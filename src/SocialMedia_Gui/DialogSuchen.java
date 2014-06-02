
package SocialMedia_Gui;

import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.rmi.RemoteException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;


/**
 * Dialog where user can search for other users
 * @author Max
 */
public class DialogSuchen extends JFrame {
    
    private final SocialMediaLogic server;
    private String nutzerEingabe;
    private Vector<Nutzer> nutzerSuche;
    private JList ergebnissListe = new JList();

    /**
     * Constructor
     * @param server - the server
     */
    DialogSuchen(SocialMediaLogic server) {
        this.server = server;
        initializeDialog();
        
        
        //JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Creates the Dialog with Label, TextField and Button
     */
    private void initializeDialog() {
        UIManager.put("OptionPane.okButtonText", "Suchen");
        nutzerEingabe = JOptionPane.showInputDialog(this, "Bitte Usernamen eingeben", "Nutzer suchen",JOptionPane.PLAIN_MESSAGE);
        
        if (JOptionPane.OK_OPTION == 0) {
            try {
                nutzerSuche = server.searchNutzer(nutzerEingabe);
                System.out.println(server.searchNutzer(nutzerEingabe));
                
                for (int i = 0; i < nutzerSuche.size(); i++) {
                    Nutzer nutzer = nutzerSuche.elementAt(i);
                    nutzer.getUsername();
                    System.out.println(nutzer.getUsername());
                }
            } catch (RemoteException ex) {
                Logger.getLogger(DialogSuchen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
        }
//        JPanel p = new JPanel(new BorderLayout());
//
//        JPanel labels = new JPanel(new GridLayout(1, 2));
//        labels.add(new JLabel("Username", SwingConstants.RIGHT));
//        p.add(labels, BorderLayout.WEST);
//
//        JPanel controls = new JPanel(new GridLayout(1, 2));
//        JTextField username = new JTextField();
//        controls.add(username);
//        p.add(controls, BorderLayout.CENTER);
//
//        JOptionPane.showMessageDialog(
//            this, p, "Nutzer suchen", JOptionPane.PLAIN_MESSAGE);
    }

}
