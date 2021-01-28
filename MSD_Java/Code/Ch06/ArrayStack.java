/**  
 * An array-based implementation of a stack.
 */ 
public class ArrayStack<T> implements Stack<T> {
    
    private T theStack[];                  // The stack itself
    private final static int STACK_SIZE = 100;  // Most items we can have
    private int top;                            // Position of top element

    /**
     *
     * Construct a new stack
     *
     * Preconditions:
     *  None
     *
     * Postconditions:
     *   The ArrayStack is ready for use      
     */ 
    public ArrayStack() { 
    	// Create storage for the stack
    	theStack = (T[])new Object[ STACK_SIZE ];
    
    	// Top will be -1 for an empty stack because it is incremented before
    	// it is used to add a new element to the stack.
    	top = -1;
    }

    /**
     * Removes the top of the stack.
     *
     * Preconditions: 
     *  Stack is not empty.
     * 
     * Postconditions:
     *  Stack size has decreased by 1.
     *  The top item of the stack has been removed.
     *  The rest of the stack is unchanged. 
     */	
    public void pop() {
        theStack[ top ] = null;  // Erase location so object can be garbage
	                             // collected
        
        top = top - 1; // Lower the top of the stack
    }

    /**
     * Places its argument on the top of the stack.
     * 
     * Preconditions: 
     *  Stack is not full.
     * 
     * Postconditions:
     *  Stack size has increased by 1.
     *  data is on top of the stack.
     *  The rest of the stack is unchanged.
     * 
     * @param data the object to place on the stack
     */
    public void push( T data ) {
        top = top + 1;           // Increment the stack pointer
        theStack[ top ] = data;  // Put the data in the stack
    }

    /**
     * Returns the top element of the stack
     * 
     * Preconditions:  
     * 	The stack is not empty.
     * 
     * Postconditions: 
     * 	The stack is unchanged.
     *
     * @return the element on top of the stack
     */	
    public T top() { 
        return theStack[ top ];  // Return the topmost element
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
     * @return true if the stack is empty and false otherwise.
     */	 
    public boolean empty() {
        return top == -1;  // Empty if top is -1
    }
    
    /**
     * Determines whether the stack is full
     * 
     * @return true if the stack can accept no more elements, false otherwise.
     * 
     * Preconditions:  
     * 	None
     * 
     * Postconditions: 
     * 	The stack is unchanged.
     *
     * @return true if the stack is full and false otherwise
     */		
    public boolean full() {
        return top == theStack.length - 1;  // Full if the top is at the end of
	                                        // the array
    }

} 
