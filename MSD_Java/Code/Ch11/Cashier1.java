/**
 * A cashier class that shows how to use java synchronization
 * primitives to gain access to a cashier.
 */
public class Cashier1 implements Cashier {
    private boolean busy = false;  // Is the cashier busy?

    /**
     * Invoked by a customer when they are ready to check out.
     * Contains the logic required to select the one customer
     * that the cashier will service.  If the cashier is already
     * serving another customer, this customer will wait until
     * the other customer has finished with the cashier.
     */
    public synchronized void readyToCheckOut() {
	// While the cashier is busy -- wait
	while ( busy ) {
	    try {
		wait();
	    }
	    catch (InterruptedException e ){}
	}

	// Move to the head of the line
	busy = true;
    }

    /**
     * Invoked by a customer when they are finished with the
     * cashier.  If customers are waiting for the cashier,
     * one of them will be selected to move tot the head of
     * the line.
     */
    public synchronized void done() {
	if ( busy ) {

	    // The cashier is no longer busy
	    busy = false;

	    // Let someone move to the head of the line
	    notifyAll();
	}
    }

} // Cashier1
