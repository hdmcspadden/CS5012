/**
 * An implementation of the producer/consumer buffer
 * that uses simple synchronization.
 */
public class SyncBuffer implements Buffer {
    private int currentItem;  // Item currently in the buffer
    private boolean full;     // Is the buffer full?

    /**
     * Create a new buffer.
     */
    public SyncBuffer() {
	full = false;
    }

    /**
     * Add an element to the buffer.  If the buffer is full,
     * the method will block until the item can be placed in
     * the buffer.
     *
     * @param item the element to add to the buffer.
     */
    public void add( int item ) {
	boolean added = false;

	while ( !added ) {
	    synchronized( this ) {
		if ( !full ) {
		    currentItem = item;
		    full = true;
		    added = true;

		}
	    }

	    Thread.yield();
	}
    }

    /**
     * Remove an element from the buffer.  If the buffer is empty,
     * the method will block until an item is available.
     *
     * @returns the next item in the buffer.
     */
    public int remove() {
	int retval = 0;
	boolean removed = false;

	while ( !removed ) {
	    synchronized( this ) {
		if ( full ) {
		    retval = currentItem;
		    full = false;
		    removed = true;
		}
	    }

	    Thread.yield();
	}

	return retval;
    }

} // SyncBuffer
