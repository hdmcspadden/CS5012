/**
 * The master clock for the home heating simulation.  Generates tick
 * events for ClockListeners that have been registered with the
 * clock.  The interval between ticks is determined at the time the
 * clock is constructed.
 */
public class Clock {

    // Number of seconds in one minute
    public static final int SECS_PER_MINUTE = 60;

    // Number of seconds in one hour
    public static final int SECS_PER_HOUR = SECS_PER_MINUTE * 60;

    // Initial size of the array that holds the listeners
    private static final int INITIAL_SIZE = 10;

    // Objects to be notified when tick events occur
    private ClockListener listeners[];

    // The number of listeners registered with this clock
    private int numListeners;

    // The number of seconds that pass between ticks
    private int secsPerTick;

    /**
     * Create a new clock that will generate tick events at
     * the specified interval.
     *
     * @param tickInterval the number of seconds between ticks.
     */
    public Clock( int tickInterval ) {
        // Setup the array that will hold the listeners
        listeners = new ClockListener[ INITIAL_SIZE ];
    	  numListeners = 0;
    
    	  // The time interval for this clock
    	  secsPerTick = tickInterval;
    }

    /**
     * Run the clock for the specified number of ticks.  The state of
     * the clock is valid between invocations of run().  This makes it 
     * possible to call run multiple times within the simulation.
     *
     * @param numTicks the number of ticks to generate
     */
    public void run( int numTicks ) {
        for ( int i = 0; i < numTicks; i++ ) {
    
    	      // Notify the listeners that an event is about to happen
    	      for ( int j = 0; j < numListeners; j++ ) {
    	          listeners[ j ].preEvent( secsPerTick );
    	      }
    
    	      // The event occurs
    	      for ( int j = 0; j < numListeners; j++ ) {
    	          listeners[ j ].event();
    	      }
    	  }
    }

    /**
     * Add a listener to the collection of objects that are
     * notified when tick events occur.
     *
     * @param entity the listener to add to the collection
     */
    public void add( ClockListener entity ) {
        // Resize the array if it is full.  A new array will be created
    	  // with twice the capacity and the contents of the old array
    	  // will be copied into the new array.
    	  if ( numListeners == listeners.length ) {
    
    	      // Create a new array that is twice as large
    	      ClockListener newListeners[] = 
    		new ClockListener[ listeners.length * 2 ];
    	    
    	      // Copy the old array into the new array
    	      for ( int i = 0; i < listeners.length; i++ ) {
    	          newListeners[ i ] = listeners[ i ];
    	      }
    
    	      // Make the class use the new array to keep track of the
    	      // listeners
    	      listeners = newListeners;
        }

    	  // Add the listener to the array
    	  listeners[ numListeners ] = entity;
    	  numListeners = numListeners + 1;
    }
}
