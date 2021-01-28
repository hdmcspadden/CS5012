import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class Adder {
    public static void main( String args[] ) {
	JFrame win = new JFrame( "My First Adder" );

	win.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	win.getContentPane().setLayout( new BorderLayout() );

	JButton button = new JButton( "Add" );

	win.getContentPane().add( button, BorderLayout.SOUTH );

	JPanel middle = new JPanel();

	JPanel field = new JPanel();
	field.setLayout( new GridLayout(0,1) );
	JTextField text = new JTextField( 10 );
	field.add( text );
	field.add( new JLabel( "Number 1", SwingConstants.CENTER ) );
	middle.add( field );

	field = new JPanel();
	field.setLayout( new GridLayout(0,1) );
	text = new JTextField( 10 );
	field.add( text );
	field.add( new JLabel( "Number 2", SwingConstants.CENTER ) );
	middle.add( field );

	field = new JPanel();
	field.setLayout( new GridLayout(0,1) );
	text = new JTextField( 10 );
	field.add( text );
	field.add( new JLabel( "Sum", SwingConstants.CENTER ) );
	middle.add( field );

	win.getContentPane().add( middle, BorderLayout.CENTER );

	win.setSize( 400, 100 );
	win.show();
    }
}
