package SocialMedia_Logic;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
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
     *
     */
    public SocialMediaServer () {
        try {
            socialMediaLogic =
                    new SocialMediaLogicImpl(SocialMedia_DatabaseManager.LikeMapper.likeMapper(),
                                            SocialMedia_DatabaseManager.KommentarMapper.kommentarMapper(),
                                            SocialMedia_DatabaseManager.BeitragMapper.beitragMapper(),
                                            SocialMedia_DatabaseManager.AbonnementMapper.abonnementMapper(),
                                            SocialMedia_DatabaseManager.NutzerMapper.nutzerMapper(),
                                            SocialMedia_DatabaseManager.PinnwandMapper.pinnwandMapper());

            Process exec = Runtime.getRuntime().exec("rmiregistry "+ serverPort);
            System.out.println("RMI Gestartet...");

            Registry rmiRegistry = LocateRegistry.createRegistry(serverPort);
            System.out.println("RMI Registry am Port " + serverPort + " erstellt...");

            String rmiRegistryServer = System.getProperty("java.rmi.registry.hostname","localhost");
            System.out.println("Server: "+ rmiRegistryServer);

            Naming.rebind("rmi://" + rmiRegistryServer + ":" + serverPort + "/socialMediaLogic",(Remote) socialMediaLogic);
            Naming.lookup("rmi://" + rmiRegistryServer + ":" + serverPort + "/socialMediaLogic");
            System.out.println("RMI Verbindung hergestellt...");
        } catch (RemoteException ex) {
            Logger.getLogger(SocialMediaServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(SocialMediaServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex){
            Logger.getLogger(SocialMediaServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(SocialMediaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5C715AB0-272A-0F62-41FE-99F75849F41F]
    // </editor-fold> 
    /**
     * 
     * @param args 
     */
    public static void main (String args[]) {
        SocialMediaServer logic = new SocialMediaServer();
        System.out.println("Server gestartet...");
    }
}

