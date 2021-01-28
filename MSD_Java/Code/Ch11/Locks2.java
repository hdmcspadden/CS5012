/**
 * Demonstrate object locking in Java.
 */

public class Locks2 extends Thread {
    private static final int NUM_THREADS = 3;        // Num of threads
    private static final String PREFIX = "Thread #"; // For thread name
    private static final int N = 3;                  // Loop constant
    private static final int DELAY = 10;             // Sleep period

    private Object lock;  // Object used for synchronization
  
    public Locks2( String name ) { 
	// Store a reference to the lock and store the name of the thread
	lock = new Integer( 0 );
	setName( name ); 
    }
  
    public void run() {
	// Get the lock before entering the loop
	synchronized( lock ) {
	    for ( int i = 0; i < N; i++ ) {
		System.out.println( getName() + " is tired" );
		
		try {
		    Thread.currentThread().sleep( DELAY );
		} catch ( InterruptedException e ){}           

		System.out.println( getName() + " is rested" ); 
	    }
	}
    }
  
    public static void main( String args[] ) {
	// Create the threads and let them run
	for ( int i = 0; i < NUM_THREADS; i++ ) {
	    new Locks2( PREFIX + i ).start(); 
	}
    }

} // Locks2

