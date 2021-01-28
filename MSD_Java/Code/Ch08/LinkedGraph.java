/** 
 * A set-and-adjacency list-based implementation of the Graph ADT.
 * Javadoc comments for methods specified in the Graph interface 
 * have been omitted.
 *
 * This code assumes that the preconditions stated in the comments are
 * true when a method is invoked and therefore does not check the
 * preconditions.
 */ 

import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

public class LinkedGraph implements Graph {
    private Map<String,Vertex> vertices;  // The vertices in the graph
    private int numEdges;  // The number of edges in the graph

    /**
     * Create a new Graph
     */
    public LinkedGraph() {
	vertices = new HashMap<String,Vertex>();
	numEdges = 0;
    }

    public void addVertex( String name ) {
	// Add the vertex if it is not already there
	if ( !vertices.containsKey( name ) ) {
	    vertices.put( name, new Vertex( name ) );
	}
    }

    public void addEdge( String source, String dest, int cost ) {
	// Find the source and destination vertices
	Vertex begin = vertices.get( source );
	Vertex end = vertices.get( dest );

	// If the vertices exist and the edge is not already there add it
	if ( begin != null && end !=null && !begin.isNeighbor( dest ) ) {
	    begin.addEdge( new Edge( begin, end, cost ) );
	}

	// One more edge in the graph
	numEdges = numEdges + 1;
    }

    public void addEdge( String source, String dest ) {
	// Simply add an edge of length 0
	addEdge( source, dest, 0 );
    }

    public boolean hasVertex( String name ) {
	return vertices.containsKey( name );
    }

    public boolean hasEdge( String source, String dest ) {
	Vertex begin = vertices.get( source );
	boolean retVal = false;

	if ( begin != null ) {
	    retVal = begin.isNeighbor( dest );
	}

	return retVal;
    }

    public Vertex getVertex( String name ) {
	return vertices.get( name );
    }

    public Edge getEdge( String source, String dest ) {
	Vertex begin = vertices.get( source );
	Edge retVal = null;

	if ( begin != null ) {
	    retVal = begin.getEdge( dest );
	}

	return retVal;
    }

    public List<Vertex> getVertices() {
	List<Vertex> retVal = new LinkedList<Vertex>();

	for ( Vertex e : vertices.values() ) {
	    retVal.add( e );
	}

	return retVal;
    }

    public List<Edge> getEdges() {
	List<Edge> retVal = new LinkedList<Edge>();

	for ( Vertex e : vertices.values() ) {
	    List<Edge> curEdges = e.getEdges();

	    for ( curEdges.first();
		  curEdges.isOnList();
		  curEdges.next() ) {
		retVal.add( curEdges.get() );
	    }
	}

	return retVal;
    }

    /**
     * Return a string representation of this graph.
     *
     * @return a string representation of this graph.
     */
    public String toString() {
	StringBuffer graphAsString = new StringBuffer( "" );

	java.util.List<String> theVerts = 
	    new java.util.LinkedList<String>( vertices.keySet() );

	Collections.sort( theVerts );

	for ( String e : theVerts ) {
	    graphAsString.append( vertices.get( e ) + "\n" );
	}

	return graphAsString.toString();
    }

} // LinkedGraph
