package SocialMedia_Data;

import SocialMedia_Logic.SocialMediaLogicImpl;
import java.util.Date;
import java.util.Vector;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.D34739A1-3E6D-6B19-CAA4-1E4A754FEA92]
// </editor-fold> 
public class AbonnementImpl extends DataReference implements Abonnement {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.332F54F4-F850-3FBE-B548-28DCCA1F4A8E]
    // </editor-fold> 
    private int pinnwandID;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3C60E566-06C4-999C-088C-A31EE76C9AC2]
    // </editor-fold> 
    private int nutzerID;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9A023376-AEF4-0492-69FC-D772039EAC98]
    // </editor-fold> 
    public AbonnementImpl () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0342C465-F245-6BA6-2C42-0097A84203E5]
    // </editor-fold> 
    public int getID () {
        return super.getID();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.470EDC27-EFF8-7E0C-8C42-93954CFB72E6]
    // </editor-fold> 
    public void setID (int val) {
        super.setID(val);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.34CD4721-4808-AC12-AB06-15C640C1C70A]
    // </editor-fold> 
    public int getNutzerID () {
        return nutzerID;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.8D1AACC7-2B0D-F458-8544-FC736F4D62B6]
    // </editor-fold> 
    public void setNutzerID (int val) {
        this.nutzerID = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.DF61E533-860E-7335-9C70-C524D9188253]
    // </editor-fold> 
    public int getPinnwandID () {
        return pinnwandID;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.7999840B-C95C-CF02-2B24-1C5DC8ACE910]
    // </editor-fold> 
    public void setPinnwandID (int val) {
        this.pinnwandID = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.FFDBA0C0-7013-1319-C885-A0C20F7E50BC]
    // </editor-fold> 
    public Date getCreationDate () {
        return super.getCreationDate();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.15452194-E393-8805-950E-73A7A3F863A4]
    // </editor-fold> 
    public void setCreationDate (Date val) {
        super.setCreationDate(val);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3F4ABB83-B7D5-73F1-C799-438A3E6484D4]
    // </editor-fold> 
    public Pinnwand getAbonnementPinnwand () {
        Vector<Pinnwand> pinnwaende = new Vector<Pinnwand>();
        pinnwaende = SocialMediaLogicImpl.getAllPinnwand();



        return null;
    }

}

