
package SocialMedia_Gui;

import SocialMedia_Data.Abonnement;
import SocialMedia_Data.Beitrag;
import SocialMedia_Data.Nutzer;
import SocialMedia_Data.Pinnwand;
import SocialMedia_DatabaseManager.PinnwandMapper;
import SocialMedia_Logic.SocialMediaLogic;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
public class BeitragPanel extends JPanel {
    
    private final SocialMediaLogic server;
    private final Nutzer clientNutzer;
    private Nutzer user;
    private Beitrag beitrag;
    private String text;
    private String verfasser;
    private String datum;
    private JLabel datumLabel = new JLabel("");
    private JLabel beitragLabel = new JLabel("");
    private JButton goEditButton = new JButton("Bearbeiten");
    private JButton goDeleteButton = new JButton("Löschen");
    
    BeitragPanel(SocialMediaLogic server, Nutzer clientNutzer, Beitrag beitrag) {
        super();
        this.server = server;
        this.clientNutzer = clientNutzer;
        this.beitrag = beitrag;
        initialize();
    }
    
    private void initialize() {
        initializeData();
        initializeContent();
        initializeListeners();
    }
    
    private void initializeData() {
        try {
            System.out.println(beitrag == null);
            System.out.println(beitrag);
            
//            user = beitrag.getOwner(server);
//            verfasser = user.getUsername();
            
            text = beitrag.getText();
            
            
            //Image goPinnwandButtonImage = ImageIO.read(getClass().getResource("pfeil.jpg"));
            goEditButton.setIcon(new ImageIcon("go to user"/*goPinnwandButtonImage*/));
            //Image goDeleteButtonImage = ImageIO.read(getClass().getResource("zahnrad.jpg"));
            goDeleteButton.setIcon(new ImageIcon("delete"/*goDeleteButtonImage*/));
        } catch (IOException ex) {
            Logger.getLogger(AbonnementPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initializeContent() {
          this.setLayout(new GridBagLayout());
        GridBagConstraints gridBagLayout = new GridBagConstraints();
        gridBagLayout.fill = GridBagConstraints.HORIZONTAL;
        gridBagLayout.anchor = GridBagConstraints.LINE_START;
        gridBagLayout.insets = new Insets(2, 2, 2, 2);

        gridBagLayout.gridx = 0;
        gridBagLayout.gridy = 0;
        this.add(new JLabel("Username", JLabel.RIGHT), gridBagLayout);
        
        gridBagLayout.gridx = 2;
        gridBagLayout.gridy = 0;
        //goDeleteButton.setBorder(null);
        //goDeleteButton.setMargin(new Insets(0, 0, 0, 0));
        this.add(goDeleteButton, gridBagLayout);

        gridBagLayout.gridx = 3;
        gridBagLayout.gridy = 0;
        //goDeleteButton.setBorder(null);
        //goPinnwandButton.setMargin(new Insets(0, 0, 0, 0));
        this.add(goEditButton, gridBagLayout);
        
        gridBagLayout.gridx = 0;
        gridBagLayout.gridy = 1;
        this.add(new JLabel(text, JLabel.RIGHT), gridBagLayout);
        
        this.setSize(70, 150);
    }
    
    private void initializeListeners() {        
        goDeleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(SocialMedia_Gui.Hauptfenster.hauptfenster(null, null),
                        "Den Beitrag wirklich löschen?", "Beitrag löschen",
                        JOptionPane.YES_NO_OPTION) == 0) {
                    try {
                        server.deleteBeitrag(beitrag);
                        SocialMedia_Gui.Hauptfenster.hauptfenster(null, null).setPanelLinks(null);
                    } catch (RemoteException ex) {
                        Logger.getLogger(DialogNutzer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        goEditButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SocialMedia_Gui.Hauptfenster.hauptfenster(null, null).setPanelLinks(new MeinePinnwand(server, clientNutzer));
            }
        });
    }   
}
