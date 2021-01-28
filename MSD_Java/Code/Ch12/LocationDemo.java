import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.FlowLayout;

public class LocationDemo {
    public static void main( String args[] ) {
	JFrame win = new JFrame( "Manual Layout" );

	win.getContentPane().setLayout( new FlowLayout() );

	JTextArea comp = new JTextArea( 5, 10 );
	comp.setBackground( Color.RED );
	comp.setLocation( 50, 10 );

	win.getContentPane().add( comp );

	win.setVisible( true );
    }

} // LocationDemo
