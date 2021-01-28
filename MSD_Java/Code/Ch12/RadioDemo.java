import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;

public class RadioDemo {

    public static void main( String args[] ) {
	JFrame win = new JFrame( "Radio Buttons" );

	JRadioButton mnButton = new JRadioButton( "MN" );
        mnButton.setSelected(true);

        JRadioButton wiButton = new JRadioButton( "WI" );
        JRadioButton iaButton = new JRadioButton( "IA" );

        // Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add( mnButton );
        group.add( wiButton );
        group.add( iaButton );

	JPanel buttons = new JPanel();
	buttons.add( mnButton );
	buttons.add( wiButton );
	buttons.add( iaButton );

	win.getContentPane().add( buttons );

	win.setVisible( true );
    }

} // RadioDemo
