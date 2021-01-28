import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * A data input screen that allows students to selected courses.  Students
 * select from 1 to 3 courses and then press the finish button.  The
 * names of the courses wil be displayed in the text area.
 */
public class GUIExample1 
    extends JFrame implements ItemListener, ActionListener {

    private static final int WIDTH = 500;   // Frame width
    private static final int HEIGHT = 250;  // Frame height
    // The names of the courses
    private static final String courses[] = { "CS 101", 
                                              "CS 102",
					      "CS 210",
					      "CS 215",
					      "CS 217",
					      "CS 302" };

    private Set<String> selectedCourses;  // Selected courses
    private JTextArea display;            // Message display area

    /**
     * Create a new course selection screen.
     *
     * @param title the title to be placed in the frame.
     */
    public GUIExample1( String title ) {
	super( title );

	// Use a tree set so the courses are display in alphabetical order
	selectedCourses = new TreeSet<String>();

	// Set frame attributes
	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	setSize( WIDTH, HEIGHT );
	setLayout( new BorderLayout() );
	
	// Instructions for the user
	JLabel l1 = new JLabel( "Please select the courses you wish " +
			      " to take.  Click on the Finished button " +
			      "when done." );

	add(l1, BorderLayout.NORTH );
			 
	// The check boxes for course selection will go in a panel.
	JPanel checkPanel = new JPanel();
	checkPanel.setLayout( new GridLayout( courses.length, 0 ) );
	checkPanel.setBorder( BorderFactory.createEtchedBorder() );

	// Create the check boxes and add them to the panel
	for ( int i = 0; i < courses.length; i++ ) {
	    JCheckBox box = new JCheckBox( courses[ i ] );

	    // This object will handle the state change events
	    box.addItemListener( this );

	    checkPanel.add( box );
	}

	add( checkPanel, BorderLayout.WEST );
	
	// Create the finished button
	JButton done = new JButton( "Finished" );
	done.addActionListener( this );

	add( done, BorderLayout.SOUTH );

	// Create the text box that will be used to display messages
	display = new JTextArea( 10, 20 );
	display.setBorder( 
	    BorderFactory.createTitledBorder(
	        BorderFactory.createEtchedBorder(),
		"Courses Selected" ) );
	display.setBackground( getBackground() );

	add( display, BorderLayout.CENTER );
    }

    /**
     * This method will be called whenever the user clicks on a check
     * box.  If the user is selecting a course it will be added to
     * the set of selected courses.  If they are deselecting a course
     * it will be removed from the set.
     *
     * @param event the item event that caused this method to be invoked.
     */
    public void itemStateChanged( ItemEvent event ) {
	// The label on the checkbox is the name of the course
	String courseName = ((JCheckBox)event.getItem() ).getText();

	if ( event.getStateChange() == ItemEvent.SELECTED ) {
	    // They are adding the course
	    selectedCourses.add( courseName );
	}
	else {
	    // They are dropping the course
	    selectedCourses.remove( courseName );
	}
    }
    
    /**
     * This method will be invoked whenever the user clicks on the finished
     * button.  If between 1 and 3 courses have been selected, the names of
     * the course are displayed in the GUI.  If the incorrect number of
     * courses is selected an error message is displayed.
     *
     * @param even the action event that caused this method to be invoked.
     */
    public void actionPerformed( ActionEvent event ) {
	// What will be displayed on the screen
	String text = "";

	if ( selectedCourses.size() < 1 ||
	     selectedCourses.size() > 3 ) {
	    // Too few or too many courses - display error message
	    text = "You must select between 1 and 3 courses";
	}
	else {
	    // Use an iterator to get the course names out of the
	    // set and format them into a string separated by
	    // newline characters
	    Iterator<String> i = selectedCourses.iterator();
	    while ( i.hasNext() ) {
		text = text + i.next() + "\n";
	    }
	}

	// Display the message
	display.setText( text );
    }
    
    /**
     * Run the course selection program.
     *
     * @param args command line arguments (ignored).
     */
    public static void main( String args[] ) {
	// Create the GUI
	GUIExample1 screen = new GUIExample1( "Course Selection" );

	// Display it on the screen
	screen.setVisible( true );
    }

} // GUIExample1
