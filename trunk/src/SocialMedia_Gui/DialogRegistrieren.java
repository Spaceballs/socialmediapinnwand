
package SocialMedia_Gui;

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
import javax.swing.JRootPane;
import javax.swing.JTextField;

/**
 * Dialog where user can register himself
 * @author Max
 */
public class DialogRegistrieren extends JFrame {
    
    private final SocialMediaLogic server;   
    private final JTextField username = new JTextField();
    private final JTextField name = new JTextField();
    private final JTextField surname = new JTextField();    
    private final JPasswordField password = new JPasswordField();
    private final JButton buttonRegistrieren = new JButton("Registrieren");

    /**
     * Constructor
     * @param server - the server
     * @param username - username inserted in DialogAnmelden
     * @param password - password inserted in DialogAnmelden
     */
    public DialogRegistrieren(SocialMediaLogic server, String username, String password) {
        this.server = server;
        this.username.setText(username);
        this.password.setText(password);
        initalize();
    }

    /**
     * Constructor
     * @param server - the server
     * @param username - the server
     * @param name - name inserted
     * @param surname - surname inserted
     * @param password - password inserted
     */
    private DialogRegistrieren(SocialMediaLogic server, String username, String name, String surname, String password) {
        this.server = server;
        this.username.setText(username);
        this.name.setText(name);
        this.surname.setText(surname);
        this.password.setText(password);
        initalize();
    }

    /**
     * Initializes the Dialog and the ActionListeners of the Buttons
     */
    private void initalize() {
        initializeDialog();
        initializeListeners();
    }

    /**
     * Creates the Dialog with Labels, TextFields and Buttons
     */
    private void initializeDialog() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(5, 5, 5, 5);

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
 
        c.gridx = 1;
        c.gridy = 4;
        this.add(buttonRegistrieren, c);

        JRootPane rootPane = this.getRootPane();
        rootPane.setDefaultButton(buttonRegistrieren);
              
        this.setTitle("Registrieren");
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * All required Listeners
     */
    public void initializeListeners() {
        //ActionListener Button Registrieren
        buttonRegistrieren.addActionListener(new ActionListener() {
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
        
    }
}
