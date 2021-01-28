/**
 * Static synchronized methods
 */
public class Locks5 extends Thread {
    private static final int NUM_THREADS = 3;        // Num of threads
    private static final String PREFIX = "Thread #"; // For thread name
    private static final int N = 3;                  // Loop constant
    private static final int DELAY = 10;             // Sleep period
  
    public Locks5( String name ) { 
	// Store the name of the thread
	setName( name ); 
    }
  
    public static synchronized void doIt( String name ) {
	for ( int i = 0; i < N; i++ ) {
	    
	    System.out.println( name + " is tired" );
	    
	    try {
		Thread.currentThread().sleep( DELAY );
	    } catch ( InterruptedException e ){}           
	    
	    System.out.println( name + " is rested" ); 
	}
    }
    
    public void run() {
	doIt( getName() );
    }
    
    public static void main( String args[] ) {
	// Create the threads and let them run
	for ( int i = 0; i < NUM_THREADS; i++ ) {
	    new Locks5( PREFIX + i ).start(); 
	}
    }
    
} // Locks5

