/**  
 * An array based implementation of a set.  Javadoc comments 
 * for methods specified in the Set interface have been omitted.
 *
 * This code assumes that the preconditions stated in the comments are
 * true when a method is invoked and therefore does not check the
 * preconditions.
 */ 
public class ArrayBasedSet<T> implements Set<T> {
    private static final int START_SIZE = 16;  // Initial capacity
    private T contents[];                      // Contents of the set
    protected int size;                        // Size of the set
    
    /**
     * Create a new ArrayBasedSet
     */
    public ArrayBasedSet() {
	contents = ( T[] )new Object[ START_SIZE ];  // Will generate a warning
	size = 0;
    }
    
    public boolean add( T e ) {
	boolean hadIt = contains(e);
	if ( !hadIt ) {
	    if ( size == contents.length ) {
		// Expand the array
		T[] newS = ( T[] )new Object[ contents.length * 2 ];
		for ( int i = 0; i < size; i++ ) {
		    newS[ i ] = contents[ i ];
		}
		contents = newS;
	    }

	    contents[ size++ ] = e; // Put it in there
	}
	
	return !hadIt;
    }
	
    public boolean remove( T e ) {
	boolean inThere = false;
	int i = 0;
	
	// Find the element's position
	for ( i = 0; !inThere && i < size; i++ ) {
	    inThere |= e.equals( contents[ i ] );
	}
	
	if ( inThere ) {
	    // Compact the array, overwriting the deleted element
	    for ( int j = i - 1; j <= size; j++ ) {
		contents[ j ] = contents[ j + 1 ];
	    }

	    size--;
	}
	
	return inThere;
    }

    public void union( Set<T> s ) {
	T elements[] = s.toArray();
	for ( int i = 0; i < elements.length; i++ )  {
	    add( elements[ i ] );
	}
    }
	
    public void intersection( Set<T> s ) {
	for ( int i = 0; i < size; i++ ) {
	    if ( !s.contains( contents[ i ] ) ) {
		remove( contents[ i ] );
		i--; // Don't skip the next element
	    }
	}
    }

    public void difference( Set<T> s ) {
	for ( int i = 0; i < size; i++ ) {
	    if ( s.contains( contents[ i ] ) ) {
		remove( contents[ i ] );
		i--; // Don't skip the next element
	    }
	}
    }

    public boolean isEmpty() {
	return size == 0; 
    }
    
    public boolean contains( T e ) {
	boolean inThere = false;
	// Check each slot until we find a match 
	for ( int i = 0; !inThere && i < size; i++ ) {
	    inThere |= e.equals( contents[ i ] );
	}

	return inThere;
    }
	
    public boolean subset( Set<T> s ) {
	boolean subset = true;
	for ( int i = 0; subset && i < size; i++ ) {
	    subset &= s.contains( contents[ i ] );
	}
	
	return subset;
    }

    public T[] toArray() {
	T o[] = ( T[] )new Object[ size ];  // Will generate a warning
	for ( int i = 0; i < size; i++ ) {
	    o[ i ] = contents[ i ];
	}

	return o;
    }

    public int size() {
	return size;
    }

    /**
     *
     * Construct a String representation of this array.
     *
     * @return a string representation of this set.
     */
    public String toString() {
	StringBuffer sb = new StringBuffer();
	for ( int i = 0; i < size; i++ ) {
	    sb.append( contents[ i ] + " ");
	}
	
	return sb.toString().trim();
    }

    /**
     * Test the implementation.
     */
    public static void main(String args[]) {
	
	ArrayBasedSet<Integer> s = new ArrayBasedSet<Integer>();
	ArrayBasedSet<Integer> t = new ArrayBasedSet<Integer>();
	ArrayBasedSet<Integer> u = new ArrayBasedSet<Integer>();
	ArrayBasedSet<Integer> v = new ArrayBasedSet<Integer>();
	
	s.add(new Integer(1));
	s.add(new Integer(2));
	s.add(new Integer(3));
	s.add(new Integer(4));
	
	t.add(new Integer(3));
	t.add(new Integer(4));
	t.add(new Integer(5));
	t.add(new Integer(6));
	
	v.add(new Integer(2));
	v.add(new Integer(3));
	
	System.out.println("s: " + s);
	System.out.println("t: " + t);
	System.out.println("u: " + u);
	System.out.println("v: " + v);
	
	System.out.println("s + 6: " + s.add(new Integer(6)));
	System.out.println("s: " + s);
	
	System.out.println("s + 4: " + s.add(new Integer(4)));
	System.out.println("s: " + s);
	
	System.out.println("t - 3: " + t.remove(new Integer(3)));
	System.out.println("t: " + t);
	
	System.out.println("t - 2: " + t.remove(new Integer(2)));
	System.out.println("t: " + t);
	
	s.union(t);
	System.out.println("s union t: " + s);
	
	System.out.println("s: " + s);
	System.out.println("t: " + t);
	s.intersection(t);
	System.out.println("s intersection t: " + s);
	
	s.difference(t);
	System.out.println("s difference t: " + s);
	
	t.difference(s);
	System.out.println("t difference s: " + t);
	
	System.out.println("t empty? " + t.isEmpty());
	System.out.println("u empty? " + u.isEmpty());
	
	System.out.println("t contains 2? " + 
			   t.contains(new Integer(2)));
	
	System.out.println("t contains 3? " + 
			   t.contains(new Integer(3)));
	
	System.out.println("s: " + s);
	System.out.println("t: " + t);
	System.out.println("u: " + u);
	System.out.println("v: " + v);
	System.out.println("s subset of t? " + s.subset(t));
	System.out.println("s subset of u? " + s.subset(u));
	System.out.println("s subset of v? " + s.subset(v));
    }

} // ArrayBasedSet
