import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Display a simple data entry screen.  This program illustrates the
 * use of listeners and a JComboBox.
 */
public class PriceEvaluator {

    public static void main( String args[] ) {
	JFrame win = new JFrame( "Price Evaluator" );
      
	win.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	win.getContentPane().setLayout( new BorderLayout() );

	JPanel items = new JPanel();
	items.setLayout( new GridLayout( 0, 1 ) );
	items.add( new JButton( "6-pack Coke" ) );
	items.add( new JButton( "Potato Chips" ) );
	items.add( new JButton( "White Bread" ) );
	items.add( new JButton( "Newspaper" ) );

	JPanel bill = new JPanel();
	JTextArea receipt = new JTextArea( 4, 11 );
	receipt.append( "White Bread\t$1.95\n" );
	receipt.append( "Newspaper\t$1.00\n" );
	receipt.append( "Total\t$2.95\n" );
	receipt.append( "Sales Tax\t$0.12\n" );
	receipt.append( "TOTAL\t$3.07" );
	bill.add( receipt );

	JLabel heading = 
	    new JLabel ( "             ITEM                                 BILL" );

				     
	win.getContentPane().add( heading, BorderLayout.NORTH );
	win.getContentPane().add( items, BorderLayout.WEST );
	win.getContentPane().add( bill, BorderLayout.EAST );
	win.getContentPane().add( new JButton( "Done" ),
				  BorderLayout.SOUTH );

	win.setSize( 250, 175 );
	win.show();
    }

} // DataEntryGUI	
