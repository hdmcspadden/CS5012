
/**  
 * A simple prioritized linked queue.  This class assumes that priorities are
 * nonnegative integers, with 0 being the highest priority.
 */ 
public class LinkedPriorityQueue<T> implements Queue<T> {

    /**
     * Minimum priority.
     */
    public static final int MIN_PRIORITY = 0;

    private PrioritizedLinkedNode<T> front;  // Front of the queue
    private PrioritizedLinkedNode<T> back;	  // Back of the queue
    private int size;                     // Number of elements in the queue

    /**
     *  Create a new priority queue.
     */
    public LinkedPriorityQueue() {
    	// Initialize state
    	front = null;
    	back = null;
    	size = 0;
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

    /**
     * Add an element to the queue.  The item is added with
     * minimum priority.  This method must be provided to
     * satisfy the Queue interface.
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
        // Let the other enqueue method do the work.
        enqueue( data, 0 );
    }

    /*
     * Add an element to the queue with the given priority.
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
     * @param priority the priority of this item.
     */ 
    public void enqueue( T data, int priority ) {
        PrioritizedLinkedNode<T> cur = front;  // The current node
        PrioritizedLinkedNode<T> prev = null;  // The last node visited

    	// The node this item will be placed in
    	PrioritizedLinkedNode<T> newNode = 
	    new PrioritizedLinkedNode<T>( data, priority );

    	// Adding to an empty queue is easy
    	if ( back == null ) {
    	    front = newNode;
    	    back = newNode;
    	}
    	else {
    	    // Step through the queue looking for the first node with
    	    // a priority less than the priority of the new node.
    	    // When the loop has terminated cur will refer to the
    	    // node after the new node in the queue and prev will
    	    // refer to the node before the new node.
    	    while ( cur != null && cur.getPriority() >= priority ) {
    		prev = cur;
    		cur = cur.getNext();
    	    }

    	    if ( cur == null ) {
    	        // Item must be added at the end of the queue
    	        back.setNext( newNode );
    	        back = newNode;
    	    }
    	    else if ( prev == null ) {
    	        // Item must be added to the front of the queue
    	        newNode.setNext( front );
    	        front = newNode;
    	    }
    	    else {
    	        // Insert between prev and cur
    	        prev.setNext( newNode );
    	        newNode.setNext( cur );
    	    }
    	}

    	// One more item in the queue
    	size = size + 1;
    }
} 
