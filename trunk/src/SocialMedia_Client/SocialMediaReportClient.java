/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Client;

import SocialMedia_Gui.DialogAnmelden;
import SocialMedia_Gui.DialogServerData;
import SocialMedia_Gui.HauptfensterReport;
import SocialMedia_Logic.SocialMediaLogic;
import SocialMedia_ReportGenerator.ReportGenerator;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastian
 */
public class SocialMediaReportClient {
    private final String serverPort = "1099";
    private final String clientPort = "1098";
    private final String serverAdress = "localhost";
    private SocialMediaLogic socialMediaLogic = null;
    
    /**
     * 
     */
    private SocialMediaReportClient (){
        DialogServerData serverData = new DialogServerData(this, serverAdress, serverPort, clientPort);
    }

    /**
     * 
     * @param adresse
     * @param serverPort 
     */
    public void executeClient(String adresse, String serverPort, String clientPort) {
         try {
             Process exec = Runtime.getRuntime().exec("rmiregistry "+ clientPort);
             System.out.println("RMI Gestartet...");
             socialMediaLogic = (SocialMediaLogic) Naming.lookup("rmi://" + adresse + ":" + serverPort + "/socialMediaLogic");
             System.out.println("Verbindung hergestellt...");
        } catch (NotBoundException ex) {
            Logger.getLogger(SocialMediaReportClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(SocialMediaReportClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(SocialMediaReportClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SocialMediaReportClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        javax.swing.SwingUtilities.invokeLater(
                new Runnable() { public void run() { createAndShowGUI();}});
    }
    
    /**
     * 
     */
    public void createAndShowGUI() {
        HauptfensterReport  report = new HauptfensterReport(socialMediaLogic);
    }    
       
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        SocialMediaReportClient c = new SocialMediaReportClient();
        System.out.println("Client gestartet...");
    }
}