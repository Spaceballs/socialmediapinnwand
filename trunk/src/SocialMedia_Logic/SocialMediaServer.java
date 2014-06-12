package SocialMedia_Logic;

import SocialMedia_IOandHelper.ServerPolicy;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.security.Policy;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Social Media Server creates the server logic and the mappers.
 * After that the RMI server is created the server logic is registrated with the RMI.
 * 
 * @author Sebastian
 */

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.A24B76E7-9F46-56FA-1EC7-D50C1E13D908]
// </editor-fold> 
public class SocialMediaServer {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.075EE66D-FB4D-E499-E575-4D3910CB050F]
    // </editor-fold> 
    private SocialMediaLogic socialMediaLogic = null;

    private final int serverPort = 1099;
    
    
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.34EC638F-091D-E446-8B60-6A9101569827]
    // </editor-fold>

    /**
     * Constructor of the Server class
     */
    public SocialMediaServer () {
        String ip = "localhost";
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(SocialMediaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        Logger.getLogger(this.getClass().getName()).info("Server gestartet...");
        try {
            socialMediaLogic =
                    new SocialMediaLogicImpl(SocialMedia_DatabaseManager.LikeMapper.likeMapper(),
                                            SocialMedia_DatabaseManager.KommentarMapper.kommentarMapper(),
                                            SocialMedia_DatabaseManager.BeitragMapper.beitragMapper(),
                                            SocialMedia_DatabaseManager.AbonnementMapper.abonnementMapper(),
                                            SocialMedia_DatabaseManager.NutzerMapper.nutzerMapper(),
                                            SocialMedia_DatabaseManager.PinnwandMapper.pinnwandMapper());
            RMISecurityManager securityManager = new RMISecurityManager();
            Policy.setPolicy(new ServerPolicy());
            System.setSecurityManager(securityManager);
            
            Process exec = Runtime.getRuntime().exec("rmiregistry "+ serverPort);
            Logger.getLogger(this.getClass().getName()).info("RMI Gestartet...");

            Registry rmiRegistry = LocateRegistry.createRegistry(serverPort);
            Logger.getLogger(this.getClass().getName()).info("RMI Registry am Port " + serverPort + " erstellt...");
            
            Logger.getLogger(this.getClass().getName()).info("Server: "+ ip);

            Naming.rebind("rmi://" + ip + ":" + serverPort + "/socialMediaLogic",(Remote) socialMediaLogic);
            Naming.lookup("rmi://" + ip + ":" + serverPort + "/socialMediaLogic");
            Logger.getLogger(this.getClass().getName()).info("RMI Verbindung hergestellt...");

            

        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex, "Fehler", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(SocialMediaServer.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Fehler", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(SocialMediaServer.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        } catch (IOException ex){
            JOptionPane.showMessageDialog(null, ex, "Fehler", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(SocialMediaServer.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        } catch (NotBoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Fehler", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(SocialMediaServer.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5C715AB0-272A-0F62-41FE-99F75849F41F]
    // </editor-fold> 
    /**
     * Main class of the server and crates the server itself.
     * @param args - deprecated
     */
    public static void main (String args[]) {
        SocialMediaServer logic = new SocialMediaServer();
    }
}

