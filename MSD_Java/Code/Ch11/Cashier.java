/**
 * A cashier at a supermarket.  When customers are ready to check out
 * they invoke readyToCheckOut().  The cashier will then determine which
 * customer it wil service.  When the current customer has finished
 * checking out it will invoke done().
 */
public interface Cashier {
    /**
     * Invoked by a customer when they are ready to check out.
     * Contains the logic required to select the one customer
     * that the cashier will service.  If the cashier is already
     * serving another customer, this customer will wait until
     * the other customer has finished with the cashier.
     */
    public void readyToCheckOut();

    /**
     * Invoked by a customer when they are finished with the
     * cashier.  If customers are waiting for the cashier,
     * one of the waiting customers will be selected and
     * serviced by the cashier.
     */
    public void done();

} // Cashier
