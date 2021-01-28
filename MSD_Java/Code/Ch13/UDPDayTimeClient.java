import java.io.IOException;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * A simple client that will query the daytime service on a
 * remote to determine the date and time at that location.
 */

public class UDPDayTimeClient {

    public static final int MAX_PACKET_SIZE = 1024;
    public static final int TIMEOUT_PERIOD = 3000;  // 3 seconds

    public static void main( String args[] ) {

	if ( args.length != 2 ) {
	    System.err.println( "Usage:  UDPDayTimeClient host port" );
	}
	else {
	    try {
		// Create a socket to send and receive on

		DatagramSocket sock = new DatagramSocket();

		// Determine the IP address of the server

		InetAddress server = InetAddress.getByName( args[ 0 ] );
	    
		// Get the port

		int port = Integer.parseInt( args[ 1 ] );

		// Assemble an empty packet to send

		DatagramPacket packet = 
		    new DatagramPacket( new byte[ MAX_PACKET_SIZE ], 
					MAX_PACKET_SIZE,
					server,
					port );

		// The message from the server

		String serverTime = null;

		// Send the packet to the server

		sock.send( packet );

		// Wait for a reply from the server, but only
		// for the specified timeout period

		sock.setSoTimeout( TIMEOUT_PERIOD );
		sock.receive( packet );

		// Convert the message to a string and print it

		serverTime = new String( packet.getData(),
					 0,
					 packet.getLength() - 1,
					 "US-ASCII" );

		System.out.println( serverTime );

		// All done close the socket

		sock.close();
	    }
	    catch ( UnknownHostException e ) {
		System.err.println( "UDPDayTimeClient:  no such host" );
	    }
	    catch ( SocketException e ) {
		System.err.println( "UDPDayTimeClient:  can't create socket" );
	    }
	    catch ( SocketTimeoutException e ) {
		System.out.print( "No response from server" );
	    }
	    catch ( IOException e ) {
		System.err.println( e.getMessage() );
	    }
	}

    }
  
} // DayTimeClient
