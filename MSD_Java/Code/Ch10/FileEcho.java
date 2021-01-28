/**
 * A program that opens a character based file, specified on the command
 * line, for reading and echos its contents to standard output.
 */

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileEcho {
  public static void main( String args[] ) {
      FileReader in = null;
      int ch;

      // Make sure the number of arguments is correct

      if ( args.length != 1 ) {
	  System.err.println( "Usage:  FileEcho sourceFile" );
      }
      else {
	  try {
	      // Attempt to open the file for reading
	      in = new FileReader( args[ 0 ] );
	      
	      // While there are characters left in the file to read, read one
	      // and echo it to the screen.  Note the cast on the invocation
	      // of the method read().  Without it this program will print out
	      // bytes (i.e. numbers).  Remember bytes != characters

	      while ( ( ch = in.read() ) != -1 ) {
		  System.out.print( (char)ch );
	      }
	  }
	  catch ( IOException e ) {
	      // Either an I/O error occurred or the file could not be opened
	      System.err.println( "FileEcho:  " + e.getMessage() );
	  }
	  finally {
	      // Close the file in a finally block.  This way, whether 
	      // an I/O exception is thrown or not, the file will be closed.
	      // Note that the file must be closed in a try block since
	      // close() throws an IOException.
	      try {
		  if ( in != null ) {
		      in.close();
		  }
	      }
	      catch( IOException e ) {
		  System.err.println( "FileEcho:  " + e.getMessage() );
	      }
	  }
      }
  }

} // FileEcho

