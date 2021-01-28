/**
 * Specifications for a node in a binary search tree.
 */
public class BinarySearchTreeNode<T extends Comparable> {
    T data;                         // Data stored in this node
    BinarySearchTreeNode<T> left;   // Left child
    BinarySearchTreeNode<T> right;  // Right child

    /**
     * Create a new node.
     */
    public BinarySearchTreeNode() {
    	this( null );
    }

    /**
     * Create a new node that contains the specified element.
     *
     * @param element the element to place in the node.
     */
    public BinarySearchTreeNode( T element ) {
	data = element;
	left = null;
	right = null;
    }

    /**
     * Get the data stored in this node.
     *
     * @return the data stored in this node.
     */
    public T getData() {
    	return data;
    }

    /**
     * Get a reference to the left child of this node.
     *
     * @return a reference to the left child of this node.
     */
    public BinarySearchTreeNode<T> getLeft() {
    	return left;
    }

    /**
     * Get a reference to the right child of this node.
     *
     * @return a reference to the right child of this node.
     */
    public BinarySearchTreeNode<T> getRight() {
    	return right;
    }

    /**
     * Set the data to the specified value.
     *
     * @param newData a reference to the data to place in this node.
     */
    public void setData( T newData ) {
    	data = newData;
    }

    /**
     * Set the left child of this node.
     *
     * @param newLeft a reference to the left child of this node.
     */
    public void setLeft( BinarySearchTreeNode<T> newLeft ) {
    	left = newLeft;
    }

    /**
     * Set the right child of this noce.
     *
     * @param newRight a reference to the right child of this node.
     */
    public void setRight( BinarySearchTreeNode<T> newRight ) {
    	right = newRight;
    }

} // BinarySearchTreeNode

