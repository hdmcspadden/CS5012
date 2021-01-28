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
public class DirectorySvc {

    public static void main( String args[] ) {
	JFrame win = new JFrame( "Directory Service" );
      
	win.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	win.getContentPane().setLayout( new FlowLayout() );

	JPanel dept = new JPanel();
	dept.setLayout( new GridLayout( 0, 2 ) );
	dept.add( new JLabel( "Department:  " ) );
		  
	String deptList[] = { "Math", "CS", "Biology" };
	JComboBox deptSelector = new JComboBox( deptList );
	dept.add( deptSelector );

	JPanel info = new JPanel();
	info.setLayout( new GridLayout( 0, 2 ));
	info.add( new JLabel( "College:  " ));
	info.add( new JTextField( "Science",10 ));
	info.add( new JLabel( "Location:  " ));
	info.add( new JTextField( "222 Olin Hall",10 ));
	info.add( new JLabel( "Phone:  " ));
	info.add( new JTextField( "123-456-7890",10 ));

	win.getContentPane().add( dept );
	win.getContentPane().add( new JLabel( "  " ));
	win.getContentPane().add( info );

	win.setSize( 425, 100 );
	win.show();
    }

} // DataEntryGUI	
