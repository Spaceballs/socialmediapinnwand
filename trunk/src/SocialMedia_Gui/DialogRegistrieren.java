/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Gui;

import SocialMedia_Client.SocialMediaClient;
import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Max
 */
public class DialogRegistrieren extends JFrame {
    
    private SocialMediaLogic server;
    
    JTextField username = new JTextField();
    JTextField name = new JTextField();
    JTextField surname = new JTextField();
    
    JPasswordField password = new JPasswordField();

    public DialogRegistrieren(SocialMediaLogic server, String username, String password) {
        this.server = server;
        this.username.setText(username);
        this.password.setText(password);
        initalize();
    }

    private DialogRegistrieren(SocialMediaLogic server, String username, String name, String surname, String password) {
        this.server = server;
        this.username.setText(username);
        this.name.setText(name);
        this.surname.setText(surname);
        this.password.setText(password);
        initalize();
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

        
        c.gridx = 1;
        c.gridy = 1;
        this.add(name, c);

        c.gridx = 0;
        c.gridy = 2;
        this.add(new JLabel("Vorname:", JLabel.RIGHT), c);

        
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
               
                if(username.getText().length() >= 3 && name.getText().length() >= 3 && surname.getText().length() >= 3 && new String(password.getPassword()).length()  >= 4 ){
                    Nutzer clientNutzer = null;
                    try {
                        clientNutzer = server.registrateNutzer(username.getText(), name.getText(), surname.getText(), new String(password.getPassword()));
                    } catch (RemoteException ex) {
                        Logger.getLogger(DialogRegistrieren.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (clientNutzer != null) {
                        dispose();
                        DialogAnmelden dialogAnmelden = new DialogAnmelden(server, username.getText(), new String(password.getPassword()));
                    } else {
                        dispose();
                        DialogRegistrieren dialogRegistrieren = new DialogRegistrieren(server, "Username already in use!", name.getText(), surname.getText(), new String(password.getPassword()));
                    }
                } else {
                    dispose();
                    DialogRegistrieren dialogRegistrieren = new DialogRegistrieren(server, "Min. 3 chars per field!", name.getText(), surname.getText(), new String(password.getPassword()));
                }
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
