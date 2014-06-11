
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

/**
 * Shows the Abonnements of the logged-in Nutzer
 * Provides the data for the AbonnementPanel
 * @author Max
 */
public class AbonnementInfo extends JPanel{

    private final SocialMediaLogic server;
    private final Nutzer clientNutzer;
    private JLabel titleAbonnements;
    private Vector<Abonnement> abonnements;


    /**
     * Constructor of the AbonnementInfo class
     * @param server - the server
     * @param clientNutzer - the logged-in Nutzer
     */
    public AbonnementInfo(SocialMediaLogic server, Nutzer clientNutzer){
        this.clientNutzer = clientNutzer;
        this.server = server;
        initializeData();
        initialize();
    }

    /**
     * Puts the title in a BorderLayout
     * Creates a ScrollPane which contains the AbonnementPanels
     */
    private void initialize() {
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        titleAbonnements = new JLabel("Abonnements",JLabel.LEFT);
        titleAbonnements.setFont(new Font("Arial", Font.BOLD, 28));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        scrollPane.setBorder(null); 
        scrollPane.getInsets().set(0,0,0,0);
        scrollPane.setViewportBorder(null);
        scrollPane.getViewport().setBorder(null);
        
        JPanel scrollPanePane = new JPanel();
        scrollPanePane.setLayout(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(5, 5, 5, 5);
        
        c.gridx = 0;
        c.gridy = 0;
        for (int i = 0; i < abonnements.size(); i++) {
            c.gridy = i;
            scrollPanePane.add(new AbonnementPanel(server, clientNutzer, abonnements.elementAt(i)), c);            
        }
        
        scrollPane.getViewport().setView(scrollPanePane);
        this.add(titleAbonnements, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Gets all Abonnements of the logged-in user
     */
    private void initializeData() {
        try {
            abonnements = server.getAllAbonnementOfNutzer(clientNutzer);
        } catch (RemoteException ex) {
            Logger.getLogger(AbonnementInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
