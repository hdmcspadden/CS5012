import java.awt.event.*;
import javax.swing.*;

pulbic class MyMouseListener extends MouseAdapter {

    // Where button information is displayed
    private JTextField displayField;

    /**
     * Create anew mouse listener that will display information using
     * the specified text fields.
     *
     * @param display where button information is displayed.
     */
    public MyMouseListener( JTextField display ) {
	displayField = display;
    }

    /**
     * Invoked when the mouse enters a component.  This method assumes
     * only buttons are looking for this event and will display
     * the button text using the designated text field.
     *
     * @param e the event that caused this method to be invoked.
     */
    public void mouseEntered( MouseEvent e ) {
	// Get a reference to the button that generated this event
	JButton button = (JButton)e.getComponent();

	// Display the button text in the text field
	displayField.setText( button.getText() );
    }

    /**
     * Invoked when the mouse leaves a component.  Causes the display
     * text field to be cleared.
     *
     * @param e the event that caused this method to be invoked.
     */
    public void mouseExited( MouseEvent e )  { 
	// We have exited a component - blank out the text field
	displayField.setText( "" );
    }

} // MyMouseListener
