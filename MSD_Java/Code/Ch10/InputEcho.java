/*
 * InputEcho.java
 *
 * Version:
 *    $Id$
 *
 * Revisions:
 *    $Log$
 */

import java.io.*;

/**
 * A program that opens a file from the command line for reading,
 * and echos its contents to standard output.
 *
 * @author Paul Tymann
 */

public class InputEcho {

    /**
     * The main method.
     *
     * @param args command line arguments (ignored).
     */

    public static void main( String args[] ) {
	String input;

	// Set things up to read from the keyboard

	BufferedReader
	    keyboard = 
	        new BufferedReader( new InputStreamReader( System.in ) );
    
	// Read stuff from input and dump to output

	try {
	    while ( ( input = keyboard.readLine() ) != null ) {
		System.out.println( input );
	    }
	} catch ( IOException e ) {
	    System.err.println( "InputEcho:  I/O error" );
	}
    }

} // InputEcho
