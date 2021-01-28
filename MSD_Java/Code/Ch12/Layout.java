import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;

/**
 * Insert Javadoc comment here
 *
 * @author Paul Tymann (ptt@cs.rit.edu)
 */

public class Layout {

    private static String labels[] = { "one",
				       "two",
				       "three",
				       "four",
				       "five",
				       "six",
				       "seven",
				       "eight",
				       "nine",
				       "ten",
				       "eleven",
				       "twelve" };

    public static void main( String args[] ) {
	JFrame win = new JFrame( "Using a Grid Layout" );

	// To generate the screen shots in figure 12-9 uncomment
	// th eline below.
	//win.setLayout( new FlowLayout() );

	// To generate the screen shots in figure 12-11 uncomment
	// the line below.
	win.setLayout( new GridLayout(5,0) );

	for ( int i = 0; i < labels.length; i++ )
	    win.add( new JButton( labels[ i ] ) );

	win.setVisible( true );
    }

} // Layout
