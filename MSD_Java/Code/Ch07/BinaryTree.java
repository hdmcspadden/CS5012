/**  
 * An interface for the binary tree Abstract Data Type (ADT)
 */ 
public interface BinaryTree<T> {
    /**
     * Position the cursor at the root of the tree.
     *
     * Preconditions:
     *   None
     *
     * Postconditions:  	
     *   If the tree is empty, the cursor is invalid.
     *     Otherwise, the cursor refers to the root of the tree.
     *   The tree structure is unchanged.
     */ 
    public void toRoot();

    /**
     * Determine if the current node has a left child.
     *
     * Preconditions:
     *   The cursor is valid.
     *
     * Postconditions:  	
     *   The tree structure is unchanged.
     *   The cursor is unchanged.
     * 
     * @return true if the current node has a left child.
     */ 	
    public boolean hasLeftChild();
    
    /**
     * Determine if the current node has a right child.
     *
     * Preconditions:
     *   The cursor is valid.
     *
     * Postconditions:  	
     *   The tree structure is unchanged.
     *   The cursor is unchanged.
     * 
     * @return true if the current node has a right child.
     */ 
    public boolean hasRightChild();
    
    /**
     * Determines if the current node has a parent.
     *
     * Preconditions:
     *   The cursor is valid.
     *
     * Postconditions:  	
     *   The tree structure is unchanged.
     *   The cursor is unchanged.
     * 
     * @return true if the current node has a parent.
     */ 
    public boolean hasParent();
    
    /**
     * Determine if the cursor is on the tree.
     *
     * Preconditions:
     *   None
     *
     * Postconditions:  	
     *   The tree structure is unchanged.
     *   The cursor is unchanged.
     *
     * @return true if the cursor is on the tree.
     */ 	
    public boolean isValid();
    
    /**
     * Position the cursor at the current node's parent, if any.
     *
     * Preconditions:
     *   The cursor is valid.
     *
     * Postconditions:  	
     *   If the cursor has no parent (i.e. referred to the root node),
     *     the cursor is invalid.  Otherwise, the cursor refers to its
     *     previous referent's parent.
     *   The structure of the tree is unchanged.
     */ 	
    public void toParent();
    
    /**
     * Position the cursor at the left child of the current node.
     *
     * Preconditions:
     *   The cursor is valid.
     *
     * Postconditions:  	
     *   If the left child of the current node is invalid, the cursor 
     *     is invalid.  Otherwise, the cursor is changed to refer to
     *     the left child of the current node.
     *   The structure of the tree is unchanged.
     */ 		
    public void toLeftChild();
    
    /**
     * Position the cursor at the right child of the current node.
     *
     * Preconditions:
     *   The cursor is valid.     
     *
     * Postconditions:  	
     *   If the left child of the current node is invalid, the cursor 
     *     is invalid.  Otherwise, the cursor is changed to refer to
     *     the right child of the current node.
     *   The structure of the tree is unchanged.
     */ 		
    public void toRightChild();
    
    /**
     * Insert the given item in the left child of the current node.
     * If the cursor is null and the tree has no root, a new root
     * is created containing this data.
     *
     * Preconditions:
     *   The tree is empty, or the cursor is valid and the left child is 
     *	   not empty.
     *	
     * Postconditions:  	
     *   The cursor has not changed.
     *   The size of the tree has increased by one.
     *   No other structure of the tree has changed. 
     *
     * @param data the data to put in the left child.
     */ 
    public void insertLeft( T data );
    
    /**
     * Insert the given item in the right child of the currrent node.
     * If the cursor is null and the tree has no root, a new root
     * is created containing this data.
     *
     * Preconditions:
     *   The tree is empty, or the cursor is valid and the right child is 
     *	   not empty.
     *	
     * Postconditions:  	
     *   The cursor has not changed.
     *   The size of the tree has increased by one.
     *   No other structure of the tree has changed. 
     *
     * @param data the data to put in the right child.
     */ 
    public void insertRight( T data );
    
    /**
     * Return a reference to the data stored at the current node.
     *
     * Preconditions:
     *   The cursor is on the tree.
     *
     * Postconditions:
     *   The tree is unchanged.
     *
     * @return a reference to the data at the current node.
     */
    public T get();

    /**
     * Set the data stored at the current node.
     *
     * Preconditions:
     *   The cursor is on the tree.
     *
     * Postconditions:
     *   The reference of the current node is changed.
     *   The rest of the tree is unchanged.
     *
     * @param data the reference to store in the current node.
     */
    public void set( T data );

    /**
     * Removes the subtree rooted at (including) the cursor.
     *
     * Preconditions:  
     *   The cursor is on the tree
     *
     * Postconditions: 
     *   The specified subtree has been removed.  If the cursor
     *     referred to the root node, the tree is empty.
     *   The tree's size has decreased.
     *   No other structure of the tree has changed.
     *   If the resulting tree is empty, the cursor is invalid.
     *     Otherwise the cursor refers to the parent of the current 
     *     node.
     */
    public void prune();
	
    /**
     * Determines if the given object is identical to this one.
     *  
     * Preconditions:
     *   None
     *
     * Postcondtions:
     *   The cursors of both trees refer to the root of their
     *     respective trees.
     *
     * @param o the Object to compare to
     * 
     * @return true if and only if all of the following are true:
     *	         The other object is a BinaryTree
     *		 The structure of the two trees are identical
     *		 The data contained in corresponding nodes of the
     *             two trees are identical.
     */
    public boolean equals( Object o );

    /**
     * Return the number of nodes in this tree.
     *
     * Preconditions:  
     * 	 None
     * 
     * Postconditions: 
     * 	 The tree is unchanged.
     *
     * @return the number of nodes in the tree.
     */
    public int size();

    /**
     * Return the height of the tree.
     *
     * Preconditions:  
     *   None
     * 
     * Postconditions: 
     *   The tree is unchanged.
     *
     * @return the height of the tree.
     */
     public int height();

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
    public void find( T target );
    
    /**
     * Perform a preorder traversal on this tree with the specified 
     * callback object.
     *
     * Preconditions:
     *   cb is not null
     * 
     * Postconditions:
     *   The tree is unchanged.
     *
     * @param cb the callback object used to process each node.
     */    
    public void preOrder( Callback<T> cb );

    /**
     * Perform an inorder traversal on this tree with the specified 
     * callback object.
     *
     * Preconditions:
     *   cb is not null
     * 
     * Postconditions:
     *   The tree is unchanged.
     *
     * @param cb the callback object used to process each node.
     */    	
    public void inOrder( Callback<T> cb );

    /**
     * Perform a postorder traversal on this tree with the specified 
     * callback object.
     *
     * Preconditions:
     *   cb is not null
     * 
     * Postconditions:
     *   The tree is unchanged.
     *
     * @param cb the callback object used to process each node.
     */    	
    public void postOrder( Callback<T> cb );

} // BinaryTree 
