/**
 * A class that represents a rectangle.  The state of a
 * rectangle consists of its height, width, and a point
 * object.  The point object specifies the location of
 * the upper left hand corner of the rectangle.
 */

public class Rectangle {

    private double height;
    private double width;
    private Point location;

    public Rectangle( double h, double w ) {
	this( new Point( 0, 0 ), h, w );
    }

    public Rectangle( Point p, double h, double w ) {
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

    public double getArea() {
	return height * width;
    }

    public double getPerimeter() {
	return 2 * ( height + width );
    }

    public static void main( String args[] ) {
	Rectangle r = new Rectangle( 10, 10 );

	System.out.println( "Rectangle:" );
	System.out.println( " Height == " + r.getHeight() );
	System.out.println( " Width == " + r.getWidth() );
	System.out.println( " Perimeter == " + r.getPerimeter() );
	System.out.println( " Area == " + r.getArea() );
    }

} // Rectangle
