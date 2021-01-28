public class Supermost {

    public Supermost() {
	System.out.println( "Supermost constructor" );
    }

}

class Superclass extends Supermost {

    public Superclass() {
	System.out.println( "Superclass constructor" );
    }

}

class Subclass extends Superclass {

    public Subclass() {
	System.out.println( "Subclass constructor" );
    }

    public static void main( String args[] ) {
	Subclass x = new Subclass();
    }
}
