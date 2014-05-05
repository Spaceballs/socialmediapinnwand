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
     * 
     */
    public BeitragImpl () 
            throws RemoteException{
    }


    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.793C9FA5-83AA-F5C8-A0D7-5DF4C6DFEBD0]
    // </editor-fold> 
    /**
     * 
     * @return 
     */
    public int getPinnwandID () 
            throws RemoteException{
        return pinnwandID;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.675365E9-6660-CDB7-8379-12169A6F449E]
    // </editor-fold> 
    /**
     * 
     * @param val 
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
     * @param verwaltung
     * @return 
     */
    public Vector<Kommentar> getAllBeitragKommentar (SocialMediaLogicImpl verwaltung) 
            throws RemoteException{
        Vector<Kommentar> kommentare = verwaltung.getAllKommentar();
        Vector<Kommentar> beitragKommentare = null;

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
     * @param verwaltung
     * @return 
     */
    public Vector<Like> getAllBeitragLikes (SocialMediaLogicImpl verwaltung) 
            throws RemoteException{
        Vector<Like> likes = verwaltung.getAllLike();
        Vector<Like> beitragLikes = null;
        
        for (int i = 0; i < likes.size(); i++) {
            Like like = likes.elementAt(i);
            if(like.getBeitragID() == this.getID())
                beitragLikes.addElement(like);
        }
        return beitragLikes;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A58E4ADA-B07B-F1DF-555A-F2302C150E60]
    // </editor-fold> 
    /**
     * 
     * @param verwaltung
     * @return 
     */
    public Nutzer getCreatorOfBeitrag (SocialMediaLogicImpl verwaltung) 
            throws RemoteException{
        Vector<Nutzer> nutzers = verwaltung.getAllNutzer();

        for (int i = 0; i < nutzers.size(); i++) {
            Nutzer nutzer = nutzers.elementAt(i);
            if(nutzer.getID() == this.getNutzerID())
                return nutzer;
        }
        return null;
    }
}

