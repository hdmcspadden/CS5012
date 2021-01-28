import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Display a simple data entry screen.  This program illustrates the
 * use of listeners and a JComboBox.
 */
public class DataEntryGUI extends JFrame implements ActionListener {

    private static final int WIDTH = 775;         // Frame width
    private static final int HEIGHT = 250;        // Frame height
    private static final int PROMPT_WIDTH = 75;   // Prompt width
    private static final int PROMPT_HEIGHT = 15;  // Prompt height
    private static final int DATA_LENGTH = 30;    // Input field size
    private static final int NUM_FIELDS = 5;      // Number of fields

    // Constants used to identify the data entry fields
    private static final int NAME = 0;
    private static final int SCHOOL = 1;
    private static final int MAJOR = 2;
    private static final int HOMETOWN = 3;
    private static final int STATE = 4;

    // The states that will be listed by the JComboBox
    private static final String stateList[] = {
	"AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DE", "FL", "GA", 
	"HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", 
	"MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", 
	"NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", 
	"SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"
    };

    // The names of the fields on the GUI
    private static final String fieldName[] = {
	"Name:",
	"School:",
	"Major:",
	"Hometown:"
    };

    // This component will allow the user to select a state
    private JComboBox stateSelector;
 
    // The input areas will be stored in this array
    private JTextField field[];    

    // Where the completed information will be stored
    private JTextArea displayArea = 
	new JTextArea( NUM_FIELDS, DATA_LENGTH );

    /**
     * Create a data entry screen.
     *
     * @param title the frame title.
     */
    public DataEntryGUI( String title ) {
	super( title );  // Let the JFrame initialize things

	// Make prompts all the same size so things line up nicely
	Dimension promptSize = new Dimension( PROMPT_WIDTH, PROMPT_HEIGHT );

	// Create the array that will hold the text fields
	field = new JTextField[ fieldName.length ];

	// Create the data entry panel
	JPanel dataEntry = new JPanel();
	dataEntry.setLayout( new GridLayout( 0, 1 ) );

	// For each field on the GUI, create a panel that will
	// hold the name of the field and the text field associated
	// with the field.  This way we can be sure that the description
	// of the filed and the text area where the information is entered
	// will be in the same row.
	for ( int i = 0; i < field.length; i = i + 1 ) {
	    JPanel row = new JPanel();

	    // Create the text field
	    field[ i ] = new JTextField( DATA_LENGTH );

	    // Create the description for the field
	    JLabel prompt = new JLabel( fieldName[ i ] );
	    prompt.setPreferredSize( promptSize );

	    // Put them in the panel
	    row.add( prompt );
	    row.add( field[ i ] );

	    // Put the panel in the main frame
	    dataEntry.add( row );
	}

	// The state is handled differently because it is combo box
	// and not a text field like the others

	JPanel row = new JPanel();
	row.setLayout( new FlowLayout( FlowLayout.LEFT ) );

	JLabel prompt = new JLabel( "State" );
	prompt.setPreferredSize( promptSize );

	stateSelector = new JComboBox( stateList );

	row.add( prompt );
	row.add( stateSelector );

	dataEntry.add( row );

	// The data entry panel and the display area will be
	// placed in a single panel so that they occupy the
	// center area of the frame
	JPanel centerPanel = new JPanel();
	centerPanel.setLayout( new FlowLayout() );

	centerPanel.add( dataEntry );
	centerPanel.add( displayArea );

	// The buttons go in a separate panel and will
	// eventually be displayed in the south area of the frame
	JPanel buttonPanel = new JPanel();
	buttonPanel.setLayout( new FlowLayout() );

	JButton button = new JButton( "Store" );
	button.addActionListener( this );
	buttonPanel.add( button );

	button = new JButton( "Clear" );
	button.addActionListener( this );
	buttonPanel.add( button );

	button = new JButton( "Quit" );
	button.addActionListener( this );
	buttonPanel.add( button );

	// Setup the main frame
	setSize( WIDTH, HEIGHT );
	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	// Add the subcomponents to the main frame
	setLayout( new BorderLayout() );
	add( BorderLayout.CENTER, centerPanel );
	add( BorderLayout.SOUTH, buttonPanel );
    }
	
    /**
     * This method will be invoked whenever one of the buttons
     * on the GUI is pressed.
     *
     * @param e the event that caused this method to be invoked.
     */
    public void actionPerformed( ActionEvent e ) {
	// Get the label on the button that was pressed
	String arg = e.getActionCommand();
	
	// Determine which button was pressed
	if ( arg.equals( "Store" ) ) {
	    // If the store button was pressed, display the data entered
	    // in the display area of the GUI

	    // Erase any text currently being displayed
	    displayArea.setText( "" );

	    // Copy the contents of the text fields and put them in
	    // a single string separated by newline characters
	    for ( int i = 0; i < field.length; i = i + 1 ) {
		displayArea.append( field[ i ].getText() + '\n' );
	    }
	    
	    // Get the state from the combo box
	    String s = (String) stateSelector.getSelectedItem();

	    // Display the results
	    displayArea.append( s );
	}
	else if ( arg.equals( "Clear" ) ) {
	    // Erase any text currently being displayed
	    displayArea.setText( "" );
	}
	else {
	    // Terminate the program
	    System.exit( 0 );
	}
    }

    /**
     * Create an instance of a DataEntryGUI and make it visible.
     */
    public static void main( String args[] ) {
	DataEntryGUI mainWindow = new DataEntryGUI( "Student Information" );
	mainWindow.setVisible( true );
    }

} // DataEntryGUI	
