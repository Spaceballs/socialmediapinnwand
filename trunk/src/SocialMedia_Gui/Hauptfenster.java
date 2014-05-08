
package SocialMedia_Gui;

import SocialMedia_Client.SocialMediaClient;
import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import SocialMedia_Report.HTMLWriter;
import SocialMedia_Report.Report;
import SocialMedia_Report.ReportImpl;
import SocialMedia_ReportGenerator.ReportGenerator;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private JMenuItem newsfeed = new JMenuItem("Newsfeed");
    private JMenuItem meinePinnwand = new JMenuItem("Meine Pinnwand");
    private JMenuItem suchen = new JMenuItem("Nutzer suchen");
    private JMenuItem accountdaten = new JMenuItem("Accountdaten ändern");
    private JMenuItem abmelden = new JMenuItem("Abmelden");
    private JPanel panelLinks = new JPanel();


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

    /**
     * Initializes all components (menu, listeners and frame)
     */
    private void initialize() {
        initializeMenu();
        initializeListeners();
        initializePane();
        sometests();
    }

    /**
     * Creates the menuBar and menus
     */
    private void initializeMenu() {
        menueLeiste.add(menue);
        menueLeiste.add(meinAccount);
        menue.add(newsfeed);
        menue.add(meinePinnwand);
        menue.add(suchen);
        meinAccount.add(accountdaten);
        meinAccount.add(abmelden);
        this.setJMenuBar(menueLeiste);
    }

    /**
     * All required listeners
     */
    private void initializeListeners() {
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

    /**
     * Creates the structure of the frame
     * with SplitPanes
     */
    private void initializePane() {
        NutzerInfo nutzerInfo = new NutzerInfo(server, clientNutzer);
        AbonnementInfo abonnementInfo = new AbonnementInfo(server, clientNutzer);

        JSplitPane splitPaneRechts = new JSplitPane(JSplitPane.VERTICAL_SPLIT, nutzerInfo, abonnementInfo);
        splitPaneRechts.setResizeWeight(0.1);
        splitPaneRechts.setEnabled(false);
        splitPaneRechts.setDividerSize(1);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelLinks, splitPaneRechts);
        splitPane.setResizeWeight(0.8);
        splitPane.setEnabled(false);
        splitPane.setDividerSize(0);
        this.getContentPane().add(splitPane);


        try {
            this.setTitle("Social Media Pinnwand von " + clientNutzer.getUsername());
        } catch (RemoteException ex) {
            Logger.getLogger(Hauptfenster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.pack();

        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH); // Frame is maximized on start
        this.setLocationRelativeTo(null); // frame is at the center of the screen
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
}
