/**
 * An edge in a graph.
 */
public class Edge implements Comparable<Edge> {
    private Vertex source;   // Where the edge begins
    private Vertex dest;     // Where the edge ends
    private int cost;        // The cost to traverse this edge

    /**
     * Create an Edge.
     *
     * @param theSource starting Vertex.
     * @param theDest ending Vertex.
     * @param theCost cost associated with this edge.
     */
    public Edge( Vertex theSource, Vertex theDest, int theCost ) {
	source = theSource;
	dest = theDest;
	cost = theCost;
    }

    /**
     * Create an Edge without a cost.
     *
     * @param theSource starting Vertex.
     * @param theDest ending Vertex.
     */
    public Edge( Vertex theSource, Vertex theDest ) {
	this( theSource, theDest, 0 );
    }

    /**
     * Get the source vertex.
     *
     * @return the source vertex.
     */
    public Vertex getSource() {
	return source;
    }

    /**
     * Get the destination vertex.
     *
     * @return the destination vertex.
     */
    public Vertex getDest() {
	return dest;
    }

    /**
     * Get the cost associated with this edge.
     *
     * @return the cost associated with this edge.
     */
    public int getCost() {
	return cost;
    }

    /**
     * Return a String representation of this Edge.
     *
     * @return a String of the form "(startVertex->endVertex:cost)"
     */
    public String toString() {
	return 
	    "(" + source.getName() + "->" + 
	    dest.getName() + ":" + cost + ")";
    }

    /**
     * Determine if this edge is equal to another object.
     *
     * @param other the object to compare this edge to.
     *
     * @return true if this edge is equal to the given object.
     */
    public boolean equals( Object other ) {
	boolean retVal = false;
	
	if ( other instanceof Edge ) {
	    Edge otherEdge = (Edge)other;
	    
	    retVal = 
		source.equals( otherEdge.source ) &&
		dest.equals( otherEdge.dest ) &&
		cost == otherEdge.cost;
	}
	
	return retVal;
    }

    /**
     * Compare this edge to another edge.  Edges are compared based on
     * their cost.  If the costs are the same the edges will be ordered
     * based on the names of the vertices that they connect.
     *
     * @param other the edge to compare this edge to.
     */
    public int compareTo( Edge other ) {
	// Compare costs by computing their difference.  If positive
	// the cost of the edge is greater, if 0 the costs are the same,
	// if negative the cost of this edge is less.
	int retVal = cost - other.cost;

	// If the costs are the same - break the tie by looking
	// at the alphabetical ordering of the vertices.
	// This way compareTo() will be consistent with equals().
	if ( retVal == 0 ) {
	    // Compare the sources
	    retVal = source.getName().compareTo( other.source.getName() );

	    // If the sources are the same compare the destinations
	    if ( retVal == 0 ) {
		retVal = dest.getName().compareTo( other.dest.getName() );
	    }
	}

	return retVal;
    }
					     
} // Edge
