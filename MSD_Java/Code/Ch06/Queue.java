
/**  
 * An interface for the a Queue
 */ 
public interface Queue<T> {

    /**
     * Places the given object at the back of the queue
     * 
     * Preconditions:  
     * 	The queue is not full.
     * 
     * Postconditions: 
     * 	Data has been added to the back of queue
     * 	The size of the queue has increased by one
     * 	No other structure of the queue has changed.
     *
     * @param data the object to place in the queue.
     *
     */ 
    public void enqueue( T data );
	
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
    public void dequeue();

    /**
     * Return the element at the front of the queue
     *
     * Preconditions:  
     * 	The queue is not empty.
     *
     * Postconditions: 
     * 	The queue is unchanged.
     *
     * @return the element currently at the front of the queue.
     */	
    public T front();
	
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
    public T back();

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
    public boolean empty();

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
    public boolean full();

} 
