/**
 * A class that represents an ellipse.  The state of an
 * ellipse consists of its height, width, and a point
 * object.  The point object specifies the location of
 * the upper left hand corner of the smallest rectangle
 * that bounds the ellipse.
 */

public class Ellipse {

    private double height;
    private double width;
    private Point location;

    public Ellipse( double h, double w ) {
	this( new Point( 0, 0 ), h, w );
    }

    public Ellipse( Rectangle boundingBox ) {
	this( boundingBox.getLocation(),
	      boundingBox.getHeight(),
	      boundingBox.getWidth() );
    }

    public Ellipse( Point p, double h, double w ) {
	height = h;
	width = w;
	location = new Point( p );
    }

    public double getHeight() {
	return height;
    }

    public double getWidth() {
	return width;
    }

    public Point getLocation() {
	return location;
    }

    /**
     * Compute the area of this ellipse.
     *
     * @return the area of this ellipse.
     */

    public double getArea() {
	return Math.PI * height * width;
    }

    /**
     * Return an approximation of the perimeter of this ellipse.
     * This approximation is is reasonable only for ellipses which
     * are nearly cicular (eccentricity close to zero).
     *
     * @return an approximation of the perimeter of this ellipse.
     */
 
    public double getPerimeter() {
        return 2 * Math.PI * ( ( height + width ) / 2 );
    }

    /**
     * A simple little test of all of the methods in this class.
     *
     * @param args command line arguments (ignored)
     */

    public static void main( String args[] ) {
	Ellipse r = new Ellipse( 1, 1 );

	System.out.println( "Ellipse:" );
	System.out.println( " Height == " + r.getHeight() );
	System.out.println( " Width == " + r.getWidth() );
	System.out.println( " Perimeter == " + r.getPerimeter() );
	System.out.println( " Area == " + r.getArea() );
    }

} // Ellipse
