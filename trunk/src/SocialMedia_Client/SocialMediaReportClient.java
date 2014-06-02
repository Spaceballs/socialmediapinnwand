/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Client;

import SocialMedia_Gui.DialogServerData;
import SocialMedia_Gui.HauptfensterReport;
import SocialMedia_Logic.SocialMediaLogic;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
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
    private final String serverAdress = "localhost";
    private SocialMediaLogic socialMediaLogic = null;
    
    /**
     * Constructor of the client start class.
     */
    private SocialMediaReportClient (){
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
     * This Method starts the real client grafical user interface and the rmi connection.
     * 
     * @param adresse - String for the url.
     * @param serverPort - String for the server rmi port.
     * @param clientPort - String for the client rmi port.
     */
    public void executeClient(String adresse, String serverPort, String clientPort) {
         try {
             Process exec = Runtime.getRuntime().exec("rmiregistry "+ clientPort);
             System.out.println("RMI Gestartet...");
             socialMediaLogic = (SocialMediaLogic) Naming.lookup("rmi://" + adresse + ":" + serverPort + "/socialMediaLogic");
             System.out.println("Verbindung hergestellt...");
        } catch (NotBoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Fehler", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(SocialMediaReportClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Fehler", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(SocialMediaReportClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex, "Fehler", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(SocialMediaReportClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "Fehler", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(SocialMediaReportClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        javax.swing.SwingUtilities.invokeLater(
                new Runnable() { public void run() { createAndShowGUI();}});
    }
    
    /**
     * Method for crating the graphical user interface for the report client.
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
        System.out.println("Client gestartet...");
    }
}