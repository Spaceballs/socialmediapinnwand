
package SocialMedia_Report;

import java.rmi.RemoteException;
import java.util.Vector;

/**
 * Interface of a CompositeParagraph which consists of multiple SimpleParagraphs
 * @author Sebastian
 */
public interface CompositeParagraph extends Paragraph{

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.0CE94AB8-9BE1-F8E2-751E-988FE0CCBF25]
    // </editor-fold>

    /**
     * Adds a SubParagraph to the Vector
     * @param val - a SimpleParagraph
     * @throws RemoteException 
     */
    void addSubParagraph(SimpleParagraph val)
        throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.89857C9B-A999-118C-4653-13E24410EF71]
    // </editor-fold>

    /**
     * Gets the number of Paragraphs in the Vector
     * @return Number of Paragraphs as Integer
     * @throws RemoteException 
     */
    int getNumParagraphs()
        throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.95B6DA7A-0ABF-1FA7-DD49-1108B989CC18]
    // </editor-fold>

    /**
     * Gets the Paragraph at a certain index
     * @param val - the index
     * @return - a Paragraph
     * @throws RemoteException 
     */
    SimpleParagraph getParagraphAt(int val)
        throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.6F1B87C7-E2C1-670A-66BF-6159316B9B7C]
    // </editor-fold>

    /**
     * Returns a SubParagraph from the Vector
     * @return a Paragraph
     * @throws RemoteException 
     */
    Vector<SimpleParagraph> getSubParagraphs()
        throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.B5A911C6-E30F-7EAB-9C57-EB771B79A18D]
    // </editor-fold>

    /**
     * Removes a SubParagraph from the Vector
     * @param val - the SimpleParagraph
     * @throws RemoteException 
     */
    void removeSubParagraph(SimpleParagraph val)
        throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.647D8A4E-7C3A-4CB2-9C69-9705DE65AF52]
    // </editor-fold>

    /**
     * Converts the Paragraphs into Strings
     * @return Paragraphs as Strings
     * @throws RemoteException 
     */
    String toStrings()
        throws RemoteException;
    
}
