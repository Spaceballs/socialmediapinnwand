
package SocialMedia_Gui;

import SocialMedia_Data.Abonnement;
import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    JButton goDeleteButton;
    JButton goPinnwandButton;    
    SocialMediaLogic server;
    Nutzer clientNutzer;
    Abonnement abonnement;
    ImageIcon goDelete = new ImageIcon("zahnrad.jpg");
    ImageIcon goPinnwand = new ImageIcon("pfeil.jpg");

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
        initalize();
    }

    /**
     * 
     */
    private void initalize() {
        initializeData();
        initalizeContent();
    }

    /**
     * 
     */
    private void initializeData() {
        
    }

    /**
     * 
     */
    private void initalizeContent() {
        this.setSize(30, 70);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gridBagLayout = new GridBagConstraints();
        gridBagLayout.fill = GridBagConstraints.HORIZONTAL;
        gridBagLayout.anchor = GridBagConstraints.LINE_START;
        gridBagLayout.insets = new Insets(5, 5, 5, 5);

        gridBagLayout.gridx = 0;
        gridBagLayout.gridy = 0;
        
        gridBagLayout.gridx = 2;
        gridBagLayout.gridy = 1;
        goDeleteButton = new JButton(goDelete);
        this.add(goDeleteButton, gridBagLayout);

        gridBagLayout.gridx = 3;
        gridBagLayout.gridy = 1;
        goPinnwandButton = new JButton(goPinnwand);
        this.add(goPinnwandButton, gridBagLayout);
        try {
            this.add(new JLabel( server.getOwnerOfPinnwandOfAbonnement(abonnement).getUsername(), JLabel.RIGHT), gridBagLayout);
        } catch (RemoteException ex) {
            Logger.getLogger(AbonnementPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        goDeleteButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                    
                    if (JOptionPane.showConfirmDialog(SocialMedia_Gui.Hauptfenster.hauptfenster(null, null),
                            "Den Account wirklich löschen?", "Account löschen",
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
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }


}
