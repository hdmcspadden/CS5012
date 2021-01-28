
/**
 * A simple test program for the Lists used in the book.
 */

public class TestBookLists {

    /**
     * Basic sanity check for List implementations.
     *
     * @param args types of lists to use
     */

    public static void main( String args[] ) {
	List<Integer> list = null;

	// Create the appropriate list
	list = new DoublyLinkedList<Integer>();

	// Should be able to print and iterate over an empty list
	System.out.println( list + " Size:  " + list.size() );

	for ( list.first(); list.isOnList(); list.next() ) {
	    System.out.println( "Should not print" );
	}

	// Add a bunch of stuff
	for ( int i = 0; i < 10; i++ ) {
	    list.add( i );
	}

	System.out.println( list + " Size:  " + list.size() );
    
	// Test out first and last
	list.first();
	System.out.println( "First is:  " + list.get() );

	list.last();
	System.out.println( "Last is:  " + list.get() );

	// Should see the same things the toString() method did
	for ( list.first(); list.isOnList(); list.next() ) {
	    System.out.print( list.get() + " " );
	}

	System.out.println();

	// Try going backwards through the list
	for ( list.last(); list.isOnList(); list.previous() ) {
	    System.out.print( list.get() + " " );
	}

	System.out.println();

	// Manually walk through the list using get.
	for ( int i = 0; i < list.size(); i++ ) {
	    System.out.print( list.get( i ) + " " );
	}

	System.out.println();

	// Try removing every other element starting at the tail and
	// working backwards.
	System.out.print( "Removing:  " );

	for ( int i = list.size() - 1; i >= 0 ; i = i - 2 ) {
	    System.out.print( list.get( i ) + " " );
	    list.remove( i );
	}

	System.out.println();
	System.out.println( list + " Size:  " + list.size() );

	// Should see the same things the toString() method did
	for ( list.first(); list.isOnList(); list.next() ) {
	    System.out.print( list.get() + " " );
	}

	System.out.println();

	// Try going backwards through the list
	for ( list.last(); list.isOnList(); list.previous() ) {
	    System.out.print( list.get() + " " );
	}

	System.out.println();

	// Add 99 at every position in the list.
	for ( int i = (list.size() - 1); i >= 0; i = i - 1 ) {
	    list.add( 99, i );
	}

	System.out.println( list + " Size:  " + list.size() );

	// Remove the 99s using remove()	
	list.first();
	list.remove();

	while ( list.isOnList() ) {
	    list.next();
	    list.remove();
	}

	System.out.println( list + " Size:  " + list.size() );

	// Add the odd numbers back into the list
	list.first();

	for ( int i = 1; i < 9; i = i + 2 ) {
	    list.add( new Integer( i ) );
	    list.next();
	}

	list.add( new Integer( 9 ) );

	System.out.println( list + " Size:  " + list.size() );

	// Test set by multiplying each integer by 100
	for ( list.first(); list.isOnList(); list.next() ) {
	    int value = ((Integer)list.get()).intValue();
	    list.set( new Integer( value * 10 ) );
	}

	System.out.println( list + " Size:  " + list.size() );

	// Use set(pos) to make the list the way it was
	for ( int i = 0; i < list.size(); i = i + 1 ) {
	    list.set( new Integer( i ), i );
	}

	System.out.println( list + " Size:  " + list.size() );

	// Remove everything from the list
	for ( list.first(); list.size() > 0; list.remove() );

	System.out.println( list + " Size:  " + list.size() );

	// Try adding to an empty list

	list.add( 99 );

	System.out.println( list + " Size:  " + list.size() );
    }

} // TestLists
