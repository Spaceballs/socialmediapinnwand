
package SocialMedia_Gui;

import SocialMedia_Logic.SocialMediaLogic;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


/**
 * Dialog where user can search for other users
 * @author Max
 */
public class DialogSuchen extends JFrame {
    
    private final SocialMediaLogic server;

    /**
     * Constructor
     * @param server - the server
     */
    DialogSuchen(SocialMediaLogic server) {
        this.server = server;
        initializeDialog();
    }

    /**
     * Creates the Dialog with Label, TextField and Button
     */
    private void initializeDialog() {
        JPanel p = new JPanel(new BorderLayout(5,5));

        JPanel labels = new JPanel(new GridLayout(0,1,2,2));
        labels.add(new JLabel("Username", SwingConstants.RIGHT));
        p.add(labels, BorderLayout.WEST);

        JPanel controls = new JPanel(new GridLayout(0,1,2,2));
        JTextField username = new JTextField();
        controls.add(username);
        p.add(controls, BorderLayout.CENTER);

        JOptionPane.showMessageDialog(
            this, p, "Nutzer suchen", JOptionPane.PLAIN_MESSAGE);
        
        // http://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html#input
        
    }

}
