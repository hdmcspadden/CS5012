import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuBarDemo extends JFrame {

    public static class MyMenuListener implements ActionListener {
	public void actionPerformed( ActionEvent e ) {
	    String command = e.getActionCommand();
	    if ( command.equals( "New" ) ) {
		//newProcedure();
	    }
	    else if ( command.equals( "Open" ) ) {
		//openProcedure();
	    }
	    else if ( command.equals( "Save" ) ) {
		//saveProcedure();
	    }
	    else if ( command.equals( "Quit" ) ) {
		System.exit( 0 );
	    }
	}
    }

    public MenuBarDemo( String title ) {
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

	JMenu insertMenu = new JMenu( "Insert" );  // create an Insert menu
	mb.add( insertMenu );			   // and adds it to the menu

	JMenuItem mNew = new JMenuItem( "New" );
	fileMenu.add( mNew );

	JMenuItem mOpen = new JMenuItem( "Open" );
	fileMenu.add( mOpen );

	JMenuItem mSave = new JMenuItem( "Save" );
	fileMenu.add( mSave );

	JMenuItem mQuit = new JMenuItem( "Quit" );
	fileMenu.add( mQuit );
	mQuit.addActionListener( new MyMenuListener() );
    }

    public static void main( String args[] ) {
	MenuBarDemo win = new MenuBarDemo( "Menu Bar Demo" );

	win.show();
    }

} // MenuBarDemo
