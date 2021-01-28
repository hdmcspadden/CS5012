/*
 * A gas furance.  A gas furance has a pilot light which must be on
 * in order for the furnace to produce heat.
 */
public class GasFurnace extends Furnace {
    private boolean pilotLight;// State of the pilot light

    /**
     * Create a new furnace.
     *
     * @param cap the capacity of the furance in BTUs/hr
     * @param eff the efficiency of the furnace
     */
    public GasFurnace( double cap, double eff ) {
        super( cap, eff );
    
    	  // Pilot light is off
    	  pilotLight = false;
    }

    /**
     * Turn the pilot light on.
     *
     * @param onOff if true the pilot light is on.
     */
    public void setPilot( boolean onOff ) {
        pilotLight = onOff;
    }

    /**
     * Return the state of the pilot light.
     *
     * @return true if the pilot light is on.
     */
    public boolean isPilotOn() {
        return pilotLight;
    }

    /**
     * Return the number of BTUs produced by the furnace during the
     * specified period of time.
     *
     * @param hours number of hours the furnance has been on.
     * @return the number of BTUs produced by the furnace during
     *         the specified time period.
     */
    public double output( double hours ) {
        double btusGenerated = 0.0;

        if ( pilotLight ) {
            btusGenerated = super.output( hours );
        }

        return btusGenerated;
    }

    /**
     * Return a string representation of this furnace.
     *
     * @return a string reprsentation of this furnace.
     */
    public String toString() {
        return "[ GasFurnace:" + " cap=" + getCapacity() + 
    	         " eff=" + getEfficiency() + " pilot on=" + 
               pilotLight + " heating=" + isHeating() + " ]";
    }
} 