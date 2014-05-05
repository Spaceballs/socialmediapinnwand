/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Gui;

import SocialMedia_Client.SocialMediaClient;
import SocialMedia_Logic.SocialMediaLogic;
import javax.swing.*;
import java.awt.*;


/**
 *
 * @author Max
 */
public class DialogSuchen extends JFrame {
    
    private SocialMediaLogic server;

    DialogSuchen(SocialMediaLogic server) {
        this.server = server;
        initialize();
    }
        
    private void initialize() {
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
    }

}
