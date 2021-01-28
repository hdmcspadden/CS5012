import java.util.*;

/**
 * A class that represents a bookshelf.  Books on the shelf
 * are stored and retrieved by ISBN.
 */
public class BookShelf {
    private Map<String, String> theShelf;  // The books
    
    /**
     * Create a new book shelf.
     */
    public BookShelf() {
        theShelf = new HashMap<String, String>();
        
    }

    /**
     * Add a book to the bookshelf.  The book is added only if a book
     * with the same ISBN is not already on the shelf.  The return
     * value indicates whether or not the book was added to the shelf.
     *
     * @param isbn the ISBN of the book to be added.
     * @param title the title of the book.
     * @return true if the book was added to the shelf.
     */
    public boolean addTitle( String isbn, String title ) {
    	// If the ISBN is a key in the map - the book is on the shelf
    	boolean onShelf = theShelf.containsKey( isbn );
    
    	// If the book is not already there - add it
    	if ( !onShelf ) {
    	    theShelf.put( isbn, title );
    	}
    
    	return onShelf;
    }

    /**
     * Return the title associated with the given ISBN.
     *
     * @param isbn the ISBN of the title to be retrieved.
     * @return the title or null if the ISBN is not on the shelf.
     */
    public String getTitle( String isbn ) {
        return theShelf.get( isbn );
    }

    /**
     * Remove the title with the specified title from the
     * shelf.  The return value indicates whether the title
     * was removed from the shelf or not.
     *
     * @param isbn the ISBN of the title to remove.
     * @return true if the title was removed from the shelf.
     */
    public boolean removeTitle( String isbn ) {
    	// Remove returns null if the key is not in the map
    	return theShelf.remove( isbn ) != null;
    }

    /**
     * Return a list that contains all of the titles on the shelf.
     *
     * @return a list that contains all of the titles on the shelf.
     */
    public List getAllTitles() {
    	// Values returns a collection - convert it to a list
    	return new ArrayList<String>( theShelf.values() );
    }

    /**
     * Return a string that contains the ISBN and the titles on the shelf.
     *
     * @return a string representation of the books on the shelf.
     */
    public String toString() {
    	// Use a string buffer for efficiency
    	StringBuffer books = new StringBuffer( "The books:\n" );
    
        for ( String key : theShelf.keySet() ){
    	    String isbn = key;
    
    	    // Use the ISBN to get the corresponding title
    	    books.append( "  " + isbn + "  " + theShelf.get( isbn ) + "\n" );
    	}

        return books.toString();
    }
} 
