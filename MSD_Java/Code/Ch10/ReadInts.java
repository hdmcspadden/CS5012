import java.util.*;

/**
 * Demonstrate the hasNext and next methods of the scanner class.
 */
public class ReadInts {
    public static void main( String args[] ) {
	Scanner in = new Scanner( System.in );

	// Read until nothing is left
	while ( in.hasNext() ) {
	    if ( in.hasNextInt() ) {
		System.out.println( "int: " + in.nextInt() );
	    }
	    else if ( in.hasNextDouble() ) {
		System.out.println( "double: " + in.nextDouble() );
	    }
	    else if ( in.hasNextBoolean() ) {
		System.out.println( "boolean: " + in.nextBoolean() );
	    }
	    else {
		System.out.println( "unknown: " + in.next() );
	    }
	}

	in.close();
    }

} // ReadInts
