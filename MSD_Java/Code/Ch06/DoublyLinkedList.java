
/**  
 * An implementation of a list using forward and backward references.
 * This changes the order of moving backwards in the list from O(n)
 * to O(1) at the cost of adding one reference to each node in the list.
 *
 * This code assumes that the preconditions stated in the comments are
 * true when a method is invoked and therefore does not check the
 * precondtions.
 */ 
public class DoublyLinkedList<T> implements List<T> {
    private int count;                // The number of nodes in the list
    private DoublyLinkedNode<T> head;    // The first node in the list
    private DoublyLinkedNode<T> last;    // The last node in the list
    private DoublyLinkedNode<T> cursor;  // The current node in the list

    /**
     * Create a new list.
     */
    public DoublyLinkedList() { 
    	count = 0;
    	head = null;
    	last = null;
    	cursor = null;
    }
	
    /** 
     * Moves the cursor to the first element in the list.
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
    	cursor = head;
    }
	
    /** 
     * Moves the cursor to the last element in the list.
     *
     * Preconditions:  
     *   None
     *
     * Postconditions: 
     *   If the list is empty the cursor is moved off the list.  Otherwise,
     *     the cursor is set to the last element in the list.
     *   The list's structure and content are unchanged.
     */ 
    public void last() { 
        cursor = last; 
    }
	
    /** 
     * Moves the cursor to the next element in the list.
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
    	cursor = cursor.getNext();
    }

    /** 
     * Moves the cursor to the previous node in the list.
     *
     * Since this list only has links in the forward direction, the only
     * way to find the previous node is to work from the front of the
     * the list until we locate the previous node.  This is an O(n)
     * operation.
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
        cursor = cursor.getPrevious();
    }

    /** 
     * Deletes the element the cursor is referring to.
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
    	removeNode( cursor );
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
        removeNode( positionToReference( position ) );
    }

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
    public void add( T element ) {
        if(cursor != null){
            addNode( element, cursor.getNext() );
        }
        else{
            addNode( element, null );
        }
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
     *   The cursor refers to the element added to the list.
     *
     * @param position the position in the list where the element will
     *                 be placed.
     * @param element the element to be added to the list.
     */
    public void add( T element, int position ) {
        addNode( element, positionToReference( position ) );
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
    public void addFirst(T element) {
        addNode( element, head );
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
     * @return the element the cursor refers to.
     */
    public T get() {
    	return cursor.getData();
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
     * @return the element in the given position.
     */ 
    public T get( int position ) {
    	return positionToReference( position ).getData();
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
        cursor.setData( element );
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
    	DoublyLinkedNode<T> target = positionToReference( position );
    	target.setData( element );
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
     * @return the number of elements in the list.
     */
    public int size() {
    	return count;
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
     * @return true if the cursor is on the list, false otherwise.
     */
    public boolean isOnList() {
	    return cursor != null;
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
    	for ( DoublyLinkedNode<T> cur = head; cur != null; cur = cur.getNext() ) {
    	    retVal = retVal.append( cur.getData() + " " );
    	}

    	retVal = retVal.append( "]" );

    	// Convert the StringBuffer to a string
    	return retVal.toString();
    }

    /**
     * Remove the specified node from the list.
     *
     * @param target the node to remove.
     * @param prev the node before the node to be deleted.
     */
    private void removeNode( DoublyLinkedNode<T> target ) {
        if( target != null ){
        	DoublyLinkedNode<T> before = target.getPrevious();
        	DoublyLinkedNode<T> after = target.getNext();
    
        	// Cursor is always set the the target's successor
        	cursor = after;  
    
        	// Set the next reference of the node before the target
        	if ( before == null ) {
        	    // We are deleting the head 
        	    head = after;
        	}
        	else {
        	    // We are somewhere in the middle of the list
        	    before.setNext( after );
        	}
    
        	// Set the previous reference of the node after the target
        	if ( after == null ) {
        	    // We are deleting the tail
        	    last = before;
        	}
        	else {
        	    // We are somewhere in the middle of the list
        	    after.setPrevious( before );
        	}
    	
        	// One less item in the list
        	count = count - 1;
        }
    }

    /**
     * Add the specified element to the list between the nodes
     * identified by before and after.
     *
     * @param element the element to add.
     * @param after the node after the node to be added.
     */
    private void addNode( T element, DoublyLinkedNode<T> after ) {
    	DoublyLinkedNode<T> before = null;

    	// Determine what is before the new node
    	if ( after == null ) {
    	    // Adding a new tail to the list
    	    before = last;
    	}
    	else {
    	    // Adding somewhere in the middle of the list
    	    before = after.getPrevious();
    	}
	
    	// Create the node
    	cursor = new DoublyLinkedNode<T>( element, before, after );

    	// Take care of the next reference of the node before the new node
    	if ( before == null ) {
    	    // Adding a new head
    	    head = cursor;
    	} 
    	else {
    	    // Somewhere in the middle of the list
    	    before.setNext( cursor );
    	}

    	// Take care of the previous reference of the node after the new node
    	if ( after == null ) {
    	    // Adding a new tail
    	    last = cursor;
    	}
    	else {
    	    after.setPrevious( cursor );
    	}
	
    	// One more node in the list
    	count = count + 1;
    }

    /**
     * Return a reference to the node with the specified position in the
     * list.
     *
     * @param position the node to obtain the reference for.
     *
     * @return a reference to the node at the specified position.
     */
    private DoublyLinkedNode<T> positionToReference( int position ) {
    	DoublyLinkedNode<T> retVal = head;

    	while ( position > 0 ) {
    	    retVal = retVal.getNext();
    	    position = position - 1;
    	}

    	return retVal;
    }


}
