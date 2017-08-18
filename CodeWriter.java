public class CodeWriter {
    
    public BufferedWriter out;
    public String file;
    
    /** Open the output file, and 
     * get ready to write
     **/
    public CodeWriter(outFile) {
        out = new BufferedWriter(new FileWriter(new File(outFile)));
        if (outFile.contains(".vm") {
            outFile = outFile.split(".vm")[0];
        }
        setFileName(outFile);
    }
    
    // Informs the codeWriter that
    // the translation of a new file has started
    public setFileName(fileName) {
        file = fileName;
    }
    
    // write the assembly code for given 
    // arithmetic command
    public writeArithmetic(String arth) {
        
    }
    
    // write the translation of push/pop command
    public writePushPop(String type, String arg1, int index) {
        
        String seg;
        
        // store the appropriate segment
        // @segment
        if (arg1 == "argument") {
            seg = "ARG";
        }
        else if (arg1 == "local") {
            seg = "LCL";
        }
        else if (arg1 == "this") {
            seg = "THIS";
        }
        else if (arg1 == "that") {
            seg = "THAT";
        }
        else if (arg1 == "temp") {
            seg = "5";
        }
        
        // create assembly code for pseudocode
        // addr = LCL + i
        if (!(arg1 == "constant" || arg1 == "static" || arg1 == "pointer")) {
            
            // @LCL
            out.write("@" + seg);
            out.newLine();
            // D = A
            out.write("D = A");
            out.newLine();
            // @i
            out.write("@" + index);
            out.newLine();
            // D = D + A
            out.write("D = D + A");
            out.newLine();
            // @addr
            out.write("@addr");
            out.newLine();
            // M = D
            out.write("M = D");
            out.newLine();
        }
        
        // Pop command
        if (type == "C_POP") {
            
        }
        // Push command
        else {
            
        }
    }
    
    // close the output file
    public close() {
        out.close();
    }
}