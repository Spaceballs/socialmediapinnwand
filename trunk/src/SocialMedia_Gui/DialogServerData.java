/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Gui;

import SocialMedia_Client.SocialMediaClient;
import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Sebastian
 */
public class DialogServerData extends JFrame implements ActionListener{
    
    private SocialMediaClient client;
    
    JTextField adresse = new JTextField();;
    JTextField port = new JTextField();

    public DialogServerData(SocialMediaClient client, String adresse, String port) {
        this.client = client;
        this.adresse.setText(adresse);
        this.port.setText(port);
        initialize();
    }

    private void initialize() {
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
        this.add(new JLabel("Server Adresse:", JLabel.RIGHT), c);
        c.gridx = 1;
        c.gridy = 0;
        this.add(adresse, c);
        c.gridx = 0;
        c.gridy = 1;
        this.add(new JLabel("Server Port:", JLabel.RIGHT), c);
        c.gridx = 1;
        c.gridy = 1;
        this.add(port, c);
        JButton anmelden = new JButton("Übernehmen");
        c.gridx = 0;
        c.gridy = 2;
        this.add(anmelden, c);

        //ActionListener Button Anmelden
        anmelden.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               client.executeClient(adresse.getText(), port.getText());
               dispose();
           }
        });

        this.setTitle("Server Data");
        this.pack(); //Komplettes Frame auf optimale Größe packen
        //dialog.setSize(400,400);
        this.setLocationRelativeTo(null); //Position des Fensters
        this.setVisible(true); //Anzeigen des Frames
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
//    andere Varianten
//        JDialog anmelden = new JDialog();
//
//        anmelden.setTitle("Anmelden");
//        anmelden.setLayout(new BorderLayout(5,5));
//        anmelden.setSize(200,200);
//        anmelden.setModal(true);
//
////        anmelden.add(new JLabel("Beispiel JLabel"));
//
//        JPanel labels = new JPanel(new GridLayout(0,1,2,2));
//        labels.add(new JLabel("Username", SwingConstants.RIGHT));
//        labels.add(new JLabel("Passwort", SwingConstants.RIGHT));
//        anmelden.add(labels, BorderLayout.WEST);
//
//        JPanel controls = new JPanel(new GridLayout(0,1,2,2));
//        JTextField adresse = new JTextField();
//        controls.add(adresse);
//        JPasswordField port = new JPasswordField();
////        port.addAncestorListener(new RequestFocusListener(false));
//        controls.add(port);
//        anmelden.add(controls, BorderLayout.CENTER);
//
//        JButton login = new JButton("Anmelden");
//        anmelden.add(login, BorderLayout.SOUTH);
//
//        JButton registrieren = new JButton("Registrieren");
//        anmelden.add(registrieren, BorderLayout.SOUTH);
//
//        anmelden.setVisible(true);
//        anmelden.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

//      _______________________________________________________________

//        JPanel p = new JPanel(new BorderLayout(5,5));
//
//        JPanel labels = new JPanel(new GridLayout(0,1,2,2));
//        labels.add(new JLabel("Username", SwingConstants.RIGHT));
//        labels.add(new JLabel("Passwort", SwingConstants.RIGHT));
//        p.add(labels, BorderLayout.WEST);
//
//        JPanel controls = new JPanel(new GridLayout(0,1,2,2));
//        JTextField adresse = new JTextField();
//        controls.add(adresse);
//        JPasswordField port = new JPasswordField();
////        port.addAncestorListener(new RequestFocusListener(false));
//        controls.add(port);
//        p.add(controls, BorderLayout.CENTER);
//
//        Object[] options = {"Anmelden", "Registrieren"};
//        JOptionPane.showOptionDialog(frame, p, "Anmelden", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

