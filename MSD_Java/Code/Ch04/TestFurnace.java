/**
 * Program to test the furnace class.
 */
public class TestFurnace {

    public static void main( String args[] ) {
        // First let's invoke the constructor 
    	  Furnace f1 = new Furnace( 10000.0, 0.78 );
    	  Furnace f2 = new Furnace( 30000.0, 0.85 );
    	  Furnace f3 = new Furnace( 50000.0, 0.93 );
    
    	  // Determine if the constructors worked and if the
    	  // getCapacity and getEfficiency methods work
    	  System.out.println( "f1 Capacity = " + f1.getCapacity() +
    			          " Efficiency = " + f1.getEfficiency() + 
    			          " Heating state = " + f1.isHeating() );
    
    	  System.out.println( "f2 Capacity = " + f2.getCapacity() +
    			          " Efficiency = " + f2.getEfficiency() +
    			          " Heating state = " + f2.isHeating() );
    
    	  System.out.println( "f3 Capacity = " + f3.getCapacity() +
    			          " Efficiency = " + f3.getEfficiency() +
    			          " Heating state = " + f3.isHeating() );
    
    	  // Now see if we can change the state of a Furnace
    	  f1.setHeating( true );
    	  System.out.println( "New heating state of f1 = " +
                            f1.isHeating() );
    
    	  f2.setHeating( true );
    	  System.out.println( "New heating state of f2 = " +
                            f2.isHeating() );
    
    	  f3.setHeating( true );
    	  System.out.println( "New heating state of f3 = " +
                            f3.isHeating() );
    
    	  // See if we can turn it off again
    	  f3.setHeating( false );
    	  System.out.println( "New heating state of f3 = " + 
                            f3.isHeating() );
    	
    	  // Now let's compute the output of each of these
    	  // furnaces for 1 hour, 2 hours, and 3 hours. Since
    	  // furnace F3 is off, it won't produce any heat
    	  System.out.println( f1.output( 1.0 ) );
    	  System.out.println( f1.output( 2.0 ) );
    	  System.out.println( f1.output( 3.0 ) );
    
    	  System.out.println( f2.output( 1.0 ) );
    	  System.out.println( f2.output( 2.0 ) );
    	  System.out.println( f2.output( 3.0 ) );
    
    	  System.out.println( f3.output( 1.0 ) );
    	  System.out.println( f3.output( 2.0 ) );
    	  System.out.println( f3.output( 3.0 ) );
    
    	  // Determine if toString() works as we would expected
    	  System.out.println( "Object f1 = " + f1 );
    	  System.out.println( "Object f2 = " + f2 );
    	  System.out.println( "Object f3 = " + f3 );
    
    	  System.out.println("End of unit test of Furnace");
    }
}
