
/**  
 * A simple linked implementation of the Stack ADT.
 */ 
public class LinkedStack<T> implements Stack<T> {

    private LinkedNode<T> top;  // Reference to the top of the stack

    /**
     * Create a new stack.
     */
    public LinkedStack() {
        top = null;  // Create an empty stack
    }

    /**
     * Places its argument on the top of the stack.
     *
     * Preconditions: 
     * 	Stack is not full.
     * 
     * Postconditions:
     * 	Stack size has increased by 1.
     * 	V is on top of the stack.
     * 	The rest of the stack is unchanged.
     * 
     * @param data Object to place on the stack
     */
    public void push( T data ) {
        // Create a new node and make it point to the top of the stack
        LinkedNode<T> newTop = new LinkedNode<T>( data, top );

        // The top of the stack is the new node
        top = newTop;
    }
	
    /**
     * Remove element at the top of the stack.
     *
     * Preconditions: 
     * 	Stack is not empty.
     * 
     * Postconditions:
     * 	Stack size has decreased by 1.
     * 	The top item of the stack has been removed.
     * 	The rest of the stack is unchanged.
     */
    public void pop() { 
        // The new top is the node after the current top
        top = top.getNext();
    }

    /**
     * Return element currently on top of the stack
     * 
     * Preconditions:  
     * 	The stack is not empty.
     * 
     * Postconditions: 
     * 	The stack is unchanged.
     *
     * @return the element currently on top of the stack
     */	
    public T top()  { 
        return top.getData();
    }

    /**
     * Returns true if the stack is empty
     *
     * Preconditions:  
     * 	None
     * 
     * Postconditions: 
     * 	The stack is unchanged.
     *
     * @return returns true if the stack is empty and false otherwise
     */	
    public boolean empty() {
        // The stack is empty if top is null
        return top == null;
    }

    /**
     * Determines whether the stack is full
     * 
     * Preconditions:  
     * 	None
     * 
     * Postconditions: 
     * 	The stack is unchanged.
     *
     * @return returns true if the stack is full and false otherwise.
     */	
    public boolean full() {
        // LinkedStacks are never full
	   return false;
    }

}
