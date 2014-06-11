
package SocialMedia_Gui;

import SocialMedia_Data.Nutzer;
import SocialMedia_IOandHelper.NutzerListCellRenderer;
import SocialMedia_Logic.SocialMediaLogic;
import java.rmi.RemoteException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

/**
 * Dialog where user can search for other users
 * @author Max
 */
public class DialogSuchen extends JFrame {
    
    private final Nutzer clientNutzer;
    private final SocialMediaLogic server;
    private String nutzerEingabe = null;
    private Vector<Nutzer> nutzerSuche;
    private final JList<Nutzer> ergebnisListe = new JList<Nutzer>();

    /**
     * Constructor
     * @param server - the server
     * @param clientNutzer - the logged-in user
     */
    DialogSuchen(SocialMediaLogic server, Nutzer clientNutzer) {
        this.clientNutzer = clientNutzer;
        this.server = server;
        initializeDialog();
    }

    /**
     * Creates the Dialog where user inserts the username he wants to search for
     */
    private void initializeDialog() {
        UIManager.put("OptionPane.okButtonText", "Suchen");
        nutzerEingabe = JOptionPane.showInputDialog(this, "Bitte Usernamen eingeben", "Nutzer suchen",JOptionPane.PLAIN_MESSAGE);
        
        if (nutzerEingabe != null) {
            try {
                String s = nutzerEingabe;
                if (s.replaceAll(" ", "").length() == 0) {
                    UIManager.put("OptionPane.okButtonText", "OK");
                    JOptionPane.showMessageDialog(null, "Leere Eingabe nicht möglich", "Fehler", JOptionPane.ERROR_MESSAGE);
                    new DialogSuchen(server, clientNutzer);
                } else {
                    nutzerSuche = server.searchNutzer(nutzerEingabe);
                    initializeList();
                    selectionOptionPane();
                }
            } catch (RemoteException ex) {
                Logger.getLogger(DialogSuchen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }

    /**
     * Puts the result of the search in a list
     */
    private void initializeList() {
        ergebnisListe.setCellRenderer(new NutzerListCellRenderer());
        ergebnisListe.setListData(nutzerSuche);
    }

    /**
     * JOptionPane where a user can be selected to switch to his Pinnwand
     */
    private void selectionOptionPane() {
        UIManager.put("OptionPane.okButtonText", "Zur Pinnwand");
        JOptionPane ergebnisAuswahl = new JOptionPane(
                new Object[] {
                        new JLabel("Bitte Usernamen auswählen"), new JScrollPane(ergebnisListe)
                },
                JOptionPane.QUESTION_MESSAGE, 
                JOptionPane.OK_CANCEL_OPTION) {
                    @Override
                    public void selectInitialValue(){
                        super.selectInitialValue();
                        ergebnisListe.requestFocus();
                    }
                    public Nutzer getSelectedNutzer(){
                        return ergebnisListe.getSelectedValue();
                    }
        };
        
        JDialog dialogErgebnis = ergebnisAuswahl.createDialog(null, "Suchergebnis");
        dialogErgebnis.setVisible(true);
        
        if ((Integer)ergebnisAuswahl.getValue() == null) {
        } else {
            final int value = (Integer)ergebnisAuswahl.getValue();

            if (ergebnisListe.getSelectedIndex() != (-1) && JOptionPane.OK_OPTION == value){
                SocialMedia_Gui.Hauptfenster.hauptfenster(null, null).setPanelLinks(new PinnwandPanel(server, clientNutzer, ergebnisListe.getSelectedValue()));
            } else if (ergebnisListe.getSelectedIndex() == (-1) && JOptionPane.OK_OPTION == value) {
                UIManager.put("OptionPane.okButtonText", "OK");
                JOptionPane.showMessageDialog(null, "Kein Nutzer ausgewählt", "Fehler", JOptionPane.ERROR_MESSAGE);
                selectionOptionPane();
            }
        }
    }
}
