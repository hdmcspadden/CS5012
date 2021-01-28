
/**
 * A simple test program for the Stacks used in the book.
 */

public class TestBookStacks {

    /**
     * Basic sanity check for Stack implementations.
     *
     * @param args types of lists to use
     */

    public static void main( String args[] ) {
        Stack<Integer> theList = new LinkedStack<Integer>();
        Stack<Integer> theList2 = new LinkedStack<Integer>();
        
        //Should print True
        System.out.println( "Empty: " + theList.empty());
        
        theList.push(1);
        
        //Should print false
        System.out.println( "Empty: " + theList.empty());
        
        System.out.println( theList.top() );
        theList.pop();
        
        //Should print true
        System.out.println( "Empty: " + theList.empty());
        
        for(int a = 0; a < 10; a++ ){
            theList.push( a );
        }
        
        //Print 0-9 in reverse order
        while( !theList.empty() ){
            System.out.print( theList.top()+" ");
            theList2.push(theList.top());
            theList.pop();
        }
        
        System.out.println();
        
        //Print 0-9 in order
        while( !theList2.empty() ){
            System.out.print( theList2.top()+" ");
            theList2.pop();
        }   
        
        System.out.println();
        
    }
    
}