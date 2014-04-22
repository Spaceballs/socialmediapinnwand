package SocialMedia_Logic;

 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.A24B76E7-9F46-56FA-1EC7-D50C1E13D908]
// </editor-fold> 
public class SocialMediaServer {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.075EE66D-FB4D-E499-E575-4D3910CB050F]
    // </editor-fold> 
    private SocialMediaLogicImpl socialMediaLogicImpl;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.BF87C5F2-0E61-1F1F-85D0-2A8DF62CA448]
    // </editor-fold> 
    private SocialMediaLogic mSocialMediaLogic;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.34EC638F-091D-E446-8B60-6A9101569827]
    // </editor-fold> 
    public SocialMediaServer () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5C715AB0-272A-0F62-41FE-99F75849F41F]
    // </editor-fold> 
    public void main (String args) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.5E344920-6D5F-56DD-3A68-2E4ECEF6E918]
    // </editor-fold> 
    public SocialMediaLogic getSocialMediaLogic () {
        return mSocialMediaLogic;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.BA708936-9B5B-71B6-0F1C-96553064528B]
    // </editor-fold> 
    public void setSocialMediaLogic (SocialMediaLogic val) {
        this.mSocialMediaLogic = val;
    }

}

