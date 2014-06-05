
package SocialMedia_Gui;

import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


/**
 * Dialog where user can change username, name, surname and password
 * or deactivate his account
 * @author Max
 */
public class DialogNutzer extends JFrame {
    
    private final SocialMediaLogic server;
    private final Nutzer clientNutzer;
    private final JTextField username = new JTextField();
    private final JTextField name = new JTextField();
    private final JTextField surname = new JTextField();
    private final JPasswordField password = new JPasswordField();
    private final JPanel controls = new JPanel(new GridLayout(0,1,2,2));
    private final JPanel p = new JPanel(new BorderLayout(5,5));
    public JPanel labels;
    
    /**
     * Constructor
     * @param server - the server
     * @param clientNutzer - the logged-in Nutzer
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
        initializeDialog();
    }

    /**
     * Creates the Dialog with Labels, TextFields and Buttons
     */
    private void initializeDialog() {
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
        
        controls.add(password);
        p.add(controls, BorderLayout.CENTER);

        String[] buttons = {"Speichern", "Account löschen"};

        if (JOptionPane.showOptionDialog(
                this, p, "Accountdaten ändern", JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, buttons, buttons[0])== 1) {
                if (JOptionPane.showConfirmDialog(this,
                        "Den Account wirklich löschen?", "Account löschen",
                        JOptionPane.YES_NO_OPTION) == 0) {
                    try {
                        server.deactivateNutzer(clientNutzer);
                        dispose();
                    } catch (RemoteException ex) {
                        Logger.getLogger(DialogNutzer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                try {
                    Nutzer clientNutzerBarbeitet;
                    clientNutzerBarbeitet = server.editNutzer(username.getText(),
                            name.getText(),
                            surname.getText(),
                            new String(password.getPassword()),
                            clientNutzer);
                    if (clientNutzerBarbeitet == null){
                        // @todo Error Behaviour
                    } else {
                        dispose();
                    }   
                } catch (RemoteException ex) {
                    Logger.getLogger(DialogNutzer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
}
