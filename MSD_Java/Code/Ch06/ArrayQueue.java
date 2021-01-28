
/**  
 * An implementation of a queue using circular arrays
 */ 
public class ArrayQueue<T> implements Queue<T> {

    // The size of the array
    public static final int MAX_SIZE = 100;

    private T theQueue[];  // The queue
    private int front, back;    // Front and back positions in the queue
    private int size;	        // Number of elements in the queue

    /**
     * Create a new queue.
     */
    public ArrayQueue() {	
    	// Create the array that will be the queue
    	theQueue = (T[])new Object[ MAX_SIZE ];
    
    	// Initialize state
    
    	size = 0;						
    	front = 0;
    	back = -1;
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
     * @param data the object to place in the queue.
     */ 
    public void enqueue( T data ) {
    	// Determine where the new element will be placed
    	back = ( back + 1 ) % MAX_SIZE;
    
    	// Add the element
    	theQueue[ back ] = data;
    
    	// One more thing in the queue
    	size = size + 1;
    }

    /**
     *
     * Removes the element at the front of the queue.
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
    	// Eliminate reference for garbage collection
    	theQueue[ front ] = null;
    
    	// Remove the first element by incrementing the location
    	// of the first element
    	front = ( front + 1 ) % MAX_SIZE;
    
    	// There is now one less element in the queue
    	size = size - 1;
    }

    /**
     * Return the element at the front of the queue
     *
     * @return the element at the front of the queue
     * 
     * Preconditions:  
     * 	The queue is not empty.
     *
     * Postconditions: 
     * 	The queue is unchanged.
     *
     * @return the element currently at the front of the queue.
     */	
    public T front() {
        return theQueue[ front ];
    }

    /**
     * Return the element at the back of the queue
     *
     * Preconditions:  
     * 	The queue is not empty.
     * 
     * Postconditions: 
     * 	The queue is unchanged.
     *
     * @return the element at the back of the queue.
     */	
    public T back() {
        return theQueue[ back ];
    }

    /**
     * Determine if the queue is empty.
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
     * @return true if the queue is full and false otherwise.
     */	
    public boolean full() {
        return size == MAX_SIZE;
    }

}
