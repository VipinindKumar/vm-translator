public class CodeWriter {
    
    public BufferedWriter out;
    public String file;
    public int i = 0;
    
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
        
        // same for every arithmetic command,
        // y
        // SP--
        out.write("@SP");
        out.newLine();
        out.write("M = M - 1");
        out.newLine();
        // *SP
        out.write("A = M");
        out.newLine();
        out.write("D = M");
        out.newLine();
        
        // uses two variables from stack to perform the arithmetic
        // x
        if (!(arth == "not" && arth == "neg")) {
            // SP--
            out.write("@SP");
            out.newLine();
            out.write("M = M - 1");
            out.newLine();
            // *SP
            out.write("A = M");
            out.newLine();
        }
        
        
        // different arth specific function coommands
        if (arth == "add") {
            out.write("M = D + M");
            out.newLine();
        }
        else if (arth == "sub") {
            out.write("M = M - D");
            out.newLine();
        }
        else if (arth == "and") {
            out.write("M = D & M");
            out.newLine();
        }
        else if (arth == "or") {
            out.write("M = D | M");
            out.newLine();
        }
        // these operations involve labels for if conditionals
        else if (arth == "eq" || arth == "gt" || arth == "lt") {
            // D = y - x
            out.write("D = D - M")
            out.newLine();
            // A-instruction referencing a label
            // i used to create a new Label with every new if conditional
            out.write("IF_" + Integer.toString(i));
            out.newLine();
            i++;
        }
        else if (arth == "neg") {
            
        }
        else if (arth == "not") {
            
        }
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
        // !!! LCL and like invoked in what way???
        if (!(arg1 == "constant" || arg1 == "static" || arg1 == "pointer")) {
            
            // @LCL
            out.write("@" + seg);
            out.newLine();
            // D = A
            out.write("D = M");
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
        // SP--
        // *addr = *SP 
        if (type == "C_POP") {
            //@ SP--
            out.write("@SP");
            out.newLine();
            out.write("M = M - 1");
            out.newLine();
            
            // *addr = *SP
            out.write("A = M");
            out.newLine();
            out.write("D = M");
            out.newLine();
            
            if (arg1 == "pointer") {
                if (index == "0") {
                    out.write("@THIS");
                }
                else {
                    out.write("@THAT");
                }
                out.newLine();
            }
            else if (arg1 == "static") {
                out.write("@" + file + "." + index);
                out.newLine();
            }
            else {
                out.write("@addr");
                out.newLine();
                out.write("A = M");
                out.newLine();
            }
            
            out.write("M = D");
            out.newLine();
        }
        
        
        // Push command
        // *SP = *addr
        // SP++
        else {
            //eg: A = M or @Foo.5 or @THIS
            if (arg1 == "pointer") {
                if (index == "0") {
                    out.write("@THIS");
                }
                else {
                    out.write("@THAT");
                }
                out.newLine();
            }
            else if (arg1 == "static") {
                out.write("@" + file + "." + index);
                out.newLine();
            }
            else {
                out.write("A = M");
                out.newLine();
            }
            
            // D = M
            out.write("D = M");
            out.newLine();
            
            // @SP
            out.write("@SP");
            out.newLine();
            
            // A = M
            out.write("A = M");
            out.newLine();
            
            // M = D
            out.write("M = D");
            out.newLine();
            
            // SP++
            // @SP
            out.write("@SP");
            out.newLine();
            
            // M = M + 1
            out.write("M = M + 1");
            out.newLine();
        }
    }
    
    // close the output file
    public close() {
        out.close();
    }
}