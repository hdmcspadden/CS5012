import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MakePopup {
    public static void main( String args[] ) {
	JFrame win = new JFrame();

	JOptionPane.showMessageDialog( win, 
				       "You Really Goofed This Time",
				       "Warning",
				       JOptionPane.ERROR_MESSAGE );
    }

} // MakePopup
