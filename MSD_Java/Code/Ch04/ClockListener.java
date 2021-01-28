/**
 * Simluation objects that implement this interface are interested
 * in being notified when the time recorded by a clock changes.
 *
 * There are two methods defined in this interface.  The preEvent()
 * method will be invoked before an event is about to take place.
 * The purpose of this method is to provide a simulation object
 * with the opportunity to update its state before the next event
 * takes place.  For example, a room may wish to calculate the change
 * in room temperature that occurred since the last event.
 *
 * The event() method indicates that an event has taken place.
 */

public interface ClockListener {

    /**
     * This method is called before the next event occurs so that
     * a simulation object can update it state based on what has
     * occurred since the last event.  A simulation object will not
     * change its state when this method is called.  It prepares itself
     * for the state change that will occur when the next event occurs.
     *
     * @param interval the number of seconds that have elapsed since
     *        the last event (i.e., the length of the interval
     *        between events).
     */
    public void preEvent( double interval );

    /**
     * Called when the next event occurs in the simulation.
     */
    public void event();

}
