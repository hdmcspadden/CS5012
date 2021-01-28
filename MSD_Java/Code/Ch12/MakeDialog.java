import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MakeDialog {

    public static void main( String args[] ) {

	JFrame win = new JFrame( "A Frame" );

	JOptionPane.showMessageDialog( win, 
				       "You really goofed this time",
				       "Warning",
				       JOptionPane.WARNING_MESSAGE );
    }

}
