import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Display a simple data entry screen.  This program illustrates the
 * use of listeners and a JComboBox.
 */
public class ComboBoxDemo extends JFrame {

    public ComboBoxDemo( String title ) {
	super( title );  // Let the JFrame initialize things

	// Get a reference to the content pane for convience
	Container contentPane = getContentPane();

	JPanel row = new JPanel();
	row.setLayout( new FlowLayout( FlowLayout.LEFT ) );

	JLabel prompt = new JLabel( "State:  " );

	String stateList[] = { "MN", "WI", "IA" };
	JComboBox stateSelector = new JComboBox( stateList );

	row.add( prompt );
	row.add( stateSelector );

	contentPane.add( row );

	// Setup the main frame
	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
	
    /**
     * Create an instance of a DataEntryGUI and make it visible.
     */
    public static void main( String args[] ) {
	ComboBoxDemo mainWindow = new ComboBoxDemo( "A JCombo Box" );
	mainWindow.setVisible( true );
    }

} // DataEntryGUI	
