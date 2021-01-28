/**
 * An implementation of a HashTable using chaining for collision
 * resolution.  Javadoc comments for methods specified in the Table 
 * interface have been omitted.
 *
 * This code assumes that the preconditions stated in the comments are
 * true when a method is invoked and therefore does not check the
 * preconditions.
 */
public class ChainingHashTable<K,V> implements Table<K,V> {
    private List<Tuple<K,V>> hashTable[];  // The hashtable
    int size;                              // The size of the hash table

    /** 
     * Create a new hash table.
     *
     * @param cardinality the number of elements in the domain.
     */
    public ChainingHashTable( int cardinality ) {
	// Note that the cast is necessary because you cannot
	// create generic arrays in Java.  This statement will
	// generate a compiler warning.
	hashTable = (LinkedList<Tuple<K,V>>[])new LinkedList[ cardinality ];
	size = 0;
    }

    public void put( K key, V value ) {
	int bucket = key.hashCode();
	
	// Do we need to create a new list for this bucket?
	if ( hashTable[ bucket ] == null ) {
	    hashTable[ bucket ] = new LinkedList<Tuple<K,V>>();
	}
	
	hashTable[ bucket ].add( new Tuple<K,V>( key, value ) );
	size = size + 1;
    }
    
    public void remove( K key ) {
	int bucket = key.hashCode();
	List<Tuple<K,V>> chain = hashTable[ bucket ];
	boolean found = false;
	
	// Is there a chain to search?
	if ( chain != null ) {
	    // Step through the chain until we fall off the end or
	    // find the tuple to delete
	    chain.first();
	    while ( !found && chain.isOnList() ) {
		// If this tuple has the key we are looking for
		// delete it and stop the loop
		if ( chain.get().getKey().equals( key ) ) {
		    chain.remove();
		    found = true;
		}
		else {
		    chain.next();
		}
	    }
	}
    }

    public V get(K key) {
	int bucket = key.hashCode();
	List<Tuple<K,V>> chain = hashTable[ bucket ];
	V retVal = null;
	
	// Is there a chain to search?
	if ( chain != null ) {
	    // Step through the chain until we find the element or 
	    // run out of list.
	    for ( chain.first(); 
		  retVal == null && chain.isOnList(); 
		  chain.next() ) {
		
		// If this tuple has the key we are looking for,
		// extract the value
		if ( chain.get().getKey().equals( key ) ) {
		    retVal = chain.get().getValue();
		}
	    }
	}
	
	return retVal;
    }

    public boolean isEmpty() {
	return size == 0;
    }

    public int size() {
	return size;
    }

    public int cardinality() {
	return hashTable.length;
    }

    public List<K> getKeys() {
	List<Tuple<K,V>> chain;
	List<K> keys = new LinkedList<K>();
	
	// Go through each chain and create a list that contains all
	// of the keys in the table
	for ( int i = 0; i < hashTable.length; i++ ) {
	    if ( hashTable[ i ] != null) {
		chain = hashTable[ i ];
		
		for ( chain.first(); chain.isOnList(); chain.next() ) {
		    keys.add( chain.get().getKey() );
		}
	    }
	}
	
	return keys;
    }

    public List<V> getValues() {
	List<Tuple<K,V>> chain;
	List<V> values = new LinkedList<V>();
	
	// Go through each chain and create a list that contains all
	// of the keys in the table
	for ( int i = 0; i < hashTable.length; i++ ) {
	    if ( hashTable[ i ] != null) {
		chain = hashTable[ i ];
		
		for ( chain.first(); chain.isOnList(); chain.next() ) {
		    values.add( chain.get().getValue() );
		}
	    }
	}
	
	return values;
    }

    /**
     * Return a string representation of this hash table.
     *
     * @return a string representation of this hash table.
     */
    public String toString() {
	StringBuffer hashAsString = new StringBuffer( "" );
	List chain = null;
	
	for ( int i = 0; i < hashTable.length; i = i + 1 ) {
	    hashAsString.append( "h[" + i + "]==" );
	    
	    if ( hashTable[ i ] != null ) {
		chain = hashTable[ i ];
		
		for ( chain.first(); chain.isOnList(); chain.next() ) {
		    hashAsString.append( " " + chain.get() );
		}
	    }
	    
	    hashAsString.append( "\n" );
	}
	
	return hashAsString.toString();
    }
    
} // ChainingHashTable
