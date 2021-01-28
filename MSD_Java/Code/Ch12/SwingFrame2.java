/**
 * Display a JFrame with a simple message and a few buttons.
 */

import java.awt.*;
import javax.swing.*;

public class SwingFrame2 {
    // The size of the frame
    public static final int WIDTH = 325;
    public static final int HEIGHT = 150;

    // The length of the text field
    public static final int FIELD_LENGTH = 20;

    public static void main( String args[] ) {
	// Create the frame
	JFrame win = new JFrame( "My Second GUI Program" );

	// Establish the layout, size, and color of the frame
	win.setLayout( new FlowLayout() );
	win.setSize( WIDTH, HEIGHT );
	win.setBackground( Color.LIGHT_GRAY );

	// Put the message in the frame
	String msg = "Programs for sale: Fast, Reliable, Cheap:  choose 2";
	JLabel label1 = new JLabel( msg );
	win.add( label1 );

	// Add some more components to make things interesting
	JButton pushButton1 = new JButton( "Press here" );
	pushButton1.setBackground( Color.RED );
	win.add( pushButton1 );

	JButton pushButton2 = new JButton( "No, Press here" );
	pushButton2.setBackground( Color.RED );
	win.add( pushButton2 );

	String msg2 = "The button that was pressed: ";
	JLabel label2 = new JLabel( msg2 );
	win.add( label2 );
	
	JTextField field = new JTextField( FIELD_LENGTH );
	win.add( field );

	// Make it visible
	win.setVisible( true );
    }

} // SwingFrame2
