/**
 * An implementation of the producer/consumer buffer
 * that uses wait/notify.
 */
public class MonitorBuffer implements Buffer {
    private int currentItem;  // Item currently in the buffer
    private boolean full;     // Is the buffer full?

    /**
     * Create a new buffer.
     */
    public MonitorBuffer() {
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
	// If the buffer is full, wait until the consumer has removed
	// the element currently in the buffer.

	if ( full ) {
	    try {
		wait();
	    }
	    catch ( InterruptedException e ) {};
	}

	// Place the item in the buffer
	currentItem = item;
	full = true;

	// There might be a consumer waiting for an element to consume
	notify();
    }

    /**
     * Remove an element from the buffer.  If the buffer is empty,
     * the method will block until an item is available.
     *
     * @returns the next item in the buffer.
     */
    public synchronized int remove() {
	int retval;

	// If the buffer is empty, wait until notified by the producer
	// that there is something to consume.
	if ( !full ) {
	    try {
		wait();
	    }
	    catch ( InterruptedException e ) {};
	}

	// Remove the current element
	retval = currentItem;
	full = false;

	// There might be a producer waiting to produce.
	notify();

	// Return the item
	return retval;
    }

} // MonitorBuffer
