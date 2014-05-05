package SocialMedia_Data;

import SocialMedia_Logic.SocialMediaLogicImpl;
import java.rmi.RemoteException;
import java.util.Vector;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.2A8A201C-25A8-2BD1-CC04-C6B0EFE3BF00]
// </editor-fold> 
/**
 * 
 * @author Sebastian
 */
public interface Beitrag extends UserCreatedContent {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1904621F-2CD0-69B0-FCF7-13F7B5E2F83A]
    // </editor-fold> 
    /**
     * 
     * @return 
     */
    public int getPinnwandID ()
            throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.651C2F55-16EC-4891-EB48-470BBCF219A5]
    // </editor-fold> 
    /**
     * 
     * @param val 
     */
    public void setPinnwandID (int val)
            throws RemoteException;

    /**
     * 
     * @param verwaltung
     * @return 
     */
    public Vector<Kommentar> getAllBeitragKommentar (SocialMediaLogicImpl verwaltung)
            throws RemoteException;

    /**
     * 
     * @param verwaltung
     * @return 
     */
    public Vector<Like> getAllBeitragLikes (SocialMediaLogicImpl verwaltung)
            throws RemoteException;

    /**
     * 
     * @param verwaltung
     * @return 
     */
    public Nutzer getCreatorOfBeitrag (SocialMediaLogicImpl verwaltung)
            throws RemoteException;

}

