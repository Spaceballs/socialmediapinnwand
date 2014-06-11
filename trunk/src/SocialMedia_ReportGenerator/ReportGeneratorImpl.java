package SocialMedia_ReportGenerator;

import SocialMedia_Data.Beitrag;
import SocialMedia_Data.Kommentar;
import SocialMedia_Data.Like;
import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogicImpl;
import SocialMedia_Report.Column;
import SocialMedia_Report.ColumnImpl;
import SocialMedia_Report.CompositeParagraph;
import SocialMedia_Report.CompositeParagraphImpl;
import SocialMedia_Report.ContributionOfNutzer;
import SocialMedia_Report.ContributionOfNutzerImpl;
import SocialMedia_Report.PopularityOfBeitrag;
import SocialMedia_Report.PopularityOfBeitragImpl;
import SocialMedia_Report.Report;
import SocialMedia_Report.Row;
import SocialMedia_Report.RowImpl;
import SocialMedia_Report.SimpleParagraphImpl;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.E7C2C07C-F969-9A30-C188-C220A1AD2C41]
// </editor-fold> 
/**
 * Generator class which creates the <code>Report</code>-Object in the given manner.
 * 
 * @author Sebastian
 */
public class ReportGeneratorImpl 
    extends java.rmi.server.UnicastRemoteObject 
    implements ReportGenerator {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5F731C06-B576-8C5F-7EB5-3ED06DFC5D1B]
    // </editor-fold> 
    private SocialMediaLogicImpl socialMediaLogic = null;
    private final SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy | HH.mm", Locale.GERMANY);

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.657F1B43-DFBC-7C21-6CDC-195ADE1929AA]
    // </editor-fold> 
    /**
     * Constructor of the <code>ReportGeneratorImpl</code> class.
     * This constructor will be called once when the server logic is started.
     * Each Server has its own <code>ReportGenerator</code>.
     * 
     * @param val - <code>SocialMediaLogic</code> will be needed to get some data for the reports.
     * @throws java.rmi.RemoteException
     */
    public ReportGeneratorImpl (SocialMediaLogicImpl val) throws RemoteException {
        socialMediaLogic = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.975F3159-35F0-CCCD-CB7B-ACA6F8F16C17]
    // </editor-fold> 
    /**
     * Method to create the <code>ContributionOfNutzerImpl</code>-Report by the given criteria.
     * 
     * @param nutzerVal - Defines the user over which should be reported.
     * @param sortByVal - sorts the <code>Nutzer</code> by most <code>Beitrag</code>, most Like get or most <code>Abonnement</code> in a specific timespan.
     * @param startDateVal - Start Date of the timespan.
     * @param endDateVal - End Date of the timespan.
     * @return ContributionOfNutzerImpl - Returns created the Report object.
     * @throws java.rmi.RemoteException
     */
    public Report createContributionOfNutzerReport (Nutzer nutzerVal, int sortByVal, Date startDateVal, Date endDateVal) throws RemoteException {
        
        Logger.getLogger(this.getClass().getName()).info("nutzerVal " + nutzerVal);
        Logger.getLogger(this.getClass().getName()).info("sortByVal " + sortByVal);
        Logger.getLogger(this.getClass().getName()).info("startDateVal " + startDateVal);
        Logger.getLogger(this.getClass().getName()).info("endDateVal " + endDateVal);
        ContributionOfNutzer report = new ContributionOfNutzerImpl();
        
        //@todo createContributionOfNutzerReport// Welcher nutzer hat die meisten beiträge gemacht? meiste likes erhalten? meisten abonnenten? in einem zeitraum?
        
        report.setCreationDate(new Date());
        report.setStartDate(startDateVal);
        report.setEndDate(endDateVal);
        report.setHeaderAndTitleParagraph(new SimpleParagraphImpl("Nutzer Popularitäts-/Aktivitäts Report"));
        if (nutzerVal != null){
            report.setBodyParagraph(new SimpleParagraphImpl("Report über die Aktivität des Nutzers: " + nutzerVal.getUsername() + " zwischen dem " + startDateVal + " und dem " + endDateVal));
        } else {
            report.setBodyParagraph(new SimpleParagraphImpl("Report zwischen dem " + startDateVal + " und dem " + endDateVal));
        }
        
        

//        Vector<Beitrag> reportBeitraege = socialMediaLogic.getAllBeitrag();
//        for (int i = 0; i < reportBeitraege.size(); i++) {
//            if (!socialMediaLogic.ownerCheck(nutzerVal, reportBeitraege.elementAt(i)))
//                reportBeitraege.removeElementAt(i);
//        }
//
//        Vector<Kommentar> reportKommentare = socialMediaLogic.getAllKommentar();
//        for (int i = 0; i < reportKommentare.size(); i++) {
//            if (!socialMediaLogic.ownerCheck(nutzerVal, reportKommentare.elementAt(i)))
//                reportKommentare.removeElementAt(i);
//        }
//        Vector<Object> sammlung = new Vector<Object>();

        Column column = new ColumnImpl();
        Row row = new RowImpl();
        column.addSubParagraph(new SimpleParagraphImpl("Das ist die"));
        column.addSubParagraph(new SimpleParagraphImpl("oberste zeile"));
        column.addSubParagraph(new SimpleParagraphImpl("in der ersten Spalte"));
        row.addColumn(column);
        column = new ColumnImpl();
        column.addSubParagraph(new SimpleParagraphImpl("Das ist die"));
        column.addSubParagraph(new SimpleParagraphImpl("oberste zeile"));
        column.addSubParagraph(new SimpleParagraphImpl("in der zweiten Spalte"));
        row.addColumn(column);
        column = new ColumnImpl();
        column.addSubParagraph(new SimpleParagraphImpl("Das ist die"));
        column.addSubParagraph(new SimpleParagraphImpl("oberste zeile"));
        column.addSubParagraph(new SimpleParagraphImpl("in der dritten Spalte"));
        row.addColumn(column);
        Vector<Row> rows = new Vector<Row>();
        rows.add(row);

        column = new ColumnImpl();
        row = new RowImpl();
        column.addSubParagraph(new SimpleParagraphImpl("TEST10"));
        column.addSubParagraph(new SimpleParagraphImpl("TEST11"));
        column.addSubParagraph(new SimpleParagraphImpl("TEST12"));
        row.addColumn(column);
        row.addColumn(column);
        row.addColumn(column);
        rows.add(row);

        column = new ColumnImpl();
        row = new RowImpl();
        column.addSubParagraph(new SimpleParagraphImpl("TEST20"));
        column.addSubParagraph(new SimpleParagraphImpl("TEST21"));
        column.addSubParagraph(new SimpleParagraphImpl("TEST22"));
        row.addColumn(column);
        row.addColumn(column);
        row.addColumn(column);
        rows.add(row);            

        report.setRows(rows);

        report.setImprintParagraph(addImprint());
        return report;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A085AD62-913F-0C59-690A-A589531FAEA9]
    // </editor-fold> 
    /**
     * Method to create the <code>PopularityOfBeitragImpl</code>-Report by the given criteria.
     * 
     * 
     * @param sortByVal - sorts the List of <code>Beitrag</code> by most </code>Like</code> or most </code>Kommentar</code> in a specific timespan.
     * @param startDateVal - Start Date of the timespan.
     * @param endDateVal - End Date of the timespan.
     * @return PopularityOfBeitragImpl - Returns created the Report object.
     * @throws java.rmi.RemoteException
     */
    public Report createPopularityOfBeitragReport (int sortByVal, Date startDateVal, Date endDateVal) throws RemoteException {
        PopularityOfBeitrag report = new PopularityOfBeitragImpl();
        
        report.setCreationDate(new Date());
        report.setStartDate(startDateVal);
        report.setEndDate(endDateVal);
        report.setHeaderAndTitleParagraph(new SimpleParagraphImpl("Beitrag Popularitäts-Report"));
        report.setBodyParagraph(new SimpleParagraphImpl("Report über die Popularität der Beiträge zwischen dem " + df.format(startDateVal) + " und dem " + df.format(endDateVal)));
        
        Vector<Beitrag> beitraege = socialMediaLogic.getAllBeitrag();
        Vector<Beitrag> beitraege2 = new Vector<Beitrag>();
        for (int i = 0; i < beitraege.size(); i++) {
            if (!startDateVal.after(beitraege.elementAt(i).getCreationDate()) && !endDateVal.before(beitraege.elementAt(i).getCreationDate()))
                beitraege2.add(beitraege.elementAt(i));
        }
        beitraege = beitraege2;
        /**
         * Wenn die Beiträge im Report nach menge der Kommentare sortiert werden soll dann den entsprechenden Sortieralgorythmus anwerfen.
         * Ansonsten soll der Report nach menge der Likes sortiert werden.
         */
        if (sortByVal == 1){
            Collections.sort(beitraege, new Comparator<Beitrag>() {
                public int compare(Beitrag o1, Beitrag o2){
                    try {
                        return ((Integer)socialMediaLogic.getAllKommentarOfBeitrag(o2).size()).compareTo((Integer)socialMediaLogic.getAllKommentarOfBeitrag(o1).size());
                    } catch (RemoteException ex) {
                        Logger.getLogger(ReportGeneratorImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return -1;
                }
            });  
        }else if (sortByVal == 0){
            Collections.sort(beitraege, new Comparator<Beitrag>() {
                public int compare(Beitrag o1, Beitrag o2){
                    try {
                        return ((Integer)socialMediaLogic.getAllLikeOfBeitrag(o2).size()).compareTo((Integer)socialMediaLogic.getAllLikeOfBeitrag(o1).size());
                    } catch (RemoteException ex) {
                        Logger.getLogger(ReportGeneratorImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return -1;
                }
            });
        }
        
        /**
         * Schleife über alle Beiträge.
         */
        Vector<Row> rows = new Vector<Row>();
        for (int i = 0; i < beitraege.size(); i++) {
            Column beitragColumn;
            Beitrag beitrag = beitraege.get(i);
            Vector<Like> likes = socialMediaLogic.getAllLikeOfBeitrag(beitrag);
            Vector<Kommentar> kommentare = socialMediaLogic.getAllKommentarOfBeitrag(beitrag);
            int laufindex = (likes.size() > kommentare.size()) ?  likes.size() : kommentare.size();
            Logger.getLogger(this.getClass().getName()).info(" Laufindex: " + laufindex);
            Logger.getLogger(this.getClass().getName()).info(" Laufindex: " + likes.size());
            Logger.getLogger(this.getClass().getName()).info(" Laufindex: " + kommentare.size());
            
            if (sortByVal==1){
                /**
                 * Wenn erste Zeile dann TableHeader schreiben.
                 */
                if (i==0){
                    Column c = new ColumnImpl();
                    Row r = new RowImpl();
                    c.addSubParagraph(new SimpleParagraphImpl("Beiträge"));
                    c.addSubParagraph(new SimpleParagraphImpl(df.format(startDateVal) + " - " + df.format(endDateVal)));
                    r.addColumn(c);
                    c = new ColumnImpl();
                    c.addSubParagraph(new SimpleParagraphImpl("Kommentare"));
                    c.addSubParagraph(new SimpleParagraphImpl("sort By Value"));
                    r.addColumn(c);
                    c = new ColumnImpl();
                    c.addSubParagraph(new SimpleParagraphImpl("Likes"));
                    r.addColumn(c);
                    rows.add(r);
                }
                beitragColumn = writeBeitrag(beitrag);
                /**
                 * Schleife über alle Likes oder Kommentare, wovon mehr da ist.
                 * Wenn nix da ist dann leere Zeile erzeugen
                 */
                for (int counter = 0; counter < laufindex; counter++){
                    Row r0 = new RowImpl();
                    Column c = new ColumnImpl();
                    if (counter == 0){
                        r0.addColumn(beitragColumn);
                    } else {
                        c.addSubParagraph(new SimpleParagraphImpl(""));
                        r0.addColumn(c);
                    }
                    try{
                        r0.addColumn(writeKommentar(kommentare.elementAt(counter)));
                    } catch (IndexOutOfBoundsException ex){
                        c = new ColumnImpl();
                        c.addSubParagraph(new SimpleParagraphImpl(""));
                        r0.addColumn(c);
                    }
                    try{
                        r0.addColumn(writeLike(likes.elementAt(counter)));
                    } catch (IndexOutOfBoundsException ex){
                        c = new ColumnImpl();
                        c.addSubParagraph(new SimpleParagraphImpl(""));
                        r0.addColumn(c);
                    }
                    rows.add(r0);
                }
            }else if(sortByVal==0){
            /**
             * Wenn erste Zeile dann TableHeader schreiben.
             */
                if (i==0){
                    Column c = new ColumnImpl();
                    Row r = new RowImpl();
                    c.addSubParagraph(new SimpleParagraphImpl("Beiträge"));
                    c.addSubParagraph(new SimpleParagraphImpl(df.format(startDateVal) + " - " + df.format(endDateVal)));
                    r.addColumn(c);
                    c = new ColumnImpl();
                    c.addSubParagraph(new SimpleParagraphImpl("Likes"));
                    c.addSubParagraph(new SimpleParagraphImpl("sort By Value"));
                    r.addColumn(c);
                    c = new ColumnImpl();
                    c.addSubParagraph(new SimpleParagraphImpl("Kommentare"));
                    r.addColumn(c);
                    rows.add(r);
                }
                beitragColumn = writeBeitrag(beitrag);
                /**
                 * Schleife über alle Likes oder Kommentare, wovon mehr da ist.
                 * Wenn nix da ist dann leere Zeile erzeugen
                 */
                for (int counter = 0; counter < laufindex; counter++){
                    Row r0 = new RowImpl();
                    Column c = new ColumnImpl();
                    if (counter == 0){
                        r0.addColumn(beitragColumn);
                    } else {
                        c.addSubParagraph(new SimpleParagraphImpl(""));
                        r0.addColumn(c);
                    }
                    try{
                        r0.addColumn(writeLike(likes.elementAt(counter)));
                    } catch (IndexOutOfBoundsException ex){
                        c = new ColumnImpl();
                        c.addSubParagraph(new SimpleParagraphImpl(""));
                        r0.addColumn(c);
                    }
                    try{
                        r0.addColumn(writeKommentar(kommentare.elementAt(counter)));
                    } catch (IndexOutOfBoundsException ex){
                        c = new ColumnImpl();
                        c.addSubParagraph(new SimpleParagraphImpl(""));
                        r0.addColumn(c);
                    }
                    rows.add(r0);
                }
            }
            report.setRows(rows);
        }
        report.setImprintParagraph(addImprint());
        //createPopularityOfBeitragReport//Beiträge mit den meisten Likes, Kommentaren in einem Zeitraum
        return report;
    }
    
    /**
     * Helper method for the report generation. Transforms a <code>Nutzer</code> into an <code>Column</code>.
     * 
     * @param n - The <code>Nutzer</code> which should be written into the report.
     * @return Returns the <code>Column</code> entry for the report.
     * @throws RemoteException 
     */
    private Column writeNutzer(Nutzer n) throws RemoteException{
        Column column = new ColumnImpl();
        column.addSubParagraph(new SimpleParagraphImpl("User: " + n.getName() + ", " + n.getSurname()));
        column.addSubParagraph(new SimpleParagraphImpl("alias " + n.getUsername()));
        return column;
    }
    
    /**
     * Helper method for the report generation. Transforms a <code>Beitrag</code> into an <code>Column</code>.
     * 
     * @param b - The <code>Beitrag</code> which should be written into the report.
     * @return Returns the <code>Column</code> entry for the report.
     * @throws RemoteException 
     */
    private Column writeBeitrag(Beitrag b) throws RemoteException{
        Column column = new ColumnImpl();
        column.addSubParagraph(new SimpleParagraphImpl("User: " + socialMediaLogic.getNutzerOf(b).getUsername()));
        column.addSubParagraph(new SimpleParagraphImpl(df.format(b.getCreationDate())));
        column.addSubParagraph(new SimpleParagraphImpl(b.getText()));
        column.addSubParagraph(new SimpleParagraphImpl("anz. Likes: " + socialMediaLogic.getAllLikeOfBeitrag(b).size() + "\t anz. Kommentare: " + socialMediaLogic.getAllKommentarOfBeitrag(b).size()));
        return column;
    }
    
    /**
     * Helper method for the report generation. Transforms a <code>Kommentar</code> into an <code>Column</code>.
     * 
     * @param k - The <code>Kommentar</code> which should be written into the report.
     * @return Returns the <code>Column</code> entry for the report.
     * @throws RemoteException 
     */    
    private Column writeKommentar(Kommentar k) throws RemoteException{
        Column column = new ColumnImpl();
        column.addSubParagraph(new SimpleParagraphImpl("User: " + socialMediaLogic.getNutzerOf(k).getUsername()));
        column.addSubParagraph(new SimpleParagraphImpl(df.format(k.getCreationDate())));
        column.addSubParagraph(new SimpleParagraphImpl(k.getText()));
        return column;
    }
    
    /**
     * Helper method for the report generation. Transforms a <code>Like</code> into an <code>Column</code>.
     * 
     * @param l - The <code>Like</code> which should be written into the report.
     * @return Returns the <code>Column</code> entry for the report.
     * @throws RemoteException 
     */
    private Column writeLike(Like l) throws RemoteException{
        Column column = new ColumnImpl();
        column.addSubParagraph(new SimpleParagraphImpl("Von " + socialMediaLogic.getNutzerOf(l).getUsername()));
        column.addSubParagraph(new SimpleParagraphImpl(df.format(l.getCreationDate())));
        return column;
    }

    /**
     * Helper method for the report generation. Generates the imprint for the report.
     * 
     * @throws RemoteException 
     */
    private CompositeParagraph addImprint() throws RemoteException {
        CompositeParagraph imprintCompositeParagraph = new CompositeParagraphImpl();
        imprintCompositeParagraph.addSubParagraph(new SimpleParagraphImpl("Dieser Report wird ihnen Präsentiert von: IT3-Team 02"));
        imprintCompositeParagraph.addSubParagraph(new SimpleParagraphImpl("Sebastian Fink"));
        imprintCompositeParagraph.addSubParagraph(new SimpleParagraphImpl("Max Kobald"));
        imprintCompositeParagraph.addSubParagraph(new SimpleParagraphImpl("Benjamin Kiss"));
        imprintCompositeParagraph.addSubParagraph(new SimpleParagraphImpl("Riccardo Antonio Giugno"));
        imprintCompositeParagraph.addSubParagraph(new SimpleParagraphImpl("Leo Christ"));
        imprintCompositeParagraph.addSubParagraph(new SimpleParagraphImpl("Kevin Hüber"));
        return imprintCompositeParagraph;
    }
}

