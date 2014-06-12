
package SocialMedia_Gui;

import SocialMedia_IOandHelper.SetTextLength;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

/**
 * Dialog for creating a new Beitrag or Kommentar or editing an existing Beitrag or Kommentar
 * @author Max
 */
public class DialogBeitrag extends JFrame {
    
    private String nutzerEingabe = null;
    private final JTextArea textFeld;
 
    /**
     * Constructor for creating a Beitrag/Kommentar
     */
    public DialogBeitrag() {
        textFeld = new JTextArea(5, 20);
        textFeld.setDocument(new SetTextLength(1000));
        initialize();
    }
    
    /**
     * Constructor for editing a Beitrag/Kommentar
     * @param text - the existing text
     */
    public DialogBeitrag(String text) {
        textFeld = new JTextArea(5, 20);
        textFeld.setDocument(new SetTextLength(1000));
        textFeld.setText(text);
        initialize();
    }

    /**
     * Initializes the needed operations
     */
    private void initialize() {
        initializeDialog();
    }

    /**
     * Initializes the dialog and puts the textfield into a ScrollPane
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
        
        if ((Integer)ergebnisAuswahl.getValue() == null) {
        } else {
            final int value = (Integer)ergebnisAuswahl.getValue();
            if (textFeld.getText() != null && JOptionPane.OK_OPTION == value) {
                String s = textFeld.getText();
                if (s.replaceAll(" ", "").length() == 0) {
                    UIManager.put("OptionPane.okButtonText", "OK");
                    JOptionPane.showMessageDialog(null, "Leere Eingabe nicht möglich", "Fehler", JOptionPane.ERROR_MESSAGE);
                    new DialogBeitrag();
                } else {
                    nutzerEingabe = textFeld.getText();
                }
            }
        }
    }
    
    /**
     * Gets the text from the textfield
     * @return the inserted text
     */
    public String getText() {
        return this.nutzerEingabe;
    }
}
