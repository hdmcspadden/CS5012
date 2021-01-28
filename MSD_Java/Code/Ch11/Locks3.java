/**
 * Use a static lock for synchrnozation
 */
public class Locks3 extends Thread {
    private static final int NUM_THREADS = 3;        // Num of threads
    private static final String PREFIX = "Thread #"; // For thread name
    private static final int N = 3;                  // Loop constant
    private static final int DELAY = 10;             // Sleep period

  // Object used for synchronization
  private static Object lock = new Integer( 0 );
  
  public Locks3( String name ) { 
    // Store the name of the thread
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

        System.out.println( getName() + " is rested" ); }
      }
  }
  
  public static void main( String args[] ) {

    // Create the threads and let them run
    for ( int i = 0; i < NUM_THREADS; i++ ) {
      new Locks3( PREFIX + i ).start(); 
    }
  }

} // Locks3

