/*
 * FileCopy.java
 *
 * Version:
 *    $Id$
 *
 * Revisions:
 *    $Log$
 */

import java.io.*;

/**
 * Copy files from the command line.  The contents of the first file on
 * the command line is copied into the second file on the command line.
 *
 * @author     Paul Tymann
 */

public class Finally {
  public static void main( String args[] ) {
      BufferedInputStream in = null;
      BufferedOutputStream out = null;
      int data;

      // Check command line arguments

      if ( args.length != 2 ) {
	  System.out.println( "Usage:  FileCopy sourceFile destFile" );
	  System.exit(1);
      }

      try {
	  // Open the input file.  A BufferedReader is used here to make
	  // the copy more efficient.  The copy could have been done
	  // using the FileInputStream only.

	  // The FileInputStream was used instead of a FileReader since
	  // the program is interested in copying bytes and not necessarily
	  // characters/strings.

	  in = new BufferedInputStream( new FileInputStream( args[ 0 ] ) );
	  
	  // Take care of the output side.  If the output file exists, it
	  // will be overwritten.
	  
	  out = new BufferedOutputStream( new FileOutputStream( args[ 1 ] ) );
      }
      catch ( FileNotFoundException e ) {
	  System.err.println( "FileCopy:  " + e.getMessage() );
	  System.exit( 1 );
      }

      // Now copy the files one byte at a time (note both in and
      // out are open at this point in the program)

      try {
	  // Copy the files a byte at a time
	  
	  while ( ( data = in.read() ) != -1 ) {
	      out.write( data );
	  }
      }
      catch ( IOException e ) {
	  System.err.println( "FileCopy:  " + e.getMessage() );
	  System.exit( 1 );
      }
      finally {
	  try {
	      out.close();
	      in.close();
	  }
	  catch ( IOException e ) {}
      } 
  }

} // FileCopy
