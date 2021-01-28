/**
 * A class that represents a square.  The state of a
 * square consists of the length of its side and a Point
 * object.  The Point object specifies the location of
 * the center of the square.
 */

public class Square {

    private double side;     // Length of a side
    private Point location;  // Location of the square

    /**
     * Create a new square at location (0,0).
     *
     * @param length the length of one of the sides of the square.
     */

    public Square( double length ) {
	this( new Point( 0, 0 ), length );
    }

    /**
     * Create a square at the specified location with the given length.
     *
     * @param center the location of the center of the square.
     * @param length the length of one of the sides of the square.
     */

    public Square( Point center, double length ) {
	side = length;
	location = new Point( center );
    }

    /**
     * Determine the length of one of the sides of the square.
     *
     * @return the length of one of the sides of the sqaure.
     */

    public double getLength() {
	return side;
    }

    /**
     * Determine the location of the center of the sqaure.
     *
     * @return a point that gives the location of the center of the
     *         square.
     */

    public Point getLocation() {
	return location;
    }

    /**
     * Determine the area of the square.
     *
     * @return the area of the square.
     */

    public double getArea() {
	return side * side;
    }

    /**
     * Determine the perimeter of the sqaure.
     *
     * @return the perimeter of the sqaure.
     */

    public double getPerimeter() {
	return 4 * side;
    }

    /**
     * Set the location of the center of this square to the coordinates
     * specified by the given point.
     *
     * @param p the location of the center of the square.
     */

    public void setLocation( Point p ) {
	location.setXY( p );
    }

    /**
     * Return a textual representation of a square.
     *
     * @return a string representation of a square.
     */

    public String toString() {
        return ( "Square:  length=" + side + 
                 " area=" + getArea() + 
                 " perimeter=" + getPerimeter() );
    }

    /**
     * Compare this square to another object.
     *
     * @param o the object to compare myself with.
     *
     * @return true if the objects are equal and false otherwise.
     */

    public boolean equals( Object o ) {
	boolean retVal = false;

	if ( o instanceof Square ) {
	    Square other = (Square)o;

	    retVal = getLength() == other.getLength();
	}

	return retVal;
    }

    public static void main( String args[] ) {
	Square aSquare = new Square( 10 );

	System.out.println( "Square:" );
	System.out.println( " Length == " + aSquare.getLength() );
	System.out.println( " Perimeter == " + aSquare.getPerimeter() );
	System.out.println( " Area == " + aSquare.getArea() );
    }

} // Square

