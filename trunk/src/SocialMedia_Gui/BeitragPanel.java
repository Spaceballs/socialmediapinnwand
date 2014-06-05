
package SocialMedia_Gui;

import SocialMedia_Data.Beitrag;
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
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Vector;
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
public class BeitragPanel extends JPanel {
    
    private final SocialMediaLogic server;
    private final Nutzer clientNutzer;
    private final Beitrag beitrag;
    private Nutzer user;
    private String text;
    private String beitragHeader;
    private Vector<Like> likes;
    private Like userLike;
    private int anzahlLikes;
    private String likeString;
    private Vector<Kommentar> kommentare;
    private GridBagConstraints gridBagLayout;
    private int textfieldOffset;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.GERMANY);
    private final JButton buttonBearbeiten = new JButton();
    private final JButton buttonLoeschen = new JButton();
    private final JButton buttonKommentieren = new JButton();
    private final JButton buttonLike = new JButton();
    private final JButton buttonUnlike = new JButton();
    
    /**
     * 
     * @param server
     * @param clientNutzer
     * @param beitrag 
     */
    BeitragPanel(SocialMediaLogic server, Nutzer clientNutzer, Beitrag beitrag) {
        super();
        this.server = server;
        this.clientNutzer = clientNutzer;
        this.beitrag = beitrag;
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
            String html1 = "<html><body style='width: ";
            String html2 = "px'>";
        
            user = server.getNutzerOf(beitrag);
            beitragHeader = html1 + 200 + html2 + "Verfasst von " + user.getUsername() + " am " + dateFormat.format(beitrag.getCreationDate());
            
            likes = new Vector<Like>();
            likes = server.getAllLikeOfBeitrag(beitrag);
            anzahlLikes = likes.size();
            likeString = html1 + 40 + html2 + Integer.toString(anzahlLikes) + " Like(s)";
            
            userLike = server.getUserLike(clientNutzer, beitrag);

            buttonBearbeiten.setIcon(new ImageIcon("edit.jpg"));
            buttonBearbeiten.setToolTipText("Beitrag bearbeiten");
            buttonBearbeiten.setEnabled(server.ownerCheck(clientNutzer, beitrag));

            buttonLoeschen.setIcon(new ImageIcon("delete.jpg"));
            buttonLoeschen.setToolTipText("Beitrag löschen");
            buttonLoeschen.setEnabled(server.ownerCheck(clientNutzer, beitrag));
            
            buttonKommentieren.setIcon(new ImageIcon("kommentar.jpg"));
            buttonKommentieren.setToolTipText("Beitrag kommentieren");
            
            buttonUnlike.setIcon(new ImageIcon("unlike.jpg"));
            buttonUnlike.setToolTipText("Like zurücknehmen");
            
            buttonLike.setIcon(new ImageIcon("like.jpg"));
            buttonLike.setToolTipText("Beitrag liken");
            
            text = beitrag.getText();
        } catch (RemoteException ex) {
            Logger.getLogger(AbonnementPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     */
    private void initializeContent() {
        try {
            this.setLayout(new GridBagLayout());
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            this.setBackground(Color.LIGHT_GRAY);
            
            gridBagLayout = new GridBagConstraints();
            gridBagLayout.anchor = GridBagConstraints.WEST;
            gridBagLayout.insets = new Insets(2, 10, 2, 2);
            
            gridBagLayout.gridx = 0;
            gridBagLayout.gridy = 0;
            gridBagLayout.gridwidth = 1;
            this.add(new JLabel(beitragHeader, JLabel.LEFT), gridBagLayout);
            
            gridBagLayout.gridx = 2;
            gridBagLayout.gridy = 0;
            gridBagLayout.gridwidth = 1;
            this.add(new JLabel(likeString, JLabel.LEFT), gridBagLayout);
            
            gridBagLayout.gridx = 3;
            gridBagLayout.gridy = 0;
            gridBagLayout.gridwidth = 1;
            this.add(buttonBearbeiten, gridBagLayout);
            
            gridBagLayout.gridx = 4;
            gridBagLayout.gridy = 0;
            gridBagLayout.gridwidth = 1;
            this.add(buttonLoeschen, gridBagLayout);
            
            initializeTextfield();
            
            gridBagLayout.gridx = 3;
            gridBagLayout.gridy = 1;
            gridBagLayout.gridwidth = 1;
            this.add(buttonKommentieren, gridBagLayout);
            
            gridBagLayout.gridx = 4;
            gridBagLayout.gridy = 1;
            gridBagLayout.gridwidth = 1;
            if(server.isAlreadyLiked(clientNutzer, beitrag)) {
                this.add(buttonUnlike, gridBagLayout);
            } else {
                this.add(buttonLike, gridBagLayout);
            }
            
            kommentare = new Vector<Kommentar>();
            kommentare = server.getAllKommentarOfBeitrag(beitrag);
            for (int i = 0; i < kommentare.size(); i++) {
                gridBagLayout.gridx = 0;
                gridBagLayout.gridy = i + textfieldOffset + 1;
                gridBagLayout.gridwidth = 2;
                this.add(new KommentarPanel(server, clientNutzer, kommentare.elementAt(i)), gridBagLayout);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(BeitragPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     */
    private void initializeListeners() {        
        buttonLoeschen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(SocialMedia_Gui.Hauptfenster.hauptfenster(null, null),
                        "Den Beitrag wirklich löschen?", "Beitrag löschen",
                        JOptionPane.YES_NO_OPTION) == 0) {
                    try {
                        server.deleteBeitrag(beitrag);
                        SocialMedia_Gui.Hauptfenster.hauptfenster(null, null).setPanelLinks(new NewsfeedPanel(server, clientNutzer));
                    } catch (RemoteException ex) {
                        Logger.getLogger(DialogNutzer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        buttonBearbeiten.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // @todo Implementierung Beitrag bearbeiten
            }
        });
        
        buttonKommentieren.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // @todo Implementierung Beitrag kommentieren
            }
        });
        
        buttonLike.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    server.createLike(beitrag, clientNutzer);
                    // @todo Unterscheidung Newsfeed/Pinnwand
                    SocialMedia_Gui.Hauptfenster.hauptfenster(null, null).setPanelLinks(new NewsfeedPanel(server, clientNutzer));
                } catch (RemoteException ex) {
                    Logger.getLogger(BeitragPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        buttonUnlike.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    server.deleteLike(userLike);
                    // @todo Unterscheidung Newsfeed/Pinnwand
                    SocialMedia_Gui.Hauptfenster.hauptfenster(null, null).setPanelLinks(new NewsfeedPanel(server, clientNutzer));
                } catch (RemoteException ex) {
                    Logger.getLogger(BeitragPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
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
        this.add(new JLabel(html1 + 300 + html2 + text, JLabel.LEFT), gridBagLayout);
        textfieldOffset = gridBagLayout.gridy;
    }
}
