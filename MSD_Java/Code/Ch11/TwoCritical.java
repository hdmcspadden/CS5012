/** 
 * A program with two critical sections.
 */ 
public class TwoCritical extends Thread { 
    private static final int NUM_THREADS = 3; 
    private static int common = 0, other = 0;

    /** 
     * Increment both common and other by one 
     */ 
    public void run() { 
	int local = 0; // Local storage 

	// Add one to common 
	local = common; 
	local = local + 1; 
	common = local; 

	// Add one to other 
	local = other; 
	local = local + 1; 
	other = local; 
    } 

    /** 
     * Create and start three threads.
     * 
     * @param args command line arguments (ignored).
     */ 
    public static void main( String args[] ) { 
	// References to the threads 
	Thread myThreads[] = new Thread[ NUM_THREADS ]; 

	// Create and start the threads 
	for ( int i = 0; i < NUM_THREADS; i++ ) { 
	    myThreads[ i ] = new ConcAccess(); 
	    myThreads[ i ].start(); 
	} 

	// Join with each thread 
	for ( int i = 0; i < NUM_THREADS; i++ ) { 
	    try { 
		myThreads[ i ].join(); 
	    } 
	    catch ( InterruptedException e ) {} 
	} 

	// Threads have terminated - print the result 
	System.out.println( "Common: " + common + "Other: " + other ); 
    } 

} // TwoCritical
