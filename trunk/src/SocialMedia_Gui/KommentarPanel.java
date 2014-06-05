
package SocialMedia_Gui;

import SocialMedia_Data.Kommentar;
import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
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
    private String kommentarHeader;
    private String text;
    private GridBagConstraints gridBagLayout;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.GERMANY);
    private final JButton buttonBearbeiten = new JButton();
    private final JButton buttonLoeschen = new JButton();
    
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
        initializeListeners();
    }
    
    private void initializeData() {
        try {
            String html1 = "<html><body style='width: ";
            String html2 = "px'>";
            
            user = server.getNutzerOf(kommentar);
            kommentarHeader = html1 + 200 + html2 + "Verfasst von " + user.getUsername() + " am " + dateFormat.format(kommentar.getCreationDate());

            buttonBearbeiten.setIcon(new ImageIcon("edit.jpg"));
            buttonBearbeiten.setToolTipText("Kommentar bearbeiten");
            buttonBearbeiten.setEnabled(server.ownerCheck(clientNutzer, kommentar));

            buttonLoeschen.setIcon(new ImageIcon("delete.jpg"));
            buttonLoeschen.setToolTipText("Kommentar löschen");
            buttonLoeschen.setEnabled(server.ownerCheck(clientNutzer, kommentar));
            
            text = kommentar.getText();
        } catch (RemoteException ex) {
            Logger.getLogger(AbonnementPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initializeContent() {
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        gridBagLayout = new GridBagConstraints();
        gridBagLayout.anchor = GridBagConstraints.WEST;
        gridBagLayout.insets = new Insets(2, 10, 2, 2);

        gridBagLayout.gridx = 0;
        gridBagLayout.gridy = 0;
        gridBagLayout.gridwidth = 1;
        this.add(new JLabel(kommentarHeader, JLabel.LEFT), gridBagLayout);
        
        gridBagLayout.gridx = 2;
        gridBagLayout.gridy = 0;
        gridBagLayout.gridwidth = 1;
        this.add(buttonBearbeiten, gridBagLayout);

        gridBagLayout.gridx = 3;
        gridBagLayout.gridy = 0;
        gridBagLayout.gridwidth = 1;
        this.add(buttonLoeschen, gridBagLayout);
        
        initializeTextfield();
    }
    
    private void initializeListeners() {
        buttonLoeschen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(SocialMedia_Gui.Hauptfenster.hauptfenster(null, null),
                        "Den Kommentar wirklich löschen?", "Kommentar löschen",
                        JOptionPane.YES_NO_OPTION) == 0) {
                    try {
                        server.deleteKommentar(kommentar);
                        // @todo Unterscheidung Newsfeed/Pinnwand
                        SocialMedia_Gui.Hauptfenster.hauptfenster(null, null).setPanelLinks(new NewsfeedPanel(server, clientNutzer));
                    } catch (RemoteException ex) {
                        Logger.getLogger(DialogNutzer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        buttonBearbeiten.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // @todo Implementierung Kommentar bearbeiten
            }
        });
    }

    /**
     * 
     */
    private void initializeTextfield() {
        String html1 = "<html><body style='width: ";
        String html2 = "px'>"; 
        gridBagLayout.gridx = 0;
        gridBagLayout.gridy = gridBagLayout.gridy + 1;
        gridBagLayout.gridwidth = 2;
        this.add(new JLabel(html1 + 200 + html2 + text, JLabel.LEFT), gridBagLayout);
    }
}
