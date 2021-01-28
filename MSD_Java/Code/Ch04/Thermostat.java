/**
 * This class represents a thermostat in the home heating simulation
 * program.  The thermostat monitors a single room and turns on the
 * furnace whenever the room temperature falls below the desired 
 * setting.  The thermostat will overheat the room slightly so that
 * the furnace will not cycle on and off too quickly.
 */
public class Thermostat implements ClockListener {
    // Default overheat setting
    public static final double DEFAULT_OVERHEAT = 3.0;

    // Default temperature setting
    public static final double DEFAULT_SETTING = 72.0;

    private Room myRoom;        // The room being monitored
    private Furnace myFurnace;  // The furnace that will heat the room

    private double setting;     // The desired room temperature
    private double overHeat;    // The amount the room will be
                                // overheated

    private boolean activateFurnace;  // Used to determine if the
  // furnace should be turned on

    /**
     * Create a new thermostat with the default settings.
     *
     * @param theRoom the room that will be monitored by this
     *        thermostat.
     * @param theFurance the furnace that will add heat to the room.
     */
    public Thermostat( Room theRoom, Furnace theFurnace ) {
        this( theRoom, theFurnace, DEFAULT_SETTING, DEFAULT_OVERHEAT );
    }

    /**
     * Create a new thermostat with the default overheat amount.
     *
     * @param theRoom the room that will be monitored by this
     *        thermostat.
     * @param theFurance the furnace that will add heat to the room.
     * @param desiredTemp the desired room temperature.
     */
    public Thermostat( Room theRoom, Furnace theFurnace, 
                       double desiredTemp ) {
        this( theRoom, theFurnace, desiredTemp, DEFAULT_OVERHEAT );
    }

    /**
     * Create a new thermostat.
     *
     * @param theRoom the room that will be monitored by this
     *        thermostat.
     * @param theFurance the furnace that will add heat to the room.
     * @param desiredTemp the desired room temperature.
     * @param overheatAmount the amount that the room will be
     *        overheated.
     */
    public Thermostat( Room theRoom, Furnace theFurnace, 
		           double desiredTemp, double overheatAmount ) {
        myRoom = theRoom;
    	  myFurnace = theFurnace;
    	  setting = desiredTemp;
    	  overHeat = overheatAmount;
    }

    /**
     * Return the room being monitored by this thermostat.
     *
     * @return the room monitored by this thermostat.
     */
    public Room getRoom() {
        return myRoom;
    }

    /**
     * Return the furnace that will heat the room.
     *
     * @return the furnace that the thermostat will use to add heat to
     *         the room.
     */
    public Furnace getFurnace() {
        return myFurnace;
    }

    /**
     * Return the setting of the thermostat.
     *
     * @return the current setting of the thermostat.
     */
    public double getSetting() {
        return setting;
    }

    /**
     * Return the overheat setting for the thermostat.
     *
     * @return the overheat setting for the thermostat.
     */
    public double getOverHeat() {
        return overHeat;
    }

    /**
     * Set the desired temperature setting for the thermostat.
     *
     * @param newSetting the new temperature setting for the
     *        thermostat.
     */
    public void setSetting( double newSetting ) {
        setting = newSetting;
    }

    /**
     * Base the decision to turn on/off the furnace on the temperature
     * of the room during the past time period.
     *
     * @param interval the number of seconds that have elapsed since
     *        the last event.
     */
    public void determineStateChange( double interval ) {
        double roomTemp = myRoom.getTemperature();

    	  if ( activateFurnace ) {
    	      // If the furnace is on, leave it on until the room
            // temperature is equal to or greater than the desired
// setting plus the overheat amount
    	      activateFurnace = roomTemp < setting + overHeat;
        }
    	  else {
    	      // If the furnace is currently off, it should stay off
    	      // until the room temperature falls below the desired
            // setting.
    	      activateFurnace = roomTemp < setting;
    	  }
    }

    /**
     * This method is called before the next event occurs so that
     * the thermostat can determine whether what it should do to the
     * furnace (i.e., turn it on, turn it off, or leave it alone) based
     * on what has happened since the last event.  The thermostat
     * will not change its state when this method is called.  
     * It prepares itself for the state change that will occur when the 
     * next event occurs.
     *
     * @param interval the number of seconds that have elapsed since
     *        the last event.
     */
    public void preEvent( double interval ) {
        determineStateChange( interval );
    }

    /**
     * Turn on/off the furnace based on the temperature of the room.
     */
    public void event() {
        myFurnace.setHeating( activateFurnace );
    }

    /**
     * Return a string representation of the thermostat.
     *
     * @return a string representation of the thermostat.
     */
    public String toString() {
        return "[ Thermostat: " + " setting=" + setting +
    	         " overheat=" + overHeat + "]";
    }
}
