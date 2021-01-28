/**
 * A cashier that gives priority access to customers that have
 * ten items or less.
 */
public class Cashier2 implements Cashier {
    private boolean busy = false;  // Is the cashier busy?
    private int tenOrLess = 0;     // Customers with 10 or fewer items

    /**
     * Invoked by a customer when they are ready to check out.
     * Contains the logic required to select the one customer
     * that the cashier will service.  If the cashier is already
     * serving another customer, this customer will wait until
     * the other customer has finished with the cashier.  Customers
     * with 10 or fewer items will be allowed to move ahead of the
     * other customers.
     */
    public synchronized void readyToCheckOut() {
	// Get a reference to the customer executing this code and find
	// out how many items they have
	Customer me = (Customer)Thread.currentThread();
	int items = me.getNumItems();

	// Make a note if they have 10 or less items
	if ( items <= 10 ) tenOrLess++;

	// As long as the cashier is busy, or there is someone in line
	// that has 10 or less items and I have more than 10 items, wait.

	while ( busy || tenOrLess > 0 && items > 10 )
	    try {
		wait();
	    }
	    catch (InterruptedException e ){}

	// My chance to get out of this store!!
	busy = true;
    }
 
    /**
     * Invoked by a customer when they are finished with the
     * cashier.  If customers are waiting for the cashier,
     * customers with 10 or fewer items will be allowed to get
     * to the head of the line before the other customers.
     */
    public synchronized void done() {
	if ( busy ) {
	    // Get a reference to the current customer
	    Customer me = (Customer)Thread.currentThread();

	    // If they had 10 or less items, they have been taken care of
	    if ( me.getNumItems() <= 10 ) tenOrLess--;

	    // The cashier is no longer busy
	    busy = false;

	    // Let someone else move to the head of the line.
	    notifyAll();
	}
    }

} // Cashier2
