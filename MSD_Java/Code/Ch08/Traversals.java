public class Traversals implements Callback<Vertex> {

    public void visit( Vertex data ) {
	System.out.println( data.getName() );
    }

    /**
     * Perform a breadth first traversal of the vertices in
     * the given graph starting at the specified node.  The
     * call back object is used to process each node as it
     * appears in the traversal.
     *
     * @param g the graph to traverse
     * @param start the vertex where the traversal will start
     * @param cb the object that processes vertices.
     */
    public void BFSTraverse( Graph g, Vertex start, Callback<Vertex> cb ) {
	Queue<Vertex> waiting = 
	    new LinkedQueue<Vertex>();  // Queue of waiting vertices

	// Ensure the graph has no marked vertices
	List<Vertex> vertices = g.getVertices();
	for (vertices.first(); vertices.isOnList(); vertices.next() ) {
	    vertices.get().setTag( false );
	}

	// Put the start vertex in the work queue
	waiting.enqueue( start );
		
	// While there are waiting vertices
	while ( !waiting.empty() ) {
	    // Get the next Vertex
	    Vertex curVertex = waiting.front();
	    waiting.dequeue();

	    // If this Vertex hasn't been processed yet
	    if ( !curVertex.getTag() ) {
		cb.visit( curVertex );   // Process the vertex
		curVertex.setTag(true);  // Mark it as visited
				
		// Put its unmarked neighbors into the work queue
		List<Vertex> neighbors = curVertex.getNeighbors();
		for ( neighbors.first(); 
		      neighbors.isOnList(); 
		      neighbors.next() ) {
		    Vertex cur = neighbors.get();
		    if ( !cur.getTag() ) {
			waiting.enqueue( cur );
		    }
		}
	    }
	}
    }

    /**
     * Use Kruskal's algorithm to create a minimum spanning tree
     * for the given graph.  The MST is returned in the form of a
     * graph.
     *
     * @param g the graph from which to generate the MST
     *
     * @return a graph containing the the vertices of g and the
     *         the edges nesseary to form a minimum spanning tree.
     */	
    public Graph kruskalMST( Graph g ) {
	// Where the MST will be stored
	Graph mst = new LinkedGraph();

	// All the vertices in the graph
	List<Vertex> vertices = g.getVertices();

	// List of Vertex Sets
	List<Set<String>> vertexSets = new LinkedList();

	// Add the vertices in the original graph to mst
	// and create the vertex sets at the same time
        for ( vertices.first(); vertices.isOnList(); vertices.next() ) {
	    String curName = vertices.get().getName();
	    Set<String> curSet = null; //new ArrayBasedSet<Vertex>();

	    // Add the name of the current vertex to its set and then
	    // add the set to the list that contains the vertex sets
	    curSet.add( curName );
	    vertexSets.add( curSet );

	    // Add the current vertex to the MST graph
	    mst.addVertex( curName );
	}

	// Put the edges into a heap which effectively sorts them
	Heap<Edge> edges = new ArrayBasedHeap<Edge>();
	List<Edge> allEdges = g.getEdges();
	for ( allEdges.first(); allEdges.isOnList(); allEdges.next() ) {
	    edges.insertHeapNode( allEdges.get() );
	}

	// Setup is complete - run the algorithm

	// There is more than one set left in the list vertex sets
	while ( vertexSets.size() > 1 ) {
	    // Get the smallest edge
	    Edge cur = edges.getSmallest();

	    // Find the sets where these vertices are located
	    int sourcePos = findSet( vertexSets, cur.getSource().getName() );
	    int destPos = findSet( vertexSets, cur.getDest().getName() );

	    // If the vertices are in different sets - add the edge to
	    // the MST
	    if ( sourcePos != destPos ) {
		Set<String> sourceSet = vertexSets.get( sourcePos );
		Set<String> destSet = vertexSets.get( destPos );

		// Add the edge to the MST
		mst.addEdge( cur.getSource().getName(),
			     cur.getDest().getName(),
			     cur.getCost() );

		// Merge the sets
		sourceSet.union( destSet );
		vertexSets.remove( destPos );
	    }
	}

	// The MST can be read from this graph
	return mst;
    }

    /**
     * Return the position of the first set in the list that
     * contains the specified name.
     *
     * @param vertexSets a list of sets to search.
     * @param name the name being searched for.
     *
     * @return the position of the first set in the list that contains
     *         the name or -1 if the name cannot be found.
     */

    private int findSet( List<Set<String>> vertexSets, String name ) {
	int retVal = -1;

	// Step through the list and examine each set.  Stop when you
	// find a set with the name or we fall off the list
	for ( int i = 0; retVal == -1 && i < vertexSets.size(); i = i + 1 ) {
	    Set curSet = vertexSets.get( i );

	    // Does the current set contain the name we are looking for?
	    if ( curSet.contains( name ) ) {
		retVal = i;
	    }
	}

	// Return the position of the set
	return retVal;
    }

    /**
     * Perform Dijkstra's Shortest Path algorithm on the given graph,
     * starting at the given vertex.  
     *
     * @param g the Graph to traverse.
     * @param name the name of the vertex where the traversal starts.
     * 
     * @return an array containing vertex path costs.  
     */
    public int[] dijkstraSP( Graph g, String name ) {
	// The names of the vertices for which the shortest
	// path is not known
	Set<String> u = new ArrayBasedSet<String>();

	// The names of the vertices for which the shortest
	// path is known
	Set<String> s = new ArrayBasedSet<String>();

	// Put the vertices in an array to make things easier
	List<Vertex> vertices = g.getVertices();
	Vertex v[] = new Vertex[ vertices.size() ];
	for ( int i = 0; i < vertices.size(); i++ ) {
	    v[ i ] = vertices.get( i );
	}

	// The starting vertex
	Vertex start = g.getVertex( name );

	// The lowest costs seen so far
	int c[] = new int[ v.length ];

	// Temporary edge used by the program
	Edge curEdge = null;

	// Sort the vertices by name so that the costs will
	// appear in order by name
	Heap<String> names = new ArrayBasedHeap<String>();

	// Build the heap
	for ( int i = 0; i < v.length; i = i + 1 ) {
	    names.insertHeapNode( v[ i ].getName() );
	}

	// Read out the values
	for ( int i = 0; !names.empty(); i = i + 1 ) {
	    v[ i ] = g.getVertex( names.getSmallest() );
	}

	// We "know" the shortest path to the source
	s.add( name );
		
	// For each vertex, compute the starting cost
	for ( int i = 0; i < v.length; i = i + 1 ) {
	    // If this isn't the start node
	    if ( !v[ i ].getName().equals( name ) ) {
		// Put it in the unknown set
		u.add( v[ i ].getName() );

		// Compute the initial cost to reach this Vertex
		curEdge = start.getEdge( v[ i ].getName() );

		if ( curEdge != null ) {
		    c[ i ] = curEdge.getCost();
		} else {
		    // This Vertex is currently unreachable
		    c[ i ] = Integer.MAX_VALUE; 
		}
	    } else {
		// It costs 0 to get to the start vertex
		c[ i ] = 0;
	    }
	}

	// Set is complete - run the algorithm until all of
	// the paths are known

	while ( !u.isEmpty() ) {
	    // Find the position of the lowest-cost unknown node
	    int min = Integer.MAX_VALUE;
	    int minPos = -1;
	    for ( int i = 0; minPos == -1 && i < c.length; i = i + 1 ) {
		if ( c[ i ] < min && u.contains( v[ i ].getName() ) ) {
		    min = c[ i ];
		    minPos = i;
		}
	    }
	    
	    // We know the shortest path to the vertex
	    s.add( v[ minPos ].getName() );
	    u.remove( v[ minPos ].getName() );
	    
	    // Update the costs based
	    for ( int i = 0; i < c.length; i = i + 1 ) {
		// Get the edge between the new shortest and the
		// current node in the array
		curEdge = v[ minPos ].getEdge( v[ i ].getName() );

		// If there is an edge
		if ( curEdge != null ) {
		    // If going through the new node is better than
		    // what has been seen update the cost
		    if ( c[ i ] > c[ minPos ] + curEdge.getCost() ) {
			c[ i ] = c[ minPos ] + curEdge.getCost();
		    }
		}
	    }
	}
	
	return c;
    }
					
    public static void main( String args[] ) {
	Traversals t = new Traversals();
	Graph g = new LinkedGraph();

	g.addVertex( "A" );
	g.addVertex( "B" );
	g.addVertex( "C" );
	g.addVertex( "D" );
	g.addVertex( "E" );
	g.addVertex( "F" );

	g.addEdge( "A", "B", 5 ); 
	g.addEdge( "A", "D", 9 );
	g.addEdge( "A", "C", 10 );

	g.addEdge( "B", "A", 5 );
	g.addEdge( "B", "D", 4 );

	g.addEdge( "C", "A", 10 );
	g.addEdge( "C", "D", 13 );
	g.addEdge( "C", "E", 14 );

	g.addEdge( "D", "B", 4 );
	g.addEdge( "D", "A", 9 );
	g.addEdge( "D", "C", 13 );
	g.addEdge( "D", "E", 7 );
	g.addEdge( "D", "F", 8 );

	g.addEdge( "E", "C", 14 );
	g.addEdge( "E", "D", 7 );
	g.addEdge( "E", "F", 2 );

	g.addEdge( "F", "D", 8 );
	g.addEdge( "F", "E", 2 );

	int costs[] = t.dijkstraSP( g, "A" );

	for ( int i = 0; i < costs.length; i = i + 1 ) {
	    System.out.println( costs[ i ] );
	}
    }
}
