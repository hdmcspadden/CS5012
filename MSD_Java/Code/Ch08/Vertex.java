/**
 * A class representing a named vertex in a graph.
 */
public class Vertex {
    // The cardinality of the table used to track edges
    private static final int TABLE_CARDINALITY = 31;

    private String name;                // The name of this vertex
    private boolean tag;                // A flag that can be set by the user
    private Table<String, Edge> edges;  // The edges that start at this vertex

    /**
     * Create a new vertex.
     *
     * @param theIdent a unique identifier for this vertex.
     */
    public Vertex( String theName ) {
	name = theName;
	tag = false;
	edges = new ChainingHashTable<String,Edge>( TABLE_CARDINALITY );
    }

    /**
     * Get the name of this vertex.
     *
     * Preconditions:
     *	 None
     *
     * Postconditions:
     *	 The vertex is unchanged.
     *	
     * @return the name of this vertex.
     */
    public String getName() {
	return name;
    }

    /**
     * Get the tag associated with this vertex.
     *
     * Preconditions:
     *	 None
     *
     * Postconditions:
     *	 The vertex is unchanged.
     *
     * @return the state of the tag associated with this vertex.
     */
    public boolean getTag() {
	return tag;
    }

    /**
     * Set the tag associated with this vertex.
     *
     * Preconditions:
     *	 None
     *
     * Postconditions:
     *	 The flag has the given value.
     *
     * @param newTag the tag's new value.
     */
    public void setTag( boolean newTag ) {
	tag = newTag;
    }

    /**
     * Add an edge to this vertex.  If the edge already exists, 
     * it will be replaced by the new edge.
     *
     * Preconditions:
     *	 The edge is not null.
     *   The source of the edge is this vertex.
     *
     * Postconditions
     *	 This Vertex has the specified edge.
     *
     * @param theEdge the edge to add to this vertex.
     */
    public void addEdge( Edge theEdge ) {
	edges.put( theEdge.getDest().getName(), theEdge );
    }

    /**
     * Get the edge that starts at this vertex and ends at the
     * vertex with the given name.
     *
     * Preconditions:
     *   The name is not null.
     *
     * Postcondtions:
     *   The vertex is not changed.
     *
     * @param name the name of the destination vertex.
     *
     * @return a reference to the edge that leads from this vertex
     *         to the specified vertex or null if the edge does not
     *         not exist.
     */
    public Edge getEdge( String name ) {
	return edges.get( name );
    }

    /**
     * Determine if the vertex with the given name is a neighbor of
     * this vertex.
     *
     * Preconditions:
     *   The name is not null.
     *
     * Postconditions:
     *   The vertex is not changed.
     *
     * @param name the name of the vertex.
     *
     * @return true if one of the neighbors of this vertex has the
     *         the specified name and false otherwise.
     */
    public boolean isNeighbor( String name ) {
	return edges.get( name ) != null;
    }

    /**
     * Get the neighbors of this vertex.
     *
     * Preconditions:
     *   None.
     *
     * Postconditions:
     *   The vertex is unchanged.
     *
     * @return a list containing all of the vertices that
     *         are neighbors of this vertex.
     */
    public List<Vertex> getNeighbors() {
	List<Edge> theEdges = edges.getValues();
	List<Vertex> retVal = new LinkedList<Vertex>();
	
	for ( theEdges.first(); theEdges.isOnList(); theEdges.next() ) {
	    retVal.add( theEdges.get().getDest() );
	}
	
	return retVal;
    }

    /**
     * Get the edges that start from this vertex.
     *
     * Preconditions:
     *   None.
     *
     * Postconditions:
     *   The vertex is unchanged.
     *
     * @return a list containing all of the edges that start from
     *         this vertex.
     */
    public List<Edge> getEdges() {
	List<Edge> theEdges = edges.getValues();
	List<Edge> retVal = new LinkedList<Edge>();
	
	for ( theEdges.first(); theEdges.isOnList(); theEdges.next() ) {
	    retVal.add( theEdges.get() );
	}
	
	return retVal;
    }

    /**
     * Returns a String representation of this vertex.
     *
     * @return a String representation of this vertex.
     */
    public String toString() {
	StringBuffer vertexAsString = new StringBuffer( "" );
	List<Edge> theEdges = edges.getValues();
	
	vertexAsString.append( name + " (tag=" + tag +")\n" );
	
	for ( theEdges.first(); theEdges.isOnList(); theEdges.next() ) {
	    vertexAsString.append( "  " + theEdges.get() + "\n" );
	}
	
	return vertexAsString.toString();
    }

} // Vertex

