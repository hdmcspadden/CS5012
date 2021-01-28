import java.awt.event.*;

public class MyMenuListener implements ActionListener {

    public void actionPerformed( ActionEvent e ) {
        String command = e.getActionCommand();
        if ( command.equals( "Cut" ) ) {
            cutProcedure();
        }
        else if ( command.equals( "Copy" ) ) {
            copyProcedure();
        }
        else if ( command.equals( "Paste" ) ) {
            pasteProcedure();
        }
    }

} // MyMenuListener
