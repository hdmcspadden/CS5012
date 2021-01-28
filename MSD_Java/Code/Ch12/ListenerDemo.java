import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A GUI that incorporates components such as buttons, labels, and text
 * fields.  It also includes event listeners for these objects.
 */
public class ListenerDemo extends JFrame implements ActionListener {
    public static final int WIDTH = 350;     // Frame width
    public static final int HEIGHT = 100;    // Frame height
    public static final int ROWS = 0;        // Number of rows in grid
    public static final int COLS = 2;        // Number of columns in grid
    public static final int FIELD_LEN = 20;  // Size of text field

    // Displays the label of the button that was pressed.  This variable
    // needs to be accessed by the actionPerformed() method so it has
    // been declared to be part of the state of the object.
    private JTextField message;

    public ListenerDemo( String title ) {
	super( title );

	// Set up the main frame
	setLayout( new GridLayout( ROWS, COLS ) );
	setSize( WIDTH, HEIGHT );
	setBackground( Color.LIGHT_GRAY );

	// Use a window listener to terminate the program if the
	// user closes the window
	addWindowListener( new MyWindowListener() );

	// Create and configure the first button
	JButton pushButton1 = new JButton( "Press here" );
	pushButton1.setBackground( Color.BLACK );
	pushButton1.setForeground( Color.WHITE );
	add( pushButton1 );

	// Call the actionPerformed() method of this object whenever
	// the button is pressed
	pushButton1.addActionListener( this );

	// Create and configure the second button
	JButton pushButton2 = new JButton( "No, Press here" );
	pushButton2.setBackground( Color.BLACK );
	pushButton2.setForeground( Color.WHITE );
	add( pushButton2 );
	pushButton2.addActionListener( this );
	
	// This label is used to describe the contents of the text field
	JLabel lab = new JLabel( "The button that was pressed: " );
	getContentPane().add( lab );
	
	// When a button is pressed, the label that appears on the button
	// will be displayed in this text field.
	message = new JTextField( FIELD_LEN );
	add( message );
    }

    /**
     * This method will be invoked whenever one of the two buttons in
     * the GUI are pressed.  The label that appears in the button that
     * was pressed will be displayed in the text field on the screen.
     *
     * @param e the event that caused this method to be invoked.
     */
    public void actionPerformed( ActionEvent e ) {
	// Get the label of the button that was pressed from the event
	String buttonName = e.getActionCommand();

	// Display the label in the text field
	message.setText( buttonName );
    }

    /**
     * Create an instance of a ListenerDemo and display it on
     * the screen.
     */
    public static void main( String args[] ) {
	ListenerDemo win = new ListenerDemo( "Using Listener" );

	win.setVisible( true );
    }

} // ListenerDemo
