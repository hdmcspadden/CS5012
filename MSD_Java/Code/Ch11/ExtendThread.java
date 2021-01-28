/** 
 * Create an additional thread in a Java program by extending 
 * the Thread class.
 */ 
public class ExtendThread extends Thread { 
    /** 
     * This code will be executed after the thread has been 
     * started. This method prints the message "I am a Thread" 
     * on standard output and then terminates.
     */ 
    public void run() { 
	System.out.println( "I am a Thread" ); 
    } 

    /** * Create an instance of this class and schedule it for 
     * execution.
     * 
     * @param args command line arguments (ignored) 
     */
    public static void main( String args[] ) { 
	// Create the thread 
	Thread theThread = new ExtendThread(); 

	// Start the thread. Note this method returns 
	// immediately. The new thread may, or may not, 
	// be executing code when it returns.
	theThread.start(); 
    } 

} // ExtendThread

