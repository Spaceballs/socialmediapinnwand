
package SocialMedia_Gui;

import SocialMedia_Data.Nutzer;
import SocialMedia_IOandHelper.SetTextLength;
import SocialMedia_Logic.SocialMediaLogic;
import java.awt.BorderLayout;
import java.awt.GridLayout;
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
     * Constructor, sets the existing data
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
     * Creates the Dialog with Labels and TextFields
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

        UIManager.put("OptionPane.yesButtonText", "Speichern");
        UIManager.put("OptionPane.noButtonText", "Account löschen");
        JOptionPane nutzerDaten = new JOptionPane(p, JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_NO_OPTION);
        
        JDialog dialogErgebnis = nutzerDaten.createDialog(null, "Accountdaten ändern");
        dialogErgebnis.setVisible(true);
        
        if ((Integer)nutzerDaten.getValue() == null) {
        } else {
            final int value = (Integer)nutzerDaten.getValue();

            if (JOptionPane.YES_OPTION == value){
                String s1 = username.getText();
                String s2 = name.getText();
                String s3 = surname.getText();
                String s4 = String.valueOf(password.getPassword());
                if (s1.replaceAll(" ", "").length() != 0 && s2.replaceAll(" ", "").length() != 0 && s3.replaceAll(" ", "").length() != 0 && s4.replaceAll(" ", "").length() != 0) {
                    try {
                        Nutzer clientNutzerBearbeitet;
                        clientNutzerBearbeitet = server.editNutzer(username.getText(),
                                name.getText(),
                                surname.getText(),
                                new String(password.getPassword()),
                                clientNutzer);

                        if (clientNutzerBearbeitet == null){
                            UIManager.put("OptionPane.okButtonText", "OK");
                            JOptionPane.showMessageDialog(null, "Accountdaten konnten nicht geändert werden", "Fehler", JOptionPane.ERROR_MESSAGE);
                            new DialogNutzer(server, clientNutzer);
                        } else {
                            dispose();
                            UIManager.put("OptionPane.okButtonText", "OK");
                            JOptionPane.showMessageDialog(null, "Accountdaten erfolgreich geändert", "Gespeichert", JOptionPane.PLAIN_MESSAGE);
                            SocialMedia_Gui.Hauptfenster.hauptfenster(null, null).refreshPanelLinks();
                        }
                    } catch (RemoteException ex) {
                        Logger.getLogger(DialogNutzer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    UIManager.put("OptionPane.okButtonText", "OK");
                    JOptionPane.showMessageDialog(null, "Leere Eingabe nicht möglich", "Fehler", JOptionPane.ERROR_MESSAGE);
                    new DialogNutzer(server, clientNutzer);
                }
            } else if (JOptionPane.NO_OPTION == value) {
                UIManager.put("OptionPane.yesButtonText", "Ja");
                UIManager.put("OptionPane.noButtonText", "Abbrechen");
                
                if (JOptionPane.showConfirmDialog(this,
                        "Den Account wirklich löschen?", "Account löschen",
                        JOptionPane.YES_NO_OPTION) == 0) {
                    try {
                        server.deactivateNutzer(clientNutzer);
                        UIManager.put("OptionPane.okButtonText", "OK");
                        JOptionPane.showMessageDialog(null, "Sie werden jetzt abgemeldet", "Account gelöscht", JOptionPane.PLAIN_MESSAGE);
                        System.exit(0);
                    } catch (RemoteException ex) {
                        Logger.getLogger(DialogNutzer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
}
