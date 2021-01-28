import java.awt.*;
import javax.swing.*;

public class ManPos {

    public static void main( String args[] ) {

	// Put "Example" into the title bar
	JFrame f = new JFrame( "Example" );

	// Set f to 300 pixels wide by 400 pixels high
	// with a light gray background color
	f. setSize( 300, 400 );
	f.setBackground( Color.lightGray );

	// Make it visible on the screen
	f.setVisible(true);

	// Assume that b is a button object.  
	// We will see how to do this later
	JButton b = new JButton( "A Button" );

	// Set button size to 70 pixels wide by 90 pixels high
	b.setSize(70, 90);

	// Position upper-left hand corner of b to (50, 10)
	b.setLocation(50, 10);

	// Now put b into the content pane
	// portion of the JFrame created above
	f.add(b);
    }

} // ManPos
