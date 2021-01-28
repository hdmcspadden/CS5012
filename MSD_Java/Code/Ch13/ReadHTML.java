/**
 * Use the URL class to read the HTML associated with a
 * web page.  The URL for the web page is taken from the
 * command line.
 */

import java.net.URL;
import java.net.MalformedURLException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ReadHTML {

    public static void main( String[] args ) {

	// Usage

	if ( args.length != 1 ) {
	    System.err.println( "Usage:  java ReadHTML url" );
	}
	else {
	    try {
		// Create the URL

		URL webPage = new URL( args[ 0 ] );

		// Connect the streams

		BufferedReader in = 
		    new BufferedReader( 
		        new InputStreamReader( webPage.openStream() ) );

		// Used to store lines as they are read

		String line = null;

		// Read and print the HTML

		while ( ( line = in.readLine() ) != null ) {
		    System.out.println( line );
		}

		// Close the streams

		in.close();
	    }
	    catch ( MalformedURLException e ) {
		System.err.println( "ReadHTML:  Invalid URL" );
	    }
	    catch ( IOException e ) {
		System.err.println( "ReadHTML:  " + e.getMessage() );
	    }
	}
    }

} // ReadHTML
