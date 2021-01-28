import java.io.IOException;

import java.net.Socket;
import java.net.ServerSocket;

/**
 * A multi-thread Java implementation of a Daytime server.  This program
 * does not accept connections on the well-known port for the
 * daytime service.
 */

public class TDayTimeServer {

    public static void main( String args[] ) {

	try {

	    // Create the server socket that will be used to accept
	    // incoming connections

	    ServerSocket listen = new ServerSocket( 0 ); // Bind to any port

	    // Print the port so we can run a client that will connect to
	    // the server.
	    
	    System.out.println( "Listening on port:  " + 
				listen.getLocalPort() );

	    // Process clients forever...

	    while ( true ) {

		// Wait for a client to connect

		Socket client = listen.accept();

		// Create and start the thread to handle the client

		Connection newThread = new Connection( client );
		newThread.start();
	    }
	    
	} catch( IOException e) {
	    System.err.println( e.getMessage() );
	}

    }

}  // TDayTimeServer
