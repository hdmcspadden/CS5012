
/**
 * The following is an array-based implementation of the List interface.
 */ 

public class ArrayList<T> implements List<T> {
    // Used to mark an empty position in the array
    private static final int OFF_LIST = -1;
    
    private T data[];  // Elements in the list

    private int SIZE = 20;  // Initial size of the arrays
    private int last;       // The end of the list
    private int cursor;     // Current node

    /**
     * Constructor for the list
     */
    public ArrayList() {
	data = (T[])new Object[ SIZE ];
	
	last = OFF_LIST;
	cursor = OFF_LIST;
    }

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
    public void first() { 
        // If there are no elements in the list, then move the 
        // cursor off the list.
        if( last == OFF_LIST ){
            cursor = OFF_LIST;
        }
        else{
            //Since java arrays start at index 0
            cursor = 0;
        }
    }
 
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
    public void last()  { 
        // If there are no elements in the list, then move the 
        // cursor off the list.
        if( last == OFF_LIST ){
            cursor = OFF_LIST;
        }
        else{
            cursor = last;
        }
    }

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
    public void next() {
        // If the cursor is at the end of the list, move it off.
        if( cursor >= last ){
            cursor = OFF_LIST;
        }
        else{
            cursor = cursor + 1; // Increment the cursor to the next element.
        }
    }

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
    public void previous() { 
        // If the cursor is at the beginning of the list, move it off.
        if( cursor == 0 ){
            cursor = OFF_LIST;
        }
        else{
            cursor = cursor - 1; // Decrement the cursor to the previous element.
        }
    }

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
    public void remove() { 
        remove( cursor );
    }

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
    public void remove( int position ) {
        
        // Shift all elements greater than the specified element (position)
        // to the left by one, overwriting (thus removing) the element 
        // at the index given by position.
        if( position != OFF_LIST){
            for( int i = position; i < last; i++ ){
                data[ i ] = data[ i + 1 ];
            }
        
            // If the element is the last element in the list, move the cursor
            // off the list.
            if( last == position ){
                cursor = OFF_LIST;
            }
        
            // Decrement the size of the list by decreasing last by one. 
            last = last - 1;
        
            // NOTE: The cursor doesn't need to actualy be changed since the
            // elements have been shifted it is not pointing at the removed
            // element's successor. 
        }
    }

    /** 
     * Add a new element as the successor to the position indicated by 
     * the cursor.
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
    public void add( T element ) {
        // Add the node to the list (as the successor to the cursor)
        cursor = cursor + 1;
        add( element, cursor );
    }

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
     *   If adding the element overflows the array, the array size is doubled
     *   The cursor refers to the element added to the list.
     *
     * @param position the position in the list where the element will
     *                 be placed.
     * @param element the element to be added to the list.
     */
    public void add( T element, int position ) {
        // If the list is empty, make this the first element
        if( last == OFF_LIST ){
            data[ 0 ] = element;
            // Increment the size of the array to one.
            last = 0;            
        }
        else{
            // Check if adding the element will overflow the array
            if( last == SIZE - 1 ){
                // Since adding the element will overflow the array,
                // double the size of it.
                doubleArraySize();
            }
            
            // Shift all elements greater than this one down one
            for( int i = last; i >= position; i-- ){
                data[ i + 1 ] = data[ i ];
            }
            
            // Assign the element to the specified position
            data[ position ] = element; 
            
            // Increase the size by incrementing last by one
            last = last + 1;
            
            // Assign the cursor to the new element
            cursor = position;
        }
    }
    
    /** 
     * Add a new element at the beginning of the list.
     * 
     * Preconditions:
     *   None
     *
     * Postconditions:
     *   The element is added at the specified position in the list.
     *   The size of the list has increased by 1.
     *   The cursor refers to the element added to the list.
     *
     * @param element the element to be added to the list.
     */
    public void addFirst( T element ){
        // Call add with the position set to the beginning (0)
        add( element, 0 );
    }

    /**
     * Returns the element that the cursor is referring to.
     *
     * Precondtions:
     *   The cursor is on the list.
     *
     * Postconditions:
     *   The list's structure, content, and cursor are unchanged.
     *
     * @return the element the cursor refers to
     */
    public T get() { 
        return data[ cursor ];
    }

    /** 
     * Returns the element stored in the specified position in the list.
     *
     * Preconditions:
     *   position >= 0 and position < size().
     *
     * Postconditions: 
     *   The list's structure, content, and cursor are unchanged.
     *
     * @param position the location of the element to be retrieved.
     *
     * @return the element at the given position
     */ 
    public T get( int position ) {
        return data[ position ];
    }

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
    public void set( T element ) {
        data[ cursor ] = element;
    }

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
    public void set( T element, int position ) {
        data[ position ] = element;
    }

    /**
     * Return the number of elements in the list.
     *
     * Preconditions:
     *   None.
     *
     * Postconditions:
     *   The list's structure, content, and cursor are unchanged.
     *
     * @return the number of elements in the list
     */
    public int size() {
        // Return last + 1 since last is zero-indexed
        return last + 1;
    }

    /**
     * Determine if the cursor is on the list.
     *
     * Preconditions:
     *   None.
     *
     * Postcondtions:
     *   The list's structure, content and cursor are unchanged.
     *
     * @return true if the cursor is on the list, false otherwise
     */
    public boolean isOnList() {
        return cursor != OFF_LIST;
    }

    /**
     * Return a string representation of this list.
     *
     * @return a string representaion of this list.
     */
    public String toString() {
        // Use a StringBuffer so we don't create a new
        // string each time we append
        StringBuffer retVal = new StringBuffer();

    	retVal = retVal.append( "[ " );
    
    	// Step through the list and use toString on the elements to
    	// determine their string representation
    	for ( int cur = 0; cur <= last; cur++ ) {
    	    retVal = retVal.append( data[ cur ] + " " );
    	}
    
    	retVal = retVal.append( "]" );
    
    	// Convert the StringBuffer to a string
    	return retVal.toString();
    }

    /**
     * Takes the data array and doubles the size of it. A temporary array
     * is used while the elements are being copied to the new array.
     */
    private void doubleArraySize(){
        // Double the size
        SIZE = SIZE * 2;
        
        T temp[] = (T[])new Object[ SIZE ];
        
        // Copy all of the elements to the new array
        for( int i = 0; i <= last; i++ ){
            temp[ i ] = data [ i ]; 
        }
        
        // Set the data variable to the temp array which is our new array
        data = temp;
    }
}
