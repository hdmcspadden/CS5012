import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BorderFactory;

import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

public class FlowLayoutDemo {

    public static void main( String args[] ) {
	JFrame win = new JFrame( "FlowLayout Alignment" );
	win.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	JPanel left = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
	left.setBorder( 
	    BorderFactory.createTitledBorder( 
	        BorderFactory.createLineBorder( Color.BLACK ), 
                "Left Alignment" ) );
	left.add( new JButton( "Component 1" ) );
	left.add( new JButton( "Component 2" ) );

	JPanel center = new JPanel( new FlowLayout( FlowLayout.CENTER ) );
	center.setBorder( 
	    BorderFactory.createTitledBorder( 
	        BorderFactory.createLineBorder( Color.BLACK ), 
                "Center Alignment" ) );
	center.add( new JButton( "Component 1" ) );
	center.add( new JButton( "Component 2" ) );

	JPanel right = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
	right.setBorder( 
	    BorderFactory.createTitledBorder( 
	        BorderFactory.createLineBorder( Color.BLACK ), 
                "Right Alignment" ) );
	right.add( new JButton( "Component 1" ) );
	right.add( new JButton( "Component 2" ) );

	Container content = win.getContentPane();
	content.setLayout( new GridLayout( 3, 0 ) );

	content.add( left );
	content.add( center );
	content.add( right );

	win.setVisible( true );
    }

} // FlowLayoutDemo
