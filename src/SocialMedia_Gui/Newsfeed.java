
package SocialMedia_Gui;

import SocialMedia_Data.Abonnement;
import SocialMedia_Data.Beitrag;
import SocialMedia_Data.Kommentar;
import SocialMedia_Data.Nutzer;
import SocialMedia_Data.Pinnwand;
import SocialMedia_Logic.SocialMediaLogic;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.rmi.RemoteException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

/**
 * Creates the content of the panelLinks and
 * shows the Newsfeed (all Beitraege, Kommentare and Likes)
 * of all Abonnements of the logged-in Nutzer
 * @author Max
 */
public class Newsfeed extends JPanel {
    private final SocialMediaLogic server;
    private Nutzer clientNutzer = null;
    private JLabel titleNewsfeed;
    private JButton beitragVerfassen = new JButton("Neuer Beitrag");
    private Vector<Abonnement> abonnements;
    private Pinnwand pinnwand;
    private Vector<Beitrag> beitraege;
    private Vector<Kommentar> kommentare;

    /**
     * Constructor
     * @param server - the server
     * @param clientNutzer - the logged-in Nutzer
     */
    public Newsfeed(SocialMediaLogic server, Nutzer clientNutzer){
        this.clientNutzer = clientNutzer;
        this.server = server;
        initializeData();
        initialize();
    }

    /**
     * Gets the username, name and surname of the logged-in Nutzer,
     * puts in in a GridLayout and
     * changes the font.
     */
    private void initialize() {
        this.setLayout(new BorderLayout());
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(null); 
        scrollPane.getInsets().set(0,0,0,0);
        scrollPane.setViewportBorder(null);
        scrollPane.getViewport().setBorder(null);
        
        JPanel scrollPanePane = new JPanel();
        scrollPanePane.setLayout(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 0;
        c.gridy = 0;
        
        titleNewsfeed = new JLabel("Newsfeed",JLabel.LEFT);
        titleNewsfeed.setFont(new Font("Arial", Font.BOLD, 28));
       
        for (int i = 0; i < beitraege.size(); i++) {
            c.gridy = i;
            scrollPanePane.add(new BeitragPanel(server, clientNutzer, beitraege.elementAt(i)), c);
            
            for (int j = 0; j < kommentare.size(); j++) {
                c.gridy = i;
                c.gridx = 2;
                scrollPanePane.add(new KommentarPanel(server, clientNutzer, kommentare.elementAt(j)), c);
            }
        }
        
        scrollPane.getViewport().setView(scrollPanePane);
        this.add(titleNewsfeed, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);      
    }
    
    /**
     * Gets the data needed from the database via the server
     * and makes it useable for the BeitragPanel
     */
    private void initializeData() {
        abonnements = new Vector<Abonnement>();
        beitraege = new Vector<Beitrag>();
        kommentare = new Vector<Kommentar>();
        
        try {
            abonnements = server.getAllAbonnementOfNutzer(clientNutzer);

            for (int i = 0; i < abonnements.size(); i++) {
                Abonnement abonnement = abonnements.elementAt(i);            
                pinnwand = server.getPinnwandOfAbonnement(abonnement);
                beitraege.addAll(server.getAllBeitragOfPinnwand(pinnwand));
            }
            
            for (int i = 0; i < beitraege.size(); i++) {
                Beitrag beitrag = beitraege.elementAt(i);
                kommentare.addAll(server.getAllKommentarOfBeitrag(beitrag));
            }
            
        } catch (RemoteException ex) {
            Logger.getLogger(Newsfeed.class.getName()).log(Level.SEVERE, null, ex);
        }            
    }
}
