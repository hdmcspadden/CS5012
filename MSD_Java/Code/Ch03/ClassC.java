public class ClassC extends ClassB {
    private int x;

    public ClassC() {
	x = -2;
	y = -3;
	z = -4;
    }

    public String toString() {
	return " x=" + x + " y=" + y + " z=" + z ;
    }

    public static void main( String args[] ) {
	ClassC aC = new ClassC();

	System.out.println( aC );
    }
}

class ClassB extends ClassA {

    protected int y;

    public ClassB() {
	y = 1;
	z = 2;
    }

}

class ClassA {

    protected int x;
    protected int y;
    protected int z;

    public ClassA() {
	x = 123;
	y = 456;
	z = 789;
    }

}
