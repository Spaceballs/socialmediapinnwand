package SocialMedia_ReportGenerator;

import SocialMedia_Report.ContributionOfNutzer;
import SocialMedia_Report.PopularityOfBeitrag;
import SocialMedia_Data.Nutzer;
import java.rmi.RemoteException;
import java.util.Date;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.84C9B6B8-BF8B-9A6C-B1BE-1B6F62D153EC]
// </editor-fold> 
public interface ReportGenerator 
    extends java.rmi.Remote {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B2310D9F-21AE-B8A9-3C32-D6C5593B6BA4]
    // </editor-fold> 
    public ContributionOfNutzer createContributionOfNutzerReport (Nutzer nutzerVal, int sortByVal, Date startDateVal, Date endDateVal)
            throws RemoteException ;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3A50FE9E-9FCC-B62A-C167-7D8A383DA065]
    // </editor-fold> 
    public PopularityOfBeitrag createPopularityOfBeitragReport (int sortByVal, Date startDateVal, Date endDateVal)
            throws RemoteException ;

}

