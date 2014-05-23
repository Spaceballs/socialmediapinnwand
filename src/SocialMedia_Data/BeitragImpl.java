package SocialMedia_Data;

//import SocialMedia_DatabaseManager.Vector<Kommentar>;
//import SocialMedia_DatabaseManager.Vector<Like>;
import SocialMedia_Logic.SocialMediaLogicImpl;
import java.rmi.RemoteException;
import java.util.Vector;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.B78E78F9-7381-6316-44FC-40BD9E5B2A96]
// </editor-fold> 
/**
 * 
 * @author Sebastian
 */
public class BeitragImpl extends UserCreatedContentImpl implements Beitrag {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.26605933-6B2E-9CAF-2CEF-ACD76C226DE9]
    // </editor-fold> 
    private int pinnwandID;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.64B1D205-0A3A-C365-8CF0-423F6D3F24FA]
    // </editor-fold> 
    /**
     * Konstruktor von Beitrag.
     * @throws java.rmi.RemoteException
     */
    public BeitragImpl () 
            throws RemoteException{
    }


    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.793C9FA5-83AA-F5C8-A0D7-5DF4C6DFEBD0]
    // </editor-fold> 
    /**
     * Getter for the pinnwandID attribute.
     * @return  Returns the ID for the object.
     * @throws java.rmi.RemoteException
     */
    public int getPinnwandID () 
            throws RemoteException{
        return pinnwandID;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.675365E9-6660-CDB7-8379-12169A6F449E]
    // </editor-fold> 
    /**
     * Setter for the pinnwandID attribute.
     * @param val - The pinnwandID value which is to be set.
     * @throws java.rmi.RemoteException 
     */
    public void setPinnwandID (int val) 
            throws RemoteException{
        this.pinnwandID = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.07143528-A037-8DD6-009D-144D8FDEA987]
    // </editor-fold> 
    /**
     * 
     * @param verwaltung - This object is needed for getting data from the DB.
     * @throws java.rmi.RemoteException
     * @return - Returns the Kommentare of the Beitrag
     */
    public Vector<Kommentar> getAllBeitragKommentar (SocialMediaLogicImpl verwaltung) 
            throws RemoteException{
        Vector<Kommentar> kommentare = verwaltung.getAllKommentar();
        Vector<Kommentar> beitragKommentare = new Vector<Kommentar>();

        for (int i = 0; i < kommentare.size(); i++) {
            Kommentar kommentar = kommentare.elementAt(i);
            if(kommentar.getBeitragID() == this.getID())
                beitragKommentare.addElement(kommentar);
        }
        return beitragKommentare;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9AF3AE41-59F5-5C5E-7339-D644ABD49DD7]
    // </editor-fold> 
    /**
     * 
     * @param verwaltung - This object is needed for getting data from the DB.
     * @throws java.rmi.RemoteException
     * @return - Returns the number of Likes of a Beitrag.
     */
    public Vector<Like> getAllBeitragLikes (SocialMediaLogicImpl verwaltung) 
            throws RemoteException{
        Vector<Like> likes = verwaltung.getAllLike();
        Vector<Like> beitragLikes = new Vector<Like>();
        
        for (int i = 0; i < likes.size(); i++) {
            Like like = likes.elementAt(i);
            if(like.getBeitragID() == this.getID())
                beitragLikes.addElement(like);
        }
        return beitragLikes;
    }
}

