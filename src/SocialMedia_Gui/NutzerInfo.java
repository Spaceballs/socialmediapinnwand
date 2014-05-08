
package SocialMedia_Gui;

import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
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
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        EmptyBorder border = new EmptyBorder(20,0,20,20);
        this.setBorder(border);
        
        try {
            username.setText(clientNutzer.getUsername());
            name.setText(clientNutzer.getSurname() + " " + clientNutzer.getName());
        } catch (RemoteException ex) {
            Logger.getLogger(NutzerInfo.class.getName()).log(Level.SEVERE, null, ex);
        }

        username.setFont(new Font("Arial", Font.BOLD, 48));
        alias.setFont(new Font("Arial", Font.ITALIC, 20));
        name.setFont(new Font("Arial", Font.BOLD, 28));

        c.fill = GridBagConstraints.HORIZONTAL;
//        c.anchor = GridBagConstraints.LINE_START;
//        c.insets = new Insets(5, 5, 5, 5);

        c.gridx = 0;
        c.gridy = 0;
        this.add(username, c);

        c.gridx = 0;
        c.gridy = 1;
        this.add(alias, c);

        c.gridx = 0;
        c.gridy = 2;
        this.add(name, c);
    }

}
