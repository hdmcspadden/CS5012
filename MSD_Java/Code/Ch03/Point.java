/**
 * A Class that defines a point.
 */

public class Point {
    // Constant that gives the maximum value that may
    // be assigned to either the x or y coordinates
    public final static int MAX_VALUE = 1024;

    // The maximum number of points created so far
    private static int numPoints = 0;

    // State of a Point
    private int xCoordinate;  // The x coordinate
    private int yCoordinate;  // The y coordinate

    /**
     * Return the nujmber of Point objects that have been created
     * thus far.
     *
     * @param the number of point objects that have been created.
     */

    public static int getNumPoints() {
	return numPoints;
    }

    /**
     * Create a new point at the specified location.
     *
     * @param x the X coordinate.
     * @param y the Y coordinate.
     */
    public Point( int x, int y ) {
        setXY( x, y );
	numPoints = numPoints + 1;
    }

    /**
     * Create a new point at(value,value).
     *
     * @param value the value to set the X and Y coordinates to.
     */
    public Point( int value ) {
	setXY( value );
	numPoints = numPoints + 1;
    }

    /**
     * Create a duplicate point object.
     *
     * @param p the point to duplicate.
     */

    public Point( Point p ) {
	xCoordinate = p.xCoordinate;
	yCoordinate = p.yCoordinate;

	numPoints = numPoints + 1;
    }

    /**
     * Return the x coordinate of this point.
     * @return the x coordinate of this point.
     */
    public int getXCoordinate() {
        return xCoordinate;
    }

    /**
     * Return the y coordinate of this point.
     * @return the y coordinate of this point.
     */
    public int getYCoordinate() {
        return yCoordinate;
    }

   /**
    * Set the x coordinate of this point.
    * @param newX the new x coordinate.
    */
    public void setXCoordinate( int newX ) {
        if ( newX > MAX_VALUE ) {
            xCoordinate = MAX_VALUE;
        }
        else {
            xCoordinate = newX;
        }
    }

    /**
     * Set the y coordinate of this point.
     * @param newY the new y coordinate.
     */
    public void setYCoordinate( int newY ) {
        if ( newY > MAX_VALUE ) {
            yCoordinate = MAX_VALUE;
        }
        else {
            yCoordinate = newY;
        }
    }

    /**
     * Set both the X and Y coordinates of this point.
     * @param newX the new x coordinate.
     * @param newY the new y coordinate.
     */
    public void setXY( int newX, int newY ) {
        xCoordinate = newX;
        yCoordinate = newY;
    }

    /**
     * Set the X and Y coordinate to the same value.
     * @param value the value to set the X and Y coordinate to.
     */
    public void setXY( int value ) {
        xCoordinate = value;
        yCoordinate = value;
    }

    /**
     * Set the X and Y coordinate equal to the X and Y coordinates
     * of the point passed as a parameter.
     *
     * @param p the point used to obtain the new X and Y coordinates.
     */

    public void setXY( Point p ) {
	xCoordinate = p.getXCoordinate();
	yCoordinate = p.getYCoordinate();
    }

    /**
     * Determine the distance between this point and the origin (i.e.
     * the distance between this point and a point at location (0,0).
     *
     * @returns the ditance between this point and the origin.
     */

    public double distanceFrom() {
	return Math.sqrt( Math.pow( xCoordinate, 2 ) + 
			  Math.pow( yCoordinate, 2 ) );
    }

    public double distanceFrom( Point p ) {
	return 0;
    }

    public static void main( String args[] ) {
	Point p = new Point( 0,5);
	System.out.println( p.distanceFrom() );
	Point p2 = new Point( 1,1);
	System.out.println( p2.distanceFrom() );
    }

} // Point
