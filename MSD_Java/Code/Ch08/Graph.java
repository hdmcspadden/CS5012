/**
 * An interface for a Graph.  Every Vertex in the Graph is identified
 * by an unique name.
 */
public interface Graph {
    /**
     * Add a vertex to the graph if the graph does not contain a
     * vertex with the same name.
     *
     * Preconditions:
     *	 The name is not null.
     *
     * Postconditions:
     *	 The Graph contains a Vertex with the given name.
     *
     * @param name the name of the vertex.
     */
    public void addVertex( String name ); 
 
    /** 
     * Add an edge to the graph if the graph not not contain an edge
     * whose source and destination vertices are the same as those
     * specified.
     *
     * Preconditions:
     *	 The source vertex is in the graph.
     *   The destination vertex is in the graph.
     *	
     * Postconditions:
     *	 The specified edge is in the Graph.
     *
     * @param source the name of the source vertex.
     * @param dest the name of the destination vertex.
     * @param cost the cost to traverse this edge.
     */
    public void addEdge( String source, String dest, int cost );

    /** 
     * Add an edge to the Graph.  If the Graph already contains this edge,
     * the old data will be replaced by the new data.
     *
     * Preconditions:
     *	 The source vertex is in the graph.
     *   The destination vertex is in the graph.
     *	
     * Postconditions:
     *	 The specified edge is in the Graph.
     *
     * @param source the name of the source vertex.
     * @param dest the name of the destination vertex.
     */
    public void addEdge( String source, String dest );

    /**
     * Determine whether the Graph contains a Vertex with the given name.
     *
     * Preconditions:
     *	 The name is not null
     *
     * Postconditions:
     *	 The Graph is unchanged.
     *
     * @param name the name of the vertex.
     *
     * @return true if the graph contains a vertex with the given name
     *         and false otherwise.
     */
    public boolean hasVertex( String name );

    /**
     * Determine whether there is an edge between the given Vertices.
     *
     * Preconditions:
     *   Source is not null.
     *	 Dest is not null.
     *
     * Postconditions:
     *	The Graph is unchanged.
     *
     * @return true if there is an edge between the vertices and false
     *         otherwise.
     */
    public boolean hasEdge( String source, String dest );
    
    /**
     * Get the vertex with the specified name.
     *
     * Preconditions:
     *   None
     *
     * Postconditions:
     *   The graph is unchanged.
     *
     * @param name the name of the vertex.
     *
     * @return a reference to the vertex with the specified name and
     *         null if no such vertex exists.
     */
    public Vertex getVertex( String name );

    /**
     * Get the edge that connects the specified vertices.
     *
     * Preconditions:
     *   None
     *
     * Postconditions:
     *   The graph is unchanged.
     *
     * @param source the name of the source vertex.
     * @param dest the name of the destination vertex.
     *
     * @return a reference to the edge that connects the specified
     *         vertices and null if the edge does not exist.
     */
    public Edge getEdge( String source, String dest );

    /**
     * Get all of the vertices in the graph.
     *
     * Precondtions:
     *   None.
     *
     * Postconditions:
     *   The graph is unchanged.
     */
    public List<Vertex> getVertices();

    /**
     * Get all of the edges in the graph.
     *
     * Preconditions:
     *   None.
     *
     * Postconditions:
     *   The graph is unchanged.
     */
    public List<Edge> getEdges();

} // Graph
