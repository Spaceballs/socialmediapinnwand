package SocialMedia_Report;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.Vector;

 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.327FB869-2B98-9C14-B7F3-E4CCB7B95F64]
// </editor-fold> 
/**
 * 
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
    private Vector<Row> rows = null;
    private Paragraph headerAndTitleParagraph = null;
    private Paragraph bodyParagraph = null;
    private Paragraph imprintParagraph = null;
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3A56DCBA-88E9-DEDF-0689-5B42C1C3471E]
    // </editor-fold> 
    /**
     * 
     * @throws java.rmi.RemoteException
     */
    public ReportImpl () 
            throws RemoteException{
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public Date getEndDate() {
        return endDate;
    }

    @Override
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public Vector<Row> getRows() {
        return rows;
    }

    @Override
    public void setRows(Vector<Row> rows) {
        this.rows = rows;
    }

    @Override
    public Paragraph getHeaderAndTitleParagraph() {
        return headerAndTitleParagraph;
    }

    @Override
    public void setHeaderAndTitleParagraph(Paragraph headerAndTitleParagraph) {
        this.headerAndTitleParagraph = headerAndTitleParagraph;
    }

    @Override
    public Paragraph getBodyParagraph() {
        return bodyParagraph;
    }

    @Override
    public void setBodyParagraph(Paragraph bodyParagraph) {
        this.bodyParagraph = bodyParagraph;
    }

    @Override
    public Paragraph getImprintParagraph() {
        return imprintParagraph;
    }

    @Override
    public void setImprintParagraph(Paragraph imprintParagraph) {
        this.imprintParagraph = imprintParagraph;
    }
    
}

