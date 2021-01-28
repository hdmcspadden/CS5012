/**
 * Copy files from the command line.  The contents of the first file on
 * the command line is copied into the second file on the command line.
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileCopy {
  public static void main( String args[] ) {
      BufferedInputStream in = null;
      BufferedOutputStream out = null;
      int data;

      // Check command line arguments

      if ( args.length != 2 ) {
	  System.out.println( "Usage:  FileCopy sourceFile destFile" );
      }
      else {
	  try {
	      // Open the input file.  A BufferedReader is used here to make
	      // the copy more efficient.  The copy could have been done
	      // using the FileInputStream only.
	      
	      // The FileInputStream was used instead of a FileReader since
	      // the program is interested in copying bytes and not necessarily
	      // characters/strings.
	      
	      in = new BufferedInputStream( 
		       new FileInputStream( args[ 0 ] ) );
	      
	      // Take care of the output side.  If the output file exists, it
	      // will be overwritten.
	      
	      out = new BufferedOutputStream( 
		        new FileOutputStream( args[ 1 ] ) );
	      
	      // Copy the files a byte at a time
	      while ( ( data = in.read() ) != -1 ) {
		  out.write( data );
	      }
	  }
	  catch ( FileNotFoundException e ) {
	      System.err.println( "FileCopy:  " + e.getMessage() );
	  }
	  catch ( IOException e ) {
	      System.err.println( "FileCopy:  " + e.getMessage() );
	  }
	  finally {
	      // The files are closed in the finally block so that no
	      // matter what happens the files will be closed.  Note that
	      // two try blocks are used in case the first close fails.
	      try {
		  if ( in != null ) {
		      in.close();
		  }
	      }
	      catch ( IOException e ) {
		  System.err.println( "FileCopy:  " + e.getMessage() );
	      }
	      
	      try {
		  if ( out != null ) {
		      out.close();
		  }
	      }
	      catch ( IOException e ) {
		  System.err.println( "FileCopy:  " + e.getMessage() );
	      }
	  }
      }
  }

} // FileCopy

