
package SocialMedia_Gui;

import SocialMedia_Data.Beitrag;
import SocialMedia_Data.Kommentar;
import SocialMedia_Data.Nutzer;
import SocialMedia_Data.Pinnwand;
import SocialMedia_Logic.SocialMediaLogic;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

/**
 *
 * @author Max
 */
public class DialogBeitrag extends JFrame {
    
    private final SocialMediaLogic server;
    private final Nutzer clientNutzer;
    private String nutzerEingabe = null;
    
    public DialogBeitrag(SocialMediaLogic server, Nutzer clientNutzer, Pinnwand pinnwand, Beitrag beitrag, Kommentar kommentar) {
        this.server = server;
        this.clientNutzer = clientNutzer;
        initialize();
    }

    /**
     * 
     */
    private void initialize() {
        initializeDialog();
    }

    /**
     * 
     */
    private void initializeDialog() {
        JTextArea textFeld = new JTextArea(5, 20);
        textFeld.setLineWrap(true);
        textFeld.setWrapStyleWord(true);
        textFeld.setFont(new Font("Arial", Font.PLAIN, 12));
        
        UIManager.put("OptionPane.okButtonText", "Speichern");
        JOptionPane ergebnisAuswahl = new JOptionPane(new Object[] {
            new JLabel("Neuen Beitrag eingeben"), new JScrollPane(textFeld)
        }, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
        
        JDialog dialogErgebnis = ergebnisAuswahl.createDialog(null, "Neuer Beitrag");
        dialogErgebnis.setVisible(true);
        
        
        nutzerEingabe = textFeld.getText();
        System.out.println(nutzerEingabe);
    }
}
