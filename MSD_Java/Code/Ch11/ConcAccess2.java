public class ConcAccess extends Thread { 
    private static final int NUM_THREADS = 3; 
    private static int common = 0;

    private static final Integer lock = new Integer( 0 );

    public void run() { 
	int local = 0; // Local storage

	// Add one to common
	synchronized( lock ) {
	    local = common; 
	    local = local + 1; 
	    common = local;
	}

    } 

    // Rest of program omitted.

} // ConcAccess2
