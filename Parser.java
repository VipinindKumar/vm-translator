public class Parser {
    
    public String command;
    public BufferedReader in;
    
    // Opens the file and get ready to parse it
    public Parser(inFile) {
        in = new BufferReader(new FileReader(new File(inFile)));
    }
    
    // are there more commands in the file?
    public hasMoreCommands() {
        command = in.readLine().trim().toLowerCase();
        if (command == null) {
            return false;
        }
        else {
            return true;
        }
    }
    
    // raed the next command form input
    // and makes it current command
    // called if hasMoreCommands() return true
    public advance() {
        return command;
    }
    
    /** return the type of VM command
     * 
     * C_ARITHMETIC, C_PUSH, C_POP, C_LABEL, C_GOTO,
     * C_IF, C_FUNCTION, C_RETURN, C_CALL
     * 
     **/    
    public commandType() {
        String type = command.split(" ")[0];
        
        if (type ==)
    }
    
    /** returns first argument of the command
     * 
     * if command type is C_ARITHMETIC return command itself
     * Should not be called if command is C_RETURN
     * 
     **/
    public arg1() {
        
    }
    
    /** Returns second argument of the command
     * 
     * Should be called only if current command is
     * C_PUSH, C_POP, C_FUNCTION, C_CALL
     * 
     **/
    public arg2() {
        
    }
}