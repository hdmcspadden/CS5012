import java.io.IOException;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import java.util.Date;

/**
 * A Java implementation of an UDP Daytime server.  This program
 * does not accept connections on the well-known port for the
 * daytime service.
 */

public class UDPDayTimeServer {

    public static int MAX_PACKET_SIZE = 1024;

    public static void main( String args[] ) {

	// Create the server socket bound to any port

	DatagramSocket sock = null;
	try {
	    sock = new DatagramSocket();
	}
	catch ( SocketException e ) {
	    System.err.println( "UDPDayTimeServer:  unable to create socket" );
	}

	// Create the datagram that messages will be read into

	byte data[] = new byte[ MAX_PACKET_SIZE ];

	DatagramPacket packet = new DatagramPacket( data, MAX_PACKET_SIZE );

	// Print the port so we can run a client that will connect to
	// the server.
	    
	System.out.println( "Listening on port:  " + sock.getLocalPort() );

	// Process clients forever...

	while ( true ) {
	    byte now[] = null;  // Current time as bytes
		
	    // Wait for a client to send a request

	    try {
		// Need to reset the size back to the full size
		// The size will be reset everytime a packet is
		// read.

		packet.setLength( MAX_PACKET_SIZE );
		sock.receive( packet );

		// Got something.  Put the current date and time into
		// the packet and send it back.

		now = new Date().toString().getBytes( "US-ASCII" );

		for ( int i = 0; i < now.length; i++ ) {
		    data[ i ] = now[ i ];
		}

		// Null terminate the string

		data[ now.length ] = 0;

		// Set the size of the packet

		packet.setLength( now.length + 1 );

		// Send the reply
		
		sock.send( packet );
	    }
	    catch ( IOException e ) {
		// Ignore anything that goes wrong.  This is perfectly
		// acceptable since UDP is an unreliable protocol
	    }
	}
    }

}  // UDPDayTimeServer
