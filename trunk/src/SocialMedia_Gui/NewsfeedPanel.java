
package SocialMedia_Gui;

import SocialMedia_Data.Abonnement;
import SocialMedia_Data.Beitrag;
import SocialMedia_Data.Nutzer;
import SocialMedia_Data.Pinnwand;
import SocialMedia_Logic.SocialMediaLogic;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

/**
 * Creates the Newsfeed (all Beitraege, Kommentare and Likes)
 * of all Abonnements of the logged-in Nutzer
 * @author Max
 */
public class NewsfeedPanel extends JPanel {
    private final SocialMediaLogic server;
    private final Nutzer clientNutzer;
    private JLabel titleNewsfeed;    
    private final JButton buttonNeuerBeitrag = new JButton("Neuer Beitrag");
    private Vector<Abonnement> abonnements;
    private Pinnwand myPinnwand;
    private Pinnwand pinnwand;
    private Vector<Beitrag> beitraege;
    private Pinnwand meinePinnwand;

    /**
     * Constructor
     * @param server - the server
     * @param clientNutzer - the logged-in Nutzer
     */
    public NewsfeedPanel(SocialMediaLogic server, Nutzer clientNutzer){
        this.clientNutzer = clientNutzer;
        this.server = server;
        initializeData();
        initialize();
        initializeListeners();
    }

    /**
     * Sets a title and a button for creating a new Beitrag
     * Creates a ScrollPane which contains a BeitragPanel for every Beitrag to be displayed
     */
    private void initialize() {
        this.setLayout(new BorderLayout());
        
        titleNewsfeed = new JLabel("Newsfeed",JLabel.LEFT);
        titleNewsfeed.setFont(new Font("Arial", Font.BOLD, 28));
        
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        titlePanel.add(titleNewsfeed, BorderLayout.WEST);
        titlePanel.add(buttonNeuerBeitrag, BorderLayout.EAST);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        scrollPane.setBorder(null); 
        scrollPane.getInsets().set(0,0,0,0);
        scrollPane.setViewportBorder(null);
        scrollPane.getViewport().setBorder(null);
        
        JPanel scrollPanePane = new JPanel();
        scrollPanePane.setLayout(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(5, 5, 5, 5);
        
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 5;
        for (int i = 0; i < beitraege.size(); i++) {
            c.gridy = i;
            scrollPanePane.add(new BeitragPanel(server, clientNutzer, beitraege.elementAt(i)), c);
        }
        
        scrollPane.getViewport().setView(scrollPanePane);
        
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
    }
    
    /**
     * Gets the data needed from the database via the server (all Beitraege of Abonnements + own Beitraege)
     * and makes it useable for the BeitragPanel
     * Sorts the Beitraege by creationDate, newest on top
     */
    private void initializeData() {
        abonnements = new Vector<Abonnement>();
        beitraege = new Vector<Beitrag>();
        
        try {
            abonnements = server.getAllAbonnementOfNutzer(clientNutzer);

            for (int i = 0; i < abonnements.size(); i++) {
                Abonnement abonnement = abonnements.elementAt(i);            
                pinnwand = server.getPinnwandOfAbonnement(abonnement);
                beitraege.addAll(server.getAllBeitragOfPinnwand(pinnwand));
            }
            myPinnwand = server.getPinnwandOfNutzer(clientNutzer);
            beitraege.addAll(server.getAllBeitragOfPinnwand(myPinnwand));
            
            Collections.sort(beitraege, new Comparator<Beitrag>() {
                public int compare(Beitrag o1, Beitrag o2){
                    try {
                        return o2.getCreationDate().compareTo(o1.getCreationDate());
                    } catch (RemoteException ex) {
                        Logger.getLogger(PinnwandPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return -1;
                }
            });
        } catch (RemoteException ex) {
            Logger.getLogger(NewsfeedPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Initializes the ActionListener for creating a new Beitrag
     */
    private void initializeListeners() {
        try {
            meinePinnwand = server.getPinnwandOfNutzer(clientNutzer);
            buttonNeuerBeitrag.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        // @todo - Fehler bei leerer Eingabe / Verhalten bei "Abbrechen"
                        DialogBeitrag dialogBeitrag = new DialogBeitrag();
                        if (dialogBeitrag.getText() != null) {
                            if (!dialogBeitrag.getText().isEmpty()){
                                server.createBeitrag(meinePinnwand, clientNutzer, dialogBeitrag.getText());
                                SocialMedia_Gui.Hauptfenster.hauptfenster(null, null).refreshPanelLinks(); 
                            }else{
                                UIManager.put("OptionPane.okButtonText", "OK");
                                JOptionPane.showMessageDialog(null, "Leere Eingabe nicht möglich", "Fehler", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            UIManager.put("OptionPane.okButtonText", "OK");
                            JOptionPane.showMessageDialog(null, "Leere Eingabe nicht möglich", "Fehler", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (RemoteException ex) {
                        Logger.getLogger(NewsfeedPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        } catch (RemoteException ex) {
            Logger.getLogger(NewsfeedPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
