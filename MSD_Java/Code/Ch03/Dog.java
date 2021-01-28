public class Dog implements Animal {
    private String name;

    public Dog( String n ) {
	name = n;
    }

    public String speak() {
	return "Woof Woof";
    }

    public boolean isCarnivoire() {
	return true;
    }

    public String toString() {
	return name;
    }
}
