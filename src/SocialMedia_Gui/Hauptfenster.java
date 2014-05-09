
package SocialMedia_Gui;

import SocialMedia_Client.SocialMediaClient;
import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import SocialMedia_Report.HTMLWriter;
import SocialMedia_Report.Report;
import SocialMedia_Report.ReportImpl;
import SocialMedia_ReportGenerator.ReportGenerator;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.basic.BasicBorders.SplitPaneBorder;

/**
 * Creates the main frame of the client
 * @author Max
 */
public class Hauptfenster extends JFrame {
    
    private SocialMediaLogic server;
    private Nutzer clientNutzer = null;
    private JMenuBar menueLeiste = new JMenuBar();
    private JMenu meinAccount = new JMenu("Mein Account");
    private JMenu menue = new JMenu("Menü");
    private JMenuItem newsfeedMenu = new JMenuItem("Newsfeed");
    private JMenuItem meinePinnwandMenu = new JMenuItem("Meine Pinnwand");
    private JMenuItem suchen = new JMenuItem("Nutzer suchen");
    private JMenuItem accountdaten = new JMenuItem("Accountdaten ändern");
    private JMenuItem abmelden = new JMenuItem("Abmelden");
    private JPanel panelLinks = new JPanel();
    private JPanel panelRechtsOben = new JPanel();
    private JPanel panelRechtsUnten = new JPanel();
    private JSplitPane splitPane;
    private JSplitPane splitPaneRechts;
    private MeinePinnwand meinePinnwand;
    private Newsfeed newsfeed;
    private static Hauptfenster hauptfenster;


    /**
     * Constructor
     * @param server - the server
     * @param clientNutzer - the logged-in Nutzer
     */
    public Hauptfenster(SocialMediaLogic server, Nutzer clientNutzer){
        this.clientNutzer = clientNutzer;
        this.server = server;
        initialize();
    }
    
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
        Newsfeed newsfeed = new Newsfeed(server, clientNutzer);
        panelLinks = newsfeed;
        initializeMenu();
        initializeListeners();
        initializePane();
        initializeOptions();
//        sometests();
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
//        NutzerInfo nutzerInfo = new NutzerInfo(server, clientNutzer);
//        AbonnementInfo abonnementInfo = new AbonnementInfo(server, clientNutzer);
//        Newsfeed newsfeed = new Newsfeed(server, clientNutzer);
//
//        splitPaneRechts = new JSplitPane(JSplitPane.VERTICAL_SPLIT, nutzerInfo, abonnementInfo);
//        splitPaneRechts.setResizeWeight(0);
//        splitPaneRechts.setEnabled(false);
//        splitPaneRechts.setDividerSize(1);
//
//        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelLinks, splitPaneRechts);
//        splitPane.setResizeWeight(0);
//        splitPane.setEnabled(false);
//        splitPane.setDividerSize(0);
//        this.getContentPane().add(splitPane);

        this.setVisible(true);
    }
    
    
    private void initializeOptions() {
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH); // Frame is maximized on start
        this.setMinimumSize(new Dimension(400, 200));
        this.setLocationRelativeTo(null); // frame is at the center of the screen
    }    

    private void sometests() {
        ReportGenerator reportGenerator;
        try {
            reportGenerator = server.getReportGenerator();
            Report report = (Report) reportGenerator.createContributionOfNutzerReport(clientNutzer, 1, clientNutzer.getCreationDate(), new Date());
            HTMLWriter writer = new HTMLWriter(report);
        } catch (RemoteException ex) {
            Logger.getLogger(SocialMediaClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * All required listeners
     */    
    private void initializeListeners() {

        //ActionListener Newsfeed
        newsfeedMenu.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               newsfeed = new Newsfeed(server, clientNutzer);
               setPanelLinks(newsfeed);
           }
        });

        //ActionListener Meine Pinnwand
        meinePinnwandMenu.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               meinePinnwand = new MeinePinnwand(server, clientNutzer);
               setPanelLinks(meinePinnwand);
           }
        });

        //ActionListener Nutzer suchen
        suchen.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               DialogSuchen dialogSuchen = new DialogSuchen(server);
           }
        });

        //ActionListener Accountdaten ändern
        accountdaten.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               DialogNutzer dialogNutzer = new DialogNutzer(server, clientNutzer);
           }
        });

        //ActionListener Abmelden
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
