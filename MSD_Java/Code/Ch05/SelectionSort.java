/**
 * Sort an array using Selection sort
 */
public class SelectionSort {

    /**
     * Sorts the given array using the selectionsort algorithm
     *
     * @param array The array of integers to sort
     */     
    public static void selectionSort( int array[] ) {
        int max;       // The index of the maximum element in the array
        int end;       // Keep track of the unsorted portion
        int temp;      // Temporary holder for swap
                
        end = array.length; // Set the end to the length of the array
                            // since it is completly unsorted 

        // Loop through the array finding the maximum element and placing
        // It at the end of the array
        for ( int i = array.length - 1; i >= 0; i--){
            
            // Initialize max to the first element
            max = 0;
            
            // Loop through the unsorted portion of the array and find
            // The maximum element of that section
            for ( int j = 0; j < end; j++ ) { 
            
                // If the current element is greater than max, set max to 
                // the index of the current element
                if ( array[ j ] > array[ max ] ) { 
                    max = j; 
                }
            }
            
            // Decrement end to decrease the size of the unsorted portion
            end--;
            
            // Swap the maximum element with the element on the end of 
            // the unsorted portion (marked with the end variable)
            temp = array[ end ];
            array[ end ] = array[ max ];
            array[ max ] = temp;
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
        selectionSort( a );  

        // Print the results
        for ( int i = 0; i < a.length; i++ )  {
            System.out.println( a[ i ] );
        }
    }
}

