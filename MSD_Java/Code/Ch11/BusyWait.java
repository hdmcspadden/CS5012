public class BusyWait extends Thread { 
    private static int DELAY = 100000; // Number of times to execute loop 

    public void run() { 
	// Code omitted 

	// Delay execution of this thread for a few milliseconds 
	// utilizing an empty for loop 
	for ( int i = 0; i < DELAY; i++ ) { 
	    // do nothing 
	} 

	// Continue execution 

	// Code omitted 
    } 

    public static void main( String args[] ) { 
	// Create the thread and start the thread 
	new BusyWait().start(); 
    } 

} // BusyWait
