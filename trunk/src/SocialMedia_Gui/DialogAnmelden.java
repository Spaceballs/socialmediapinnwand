/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Max
 */
public class DialogAnmelden extends JFrame implements ActionListener{

    public DialogAnmelden() {
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
        this.add(new JLabel("Username:", JLabel.RIGHT), c);

        JTextField username = new JTextField();
        c.gridx = 1;
        c.gridy = 0;
        this.add(username, c);

        c.gridx = 0;
        c.gridy = 1;
        this.add(new JLabel("Passwort:", JLabel.RIGHT), c);

        JPasswordField password = new JPasswordField();
        c.gridx = 1;
        c.gridy = 1;
        this.add(password, c);


        JButton anmelden = new JButton("Anmelden");
        c.gridx = 0;
        c.gridy = 2;
        this.add(anmelden, c);

        JButton registrieren = new JButton("Registrieren");
        c.gridx = 1;
        c.gridy = 2;
        this.add(registrieren, c);

        //ActionListener Button Anmelden
        anmelden.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               dispose();
               new Hauptfenster();
           }
        });

        //ActionListener Button Registrieren
        registrieren.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               dispose();
               new DialogRegistrieren();
           }
        });

        this.setTitle("Anmelden");
        this.pack(); //Komplettes Frame auf optimale Größe packen
        //dialog.setSize(400,400);
        this.setLocationRelativeTo(null); //Position des Fensters
        this.setVisible(true); //Anzeigen des Frames

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


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
//        JTextField username = new JTextField();
//        controls.add(username);
//        JPasswordField password = new JPasswordField();
////        password.addAncestorListener(new RequestFocusListener(false));
//        controls.add(password);
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
//        JTextField username = new JTextField();
//        controls.add(username);
//        JPasswordField password = new JPasswordField();
////        password.addAncestorListener(new RequestFocusListener(false));
//        controls.add(password);
//        p.add(controls, BorderLayout.CENTER);
//
//        Object[] options = {"Anmelden", "Registrieren"};
//        JOptionPane.showOptionDialog(frame, p, "Anmelden", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }

    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}