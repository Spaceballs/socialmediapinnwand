
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
    
    private String nutzerEingabe = null;
    private JTextArea textFeld;
 
    public DialogBeitrag() {
        textFeld = new JTextArea(5, 20);
        initialize();
    }
    
    public DialogBeitrag(String text) {
        textFeld = new JTextArea(text, 5, 20);
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
        textFeld.setLineWrap(true);
        textFeld.setWrapStyleWord(true);
        textFeld.setFont(new Font("Arial", Font.PLAIN, 12));
        
        UIManager.put("OptionPane.okButtonText", "Speichern");
        JOptionPane ergebnisAuswahl = new JOptionPane(new Object[] {
            new JLabel("Text eingeben"), new JScrollPane(textFeld)
        }, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
        
        JDialog dialogErgebnis = ergebnisAuswahl.createDialog(null, "Neuer Text");
        dialogErgebnis.setVisible(true);
        
        final int value = ((Integer)ergebnisAuswahl.getValue()).intValue();
        
        if (JOptionPane.OK_OPTION == value){
            nutzerEingabe = textFeld.getText();
        } else if (textFeld.getText().isEmpty() && JOptionPane.OK_OPTION == value) {
            UIManager.put("OptionPane.okButtonText", "OK");
            JOptionPane.showMessageDialog(null, "Kein Text eingegeben", "Fehler", JOptionPane.ERROR_MESSAGE);
            initializeDialog();
        }
    }
    
    public String getText() {
        return this.nutzerEingabe;
    }
}
