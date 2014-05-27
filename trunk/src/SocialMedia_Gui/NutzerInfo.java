
package SocialMedia_Gui;

import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import java.awt.BorderLayout;
import java.awt.Font;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Creates the content of the panelRechtsOben
 * Shows the username, name and surname of the logged-in Nutzer
 * @author Max
 */
public class NutzerInfo extends JPanel {

    private final SocialMediaLogic server;
    private final Nutzer clientNutzer;
    private final JLabel username = new JLabel("",JLabel.LEFT);
    private final JLabel name = new JLabel("", JLabel.LEFT);
    private final JLabel alias = new JLabel("alias", JLabel.LEFT);

    /**
     * Constructor
     * @param server - the server
     * @param clientNutzer - the logged-in Nutzer
     */
    public NutzerInfo(SocialMediaLogic server, Nutzer clientNutzer){
        this.clientNutzer = clientNutzer;
        this.server = server;
        initialize();
    }

    /**
     * Gets the username, name and surname of the logged-in Nutzer,
     * puts in in a GridLayout and
     * changes the font.
     */
    private void initialize() {
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(5,5,5,5));
        
        try {
            username.setText(clientNutzer.getUsername());
            name.setText(clientNutzer.getSurname() + " " + clientNutzer.getName());
        } catch (RemoteException ex) {
            Logger.getLogger(NutzerInfo.class.getName()).log(Level.SEVERE, null, ex);
        }

        username.setFont(new Font("Arial", Font.BOLD, 48));
        alias.setFont(new Font("Arial", Font.ITALIC, 20));
        name.setFont(new Font("Arial", Font.BOLD, 28));
        
        this.add(username, BorderLayout.NORTH);
        this.add(alias, BorderLayout.WEST);
        this.add(name, BorderLayout.SOUTH);
    }
}
