
/**  
 * An interface for a simple stack ADT.
 */ 
public interface Stack<T> {
    /**
     * Places its argument on the top of the stack.
     *   
     * Preconditions: 
     * 	Stack is not full.
     * 
     * Postconditions:
     * 	Stack size has increased by 1.
     * 	data is on top of the stack.
     * 	The rest of the stack is unchanged.
     *
     * @param data Object to place on the stack.
     */
    public void push( T data );
	
    /**
     * Removes the top of the stack.
     *
     * Preconditions: 
     * 	Stack is not empty.
     * 
     * Postconditions:
     * 	Stack size has decreased by 1.
     * 	The top item of the stack has been removed.
     * 	The rest of the stack is unchanged.
     */
    public void pop();

    /**
     * Returns the top element of the stack.
     *
     * Preconditions:  
     * 	The stack is not empty.
     * 
     * Postconditions: 
     * 	The stack is unchanged.
     *
     * @return the top element of the stack.
     */	
    public T top();

    /**
     * Determines if the stack is empty.
     *
     * Preconditions:  
     * 	None.
     * 
     * Postconditions: 
     * 	The stack is unchanged.
     *
     * @return true if the stack is empty, false otherwise.
     */	
    public boolean empty();

    /**
     * Determines if the stack is full.
     * 
     * Preconditions:  
     * 	None.
     * 
     * Postconditions: 
     * 	The stack is unchanged.
     *
     * @return true if the stack is full and false otherwise.
     */	
    public boolean full();

}
