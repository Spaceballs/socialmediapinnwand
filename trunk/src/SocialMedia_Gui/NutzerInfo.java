
package SocialMedia_Gui;

import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import java.awt.Font;
import java.awt.GridLayout;
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

    private SocialMediaLogic server;
    private Nutzer clientNutzer = null;
    JLabel username = new JLabel("",JLabel.LEFT);
    JLabel name = new JLabel("", JLabel.LEFT);
    JLabel alias = new JLabel("alias", JLabel.LEFT);

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
        try {
            username.setText(clientNutzer.getUsername());
            name.setText(clientNutzer.getSurname() + " " + clientNutzer.getName());
        } catch (RemoteException ex) {
            Logger.getLogger(NutzerInfo.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.setLayout(new GridLayout(3,1,0,0));
        EmptyBorder border = new EmptyBorder(20,40,20,40);
        this.setBorder(border);

        username.setFont(new Font("Arial", Font.BOLD, 48));
        alias.setFont(new Font("Arial", Font.ITALIC, 20));
        name.setFont(new Font("Arial", Font.BOLD, 28));

        this.add(username);
        this.add(alias);
        this.add(name);

    }

}
