package SocialMedia_Report;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.Vector;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.327FB869-2B98-9C14-B7F3-E4CCB7B95F64]
// </editor-fold> 
/**
 * Implementation class of a Report
 * @author Sebastian
 */
public class ReportImpl extends java.rmi.server.UnicastRemoteObject implements Report{
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.DD0CA414-A7D3-3EE0-28C4-6DDA3EBB3A5F]
    // </editor-fold> 
    private Date creationDate = new Date();
    private Date startDate = null;
    private Date endDate = null;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6C37A6A4-26A4-83AC-CC6C-E9599681DD35]
    // </editor-fold> 
    private Vector<Row> rows = new Vector<Row>();
    private Paragraph headerAndTitleParagraph = null;
    private Paragraph bodyParagraph = null;
    private Paragraph imprintParagraph = null;
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3A56DCBA-88E9-DEDF-0689-5B42C1C3471E]
    // </editor-fold> 
    /**
     * Constructor of the class
     * @throws java.rmi.RemoteException
     */
    public ReportImpl () 
            throws RemoteException{
        super();
    }

    /**
     * Getter for the creationDate
     * @return the creationDate of the Report
     */
    @Override
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Setter for the creationDate
     * @param creationDate of the Report
     */
    @Override
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * getter for the startDate
     * @return the startDate of the Report
     */
    @Override
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Setter of the startDate
     * @param startDate of the Report
     */
    @Override
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Getter for the endDate
     * @return endDate of the Report
     */
    @Override
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Setter for the endDate
     * @param endDate of the Report
     */
    @Override
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Getter for Rows
     * @return Vector of Rows
     */
    @Override
    public Vector<Row> getRows() {
        return rows;
    }

    /**
     * Setter for Rows
     * @param rows - a Vector of Rows
     */
    @Override
    public void setRows(Vector<Row> rows) {
        this.rows = rows;
    }

    /**
     * Getter for the Header and TitleParagraph
     * @return the headerAndTitleParagraph
     */
    @Override
    public Paragraph getHeaderAndTitleParagraph() {
        return headerAndTitleParagraph;
    }

    /**
     * Setter for the Header and TitleParagraph
     * @param headerAndTitleParagraph - a Paragraph
     */
    @Override
    public void setHeaderAndTitleParagraph(Paragraph headerAndTitleParagraph) {
        this.headerAndTitleParagraph = headerAndTitleParagraph;
    }

    /**
     * Getter for the BodyParagraph
     * @return a bodyParagraph
     */
    @Override
    public Paragraph getBodyParagraph() {
        return bodyParagraph;
    }

    /**
     * Setter for the BodyParagraph
     * @param bodyParagraph - a Paragraph
     */
    @Override
    public void setBodyParagraph(Paragraph bodyParagraph) {
        this.bodyParagraph = bodyParagraph;
    }

    /**
     * Getter for the ImprintParagraph
     * @return imprintParagraph
     */
    @Override
    public Paragraph getImprintParagraph() {
        return imprintParagraph;
    }

    /**
     * Setter for the ImprintParagraph
     * @param imprintParagraph - a Paragraph
     */
    @Override
    public void setImprintParagraph(Paragraph imprintParagraph) {
        this.imprintParagraph = imprintParagraph;
    }
    
}

