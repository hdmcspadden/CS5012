public class Square2 extends Polygon {

    /**
     * Create a new sqaure.
     */

    public Square2() {
	super( 4 );
    }

    /**
     * Return the perimeter of the sqaure.
     *
     * @return the perimeter of the sqaure.
     */

    public double getPerimeter() {
	return 4 * vertices[ 0 ].distanceFrom( vertices[ 1 ] );
    }

} // Square
