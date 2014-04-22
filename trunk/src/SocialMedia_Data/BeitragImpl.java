package SocialMedia_Data;

//import SocialMedia_DatabaseManager.Vector<Kommentar>;
//import SocialMedia_DatabaseManager.Vector<Like>;
import java.util.Date;
import java.util.Vector;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.B78E78F9-7381-6316-44FC-40BD9E5B2A96]
// </editor-fold> 
public class BeitragImpl extends UserCreatedContentImpl implements Beitrag {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.26605933-6B2E-9CAF-2CEF-ACD76C226DE9]
    // </editor-fold> 
    private int pinnwandID;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.64B1D205-0A3A-C365-8CF0-423F6D3F24FA]
    // </editor-fold> 
    public BeitragImpl () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C945911F-F454-1D88-5310-C9A5C00922CB]
    // </editor-fold> 
    public String getText () {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2C7CB7A6-B16F-682E-E585-FD398806DF85]
    // </editor-fold> 
    public void setText (String val) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4A30B1A8-6AC6-7D86-7848-B2917DD642B5]
    // </editor-fold> 
    public int getID () {
        return 0;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F71FDCA7-B9C9-FA59-2C86-92BF6FA9CF31]
    // </editor-fold> 
    public void setID (int val) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.793C9FA5-83AA-F5C8-A0D7-5DF4C6DFEBD0]
    // </editor-fold> 
    public int getPinnwandID () {
        return pinnwandID;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.675365E9-6660-CDB7-8379-12169A6F449E]
    // </editor-fold> 
    public void setPinnwandID (int val) {
        this.pinnwandID = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.57E61C7E-1682-26A8-796D-BF4927349BF6]
    // </editor-fold> 
    public void setCreationDate (Date val) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.42B80735-49DD-DC44-32A0-27F8A0A1EE65]
    // </editor-fold> 
    public int getNutzerID () {
        return 0;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.ECF4D252-5F36-EC4D-1454-1F816D76890B]
    // </editor-fold> 
    public void setNutzerID (int val) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.DA572805-9588-8C69-7CF1-90C898B1A046]
    // </editor-fold> 
    public Date getCreationDate () {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.07143528-A037-8DD6-009D-144D8FDEA987]
    // </editor-fold> 
    public Vector<Kommentar> getAllBeitragKommentar () {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9AF3AE41-59F5-5C5E-7339-D644ABD49DD7]
    // </editor-fold> 
    public Vector<Like> getAllBeitragLikes () {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A58E4ADA-B07B-F1DF-555A-F2302C150E60]
    // </editor-fold> 
    public Nutzer getCreatorOfBeitrag () {
        return null;
    }

}

