
package SocialMedia_Gui;

import SocialMedia_Data.Abonnement;
import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import java.awt.Color;
import java.awt.Dimension;
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
    
    private JButton goDeleteButton;
    private JButton goPinnwandButton;    
    private SocialMediaLogic server;
    private Nutzer clientNutzer;
    private Abonnement abonnement;
    private JLabel abonnementLabel;
    private ImageIcon goDelete = new ImageIcon("zahnrad.jpg");
    private ImageIcon goPinnwand = new ImageIcon("pfeil.jpg");

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

        this.setBackground(Color.red);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gridBagLayout = new GridBagConstraints();
        gridBagLayout.fill = GridBagConstraints.HORIZONTAL;
        gridBagLayout.anchor = GridBagConstraints.LINE_START;
        gridBagLayout.insets = new Insets(5, 5, 5, 5);

        gridBagLayout.gridx = 0;
        gridBagLayout.gridy = 0;
//        gridBagLayout.weightx = 2;
        this.add(new JLabel("Nutzer",JLabel.LEFT), gridBagLayout);
        
        gridBagLayout.gridx = 2;
        gridBagLayout.gridy = 0;
        goDeleteButton = new JButton("Delete");
        this.add(goDeleteButton, gridBagLayout);

        gridBagLayout.gridx = 3;
        gridBagLayout.gridy = 0;
        goPinnwandButton = new JButton("Pinnwand");
        this.add(goPinnwandButton, gridBagLayout);
//        try {
//            this.add(new JLabel( server.getOwnerOfPinnwandOfAbonnement(abonnement).getUsername(), JLabel.RIGHT), gridBagLayout);
//        } catch (RemoteException ex) {
//            Logger.getLogger(AbonnementPanel.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
        });this.setSize(30, 70);
    }


}
