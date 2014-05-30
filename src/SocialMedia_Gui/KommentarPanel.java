
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
import java.util.Date;
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
    private String verfasser;
    private String text;
    private StringBuffer buffer;
    private String datum;
    private Date date;
    private GridBagConstraints gridBagLayout;
    private int textfieldOffset;
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
//        initializeListeners();
    }
    
    private void initializeData() {
        try {            
            user = server.getNutzerOf(kommentar);
            verfasser = "Verfasst von " + user.getUsername();
            
            text = kommentar.getText();
            
            date = new Date();
            date = kommentar.getCreationDate();
            datum = "am " + dateFormat.format(date);

            buttonBearbeiten.setIcon(new ImageIcon("edit.jpg"));
            buttonBearbeiten.setToolTipText("Kommentar bearbeiten");
            buttonBearbeiten.setEnabled(server.ownerCheck(clientNutzer, kommentar));

            buttonLoeschen.setIcon(new ImageIcon("delete.jpg"));
            buttonLoeschen.setToolTipText("Kommentar löschen");
            buttonLoeschen.setEnabled(server.ownerCheck(clientNutzer, kommentar));
        } catch (RemoteException ex) {
            Logger.getLogger(AbonnementPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initializeContent() {
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        gridBagLayout = new GridBagConstraints();
        gridBagLayout.fill = GridBagConstraints.HORIZONTAL;
        gridBagLayout.anchor = GridBagConstraints.LINE_START;
        gridBagLayout.insets = new Insets(2, 2, 2, 2);

        gridBagLayout.gridx = 0;
        gridBagLayout.gridy = 0;
        gridBagLayout.gridwidth = 1;
        this.add(new JLabel(verfasser, JLabel.LEFT), gridBagLayout);
        
        gridBagLayout.gridx = 1;
        gridBagLayout.gridy = 0;
        gridBagLayout.gridwidth = 1;
        this.add(new JLabel(datum, JLabel.LEFT), gridBagLayout);
        
        gridBagLayout.gridx = 2;
        gridBagLayout.gridy = 0;
        gridBagLayout.gridwidth = 1;
        this.add(buttonBearbeiten, gridBagLayout);

        gridBagLayout.gridx = 3;
        gridBagLayout.gridy = 0;
        gridBagLayout.gridwidth = 1;
        this.add(buttonLoeschen, gridBagLayout);
        
        initializeTextfield();
        
//        gridBagLayout.gridx = 0;
//        gridBagLayout.gridy = 1;
//        gridBagLayout.gridwidth = 1;
//        this.add(new JLabel(text, JLabel.LEFT), gridBagLayout);
        
        this.setSize(70, 150);
    }
    
    private void initializeListeners() {
        buttonLoeschen.addActionListener(new ActionListener() {
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
        
        buttonBearbeiten.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SocialMedia_Gui.Hauptfenster.hauptfenster(null, null).setPanelLinks(new MeinePinnwand(server, clientNutzer));
            }
        });
    }

    private void initializeTextfield() {
        buffer = new StringBuffer();
        buffer.append(text);
        do {
            if (buffer.length() >= 60) {
                text = buffer.substring(0, 60);
                buffer.delete(0, 60);
            } else {
                text = buffer.toString();
                buffer.setLength(0);
            }
            
            gridBagLayout.gridx = 0;
            gridBagLayout.gridy = gridBagLayout.gridy + 1;
            gridBagLayout.gridwidth = 2;
            this.add(new JLabel(text, JLabel.LEFT), gridBagLayout);
        } while (buffer.length() != 0);
        textfieldOffset = gridBagLayout.gridy;
    }
}
