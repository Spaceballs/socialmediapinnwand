
package SocialMedia_Gui;

import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;


/**
 * Dialog where user can change username, name, surname and password
 * or deactivate his account
 * @author Max
 */
public class DialogNutzer extends JFrame {
    
    private final SocialMediaLogic server;
    private final Nutzer clientNutzer;
    private final JTextField username;
    private final JTextField name;
    private final JTextField surname;
    private final JPasswordField password;
    private JPanel controls;
    private JPanel p;
    public JPanel labels;
    
    /**
     * Constructor
     * @param server - the server
     * @param clientNutzer - the logged-in Nutzer
     */
    public DialogNutzer(SocialMediaLogic server, Nutzer clientNutzer){
        this.server = server;
        this.clientNutzer = clientNutzer;
        
        username = new JTextField();
        name = new JTextField();
        surname = new JTextField();
        password = new JPasswordField();
        
        username.setDocument(new SetTextLength(25));
        name.setDocument(new SetTextLength(25));
        surname.setDocument(new SetTextLength(25));
        password.setDocument(new SetTextLength(25));
        
        try {
            this.username.setText(clientNutzer.getUsername());
            this.name.setText(clientNutzer.getName());
            this.surname.setText(clientNutzer.getSurname());
            this.password.setText(clientNutzer.getPassword());
        } catch (RemoteException ex) {
            Logger.getLogger(DialogNutzer.class.getName()).log(Level.SEVERE, null, ex);
        }
        initializeDialog();
    }

    /**
     * Creates the Dialog with Labels, TextFields and Buttons
     */
    private void initializeDialog() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        labels = new JPanel(new GridLayout(0,1,2,2));
        p = new JPanel(new BorderLayout(5,5));
        labels.add(new JLabel("Username", SwingConstants.RIGHT));
        labels.add(new JLabel("Nachname", SwingConstants.RIGHT));
        labels.add(new JLabel("Vorname", SwingConstants.RIGHT));
        labels.add(new JLabel("Passwort", SwingConstants.RIGHT));
        p.add(labels, BorderLayout.WEST);
        
        controls = new JPanel(new GridLayout(0,1,2,2)); 
        controls.add(username);
        controls.add(name);
        controls.add(surname); 
        controls.add(password);
        p.add(controls, BorderLayout.CENTER);

//        String[] buttons = {"Speichern", "Account löschen"};

        // @todo - Änderung auch bei Klick auf "X"
        JOptionPane nutzerDaten = new JOptionPane(p, JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_NO_OPTION);
        
        JDialog dialogErgebnis = nutzerDaten.createDialog(null, "Accountdaten ändern");
        dialogErgebnis.setVisible(true);
        
        final int value = (Integer)nutzerDaten.getValue();
        System.out.println(value);
        
        if (JOptionPane.YES_OPTION == value){
            System.out.println("Gespeichert");
        } else if (JOptionPane.NO_OPTION == value) {
            System.out.println("Gelöscht");
        } 
        
//        if (JOptionPane.showOptionDialog(
//                this, p, "Accountdaten ändern", JOptionPane.YES_NO_OPTION,
//                JOptionPane.PLAIN_MESSAGE, null, buttons, buttons[0])== 1) {
//                if (JOptionPane.showConfirmDialog(this,
//                        "Den Account wirklich löschen?", "Account löschen",
//                        JOptionPane.YES_NO_OPTION) == 0) {
//                    try {
//                        server.deactivateNutzer(clientNutzer);
//                        dispose();
//                    } catch (RemoteException ex) {
//                        Logger.getLogger(DialogNutzer.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            } else {
//                try {
//                    Nutzer clientNutzerBarbeitet;
//                    clientNutzerBarbeitet = server.editNutzer(username.getText(),
//                            name.getText(),
//                            surname.getText(),
//                            new String(password.getPassword()),
//                            clientNutzer);
//                    if (clientNutzerBarbeitet == null){
//                        // @todo Error Behaviour
//                    } else {
//                        dispose();
//                    }   
//                } catch (RemoteException ex) {
//                    Logger.getLogger(DialogNutzer.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
    }
}
