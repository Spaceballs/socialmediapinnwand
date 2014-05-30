
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
 *
 * @author Max
 */
class AbonnementPanel extends JPanel {
    
    private final JButton buttonLoeschen = new JButton();
    private final JButton buttonPinnwand = new JButton();    
    private final SocialMediaLogic server;
    private final Nutzer clientNutzer;
    private final Abonnement abonnement;
    private String username;
    private Nutzer user;

    /**
     * 
     * @param server
     * @param clientNutzer
     * @param abonnement 
     */
    AbonnementPanel(SocialMediaLogic server, Nutzer clientNutzer, Abonnement abonnement) {
        super();
        this.server = server;
        this.clientNutzer = clientNutzer;
        this.abonnement = abonnement;
        initialize();
    }

    /**
     * 
     */
    private void initialize() {
        initializeData();
        initializeContent();
        initializeListeners();
    }

    /**
     * 
     */
    private void initializeData() {
        try {            
            user =  server.getOwnerOfPinnwandOfAbonnement(abonnement);
            username = user.getUsername();
            
            buttonPinnwand.setIcon(new ImageIcon("pinnwand.jpg"));
            buttonPinnwand.setToolTipText("Gehe zur Pinnwand von " + username);
            
            buttonLoeschen.setSize(18, 18);
            buttonLoeschen.setIcon(new ImageIcon("delete.jpg"));
            buttonLoeschen.setToolTipText("Abonnement löschen");
            
        } catch (RemoteException ex) {
            Logger.getLogger(AbonnementPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
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
     * 
     */
    private void initializeListeners() {
        
        buttonLoeschen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(SocialMedia_Gui.Hauptfenster.hauptfenster(null, null),
                        "Das Abonnement wirklich löschen?", "Abonnement löschen",
                        JOptionPane.YES_NO_OPTION) == 0) {
                    try {
                        server.deleteAbonnement(abonnement);
                        SocialMedia_Gui.Hauptfenster.hauptfenster(null, null).setPanelLinks(new NewsfeedPanel(server, clientNutzer));
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
