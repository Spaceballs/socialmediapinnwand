package SocialMedia_Report;

import java.rmi.RemoteException;
import java.util.Vector;

/**
 * Implementation of a CompositeParagraph which consists of multiple SimpleParagraphs
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.7A43FD0E-22AA-EF61-FB63-B7C114E4BC77]
// </editor-fold> 
public class CompositeParagraphImpl extends ParagraphImpl implements CompositeParagraph{
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.87D0B57D-45F2-5E22-5E73-36AFA8B9750D]
    // </editor-fold>
    Vector<SimpleParagraph> subParagraphs = new Vector<SimpleParagraph>();
    
    /**
     * Constructor of the CompositeParagraphImpl class
     * @throws RemoteException 
     */
    public CompositeParagraphImpl () throws RemoteException{
        super();  
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0CE94AB8-9BE1-F8E2-751E-988FE0CCBF25]
    // </editor-fold>
    /**
     * Adds a SubParagraph to the Vector
     * @param val - a SimpleParagraph
     * @throws RemoteException 
     */
    public void addSubParagraph (SimpleParagraph val)  
            throws RemoteException{
        this.subParagraphs.addElement(val);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B5A911C6-E30F-7EAB-9C57-EB771B79A18D]
    // </editor-fold>
    /**
     * Removes a SubParagraph from the Vector
     * @param val - the SimpleParagraph
     * @throws RemoteException 
     */
    public void removeSubParagraph (SimpleParagraph val)  
            throws RemoteException{
        this.subParagraphs.removeElement(val);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6F1B87C7-E2C1-670A-66BF-6159316B9B7C]
    // </editor-fold>
    /**
     * Returns a SubParagraph from the Vector
     * @return a Paragraph
     * @throws RemoteException 
     */
    public Vector<SimpleParagraph> getSubParagraphs ()  
            throws RemoteException{
        return this.subParagraphs;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.89857C9B-A999-118C-4653-13E24410EF71]
    // </editor-fold>
    /**
     * Gets the number of Paragraphs in the Vector
     * @return Number of Paragraphs as Integer
     * @throws RemoteException 
     */
    public int getNumParagraphs ()  
            throws RemoteException{
        return this.subParagraphs.size();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.95B6DA7A-0ABF-1FA7-DD49-1108B989CC18]
    // </editor-fold>
    /**
     * Gets the Paragraph at a certain index
     * @param val - the index
     * @return - a Paragraph
     * @throws RemoteException 
     */
    public SimpleParagraph getParagraphAt (int val) 
            throws RemoteException {
        return this.subParagraphs.elementAt(val);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.647D8A4E-7C3A-4CB2-9C69-9705DE65AF52]
    // </editor-fold>
    /**
     * Converts the Paragraphs into Strings
     * @return Paragraphs as Strings
     * @throws RemoteException 
     */
    public String toStrings () 
            throws RemoteException{
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < subParagraphs.size(); i++) {
            SimpleParagraph simpleParagraph = subParagraphs.elementAt(i);
            buffer.append(simpleParagraph.toStrings());
            buffer.append(" %br ");
        }
	return buffer.toString();
    }
}

