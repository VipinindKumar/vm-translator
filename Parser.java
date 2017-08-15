public class Parser {
    
    
    // Opens the file and get ready to parse it
    public Parser(inFile) {
        
    }
    
    // are there more commands in the file?
    public hasMoreCommands() {
        
    }
    
    // raed the next command form input
    // and makes it current command
    // called if hasMoreCommands() return true
    public advance() {
        
    }
    
    /** return the type of VM command
     * 
     * C_ARITHMETIC, C_PUSH, C_POP, C_LABEL, C_GOTO,
     * C_IF, C_FUNCTION, C_RETURN, C_CALL
     * 
     **/    
    public commandType() {
        
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