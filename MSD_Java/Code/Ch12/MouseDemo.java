import java.awt.*;
import javax.swing.*;

public class MouseDemo extends JFrame {
    // The size of the frame
    private static final int WIDTH = 300;      // Frame width
    private static final int HEIGHT = 100;     // Frame height
    private static final int FIELD_SIZE = 20;  // Input field length

    /**
     * Create a GUI that demoonstrates how to use a MouseListener.
     *
     * @param title the title of the frame.
     */
    public MouseDemo( String title ) {
	super(title);

	JTextField display = new JTextField( FIELD_SIZE );
	JButton button = null;

	// The listener that will handle mouse events
	MyMouseListener listener = new MyMouseListener( display );

	// Set up the frame
	setSize( WIDTH, HEIGHT );
	setLayout( new GridLayout( 0, 2 ) );
	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	// Create two buttons and add them to the frame
	button = new JButton( "Button one" );
	button.setBackground( Color.RED );
	button.addMouseListener( listener );
	add( button );
	
	button = new JButton( "Button two" );
	button.setBackground( Color.YELLOW );
	button.addMouseListener( listener );
	add( button );
	
	// Label and text field for the mouse information
	add( new JLabel( "Button entered" ) );
	add( display );
    }

    /**
     * Display a MouseDemo GUI.
     */
    public static void main( String args[] ) {
	MouseDemo win = new MouseDemo( "Mouse Listeners" );

	win.setVisible( true );
    }

} // MouseDemo
