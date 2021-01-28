/**
 * An interface for shape objects.
 */

public interface ShapeI {

    /**
     * Determine the location of the center of the shape.
     *
     * @return a point that gives the location of the center of the
     *         shape.
     */

    public Point getLocation();

    /**
     * Set the location of the center of this shape to the coordinates
     * specified by the given point.
     *
     * @param p the location of the center of the shape.
     */

    public void setLocation( Point p );

    /**
     * Return the area of this shape.
     *
     * @return the area of this shape.
     */

    public double getArea();

    /**
     * Return the perimeter of this shape.
     *
     * @return the perimeter of this shape.
     */

    public double getPerimeter();

} // Shape

