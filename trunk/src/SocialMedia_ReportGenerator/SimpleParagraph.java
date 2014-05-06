package SocialMedia_ReportGenerator;


/**
 *  Diese Klasse stellt einzelne Absätze dar. Der Absatzinhalt wird als String
 *   gespeichert. Der Anwender sollte in diesem Strinig keinerlei Formatierungssymbole
 *   einfügen, da diese in der Regel zielformatspezifisch sind.
 *   
 *   @author Thies
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.0BCEFED5-709C-C881-F6DE-BEC6977B5E59]
// </editor-fold> 
public class SimpleParagraph extends Paragraph{

    /**
     *  Inhalt des Absatzes.
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F53CDAB6-019F-C91C-45C5-EC1F1804E748]
    // </editor-fold> 
    private String text = "";





    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5E408F32-89DC-3A7C-71A4-820980F3252C]
    // </editor-fold>
    /**
     *  Dieser Konstruktor ermöglicht es, bereits bei Instantiierung von
     *  	 <code>SimpleParagraph</code>-Objekten deren Inhalt angeben zu können.
     *
     *  	 @param value der Inhalt des Absatzes
     */
    public SimpleParagraph (String val) {
        this.text = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.ABD5A780-991F-8EB7-9901-2929A1CBA75D]
    // </editor-fold>
    /**
     *
     * @return
     */
    public String getText () {
        return text;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D0033BDC-E2EA-54A4-4419-6C910255DDE4]
    // </editor-fold>
    /**
     *
     * @param val
     */
    public void setText (String val) {
        this.text = val;
    }

    /**
     *  Umwandeln des <code>SimpleParagraph</code>-Objekts in einen String.
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.193B4D3C-F228-B112-FBD8-4CE55F239E30]
    // </editor-fold>
    /**
     *
     * @return
     */
    @Override
    public String toString () {
        return this.text;
    }

}

