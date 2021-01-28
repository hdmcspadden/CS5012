/**
 * A furnace in the home heating simulation.  When on a furance
 * will produce a certain number of BTUs/hour of heat.  The furance
 * has a capacity which gives the maxmimum number of BTUs it can 
 * generate and an efficiency which determines what percentage of the 
 * furnace's capacity is actually generated as output.
 */
public class Furnace {
    private double capacity;    // Capacity of the furnace in BTUs/hour
    private double efficiency;  // The efficiency of the furnace
    private boolean heating;    // Is the furnace producing heat?

    /**
     * Create a new furnace.
     *
     * @param cap the capacity of the furance in BTUs/hr
     * @param eff the efficiency of the furnace
     */
    public Furnace( double cap, double eff ) {
        // Store the state of the furnace
    	capacity = cap;
    	efficiency = eff;
    
    	// Make sure the furnace is off
    	heating = false;
    }

    /**
     * Turn the furnace on (i.e., it will produce heat) or off.
     *
     * @param onOff if true the furnace will produce heat.
     */
    public void setHeating( boolean onOff ) {
        heating = onOff;
    }

    /**
     * Return the capacity of this furnace.
     *
     * @return the capacity of the furance.
     */
    public double getCapacity() {
        return capacity;
    }

    /**
     * Return the efficiency of this furnace.
     *
     * @return the efficiency of this furnace.
     */
    public double getEfficiency() {
        return efficiency;
    }

    /**
     * Return the state of the furnace.
     *
     * @return true if the furnace is producing heat.
     */
    public boolean isHeating() {
        return heating;
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
    
    	  if ( heating ) {
    	      btusGenerated = capacity * efficiency * hours;
    	  }
    
        return btusGenerated;
    }

    /**
     * Return a string representation of this furnace.
     *
     * @return a string reprsentation of this furnace.
     */
    public String toString() {
        return "[ Furnace:" + " cap=" + capacity + 
    	         " eff=" + efficiency + " heating=" + 
               heating + " ]";
    }
}
