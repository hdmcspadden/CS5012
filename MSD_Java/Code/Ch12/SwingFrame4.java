/**
 * Display a JFrame with a simple message.
 */

import java.awt.*;	     // The packages that contain the classes
import javax.swing.*;        // that make up the AWT and Swing
import java.awt.event.*; 
import javax.swing.event.*;

public class SwingFrame4 {
    public static void main( String args[] ) {
	// Create the frame
	JFrame win = new JFrame( "My First GUI Program" );

	// Get the reference to the content pane
	Container contentPane = win.getContentPane();

	// Establish the layout, size, and color of the frame
	contentPane.setLayout( new FlowLayout() );
	win.setSize( 325, 150 );
	win.setBackground( Color.LIGHT_GRAY );

	// Configure the frame so the program exits if the user
	// closes the window
	win.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	// Put the message in the frame
	contentPane.add( 
	    new JLabel("Programs for sale: Fast, Reliable, Cheap: choose 2"));

	// Add some more components to make things interesting
	JButton pushButton1 = new JButton( "Press here" );
	pushButton1.setBackground( Color.BLUE );
	contentPane.add( pushButton1 );


	JButton pushButton2 = new JButton( "No, Press here" );
	pushButton2.setBackground( Color.BLUE );
	contentPane.add( pushButton2 );

	JLabel lab = new JLabel( "The button that was pressed: " );
	win.getContentPane().add( lab );
	
	JTextField tf = new JTextField( 20 );
	win.getContentPane().add( tf );

	// Create the object that will handle events and register
	// it with the buttons
	ActionListener buttonListener = new MyButtonListener( tf );
	pushButton1.addActionListener( buttonListener );
	pushButton2.addActionListener( buttonListener );

	// Make it visible
	win.setVisible( true );
    }

} // SwingFrame2
