/** 
 * Once every second print the elapsed time since the program 
 * was started.
 */ 
public class Clock { 
    public static final int ONE_SECOND = 1000; // Millisecs in a second 
    public static final int SECS_PER_MIN = 60; // Seconds in a minute 
    public static final int MINS_PER_HR = 60;  // Minutes in an hour 

    /** 
     * The main program consists of an infinite loop that sleeps for 
     * one second, updates the current time, and prints the result.
     * 
     * @param args command line arguments (ignored) 
     */ 
    public static void main( String args[] ) { 
	int secs = 0, mins = 0, hrs = 0;  // Elapsed time 

	while ( true ) { 
	    // Sleep for one second 
	    try { 
		Thread.sleep( ONE_SECOND ); 
	    } 
	    catch ( InterruptedException e ) {} 

	    // Update the time 
	    secs++; 

	    if ( secs >= SECS_PER_MIN ) { 
		secs = 0; mins++; 

		if ( mins >= MINS_PER_HR ) { 
		    mins = 0; hrs++; 
		} 
	    } 

	    // Print the current time 
	    System.out.println( hrs + ":" + mins + ":" + secs ); 
	} 
    } 

} // Clock
