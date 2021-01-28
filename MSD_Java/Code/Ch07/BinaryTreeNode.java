/**  
 * A node for use in binary trees.
 */ 
public class BinaryTreeNode<T> {
    private BinaryTreeNode<T> left;   // The left child
    private BinaryTreeNode<T> right;  // The right child
    private T data;           // The data in this node 

    /**
     * Create a new node.
     */
    public BinaryTreeNode() {
    	this( null, null, null );
    }

    /**
     * Create a new node containing the specified data.
     *
     * @param theData the data to place in this node.
     */
    public BinaryTreeNode( T theData ) {
    	this( theData, null, null );
    }

    /**
     * Create a new node with the specified data and children.
     *
     * @param theData the data to place in this node.
     * @param leftChild the left child.
     * @param rightChild the right child.
     */
    public BinaryTreeNode( T theData, BinaryTreeNode<T> leftChild,
	                       BinaryTreeNode<T> rightChild ) {
	    data = theData;
	    left = leftChild;
	    right = rightChild;
    }

    /**
     * Returns the data stored in this node.
     * 
     * Preconditions:  
     *   None
     * 
     * Postconditions: 
     * 	 This node is unchanged.
     * 
     * @return the data stored in this node.
     */
    public T getData() {
        return data;
    }
	
    /**
     * Returns a reference to the left child.
     *
     * Preconditions:  
     *   None
     * 
     * Postconditions: 
     * 	 This node is unchanged.
     *
     * @return a reference to this node's left child.
     */
    public BinaryTreeNode<T> getLeft() {
	    return left;
    } 
    
    /**
     * Returns a reference to the right child.
     *
     * Preconditions:  
     *   None
     * 
     * Postconditions: 
     * 	 This node is unchanged.
     *
     * @return a reference to this node's right child.
     */
    public BinaryTreeNode<T> getRight() {
        return right;
    }
    
    /**
     * Sets this node's left child to the given node.
     *  
     * Preconditions:  
     *   None
     * 
     * Postconditions: 
     * 	 This node's left subchild has been changed to the given node.
     *
     * @param newLeft the node to become this node's left child.
     */
    public void setLeft( BinaryTreeNode<T> newLeft ) {
        left = newLeft;
    }

    /**
     * Sets this node's right child to the given node.
     *
     * Preconditions:  
     *   None
     * 
     * Postconditions: 
     * 	 This node's right subchild has been changed to the given node.
     *
     * @param newRight the node to become this node's left child.
     */
    public void setRight( BinaryTreeNode<T> newRight ) {
        right = newRight;
    }

    /**
     * Sets the data field of the current node
     *  
     * Preconditions:  
     *   None
     * 
     * Postconditions: 
     * 	 This node's data field has been updated.
     *
     * @param newData Node to become this node's right child.
     */
    public void setData( T newData ) {
        data = newData;
    }

    /**
     * Performs an inorder traversal of the BinaryTree rooted at this node.
     * Each visited node is visited with the given callback.
     *
     * Preconditions:
     *	 cb is not null
     *
     * Postconditions: 
     *	 All nodes in the tree have been visited by the given
     *	   callback in the specified order.
     *
     * @param cb the callback object used to process nodes.
     */
    public void inOrder( Callback<T> cb ) {
        // First we visit the left subtree, if any
        if ( left != null ) { 
            left.inOrder( cb ); 
        }
        
        // Then we visit this node
	    cb.visit(data);
		
        // Last we visit the right subtree, if any
        if ( right != null ) {
            right.inOrder( cb );
        }
    }
	
    /**
     * Performs a preorder traversal of the BinaryTree rooted at this node.
     * Each visited node is visited with the given callback.
     *
     * Preconditions:
     *	 cb is not null
     *
     * Postconditions: 
     *	 All nodes in the tree have been visited by the given
     *	   callback in the specified order.
     *
     * @param cb the callback object used to process nodes.
     */
    public void preOrder( Callback<T> cb ) {
        // First we visit the current node
	    cb.visit( data );
	
        // Then we visit our left subtree, if any
	    if ( left != null )  {
            left.preOrder( cb );
        }
	
        // Last we visit our right subtree, if any
	    if ( right != null ) {
            right.preOrder( cb );
        }
    }

