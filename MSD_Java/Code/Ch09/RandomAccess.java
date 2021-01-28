import java.util.*;

/**
 * A program to test the efficiency of random access in an ArrayList
 * versus a LinkedList.
 */
public class RandomAccess {
    /**
     * This method will perform num random accesses of the given
     * list.  The return value gives the number of milliseconds
     * required to perform the lookups.
     *
     * @param theList the list to access.
     * @param num the number of times to access the list.
     * @return the number of milliseconds required to perform num
     *         accesses of the list.
     */
    public static int access( List<Integer> theList, int num ) {
    	Random rng = new Random();
    
    	// Record the starting time
    	long start = System.currentTimeMillis();
    
    	// Access random locations within the list
    	for ( int i = 0; i < num; i++ ) {
    	    Integer x = theList.get( rng.nextInt( theList.size() ) );
    	}
    
    	// Return the time required to perform the loop
    	return (int)( System.currentTimeMillis() - start );
    }

    /**
     * Fill a list with num random values.
     *
     * @param theList the list to fill.
     * @param num the number of numbers to place in the list.
     * @param max the maximum value to place in the list.
     */
    public static void fill( List<Integer> aList, int num, int max ) {
    	Random rng = new Random();
    
    	for ( int i = 0; i < num; i++ ) {
    	    aList.add( rng.nextInt( max ) );
    	}
    }
    
    /**
     * Create two lists of integets, fill them and report the
     * time taken to randomly access them 10,000 times.
     * 
     * @param args the list of command line arguments.
     */
    public static void main( String args[] ) {
    	List<Integer> aList = new ArrayList<Integer>();
    	List<Integer> lList = new LinkedList<Integer>();
    
    	// Fill the lists
    	fill( aList, 1000, 100 );
    	fill( lList, 1000, 100 );
    
    	// Report the time required to do 10,000 random accesses
    	System.out.println( access( aList, 10000 ) );
    	System.out.println( access( lList, 10000 ) );
    }
}
