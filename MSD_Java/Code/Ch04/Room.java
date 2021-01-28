/**
 * A room in the heating simulation.
 */
public class Room implements ClockListener {
    /**
     * The specific heat capacity (SHC) gives the amount of heat
     * stored in the room.  The SHC for a typical tract house in the
     * United States is 4 BTUs per square foot per degree Fahrenheit.
     */
    public static final double DEFAULT_SHC = 4.0;

    /**
     * The Basic Load constant (BLC) gives the resistance of heat flow
     * out of the room.  A large BLC value is indicative of a room
     * that loses heat very easily.
     */
    public static final double DEFAULT_BLC = 1.0;
    public static final double MINIMUM_BLC = 1.0;
    public static final double MAXIMUM_BLC = 10.0;

    // State of the room
    private Environment outside;  // The outside world
    private Furnace myFurnace;    // The furnace heating this room

    private double shc;           // The SHC for this room
    private double blc;           // The BLC for this room
    private double floorArea;     // The floor area of this room
    private double temperature;   // The current room temperature

    private double deltaTemp;     // The change in room temperature 	
					    // during the past time interval

    /**
     * Create a new room.  The SHC and BLC for the room will be set
     * to the default values.
     *
     * @param theWorld the environment that the room will get the
     *   	  outside temperature from.
     * @param heatSource the furnace providing heat to the room.
     * @param area the floor area of the room in square feet.
     * @param initialTemperature the initial temperature of the room in
     *        degrees Fahrenheit.
     */
    public Room( Environment theWorld, Furnace heatSource,
                 double area, double initialTemperature ) {
        
        this( theWorld, heatSource, DEFAULT_SHC,
	        DEFAULT_BLC, area, initialTemperature );
    }

    /**
     * Create a new room.  The SHC and BLC for the room will be set
     * to the default values.  The initial temperature of the room will
     * be set to the current outside temperature.
     *
     * @param theWorld the environment that the room will get the
     *        outside temperature from.
     * @param heatSource the furnace providing heat to the room.
     * @param area the floor area of the room in square feet.
     */
    public Room( Environment theWorld, Furnace heatSource, 
		     double area ) {

        this( theWorld, heatSource, DEFAULT_SHC,
	        DEFAULT_BLC, area,
	        theWorld.getTemperature() ); // outside temperature
    }

    /**
     * Create a new room.
     *
     * @param theWorld the environment that the room will get the
     *        outside temperature from.
     * @param heatSource the furnace providing heat to the room.
     * @param specificHeatCapacity the SHC for this room.
     * @param basicLoadConstant the BLC for this room.  If the value of 
     *        this parameter falls outside the valid range for the BLC,
     *        the default BLC value will be used.
     * @param area the floor area of the room in square feet.
     * @param initialTemperature the initial temperature of the room in
     *        degrees Fahrenheit.
     */
    public Room( Environment theWorld, Furnace heatSource,
                 double specificHeatCapacity, double basicLoadConstant,
                 double area, double initialTemperature ) {

        // Initialize the state of the room
    	  outside = theWorld;
    	  myFurnace = heatSource;
    	  shc = specificHeatCapacity;
    	  floorArea = area;
    	  temperature = initialTemperature;

    	  // Make sure the requested BLC is in range
    	  if ( basicLoadConstant < MINIMUM_BLC || 
    	       basicLoadConstant > MAXIMUM_BLC ) {
            blc = DEFAULT_BLC;
    	  }
        else {
    	      blc = basicLoadConstant;
    	  }
    }

    /**
     * Return the environment in which this room is located.
     *
     * @return the environment the room is located in.
     */
    public Environment getEnvironment() {
        return outside;
    }

    /**
     * Return the primary heat source for this room.
     *
     * @return the furnace heating this room.
     */
    public Furnace getFurnace() {
        return myFurnace;
    }

    /**
     * Return the specific heat capacity for this room.
     *
     * @return the SHC for this room.
     */
    public double getSHC() {
        return shc;
    }

    /**
     * Return the basic load constant for this room.
     *
     * @return the BLC for this room.
     */
    public double getBLC() {
        return blc;
    }

    /**
     * Return the floor area of this room.
     *
     * @return the floor area of this room.
     */
    public double getFloorArea() {
        return floorArea;
    }

    /**
     * Return the current temperature of this room.
     *
     * @return the current temperature of the room.
     */
    public double getTemperature(){
        return temperature;
    }

    /**
     * This method will compute the change in room temperature
     * since the last event.
     *
     * Heat into the room comes from the furnace:
     *   Qin = FurnaceOutputBTUsPerHr * timeHours
     *
     * Heat loss is calculated as follows:
     *   Qloss = BLC * FloorArea * ( InsideTemp - OutsideTemp ) *
     *           timeHours
     *
     * The Basic Load Constant (BLC) gives the resistance to heat flow
     * out of the room.  The BLC can range from 1 to 10. A large BLC
     * value is indicative of a room that loses heat very quickly
     * (like a car).
     *
     * The change in room temperature during the past interval is given
     * by the formula:
     *   deltaTemp = ( Qin - Qloss ) / ( SHC * floorArea )
     *
     * SHC stands for specific heat capacity of the room and gives
     * the amount of heat that is stored in the room itself (i.e.,
     * in the walls, floors, etc.).  The SHC for a typical tract house
     * in the US is 4 BTUs per square foot per degree Fahrenheit.
     *
     * @param interval the number of seconds of elapsed time.
     */
    public void determineTemperatureChange( double interval ) {
        // The number of hours that have passed since the last event
    	  double elapsedTimeInHours = interval / Clock.SECS_PER_HOUR;
    
        // Only heat into the room comes from the furnace
    	  double qIn = myFurnace.output( elapsedTimeInHours );
    
    	  // Compute the heat that has left the room
    	  double qLoss = blc * floorArea * 
    	                 ( temperature - outside.getTemperature() )  *
    	                 elapsedTimeInHours;
    
    	  // Compute the change in temperature
    	  deltaTemp = ( qIn - qLoss ) / ( shc * floorArea );
    }

    /**
     * This method is called before the next event occurs so that
     * can determine the temperature change that has occurred
     * since the last event.  The room will not change its state when 
     * this method is called.  It prepares itself for the state change
     * that will occur when the next event occurs.
     *
     * @param interval the number of seconds that have elapsed since
     *        the last event.
     */
    public void preEvent( double interval ) {
        // Determine the change in room temperature
        determineTemperatureChange( interval );
    }

    /**
     * The room will update its current temperature when
     * this method is called.
     */
    public void event() {
        // Adjust the room temperature
        temperature = temperature + deltaTemp;
    }

    /**
     * Return a string representation of the room.
     *
     * @return a string representation of the room.
     */
    public String toString() {
        return "[ Room: " + " temp=" + temperature +
	         " area=" + floorArea + " SHC=" + shc +
	         " BLC=" + blc + " ]";
    }
}
