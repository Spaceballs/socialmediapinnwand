
package SocialMedia_Gui;

import SocialMedia_Data.Beitrag;
import SocialMedia_Data.Kommentar;
import SocialMedia_Data.Like;
import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
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
public class BeitragPanel extends JPanel {
    
    private final SocialMediaLogic server;
    private final Nutzer clientNutzer;
    private final Beitrag beitrag;
    private Nutzer user;
    private String text;
    private StringBuffer buffer;
    private String verfasser;
    private String datum;
    private Date date;
    private Vector<Like> likes;
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
//        initializeListeners();
    }
    
    /**
     * 
     */
    private void initializeData() {
        try {            
            user = server.getNutzerOf(beitrag);
            verfasser = "Verfasst von " + user.getUsername();
            
            text = beitrag.getText();
            
            date = new Date();
            date = beitrag.getCreationDate();
            datum = "am " + dateFormat.format(date);
            
            likes = new Vector<Like>();
            likes = server.getAllLikeOfBeitrag(beitrag);
            anzahlLikes = likes.size();
            likeString = Integer.toString(anzahlLikes);

            buttonBearbeiten.setIcon(new ImageIcon("edit.jpg"));
            buttonBearbeiten.setToolTipText("Beitrag bearbeiten");
            buttonBearbeiten.setEnabled(server.ownerCheck(clientNutzer, beitrag));

            buttonLoeschen.setIcon(new ImageIcon("delete.jpg"));
            buttonLoeschen.setToolTipText("Beitrag löschen");
            buttonLoeschen.setEnabled(server.ownerCheck(clientNutzer, beitrag));
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
//            gridBagLayout.fill = GridBagConstraints.HORIZONTAL;
            gridBagLayout.anchor = GridBagConstraints.WEST;
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
            this.add(new JLabel(likeString + " Like(s)", JLabel.LEFT), gridBagLayout);
            
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
            buttonKommentieren.setIcon(new ImageIcon("kommentar.jpg"));
            buttonKommentieren.setToolTipText("Beitrag kommentieren");
            this.add(buttonKommentieren, gridBagLayout);
            
            gridBagLayout.gridx = 4;
            gridBagLayout.gridy = 1;
            gridBagLayout.gridwidth = 1;
            if(server.isAlreadyLiked(clientNutzer, beitrag)) {
                buttonUnlike.setIcon(new ImageIcon("unlike.jpg"));
                buttonUnlike.setToolTipText("Like zurücknehmen");
                this.add(buttonUnlike, gridBagLayout);
            } else {
                buttonLike.setIcon(new ImageIcon("like.jpg"));
                buttonLike.setToolTipText("Beitrag liken");
                this.add(buttonLike, gridBagLayout);
            }
            
            kommentare = new Vector<Kommentar>();
            kommentare = server.getAllKommentarOfBeitrag(beitrag);
            for (int i = 0; i < kommentare.size(); i++) {
                gridBagLayout.gridx = 1;
                gridBagLayout.gridy = i + textfieldOffset + 1;
                gridBagLayout.gridwidth = 2;
                this.add(new KommentarPanel(server, clientNutzer, kommentare.elementAt(i)), gridBagLayout);
            }
            
            this.setSize(70, 150);
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
                        SocialMedia_Gui.Hauptfenster.hauptfenster(null, null).setPanelLinks(null);
                    } catch (RemoteException ex) {
                        Logger.getLogger(DialogNutzer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        buttonBearbeiten.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        buttonLike.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    server.createLike(beitrag, clientNutzer);
                } catch (RemoteException ex) {
                    Logger.getLogger(BeitragPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        buttonKommentieren.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        buttonUnlike.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
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
