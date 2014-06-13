package SocialMedia_Data;

import SocialMedia_Logic.SocialMediaLogicImpl;
import java.rmi.RemoteException;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.C6C8C8C1-C1A1-6C43-5A79-24AB722E73B1]
// </editor-fold> 
/**
 * @todo Kommentare
 * @author Sebastian
 */
public interface Abonnement extends DataReference {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CA1B5D3A-569F-7542-04E9-B473D20FF13A]
    // </editor-fold> 
    /**
     * Getter for the PinnwandID attribute.
     * @throws java.rmi.RemoteException
     * @return - Returns the int ID of the object.
     */
    public int getPinnwandID ()
            throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CEE0B0A3-45CB-A3FE-D990-AF2358894EC7]
    // </editor-fold> 
    /**
     * Setter for the PinnwandID attribute.
     * @throws java.rmi.RemoteException
     * @param val - Needs an int ID to be set.
     */
    public void setPinnwandID (int val)
            throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C6252FA8-05D7-5CCB-DA2B-1A0531F2BF0E]
    // </editor-fold> 
    /**
     * Getter for the NutzerID attribute.
     * @return Integer - Returns the int ID of the object.
     * @throws java.rmi.RemoteException 
     */
    public int getNutzerID ()
            throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3EAF494D-794D-E648-FA6B-1504A7AF2165]
    // </editor-fold> 
    /**
     * Setter for the NutzerID attribute.
     * @throws java.rmi.RemoteException
     * @param val - Needs an int ID to be set. 
     */
    public void setNutzerID (int val)
            throws RemoteException;

    /**
     * Collects all Pinnwand Abonnements and compares them with the current PinnwandID
     * @param verwaltung - This object is needed for getting data from the DB.
     * @throws java.rmi.RemoteException
     * @return - Returns the Pinnwand object. 
     */
    public Pinnwand getAbonnementPinnwand (SocialMediaLogicImpl verwaltung)
            throws RemoteException;
}

