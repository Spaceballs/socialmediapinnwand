package SocialMedia_ReportGenerator;

import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic; 
import java.util.Date;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.E7C2C07C-F969-9A30-C188-C220A1AD2C41]
// </editor-fold> 
public class ReportGeneratorImpl implements ReportGenerator {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5F731C06-B576-8C5F-7EB5-3ED06DFC5D1B]
    // </editor-fold> 
    private SocialMediaLogic socialMediaLogic = null;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3854DE2D-2FBB-12AC-4665-7EAB9F8EF992]
    // </editor-fold> 
    private SocialMediaLogic mSocialMediaLogic;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.FFA80F7B-865F-8487-8FD9-D67548105CC4]
    // </editor-fold> 
    private ContributionOfNutzer mContributionOfNutzer;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1E9124D5-98E6-2B62-25ED-7FBD09053676]
    // </editor-fold> 
    private PopularityOfBeitrag mPopularityOfBeitrag;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.657F1B43-DFBC-7C21-6CDC-195ADE1929AA]
    // </editor-fold> 
    public ReportGeneratorImpl (SocialMediaLogic val) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.90F365D7-3DB5-1127-B82A-A1B3AF5438A5]
    // </editor-fold> 
    public SocialMediaLogic getSocialMediaLogic () {
        return mSocialMediaLogic;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.400D4454-3840-440E-5A48-88302354B31E]
    // </editor-fold> 
    public void setSocialMediaLogic (SocialMediaLogic val) {
        this.mSocialMediaLogic = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.975F3159-35F0-CCCD-CB7B-ACA6F8F16C17]
    // </editor-fold> 
    public ContributionOfNutzer createContributionOfNutzerReport (Nutzer nutzerVal, int sortByVal, Date startDateVal, Date endDateVal) {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A085AD62-913F-0C59-690A-A589531FAEA9]
    // </editor-fold> 
    public PopularityOfBeitrag createPopularityOfBeitragReport (int sortByVal, Date startDateVal, Date endDateVal) {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1AB44A57-38A8-9D34-8C53-06AA5E334E41]
    // </editor-fold> 
    public ContributionOfNutzer getContributionOfNutzer () {
        return mContributionOfNutzer;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.AB9B6DD8-B1AF-88F4-1B33-DAEED2264FFB]
    // </editor-fold> 
    public void setContributionOfNutzer (ContributionOfNutzer val) {
        this.mContributionOfNutzer = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.889BB154-1FA6-9BEB-60E1-DE023E3B22E8]
    // </editor-fold> 
    public PopularityOfBeitrag getPopularityOfBeitrag () {
        return mPopularityOfBeitrag;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.ED0A0B3C-08CC-8D03-B895-1A3710D8A06B]
    // </editor-fold> 
    public void setPopularityOfBeitrag (PopularityOfBeitrag val) {
        this.mPopularityOfBeitrag = val;
    }

}

