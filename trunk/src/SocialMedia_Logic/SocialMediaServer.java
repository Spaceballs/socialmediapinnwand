package SocialMedia_Logic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;

 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.A24B76E7-9F46-56FA-1EC7-D50C1E13D908]
// </editor-fold> 
public class SocialMediaServer {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.075EE66D-FB4D-E499-E575-4D3910CB050F]
    // </editor-fold> 
    private SocialMediaLogic socialMediaLogic = null;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.34EC638F-091D-E446-8B60-6A9101569827]
    // </editor-fold> 
    public SocialMediaServer () {
		try {

			socialMediaLogic =
				new SocialMediaLogicImpl(SocialMedia_DatabaseManager.LikeMapper.likeMapper(),
                                                        SocialMedia_DatabaseManager.KommentarMapper.kommentarMapper(),
                                                        SocialMedia_DatabaseManager.BeitragMapper.beitragMapper(),
                                                        SocialMedia_DatabaseManager.AbonnementMapper.abonnementMapper(),
                                                        SocialMedia_DatabaseManager.NutzerMapper.nutzerMapper(),
                                                        SocialMedia_DatabaseManager.PinnwandMapper.pinnwandMapper());
                        
			Naming.rebind("rmi://thiesnb:1099/BankVerwaltung1",(Remote) socialMediaLogic);
		}
		catch (RemoteException e) {
			e.printStackTrace();
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5C715AB0-272A-0F62-41FE-99F75849F41F]
    // </editor-fold> 
    public static void main (String args[]) {
        SocialMediaServer logic = new SocialMediaServer();
    }
}

