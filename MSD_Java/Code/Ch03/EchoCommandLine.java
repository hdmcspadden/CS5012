/**
 * A program that echos the command line.
 */

public class EchoCommandLine {

    /**
     * Print out the contents of the args array that is
     * passed to the method when it is invoked.
     *
     * @param args the command line arguments.
     */

    public static void main( String args[] ) {

	// Print out args

	for ( int i = 0; i < args.length; i++ ) {
	    System.out.println( args[ i ] );
	}

    }

} // EchoCommandLine
