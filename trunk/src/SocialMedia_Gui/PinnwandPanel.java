
package SocialMedia_Gui;

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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

/**
 * Creates the content of the panelLinks and
 * shows the Pinnwand (all Beitraege, Kommentare and Likes)
 * of the logged-in Nutzer
 * @author Max
 */
public class PinnwandPanel extends JPanel {

    private final SocialMediaLogic server;
    private final Nutzer clientNutzer;
    private final Nutzer nutzer;
    private final JLabel titlePinnwand = new JLabel("",JLabel.LEFT);
    private final JButton buttonNeuerBeitrag = new JButton("Neuer Beitrag");
    private final JButton buttonAbonnieren = new JButton("Abonnieren");
    private final JButton buttonAbonnementLoeschen = new JButton();
    private Vector<Beitrag> beitraege;
    private Pinnwand pinnwand;

    /**
     * Constructor
     * @param server - the server
     * @param clientNutzer - 
     * @param nutzer - 
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
     * Gets the username, name and surname of the logged-in Nutzer,
     * puts in in a GridLayout and
     * changes the font.
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
            
            buttonAbonnieren.setIcon(new ImageIcon("abonnieren.jpg"));
            buttonAbonnieren.setToolTipText("Nutzer " + nutzer.getUsername() + "abonnieren");
            
            buttonAbonnementLoeschen.setIcon(new ImageIcon("delete.jpg"));
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
            
            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setBorder(null);
            scrollPane.getInsets().set(0,0,0,0);
            scrollPane.setViewportBorder(null);
            scrollPane.getViewport().setBorder(null);
            
            JPanel scrollPanePane = new JPanel();
            scrollPanePane.setLayout(new GridBagLayout());
            
            GridBagConstraints c = new GridBagConstraints();
            
            c.fill = GridBagConstraints.HORIZONTAL;
            c.anchor = GridBagConstraints.LINE_START;
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
     * 
     */
    private void initializeData() {
            beitraege = new Vector<Beitrag>();
            
        try {
            pinnwand = server.getPinnwandOfNutzer(nutzer);
            beitraege.addAll(server.getAllBeitragOfPinnwand(pinnwand));
        } catch (RemoteException ex) {
            Logger.getLogger(PinnwandPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     */
    private void initializeListeners() {
        buttonNeuerBeitrag.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DialogBeitrag dialogBeitrag = new DialogBeitrag(server, nutzer, pinnwand);
            }
        });
    }

}
