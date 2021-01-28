/**
 * Display a JFrame with a simple message.
 */

import java.awt.*;
import javax.swing.*;

public class SwingFrame	{
    // The size of the frame
    public static final int WIDTH = 325;
    public static final int HEIGHT = 150;

    public static void main( String args[] ) {
	// Create the frame
	JFrame win = new JFrame( "My First GUI Program" );

	// Establish the layout, size, and color of the frame
	win.setLayout( new FlowLayout() );
	win.setSize( WIDTH, HEIGHT );
	win.setBackground( Color.LIGHT_GRAY );

	// Put the message in the frame
	String msg = "Programs for sale: Fast, Reliable, Cheap:  choose 2";
	JLabel label = new JLabel( msg );
	win.add( label );

	// Make it visible
	win.setVisible( true );
    }

} // SwingFrame
