/**
 * A Simple program to demonstrate parameter passing in Java.
 */
public class Param {
    /**
     * Create and initialize a Point and an int value.  Print the
     * values of these variables before and afcter invoking the
     * method aMethod().
     *
     * @param args command line arguments (ignored).
     */
    public static void main( String args[] ) {
	int x = 16;
	int y = 67;
	Point aPoint = new Point( 0, 0 );

	// Before...
	System.out.println( "x=" + x );
	System.out.println( "y=" + y );
	System.out.println( "aPoint=" + pointToString( aPoint ) );

	move( aPoint, x, y );

	// After...
	System.out.println( "x=" + x );
	System.out.println( "y=" + y );
	System.out.println( "aPoint=" + pointToString( aPoint ) );
    }

    /**
     * Move a point
     *
     * @param p the point to move
     * @param deltaX amount to move the x-coordinate
     * @param deltaY amount to move the y-coordinate
     */
    public static void move( Point p, int deltaX, int deltaY ) {
	p.setXCoordinate( p.getXCoordinate() + deltaX );
	p.setYCoordinate( p.getYCoordinate() + deltaY );
    }

    /**
     * Convert the given point to string form suitable for
     * printing
     *
     * @param p the point to convert to a string.
     */
    public static String pointToString( Point p ) {
	return "(" + p.getXCoordinate() + "," + p.getYCoordinate() + ")";
    }

} // Param
