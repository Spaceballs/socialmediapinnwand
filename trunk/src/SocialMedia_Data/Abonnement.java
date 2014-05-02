package SocialMedia_Data;

import SocialMedia_Logic.SocialMediaLogicImpl;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.C6C8C8C1-C1A1-6C43-5A79-24AB722E73B1]
// </editor-fold> 
/**
 * 
 * @author Sebastian
 */
public interface Abonnement extends DataReference {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CA1B5D3A-569F-7542-04E9-B473D20FF13A]
    // </editor-fold> 
    /**
     * 
     * @return 
     */
    public int getPinnwandID ();

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CEE0B0A3-45CB-A3FE-D990-AF2358894EC7]
    // </editor-fold> 
    /**
     * 
     * @param val 
     */
    public void setPinnwandID (int val);

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C6252FA8-05D7-5CCB-DA2B-1A0531F2BF0E]
    // </editor-fold> 
    /**
     * 
     * @return 
     */
    public int getNutzerID ();

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3EAF494D-794D-E648-FA6B-1504A7AF2165]
    // </editor-fold> 
    /**
     * 
     * @param val 
     */
    public void setNutzerID (int val);

    /**
     * 
     * @param verwaltung
     * @return 
     */
    public Pinnwand getAbonnementPinnwand (SocialMediaLogicImpl verwaltung);
}

