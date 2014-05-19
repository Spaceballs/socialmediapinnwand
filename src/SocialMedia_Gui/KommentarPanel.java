
package SocialMedia_Gui;

import SocialMedia_Data.Kommentar;
import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Max
 */
public class KommentarPanel extends JPanel {
    
    private SocialMediaLogic server;
    private Nutzer clientNutzer;
    private Kommentar kommentar;
    private JLabel verfasserLabel = new JLabel("");
    private JLabel datumLabel = new JLabel("");
    private JLabel kommentarLabel = new JLabel("");
    private JButton kommentarBearbeiten = new JButton("Bearbeiten");
    private JButton kommentarLoeschen = new JButton("Löschen");
    
    KommentarPanel(SocialMediaLogic server, Nutzer clientNutzer, Kommentar kommentar) {
        super();
        this.server = server;
        this.clientNutzer = clientNutzer;
        this.kommentar = kommentar;
        initialize();
    }
    
    public void initialize() {
        initializeData();
        initializeContent();        
    }
    
    public void initializeData() {
        
    }
    
    public void initializeContent() {
        this.setSize(30,70);
        this.setBackground(Color.green);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gridBagLayout = new GridBagConstraints();
        gridBagLayout.fill = GridBagConstraints.HORIZONTAL;
        gridBagLayout.anchor = GridBagConstraints.LINE_START;
        gridBagLayout.insets = new Insets(5, 5, 5, 5);

        gridBagLayout.gridx = 0;
        gridBagLayout.gridy = 0;
//        gridBagLayout.weightx = 2;
        this.add(new JLabel("Nutzer",JLabel.LEFT), gridBagLayout);
        
    }
    
}
