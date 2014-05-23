
package SocialMedia_Gui;

import SocialMedia_Data.Abonnement;
import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
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
    
    private final JButton goDeleteButton = new JButton();
    private final JButton goPinnwandButton = new JButton();    
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
            //Image goPinnwandButtonImage = ImageIO.read(getClass().getResource("pfeil.jpg"));
            goPinnwandButton.setIcon(new ImageIcon("go to user"/*goPinnwandButtonImage*/));
            //Image goDeleteButtonImage = ImageIO.read(getClass().getResource("zahnrad.jpg"));
            goDeleteButton.setIcon(new ImageIcon("delete"/*goDeleteButtonImage*/));
        } catch (IOException ex) {
            Logger.getLogger(AbonnementPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     */
    private void initializeContent() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gridBagLayout = new GridBagConstraints();
        gridBagLayout.fill = GridBagConstraints.HORIZONTAL;
        gridBagLayout.anchor = GridBagConstraints.LINE_START;
        gridBagLayout.insets = new Insets(2, 2, 2, 2);

        gridBagLayout.gridx = 0;
        gridBagLayout.gridy = 0;
        this.add(new JLabel(username, JLabel.RIGHT), gridBagLayout);
        
        gridBagLayout.gridx = 2;
        gridBagLayout.gridy = 0;
        //goDeleteButton.setBorder(null);
        //goDeleteButton.setMargin(new Insets(0, 0, 0, 0));
        this.add(goDeleteButton, gridBagLayout);

        gridBagLayout.gridx = 3;
        gridBagLayout.gridy = 0;
        //goDeleteButton.setBorder(null);
        //goPinnwandButton.setMargin(new Insets(0, 0, 0, 0));
        this.add(goPinnwandButton, gridBagLayout);
        
        this.setSize(70, 150);
    }
    
    /**
     * 
     */
    private void initializeListeners() {
        
        goDeleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(SocialMedia_Gui.Hauptfenster.hauptfenster(null, null),
                        "Das Abonnement wirklich löschen?", "Abonnement löschen",
                        JOptionPane.YES_NO_OPTION) == 0) {
                    try {
                        server.deleteAbonnement(abonnement);
                        SocialMedia_Gui.Hauptfenster.hauptfenster(null, null).setPanelLinks(null);
                    } catch (RemoteException ex) {
                        Logger.getLogger(DialogNutzer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        goPinnwandButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SocialMedia_Gui.Hauptfenster.hauptfenster(null, null).setPanelLinks(new MeinePinnwand(server, clientNutzer));
            }
        });
    }
}
