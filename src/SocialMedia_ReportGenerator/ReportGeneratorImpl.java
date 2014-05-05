package SocialMedia_ReportGenerator;

import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic; 
import java.util.Date;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.E7C2C07C-F969-9A30-C188-C220A1AD2C41]
// </editor-fold> 
/**
 * Generator class which creates the Reports in the given manner.
 * 
 * @author Sebastian
 */
public class ReportGeneratorImpl implements ReportGenerator {

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
     */
    public ReportGeneratorImpl (SocialMediaLogic val) {
        socialMediaLogic = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.975F3159-35F0-CCCD-CB7B-ACA6F8F16C17]
    // </editor-fold> 
    /**
     * ContributionOfNutzer
     * 
     * 
     * @param nutzerVal - Defines the user over which should be reported.
     * @param sortByVal - 
     * @param startDateVal - Start Date of the timespan.
     * @param endDateVal - End Date of the timespan.
     * @return ContributionOfNutzer - Returns created the Report object.
     */
    public ContributionOfNutzer createContributionOfNutzerReport (Nutzer nutzerVal, int sortByVal, Date startDateVal, Date endDateVal) {
        ContributionOfNutzer report = new ContributionOfNutzer();
        
        // TO-DO: Report code
        // TO-DO: Report code
        // TO-DO: Report code
        
        report.setCreationDate(new Date());
        report.setReportTitle(("Report über die Aktivität des Nutzers: " + nutzerVal.getUsername() + " zwischen dem " + startDateVal + " und dem " + endDateVal));
        
        return report;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A085AD62-913F-0C59-690A-A589531FAEA9]
    // </editor-fold> 
    /**
     * Method to create the PopularityOfBeitrag-Report by the given criteria.
     * 
     * 
     * @param sortByVal - 
     * @param startDateVal - Start Date of the timespan.
     * @param endDateVal - End Date of the timespan.
     * @return PopularityOfBeitrag - Returns created the Report object.
     */
    public PopularityOfBeitrag createPopularityOfBeitragReport (int sortByVal, Date startDateVal, Date endDateVal) {
        PopularityOfBeitrag report = new PopularityOfBeitrag();
        
        // TO-DO: Report code
        // TO-DO: Report code
        // TO-DO: Report code
        
        report.setCreationDate(new Date());
        report.setReportTitle(("Report über die Popularität von Beiträgen zwischen dem " + startDateVal + " und dem " + endDateVal));
        
        return report;
    }
}

