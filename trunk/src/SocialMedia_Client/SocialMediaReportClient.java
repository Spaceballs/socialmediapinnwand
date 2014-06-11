/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Client;

import SocialMedia_IOandHelper.ReadWriteTextFile;
import SocialMedia_Gui.DialogServerData;
import SocialMedia_Gui.HauptfensterReport;
import SocialMedia_Logic.SocialMediaLogic;
import SocialMedia_Logic.SocialMediaServer;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
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
     */
    private SocialMediaReportClient (){
        ReadWriteTextFile text = new ReadWriteTextFile();
        try {
            Logger.getLogger(this.getClass().getName()).info("Loading Policy Data...");
            ClassLoader loader = this.getClass().getClassLoader();
            StringBuilder packageStringBuilder = new StringBuilder(this.getClass().getPackage().toString());
            packageStringBuilder.delete(0, 8).append("/");
            String path = loader.getResource(packageStringBuilder.toString()).toString();
            path = path.replaceAll(packageStringBuilder.toString(), "");
            serverAdress = InetAddress.getLocalHost().getHostAddress();
            System.out.println(serverAdress);
            
            Logger.getLogger(this.getClass().getName()).info("Preparing File...");
            List<String> lines = text.readSmallTextFile("client.policy.set");
            List<String> lines0 = new ArrayList<String>();

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i).replaceAll("%path", path).replaceAll("%ip", serverAdress);  
                lines0.add(i, line);
            }
            Logger.getLogger(this.getClass().getName()).info("Writing Files...");
            text.writeSmallTextFile(lines0, "client.policy");
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(SocialMediaServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SocialMediaServer.class.getName()).log(Level.SEVERE, null, ex);
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
     * 
     * @param adresse - String for the url.
     * @param serverPort - String for the server rmi port.
     * @param clientPort - String for the client rmi port.
     */
    public void executeClient(String adresse, String serverPort, String clientPort) {
        
        
        
         try {
             System.setProperty("java.security.policy", "client.policy");
             RMISecurityManager securityManager = new RMISecurityManager();
             System.setSecurityManager(securityManager);
             
             Process exec = Runtime.getRuntime().exec("rmiregistry "+ clientPort);
             Logger.getLogger(this.getClass().getName()).info("RMI Gestartet...");
             socialMediaLogic = (SocialMediaLogic) Naming.lookup("rmi://" + adresse + ":" + serverPort + "/socialMediaLogic");
             Logger.getLogger(this.getClass().getName()).info("Verbindung hergestellt...");
        } catch (NotBoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Fehler", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(SocialMediaReportClient.class.getName()).log(Level.SEVERE, null, ex);
            javax.swing.SwingUtilities.invokeLater(
                new Runnable() { public void run() { createAndShowDialogue();}});
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Fehler", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(SocialMediaReportClient.class.getName()).log(Level.SEVERE, null, ex);
            javax.swing.SwingUtilities.invokeLater(
                new Runnable() { public void run() { createAndShowDialogue();}});
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex, "Fehler", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(SocialMediaReportClient.class.getName()).log(Level.SEVERE, null, ex);
            javax.swing.SwingUtilities.invokeLater(
                new Runnable() { public void run() { createAndShowDialogue();}});
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "Fehler", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(SocialMediaReportClient.class.getName()).log(Level.SEVERE, null, ex);
            javax.swing.SwingUtilities.invokeLater(
                new Runnable() { public void run() { createAndShowDialogue();}});
        }
        javax.swing.SwingUtilities.invokeLater(
                new Runnable() { public void run() { createAndShowGUI();}});
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