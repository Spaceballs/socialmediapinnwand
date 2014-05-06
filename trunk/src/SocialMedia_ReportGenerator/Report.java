package SocialMedia_ReportGenerator;

import java.util.Date;
import java.util.Vector;

 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.327FB869-2B98-9C14-B7F3-E4CCB7B95F64]
// </editor-fold> 
public class Report {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C01546F6-1230-9D1A-E8B7-1C6BA18AA572]
    // </editor-fold> 
    private String reportTitle = "Report";

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.DD0CA414-A7D3-3EE0-28C4-6DDA3EBB3A5F]
    // </editor-fold> 
    private Date creationDate = new Date();

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6C37A6A4-26A4-83AC-CC6C-E9599681DD35]
    // </editor-fold> 
    private Vector<Row> sRows = null;

    private Vector<Paragraph> mParagraphs = null;

    public Vector<Paragraph> getmParagraphs() {
        return mParagraphs;
    }

    public void setmParagraphs(Vector<Paragraph> mParagraphs) {
        this.mParagraphs = mParagraphs;
    }
    public void setmParagraph(Paragraph mParagraph) {
        mParagraphs.add(mParagraph);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.337EFAD5-50E8-9171-8E9E-33811BD3CE75]
    // </editor-fold> 
    //private mheader;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5E37A5B1-9B94-6FA0-A4F3-C5A45C504909]
    // </editor-fold> 
    //private mImprint;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3A56DCBA-88E9-DEDF-0689-5B42C1C3471E]
    // </editor-fold> 
    public Report () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.736AE163-DD52-AE45-73DA-F720D296BEBF]
    // </editor-fold> 
    public Date getCreationDate () {
        return creationDate;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.DF9B67FA-09D6-BC6D-AFAD-6C11C9D79470]
    // </editor-fold> 
    public void setCreationDate (Date val) {
        this.creationDate = val;
    }
/**
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E7F13085-F143-4E05-9F5C-77EB225D1BC1]
    // </editor-fold> 
    public getMheader () {
        return mheader;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.9E97DF53-997D-C999-C17B-9F50ADDF2DBE]
    // </editor-fold> 
    public void setMheader ( val) {
        this.mheader = val;
    }
 */

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.71D76669-894D-09DE-8726-1490EAAF6F4C]
    // </editor-fold> 
    public String getReportTitle () {
        return reportTitle;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.2825BBE1-A6B3-F481-3693-EE16A3B47B0C]
    // </editor-fold> 
    public void setReportTitle (String val) {
        this.reportTitle = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.88FBC6E4-CD3B-4E19-1904-6B13A7DF387D]
    // </editor-fold> 
    public void addRow (Row val) {
        sRows.add(val);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6B817044-83CA-F739-4038-CAB9BC5D19F9]
    // </editor-fold> 
    public void removeRow (Row val) {
        sRows.remove(val);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C4845CAD-6489-79E9-8793-09FBE313D345]
    // </editor-fold> 
    public Vector<Row> getAllRows () {
        return sRows;
    }
/**
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.8A555855-D915-27CF-8EFA-94450C4A9DFD]
    // </editor-fold> 
    public getImprint () {
        return mImprint;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.7D60DA78-85B4-CAF0-46E8-F8D6827EF05A]
    // </editor-fold> 
    public void setImprint ( val) {
        this.mImprint = val;
    }
 */

}

