/**
 * A very simple implementation of a polygon.
 */

public class Polygon {

    protected Point vertices[];  // The vertices of the polygon
    protected int numPoints;     // Number of points in the array

    /**
     * Create a new polygon.
     *
     * @param numVertices the number of vertices in the polygon
     */

    public Polygon( int numVertices ) {
	vertices = new Point[ numVertices ];
	numVertices = 0;
    }

    /**
     * Add a new vertex to the polygon.
     *
     * @param p a point that represent the vertex to be added.
     */

    public void addVertex( Point p ) {

	// Cannot add more vertices than the array will hold.

	if ( numPoints < vertices.length ) {
	    vertices[ numPoints ] = p;
	    numPoints = numPoints + 1;
	}
    }

    /**
     * Compute the perimeter of the polygon.
     *
     * @return the perimeter of the polygon.
     */

    public double getPerimeter() {
	double retVal = 0;

	// Since we know nothing about the shape of the polygon
	// the only way to compute its perimeter is to step through
	// the vertices and compute the distance of each side.

	for ( int i = 0; i < numPoints - 1; i++ ) {
	    Point p1 = vertices[ i ];
	    Point p2 = vertices[ ( i + 1 ) % numPoints ];
	    retVal = retVal + p1.distanceFrom( p2 );
	}

	return retVal;
    }

} // Polygon
