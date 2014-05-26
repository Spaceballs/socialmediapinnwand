
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
 * Dialog where user inserts username and password
 * @author Max
 */
public class DialogAnmelden extends JFrame implements ActionListener{
    
    private final SocialMediaLogic server;    
    private final JTextField username = new JTextField();
    private final JPasswordField password = new JPasswordField();
    private final JButton buttonAnmelden = new JButton("Anmelden");
    private final JButton buttonRegistrieren = new JButton("Registrieren");

    /**
     * Constructor
     * @param server - the server
     */
    public DialogAnmelden(SocialMediaLogic server) {
        this.server = server;
        username.setText("MaxK");
        password.setText("dooonuts");
        initialize();
    }

    /**
     * Constructor
     * @param server - the server
     * @param username - inserted username
     * @param password - inserted password
     */
    public DialogAnmelden(SocialMediaLogic server, String username, String password) {
        this.server = server; 
        initialize();
        this.username.setText(username);
        this.password.setText(password);
    }

    /**
     * Initializes the Dialog and the ActionListeners of the Buttons
     */
    private void initialize() {
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
        this.add(new JLabel("Passwort:", JLabel.RIGHT), c);
        c.gridx = 1;
        c.gridy = 1;
        this.add(password, c);

        c.gridx = 0;
        c.gridy = 2;
        this.add(buttonAnmelden, c);

        c.gridx = 1;
        c.gridy = 2;
        this.add(buttonRegistrieren, c);

        JRootPane rootPane = this.getRootPane();
        rootPane.setDefaultButton(buttonAnmelden);

        this.setTitle("Anmelden");
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * All required Listeners
     */
    private void initializeListeners() {    
        //ActionListener Button Anmelden
        buttonAnmelden.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               Nutzer clientNutzer = null;
               try {
                   clientNutzer = server.authenticateNutzer(username.getText(), new String(password.getPassword()));
               } catch (RemoteException ex) {
                   Logger.getLogger(DialogAnmelden.class.getName()).log(Level.SEVERE, null, ex);
               }
               if (clientNutzer != null){
                   dispose();
                   Hauptfenster hauptfenster = SocialMedia_Gui.Hauptfenster.hauptfenster(server, clientNutzer);
               } else {
                   dispose();
                   DialogAnmelden  anmelden = new DialogAnmelden(server, username.getText(), new String(password.getPassword()));
               }
           }
        });
        //ActionListener Button Registrieren
        buttonRegistrieren.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               dispose();
               DialogRegistrieren dialogRegistrieren = new DialogRegistrieren(server, username.getText(), new String(password.getPassword()));
           }
        });
    }

    /**
     * UnsupportedOperationException
     * @param e - ActionEvent
     */
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
