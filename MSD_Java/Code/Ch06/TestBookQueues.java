
/**
 * A simple test program for the Queue used in the book.
 */

public class TestBookQueues {

    /**
     * Basic sanity check for Queue implementations.
     *
     * @param args types of lists to use
     */

    public static void main( String args[] ) {
        Queue<Integer> theList = new LinkedQueue<Integer>();
        Queue<Integer> theList2 = new LinkedQueue<Integer>();
        
        //Should print True
        System.out.println( "Empty: " + theList.empty());
        
        theList.enqueue(1);
        
        //Should print false
        System.out.println( "Empty: " + theList.empty());
        
        System.out.println( theList.front() );
        theList.dequeue();
        
        //Should print true
        System.out.println( "Empty: " + theList.empty());
        
        for(int a = 0; a < 10; a++ ){
            theList.enqueue( a );
        }
        
        //Print 0-9 in reverse order
        while( !theList.empty() ){
            System.out.print( theList.front()+" ");
            theList2.enqueue(theList.front());
            theList.dequeue();
        }
        
        System.out.println();
        
        //Print 0-9 in order
        while( !theList2.empty() ){
            System.out.print( theList2.front()+" ");
            theList2.dequeue();
        }   
        
        System.out.println();
        
    }
    
}