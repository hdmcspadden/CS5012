/**
 * A class that represents a name consisting of a first and
 * last name.
 */
public class Name implements Comparable<Name>{
    // The name
    String first;
    String last;

    /**
     * Create a new name.
     *
     * @param firstName the first name.
     * @param lastName the last name.
     */
    public Name( String firstName, String lastName ) {
    	first = firstName;
    	last = lastName;
    }

    /**
     * Get the first name.
     *
     * @return the first name.
     */
    public String getFirst() {
        return first;
    }

    /**
     * Get the last name.
     *
     * @return the last name.
     */
    public String getLast() {
        return last;
    }

    /**
     * Compare two names and determine their relative order.  This
     * method will first comapre the last names.  If they are different
     * there alphabetical order will determine the order of the names.
     * If the last names are the same, the first names will be used to
     * determine the order.
     *
     * @param otherName the name to compare this name to.
     * @return a negative number if this name is less than the given name,
     *         zero if the names are equal, and a positive number if this
     *         name is greater than the specified string.
     */
    public int compareTo( Name otherName ) {
    	// Compare the last names using the compareTo() method
    	// defined in the string class.
    	int retVal = last.compareTo( otherName.getLast() );
    
    	// If the last names are equal, compare the first names.
    	if ( retVal == 0 ) {
    	    retVal = first.compareTo( otherName.getFirst() );
    	}
    
    	return retVal;
    }

    /**
     * Determine if this name is equal to the specified object.
     *
     * @param otherObject the object to compare this name to.
     * @return true if this name is equal to the specified object.
     */
    public boolean equals( Object otherObject ) {
    	boolean retVal = false;
    
    	// If this method is passed a reference to something
    	// other than a name the objects are not equal.
    	if ( otherObject instanceof Name ) {
    	    Name otherName = (Name)otherObject;
    
    	    // Two names are equal if their first and last names are the same.
    	    retVal = last.equals( otherName.getLast() ) &&
    	             first.equals( otherName.getFirst() );
    	}
    
    	return retVal;
    }
}
