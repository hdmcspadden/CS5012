/**  
 * An interface for a heap data structure
 */ 
public interface Heap<T extends Comparable> {
	/**
	 * Adds the given information to the heap.
	 *
	 * Preconditions:  
	 *	data is not null. 
	 *	data is of the same data type as the other nodes in the heap. 
	 *
	 * Postconditions: 
	 *	data has been added to the heap.
	 *	The heap property has been preserved.
	 * 
	 * @param data the information to be added
	 */
	public void insertHeapNode( T info );

	/**
	 * Remove and return the smallest element in the heap
	 * 
	 * Preconditions:  
	 *	The heap is not empty. 
	 *
	 * Postconditions: 
	 *	The element has been removed.
	 *
	 * @return the smallest value in the heap
	 */	
	public T getSmallest();

	/**
	 * Determine whether the heap is empty.
	 * 
	 * @return true if the heap is empty, false otherwise
	 * 
	 * Preconditions:  
	 *	None
	 * 
	 * Postconditions: 
	 *	The heap is unchanged.
	 *
	 * @return true if the heap is empty and false otherwise
	 */
	public boolean empty();

} // Heap
