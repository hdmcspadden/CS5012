/**  
 * A reference based implementation of a binary tree.  Javadoc comments 
 * for methods specified in the BinaryTree interface have been omitted.
 *
 * This code assumes that the preconditions stated in the comments are
 * true when a method is invoked and therefore does not check the
 * preconditions.
 */ 
public class LinkedBinaryTree<T> implements BinaryTree<T> {
    private BinaryTreeNode<T> root;    // The root of the tree
    private BinaryTreeNode<T> cursor;  // The current node

    public void toRoot() {
    	cursor = root;
    }

    public boolean hasLeftChild() {
    	return cursor.getLeft() != null;
    }

    public boolean hasRightChild() {
    	return cursor.getRight() != null;
    }

    public boolean hasParent() {
    	return root.findParent( cursor ) != null;
    }

    public boolean isValid() {
    	return cursor != null;
    }

    public void toParent() {
    	cursor = root.findParent( cursor );
    }

    public void toLeftChild() {
    	cursor = cursor.getLeft();
    }

    public void toRightChild() {
    	cursor = cursor.getRight();
    }

    public void insertLeft( T data ) {
    	// Create the node that will hold the data
    	BinaryTreeNode<T> newNode = new BinaryTreeNode<T>( data );

		// If the tree is empty this becomes the only node in the
		// tree, otherwise make the new node the left child of the
		// cursor
		if ( root == null ) {
		    root = newNode;
		}
		else {
		    cursor.setLeft( newNode );
		}
    }
 
    public void insertRight( T data ) {
		// Create the node that will hold the data
		BinaryTreeNode<T> newNode = new BinaryTreeNode<T>( data );
	
		// If the tree is empty this becomes the only node in the
		// tree, otherwise make the new node the left child of the
		// cursor
		if ( root == null ) {
		    root = newNode;
		}
		else {
		    cursor.setRight( newNode );
		}
    }

    public T get() {
    	return cursor.getData();
    }

    public void set( T data ) {
    	cursor.setData( data );
    }

    public void prune() {
		// Are we trying to delete the root node?
		if ( cursor == root ) {
		    // Delete the root and invalidate the cursor
		    root = null;
		    cursor = null;
		} else {
		    // Find the parent of the node to delete
		    BinaryTreeNode<T> parent = root.findParent( cursor );
		    
		    // Is it the parent's left child?
		    if ( parent.getLeft() == cursor ) {
		    	// Delete left child
		    	parent.setLeft( null );
		    } else {
		    	// Delete right child
		    	parent.setRight( null );
		    }
		    
		    // Update the cursor
		    cursor = parent;
		}
    }

    public boolean equals( Object o ) {
		boolean retVal = false;
	
		// We can only do the comparison if the other object is a tree
		if ( o instanceof BinaryTree ) {
		    BinaryTree other = (BinaryTree<?>)o;
		
		    // Start at the top of both trees
		    toRoot();
		    other.toRoot();
	
		    // Use the recursive helper method to do the actual work
		    retVal = equalHelper( other );
	
		    // Reset the iterators
		    toRoot();
		    other.toRoot();
		}
	
		return retVal;
    }
    
    /**
     * Compare the content and structure of this tree to a second
     * binary tree.
     *
     * @param tree the tree to compare this tree with
     *
     * @return true if the content and structure of a given tree is
     *         identical to this tree and false otherwise.
     */

    private boolean equalHelper( BinaryTree<?> tree ) {
		// Handle the case where both trees are empty.  If both
		// trees are empty, they are equal.
		boolean retVal = ( cursor == null && !tree.isValid() );
	
		// If both trees have something in them -- compare them
		if ( cursor != null && tree.isValid() ) {
	
		    // Both nodes should have the same data and both
		    // should have the same type of children
		    retVal = cursor.getData().equals( tree.get() ) &&
				     hasLeftChild() == tree.hasLeftChild() &&
				     hasRightChild() == tree.hasRightChild();
	
		    // If they are equal and have left children - compare them
		    if ( retVal && hasLeftChild() ) {
				toLeftChild();
				tree.toLeftChild();
				retVal = equalHelper( tree );
		
				// Back up the cursors
				toParent();
				tree.toParent();
		    }
	
		    // If they are equal and have right children - compare them
		    if ( retVal && hasRightChild() ) {
				toRightChild();
				tree.toRightChild();
				retVal = retVal && equalHelper( tree );
				
				// Back up the cursors
				toParent();
				tree.toParent();
		    }
		}
	
		return retVal;
    } 
    

    public int size() {
		int size = 0;
	
		// If the root is null, the size of the tree is zero.  Otherwise, the
		// size of the tree is the size of the root node.
		if ( root != null ) {
		    size = root.size();  
		}
	
		return size;
    }

    public int height() { 
		int height = 0;
		// If the root is null, the height of the tree is zero.  Otherwise, the
		// height of the tree is the height of the root node.
		if ( root != null ) {
		    height = root.height();
		}
	
		return height;
    }

    public void find( T key) {
		// If the root is null, there is no node containing the given key.
		// Otherwise, check the tree rooted at the root node.
		if (root != null) {
		    cursor = root.find(key);
		} else {
		    cursor = null;
		}
    }	
        
    public void preOrder( Callback<T> cb ) {
		// Start the traversal at the root node
		if ( root != null ) {
		    root.preOrder( cb ); 
		} 
    }

    public void inOrder( Callback<T> cb ) { 
		// Start the traversal at the root node
		if ( root != null ) {
		    root.inOrder( cb ); 
		}
    }
    
    public void postOrder( Callback<T> cb ) { 
		// Start the traversal at the root node
		if ( root != null ) {
		    root.postOrder( cb ); 
		}
    }
    
    /**
     * Return a string representation of this tree.  The string
     * returned by this method will show the structure of the
     * tree if the string is rotated 90 degrees to the right.
     * 
     * @return a string representation of this tree.
     */
    public String toString() {
		StringBuffer retVal = new StringBuffer();
	
		// Get the string
		treeToString( root, retVal, "" );
	
		// Convert the string buffer to a string
		return retVal.toString();
    }

    /**
     * A recursive method that does a RVL traversal of the tree
     * to create a string that shows the contents and structure of
     * the tree.
     *
     * For a tree that has the following structure:
     *
     *                      A
     *                B           C
     *            D       E
     *
     * This method will return the following string
     *
     *     C
     * A
     *         E
     *     B
     *         D
     */
    private void treeToString( BinaryTreeNode<T> cur, 
			                   StringBuffer str,
			                   String indent ) {

		if ( cur != null ) {
		    // Get the string representation of the right child.  Indent
		    // is increased by 4 since this subtree is one level deeper in
		    // the tree
		    treeToString( cur.getRight(), str, indent + "    " );
	
		    // Convert the information in the current node
		    str.append( indent );
		    str.append( cur.getData().toString() );
		    str.append( "\n" );
	
		    // Get the string representation of the left child.
		    treeToString( cur.getLeft(), str, indent + "    " );
		}
    }
    
}
