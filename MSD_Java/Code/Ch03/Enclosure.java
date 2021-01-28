public class Enclosure<T> {
    private T occupant;

    public Enclosure( T o ) {
	occupant = o;
    }

    public void addOccupant( T o ) {
	occupant = o;
    }

    public T getOccupant() {
	return occupant;
    }

    public T removeOccupant() {
	T retVal = occupant;
	occupant = null;
	return retVal;
    }
	
    boolean isEmpty() {
	return occupant == null;
    }

    public static <U extends Animal> void fill( U[] pets, Enclosure<U>[] cages ) {
	for ( int i = 0; i < pets.length; i++ ) {
	    cages[ i ] = new Enclosure<U>( pets[ i ] );
	}
    }

    public static void main( String args[] ) {
	Dog d[] = {
	    new Dog( "Buster" ),
	    new Dog( "Spencer" ),
	    new Dog( "Rudy" ),
	    new Dog( "Roxy" ) };

	Enclosure<Dog> c[] = (Enclosure<Dog>[])new Object[ d.length ];

	Enclosure.fill( d, c );

	for ( int i = 0; i < c.length; i++ ) {
	    System.out.println( c[ i ].getOccupant() );
	}

Dog myDogs[] = new Dog[ 10 ];
Object objArray[] = myDogs;
objArray[ 0 ] = "a string";

    }
}
