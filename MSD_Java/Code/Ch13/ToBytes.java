import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.net.DatagramPacket;

public class ToBytes {

    public static void main( String args[] ) {

	try {
	    DatagramPacket pak = makePak( 50964, "Hello World" );

	    System.out.println( "Number:  " + getNumber( pak ) );
	    System.out.println( "Message:  " + getString( pak ) );
	}
	catch ( IOException e ) {
	    System.out.println( e.getMessage() );
	}
    }

    public static DatagramPacket makePak( int number, String message ) 
	throws IOException {

	DatagramPacket retVal = null;
	byte data[] = null;
    
	// Streams used to do the conversion

	ByteArrayOutputStream bytes = new ByteArrayOutputStream();
	DataOutputStream out = new DataOutputStream( bytes );

	// Write the message into the stream.  Make sure to flush
	// the stream so that all the bytes are sent to the
	// byte array.  Note these methods may throw an exception.

	out.writeInt( number );
	out.writeBytes( message );
	out.flush();

	// Get the message in byte form
	
	data = bytes.toByteArray();

	// Close the streams

	out.close();
	bytes.close();

	// Create the datagram
	
	retVal = new DatagramPacket( data, data.length );
	
	return retVal;
    }

    public static int getNumber( DatagramPacket packet ) 
	throws IOException {

	// Wrap streams around the data portion of the packet so
	// that the integer in the first part of the packet can
	// be extracted

	DataInputStream data =
	    new DataInputStream( 
	        new ByteArrayInputStream( packet.getData() ) );

	// Read the number and return

	return data.readInt();
    }

    public static String getString( DatagramPacket packet ) 
	throws IOException {

	// Extract the string using one of the constructors of
	// the string class.

	return new String( packet.getData(),        // Where the codes are
			   4,                       // Where the codes start
			   packet.getLength() - 4,  // Length of the string
                           "US-ASCII" );            // Coding used
    }

} // ToBytes
