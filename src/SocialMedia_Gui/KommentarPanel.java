
package SocialMedia_Gui;

import SocialMedia_Data.Kommentar;
import SocialMedia_Data.Like;
import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Vector;
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
public class KommentarPanel extends JPanel {
    
    private final SocialMediaLogic server;
    private final Nutzer clientNutzer;
    private final Kommentar kommentar;
    private Nutzer user;
    private String verfasser;
    private String text;
    private String datum;
    private final JButton goEditButton = new JButton("Bearbeiten");
    private final JButton goDeleteButton = new JButton("Löschen");
    
    KommentarPanel(SocialMediaLogic server, Nutzer clientNutzer, Kommentar kommentar) {
        super();
        this.server = server;
        this.clientNutzer = clientNutzer;
        this.kommentar = kommentar;
        initialize();
    }
    
    private void initialize() {
        initializeData();
        initializeContent();
//        initializeListeners();
    }
    
    private void initializeData() {
        try {            
            user = server.getNutzerOf(kommentar);
            verfasser = user.getUsername();
            
            text = kommentar.getText();
            
            datum = kommentar.getCreationDate().toString();

            //Image goPinnwandButtonImage = ImageIO.read(getClass().getResource("pfeil.jpg"));
            goEditButton.setIcon(new ImageIcon("go to user"/*goPinnwandButtonImage*/));
            goEditButton.setVisible(server.ownerCheck(clientNutzer, kommentar));
            //Image goDeleteButtonImage = ImageIO.read(getClass().getResource("zahnrad.jpg"));
            goDeleteButton.setIcon(new ImageIcon("delete"/*goDeleteButtonImage*/));
            goDeleteButton.setVisible(server.ownerCheck(clientNutzer, kommentar));
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
        this.add(new JLabel(verfasser, JLabel.RIGHT), gridBagLayout);
        
        gridBagLayout.gridx = 1;
        gridBagLayout.gridy = 0;
        this.add(new JLabel(datum, JLabel.RIGHT), gridBagLayout);
        
        gridBagLayout.gridx = 2;
        gridBagLayout.gridy = 0;
        //goEditButton.setBorder(null);
        //goEditButton.setMargin(new Insets(0, 0, 0, 0));
        this.add(goEditButton, gridBagLayout);

        gridBagLayout.gridx = 3;
        gridBagLayout.gridy = 0;
        //goDeleteButton.setBorder(null);
        //goDeleteButton.setMargin(new Insets(0, 0, 0, 0));
        this.add(goDeleteButton, gridBagLayout);
        
        gridBagLayout.gridx = 0;
        gridBagLayout.gridy = 1;
        this.add(new JLabel(text, JLabel.RIGHT), gridBagLayout);
        
        this.setSize(70, 150);        
    }
    
    private void initializeListeners() {
        goDeleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(SocialMedia_Gui.Hauptfenster.hauptfenster(null, null),
                        "Den Kommentar wirklich löschen?", "Kommentar löschen",
                        JOptionPane.YES_NO_OPTION) == 0) {
                    try {
                        server.deleteKommentar(kommentar);
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
