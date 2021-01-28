/*
 * TestSquare.java
 */

/**
 * A simple program to illustrate how to use the Square class.
 */

public class TestSquare {

    /**
     * Create a square and then print its length, location, perimeter,
     * and area.
     */

    public static void main( String args[] ) {
	Square aSquare = new Square( 10 );

	System.out.println( "Square:" );
	System.out.println( " Length == " + aSquare.getLength() );
	System.out.println( " Location == (" + 
			    aSquare.getLocation().getXCoordinate() + "," +
			    aSquare.getLocation().getYCoordinate() + ")" );
			                   
	System.out.println( " Perimeter == " + aSquare.getPerimeter() );
	System.out.println( " Area == " + aSquare.getArea() );
    }

} // TestSquare
