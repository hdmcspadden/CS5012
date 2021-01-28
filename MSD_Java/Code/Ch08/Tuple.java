/**
 * A class describing a (key,value) pair, or 2-tuple.
 */
public class Tuple<K,V> {
    private K key;    // The Key
    private V value;  // The value

    /**
     * Construct a new Tuple containing the given data.
     * 
     * Preconditions:
     *	 Key is not null
     *	 Value is not null
     * Postconditions:
     *	 The Tuple is ready for use.
     *
     * @param newKey the key.
     * @param newValue the value.
     */
    public Tuple( K newKey, V newValue ) {
        key = newKey;
	value = newValue;
    }

    /**
     * Get this Tuple's key.
     *
     * Preconditions:
     *	 None
     * Postconditions:
     *	 The Tuple is unchanged.
     *
     * @return the key associated with this tuple.
     */
    public K getKey() {
	return key;
    }

    /**
     * Get this Tuple's value.
     *
     * Preconditions:
     *	None
     * Postconditions:
     *	The Tuple is unchanged.
     *
     * @return the value associated with this tuple.
     */
    public V getValue() {
	return value;
    }
	
    /**
     * Set this Tuple's key.  The key of a tuple should not be changed
     * while the tuple is in a table.  The tuple should be removed, the
     * key changed, and then the tuple should be placed back into the
     * table.
     *
     * Preconditions:
     *	 None
     * Postconditions:
     *	 The Tuple has the specified key.
     *
     * @param newKey the new key to associated with this tuple.
     */
    public void setKey( K newKey ) {
	key = newKey;
    }
    
    /**
     * Set this Tuple's value.
     *
     * Preconditions:
     *	None
     * Postconditions:
     *	The Tuple has the specified value
     *
     * @param newValue the value to associated with this tuple.
     */
    public void setValue( V newValue ) {
	value = newValue;
    }

    /**
     * Return a string representation of this tuple.
     *
     * Preconditions:
     *	None
     * Postconditions:
     *	The Tuple is unchanged.
     *
     * @return a string respentation of this tuple.
     */
    public String toString() {
	return "(" + key + "," + value + ")";
    }

} // Tuple

