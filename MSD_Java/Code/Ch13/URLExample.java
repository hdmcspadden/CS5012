import java.net.*; 
import java.io.*;

public class URLExample {

    public static void main(String[] args) {
	String source = 
           "http://www.cs.rit.edu/~ptt/javaship.gif";
	try {
	    URL yahoo = new URL( source );
	    BufferedInputStream in = 
               new BufferedInputStream(yahoo.openStream());

	    int inputLine;
	    while ((inputLine = in.read()) != -1)
		System.out.println(inputLine);
	    in.close();
	} catch ( Exception ex ) {  ex.printStackTrace(); }}}
