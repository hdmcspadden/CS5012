import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class TestHeap {
    public static final int N = 50;

    public static void main( String args[] ) {
	Heap<Integer> theHeap = new ArrayBasedHeap<Integer>();
	List<Integer> numbers = new ArrayList<Integer>();

	for ( int i = 0; i < N; i = i + 1 ) {
	    numbers.add( i );
	}

	Collections.shuffle( numbers );

	for ( Integer num : numbers ) {
	    theHeap.insertHeapNode( num );
	}

	while( !theHeap.empty() ) {
	    System.out.print( theHeap.getSmallest() + " " );
	}

	System.out.println();
    }
}
