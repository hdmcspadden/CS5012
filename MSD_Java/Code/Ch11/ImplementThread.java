/** 
 * Illustrate how to create an additional thread in a Java 
 * program by implementing the Runnable interface.
 */ 
public class ImplementRunnable implements Runnable { 
    /** 
     * This code will be executed after the thread has been 
     * started. This method prints the message "I am a Thread" 
     * on standard output and then terminates.
     */ 
    public void run() { 
	System.out.println( "I am a Thread" ); 
    }

    /** 
     * Create an instance of this class and a thread to run it.
     * Then start the thread so that the run() method executes.
     * 
     * @param args command line arguments (ignored) 
     */ 
    public static void main( String args[] ) { 
	// Create the object that contains the run() method 
	Runnable runnableObject = new ImplementRunnable(); 

	// Create the thread and tell it about the runnable object.
	Thread theThread = new Thread( runnableObject ); 

	// Start the thread.
	theThread.start(); 
    } 

} // ImplementRunnable

