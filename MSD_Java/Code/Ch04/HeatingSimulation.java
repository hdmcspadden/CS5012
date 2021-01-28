import java.text.DecimalFormat;

/**
 * The program that runs the heating simulation.  The heating
 * system modeled by this program consists of a single room heated
 * by one furnace which is controlled by a single thermostat.
 */
public class HeatingSimulation {

    // The simulation will always advance time in 60 second units
    private static final int SECS_BETWEEN_EVENTS = 60;

    // An array will be used to store the simulation parameters.  This
    // will make it easier to write the code that parses the command
    // line and sets these parameters.  The constants below identify
    // the parameter that is stored in the corresponding position in
    // the array
    
    // Inside temperature
    private static final int INSIDE_TEMP = 0;     
    // Outside temperature    
    private static final int OUTSIDE_TEMP = 1;    
    // Desired temperature    
    private static final int DESIRED_TEMP = 2;     
    // Furnace capacity   
    private static final int FURNACE_CAPACITY = 3;  
    // Furnace efficiency  
    private static final int FURNACE_EFFICIENCY = 4; 
    // Room size (sq ft) 
    private static final int ROOM_SIZE = 5;     
    // Display freq (mins)      
    private static final int DISPLAY_FREQ = 6;     
    // Time to run (mins)   
    private static final int SIM_LENGTH = 7;          

    // The array to hold the values of the parameters.  The initializer
    // is used to set the default value for each parameter.
    private static double simParams[] = { 
                                        72.0,   // Inside temperature
					          50.0,   // Outside temperature
					          72.0,   // Desired temperature
					          50000.0,// Furnace capacity
					          .90,    // Furnace efficiency
					          250.0,  // Room size
					          5.0,    // Ticks between output
					          7200.0  // Time to run (secss)
    };

    // This arrays holds the names of the parameters will be used on
    // the command line.  Each name is stored in the same position as
    // the corresponding value in the simParams[] array.
    private static String simNames[] = {"in",   // Inside temperature
					          "out",  // Outside temperature
					          "set",  // Desired temperature
					          "cap",  // Furnace capacity
					          "eff",  // Furnace efficiency
					          "size", // Room size
					          "freq", // Display frequency
					          "length"// Time to run
    };

    public static void main( String args[] ) {
        // Format used to print report
    	  DecimalFormat fmt = new DecimalFormat( "###0.00" );
    
    	  // The references to the objects that make up the simulation.
    	  // In this simulation there is one room controlled by one
    	  // thermostat and heated by one furnace.
    	  GasFurnace theFurnace = null;
    	  Environment theWorld = null;
    	  Room theRoom = null;
    	  Thermostat theThermostat = null;
    
    	  // Process the command line arguments
    	  processCommandLine( args );

    	  // Create a furnance, a room, a thermostat, and an environment.
    	  theFurnace = new GasFurnace( simParams[ FURNACE_CAPACITY ],
    				             simParams[ FURNACE_EFFICIENCY ] );
    
    	  theWorld = new Environment( simParams[ OUTSIDE_TEMP ] );
    
    	  theRoom = new Room( theWorld, theFurnace, 
                            simParams[ ROOM_SIZE ],
    			          simParams[ INSIDE_TEMP ] );
    
    	  theThermostat = new Thermostat( theRoom, theFurnace, 
    					          simParams[ DESIRED_TEMP ] );
    
    	  // Create the clock that will drive the simulation and register
    	  // the room and the thermostat with the clock so that they
    	  // will be notified when events occur within the simulation
    	  Clock masterClock = new Clock( SECS_BETWEEN_EVENTS );
    	  masterClock.add( theRoom );
    	  masterClock.add( theThermostat );

    	  // Turn on the pilot light so the furnace will produce heat
    	  theFurnace.setPilot( true );
    
    	  // Print out the objects that were created
    	  System.out.println( "Created 4 Objects:" );
    	  System.out.println( "  " + theFurnace );
    	  System.out.println( "  " + theWorld );
    	  System.out.println( "  " + theRoom );
    	  System.out.println( "  " + theThermostat );
    	  System.out.println();
    
    	  // Run the simulation for the requested time period.  When
    	  // displayFrequency seconds of simulated time have passed, the
    	  // current state of the objects within the simulation will be
        // displayed
    	  System.out.println( "Starting simulation:  " +
    			          " display frequency=" + 
                            simParams[ DISPLAY_FREQ ] +
    			          " runtime(sec.)= " + 
                            simParams[ SIM_LENGTH ] + "\n" );
    
    	  System.out.println("Time\tInside\tOutside\tDesired\tFurnace" );
    	  System.out.println("----\t------\t-------\t-------\t-------" );

    	  for ( int simTime = 0; simTime <= (int)simParams[ SIM_LENGTH ]; 
    	        simTime = simTime + (int)simParams[ DISPLAY_FREQ ] *
              SECS_BETWEEN_EVENTS) {
    
    	      // Print the statistics
    	      System.out.print( simTime + "\t" +
    			            fmt.format(theRoom.getTemperature()) +
                              "\t" +
                              fmt.format(theWorld.getTemperature()) +
                              "\t" +
    			            fmt.format(theThermostat.getSetting()) );
    
    	      if ( theFurnace.isHeating() ) {
    		    System.out.print( "\tOn" );
    	      }
    
    	      System.out.println();
    
    	      // Run the simulation for display frequencies seconds
    	      masterClock.run( (int)simParams[ DISPLAY_FREQ ] );
    	  }
    }

    /**
     * Scan the command line arguments and set any simulation
     * parameters as specified by the user.  Invalid parameters
     * settings will be ignored.
     * Note that if an invalid numeric value is specified on the
     * command line a runtime exception will be thrown and the program
     * will terminate.
     *
     * @param args the parameter settings to parse.
     */
    private static void processCommandLine( String args[] ) {
        // Step through the settings...
        for ( int i = 0; i < args.length; i++ ) {
    	      // Parameter settings take the form:  name=value
    	      int equals = args[ i ].indexOf( '=' );
    
    	      // If there is an equals sign in the setting the it might
            // be valid
    	      if ( equals != -1 ) {
                // Extract the name and the value
        	    String paramName = args[ i ].substring( 0, equals );
        	    String paramValue = args[ i ].substring( equals + 1 );
        




        	    // The index into the simParams array where the setting
        	    // is to be made. A value of -1 indicates that the name
        	    // is invalid
        	    int loc = -1;
        
        	    // Search for the name in the names array.  Since the
        	    // name is stored in the same position as the
                // corresponding value, once the location of the name
                // is determined we know where the value is stored
        	    for (int j = 0; loc == -1 && j < simNames.length; j++){
                    if ( paramName.equals( simNames[ j ] ) ) {
        		      loc = j;
        		  }
        	    }
        
        	    // If the name is valid set the parameter.  Note that
        	    // an invalid value entered on the command line will
        	    // cause a runtime exception and terminate the program.
        	    if ( loc != -1 && paramValue.length() > 0 ) {
        	        simParams[ loc ] = Double.parseDouble(paramValue);
        	    }
    	      }
    	  }
    }
}
