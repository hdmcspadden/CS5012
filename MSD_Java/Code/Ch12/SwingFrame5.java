import java.awt.*;		// here are the windowing methods
import java.awt.event.*;	// here are the event handlers	
import javax.swing.*;
import javax.swing.event.*;

class MyButtonListener implements ActionListener 	{
    public void actionPerformed(ActionEvent e)     {
	String buttonName = e.getActionCommand();
	tf.setText(buttonName);
    }
}

// This GUI incorporates components such as buttons, labels,
// and text fields.  It also includes event listeners for these objects.

public class SwingFrame5 {
    public static void main(String args[])		{
	JFrame win = new JFrame("My First GUI");
	win.getContentPane().setLayout(new FlowLayout());
	win.setSize(500, 600);
	win.setBackground(Color.lightGray);
	
	// now let's add some components to make it interesting
	JButton pushButton1 = new JButton("Press here");
	pushButton1.setBackground(Color.darkGray);
	win.getContentPane().add(pushButton1);
	pushButton1.addActionListener(new MyButtonListener());
	
	JButton pushButton2 = new JButton("No, Press here");
	pushButton2.setBackground(Color.darkGray);
	win.getContentPane().add(pushButton2);
	pushButton2.addActionListener(new MyButtonListener());
	
	JLabel lab = new JLabel("The button that was pressed: ");
	win.getContentPane().add(lab);
	
	JTextField tf = new JTextField(20);
	win.getContentPane().add(tf);
	
	win.setVisible(true);
    }

} // SwingFrame
