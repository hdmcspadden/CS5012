import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Print out the IP address of the local host using the
 * getLocalHost() method from the InetAddress class.
 */

public class HostInfo {

    public static void main( String args[] ) {
    
	// Must be executed in a try block since getLocalHost()
	// might throw a NoSuchHostException

	try {

	    // Attempt to print the local address

	    System.out.println( "Local address:  " + 
				InetAddress.getLocalHost() );
	} 
	catch ( UnknownHostException e ) {

	    // Will be thrown if the local address cannot be
	    // determined.  This might happen for example if
	    // the machine has not been assigned an IP address

	    System.out.println( "Local address unknown" );
	}

    }

} // HostInfo
