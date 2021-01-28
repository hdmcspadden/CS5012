/**
 * An interface for a set which is a collection of objects that contains no
 * duplicates and have no order.
 */
public interface Set<T> {
    /**
     * Add the given element to this set.
     * 
     * Preconditions: 
     *   This set is not full. e is not null. 
     *
     * Postconditions: 
     *   e is contained in this set.
     * 
     * @param e the element to add.
     * @return true if e was added to the set.
     */
    public boolean add(T e);
    
    /**
     * Remove the given element from this set.
     * 
     * Preconditions: 
     *   This set is not empty and e is not null. 
     *
     * Postconditions: 
     *   e is not contained in this set.
     * 
     * @param e the element to remove from this set.
     * @return true if e was removed from the set.
     */
    public boolean remove(T e);
    
    /**
     * Add to this set all elements of the given set.
     * 
     * Preconditions: 
     *   s is not null. 
     *
     * Postconditions: 
     *   This set contains the union of this set and s.
     * 
     * @param s the set whose elements are to be added
     */
    public void union(Set<T> s);

    /**
     * Remove from this set all elements not in the given set.
     * 
     * Preconditions: 
     *   s is not null. 
     *
     * Postconditions: 
     *   This set contains the intersection of this set and s.
     * 
     * @param s the set to intersect with.
     */
    public void intersection(Set<T> s);

    /**
     * Remove all elements in this set which are members of the given 
     * set (i.e., retains those elements not in the given set).
     * 
     * Preconditions: 
     *   s is not null. 
     *
     * Postconditions: 
     *   This set contains the difference of this set and s.
     *
     * @param s the set to 'subtract' from this set.
     */
    public void difference(Set<T> s);

    /**
     * Determines whether this set is empty.
     * 
     * Preconditions: 
     *   None 
     *
     * Postconditions: 
     *   The set is unchanged.
     * 
     * @return true if this set is empty.
     */
    public boolean isEmpty();

    /**
     * Determine if an object is a member of this set.
     * 
     * Preconditions: 
     *   e is not null. 
     *
     * Postconditions: 
     *   The set is unchanged.
     * 
     * @param e the object to check for set membership.
     * @return true if the given element is a member of this set.
     */
    public boolean contains(T e);

    /**
     * Determine if this set is a subset of a given set.
     * 
     * Preconditions: 
     *   s is not null. 
     *
     * Postconditions: 
     *   The set is unchanged.
     * 
     * @param s the set to be for membership.
     * @return true if this set is a subset of the given set.
     */
    public boolean subset(Set<T> s);

    /**
     * Return an array that contains the elements in this set.
     * 
     * Preconditions: 
     *   None 
     *
     * Postconditions: 
     *   The set is unchanged.
     * 
     * @return an array representation of this Set.
     */
    public T[] toArray();

    /**
     * Determine the size of this set.
     * 
     * Preconditions: 
     *   None 
     *
     * Postconditions: 
     *   The set is unchanged.
     * 
     * @return the number of elements in this set.
     */
    public int size();

} // Set
