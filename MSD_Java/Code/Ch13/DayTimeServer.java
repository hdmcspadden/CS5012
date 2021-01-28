import java.io.IOException;
import java.io.PrintWriter;

import java.net.Socket;
import java.net.ServerSocket;

import java.util.Date;

/**
 * A Java implementation of a Daytime server.  This program
 * does not accept connections on the well-known port for the
 * daytime service.
 */

public class DayTimeServer {

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

		// Wrap streams around the socket so a reply can be sent

		PrintWriter out = 
		    new PrintWriter( client.getOutputStream(), true );

		// Print out the current date

		out.println( new Date() );

		// Thats it for this client

		out.close(); 
		client.close(); 
	    }
	    
	} catch( IOException e) {
	    System.err.println( e.getMessage() );
	}

    }

}  // DayTimeServer
