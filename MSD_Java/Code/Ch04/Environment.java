/**
 * This class represents the external environment that a room
 * is contained in.  The primary role of this class is to maintain
 * the outside temperature.  We will be using a fixed outdoor
 * temperature, but it could be modified to cvary according to
 * some enironmental rules.
 */
public class Environment {
    // Initial temperature.  Used by the dafulat constructor.
    public static final double DEFAULT_TEMPERATURE = 72.;

    // The current temperature in this environment
    private double temperature;

    /**
     * Create a new environment using the deafault temperature.
     */
    public Environment() {
        this( DEFAULT_TEMPERATURE );
    }

    /**
     * Create a new environment with the specified temperature.
     *
     * @param initialTemp initial temperature of the environment.
     */
    public Environment( double initialTemp ) {
        temperature = initialTemp;
    }

    /**
     * Return the environment's current temperature.
     *
     * @return the current temperature.
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Set the temperature of the environment.
     * 
     * @param newTemp temperature to set the environment to.
     */
    public void setTemperature( double newTemp ) {
        temperature = newTemp;
    }

    /**
     * Return a string representation of the environment.
     *
     * @return a string representation of the environment.
     */
    public String toString() {
        return "[ Environment: " +
	         " temperature=" + temperature +
	         " ]";
    }
}
