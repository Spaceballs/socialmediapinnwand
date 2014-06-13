package SocialMedia_Data;

import SocialMedia_Logic.SocialMediaLogicImpl;
import java.rmi.RemoteException;
import java.util.Vector;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.2A8A201C-25A8-2BD1-CC04-C6B0EFE3BF00]
// </editor-fold> 
/**
 * @todo Kommentare
 * @author Sebastian
 */
public interface Beitrag extends UserCreatedContent {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1904621F-2CD0-69B0-FCF7-13F7B5E2F83A]
    // </editor-fold> 
    /**
     * 
     * Getter for the pinnwandID attribute.
     * @throws java.rmi.RemoteException
     * @return int
     */
    public int getPinnwandID ()
            throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.651C2F55-16EC-4891-EB48-470BBCF219A5]
    // </editor-fold> 
    /**
     * 
     * Setter for the pinnwandID attribute.
     * @throws java.rmi.RemoteException
     * @param val - int value to be set
     */
    public void setPinnwandID (int val)
            throws RemoteException;

    /**
     * Note: only used by the Server. 
     * Getter for all Kommentare of the Beitrag.
     * @param verwaltung - This object is needed for getting data from the DB.
     * @throws java.rmi.RemoteException
     * @return Vector
     */
    public Vector<Kommentar> getAllBeitragKommentar (SocialMediaLogicImpl verwaltung)
            throws RemoteException;

    /**
     * Note: only used by the Server. 
     * Getter for all likes of the Beitrag.
     * @param verwaltung - This object is needed for getting data from the DB.
     * @throws java.rmi.RemoteException
     * @return Vector
     */
    public Vector<Like> getAllBeitragLikes (SocialMediaLogicImpl verwaltung)
            throws RemoteException;
}

