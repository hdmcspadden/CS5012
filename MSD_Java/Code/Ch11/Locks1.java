/** 
 * Demonstrate object locking in Java.
 */ 
public class Locks1 extends Thread { 
    private static final int NUM_THREADS = 3;       // Num of threads
    private static final String PREFIX = "Thread #"; // For thread name 
    private static final int N = 3;                  // Loop constant 
    private static final int DELAY = 10;             // Sleep period 

    private Object lock; // Object used for synchronization 

    public Locks1( Object l, String name ) { 
	// Store a reference to the lock and store name of the thread 
	lock = l; 
	setName( name ); 
    } 

    public void run() {
	// Get the lock before entering the loop 
	synchronized( lock ) { 
	    for ( int i = 0; i < N; i++ ) { 
		System.out.println( getName() + " is tired" ); 

		try { 
		    Thread.currentThread().sleep( DELAY ); 
		} 
		catch ( InterruptedException e ){} 

		System.out.println( getName() + " is rested" ); 
	    } 
	} 
    } 

    public static void main( String args[] ) { 
	// Create the object that will be used as the lock 
	Integer lock = new Integer( 0 ); 

	// Create the threads and let them run 
	for ( int i = 0; i < NUM_THREADS; i++ ) { 
	    new Locks1( lock, PREFIX + i ).start(); 
	} 
    } 

} // Locks1
