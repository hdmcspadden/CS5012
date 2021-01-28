/**
 * Sequential search of an array.
 */
public class SequentialSearch {

    /**
     * Searches the given array for the given integer. If found, returns its
     * position. If not, returns NOT_FOUND.
     * 
     * @param array
     *            The array of integers to search
     * @param target
     *            The integer to search for
     * @return target's position if found, -1 otherwise
     */
    public static int search(int array[], int target) {
        // Assume the target is not in the array
        int position = -1;

        // Step through the array until the target is found
        // or the entire array has been searched.
        for (int i = 0; i < array.length && position == -1; i++) {

            // Is the current element what we are looking for?
            if (array[i] == target) {
                position = i;
            }
        }

        // Return the the element's position
        return position;
    }

    /**
     * 
     * A simple demonstration routine for sequential search
     * 
     * @param args
     *            ignored
     */
    public static void main(String args[]) {
        int array[] = { 1, 2, 3, 4, 5, 6, 7, 8 };

        // Search for something that's in the array
        System.out.println(search(array, 6));

        // Search for something that's not in the array
        System.out.println(search(array, 17));
    }
}
