import java.awt.*;
import javax.swing.*;

public class MouseTracker {

    public static void main( String args[] ) {
	JFrame win = new JFrame( "Mouse Tracker" );

	win.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	win.getContentPane().setLayout( new BorderLayout() );

	JPanel buttons = new JPanel();
	buttons.add( new JButton( "B1" ) );
	buttons.add( new JButton( "B2" ) );
	buttons.add( new JButton( "B3" ) );

	JPanel info = new JPanel();
	info.setLayout( new GridLayout( 1, 0 ) );
	info.add( new JLabel( "X:" ) );
	info.add( new JTextField( 5 ) );
	info.add( new JLabel( "  " ) );
	info.add( new JLabel( "Y:" ) );
	info.add( new JTextField( 5 ) );
	info.add( new JLabel( "  " ) );
	info.add( new JLabel( "Button:" ) );
	info.add( new JTextField( 5 ) );

	win.getContentPane().add( info, BorderLayout.CENTER );
	win.getContentPane().add( buttons, BorderLayout.SOUTH );

	win.setSize( 350, 90 );
	win.show();
    }
}
