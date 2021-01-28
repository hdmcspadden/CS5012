import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.BorderLayout;

public class BorderLayoutDemo {

    public static void main( String args[] ) {
	// Create a new JFrame called win
	JFrame win = new JFrame( "Using a Border Layout" );

	// Select a border layout
	win.setLayout( new BorderLayout() );

	// Now add buttons to each of the five regions of the screen
	win.add( BorderLayout.NORTH, new JButton( "North" ) );
	win.add( BorderLayout.SOUTH, new JButton( "South" ) );
	//win.add( BorderLayout.EAST, new JButton( "East" ) );
	//win.add( BorderLayout.WEST, new JButton( "West" ) );
	win.add( BorderLayout.CENTER, new JButton( "Center" ) );

	// Show it
	win.setVisible( true );
    }

} // BorderLayoutDemo

