/** 
 * Use a user thread to perform some complicated time consuming 
 * computation. The main thread will wait for the worker thread 
 * using the sleep() method.
 */ 
public class SleepingMain extends Thread { 
    private static final int DELAY = 1000; // Milliseconds to sleep 
    private static int result = 0;         // Result of computation 

    public void run() { 
	// Perform a complicated time consuming calculation 
	// and store the answer in the variable result 

	// Code omitted . . .
    } 

    /** 
     * Create and start thread to perform computation. Wait until 
     * the thread has finished before printing the result.
     * 
     * @param args command line arguments (ignored) 
     */ 
    public static void main( String args[] ) { 
	// Create and start the thread 
	Thread t = new SleepingMain(); 
	t.start();

	// Wait for thread to terminate 
	while ( t.isAlive() ) { 
	    try { 
		Thread.sleep( DELAY ); 
	    } catch ( InterruptedException e ) {} 
	} 

	// Print result 
	System.out.println( result ); 
    } 

} // SleepingMain
