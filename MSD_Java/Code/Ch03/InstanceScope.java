/**
 * Illustrate how to specify the scope of instance variables.
 */

public class InstanceScope {

    // X is private which means X can only be accessed by
    // instances of the InstanceScope class.
    private int x;

    // Y is public which means Y can be accessed by any
    // instance of any class.
    public int y;

     // Z has package scope which means Z can be accessed
     // by any instance of a class that is in the same 
     // package as InstanceScope.
    int z;

} // InstanceScope
