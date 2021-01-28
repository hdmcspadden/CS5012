/**  
 * A simple array-based implemenation of the Heap ADT.
 */ 

public class ArrayBasedHeap<T extends Comparable> implements Heap<T> {
    // Initial size of the heap
    private static final int INITIAL_SIZE = 32;

    private T heapForm[];  // The heap
    private int size;      // Number of elements in the heap
   
    /**
     * Create a new heap.
     */
    public ArrayBasedHeap() { 
	heapForm = (T[]) new Comparable[ INITIAL_SIZE ]; 
	size = 0;
    }
	
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
    public void insertHeapNode( T data ) {
	// Is there room in the heap for another element?
	if ( size == heapForm.length ) {
	    // No - resize the heap
	    expandHeap();
	}
	
	heapForm[ size ] = data;  // Put new data into the heap
	size = size + 1;          // One more element in the heap

	interchangeUp();          // Ensure that the ordering property
	                          // of the heap holds after the item
	                          // has been inserted
    }
    
    /**
     * Ensure that the ordering property of the heap holds after
     * the insertion of an new element into the heap.
     */
    private void interchangeUp() {
	int cur = size - 1;            // Location of last item added
	int parent = ( cur - 1 ) / 2;  // Parent of the new item

	// We only need to check heaps with more than 1 element
	if ( size > 1 ) {

	    // Walk up the heap until you reach the top or stop finding
	    // values that are out of place
	    while ( parent >= 0 && 
		    heapForm[ cur ].compareTo( heapForm[ parent ] ) < 0 ) {
		// Swap the parent and child values
		swap( parent, cur );

		// Move up one level in the heap
		cur = parent;
		parent = ( cur - 1 ) / 2;
	    }
	}
    }

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
    public T getSmallest() {
	// The smallest element is always the root
	T smallest = heapForm[ 0 ];
	
	// One less itme in the heap
	size = size - 1;

	// Replace the smallest (root) node with the largest (last) node
	heapForm[ 0 ] = heapForm[ size ];
	heapForm[ size ] = null;

	// Ensure that the ordering property holds
	interchangeDown();

	return smallest;
    }
    
    /**
     * Make sure the ordering property holds after removing the
     * smallest element from the heap.
     */
    private void interchangeDown() {
	int parent = 0;	       // Parent position
	int left;              // Left child
	int right;             // Right child

	int minPos;            // Position of the smallest child
	Comparable minValue;   // Value of the smallest child

	boolean continueScan;  // When true heap is ordered
	
	// Only need to look if the heap size is greater than 1
	if ( size > 1 ) {
	    do {
		left = parent * 2 + 1;
		right = parent * 2 + 2;

		continueScan = false;

		if ( left < size ) {
		    // I have at least one child

		    if ( right < size ) {
			// I have two children - figure out which is
			// the minimum
			if ( heapForm[left].compareTo(heapForm[right]) < 0 ) {
			    // Left is the smallest
			    minValue = heapForm[ left ];
			    minPos = left;
			}
			else {
			    // Right is the smallest
			    minValue = heapForm[ right ];
			    minPos = right;
			}

			// If the parent is larger than the smallest child
			// swap them and continue scan
			if ( heapForm[ parent ].compareTo( minValue ) > 0 ) {
			    swap( parent, minPos );
			    parent = minPos;
			    continueScan = true;
			}
		    }
		    else {
			// Only one child (must be the smaller) - is the
			// parent larger than the left child?
			if (heapForm[parent].compareTo(heapForm[left] ) > 0) {
			    // Yes - swap them
			    swap( parent, left );
			    parent = left;
			    continueScan = true;
			}
		    }
		}
	    } while ( continueScan );
	}
    }

    /**
     * Swap two elements in the heap.
     *
     * @param pos1 the position of the first element.
     * @param pos2 the position of the second element.
     */
    private void swap( int pos1, int pos2 ) {
	T temp = heapForm[ pos1 ];
	heapForm[ pos1 ] = heapForm[ pos2 ];
	heapForm[ pos2 ] = temp;
    }

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
    public boolean empty() {
	return size == 0;
    }
    
    /**
     * Double the size of the array used to hold the heap.
     */
    private void expandHeap() {
	// Create a bigger array to hold the heap
	T newHeap[] = (T[]) new Comparable[ heapForm.length * 2 ];

	// Copy the elements over from the existing heap
	for ( int i = 0; i < size; i = i + 1 ) {
	    newHeap[ i ] = heapForm[ i ];
	}

	// Use the bigger heap
	heapForm = newHeap;
    }

} // ArrayBasedHeap
