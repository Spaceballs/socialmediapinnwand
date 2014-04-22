package SocialMedia_ReportGenerator;

import java.util.Vector;


/**
 *  Diese Klasse stellt eine Menge einzelner Absätze 
 *   (<code>SimpleParagraph</code>-Objekte) dar. Diese werden als Unterabschnitte
 *   in einem <code>Vector</code> abgelegt verwaltet.
 *   
 *   @author Thies
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.7A43FD0E-22AA-EF61-FB63-B7C114E4BC77]
// </editor-fold> 
public class CompositeParagraph extends Paragraph{

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.87D0B57D-45F2-5E22-5E73-36AFA8B9750D]
    // </editor-fold> 
    private Vector<SimpleParagraph> subParagraphs = new Vector<SimpleParagraph>();

    /**
     *  Einen Unterabschnitt hinzufügen.
     *  	 
     *  	 @param p der hinzuzufügende Unterabschnitt.
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0CE94AB8-9BE1-F8E2-751E-988FE0CCBF25]
    // </editor-fold> 
    public void addSubParagraph (SimpleParagraph val) {
        this.subParagraphs.addElement(val);
    }

    /**
     *  Einen Unterabschnitt entfernen.
     *  	 
     *  	 @param p der zu entfernende Unterabschnitt.
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B5A911C6-E30F-7EAB-9C57-EB771B79A18D]
    // </editor-fold> 
    public void removeSubParagraph (SimpleParagraph val) {
        this.subParagraphs.removeElement(val);
    }

    /**
     *  Auslesen sämtlicher Unterabschnitte.
     *  	 
     *  	 @return <code>Vector</code>, der sämtliche Unterabschnitte enthält.
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6F1B87C7-E2C1-670A-66BF-6159316B9B7C]
    // </editor-fold> 
    public Vector<SimpleParagraph> getSubParagraphs () {
        return this.subParagraphs;
    }

    /**
     *  Auslesen der Anzahl der Unterabschnitte.
     *  	 
     *  	 @return int Anzahl der Unterabschnitte
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.89857C9B-A999-118C-4653-13E24410EF71]
    // </editor-fold> 
    public int getNumParagraphs () {
        return this.subParagraphs.size();
    }

    /**
     *  Auslesen eines einzelnen Unterabschnitts.
     *  	 
     *  	 @param i der Index des gewünschten Unterabschnitts (0 <= i <n), mit n = 
     *  	 Anzahl der Unterabschnitte.
     *  	 
     *  	 @return der gewünschte Unterabschnitt.
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.95B6DA7A-0ABF-1FA7-DD49-1108B989CC18]
    // </editor-fold> 
    public SimpleParagraph getParagraphAt (int val) {
        return this.subParagraphs.elementAt(val);
    }

    /**
     *  Umwandeln eines <code>CompositeParagraph</code> in einen String.
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.647D8A4E-7C3A-4CB2-9C69-9705DE65AF52]
    // </editor-fold> 
    public String toString () {
        	// Leerer Buffer anlegen
		StringBuffer result = new StringBuffer();
        	// Schleife über alle Unterabseätze
		for ( int i = 0; i < this.subParagraphs.size(); i++ ) {
			SimpleParagraph p = this.subParagraphs.elementAt(i);
			// den entsprechenden Unterabsatz in einen String wandeln und an den Buffer übergeben.
			result.append(p.toString() + "\n");
		}
		// In String umgewandeltes ergebniss ausgeben
		return result.toString();
    }
}

