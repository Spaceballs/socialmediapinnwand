package SocialMedia_Data;

import SocialMedia_Logic.SocialMediaLogicImpl;
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
     */
    public String getUsername ();

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3E73CF75-5E6B-810D-6C9C-5F5EB3FC885F]
    // </editor-fold> 
    /**
     * 
     * @param val 
     */
    public void setUsername (String val);

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8458843F-1E37-B667-B32B-DBC7B069FDB8]
    // </editor-fold> 
    /**
     * 
     * @return 
     */
    public String getName ();

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3D2FE16F-24D5-6839-AB3C-D9115E02A2E9]
    // </editor-fold> 
    /**
     * 
     * @param val 
     */
    public void setName (String val);

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.90EE25F5-9838-FA49-1619-7496F8C9D4CE]
    // </editor-fold> 
    /**
     * 
     * @return 
     */
    public String getSurname ();

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C745F1EF-B411-98F3-1AAE-A7B56AC34214]
    // </editor-fold> 
    /**
     * 
     * @param val 
     */
    public void setSurname (String val);

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2724338A-E37B-F36D-B4B8-465E8AF41A47]
    // </editor-fold> 
    /**
     * 
     * @return 
     */
    public String getPassword ();

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8599D1DB-7C9D-E5AA-1335-1F77CA4ABE17]
    // </editor-fold> 
    /**
     * 
     * @param val 
     */
    public void setPassword (String val);

    /**
     * 
     * @param verwaltung
     * @return 
     */
    public Pinnwand getNutzerPinnwand (SocialMediaLogicImpl verwaltung);

    /**
     * 
     * @param verwaltung
     * @return 
     */
    public Vector<Abonnement> getAllNutzerAbonnement (SocialMediaLogicImpl verwaltung);

}

