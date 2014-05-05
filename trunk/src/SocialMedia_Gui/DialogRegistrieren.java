/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Gui;

import SocialMedia_Client.SocialMediaClient;
import SocialMedia_Logic.SocialMediaLogic;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Max
 */
public class DialogRegistrieren extends JFrame {
    
    private SocialMediaLogic server;
    
    JTextField username = new JTextField();
    
    JPasswordField password = new JPasswordField();

    public DialogRegistrieren(SocialMediaLogic server, String username, String password) {
        this.server = server;
        initalize();
        this.username.setText(username);
        this.password.setText(password);
    }

    private void initalize() {
        // GridBagLayout mit Abstand zwischen den Elementen.
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(5, 5, 5, 5);

        // Abstand nach außen erzeugen.
        //dialog.setBorder(new EmptyBorder(10, 10, 10, 10));

        c.gridx = 0;
        c.gridy = 0;
        this.add(new JLabel("Username:", JLabel.RIGHT), c);

        
        c.gridx = 1;
        c.gridy = 0;
        this.add(username, c);

        c.gridx = 0;
        c.gridy = 1;
        this.add(new JLabel("Nachname:", JLabel.RIGHT), c);

        JTextField name = new JTextField();
        c.gridx = 1;
        c.gridy = 1;
        this.add(name, c);

        c.gridx = 0;
        c.gridy = 2;
        this.add(new JLabel("Vorname:", JLabel.RIGHT), c);

        JTextField surname = new JTextField();
        c.gridx = 1;
        c.gridy = 2;
        this.add(surname, c);

        c.gridx = 0;
        c.gridy = 3;
        this.add(new JLabel("Passwort:", JLabel.RIGHT), c);

        
        c.gridx = 1;
        c.gridy = 3;
        this.add(password, c);


        JButton registrieren = new JButton("Registrieren");
        c.gridx = 1;
        c.gridy = 4;
        this.add(registrieren, c);

        //ActionListener Button
        registrieren.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               dispose();
               new DialogAnmelden(server);
           }
        });

        this.setTitle("Registrieren");
        this.pack(); //Komplettes Frame auf optimale Größe packen
        //dialog.setSize(400,400);
        this.setLocationRelativeTo(null); //Position des Fensters
        this.setVisible(true); //Anzeigen des Frames

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
