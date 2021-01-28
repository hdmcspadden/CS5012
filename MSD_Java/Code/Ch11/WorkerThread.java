/** 
 * Use a user thread to perform some complicated time consuming 
 * computation.
 */ 
public class WorkerThread extends Thread { 
    private static int result = 0; // Result of computation 

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
    public static void main(String args[]) { 
	// Create and start the thread 
	Thread t = new WorkerThread(); 
	t.start(); 

	// Wait for thread to terminate 
	while ( t.isAlive() ); 

	// Print result 
	System.out.println( result ); 
    } 

} // WorkerThread
