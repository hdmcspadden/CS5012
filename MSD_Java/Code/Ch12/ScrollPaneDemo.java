import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

public class ScrollPaneDemo {

    public static void main( String args[] ) {
	JFrame win = new JFrame( "A Scroll Pane" );

	JTextArea textArea = new JTextArea( 5, 30 );
	JScrollPane scrollPane = new JScrollPane( textArea );

	win.getContentPane().add(scrollPane, BorderLayout.CENTER);

	win.setVisible( true );
    }

} // ScrollPaneDemo
