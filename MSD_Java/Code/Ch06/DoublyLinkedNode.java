
/**  
 * This is a doubly linked list node class suitable for building linked
 * data structures such as lists, stacks, and queues.  It includes 
 * a second, "rear-facing" link that permits O(1) movement towards the 
 * front of the list. 
 */ 

public class DoublyLinkedNode<T> {

    private T data;               // The data stored in this node
    private DoublyLinkedNode<T> next;     // The next node in the data structure
    private DoublyLinkedNode<T> previous; // the rear-facing link
    
    /**
     * Create a new node.
     */
    public DoublyLinkedNode() {
    	this( null, null, null );
    }

    /**
     * Construct a node given the info and next references.
     *
     * @param newData the data to be associated with this node.
     * @param newPrevious a reference to the previous node in the list.
     * @param newNext a reference to the next node in the list.
     */
    public DoublyLinkedNode( T newData, 
			     DoublyLinkedNode<T> newPrevious,
			     DoublyLinkedNode<T> newNext ) {

    	data = newData;
    	next = newNext;
    	previous = newPrevious;
    }

    /**
     * Return the data stored in this node.
     *
     * Preconditions:
     *   None.
     *
     * Postconditions:
     *   The node is unchanged.
     *
     * @return a reference to the data stored in this node.
     */	
    public T getData() {
	    return data;
    }
	
    /**
     * Return a reference to the next node in the data structure.
     *
     * Preconditions:  
     *   None
     *
     * Postconditions: 
     *   The node is unchanged.
     *
     * @return a reference to the next Node in the list, or null if this
     * 	       node has no successor.
     */ 
    public DoublyLinkedNode<T> getNext() {
	    return next;
    }   
	
    /**
     * Return a reference to the previous node in the data structure.
     *
     * Preconditions:
     *   None.
     *
     * Postconditions:
     *   The node is unchanged.
     *
     * @return a reference to the previous node in the data structure.
     */
    public DoublyLinkedNode<T> getPrevious() {
	    return previous;
    }

    /**
     * Set the data associated with this node.
     *
     * Preconditions:  
     *   None
     *
     * Postconditions: 
     *   The data associated with this node has been changed.
     *
     * @param newData the data to be associated with this node.
     */
    public void setData( T newData ) {
	    data = newData;
    }

    /**
     * Set the reference to the next node.
     *
     * Preconditions:
     *   None.
     *
     * Postconditions:
     *   The reference to the next node has been changed.
     *
     * @param newNext the reference to the next node in the data structure.
     */
    public void setNext( DoublyLinkedNode<T> newNext ) {
	    next = newNext;
    }

    /**
     * Set the reference the to previous node in the data structure.
     *
     * Preconditions:
     *   None.
     *
     * Postconditions:
     *   The reference to the previous node in the data structure is changed.
     */
    public void setPrevious( DoublyLinkedNode<T> newPrev ) { 
	    previous = newPrev; 
    }

}
