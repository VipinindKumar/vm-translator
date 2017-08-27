/** Translates VM code into Assembly code
 * 
 * Usage: java VMTranslator <file-name/path-to-directory>
 * 
 * Dependicies: Parser.java, CodeWriter.java
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
            
            // artithmetic command
            if (ctype.equals("C_ARITHMETIC")) {
                code.writeArithmetic(parser.arg1());
            }
            else if (ctype.equals("C_PUSH") || ctype.equals("C_POP")) {
                code.writePushPop(ctype, parser.arg1(), parser.arg2());
            }
        }
    }
    
    public static void main(String[] args) {
        
        File path = new File(args[0]);
        
        VMTranslator vmt = new VMTranslator();
        // create CodeWriter
        vmt.code = new CodeWriter(args[0]);
        
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