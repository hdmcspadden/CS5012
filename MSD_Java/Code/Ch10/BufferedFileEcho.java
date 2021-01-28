/**
 * A program that opens a character based file, and uses a BufferedReader
 * to read the contents of the file by lines.  The contents of the file
 * are echoed to standard output.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedFileEcho {
    public static void main( String args[] ) {
      BufferedReader in = null;
      String line = null;

      // Make sure the number of arguments is correct

      if ( args.length != 1 ) {
	  System.err.println( "Usage:  BufferedFileEcho sourceFile" );
      }
      else {
	  // Attempt to open the file for reading.  Note that this
	  // program does some additional "plumbing".  It creates
	  // the FileReader and then wraps a BufferedReader around
	  // it.  The program will read from the BufferedReader which 
	  // in turn will read from the FileReader.
	  
	  try {
	      in = new BufferedReader( new FileReader( args[ 0 ] ) );

	      // While there are lines left in the file, read a line and
	      // print it on the screen.  Note that readLine() strips the
	      // line termination character(s) from the input which is why
	      // the lines are printed using println()
	      
	      while ( ( line = in.readLine() ) != null ) {
		  System.out.println( line );
	      }
	  }
	  catch ( IOException e ) {
	      // Either an I/O error ocurredor the file could not be opened
	      System.err.println( "BufferedFileEcho:  " + e.getMessage() );
	  }
	  finally {
	      // Close the file in a finally block.  This way whether the
	      // an I/O exception is thrown or not, the file will be closed.
	      // Note that the file must be closed in a try block since
	      // close() throws an IOException.
	      try {
		  if ( in != null ) {
		      in.close();
		  }
	      }
	      catch( IOException e ) {
		  System.err.println( "BufferedFileEcho:  " + e.getMessage() );
	      }
	  }
      }
  }

} // BufferedFileEcho

