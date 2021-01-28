
/**  
 * A linkable-node class suitable for building prioritized linked data
 * structures such as lists, stacks, and queues.  
 */ 
public class PrioritizedLinkedNode<T> {
    private int priority;                // This node's priority
    private T data;                 // The data stored in this node
    private PrioritizedLinkedNode<T> next;  // The next node in the data structure
    
    /**
     * Construct a node given the info and next references.
     *
     * @param newData the data to be associated with this node.
     * @param newNext a reference to the next node in the list.
     */
    public PrioritizedLinkedNode( T newData, int p ) {
    	data = newData;
    	priority = p;
    	next = null;
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
    public PrioritizedLinkedNode<T> getNext() {
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
    public void setNext( PrioritizedLinkedNode<T> newNext ) {
    	next = newNext;
    }

    /**
     *
     * setPriority() changes the priority of this node.  
     * 
     * Preconditions:  
     * 	None
     *
     * Postconditions: 
     * 	Node's priority has been updated.
     * 
     * @param p this datum's priority
     *
     */ 
    public void setPriority(int p) {
        priority = p;
    }

    /**
     *
     * getPriority() returns the priority of this node
     * 
     * Preconditions:  
     * 	None
     *
     * Postconditions:
     * 	Node is unchanged.
     *
     * @return priority of this node
     *
     */ 
    public int getPriority() { 
        return priority; 
    }

}
