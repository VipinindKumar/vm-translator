public class CodeWriter {
    
    public BufferedWriter out;
    
    /** Open the output file, and 
     * get ready to write
     **/
    public CodeWriter(outFile) {
        out = new BufferedWriter(new FileWriter(new File(outFile)));
    }
    
    // Informs the codeWriter that
    // the translation of a new file has started
    public setFileName(fileName) {
        
    }
    
    // write the assembly code for given 
    // arithmetic command
    public writeArithmetic(String arth) {
        
    }
    
    // write the translation of push/pop command
    public writePushPop(String type, String arg1, int index) {
        
    }
    
    // close the output file
    public close() {
        out.close();
    }
}