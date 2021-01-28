/**
 * A program that opens a text file consisting of lines that
 * have one integer each.  The numbers are read, summed, and the
 * total is printed.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadNums {
  public static void main( String args[] ) {
      BufferedReader in = null;
      String line = null;
      int sum = 0;

      // Make sure the number of arguments is correct

      if ( args.length != 1 ) {
	  System.err.println( "Usage:  ReadNums sourceFile" );
      }
      else {
	  try {
	      // Attempt to open the file for reading
	      in = new BufferedReader( new FileReader( args[ 0 ] ) );
	      
	      // Read the numbers a line at a time from the source file
	      while ( ( line = in.readLine() ) != null ) {
		  
		  // Attempt to convert the string to an int.  If it
		  // can't be done ingore the line

		  try {
		      sum = sum + Integer.parseInt( line );
		  }
		  catch ( NumberFormatException e ) {}
	      }

	      // Numbers are read and summed, print out the results

	      System.out.println( "The sum is " + sum );
	  }
	  catch ( IOException e ) {
	      System.err.println( "ReadNums:  " + e.getMessage() );
	  }
	  finally {
	      try {
		  if ( in != null ) {
		      in.close();
		  }
	      }
	      catch ( IOException e ) {
		  System.err.println( "ReadNums:  " + e.getMessage() );
	      }
	  }
      }
  }

} // ReadNums

