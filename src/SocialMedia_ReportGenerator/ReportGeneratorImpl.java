package SocialMedia_ReportGenerator;

import SocialMedia_Data.Beitrag;
import SocialMedia_Data.Kommentar;
import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic; 
import SocialMedia_Report.Column;
import SocialMedia_Report.ColumnImpl;
import SocialMedia_Report.CompositeParagraph;
import SocialMedia_Report.CompositeParagraphImpl;
import SocialMedia_Report.ContributionOfNutzer;
import SocialMedia_Report.ContributionOfNutzerImpl;
import SocialMedia_Report.PopularityOfBeitrag;
import SocialMedia_Report.PopularityOfBeitragImpl;
import SocialMedia_Report.Row;
import SocialMedia_Report.RowImpl;
import SocialMedia_Report.SimpleParagraphImpl;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.E7C2C07C-F969-9A30-C188-C220A1AD2C41]
// </editor-fold> 
/**
 * Generator class which creates the Reports in the given manner.
 * 
 * @author Sebastian
 */
public class ReportGeneratorImpl 
    extends java.rmi.server.UnicastRemoteObject 
    implements ReportGenerator {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5F731C06-B576-8C5F-7EB5-3ED06DFC5D1B]
    // </editor-fold> 
    private SocialMediaLogic socialMediaLogic = null;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.657F1B43-DFBC-7C21-6CDC-195ADE1929AA]
    // </editor-fold> 
    /**
     * Constructor of the ReportGeneratorImpl class.
     * This constructor will be called once when the server logic is started.
     * Each Server has his own ReportGenerator.
     * 
     * @param val - SocialMediaLogic will be needed to get some data for the reports.
     * @throws java.rmi.RemoteException
     */
    public ReportGeneratorImpl (SocialMediaLogic val) throws RemoteException {
        socialMediaLogic = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.975F3159-35F0-CCCD-CB7B-ACA6F8F16C17]
    // </editor-fold> 
    /**
     * ContributionOfNutzerImpl
     * 
     * 
     * @param nutzerVal - Defines the user over which should be reported.
     * @param sortByVal - 
     * @param startDateVal - Start Date of the timespan.
     * @param endDateVal - End Date of the timespan.
     * @return ContributionOfNutzerImpl - Returns created the Report object.
     * @throws java.rmi.RemoteException
     */
    public ContributionOfNutzer createContributionOfNutzerReport (Nutzer nutzerVal, int sortByVal, Date startDateVal, Date endDateVal) throws RemoteException {
        ContributionOfNutzer report = new ContributionOfNutzerImpl();
        try {
            report.setCreationDate(new Date());
            report.setHeaderAndTitleParagraph(new SimpleParagraphImpl("Report über die Aktivität des Nutzers: " + nutzerVal.getUsername() + " zwischen dem " + startDateVal + " und dem " + endDateVal));
            report.setBodyParagraph(null);
            
            report.setImprintParagraph(addImprint());
            
            Vector<Beitrag> reportBeitraege = socialMediaLogic.getAllBeitrag();
            for (int i = 0; i < reportBeitraege.size(); i++) {
                if (!socialMediaLogic.ownerCheck(nutzerVal, reportBeitraege.elementAt(i)))
                    reportBeitraege.removeElementAt(i);
            }
            
            Vector<Kommentar> reportKommentare = socialMediaLogic.getAllKommentar();
            for (int i = 0; i < reportKommentare.size(); i++) {
                if (!socialMediaLogic.ownerCheck(nutzerVal, reportKommentare.elementAt(i)))
                    reportKommentare.removeElementAt(i);
            }
            Vector<Object> sammlung = new Vector<Object>();

            Column column = new ColumnImpl();
            column.addSubParagraph(new SimpleParagraphImpl("TEST"));
            column.addSubParagraph(new SimpleParagraphImpl("TEST"));
            Row row = new RowImpl();
            row.addColumn(column);
            Vector<Row> rows = new Vector<Row>();
            rows.add(row);
            report.setRows(rows);
            
        } catch (RemoteException ex) {
            Logger.getLogger(ReportGeneratorImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return report;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A085AD62-913F-0C59-690A-A589531FAEA9]
    // </editor-fold> 
    /**
     * Method to create the PopularityOfBeitragImpl-Report by the given criteria.
     * 
     * 
     * @param sortByVal - 
     * @param startDateVal - Start Date of the timespan.
     * @param endDateVal - End Date of the timespan.
     * @return PopularityOfBeitragImpl - Returns created the Report object.
     * @throws java.rmi.RemoteException
     */
    public PopularityOfBeitrag createPopularityOfBeitragReport (int sortByVal, Date startDateVal, Date endDateVal) throws RemoteException {
        PopularityOfBeitrag report = new PopularityOfBeitragImpl();
        return report;
    }
    
    /**
     * Helper method for the report generation.
     * 
     * @param b - The Beitrag which should be written into the report.
     * @return Returns the column entry for the report.
     * @throws RemoteException 
     */
    private Column writeBeitrag(Beitrag b) throws RemoteException{
        Column column = new ColumnImpl();
        column.addSubParagraph(new SimpleParagraphImpl("User: " + socialMediaLogic.getNutzerOf(b)));
        column.addSubParagraph(new SimpleParagraphImpl(b.getCreationDate().toString()));
        column.addSubParagraph(new SimpleParagraphImpl(b.getText()));
        column.addSubParagraph(new SimpleParagraphImpl("Likes: " + socialMediaLogic.getAllLikeOfBeitrag(b).size()));
        return column;
    }
    
    /**
     * Helper method for the report generation.
     * 
     * @param k - The Kommentar which should be written into the report.
     * @return Returns the column entry for the report.
     * @throws RemoteException 
     */    
    private Column writeKommentar(Kommentar k) throws RemoteException{
        Column column = new ColumnImpl();
        column.addSubParagraph(new SimpleParagraphImpl("User: " + socialMediaLogic.getNutzerOf(k)));
        column.addSubParagraph(new SimpleParagraphImpl(k.getCreationDate().toString()));
        column.addSubParagraph(new SimpleParagraphImpl(k.getText()));
        return column;
    }

    /**
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

