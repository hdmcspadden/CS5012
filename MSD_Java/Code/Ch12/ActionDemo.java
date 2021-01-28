import javax.swing.JFrame;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ActionDemo extends JFrame implements ActionListener {

    private message;

    public ActionDemo( String title ) {
	super( title );

	// This GUI incorporates components such as buttons, labels,
	// and text fields.  It also includes event listeners for these 
	// objects.

	getContentPane().setLayout( new FlowLayout() );
	setSize( 500, 600 );
	setBackground(Color.lightGray);

	// now let's add some components to make it interesting
	JButton pushButton1 = new JButton("Press here");
	pushButton1.setBackground(Color.darkGray);
	getContentPane().add(pushButton1);
	pushButton1.addActionListener(this);

	JButton pushButton2 = new JButton("No, Press here");
	pushButton2.setBackground(Color.darkGray);
	getContentPane().add(pushButton2);
	pushButton2.addActionListener(this);
	
	JLabel lab = new JLabel("The button that was pressed: ");
	getContentPane().add(lab);
	
	message = new JTextField( 20 );
	getContentPane().add( message );
    }

    public void actionPerformed( ActionEvent e ) {
	String buttonName = e.getActionCommand();
	tf.setText( buttonName );
    }

    public static void main( String args[] ) {
	ActionDemo win = new ActionDemo( "Using Listener" );

	win.setVisisble( true );
    }

} 	// SwingFrame
