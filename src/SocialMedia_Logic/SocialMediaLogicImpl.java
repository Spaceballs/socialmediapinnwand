package SocialMedia_Logic;

import SocialMedia_Data.Abonnement; 
import SocialMedia_Data.AbonnementImpl; 
import SocialMedia_Data.Beitrag; 
import SocialMedia_Data.BeitragImpl; 
import SocialMedia_Data.Kommentar; 
import SocialMedia_Data.KommentarImpl; 
import SocialMedia_Data.Like; 
import SocialMedia_Data.LikeImpl; 
import SocialMedia_Data.Nutzer;
import SocialMedia_Data.NutzerImpl; 
import SocialMedia_Data.Pinnwand; 
import SocialMedia_Data.PinnwandImpl;  
import SocialMedia_DatabaseManager.AbonnementMapper; 
import SocialMedia_DatabaseManager.BeitragMapper; 
import SocialMedia_DatabaseManager.KommentarMapper; 
import SocialMedia_DatabaseManager.LikeMapper; 
import SocialMedia_DatabaseManager.NutzerMapper; 
import SocialMedia_DatabaseManager.PinnwandMapper; 
//import SocialMedia_DatabaseManager.Vector<Abonnement>;
//import SocialMedia_DatabaseManager.Vector<Beitrag>;
//import SocialMedia_DatabaseManager.Vector<Kommentar>;
//import SocialMedia_DatabaseManager.Vector<Like>;
//import SocialMedia_DatabaseManager.Vector<Nutzer>;
import SocialMedia_ReportGenerator.ReportGenerator; 
import java.util.Vector;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.FB484D00-E9A8-8868-8F1F-2944573C596E]
// </editor-fold> 
public class SocialMediaLogicImpl implements SocialMediaLogic {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.EB4714A1-545D-2CD4-C61F-CAB30CBEAB2D]
    // </editor-fold> 
    private LikeMapper likeMapper;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.7E384158-C838-6D19-388B-73F38973C24A]
    // </editor-fold> 
    private KommentarMapper kommentarMapper;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A9627CE2-EE84-211B-8192-BFAAE5583435]
    // </editor-fold> 
    private BeitragMapper beitragMapper;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6B7FBB1E-10AE-F884-F94B-121E46EF9F62]
    // </editor-fold> 
    private AbonnementMapper abonnementMapper;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.43F95F85-F37C-7558-2A76-EC8662964A63]
    // </editor-fold> 
    private NutzerMapper nutzerMapper;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.AD32097B-46E4-1D92-AB48-48CDBC6877B5]
    // </editor-fold> 
    private PinnwandMapper pinnwandMapper;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9993C351-D864-16C8-841C-49E622E0F1E3]
    // </editor-fold> 
    private BeitragImpl mBeitragImpl;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.10923064-344E-34CA-DAD0-7B0B43557281]
    // </editor-fold> 
    private KommentarImpl mKommentarImpl;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D1C038DB-E8BE-8F11-611C-6B1F72640E28]
    // </editor-fold> 
    private LikeImpl mLikeImpl;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.38AB6D65-1C53-A8E5-A633-DE72ADAD95EF]
    // </editor-fold> 
    private PinnwandImpl mPinnwandImpl;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.581077A3-7577-A33B-BC13-E596C94996F4]
    // </editor-fold> 
    private AbonnementImpl mAbonnementImpl;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F684580B-48EE-C623-EB5C-F884CF202FB7]
    // </editor-fold> 
    private NutzerImpl mNutzerImpl;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B733DD4E-D212-7D7B-28BC-F5F7BDFF3C47]
    // </editor-fold> 
    private PinnwandMapper mPinnwandMapper;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.BFA99BFB-745E-DFDA-B8E6-E9694F495CB7]
    // </editor-fold> 
    private NutzerMapper mNutzerMapper;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8EF53F9B-C617-BF06-AEE5-5640D92FED41]
    // </editor-fold> 
    private AbonnementMapper mAbonnementMapper;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.ECEFB40D-C12D-3573-7AC1-3EEA3D4A31CD]
    // </editor-fold> 
    private BeitragMapper mBeitragMapper;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.93B57EBB-8476-BE9F-69F0-A6280A40A2E6]
    // </editor-fold> 
    private KommentarMapper mKommentarMapper;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.98EF5AEC-BB27-1083-8D93-7D39E5E21BF3]
    // </editor-fold> 
    private LikeMapper mLikeMapper;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6747B83B-E0F7-D214-A7C1-84F36AD01DC1]
    // </editor-fold> 
    private ReportGenerator mReportGenerator;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A40EA4B1-D3AE-FBD5-8C74-CE69064D5075]
    // </editor-fold> 
    public SocialMediaLogicImpl (LikeMapper likeMapper, KommentarMapper kommentarMapper, BeitragMapper beitragMapper, AbonnementMapper abonnementMapper, NutzerMapper nutzerMapper, PinnwandMapper pinnwandMapper) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E929B82C-9AA5-5632-24CF-A07C993A9752]
    // </editor-fold> 
    public AbonnementMapper getAbonnementMapper () {
        return mAbonnementMapper;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.D9B509AB-618D-69F3-0295-7B1E8654B4B5]
    // </editor-fold> 
    public void setAbonnementMapper (AbonnementMapper val) {
        this.mAbonnementMapper = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E6B3A845-6C39-7A23-DD49-880CA04D7998]
    // </editor-fold> 
    public BeitragMapper getBeitragMapper () {
        return mBeitragMapper;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.4C9782F2-F29B-7DB0-E1C6-219156F494B4]
    // </editor-fold> 
    public void setBeitragMapper (BeitragMapper val) {
        this.mBeitragMapper = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.BA018761-DFEF-073F-9CD8-B114A2CA97A9]
    // </editor-fold> 
    public KommentarMapper getKommentarMapper () {
        return mKommentarMapper;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.3A6D889E-4C70-6F2A-5F46-C92FC2796232]
    // </editor-fold> 
    public void setKommentarMapper (KommentarMapper val) {
        this.mKommentarMapper = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1CE5B23F-7E35-3547-1EFB-5EE1D9C5F09F]
    // </editor-fold> 
    public LikeMapper getLikeMapper () {
        return mLikeMapper;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.5F9ECE85-3252-A252-C034-E75D0F86EF2D]
    // </editor-fold> 
    public void setLikeMapper (LikeMapper val) {
        this.mLikeMapper = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.16CC8171-F482-CAF0-53A0-879A93395401]
    // </editor-fold> 
    public NutzerMapper getNutzerMapper () {
        return mNutzerMapper;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.51C55431-348E-B322-92B0-CFBE123E2D83]
    // </editor-fold> 
    public void setNutzerMapper (NutzerMapper val) {
        this.mNutzerMapper = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.17C5896F-3C7C-A5B5-66EC-62F8FCF8FA18]
    // </editor-fold> 
    public PinnwandMapper getPinnwandMapper () {
        return mPinnwandMapper;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1ECF5936-CE36-5434-0577-566E6CB6A36B]
    // </editor-fold> 
    public void setPinnwandMapper (PinnwandMapper val) {
        this.mPinnwandMapper = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F512BA95-062D-B7B4-5874-8D2D04E7A001]
    // </editor-fold> 
    public Vector<Like> getAllLikeOfBeitrag (Beitrag val) {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.99C8403B-5BBC-E69A-9FC6-F0E8428FA93D]
    // </editor-fold> 
    public Vector<Kommentar> getAllKommentarOfBeitrag (Beitrag val) {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.EE7AEF7E-9E77-F835-A78D-1EEAC56AAD77]
    // </editor-fold> 
    public Vector<Beitrag> getAllBeitrag () {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9B4DF46F-B156-4748-2520-2D5835471895]
    // </editor-fold> 
    public Vector<Abonnement> getAllAbonnementOfNutzer (Nutzer val) {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.EEA69D64-E839-E156-7131-877DEDAFDDA6]
    // </editor-fold> 
    public Pinnwand getPinnwandOfAbonnement (Abonnement val) {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.6858C105-4B91-7C1F-99C9-FCBC92679077]
    // </editor-fold> 
    public ReportGenerator getReportGenerator () {
        return mReportGenerator;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.342B0088-2895-7E8A-A3F3-A8EDCB71F3D2]
    // </editor-fold> 
    public void setReportGenerator (ReportGenerator val) {
        this.mReportGenerator = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.332BE2CD-E2F2-7B46-7CF6-53FA4A82274E]
    // </editor-fold> 
    public Nutzer createNutzer (String username, String name, String surname, String password) {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.FC04FC00-E24A-98F2-3349-B9FD920145AE]
    // </editor-fold> 
    public Pinnwand createPinnwand (Nutzer n) {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.88BE6958-5E18-14BA-A610-1D88707C5B09]
    // </editor-fold> 
    public Beitrag createBeitrag (Pinnwand p, Nutzer n, String text) {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A02DB77D-0CF1-4106-4F71-8156B34213A9]
    // </editor-fold> 
    public Kommentar createKommentar (Beitrag b, Nutzer n, String text) {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9F06F9DF-CAE9-CF4B-A623-71CD19435718]
    // </editor-fold> 
    public Like createLike (Beitrag b, Nutzer n) {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9C219BC2-CE4B-0A3F-F90A-6D9158230771]
    // </editor-fold> 
    public Abonnement createAbonnement (Pinnwand p, Nutzer n) {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F096A7B4-B512-4224-39C4-0A1923FB1E76]
    // </editor-fold> 
    public void deleteBeitrag (Beitrag val) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.54EA257F-BDC9-E395-06E2-C38930EA1C47]
    // </editor-fold> 
    public void deleteKommentar (Kommentar val) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F04E9C7D-DF39-D4C1-CA6F-F0C7E594FF23]
    // </editor-fold> 
    public void deleteLike (Like val) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D70A0C1C-C792-90AD-0451-23BE6ED0F91C]
    // </editor-fold> 
    public void deleteAbonnement (Abonnement val) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.44DCB352-14CA-B344-5BC9-140373F0D2B6]
    // </editor-fold> 
    public void deactivateNutzer (Nutzer val) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5737DE0C-5D9D-A07C-31A1-2A9182689801]
    // </editor-fold> 
    public void deletePinnwand (Pinnwand val) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F430EEA6-50C6-02C3-918D-04DD28681A58]
    // </editor-fold> 
    public Nutzer authenticateNutzer (String username, String password) {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F21F8D86-3A7A-9698-C19B-B697E5029F30]
    // </editor-fold> 
    public Nutzer registrateNutzer (String username, String name, String surname, String password) {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2B7961BD-5993-B6B1-74E5-DCAE142378D2]
    // </editor-fold> 
    public Pinnwand getPinnwandOfNutzer (Nutzer val) {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0C6ACEA3-8FF0-DA46-FB02-E756225055F9]
    // </editor-fold> 
    public Vector<Pinnwand> getAllPinnwand () {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A778174E-5769-F86A-5D7A-3B24981B8141]
    // </editor-fold> 
    public Vector<Beitrag> getAllBeitragOfPinnwand (Pinnwand val) {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.57B75893-889C-FDFD-4B14-C8C32D7C6BF8]
    // </editor-fold> 
    public Vector<Like> getAllLike () {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9B8BB13C-9084-D93A-081F-3E5FCE5AD63F]
    // </editor-fold> 
    public Vector<Kommentar> getAllKommentar () {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0A2A6431-0899-945E-33F2-3D1BC5D84ABE]
    // </editor-fold> 
    public Vector<Abonnement> getAllAbonnement () {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D1944576-2CD0-9400-47FB-2EFE48B33DE5]
    // </editor-fold> 
    public Nutzer getOwnerOfPinnwandOfAbonnement (Abonnement val) {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F73B11C8-1E12-4694-46DB-4CC2CADB0F4E]
    // </editor-fold> 
    public Vector<Nutzer> getAllNutzer () {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.86E91838-6671-CE8D-5E33-D0DD3F055D7F]
    // </editor-fold> 
    public Vector<Nutzer> searchNutzer (String val) {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3AF91737-2A47-B29A-5E79-2E90649BA926]
    // </editor-fold> 
    public Nutzer editNutzer (String username, String name, String surname, String password, Nutzer n) {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.73F924D2-DAB9-D6BA-1382-98A56D7A2F08]
    // </editor-fold> 
    public Beitrag editBeitrag (String text, Beitrag b) {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5D166AAA-C58E-F614-CBC5-BDC40AD2AF64]
    // </editor-fold> 
    public Kommentar editKommentar (String text, Kommentar k) {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.7E869C88-9B52-64C0-3A27-F54B650336BB]
    // </editor-fold> 
    public void saveNutzer (Nutzer val) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.96DF2B87-8D8D-F34E-C01E-85EDD102CA5A]
    // </editor-fold> 
    public void saveBeitrag (Beitrag val) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4C2FEF26-D39B-EA32-2139-40C512071758]
    // </editor-fold> 
    public void saveKommentar (Kommentar val) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.291FFDFE-4910-E21F-D077-7345E9D295EA]
    // </editor-fold> 
    public Nutzer getOwnerOfPinnwand (Pinnwand p) {
        return null;
    }

}

