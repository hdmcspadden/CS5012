/**
 * An example of a recusive method
 */
public class Recursion {
	
    /** 
     * A simple recursive method.
     */
    public static int silly( int n ) {
	int a;
	int b;
	int retVal;

	if ( n <= 1 ) {
	    retVal = 1;
	} else {
	    a = silly( n / 2 );
	    b = silly( n / 2 );
	    retVal = a + b;
	}

	return retVal;
    }

    /**
     * A simple demonstration.
     */
    public static void main( String args[] ) {
	System.out.println( "silly( 6 ) = " + silly( 6 ) );
    }

} // Recursion

