/**
 * A simple recursive binary search routine
 */
public class BinarySearch {

    /** 
     * Recursively searches the given array for the given integer.  If found,
     * returns its position.  If not, returns -1.
     *
     * @param array The array of integers to search 
     * @param target The integer to search for 
     * @param start First position included in the search range
     * @param end Last position included in the search range
     * @return target's position if found, -1 otherwise
     */ 
    public static int search( int array[], int target, 
    		                  int start, int end ) {
    
        int position = -1;     // Assume the target is not here
    
        // Do the search only if there are elements in the array
        if ( start <= end ) {
            // Determine where the middle is
            int middle = ( start + end ) / 2;
    
            if ( target < array[ middle ] )  {
                // Target is smaller than middle.  Search left half.
                position = search( array, target, start, middle - 1 );
            } else if ( target > array[ middle ] ) { 
                // Target is larger than middle.  Search right half.
                position = search( array, target, middle + 1, end );
            } else {
                // Target is equal to middle-- we found it.
                position = middle; 
            }
        }
    
        return position;
    }

    /**
     * A simple demonstration routine for binary search.
     *
     * @param args ignored 
     */
    public static void main(String args[]) {
	int array[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
	
	// Search for something that's in the array
	System.out.println( search( array, 6, 0, array.length - 1 ) );

	// Search for something that's not in the array
	System.out.println( search( array, 17, 0, array.length - 1 ) );
    }
}

