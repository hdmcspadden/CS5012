/**
 * Use the class Class to obtain basic information about the
 * class Integer.
 */
public class UsingClass {
    public static void main( String args[] ) {
	// Create an instance of an integer
	Integer anInt = new Integer( 0 );

	// Obtain a reference to the class object associated
	// with an integer
	Class aClass = anInt.getClass();

	// Print out the name of the class and the package using
	// accessors provided by the Class object
	System.out.println( "Class:  " + aClass.getName() );
	System.out.println( "Package:  " + aClass.getPackage() );
    }

}  // UsingClass
