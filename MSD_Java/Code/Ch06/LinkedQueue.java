
/**  
 * A linked list implementation of a queue.
 */ 
public class LinkedQueue<T> implements Queue<T> {

    protected LinkedNode<T> front;  // The first node in the queue
    protected LinkedNode<T> back;   // The last node in the queue
    protected int size;          // The number of elements in the queue

    /**
     * Constructs a LinkedQueue
     */
    public LinkedQueue() {
    	// Initialize state
    	size = 0;
    	front = null;
    	back = null;
    }

    /**
     * Places the given object at the back of the queue
     * 
     * Preconditions:  
     * 	The queue is not full.
     * 
     * Postconditions: 
     * 	The value V has been added to the back of queue
     * 	The size of the queue has increased by one
     * 	No other structure of the queue has changed.
     *
     * @param data  Object to put into the queue
     */ 
    public void enqueue( T data ) {
    	// Initialize a new node
    	LinkedNode<T> newNode = new LinkedNode<T>( data, null );
    
    	// Is the queue empty?
    	if ( empty() ) {
    	    // The new node is also the front of the queue
            front = newNode;
    	}
    	else {
    	    // Make the last thing in the queue refer
    	    // to the new element
    	    back.setNext( newNode );
    	}
    
    	// Back should refer to the new node
    	back = newNode;
    
    	// One more element in the queue
    	size = size + 1;
    }

    /**
     * Remove the item at the front of the queue.
     * 
     * Preconditions:  
     *	The queue is not empty.
     * 
     * Postconditions: 
     * 	The size of the queue has decreased by one.
     * 	The first item of the queue has been removed.
     * 	No other structure of the queue has changed.
     */	    
    public void dequeue() {
        // Remove the front element
    	front = front.getNext();	
            
    	// Queue is empty - back should not refer to anything
    	if (front == null) {
            back = null;	
        }
    
        // One less item in the queue
    	size = size - 1;				
    }

    /**
     * Return the item at the front of the queue.
     *
     * Preconditions:  
     * 	The queue is not empty.
     *
     * Postconditions: 
     * 	The queue is unchanged.
     *
     * @return the item at the front of the queue.
     */	
    public T front()  {
        return front.getData();		
    }
	
    /**
     * Return the item at the back of the queue.
     *
     * Preconditions:  
     * 	The queue is not empty.
     * 
     * Postconditions: 
     * 	The queue is unchanged.
     *
     * @return the item at the back of the queue.
     */	
    public T back() {
        return back.getData();	
    }

    /**
     * Determine if the queue is empty
     * 
     * Preconditions:  
     *	None
     *
     * Postconditions: 
     * 	The queue is unchanged.
     *
     * @return true if the queue is empty and false otherwise.
     */	
    public boolean empty() {
        return size == 0;
    }

    /**
     * Determine if the queue is full.
     * 
     * Preconditions:  
     * 	None
     * 
     * Postconditions: 
     * 	The queue is unchanged.
     *
     * @return true if the queue is full and flse otherwise.
     */	
    public boolean full() {
        // Linked structures are never full
        return false;
    } 

}
