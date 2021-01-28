/**
 * This program creates several points at different
 * locations.
 */

public class CreatePoints {

    /**
     * The main method.
     *
     * @param args command line arguments (ignored).
     */

    public static void main( String args[] ) {
	Point p1, p2, p3;

	p1 = new Point( 10, 45 );  // Create a point at (10,45)
	p2 = new Point( 10, 10 );  // Create a point at (10,10)
	p3 = new Point( 10, 10 );  // Create a point at (10,10)

	// Place p1 at the origin
	p1.setXY( 0 );
	
	// Locate p2 at the same locations as p1
	p2.setXCoordinate( p1.getXCoordinate() );
	p2.setYCoordinate( p1.getYCoordinate() );
	
	// Place p3 10 units away from p2 in each dimension
	p3.setXCoordinate( p2.getXCoordinate() + 10 );
	p3.setYCoordinate( p2.getYCoordinate() + 10 );

	// Print the results
	
	System.out.println( "p1 --> " + pointToString( p1 ) );
	System.out.println( "p2 --> " + pointToString( p2 ) );
	System.out.println( "p3 --> " + pointToString( p3 ) );
    }

    /**
     * Convert the given point to string form suitable for
     * printing.
     *
     * @param p the point to convert to a string.
     */

    public static String pointToString( Point p ) {
	return "(" + p.getXCoordinate() + "," + p.getYCoordinate() + ")";
    }

}  // CreatePoints
