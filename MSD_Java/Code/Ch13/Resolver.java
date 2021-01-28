import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * For each machine name on the command line, look up
 * its IP address and print it out.
 */

public class Resolver {

    public static void main( String args[] ) {

	// Iterate over the command line arguments

	for ( int i = 0; i < args.length; i++ ) {

	    // Must be executed in a try block since getLocalHost()
	    // might throw a UnknownHostException

	    try {

		System.out.print( args[ i ] + ":  " );

		// Attempt to print the IP address of the
		// current host

		System.out.println( InetAddress.getByName( args[ i ] ) );
	    }
	    catch ( UnknownHostException e ) {

		// Will be thrown if the current machine name
		// is not known

		System.out.println( "Unknown host" );
	    }

	}

    }

} // Resolver
