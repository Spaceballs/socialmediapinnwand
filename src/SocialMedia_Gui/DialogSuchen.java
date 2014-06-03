
package SocialMedia_Gui;

import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import java.rmi.RemoteException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


/**
 * Dialog where user can search for other users
 * @author Max
 */
public class DialogSuchen extends JFrame {
    
    private final SocialMediaLogic server;
    private String nutzerEingabe = null;
    private Vector<Nutzer> nutzerSuche;
    private JList ergebnisListe = new JList();

    /**
     * Constructor
     * @param server - the server
     */
    DialogSuchen(SocialMediaLogic server) {
        this.server = server;
        initializeDialog();
        initializeList();
    }

    /**
     * Creates the Dialog with Label, TextField and Button
     */
    private void initializeDialog() {
        UIManager.put("OptionPane.okButtonText", "Suchen");
        nutzerEingabe = JOptionPane.showInputDialog(this, "Bitte Usernamen eingeben", "Nutzer suchen",JOptionPane.PLAIN_MESSAGE);
        
        if (JOptionPane.OK_OPTION == 0 && nutzerEingabe != null) {
            try {
                if (nutzerEingabe.contentEquals("") || nutzerEingabe.contentEquals(" ")) {
                    UIManager.put("OptionPane.okButtonText", "OK");
                    JOptionPane.showMessageDialog(null, "Leere Eingabe nicht möglich", "Fehler", JOptionPane.ERROR_MESSAGE);
                    new DialogSuchen(server);
                } else {
                    nutzerSuche = server.searchNutzer(nutzerEingabe);
                
                    for (int i = 0; i < nutzerSuche.size(); i++) {
                        Nutzer nutzer = nutzerSuche.elementAt(i);
                        nutzer.getUsername();
                        System.out.println(nutzer.getUsername());
                    }
                }
            } catch (RemoteException ex) {
                Logger.getLogger(DialogSuchen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }

    private void initializeList() {
        ergebnisListe.setCellRenderer(new NutzerListCellRenderer());
    }
}
