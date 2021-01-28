/** 
 * Create five threads, each with a different name. Each thread 
 * prints its name on standard output and terminates.
 */
public class MultipleThreads extends Thread { 
    // The number of threads to create 
    public final static int NUM_THREADS = 5; 

    /** 
     * Print the name of the thread on standard output.
     */ 
    public void run() { 
	System.out.println( getName() ); 
    } 

    /** 
     * Create NUM_THREADS threads, start each thread, and terminate.
     * The name of each thread will be of the form "Thread #N" where 
     * N will be replaced by a number from 0 to NUM_THREADS - 1.
     * 
     * @param args command line arguments (ignored) 
     */ 
    public static void main( String args[] ) { 
	Thread newThread = null;  // Reference to new thread 
	String name = "Thread #"; // Prefix for all thread names 

	// Create the threads 
	for ( int i = 0; i < NUM_THREADS; i++ ) { 
	    // Create a thread 
	    newThread = new MultipleThreads(); 

	    // Set the name 
	    newThread.setName( name + i ); 

	    // The name can also be specified in the constructor: 
	    // 
	    // newThread = new MultipleThread( name + i ) 

	    // Start the thread 
	    newThread.start(); 
	} 
    } 
} // MultipleThreads

