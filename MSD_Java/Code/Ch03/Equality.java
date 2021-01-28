/**
 * Test the results of applying the equality operator (==)
 * to different points.
 */

public class Equality {

    /**
     * The main method.
     *
     * @param args command line arguments (ignored).
     */
    public static void main( String args[] ) {
	// Create some points
	Point p1 = new Point( 12, 34 );
	Point p2 = new Point( 56, 78 );
	Point p3 = p1;
	Point p4 = new Point( 12, 34 );

	// Apply equality to the points
	System.out.println( p1 == p2 ); // False two different points
	System.out.println( p1 == p3 ); // True both refer to the same object
	System.out.println( p1 == p4 ); // False even though the state of
	                                // the two objects is the same
    }

} // Equality
