
package SocialMedia_Gui;

import SocialMedia_Data.Nutzer;
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
     */
    DialogSuchen(SocialMediaLogic server, Nutzer clientNutzer) {
        this.clientNutzer = clientNutzer;
        this.server = server;
        initializeDialog();
    }

    /**
     * Creates the Dialog with Label, TextField and Button
     */
    private void initializeDialog() {
        UIManager.put("OptionPane.okButtonText", "Suchen");
        nutzerEingabe = JOptionPane.showInputDialog(this, "Bitte Usernamen eingeben", "Nutzer suchen",JOptionPane.PLAIN_MESSAGE);
        
        if (JOptionPane.OK_OPTION == 0 && nutzerEingabe != null) {
            try {
                //@todo - Fehler bei Eingabe von 2 Leerzeichen oder mehr auswerfen
                if (nutzerEingabe.contentEquals("") || nutzerEingabe.contentEquals(" ")) {
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
     * 
     */
    private void initializeList() {
        ergebnisListe.setCellRenderer(new NutzerListCellRenderer());
        ergebnisListe.setListData(nutzerSuche);
    }

    /**
     * 
     */
    private void selectionOptionPane() {
        // @todo - Selektierte Pinnwand wird auch bei "Abbrechen" oder "X" angezeigt
        ergebnisListe.setSelectedIndex(0);
        UIManager.put("OptionPane.okButtonText", "Zur Pinnwand");
        JOptionPane ergebnisAuswahl = new JOptionPane(
                new Object[] {
                        new JLabel("Bitte Usernamen auswählen"), new JScrollPane(ergebnisListe)
                },
                JOptionPane.PLAIN_MESSAGE, 
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
        if (JOptionPane.OK_OPTION == 0){
            SocialMedia_Gui.Hauptfenster.hauptfenster(null, null).setPanelLinks(new PinnwandPanel(server, clientNutzer, ergebnisListe.getSelectedValue()));
        }
    }
}
