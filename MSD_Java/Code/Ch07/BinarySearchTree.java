/**  
 *
 * An interface for the Binary Search Tree ADT.
 *
 * This interface assumes that duplicate entries are forbidden in the tree.
 */
public interface BinarySearchTree<T extends Comparable> {
    /**
     * Inserts the given data into the correct position within the tree.
     *
     * Preconditions:
     *   The data to be added is not currently in the tree.
     *
     * Postconditions:
     *   The size of the tree has increased by one.
     *   The element added is in the correct position within the tree.
     *
     * @param data the data to insert into the tree.
     */	
    public void insert( T info );
    
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
    public int size();
    
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
    public int height();
    
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
    public boolean contains( T key ); 
    
} // BinarySearchTree

