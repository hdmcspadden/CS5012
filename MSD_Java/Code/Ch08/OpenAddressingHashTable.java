/**
 * A hash table that uses open addressing.  Javadoc comments 
 * for methods specified in the Set interface have been omitted.
 *
 *
 * This code assumes that the preconditions stated in the comments are
 * true when a method is invoked and therefore does not check the
 * preconditions.
 */ 

public class OpenAddressingHashTable<K,V> implements Table<K,V> {
    // Safety constants for the domain
    public static int CARDINALITY = 27;
    public static int ADDR_STEP = 17;
    
    // The hashTable
    private Tuple<K,V> table[];
    private int size;

    /**
     * Create a new hash table.
     */
    public OpenAddressingHashTable() {
	table = (Tuple<K,V>[]) new Tuple[ CARDINALITY ];
	size = 0;
    }

    public void put( K key, V value ) {
	int pos = key.hashCode();
	
	// Find an open position
	while ( table[ pos ] != null ) {
	    pos = ( pos + ADDR_STEP ) % table.length;
	}
	
	table[ pos ] = new Tuple<K,V>( key, value );
	size = size + 1;
    }

    public void remove( K key ) {
	int loc = find( key );
	
	if ( loc != -1 ) {
	    table[ loc ] = null;
	    size = size - 1;
	}
    }

    /**
     * Return the location in the table where the tuple with the
     * specified key is found.  A -1 is returned if the key cannot
     * be found in the table.
     *
     * @param key the key to search the table for.
     * @return the location of the key in the table or -1 if the key
     *         cannot be found.
     */
    private int find( K key ) {
	int probe = key.hashCode();
	int loc = -1;
 
	// Check the 'next' open address until we find the key or we have 
	// checked the entire array
	for ( int i = 0; i < table.length && loc == -1; i = i + 1) {
	    Tuple<K,V> curTuple = table[ probe ];
	    
	    // Is this the tuple we are looking for?
	    if ( curTuple != null && curTuple.getKey().equals( key ) ) {
		loc = i;
	    } else {
		// Calculate the next table location to probe
		probe = ( probe + ADDR_STEP ) % table.length;
	    }
	}
	
	return loc;
    }

    public V get( K key ) {
	int loc = find( key );
	V retVal = null;
	
	if ( loc != -1 ) {
	    retVal = table[ loc ].getValue();
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
	return CARDINALITY;
    }
	
    public List<K> getKeys() {
	List<K> keys = new LinkedList<K>();

	// Populate the list with the keys in the table
	for ( int i = 0; i < table.length; i = i + 1 ) {
	    if ( table[ i ] != null ) {
		keys.add( table[ i ].getKey() );

	    }
	}
	
	return keys;
    }
    
    public List<V> getValues() {
	List<V> values = new LinkedList<V>();

	// Populate the list with the values in the table
	for ( int i = 0; i < table.length; i = i + 1 ) {
	    if ( table[ i ] != null ) {
		values.add( table[ i ].getValue() );
	    }
	}

	return values;
    }

    /**
     * Return a string representation of the hash table.
     *
     * @return a string representation of the hash table.
     */
    public String toString() {
	StringBuffer hashAsString = new StringBuffer( "" );

	for ( int i = 0; i < table.length; i = i + 1 ) {
	    hashAsString.append( "h[" + i + "]==" );
	    
	    if ( table[ i ] != null ) {
		hashAsString.append( table[ i ] );
	    }
	    
	    hashAsString.append( "\n" );
	}

	return hashAsString.toString();
    }
    
} // OpenAddressingHashTable
