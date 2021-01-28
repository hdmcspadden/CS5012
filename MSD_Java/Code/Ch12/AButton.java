import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AButton extends JFrame {

    public AButton( String text ) {
	super( "A Button" );
	
	Container content = getContentPane();

	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	
	content.setLayout( new BorderLayout( 20, 20 ) );

	JButton theButton = new JButton( text );
	theButton.setBackground( Color.RED );
	theButton.setForeground( Color.YELLOW );
	theButton.setFont( new Font( null, Font.BOLD, 25 ) );
	theButton.setBorder( 
	    BorderFactory.createLineBorder( Color.BLACK, 5 ) );

	theButton.setSize( 10, 20 );
	theButton.setLocation( 10, 10 );

	content.add( BorderLayout.NORTH, new JLabel( "     " ) );
	content.add( BorderLayout.EAST, new JLabel( "     " ) );
	content.add( BorderLayout.WEST, new JLabel( "     " ) );
	content.add( BorderLayout.SOUTH, new JLabel( "     " ) );
	content.add( BorderLayout.CENTER, theButton );
    }

    public static void main( String args[] ) {
	AButton win = new AButton( "Button Text" );

	win.setVisible( true );
    }

} // AButton
