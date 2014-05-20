
package SocialMedia_Gui;

import SocialMedia_Client.SocialMediaClient;
import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import SocialMedia_Report.HTMLWriter;
import SocialMedia_Report.Report;
import SocialMedia_ReportGenerator.ReportGenerator;
import java.awt.Dimension;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JList;

/**
 *
 * @author Max
 */
public class HauptfensterReport extends JFrame {
    
    private Nutzer reportUser = null;
    private SocialMediaLogic server = null;
    private JList<Nutzer> nutzerliste = new JList();

    /**
     * 
     * @param server 
     */
    public HauptfensterReport(SocialMediaLogic server) {
        try {
            nutzerliste.setListData(server.getAllNutzer());
        } catch (RemoteException ex) {
            Logger.getLogger(HauptfensterReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.server = server;
        initialize();
    }

    /**
     * 
     */
    private void initialize() {
        this.pack();
        this.setExtendedState(this.getExtendedState() | JFrame.NORMAL); // Frame is maximized on start
        this.setMinimumSize(new Dimension(400, 200));
        this.setLocationRelativeTo(null); // frame is at the center of the screen
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * 
     */
    private void sometests() {
        ReportGenerator reportGenerator;
        try {
            reportGenerator = server.getReportGenerator();
            //Report report = (Report) reportGenerator.createContributionOfNutzerReport(clientNutzer, 1, clientNutzer.getCreationDate(), new Date());
            //HTMLWriter writer = new HTMLWriter(report);
        } catch (RemoteException ex) {
            Logger.getLogger(SocialMediaClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
