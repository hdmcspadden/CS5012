/**
 * The base class for shape objects.
 */

public abstract class Shape {

    private Point location;  // Location of the shape

    /**
     * Create a new shape at location (0,0).
     *
     * @param length the length of one of the sides of the square.
     */

    public Shape() {
	this( new Point( 0, 0 ) );
    }

    /**
     * Create a shape at the specified location.
     *
     * @param center the location of the center of the shape.
     */

    public Shape( Point center ) {
	location = new Point( center );
    }

    /**
     * Determine the location of the center of the shape.
     *
     * @return a point that gives the location of the center of the
     *         shape.
     */

    public Point getLocation() {
	return location;
    }

    /**
     * Set the location of the center of this shape to the coordinates
     * specified by the given point.
     *
     * @param p the location of the center of the shape.
     */

    public void setLocation( Point p ) {
	location.setXY( p );
    }

    /**
     * Return the area of this shape.
     *
     * @return the area of this shape.
     */

    public abstract double getArea();

    /**
     * Return the perimeter of this shape.
     *
     * @return the perimeter of this shape.
     */

    public abstract double getPerimeter();

} // Shape