    /**
     * Performs a postorder traversal of the BinaryTree rooted at this node.
     * Each visited node is visited with the given callback.
     *
     * Preconditions:
     *	 cb is not null
     *
     * Postconditions: 
     *	 All nodes in the tree have been visited by the given
     *	   callback in the specified order.
     *
     * @param cb the callback object used to process nodes.
     */
    public void postOrder( Callback<T> cb ) {
        // First we visit our left subtree, if any
    	if ( left != null ) {
            left.postOrder( cb );
        }
	
        // Then we visit our right subtree, if any
    	if ( right != null ) {
            right.postOrder( cb );
        }
	
        // Last we visit this node
        cb.visit( data );
    }

    /**
     * Returns the height of the tree rooted at this node.
     *
     * Preconditions:
     *   None
     *
     * Postconditions:
     *   The tree rooted at this node is unchanged.
     *
     * @return the height of this tree.
     */
    public int height() {
		int leftHeight = 0;   // Height of the left subtree
		int rightHeight = 0;  // Height of the right subtree
		int height = 0;       // The height of this subtree
	
		// If we have a left subtree, determine its height
		if ( left != null )  {
		    leftHeight = left.height();
		}
	
		// If we have a right subtree, determine its height
		if ( right != null )  {
		    rightHeight = right.height();
		}
	
	        // The height of the tree rooted at this node is one more than the
	        // height of the 'taller' of its children.
		if (leftHeight > rightHeight) {
		    height = 1 + leftHeight;
		} else {
		    height = 1 + rightHeight;
		}
	
		// Return the answer
		return height;
    }

    /**
     * Returns the number of nodes in this tree. 
     *
     * Preconditions:
     *  None
     *
     * Postconditions
     *  The tree rooted at this node is unchanged
     *
     * @return the number of nodes in this tree.
     */
    public int size() {
        int size = 0;  // The size of the tree

        // The size of the tree rooted at this node is one more than the 
        // sum of the sizes of its children.
        if ( left != null ) {
        	size = size + left.size();
        }
		
		if ( right != null ) {
		    size = size + right.size();
		}
        
		return size + 1;
    }

    /**
     * Position the cursor on the first (as seen by an inorder traversal) 
     * occurrence of the given data.  Equality is determined by invoking
     * the equals method.
     * 
     * Preconditions:  
     * 	 Key is not null
     *
     * Postconditions: 
     *   The tree is unchanged.
     *   If key is found, cursor refers to the first occurrence of
     *     the key.  If key is not found, the cursor is off the tree
     *
     * @param target object containing the data to be searched for.
     */
    public BinaryTreeNode<T> find( T target ) {
    	BinaryTreeNode<T> location = null;  // The node that contains the target

        // Is the target in the left subtree?
		if ( left != null ) {
		    location = left.find( target );
		}
	
	    // If we haven't found it, is it in this node?
		if (location == null && target.equals( data ) ) {
		    location = this;
	    }
	
	    // If we haven't found it, and we have a right child, check there
		if ( location == null && right != null ){	
		    location = right.find( target );
	    }
	
		// Return the location of the target
		return location;
    }

    /**
     * Locate the parent of the given node looking in the tree whose
     * root is this node.
     *
     * Preconditions:
     *  target is not null
     *
     * Postconditions:
     *  The tree rooted at this node is unchanged.
     *
     * @param target the node whose parent is to be located.
     *
     * @return the parent of the given node.
     */
    public BinaryTreeNode<T> findParent( BinaryTreeNode<T> target ) {
		BinaryTreeNode<T> parent = null;
	        
		// Are we parent to the target node?
		if ( left == target || right == target ) {
		    parent = this;					
	    }
	
		// If we have not found the parent, check the left subtree
		if ( parent == null && left != null ) {
		    parent = left.findParent( target );
		}
	
		// If we have not found the parent, check the right subtree
		if ( parent == null && right != null ) {
		    parent = right.findParent( target );
		}
	
		// Return the parent
		return parent;
    }

    /**
     * Return a string representation of this node.
     *
     * @return a string representation of this node.
     */
    public String toString() {
    	return data.toString();
    }

} 
