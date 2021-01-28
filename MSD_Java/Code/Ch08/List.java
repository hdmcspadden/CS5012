
/**  
 * This interface defines the operations that a List is expected to
 * provide.  The operations a list can support can be defined with out
 * regard to the way in which the list is implemented.
 *
 * A list maintains an internal cursor which refers to the current
 * element in the list.
 */
public interface List<T> {
    /** 
     * Move the cursor to the first element in the list.
     *
     * Preconditions:  
     *   None
     *
     * Postconditions: 
     *   If the list is empty the cursor is moved off the list.  Otherwise,
     *     the cursor is set to the first element in the list.
     *   The list's structure and content are unchanged.
     */ 
    public void first(); 

    /** 
     * Move the cursor to the last element in the list.
     *
     * Preconditions:  
     *   None
     *
     * Postconditions: 
     *   If the list is empty the cursor is moved off the list.  Otherwise,
     *     the cursor is set to the last element in the list.
     *   The list's structure and content are unchanged.
     */  
    public void last(); 

    /** 
     * Move the cursor to the next element in the list.
     *
     * Preconditions:  
     *   The cursor is on the list.
     * 
     * Postconditions: 
     *   If the cursor is at the end of the list the cursor is moved off 
     *     the list.  Otherwise the cursor is set to the next element.
     *   The list's structure and content are unchanged.
     */ 
	 
    public void next();

    /** 
     * Move the cursor to the previous node in the list.
     *
     * Preconditions:  
     *   The cursor is on the list.
     * 
     * Postconditions: 
     *   If the cursor is at the front of the list the cursor is moved off 
     *     the list.  Otherwise the cursor is moved to the previous element.
     *   The list's structure and content are unchanged.
     */ 
	 
    public void previous(); 

    /** 
     * Remove the element the cursor is referring to.
     *
     * Preconditions:  
     *   The cursor is on the list.
     * 
     * Postconditions: 
     *   The element the cursor is referring to is removed.
     *   The size of the list has decreased by 1.
     *   If the element that was removed was the last element in the list, 
     *     the cursor is moved off the list.  Otherwise the cursor is 
     *     moved to the removed element's successor.
     */ 
	 
    public void remove(); 

    /**
     * Remove the element at the specified position in the list.
     *
     * Preconditions:
     *   position >= 0 and position < size().
     *
     * Postconditions:
     *   The element at the specified position is removed from the list.
     *   Elements at positions greater than the specified position 
     *     (if any) are shifted to the left by one position.
     *   The size of the list is decreased by 1.
     *   If the element that was removed was the last element in the list, 
     *     the cursor is moved off the list.  Otherwise the cursor is 
     *     moved to the removed element's successor.
     *
     * @param position the position in the list where the element will
     *                 be placed.
     */

     public void remove( int position );

    /** 
     * Add a new element at the position indicated by the cursor.
     *
     * Preconditions:
     *   The list is empty or the cursor is on the list.
     *
     * Postconditions:
     *   If the list is empty, the element becomes the only element
     *     in the list.  Otherwise the element is added at the
     *     position specified by the cursor.
     *   Elements at positions greater than or equal to the current
     *     position of the cursor (if any) are shifted to the right by
     *     one position.
     *   The size of the list has increased by 1.
     *   The cursor refers to the element added to the list.
     *
     * @param element the element to be added to the list.
     */

    public void add( T element );

    /**
     * Add a new element at the specified position in the list.
     *
     * Preconditions:
     *   position >= 0 and position <= size().
     *
     * Postconditions:
     *   The element is added at the specified position in the list.
     *   Elements at positions greater than or equal to the specified position 
     *     (if any) are shifted to the right by one position.
     *   The size of the list is increased by 1.
     *   The cursor refers to the element added to the list.
     *
     * @param position the position in the list where the element will
     *                 be placed.
     * @param element the element to be added to the list.
     */

     public void add( T element, int position );

    /**
     *
     */
    public void addFirst( T element );

    /**
     * Returns the element that the cursor is referring to.
     *
     * @return the element the cursor refers to
     *
     * Precondtions:
     *   The cursor is on the list.
     *
     * Postconditions:
     *   The list's structure, content, and cursor are unchanged.
     */

    public T get();

    /** 
     * Returns the element stored in the specified position in the list.
     *
     * @return the element at the given position
     *
     * Preconditions:
     *   position >= 0 and position < size().
     *
     * Postconditions: 
     *   The list's structure, content, and cursor are unchanged.
     *
     * @param position the location of the element to be retrieved.
     */ 
	 
    public T get( int position ); 

    /**
     * Sets the element stored at the location identified by the cursor.
     *
     * Preconditions:
     *   The cursor is on the list.
     *
     * Postconditions:
     *   The element at the current cursor position is changed to the
     *     specified value.
     *   The list's structure and cursor are unchanged.
     *
     * @param element the element to place in the list.
     */

    public void set( T element );

    /** 
     * Sets the element stored in the specified position in the list.
     *
     * Preconditions:
     *   position >= 0 and position < size().
     *
     * Postconditions:
     *   The element at the specified position in the list is changed
     *     to the specified value.
     *   The list's structure and cursor are unchanged.
     *
     * @param position the location of the element to be changed.
     * @param element the element to place in the specified location
     *                of the list.
     */ 

    public void set( T element, int position );

    /**
     * Return the number of elements in the list.
     *
     * @return the number of elements in the list
     *
     * Preconditions:
     *   None.
     *
     * Postconditions:
     *   The list's structure, content, and cursor are unchanged.
     */

    public int size();

    /**
     * Determine if the cursor is on the list.
     *
     * @return true if the cursor is on the list, false otherwise
     *
     * Preconditions:
     *   None.
     *
     * Postcondtions:
     *   The list's structure, content and cursor are unchanged.
     */

    public boolean isOnList();

} // List

