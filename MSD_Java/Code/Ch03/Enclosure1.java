public class Enclosure1 {
    Animal occupant;

    public void addOccupant( Animal o ) {
	occupant = o;
    }

    public Animal getOccupant() {
	return occupant;
    }

    public Animal removeOccupant() {
	Animal retVal = occupant;
	occupant = null;
	return retVal;
    }

    public static void main( String args[] ) {
	Enclosure1 cage1 = new Enclosure1();
	Enclosure1 cage2 = new Enclosure1();

	cage1.addOccupant( new Dog( "Buster" ) );
	cage2.addOccupant( new Cat( "Grumpy" ) );
    }
}
