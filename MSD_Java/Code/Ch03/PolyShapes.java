public class PolyShapes {

    /**
     * Compute the total area of all the shapes in the
     * array.
     *
     * @param shapes array containing the shapes.
     *
     * @return the total area of all the shapes.
     */

    public static double totalArea( Shape shapes[] ) {
	double retVal = 0;

	for ( int i = 0; i < shapes.length; i++ ) {
	    retVal = retVal + shapes[ i ].getArea();
	}

	return retVal;
    }

    public static void main( String args[] ) {
	Shape theShapes[] = new Shape[ 3 ];

	theShapes[ 0 ] = new Square( 10 );
	theShapes[ 1 ] = new Circle( 40 );
	theShapes[ 2 ] = new Triangle( 10, 30 );

	System.out.println( "Total area:  " + totalArea( theShapes ) );
    }

} //PolyShapes
