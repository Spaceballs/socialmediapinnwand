package SocialMedia_Data;

//import SocialMedia_DatabaseManager.Vector<Beitrag>;
import SocialMedia_Logic.SocialMediaLogicImpl;
    import java.util.Vector;
    import java.util.Date;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.47B4081F-641D-CF5F-7507-4246F9B5F87B]
// </editor-fold> 
public class PinnwandImpl extends DataReference implements Pinnwand {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F8ED24B1-434A-1BB8-CA16-4BFE06D95567]
    // </editor-fold> 
    private int nutzerID;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.72DCC317-149D-B9E4-6A3B-717A3374A9CA]
    // </editor-fold> 
    public PinnwandImpl () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.336B64D4-7A85-04C0-6E35-345CAFB99DEF]
    // </editor-fold> 
    public int getID () {
        return super.getID();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.89A92A9A-D870-875A-FB5B-2E3A39DE06D9]
    // </editor-fold> 
    public void setID (int val) {
        super.setID(val);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.9C4291DD-740E-D30A-3764-2DC928A81FA5]
    // </editor-fold> 
    public int getNutzerID () {
        return nutzerID;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.44707E22-5B0D-70BB-F963-9CA705705444]
    // </editor-fold> 
    public void setNutzerID (int val) {
        this.nutzerID = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8E214C75-16B9-1093-9E83-06CAE123C577]
    // </editor-fold> 
    public Date getCreationDate () {
        return super.getCreationDate();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B250D00D-7652-10AF-33A3-C9FDA1EA3CA3]
    // </editor-fold> 
    public void setCreationDate (Date val) {
        super.setCreationDate(val);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1C5670FC-1942-4082-13A2-408A385BBDAB]
    // </editor-fold> 
    public Vector<Beitrag> getAllPinnwandBeitraege (SocialMediaLogicImpl verwaltung) {
        Vector<Beitrag> beitraege = verwaltung.getAllBeitrag();
        Vector<Beitrag> pinnwandBeitraege = null;

        for (int i = 0; i < beitraege.size(); i++) {
            Beitrag beitrag = beitraege.elementAt(i);
            if(beitrag.getPinnwandID() == this.getID())
                pinnwandBeitraege.addElement(beitrag);
        }
        return pinnwandBeitraege;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A095AC40-10D1-77A9-0A67-2D41CC05B201]
    // </editor-fold> 
    public Nutzer getOwner (SocialMediaLogicImpl verwaltung) {
        Vector<Nutzer> nutzers = verwaltung.getAllNutzer();

        for (int i = 0; i < nutzers.size(); i++) {
            Nutzer nutzer = nutzers.elementAt(i);
            if(nutzer.getID() == nutzerID)
                return nutzer;
        }
        return null;
    }

}

