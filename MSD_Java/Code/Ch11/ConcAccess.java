/** 
* Add three to a variable in a strange way.
*/ 
public class ConcAccess extends Thread {
    private static final int NUM_THREADS = 3; 
    private static int common = 0; 

    /** 
     * Obtain a local copy of common, increment the copy by one 
     * and store the result back in common.
     */ 
    public void run() { 
	int local = 0; // Local storage 
	
	// Add one to common 
	local = common; 
	local = local + 1; 
	common = local; 
    } 

    /** 
     * Create and start three threads that will each add one to 
     * common. Print common when all threads have died.
     * 
     * @param args command line arguments (ignored).
     */ 
    public static void main( String args[] ) { 
	// Holds the references to the threads that 
	// are created so that main can join with them 
	Thread myThreads[] = new Thread[ NUM_THREADS ]; 

	// Create and start the threads 
	for ( int i = 0; i < NUM_THREADS; i++ ) { 
	    myThreads[ i ] = new ConcAccess(); myThreads[ i ].start(); 
	} 

	// Join with each thread 
	for ( int i = 0; i < NUM_THREADS; i++ ) { 
	    try { 
		myThreads[ i ].join(); 
	    } 
	    catch ( InterruptedException e ) {} 
	} 

	// Threads have terminated - print the result 
	System.out.println( "Common is: " + common ); 
    } 

} // ConcAccess
