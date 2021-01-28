import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.net.Socket;
import java.net.UnknownHostException;

/**
 * A simple client that will query the daytime service on a
 * remote to determine the date and time at that location.
 */


public class DayTimeClient {

    static int DAYTIME_PORT = 13;  // Well know port for the daytime

    public static void main( String args[] ) {

	if ( args.length != 1 ) {
	    System.err.println( "Usage:  java DayTimeClient host" );
	}
	else {
	    try {
		// Attempt to connect to the specified host

		Socket sock = new Socket( args[ 0 ], DAYTIME_PORT );

		// Wrap a stream around the socket so we can read the
		// reply

		BufferedReader in = 
		    new BufferedReader( 
		        new InputStreamReader( sock.getInputStream() ) );

		// Read and print the reply sent by the server

		System.out.println( in.readLine() );

		// All done close the socket

                in.close();
		sock.close();
	    }
	    catch ( UnknownHostException e ) {
		System.err.println( "DayTimeClient:  no such host" );
	    }
	    catch ( IOException e ) {
		System.err.println( e.getMessage() );
	    }
	}

    }
  
} // DayTimeClient
