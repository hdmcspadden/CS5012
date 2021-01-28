import java.awt.event.*;
import javax.swing.*;

public class MyButtonListener implements ActionListener {
    // The text field used to display the button information
    private JTextField display;

    /**
     * Create a new button listener that will use the given
     * text field to display button information.
     *
     * @param theDisplay the text field used to display button 
     *                  information.
     */
    public MyButtonListener( JTextField theDisplay ) {
	display = theDisplay;
    }

    /**
     * This method will be invoked whenever a button is pressed.
     * The label of the button that was pressed will be displayed
     * in the text field associated with this listener.
     *
     * @param e the event that caused this method to be invoked.
     */
    public void actionPerformed(ActionEvent e) {
	// Get the label of the button that was pressed
	String buttonName = e.getActionCommand();

	// Display the label in the text field
	display.setText( buttonName );
    }

} // MyButtonListener
