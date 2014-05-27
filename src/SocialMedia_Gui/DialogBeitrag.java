
package SocialMedia_Gui;

import SocialMedia_Data.Beitrag;
import SocialMedia_Data.Nutzer;
import SocialMedia_Data.Pinnwand;
import SocialMedia_Logic.SocialMediaLogic;
import java.awt.Dimension;
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
import javax.swing.JRootPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Max
 */
public class DialogBeitrag extends JFrame {
    
    private final SocialMediaLogic server;
    private final Nutzer clientNutzer;
    private Beitrag beitrag;
    private Pinnwand pinnwand;
    private String text;
    private final JButton buttonSpeichern = new JButton("Speichern");
    
    public DialogBeitrag(SocialMediaLogic server, Nutzer clientNutzer, Pinnwand pinnwand) {
        this.server = server;
        this.clientNutzer = clientNutzer;
        
        initialize();
    }

    /**
     * Initializes the Dialog and the ActionListeners of the Buttons
     */
    private void initialize() {
        initializeDialog();
//        initializeListeners();
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
        this.add(new JTextArea(5,1), c);

        c.gridx = 0;
        c.gridy = 1;
        this.add(buttonSpeichern, c);

        this.setTitle("Neuer Beitrag");
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * All required Listeners
     */
    private void initializeListeners() {
        buttonSpeichern.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               server.createBeitrag(pinnwand, clientNutzer, text);
           }
        });
    }
}
