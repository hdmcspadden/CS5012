import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class TestBST {
    public static final int N = 25;

    public static void main( String args[] ) {
	BinarySearchTree<Integer> bst = 
	    new LinkedBinarySearchTree<Integer>();

	List<Integer> numbers = new ArrayList<Integer>();

	for ( int i = 0; i < N; i = i + 1 ) {
	    numbers.add( i * 2 );
	}

	Collections.shuffle( numbers );

	for ( Integer i : numbers ) {
	    bst.insert( i );
	}

	System.out.println( bst );
	System.out.println( "Size==" + bst.size() );
	System.out.println( "Height=" + bst.height() );

	for ( int i = 0; i < N * 2; i = i + 1 ) {
	    System.out.println( i + "-->" + bst.contains( new Integer( i ) ) );
	}
    }
}
