import java.io.IOException;
import java.io.PrintWriter;

import java.net.Socket;

import java.util.Date;

/**
 * This class handles a client connection to the Daytime service
 * in a separate thread.
 */

public class Connection extends Thread {

    private Socket myClient;  // The client this thread will service

    /**
     * Create a new connection.
     *
     * @param client the socket connected to the client.
     */

    public Connection( Socket client ) {
	myClient = client;
    }

    /**
     * Send the current date and time to the client.
     */

    public void run() {

	try {

	    // Wrap streams around the socket so a reply can be sent

	    PrintWriter out = 
		new PrintWriter( myClient.getOutputStream(), true );

	    // Print out the current date

	    out.println( new Date() );

	    // That is it for this client

	    myClient.close();

	} catch( IOException e) {
	    System.err.println( e.getMessage() );
	}
    }

}  // Connection
