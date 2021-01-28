import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindowListener extends WindowAdapter {
    // We only need to override the methods that correspond to the
    // events we are interested in handling.  The stubs are
    // provided by the super class.

    /**
     * Invoked when the user attempts to close a window.
     */
    public void windowClosing( WindowEvent e ) { 
	// Simply terminate the program
	System.exit(0);
    }

} //MyWindowListener
