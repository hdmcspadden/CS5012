/**
 * Sort an array using bubble sort
 */
public class BubbleSort {

    /**
     * Sorts the given array using the bubblesort algorithm
     *
     * @param array The array of integers to sort
     */     
    public static void bubbleSort( int array[] ) {
	    int i = 0;     // How many elements are sorted - initially none
	    boolean swap;  // Was a swap made during this pass?
	    int temp;      // Temporary storage for swap

	    // Keep making passes through the array until it is sorted
        do {
            swap = false; 

            // Make a pass through the array, swap adjacent elements that
            // are out of order
            for ( int j = 0; j < array.length - i - 1; j++ ) { 
                // If the two elements are out of order - swap them
                if ( array[ j ] > array[ j + 1 ] ) { 
                    temp = array[ j ]; 
                    array[ j ] = array[ j + 1 ];  
                    array[ j + 1 ] = temp;

                    // Made a swap - array might not be sorted
                    swap = true;
                }
            }

            // One more element is in the correct position
            i = i + 1;
        } while ( swap );
    }

    /**
     * A simple routine to demonstrate the bubble sort.
     *
     * @param args ignored
     */
    public static void main(String args[]) {
	int a[] = { 5, 2, 6, 4, 7, 1, 9, 8, 3, 0 };

	// Do the sort
	bubbleSort( a );  

	// Print the results
	for ( int i = 0; i < a.length; i++ )  {
	    System.out.println( a[ i ] );
	}
    }
}

