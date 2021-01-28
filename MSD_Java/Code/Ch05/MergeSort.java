/**
 * Sort an array using merge sort
 */
public class MergeSort {

    /**
     * Sort an array using merge sort.
     *
     * @param array the array that contains the values to be sorted
     * @param start the start of the sorting region
     * @param end the end of the sorting region
     */
    public static void mergeSort( int array[], int start, int end ) {
        int middle;  // Middle of the array
        int left;    // First element in left array
        int right;   // First element in the right array
        int temp;    // Temporary storage
    
        if ( start < end ) {
            // Split the array in half and sort each half
            middle = ( start + end ) /2;
    
            mergeSort( array, start, middle );
            mergeSort( array, middle + 1, end );
    
            // Merge the sorted arrays into one
            left = start;
            right = middle + 1;
    
            // While there are numbers in the array to be sorted
            while ( left <= middle && right <= end ) {
    	        // If the current number in the left array
    	        // is larger than the current number in the right
    	        // array the numbers need to be moved around
                if ( array[ left ] > array[ right ] ) {
    	            // Remember the first number in the right array
                    temp = array[ right ];
    
                    // Move the left array right one position to make
                    // room for the smaller number
                    for ( int i = right - 1; i >= left; i-- ) {
    		            array[ i + 1 ] = array[ i ];
                    }
    
                    // Put the smaller number where it belongs
                    array[ left ] = temp;
    
                    // The right array and the middle need to shift right
                    right = right + 1;
                    middle = middle + 1;
                }
    
                // No matter what the left array moves right
                left = left + 1;
            }
        }
    }

    /**
     * A simple routine to demonstrate the bubble sort.
     *
     * @param args ignored
     */
    public static void main(String args[]) {
	int a[] = { 5, 2, 6, 4, 7, 1, 9, 8, 3, 0 };

	// Do the sort
	mergeSort( a, 0, a.length - 1 );  

	// Print the results
	for ( int i = 0; i < a.length; i++ )  {
	    System.out.println( a[ i ] );
	}
    }
}
