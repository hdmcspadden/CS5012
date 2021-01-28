/**
 * A test program for the environment class.
 */
public class TestEnvironment {

    public static void main( String args[] ) {
    	// First let's use both the default constructor 
    	// and the one-parameter constructor
    	Environment e1 = new Environment();
    	Environment e2 = new Environment( 85.0 );
    
    	// Determine if the constructors and 
    	// the getTemperature method works
    	System.out.println("Temperature of e1 = " + e1.getTemperature());
    	System.out.println("Temperature of e2 = " + e2.getTemperature());
    
    	// See if we can change the temperature
    	e1.setTemperature( 75.0 );
    	System.out.println( "New temperature of e1 = " +
                          e1.getTemperature() );
    
    	e2.setTemperature( 90.0 );
    	System.out.println( "New temperature of e2 = " +
                          e2.getTemperature() );
    
    	// Determine if toString() works as expected
    	System.out.println( "Object e1 = " + e1 );
    	System.out.println( "Object e2 = " + e2 );
    
    	System.out.println( "End of unit test of Environment" );
    }

}
