/**
 * A program reads integers from standard input,
 * sums them and prints out the result.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class InputNums {
  public static void main( String args[] ) {
      BufferedReader in = null;
      String line;
      int sum = 0;

      // Attempt to open the file for reading

      try {
	  // Connect System.in to a BufferedReader

	  in= new BufferedReader( new InputStreamReader ( System.in ) );

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
	  System.err.println( "InputNums:  " + e.getMessage() );
	  System.exit(1);
      }
      finally {
	  try {
	      if ( in != null ) {
		  in.close();
	      }
	  }
	  catch ( IOException e ) {
	      System.err.println( "InputNums:  " + e.getMessage() );
	  }
      }
  }

} // InputNums

