/** Translates VM code into Assembly code
 * 
 * Usage: java VMTranslator <file-name/path-to-directory>
 * 
 * Dependencies: Parser.java, CodeWriter.java
 * 
 * - Constructs a Parser from input file
 * - Construct a CodeWriter to generate code in output file
 * - Read VM commands and generate corresponding Assembly code
 * 
 **/
import java.io.*;

public class VMTranslator {
    
    public Parser parser;
    public CodeWriter code;
    
    // take a filename, create parser and
    // translate each vm commands in file 
    private void parse(File in) {
        // construct a parser with the file
        parser = new Parser(in);
        
        // iterate through each command
        while (parser.hasMoreCommands()) {
            String command = parser.advance();
            
            String ctype = parser.commandType();
            
            // Arithmetic command
            if (ctype.equals("C_ARITHMETIC")) {
                code.writeArithmetic(parser.arg1());
            }
            // Push/Pop command
            else if (ctype.equals("C_PUSH") || ctype.equals("C_POP")) {
                code.writePushPop(ctype, parser.arg1(), parser.arg2());
            }
            // Label command
            else if (ctype.equals("C_LABEL")) {
                code.writeLabel(parser.arg1());
            }
            // goto command
            else if (ctype.equals("C_GOTO")) {
                code.writeGoto(parser.arg1());
            }
            // if-goto command
            else if (ctype.equals("C_IF")) {
                code.writeIf(parser.arg1());
            }
            // call command
            else if (ctype.equals("C_CALL")) {
                code.writeCall(parser.arg1(), parser.arg2());
            }
            // function command
            else if (ctype.equals("C_FUNCTION")) {
                code.writeFunction(parser.arg1(), parser.arg2());
            }
            // return command
            else if (ctype.equals("C_RETURN")) {
                code.writeReturn();
            }
        }
    }
    
    public static void main(String[] args) {
        
        File path = new File(args[0]);
        
        VMTranslator vmt = new VMTranslator();
        
        // argument could be a file or directory containing multiple files
        File[] files = path.listFiles();
        // if path is a directory
        if (files != null) {
            // create CodeWriter
            vmt.code = new CodeWriter(args[0], true);
            
            for (File file : files) {
              vmt.parse(file);
            }
        }
        // single file
        else {
            // create CodeWriter
            vmt.code = new CodeWriter(args[0], false);
            
            vmt.parse(path);
        }
        
        vmt.code.close();
    }
}