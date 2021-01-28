/**
 * A buffer that can serve as a connection between a
 * producer and a consumer.
 */
public interface Buffer {
    /**
     * Add an element to the buffer.  If the buffer is full,
     * the method will block until the item can be placed in
     * the buffer.
     *
     * @param item the element to add to the buffer.
     */
    public void add( int item );

    /**
     * Remove an element from the buffer.  If the buffer is empty,
     * the method will block until an item is available.
     *
     * @returns the next item in the buffer.
     */
    public int remove();

} // Buffer
