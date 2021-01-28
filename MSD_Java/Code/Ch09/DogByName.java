import java.util.Comparator;

public class DogByName implements Comparator {
    public int compare( Object o1, Object o2 ) {
    	Dog d1 = (Dog)o1;
    	Dog d2 = (Dog)o2;
    
    	return d1.getName().compareTo( d2.getName() );
    }
}
