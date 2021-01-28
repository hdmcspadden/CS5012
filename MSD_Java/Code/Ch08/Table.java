/**
 * An interface describing the Table data structure, also called a Map
 */
public interface Table<K,V> {
    /**
     * Puts the given value into the table, indexed by the given key.
     *
     * Preconditions:
     *   Key is not null
     *   Value is not null
     *
     * Postconditions:
     *   The given value has been associated with the given key.
     *
     * @param key the key to refer to the given value by.
     * @param value the data to associate with the given key.
     */
    public void put( K key, V value );

    /**
     * Removes the object assocated with the given key, if any.
     *
     * Preconditions:
     *   Key is not null
     *
     * Postconditions:
     *   The element (if any) identified by key has been removed.
     *
     * @param key the key to remove.
     */
    public void remove( K key );
    
    /**
     * Returns the object associated with the given key.
     *
     * Preconditions:
     *   Key is not null.
     *
     * Postconditions:
     *   The Table is unchanged.
     *	
     * @param key the key to look up in the table.
     *
     * @return the object associated with the key or null if the key
     *         is not in the table.
     */
    public V get( K key );
    
    /**
     * Determine whether the Table is empty.
     *
     * Preconditions:
     *   None
     *
     * Postconditions:
     *   The Table is unchanged.
     *
     * @return true if the table is empty.
     */
    public boolean isEmpty();
    
    /**
     * Determine the size of the Table.
     *
     * Preconditions:
     *   None
     *
     * Postconditions:
     *   The Table is unchanged.
     *
     * @return the number of elements in the table.
     */	
    public int size();
    
    /**
     * Determine the cardinality of the Table.
     *
     * Preconditions:
     *   None
     *
     * Postconditions:
     *   The Table is unchanged.
     *
     * @return a number one greater than the maximum domain element.
     */
    public int cardinality();
    
    /**
     * Get all the keys in this Table.
     *
     * Preconditions:
     *   None
     *
     * Postconditions:
     *   The Table is unchanged.
     *
     * @return a list containing all of the keys in the table.
     */	
    public List<K> getKeys();
    
    /**
     * Get all values stored in this Table.  There is no correlation
     * between the order of the elements returned by this method and
     * the getKeys() method.
     *
     * Preconditions:
     *   None
     *
     * Postconditions:
     *   The Table is unchanged.
     *
     * @return a list containing all of the values in the table.
     */
    public List<V> getValues();

} // Table

