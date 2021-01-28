/**
 * This program will either sum numbers from standard input or from a
 * file, depending on whether or not the user specifies a file name on
 * the command line.  The sum will be printed once the input has been
 * exhausted.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SumNums {
    public static void main( String args[] ) {
	BufferedReader in = null;

	// Hook up in to System.in or a FileReader depending on
	// the command line argument

	try {
	    if ( args.length > 0 ) {
		// Try to hook up to the first thing on the command line
		in = new BufferedReader( new FileReader( args[ 0 ] ) );
	    }
	    else {
		// Hook up to System.in
		in = new BufferedReader( new InputStreamReader( System.in ) );
	    }

	    // Sum the input and print the result
	    System.out.println( "The sum is " + sumInput( in ) );
	}
	catch ( IOException e ) {
	    System.err.println( "SumNums:  " + e.getMessage() );
	}
	finally {
	    try {
		if ( in != null ) {
		    in.close();
		}
	    }
	    catch ( IOException e ) {
		System.err.println( "SumNums:  " + e.getMessage() );
	    }
	}
    }

    /**
     * Read lines from the buffered reader and convert the integer values
     * on those lines to numbers.  The sum of the numbers is returned.
     * Note that this method takes a buffered reader as parameter and it
     * does not care if the buffered reader is connected to a file or the
     * standard input stream.
     *
     * @param in the buffered reader to process.
     *
     * @return the sum of the numbers in the stream.
     */

    public static int sumInput( BufferedReader in ) throws IOException {
	String line = null;
	int sum = 0;

	// Read the BufferedReader on line at a time
	while ( ( line = in.readLine() ) != null ) {
	    // Attempt to convert the string to an int.  If it
	    // can't be done ingore the line
	    try {
		sum = sum + Integer.parseInt( line );
	    }
	    catch ( NumberFormatException e ) {}
	}

	// Numbers are read and summed, return the results
	return sum;
    }

} // SumNums

