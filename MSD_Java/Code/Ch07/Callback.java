/**
 * A callback object specifies what should be done when one of the
 * traversal methods "visits" a node.
 */
public interface Callback<T> {
    /**
     * Called when a node is visited during a traversal.
     *
     * @param T the data contained in the node being visited.
     */
    public void visit( T data );

} // Callback
