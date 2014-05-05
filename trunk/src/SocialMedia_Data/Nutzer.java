package SocialMedia_Data;

import SocialMedia_Logic.SocialMediaLogicImpl;
import java.rmi.RemoteException;
import java.util.Vector;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.917FBD41-4ADB-8612-BEDC-6048D96A8ED8]
// </editor-fold> 
/**
 * 
 * @author Sebastian
 */
public interface Nutzer extends DataReference{

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E43AA795-3C56-21D4-4433-70637434F45E]
    // </editor-fold> 
    /**
     * 
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public String getUsername ()
            throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3E73CF75-5E6B-810D-6C9C-5F5EB3FC885F]
    // </editor-fold> 
    /**
     * 
     * @param val 
     * @throws java.rmi.RemoteException 
     */
    public void setUsername (String val)
            throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8458843F-1E37-B667-B32B-DBC7B069FDB8]
    // </editor-fold> 
    /**
     * 
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public String getName ()
            throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3D2FE16F-24D5-6839-AB3C-D9115E02A2E9]
    // </editor-fold> 
    /**
     * 
     * @param val 
     * @throws java.rmi.RemoteException 
     */
    public void setName (String val)
            throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.90EE25F5-9838-FA49-1619-7496F8C9D4CE]
    // </editor-fold> 
    /**
     * 
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public String getSurname ()
            throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C745F1EF-B411-98F3-1AAE-A7B56AC34214]
    // </editor-fold> 
    /**
     * 
     * @param val 
     * @throws java.rmi.RemoteException 
     */
    public void setSurname (String val)
            throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2724338A-E37B-F36D-B4B8-465E8AF41A47]
    // </editor-fold> 
    /**
     * 
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public String getPassword ()
            throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8599D1DB-7C9D-E5AA-1335-1F77CA4ABE17]
    // </editor-fold> 
    /**
     * 
     * @param val 
     * @throws java.rmi.RemoteException 
     */
    public void setPassword (String val)
            throws RemoteException;

    /**
     * 
     * @param verwaltung
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public Pinnwand getNutzerPinnwand (SocialMediaLogicImpl verwaltung)
            throws RemoteException;

    /**
     * 
     * @param verwaltung
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public Vector<Abonnement> getAllNutzerAbonnement (SocialMediaLogicImpl verwaltung)
            throws RemoteException;

}

