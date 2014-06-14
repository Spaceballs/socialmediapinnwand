/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Client;

import SocialMedia_Gui.DialogServerData;
import SocialMedia_Gui.HauptfensterReport;
import SocialMedia_IOandHelper.ClientPolicy;
import SocialMedia_Logic.SocialMediaLogic;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.security.Policy;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Client starting class. The client is started by the main class embedded in this one.
 * 
 * @author Sebastian
 */
public class SocialMediaReportClient {
    private final String serverPort = "1099";
    private final String clientPort = "1098";
    private String serverAdress = "localhost";
    private SocialMediaLogic socialMediaLogic = null;
    
    /**
     * Constructor of the client start class.
     * Prepares the Data for the rmi connection.
     */
    private SocialMediaReportClient (){
        try {
            serverAdress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(SocialMediaReportClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        Logger.getLogger(this.getClass().getName()).info("Client gestartet...");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Fehler", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(SocialMediaClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, ex, "Fehler", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(SocialMediaClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, ex, "Fehler", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(SocialMediaClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, ex, "Fehler", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(SocialMediaClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        javax.swing.SwingUtilities.invokeLater(
                new Runnable() { public void run() { createAndShowDialogue();}});
    }
    
    /**
     * Creates an window to ask for the server data.
     */
    public void createAndShowDialogue(){
        DialogServerData serverData = new DialogServerData(this, serverAdress, serverPort, clientPort);
    }
    
    /**
     * This Method starts the real client graphical user interface and the rmi connection.
     * With the data given by the Dialog Server Data.
     * 
     * @param adresse - String for the url.
     * @param serverPort - String for the server rmi port.
     * @param clientPort - String for the client rmi port.
     */
    public void executeClient(String adresse, String serverPort, String clientPort) {
         try {
             Policy.setPolicy(new ClientPolicy());
             RMISecurityManager securityManager = new RMISecurityManager();
             System.setSecurityManager(securityManager);
             
             Process exec = Runtime.getRuntime().exec("rmiregistry "+ clientPort);
             Logger.getLogger(this.getClass().getName()).info("RMI Gestartet...");
             socialMediaLogic = (SocialMediaLogic) Naming.lookup("rmi://" + adresse + ":" + serverPort + "/socialMediaLogic");
             Logger.getLogger(this.getClass().getName()).info("Verbindung hergestellt...");
             javax.swing.SwingUtilities.invokeLater(
                new Runnable() { public void run() { createAndShowGUI();}});
        } catch (NotBoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Fehler", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(SocialMediaReportClient.class.getName()).log(Level.SEVERE, null, ex);
            createAndShowDialogue();
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Fehler", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(SocialMediaReportClient.class.getName()).log(Level.SEVERE, null, ex);
            createAndShowDialogue();
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex, "Fehler", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(SocialMediaReportClient.class.getName()).log(Level.SEVERE, null, ex);
            createAndShowDialogue();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "Fehler", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(SocialMediaReportClient.class.getName()).log(Level.SEVERE, null, ex);
            createAndShowDialogue();
        }
    }
    
    /**
     * Method for creating the graphical user interface for the report client.
     */
    public void createAndShowGUI() {
        HauptfensterReport  report = new HauptfensterReport(socialMediaLogic);
    }    
       
    /**
     * Main class and start class for the client.
     * @param args - Deprecated
     */
    public static void main(String[] args) {
        SocialMediaReportClient c = new SocialMediaReportClient();
    }
}