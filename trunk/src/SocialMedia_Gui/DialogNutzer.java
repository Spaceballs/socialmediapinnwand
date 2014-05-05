/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Gui;

import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Max
 */
public class DialogNutzer extends JFrame {
    
    private SocialMediaLogic server;
    private JTextField username = new JTextField();
    private JTextField name = new JTextField();
    private JTextField surname = new JTextField();
    private JPasswordField password = new JPasswordField();
    private JPanel controls = new JPanel(new GridLayout(0,1,2,2));
    private JPanel p = new JPanel(new BorderLayout(5,5));
    private Nutzer clientNutzer = null;
    public JPanel labels;
    
    /**
     * 
     * @param server
     * @param clientNutzer 
     */
    public DialogNutzer(SocialMediaLogic server, Nutzer clientNutzer){
        this.server = server;
        this.clientNutzer = clientNutzer;
        try {
            this.username.setText(clientNutzer.getUsername());
            this.name.setText(clientNutzer.getName());
            this.surname.setText(clientNutzer.getSurname());
            this.password.setText(clientNutzer.getPassword());
        } catch (RemoteException ex) {
            Logger.getLogger(DialogNutzer.class.getName()).log(Level.SEVERE, null, ex);
        }
        initialize();
    }

    /**
     * 
     */
    private void initialize() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        labels = new JPanel(new GridLayout(0,1,2,2));
        labels.add(new JLabel("Username", SwingConstants.RIGHT));
        labels.add(new JLabel("Nachname", SwingConstants.RIGHT));
        labels.add(new JLabel("Vorname", SwingConstants.RIGHT));
        labels.add(new JLabel("Passwort", SwingConstants.RIGHT));
        p.add(labels, BorderLayout.WEST);

        
        controls.add(username);
        controls.add(name);
        controls.add(surname);
        
//        password.addAncestorListener(new RequestFocusListener(false));
        controls.add(password);
        p.add(controls, BorderLayout.CENTER);

        String[] buttons = {"Speichern", "Account löschen"};

        if (JOptionPane.showOptionDialog(
                this, p, "Accountdaten ändern", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, buttons, buttons[0])
            == 1) {
                if (JOptionPane.showConfirmDialog(this,
                        "Den Account wirklich löschen?", "Account löschen",
                        JOptionPane.YES_NO_OPTION) == 0) {
                    try {
                        server.deactivateNutzer(clientNutzer);
                        dispose();
                    } catch (RemoteException ex) {
                        Logger.getLogger(DialogNutzer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Gelöscht");
                }
            } else {
                try {
                    Nutzer clientNutzerBarbeitet;
                    clientNutzerBarbeitet = server.editNutzer(username.getText(), name.getText(), surname.getText(), new String(password.getPassword()), clientNutzer);
                    if (clientNutzerBarbeitet == null){
                        // TO-DO: Error Behaviour
                    } else {
                        dispose();
                    }   
                } catch (RemoteException ex) {
                    Logger.getLogger(DialogNutzer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
//        alte Variante
//        final JFrame dialog = new JFrame("Accoundaten ändern");
//
//        // GridBagLayout mit Abstand zwischen den Elementen.
//        dialog.setLayout(new GridBagLayout());
//        GridBagConstraints c = new GridBagConstraints();
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.anchor = GridBagConstraints.LINE_START;
//        c.insets = new Insets(5, 5, 5, 5);
//
//        // Abstand nach außen erzeugen.
//        //dialog.setBorder(new EmptyBorder(10, 10, 10, 10));
//
//        c.gridx = 0;
//        c.gridy = 0;
//        dialog.add(new JLabel("Username:", JLabel.RIGHT), c);
//
//        JTextField username = new JTextField();
//        c.gridx = 1;
//        c.gridy = 0;
//        dialog.add(username, c);
//
//        c.gridx = 0;
//        c.gridy = 1;
//        dialog.add(new JLabel("Nachname:", JLabel.RIGHT), c);
//
//        JTextField name = new JTextField();
//        c.gridx = 1;
//        c.gridy = 1;
//        dialog.add(name, c);
//
//        c.gridx = 0;
//        c.gridy = 2;
//        dialog.add(new JLabel("Vorname:", JLabel.RIGHT), c);
//
//        JTextField surname = new JTextField();
//        c.gridx = 1;
//        c.gridy = 2;
//        dialog.add(surname, c);
//
//        c.gridx = 0;
//        c.gridy = 3;
//        dialog.add(new JLabel("Passwort:", JLabel.RIGHT), c);
//
//        JTextField password = new JTextField();
//        c.gridx = 1;
//        c.gridy = 3;
//        dialog.add(password, c);
//
//
//        JButton speichern = new JButton("Speichern");
//        c.gridx = 1;
//        c.gridy = 4;
//        dialog.add(speichern, c);
//
//        //ActionListener Button Anmelden
//        speichern.addActionListener(new ActionListener() {
//           public void actionPerformed(ActionEvent e) {
//               dialog.dispose();
//           }
//        });
//
//        dialog.pack(); //Komplettes Frame auf optimale Größe packen
//        //dialog.setSize(400,400);
//        dialog.setLocationRelativeTo(null); //Position des Fensters
//        dialog.setVisible(true); //Anzeigen des Frames
//
//        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
