import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBarDemo2 extends JFrame {

    public MenuBarDemo2( String title ) {
	super( title );

	JMenuBar mb = new JMenuBar();	// create a new empty menu bar mb
	setJMenuBar( mb );	        // and place it into the menu bar 
	                                // section of f	

	JMenu fileMenu = new JMenu( "File" );  // create a pulldown File menu
	mb.add( fileMenu );		       // and add it to the menu bar

	JMenu editMenu = new JMenu( "Edit" );  // create an Edit menu
	mb.add( editMenu );		       // and add it to the menu bar

	JMenu viewMenu = new JMenu( "View" );	// create a View menu
	mb.add( viewMenu );			// and adds it to the menu bar

	JMenu specialMenu = new JMenu( "Special" );
	mb.add( specialMenu );

	JMenu helpMenu = new JMenu( "Help" );  // create an Insert menu
	mb.add( helpMenu );			   // and adds it to the menu

	JMenuItem mCut = new JMenuItem( "Cut" );
	editMenu.add( mCut );

	JMenuItem mCopy = new JMenuItem( "Copy" );
	editMenu.add( mCopy );

	JMenuItem mPaste = new JMenuItem( "Paste" );
	editMenu.add( mPaste );
    }

    public static void main( String args[] ) {
	MenuBarDemo2 win = new MenuBarDemo2( "Menu Components" );

	win.setVisible( true );
    }

} // MenuBarDemo
