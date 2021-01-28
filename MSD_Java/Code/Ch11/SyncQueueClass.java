/**
 * A thread safe queue class.
 */

public class SyncQueueClass {
    // Instance variables go here

    public void enqueue( Object item ) {
	synchronized ( SyncQueueClass ) {
	    // Code to enqueue goes here
	}
    }

    public Object dequeue() {
	synchronized ( SyncQueueClass ) {
	    // Code to dequeue goes here
	}
    }

} // SyncQueueClass
