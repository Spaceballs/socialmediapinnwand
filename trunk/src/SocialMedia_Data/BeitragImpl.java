package SocialMedia_Data;

//import SocialMedia_DatabaseManager.Vector<Kommentar>;
//import SocialMedia_DatabaseManager.Vector<Like>;
import SocialMedia_Logic.SocialMediaLogicImpl;
import java.util.Date;
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
    public BeitragImpl () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C945911F-F454-1D88-5310-C9A5C00922CB]
    // </editor-fold> 
    /**
     * 
     * @return 
     */
    public String getText () {
        return super.getText();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2C7CB7A6-B16F-682E-E585-FD398806DF85]
    // </editor-fold> 
    /**
     * 
     * @param val 
     */
    public void setText (String val) {
        super.setText(val);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4A30B1A8-6AC6-7D86-7848-B2917DD642B5]
    // </editor-fold> 
    /**
     * 
     * @return 
     */
    public int getID () {
        return super.getID();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F71FDCA7-B9C9-FA59-2C86-92BF6FA9CF31]
    // </editor-fold> 
    /**
     * 
     * @param val 
     */
    public void setID (int val) {
        super.setID(val);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.793C9FA5-83AA-F5C8-A0D7-5DF4C6DFEBD0]
    // </editor-fold> 
    /**
     * 
     * @return 
     */
    public int getPinnwandID () {
        return pinnwandID;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.675365E9-6660-CDB7-8379-12169A6F449E]
    // </editor-fold> 
    /**
     * 
     * @param val 
     */
    public void setPinnwandID (int val) {
        this.pinnwandID = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.57E61C7E-1682-26A8-796D-BF4927349BF6]
    // </editor-fold> 
    /**
     * 
     * @param val 
     */
    public void setCreationDate (Date val) {
        super.setCreationDate(val);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.42B80735-49DD-DC44-32A0-27F8A0A1EE65]
    // </editor-fold> 
    /**
     * 
     * @return 
     */
    public int getNutzerID () {
        return super.getNutzerID();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.ECF4D252-5F36-EC4D-1454-1F816D76890B]
    // </editor-fold> 
    /**
     * 
     * @param val 
     */
    public void setNutzerID (int val) {
        super.setNutzerID(val);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.DA572805-9588-8C69-7CF1-90C898B1A046]
    // </editor-fold> 
    /**
     * 
     * @return 
     */
    public Date getCreationDate () {
        return super.getCreationDate();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.07143528-A037-8DD6-009D-144D8FDEA987]
    // </editor-fold> 
    /**
     * 
     * @param verwaltung
     * @return 
     */
    public Vector<Kommentar> getAllBeitragKommentar (SocialMediaLogicImpl verwaltung) {
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
    public Vector<Like> getAllBeitragLikes (SocialMediaLogicImpl verwaltung) {
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
    public Nutzer getCreatorOfBeitrag (SocialMediaLogicImpl verwaltung) {
        Vector<Nutzer> nutzers = verwaltung.getAllNutzer();

        for (int i = 0; i < nutzers.size(); i++) {
            Nutzer nutzer = nutzers.elementAt(i);
            if(nutzer.getID() == this.getNutzerID())
                return nutzer;
        }
        return null;
    }
}

