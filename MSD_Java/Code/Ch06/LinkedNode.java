
/**  
 * This class represents the nodes in a singly linked list.
 */ 

public class LinkedNode<T> {

    private T data;      // The data stored in this node
    private LinkedNode<T> next;  // The next node in the data structure
    
    /**
     * Default constructor for the LinkedNode
     */
    public LinkedNode() {
    	this( null, null );
    }

    /**
     * Construct a node given the info and next references.
     *
     * @param newData the data to be associated with this node.
     * @param newNext a reference to the next node in the list.
     */
    public LinkedNode( T newData, LinkedNode<T> newNext ) {
    	data = newData;
    	next = newNext;
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
    public LinkedNode<T> getNext() {
    	return next;
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
    public void setNext( LinkedNode<T> newNext ) {
    	next = newNext;
    }
	
} // LinkedNode
