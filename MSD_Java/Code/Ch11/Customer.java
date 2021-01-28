import java.util.Random;

/**
 * A simple example to demonstrate the use of notifyAll() in
 * java.  This program simulates a number of customers who
 * wish to check out of a store.  An instance of a cashier is
 * used to control the order in which customers are serviced.
 */
public class Customer extends Thread {
    public static int MAX_ITEMS = 25; // Maximum items a customer may buy
    private int id;                   // This customers id
    private int numItems;             // Number of items bought
    private Cashier register;         // The only register in the store

    /**
     * Create a new customer with the specified id, wishing to
     * go through the specified register.
     *
     * @param id this customer's id
     * @param register the cashier who will service this customer
     */
    public Customer( int id, Cashier register ) {
	// Record state
	this.id = id;
	this.register = register;

	// Randomly determine the number of items ( between 1 and MAX_ITEMS)
	numItems = new Random().nextInt( MAX_ITEMS ) + 1;

	// Indiciate that a customer has been created
	System.out.println( "Customer " + 
			    id + 
			    " has " + 
			    numItems + 
			    " items." );
    }

    /**
     * This method simulates the behavior of a customer.  The
     * customer requests to move to the head of the line.  Once
     * there checks out, and then leaves the line.
     */
    public void run() {
	// Move to the head of the line
	register.readyToCheckOut();
	System.out.println( "Customer " + id + " is checking out" );

	// I have the cashier so -- check out
	try {
	    sleep( 500 );
	}
	catch ( InterruptedException e ) {}

	// Thats it
	System.out.println( "Customer " + id + " has finished checking out" );
	register.done();
    }

    /**
     * Return the id associated with this customer.
     *
     * @return the customer's id
     */
    public int getCustomerId() {
	return id;
    }

    /**
     * Return the number of items this customer wishes to purchase.
     *
     * @return the number of items being purchased by this customer.
     */
    public int getNumItems() {
	return numItems;
    }

} // Customer
