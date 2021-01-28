import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A simple four-function calculator.
 */
public class Calculator extends JFrame implements ActionListener {
    // The labels on the buttons
    private static final String labels = "789X456/123-0C=+";

    // Frame size
    private static final int WIDTH = 200;
    private static final int HEIGHT = 200;

    // The font to use in the display
    private static final Font DISPLAY_FONT = new Font( null, Font.BOLD, 20 );

    // Number of rows and columns to use when displaying the buttons
    private static final int NUM_ROWS = 4;
    private static final int NUM_COLS = 4;

    // The object that knows how to do the arithmetic
    private CalcLogic myCalc;

    // The display portion of the GUI
    private JLabel display;

    /**
     * Create a new calculator.
     */
    public Calculator( String name ) {
	super( name );

	JPanel buttonPanel = new JPanel();

	// The object that knows how to process keys.  This GUI
	// will simply catch button presses and pass them on to this
	// object that knows what to do with them
        myCalc = new CalcLogic();

	// Configure the frame
	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	setLayout( new BorderLayout() );
	setSize( WIDTH, HEIGHT );
	setResizable( false );

	// Create the button panel
	buttonPanel.setLayout( new GridLayout( NUM_ROWS, NUM_COLS ) );

	// Create the buttons and place them in the panel
	for ( int i = 0 ; i < labels.length() ; i = i + 1 ) {
	    JButton b = new JButton( labels.substring( i, i + 1 ) );
	    b.addActionListener( this );
	    buttonPanel.add( b );
	}

	// Create the display
	display = new JLabel( "0", JLabel.RIGHT );
	display.setFont( DISPLAY_FONT );

	// "Assemble" the calculator
	add( BorderLayout.NORTH, display );
	add( BorderLayout.CENTER, buttonPanel);
    }

    /**
     * Return the current contents of the display portion of the
     * GUI.
     *
     * @return the contents of the display.
     */
    public String getDisplay() {
      return display.getText();
    }

    /**
     * Set the contents of the display.
     *
     * @param text the value to place in the display.
     */
    public void setDisplay( String text ) {
      display.setText( text );
    }

    /**
     * Invoked whenever a user presses a button.  The button press
     * is simply passed on to the calculator engine which processes
     * the button and updates the display if required.
     *
     * @param e the event that caused this method to be invoked.
     */
    public void actionPerformed( ActionEvent e ) {
	// Get the name of the button that was pressed
	String s = e.getActionCommand();

	// Let the logic object handle it
        myCalc.handleButton( s, this ) ;
    }

    /**
     * Create and display a calculator.
     */
    public static void main( String args[] ) {
	Calculator calcGUI = new Calculator( "A Java Calculator" );
	calcGUI.setVisible( true );
    }

} // Calculator
