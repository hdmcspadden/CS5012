
/**  
 * This is a simple circular linked list class.  Some methods have different
 * semantics to restrict this class' behaviors to more closely match those of
 * the ADT.
 */ 
public class CircularLinkedList<T> extends LinkedList<T> {
    /** 
     * Move the cursor to the next element in the list.
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
        // If the cursor is at the end of the list, wrap around to the
    	// head of the list, otherwise advance the cursor as usual
        if ( cursor == last ) {
            cursor = head;
        }
        else {
            super.next();
        }
    }

    /** 
     * Move the cursor to the previous node in the list.
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
    	// If the cursor is at the front of the list wrap around to the
        // end of the list, otherwise go backwards as usual
    	if (cursor == head) {
    	    cursor = last;
    	}
    	else {
    	    super.previous();
    	}
    }

}
