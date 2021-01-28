/**
 * A simple iterative binary search routine
 */
public class BinarySearch {

    /** 
     * Search the given array for the given integer using a binary
     * search.  This method assumes that the elements in the array
     * are in sorted order.  If the element is found, the method
     * returns the position of the element, otherwise it returns -1.
     *
     * @param array The array of integers to search 
     * @param target The integer to search for
     * @return target's position if found, -1 otherwise
     */ 

    public static int search( int array[], int target ) { 
        int start = 0;                   // The start of the search region
     	int end = array.length - 1;      // The end of the search region
     	int position = -1;               // Position of the target
     
     	// While there is still something left in the list to search 
        // and the element has not been found
     	while ( start <= end && position == -1 ) {
     	    int middle = (start + end) / 2;  // Location of the middle

     	    // Determine whether the target is smaller than, greater than,
     	    // or equal to the middle element
    	    if ( target < array[ middle ] )  {
		        // Target is smaller; must be in left half
    	        end = middle - 1; 
    	    } else  if ( target > array[ middle ] ) {
    	        // Target is larger; must be in right half
    	        start = middle + 1;  
    	    } else {
    	        // Found it!!
    	        position = middle;
    	    }
     	}

     	// Return location of target
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
	System.out.println( search( array, 6) );

	// Search for something that's not in the array
	System.out.println( search( array, 17 ) );
    }
}
