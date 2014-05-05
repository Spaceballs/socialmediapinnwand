/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Client;

import SocialMedia_Gui.DialogAnmelden;
import static SocialMedia_Gui.Main.createAndShowGUI;
import SocialMedia_Logic.SocialMediaLogic;
import com.sun.org.apache.xml.internal.serializer.NamespaceMappings;
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
public class SocialMediaClient {
    
    private final int serverPort = 1099;
    private final String serverAdress = "localhost";
    SocialMediaLogic socialMediaLogic = null;
    
    
    
    /**
     * 
     */
    private SocialMediaClient (){
        try {
            Process exec = Runtime.getRuntime().exec("rmiregistry "+ (serverPort+1));
            System.out.println("RMI Gestartet...");
            socialMediaLogic = (SocialMediaLogic) Naming.lookup("rmi://" + serverAdress + ":" + serverPort + "/socialMediaLogic");
            System.out.println("Verbindung hergestellt...");
        } catch (NotBoundException ex) {
            Logger.getLogger(SocialMediaClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(SocialMediaClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(SocialMediaClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SocialMediaClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        javax.swing.SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        createAndShowGUI();
                    }
                }
        );
    }
    
    /**
     * 
     */
    public void createAndShowGUI() {
        DialogAnmelden  anmelden = new DialogAnmelden(socialMediaLogic);
    }
    
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        SocialMediaClient c = new SocialMediaClient();
        System.out.println("Client gestartet...");
    }
    
}