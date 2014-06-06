
package SocialMedia_Gui;

import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 * Creates the main frame of the client
 * @author Max
 */
public class Hauptfenster extends JFrame {
    
    private final SocialMediaLogic server;
    private final Nutzer clientNutzer;
    private final JMenuBar menueLeiste = new JMenuBar();
    private final JMenu meinAccount = new JMenu("Mein Account");
    private final JMenu menue = new JMenu("Menü");
    private final JMenuItem newsfeedMenu = new JMenuItem("Newsfeed");
    private final JMenuItem meinePinnwandMenu = new JMenuItem("Meine Pinnwand");
    private final JMenuItem suchen = new JMenuItem("Nutzer suchen");
    private final JMenuItem accountdaten = new JMenuItem("Accountdaten ändern");
    private final JMenuItem abmelden = new JMenuItem("Abmelden");
    private JPanel panelLinks = new JPanel();
    private JSplitPane splitPane;
    private JSplitPane splitPaneRechts;
    private PinnwandPanel pinnwandPanel;
    private NewsfeedPanel newsfeedPanel;
    private static Hauptfenster hauptfenster;


    /**
     * Constructor of the Hauptfenster class
     * @param server - the server
     * @param clientNutzer - the logged-in Nutzer
     */
    public Hauptfenster(SocialMediaLogic server, Nutzer clientNutzer){
        this.clientNutzer = clientNutzer;
        this.server = server;
        initialize();
    }
    

    /**
     *
     * @param server - the server
     * @param clientNutzer - the logged-in Nutzer
     * @return - Returns the hauptfenster
     */
    
    public static Hauptfenster hauptfenster(SocialMediaLogic server, Nutzer clientNutzer){
        if(server == null && clientNutzer == null){
            return hauptfenster;
        } else{
            if (hauptfenster == null){
                hauptfenster = new Hauptfenster(server, clientNutzer);
            }
        }
        return hauptfenster;
    }

    /**
     * Initializes all components (menu, listeners and frame)
     */
    private void initialize() {
        NewsfeedPanel newsfeed = new NewsfeedPanel(server, clientNutzer);
        panelLinks = newsfeed;
        initializeMenu();
        initializeListeners();
        initializePane();
        initializeOptions();
    }

    /**
     * Creates the menuBar and menus
     */
    private void initializeMenu() {
        menueLeiste.add(menue);
        menueLeiste.add(meinAccount);
        menue.add(newsfeedMenu);
        menue.add(meinePinnwandMenu);
        menue.add(suchen);
        meinAccount.add(accountdaten);
        meinAccount.add(abmelden);
        this.setJMenuBar(menueLeiste);
    }

    /**
     * Creates the structure of the frame
     * with SplitPanes
     */
    private void initializePane() {
        NutzerInfo nutzerInfo = new NutzerInfo(server, clientNutzer);
        AbonnementInfo abonnementInfo = new AbonnementInfo(server, clientNutzer);
        
        splitPaneRechts = new JSplitPane(JSplitPane.VERTICAL_SPLIT, nutzerInfo, abonnementInfo);
        splitPaneRechts.setResizeWeight(0);
        splitPaneRechts.setEnabled(false);
        splitPaneRechts.setDividerSize(1);
        
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelLinks, splitPaneRechts);
        splitPane.setResizeWeight(0.7);
        splitPane.setEnabled(false);
        splitPane.setDividerSize(0);
        this.getContentPane().add(splitPane);

        try {
            this.setTitle("Social Media Pinnwand von " + clientNutzer.getUsername());
        } catch (RemoteException ex) {
            Logger.getLogger(Hauptfenster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.setVisible(true);  
    }

    /**
     * Removes all panels and sets them again with the given panel as panelLinks
     * @param panelLinks - JPanel on the left side (newsfeed or meinePinnwand) 
     */
    public void setPanelLinks(JPanel panelLinks) {
        this.getContentPane().removeAll();
        if (panelLinks != null)
            this.panelLinks = panelLinks;
        NutzerInfo nutzerInfo = new NutzerInfo(server, clientNutzer);
        AbonnementInfo abonnementInfo = new AbonnementInfo(server, clientNutzer);
        NewsfeedPanel newsfeed = new NewsfeedPanel(server, clientNutzer);

        splitPaneRechts = new JSplitPane(JSplitPane.VERTICAL_SPLIT, nutzerInfo, abonnementInfo);
        splitPaneRechts.setResizeWeight(0);
        splitPaneRechts.setEnabled(false);
        splitPaneRechts.setDividerSize(1);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelLinks, splitPaneRechts);
        splitPane.setResizeWeight(0.7);
        splitPane.setEnabled(false);
        splitPane.setDividerSize(0);
        this.getContentPane().add(splitPane);

        this.setVisible(true);
    }
    
    /**
     * 
     */
    private void initializeOptions() {
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH); // Frame is maximized on start
//        this.setMinimumSize(new Dimension(400, 200));
        
        this.setSize(1024, 768);
        this.setResizable(false);
        this.setLocationRelativeTo(null); // frame is at the center of the screen
    }

    
    /**
     * All required listeners
     */    
    private void initializeListeners() {
        newsfeedMenu.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               newsfeedPanel = new NewsfeedPanel(server, clientNutzer);
               setPanelLinks(newsfeedPanel);
           }
        });

        meinePinnwandMenu.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               pinnwandPanel = new PinnwandPanel(server, clientNutzer, clientNutzer);
               setPanelLinks(pinnwandPanel);
           }
        });

        suchen.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               DialogSuchen dialogSuchen = new DialogSuchen(server, clientNutzer);
           }
        });

        accountdaten.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               DialogNutzer dialogNutzer = new DialogNutzer(server, clientNutzer);
           }
        });

        abmelden.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(Hauptfenster.this,
                        "Das Programm wirklich beenden?", "Beenden",
                        JOptionPane.YES_NO_OPTION) == 0) {
                    System.exit(0);
                }
            }
        });
    }
}
