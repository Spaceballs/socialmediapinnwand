
package SocialMedia_Gui;

import SocialMedia_Data.Abonnement;
import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Every booked Pinnwand/Nutzer is shown in a separate panel
 * You can navigate to the Pinnwand of the booked Nutzer or delete the Abonnement
 * @author Max
 */
class AbonnementPanel extends JPanel {
    
    private final JButton buttonLoeschen = new JButton();
    private final JButton buttonPinnwand = new JButton();    
    private final SocialMediaLogic server;
    private final Nutzer clientNutzer;
    private final Abonnement abonnement;
    private String username;
    private String usernameToolTip;
    private Nutzer user;

    /**
     * Constructor for the AbonnementPanel
     * @param server - the server
     * @param clientNutzer - the logged-in user
     * @param abonnement - the Abonnement shown in the panel
     */
    AbonnementPanel(SocialMediaLogic server, Nutzer clientNutzer, Abonnement abonnement) {
        super();
        this.server = server;
        this.clientNutzer = clientNutzer;
        this.abonnement = abonnement;
        initialize();
    }

    /**
     * Initializes the needed operations
     */
    private void initialize() {
        initializeData();
        initializeContent();
        initializeListeners();
    }

    /**
     * Gets the username from the Abonnement and creates the buttons with Icons and tooltips
     */
    private void initializeData() {
        try {
            String html1 = "<html><body style='width: ";
            String html2 = "px'>";
            
            user =  server.getOwnerOfPinnwandOfAbonnement(abonnement);
            username = html1 + 75 + html2 + user.getUsername();
            usernameToolTip = user.getUsername();
            
            buttonPinnwand.setIcon(new ImageIcon(this.getClass().getResource("Ressources/pinnwand.jpg")));
            buttonPinnwand.setToolTipText("Gehe zur Pinnwand von " + usernameToolTip);
            
            buttonLoeschen.setSize(18, 18);
            buttonLoeschen.setIcon(new ImageIcon(this.getClass().getResource("Ressources/delete.jpg")));
            buttonLoeschen.setToolTipText("Abonnement löschen");
            
        } catch (RemoteException ex) {
            Logger.getLogger(AbonnementPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Puts the username and buttons in a GridBagLayout
     */
    private void initializeContent() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gridBagLayout = new GridBagConstraints();
        gridBagLayout.anchor = GridBagConstraints.WEST;
        gridBagLayout.insets = new Insets(2, 2, 2, 2);

        gridBagLayout.gridx = 0;
        gridBagLayout.gridy = 0;
        this.add(new JLabel(username, JLabel.LEFT), gridBagLayout);
        
        gridBagLayout.gridx = 2;
        gridBagLayout.gridy = 0;
        this.add(buttonLoeschen, gridBagLayout);

        gridBagLayout.gridx = 3;
        gridBagLayout.gridy = 0;
        this.add(buttonPinnwand, gridBagLayout);
        
        this.setSize(70, 150);
    }
    
    /**
     * Initializes the needed ActionListeners to go to the Pinnwand
     * and to delete a Abonnement
     */
    private void initializeListeners() {
        
        buttonLoeschen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(SocialMedia_Gui.Hauptfenster.hauptfenster(null, null),
                        "Das Abonnement wirklich löschen?", "Abonnement löschen",
                        JOptionPane.YES_NO_OPTION) == 0) {
                    try {
                        server.deleteAbonnement(abonnement);
                        SocialMedia_Gui.Hauptfenster.hauptfenster(null, null).refreshPanelLinks();
                    } catch (RemoteException ex) {
                        Logger.getLogger(DialogNutzer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        buttonPinnwand.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SocialMedia_Gui.Hauptfenster.hauptfenster(null, null).setPanelLinks(new PinnwandPanel(server, clientNutzer, user));
            }
        });
    }
}
