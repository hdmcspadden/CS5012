/**
 * A class that represents a dog.  The state of a dog consists of its
 * name, breed, and gender.  Note that this class is not comparable.
 */
public class Dog {
    // State for the dog
    private String breed;
    private String name;
    private String gender;

    /**
     * Create a new dog object.
     *
     * @param theBreed the breed of the dog
     * @param theName the name of this dog
     * @param theGender the gender of this dog
     */
    public Dog( String theBreed, String theName, String theGender ) {
    	breed = theBreed;
    	name = theName;
    	gender = theGender;
    }

    /**
     * Return the breed of this dog
     *
     * @return the breed of this dog
     */    
    public String getBreed() {
        return breed;
    }

    /**
     * Return the name of this dog
     *
     * @return the name of this dog
     */
    public String getName() {
        return name;
    }

    /**
     * Return the gender of this dog
     *
     * @return the gender of this dog
     */
    public String getGender() {
        return gender;
    }

    /**
     * Indicates whether some other object is equal to this one.
     *
     * @param o the object to be compared with
     * @return true if this object is the same as the argument.
     */    
    public boolean equals( Object o ) {
    	boolean retVal = false;
    
    	if ( o instanceof Dog ) {
    	    Dog other = (Dog)o;
    	    retVal = 
    		breed.equals( other.getBreed() ) &&
    		name.equals( other.getName() ) &&
    		gender.equals( other.getGender() );
    	}
    
    	return retVal;
    }

    /**
     * Return a hash value for this object; the hash value for a dog
     * object is equal to the sum of the hash codes for the name.
     * breed, and gender of the dog.
     *
     * @return a hash code for a dog object.
     */
    public int hashCode() {
	return name.hashCode() + breed.hashCode() + gender.hashCode();
    }

} // Dog
