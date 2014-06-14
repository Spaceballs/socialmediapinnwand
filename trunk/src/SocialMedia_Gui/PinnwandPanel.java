
package SocialMedia_Gui;

import SocialMedia_Data.Abonnement;
import SocialMedia_Data.Beitrag;
import SocialMedia_Data.Nutzer;
import SocialMedia_Data.Pinnwand;
import SocialMedia_Logic.SocialMediaLogic;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

/**
 * Creates the Pinnwand (all Beitraege, Kommentare and Likes) of a Nutzer
 * @author Max
 */
public class PinnwandPanel extends JPanel {

    private final SocialMediaLogic server;
    private final Nutzer clientNutzer;
    private final Nutzer nutzer;
    private final JLabel titlePinnwand = new JLabel("",JLabel.LEFT);
    private final JButton buttonNeuerBeitrag = new JButton("Neuer Beitrag");
    private final JButton buttonAbonnieren = new JButton();
    private final JButton buttonAbonnementLoeschen = new JButton();
    private Abonnement pinnwandAbonnement;
    private Vector<Beitrag> beitraege;
    private Vector<Beitrag> beitraegeSortiert;
    private Pinnwand pinnwand;
    JScrollPane scrollPane;

    /**
     * Constructor
     * @param server - the server
     * @param clientNutzer - the logged-in nutzer
     * @param nutzer - nutzer of the pinnwand
     */
    public PinnwandPanel(SocialMediaLogic server, Nutzer clientNutzer, Nutzer nutzer){
        this.nutzer = nutzer;
        this.server = server;
        this.clientNutzer = clientNutzer;
        initializeData();
        initialize();
        initializeListeners();
    }

    /**
     * Sets a title and a button for creating a new Abonnement/deleting a Abonnement
     * Creates a ScrollPane which contains a BeitragPanel for every Beitrag to be displayed
     */
    private void initialize() {
        try {
            this.setLayout(new BorderLayout());
            
            titlePinnwand.setText("Pinnwand von " + nutzer.getUsername());
            titlePinnwand.setFont(new Font("Arial", Font.BOLD, 28));
            
            JPanel titlePanel = new JPanel();
            titlePanel.setLayout(new BorderLayout());
            titlePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
            titlePanel.add(titlePinnwand, BorderLayout.WEST);
            
            buttonAbonnieren.setIcon(new ImageIcon(this.getClass().getResource("Ressources/abonnieren.jpg")));
            buttonAbonnieren.setToolTipText("Nutzer " + nutzer.getUsername() + " abonnieren");
            
            buttonAbonnementLoeschen.setIcon(new ImageIcon(this.getClass().getResource("Ressources/delete.jpg")));
            buttonAbonnementLoeschen.setToolTipText("Abonnement löschen");
            
            if(server.ownerCheck(clientNutzer, pinnwand)) {
                titlePanel.add(buttonNeuerBeitrag, BorderLayout.EAST);
            } else {
                if(server.isAlreadyBooked(clientNutzer, pinnwand)) {
                    titlePanel.add(buttonAbonnementLoeschen, BorderLayout.EAST);
                } else {
                    titlePanel.add(buttonAbonnieren, BorderLayout.EAST);
                }
            }
            
            scrollPane = new JScrollPane();
            scrollPane.getVerticalScrollBar().setUnitIncrement(20);
            scrollPane.setBorder(null);
            scrollPane.getInsets().set(0,0,0,0);
            scrollPane.setViewportBorder(null);
            scrollPane.getViewport().setBorder(null);
            
            JPanel scrollPanePane = new JPanel();
            scrollPanePane.setLayout(new GridBagLayout());
            
            GridBagConstraints c = new GridBagConstraints();

            c.anchor = GridBagConstraints.WEST;
            c.insets = new Insets(5, 5, 5, 5);
            
            c.gridx = 0;
            c.gridy = 0;
            for (int i = 0; i < beitraege.size(); i++) {
                c.gridy = i;
                scrollPanePane.add(new BeitragPanel(server, clientNutzer, beitraege.elementAt(i)), c);
            }
            
            scrollPane.getViewport().setView(scrollPanePane);
            
            this.add(titlePanel, BorderLayout.NORTH);
            this.add(scrollPane, BorderLayout.CENTER);
        } catch (RemoteException ex) {
            Logger.getLogger(PinnwandPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Gets the data needed from the database via the server (all Beitraege of a Nutzer)
     * and makes it useable for the BeitragPanel
     * Sorts the Beitraege by creationDate, newest on top
     */
    private void initializeData() {
        beitraege = new Vector<Beitrag>();
        
        try {    
            pinnwand = server.getPinnwandOfNutzer(nutzer);
            beitraege.addAll(server.getAllBeitragOfPinnwand(pinnwand));
            
            pinnwandAbonnement = server.getPinnwandAbonnement(clientNutzer, pinnwand);
            
            Collections.sort(beitraege, new Comparator<Beitrag>() {
                public int compare(Beitrag o1, Beitrag o2){
                    try {
                        return o2.getCreationDate().compareTo(o1.getCreationDate());
                    } catch (RemoteException ex) {
                        Logger.getLogger(PinnwandPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return -1;
                }
            });
        } catch (RemoteException ex) {
            Logger.getLogger(PinnwandPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Initializes all needed ActionListeners
     */
    private void initializeListeners() {
        buttonNeuerBeitrag.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    DialogBeitrag dialogBeitrag = new DialogBeitrag();
                    if (dialogBeitrag.getText() != null) {
                            server.createBeitrag(pinnwand, clientNutzer, dialogBeitrag.getText());
                            SocialMedia_Gui.Hauptfenster.hauptfenster(null, null).refreshPanelLinks();
                    }
                } catch (RemoteException ex) {
                    Logger.getLogger(PinnwandPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        buttonAbonnieren.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    server.createAbonnement(pinnwand, clientNutzer);
                    SocialMedia_Gui.Hauptfenster.hauptfenster(null, null).refreshPanelLinks();
                } catch (RemoteException ex) {
                    Logger.getLogger(PinnwandPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        buttonAbonnementLoeschen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(SocialMedia_Gui.Hauptfenster.hauptfenster(null, null),
                        "Das Abonnement wirklich löschen?", "Abonnement löschen",
                        JOptionPane.YES_NO_OPTION) == 0) {
                    try {
                        server.deleteAbonnement(pinnwandAbonnement);
                        SocialMedia_Gui.Hauptfenster.hauptfenster(null, null).refreshPanelLinks();
                    } catch (RemoteException ex) {
                        Logger.getLogger(DialogNutzer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }
   
    /**
     * Gets the user whose Pinnwand is displayed
     * @return Nutzer-object
     */
    public Nutzer getNutzer(){
        return this.nutzer;
    }
    
    /**
     * Getter for the ScrollPane
     * @return scrollPane of the Panel
     */
    public JScrollPane getScrollPane(){
        return scrollPane;
    }
}
