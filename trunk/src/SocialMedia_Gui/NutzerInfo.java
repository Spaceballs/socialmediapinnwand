/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Gui;

import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Max
 */
public class NutzerInfo extends JPanel {

    private SocialMediaLogic server;
    private Nutzer clientNutzer = null;
    JLabel username = new JLabel("", JLabel.LEFT);
    JLabel name = new JLabel("", JLabel.LEFT);

    /**
     * Konstruktor
     * @param server
     * @param clientNutzer
     */
    public NutzerInfo(SocialMediaLogic server, Nutzer clientNutzer){
        this.clientNutzer = clientNutzer;
        this.server = server;
        initialize();
    }

    private void initialize() {
        try {
            username.setText(clientNutzer.getUsername());
            name.setText(clientNutzer.getSurname() + " " + clientNutzer.getName());
        } catch (RemoteException ex) {
            Logger.getLogger(NutzerInfo.class.getName()).log(Level.SEVERE, null, ex);
        }

        // GridBagLayout mit Abstand zwischen den Elementen.
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(5, 5, 5, 5);

        c.gridx = 0;
        c.gridy = 0;
        this.add(name, c);

        c.gridx = 0;
        c.gridy = 1;
        this.add(new JLabel("alias", JLabel.LEFT), c);

        c.gridx = 0;
        c.gridy = 2;
        this.add(username, c);

    }

}
