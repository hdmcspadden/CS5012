/**
 * An implementation of a buffer that can lead to deadlock.
 */
public class DeadlockBuffer implements Buffer {
    private int currentItem;  // Item currently in the buffer
    private boolean full;     // Is the buffer full?

    /**
     * Create a new buffer.
     */
    public DeadlockBuffer() {
	full = false;
    }

    /**
     * Add an element to the buffer.  If the buffer is full,
     * the method will block until the item can be placed in
     * the buffer.
     *
     * @param item the element to add to the buffer.
     */
    public synchronized void add( int item ) {
	// Wait until there is room in the buffer for the item
	while ( full );

	currentItem = item;
	full = true;
    }

    /**
     * Remove an element from the buffer.  If the buffer is empty,
     * the method will block until an item is available.
     *
     * @returns the next item in the buffer.
     */
    public int remove() {
	// Wait until there is something to remove
	while ( !full );

	full = false;
	return currentItem;
    }

} // DeadlockBuffer
