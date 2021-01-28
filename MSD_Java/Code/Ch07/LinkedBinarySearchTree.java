/**  
 * A linked list-based binary search tree implementation.
 */
public class LinkedBinarySearchTree<T extends Comparable> 
    implements BinarySearchTree<T> {

    private BinarySearchTreeNode<T> root;  // the root of the tree

    /**
     * Inserts the given data into the correct position within the tree.
     *
     * Preconditions:
     *   The data to be added is not equal to any 
     *     data currently in the tree.
     *
     * Postconditions:
     *   The size of the tree has increased by one.
     *   The element added is in the correct position within the tree.
     *
     * @param data the data to insert into the tree.
     */	
    public void insert( T data ) {
	BinarySearchTreeNode<T> cur = root;
	BinarySearchTreeNode<T> newNode = new BinarySearchTreeNode<T>( data );
	
	if ( root == null ) {
	    root = newNode;
	}
	else {
	    while ( cur != null ) {
		int compare = data.compareTo( cur.getData() );
		
		if ( compare < 0 ) {
		    // The new element is less than the current element
		    if ( cur.getLeft() == null ) {
			// There is no left child so insert data here
			cur.setLeft( newNode );
			cur = null;
		    }
		    else {
			// There is a left child - insert into it
			cur = cur.getLeft();
		    }
		}
		else if ( compare > 0 ) {
		    // The new element is greater than the current element
		    if ( cur.getRight() == null ) {
			// There is no right child so insert data here
			cur.setRight( newNode );
			cur = null;
		    }
		    else {
			// There is a right child - insert into it
			cur = cur.getRight();
		    }
		}
		else {
		    // The new element is already in the tree - do not add
		    cur = null;
		}
	    }
	}
    }

    /**
     * Determine the size of the tree.
     *
     * Preconditions:
     *   None
     *
     * Postconditions:
     *   The tree is unchanged.
     *
     * @return the number of elements in the tree.
     */
    public int size() {
	int size = 0;
	
	// If there is a tree determine the size of it
	if (root != null) {
	    size = size( root );
	}
	
	return size;
    }

    /**
     * Determine the size of the tree with the specified root.
     *
     * @param root the root of the tree.
     *
     * @return the size of the tree.
     */
    private int size( BinarySearchTreeNode<T> root ) {
        int size = 0;  // The size of the tree

        // The size of the tree is one more than the sum of 
	// the sizes of its children.
	if ( root.getLeft() != null ) {
	    size = size( root.getLeft() );
	}
	
	if ( root.getRight() != null ) {
	    size = size + size( root.getRight() );
	}
	
	return size + 1;
    }

    /**
     * Determine the height of the tree.
     *
     * Preconditions:
     *   None
     *
     * Postconditions:
     *   The tree is unchanged.
     *
     * @return the height of the tree.
     */
    public int height() { 
	int height = 0;
	
	// If there is a tree determine the height
	if ( root != null ) {
	    height = height( root );
	}
	
	return height;
    }

    /**
     * Determine the height of the tree with the specified root.
     *
     * @param root the root of the tree.
     *
     * @return the height of this tree.
     */
    private int height( BinarySearchTreeNode<T> root ) {
	int leftHeight = 0;   // Height of the left subtree
	int rightHeight = 0;  // Height of the right subtree
	int height = 0;       // The height of this subtree
	
	// If we have a left subtree, determine its height
	if ( root.getLeft() != null )  {
	    leftHeight = height( root.getLeft() );
	}
	
	// If we have a right subtree, determine its height
	if ( root.getRight() != null )  {
	    rightHeight = height( root.getRight() );
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
     * Determine if the given element is in the tree.
     *
     * Preconditions:
     *   Target is not null.
     *
     * Postconditions:
     *   The tree is unchanged.
     *
     * @param target the element being searched for.
     *
     * @return true if the element is found and false otherwise.
     */
    public boolean contains( T target ) {
	boolean found = false;
	BinarySearchTreeNode<T> cur = root;
	
	// Keep looking until we find the element or fall off the tree
	while ( !found && cur != null ) {
	    int compare = target.compareTo( cur.getData() );
	    
	    if ( compare < 0 ) {
		// The target is smaller - look left
		cur = cur.getLeft();
	    }
	    else if ( compare > 0 ) {
		// The target is greater - look right
		cur = cur.getRight();
	    }
	    else {
		// Found it!!
		found = true;
	    }
	}
	
	return found;
    }	

    /**
     * Return a string representation of this tree.  The string
     * contains the elements in the tree listed in the
     * order they were found during an inorder traversal of the tree.
     *
     * @return a string representation of this tree.
     */
    public String toString() {
	// Use a string buffer to avoid created many temporary strings
	StringBuffer result = new StringBuffer();
	
	// If there is a tree traverse it
	if ( root != null ) {
	    inorder( root, result );
	}
	
	// Return the result
	return result.toString();
    }

    /**
     * Perform an inorder traversal of the tree.  When a node is
     * processed, the contents of the node are converted to a string
     * and appended to the specified string buffer.
     *
     * @param root the root of the tree to traverse.
     * @param result the string buffer that will contain the string
     *               repsentations of the strings in the tree.
     */
    private void inorder( BinarySearchTreeNode<T> root, StringBuffer result ) {
	// If there is a left child - traverse it
	if ( root.getLeft() != null ) {
	    inorder( root.getLeft(), result );
	}
	
	// Process the current node by converting the data to a string
	// and appending the result to the string buffer.  A space is
	// placed between consecutive elements in the string
	result.append( root.getData() );
	result.append( " " );
	
	// If there is a right child - traverse it
	if ( root.getRight() != null ) {
	    inorder( root.getRight(), result );
	}
    }
    
} // LinkedBinarySearchTree
