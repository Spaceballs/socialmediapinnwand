
package SocialMedia_Gui;

import SocialMedia_Data.Abonnement;
import SocialMedia_Data.Nutzer;
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

    /**
     * Constructor
     * @param server - the server
     * @param clientNutzer - the logged-in Nutzer
     */
    public Newsfeed(SocialMediaLogic server, Nutzer clientNutzer){
        this.clientNutzer = clientNutzer;
        this.server = server;
        initialize();
        initializeData();
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
        
        for (int i = 0; i < abonnements.size(); i++) {
            c.gridy = i;
            scrollPanePane.add(new AbonnementPanel(server, clientNutzer, abonnements.elementAt(i)), c);            
        }
        scrollPane.getViewport().setView(scrollPanePane);
        this.add(titleNewsfeed, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);      
    }
    
    /**
     * 
     */
    private void initializeData() {
        try {
            abonnements = server.getAllAbonnementOfNutzer(clientNutzer);
        } catch (RemoteException ex) {
            Logger.getLogger(AbonnementInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
