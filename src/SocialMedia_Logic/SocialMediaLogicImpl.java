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
import SocialMedia_ReportGenerator.ReportGeneratorImpl;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.Vector;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.FB484D00-E9A8-8868-8F1F-2944573C596E]
// </editor-fold> 
/**
 * 
 * @author Sebastian
 */
public class SocialMediaLogicImpl extends java.rmi.server.UnicastRemoteObject implements SocialMediaLogic {

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

    private ReportGenerator reportGenerator;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A40EA4B1-D3AE-FBD5-8C74-CE69064D5075]
    // </editor-fold>

    /**
     *
     * @param likeMapper
     * @param kommentarMapper
     * @param beitragMapper
     * @param abonnementMapper
     * @param nutzerMapper
     * @param pinnwandMapper
     * @throws java.rmi.RemoteException
     */
    public SocialMediaLogicImpl (LikeMapper likeMapper, KommentarMapper kommentarMapper, BeitragMapper beitragMapper, AbonnementMapper abonnementMapper, NutzerMapper nutzerMapper, PinnwandMapper pinnwandMapper) throws RemoteException {
        this.likeMapper = likeMapper;
        this.kommentarMapper = kommentarMapper;
        this.beitragMapper = beitragMapper;
        this.abonnementMapper = abonnementMapper;
        this.nutzerMapper = nutzerMapper;
        this.pinnwandMapper = pinnwandMapper;
        this.reportGenerator = new ReportGeneratorImpl(this);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F512BA95-062D-B7B4-5874-8D2D04E7A001]
    // </editor-fold>
    /**
     * 
     * @param val
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public Vector<Like> getAllLikeOfBeitrag (Beitrag val) throws RemoteException{
        return val.getAllBeitragLikes(this);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.99C8403B-5BBC-E69A-9FC6-F0E8428FA93D]
    // </editor-fold> 
    /**
     * 
     * @param val
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public Vector<Kommentar> getAllKommentarOfBeitrag (Beitrag val) throws RemoteException{
        return val.getAllBeitragKommentar(this);
    }
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.EE7AEF7E-9E77-F835-A78D-1EEAC56AAD77]
    // </editor-fold> 
    /**
     * 
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public Vector<Beitrag> getAllBeitrag () throws RemoteException{
        return beitragMapper.getAll();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9B4DF46F-B156-4748-2520-2D5835471895]
    // </editor-fold> 
    /**
     * 
     * @param val
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public Vector<Abonnement> getAllAbonnementOfNutzer (Nutzer val) throws RemoteException{
        return val.getAllNutzerAbonnement(this);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.EEA69D64-E839-E156-7131-877DEDAFDDA6]
    // </editor-fold> 
    /**
     * 
     * @param val
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public Pinnwand getPinnwandOfAbonnement (Abonnement val) throws RemoteException{
        return val.getAbonnementPinnwand(this);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.332BE2CD-E2F2-7B46-7CF6-53FA4A82274E]
    // </editor-fold> 
    /**
     * 
     * @param username
     * @param name
     * @param surname
     * @param password
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public Nutzer createNutzer (String username, String name, String surname, String password) throws RemoteException{
        Boolean isCreatable = true;
        Nutzer neuerNutzer = new NutzerImpl();
        neuerNutzer.setName(name);
        neuerNutzer.setSurname(surname);
        neuerNutzer.setUsername(username);
        neuerNutzer.setPassword(password);
        neuerNutzer.setCreationDate(new Date());

        Vector<Nutzer> alleNutzer = this.getAllNutzer();

        for (int i = 0; i < alleNutzer.size(); i++) {
            Nutzer nutzer = alleNutzer.elementAt(i);
            if(nutzer.getUsername().equals(neuerNutzer.getUsername()))
                isCreatable = false;
        }
        if (isCreatable) {
            neuerNutzer = nutzerMapper.insert(neuerNutzer);
            createPinnwand(neuerNutzer);
            return neuerNutzer;
        } else {
            return null;
        }
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.FC04FC00-E24A-98F2-3349-B9FD920145AE]
    // </editor-fold> 
    /**
     * 
     * @param n
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public Pinnwand createPinnwand (Nutzer n) throws RemoteException{
        Pinnwand pinnwand = new PinnwandImpl();
        pinnwand.setCreationDate(new Date());
        pinnwand.setNutzerID(n.getID());
        return pinnwandMapper.insert(pinnwand);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.88BE6958-5E18-14BA-A610-1D88707C5B09]
    // </editor-fold> 
    /**
     * 
     * @param p
     * @param n
     * @param text
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public Beitrag createBeitrag (Pinnwand p, Nutzer n, String text) throws RemoteException{
        Beitrag beitrag = new BeitragImpl();
        beitrag.setCreationDate(new Date());
        beitrag.setPinnwandID(p.getID());
        beitrag.setText(text);
        beitrag.setNutzerID(n.getID());
        return beitragMapper.insert(beitrag);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A02DB77D-0CF1-4106-4F71-8156B34213A9]
    // </editor-fold> 
    /**
     * 
     * @param b
     * @param n
     * @param text
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public Kommentar createKommentar (Beitrag b, Nutzer n, String text) throws RemoteException{
        Kommentar kommentar = new KommentarImpl();
        kommentar.setBeitragID(b.getID());
        kommentar.setCreationDate(new Date());
        kommentar.setText(text);
        kommentar.setNutzerID(n.getID());
        return kommentarMapper.insert(kommentar);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9F06F9DF-CAE9-CF4B-A623-71CD19435718]
    // </editor-fold> 
    /**
     * 
     * @param b
     * @param n
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public Like createLike (Beitrag b, Nutzer n) throws RemoteException{
        Like like = new LikeImpl();
        like.setBeitragID(b.getID());
        like.setCreationDate(new Date());
        like.setNutzerID(n.getID());
        return likeMapper.insert(like);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9C219BC2-CE4B-0A3F-F90A-6D9158230771]
    // </editor-fold> 
    /**
     * 
     * @param p
     * @param n
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public Abonnement createAbonnement (Pinnwand p, Nutzer n) throws RemoteException{
        Abonnement abonnement = new AbonnementImpl();
        abonnement.setCreationDate(new Date());
        abonnement.setNutzerID(n.getID());
        abonnement.setPinnwandID(p.getID());
        return abonnementMapper.insert(abonnement);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F096A7B4-B512-4224-39C4-0A1923FB1E76]
    // </editor-fold> 
    /**
     * 
     * @param val 
     * @throws java.rmi.RemoteException 
     */
    public void deleteBeitrag (Beitrag val) throws RemoteException{
        Vector<Kommentar> kommentareToDelete = val.getAllBeitragKommentar(this);
        for (int i = 0; i < kommentareToDelete.size(); i++) {
            Kommentar kommentar = kommentareToDelete.elementAt(i);
            deleteKommentar(kommentar);
        }
        Vector<Like> likesToDelete = val.getAllBeitragLikes(this);
        for (int i = 0; i < likesToDelete.size(); i++) {
            Like like = likesToDelete.elementAt(i);
            deleteLike(like);
        }
        beitragMapper.delete(val);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.54EA257F-BDC9-E395-06E2-C38930EA1C47]
    // </editor-fold> 
    /**
     * 
     * @param val 
     * @throws java.rmi.RemoteException 
     */
    public void deleteKommentar (Kommentar val) throws RemoteException{
        kommentarMapper.delete(val);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F04E9C7D-DF39-D4C1-CA6F-F0C7E594FF23]
    // </editor-fold> 
    /**
     * 
     * @param val 
     * @throws java.rmi.RemoteException 
     */
    public void deleteLike (Like val) throws RemoteException{
        likeMapper.delete(val);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D70A0C1C-C792-90AD-0451-23BE6ED0F91C]
    // </editor-fold> 
    /**
     * 
     * @param val 
     * @throws java.rmi.RemoteException 
     */
    public void deleteAbonnement (Abonnement val) throws RemoteException{
        abonnementMapper.delete(val);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.44DCB352-14CA-B344-5BC9-140373F0D2B6]
    // </editor-fold> 
    /**
     * 
     * @param val 
     * @throws java.rmi.RemoteException 
     */
    public void deactivateNutzer (Nutzer val) throws RemoteException{
        val.setUsername("Deaktivierter Nutzer");
        val.setPassword(new Date().toString());
        deletePinnwand(val.getNutzerPinnwand(this));
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5737DE0C-5D9D-A07C-31A1-2A9182689801]
    // </editor-fold> 
    /**
     * 
     * @param val 
     * @throws java.rmi.RemoteException 
     */
    public void deletePinnwand (Pinnwand val) throws RemoteException{
        pinnwandMapper.delete(val);
        Vector<Beitrag> zuLoeschendeBeitraege = val.getAllPinnwandBeitraege(this);
        for (int i = 0; i < zuLoeschendeBeitraege.size(); i++) {
            deleteBeitrag(zuLoeschendeBeitraege.elementAt(i));
        }
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F430EEA6-50C6-02C3-918D-04DD28681A58]
    // </editor-fold> 
    /**
     * 
     * @param username
     * @param password
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public Nutzer authenticateNutzer (String username, String password) throws RemoteException{
        Vector<Nutzer> nutzers = nutzerMapper.getAll();
        Nutzer nutzer = null;
        for (int i = 0; i < nutzers.size(); i++) {
            if (username.equals(nutzers.elementAt(i).getUsername()))
                nutzer = nutzers.elementAt(i);
        }
        if (nutzer != null){
            if (password.equals(nutzer.getPassword())) {
                return nutzer;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F21F8D86-3A7A-9698-C19B-B697E5029F30]
    // </editor-fold> 
    /**
     * 
     * @param username
     * @param name
     * @param surname
     * @param password
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public Nutzer registrateNutzer (String username, String name, String surname, String password) throws RemoteException{
        return createNutzer(username, name, surname, password);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2B7961BD-5993-B6B1-74E5-DCAE142378D2]
    // </editor-fold> 
    /**
     * 
     * @param val
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public Pinnwand getPinnwandOfNutzer (Nutzer val) throws RemoteException{
        return val.getNutzerPinnwand(this);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0C6ACEA3-8FF0-DA46-FB02-E756225055F9]
    // </editor-fold> 
    /**
     * 
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public Vector<Pinnwand> getAllPinnwand () throws RemoteException{
        return this.pinnwandMapper.getAll();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A778174E-5769-F86A-5D7A-3B24981B8141]
    // </editor-fold> 
    /**
     * 
     * @param val
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public Vector<Beitrag> getAllBeitragOfPinnwand (Pinnwand val) throws RemoteException{
        return val.getAllPinnwandBeitraege(this);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.57B75893-889C-FDFD-4B14-C8C32D7C6BF8]
    // </editor-fold> 
    /**
     * 
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public Vector<Like> getAllLike () throws RemoteException{
        return likeMapper.getAll();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9B8BB13C-9084-D93A-081F-3E5FCE5AD63F]
    // </editor-fold> 
    /**
     * 
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public Vector<Kommentar> getAllKommentar () throws RemoteException{
        return kommentarMapper.getAll();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0A2A6431-0899-945E-33F2-3D1BC5D84ABE]
    // </editor-fold> 
    /**
     * 
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public Vector<Abonnement> getAllAbonnement () throws RemoteException{
        return this.abonnementMapper.getAll();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D1944576-2CD0-9400-47FB-2EFE48B33DE5]
    // </editor-fold> 
    /**
     * 
     * @param val
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public Nutzer getOwnerOfPinnwandOfAbonnement (Abonnement val) throws RemoteException{
        Pinnwand p;
        p = val.getAbonnementPinnwand(this);
        return p.getOwner(this);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F73B11C8-1E12-4694-46DB-4CC2CADB0F4E]
    // </editor-fold> 
    /**
     * 
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public Vector<Nutzer> getAllNutzer () throws RemoteException{
        return nutzerMapper.getAll();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.86E91838-6671-CE8D-5E33-D0DD3F055D7F]
    // </editor-fold> 
    /**
     * 
     * @param val
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public Vector<Nutzer> searchNutzer (String val) throws RemoteException{
        Vector<Nutzer> nutzers = nutzerMapper.getAll();
        Vector<Nutzer> filteredNutzers = null;
        for (int i = 0; i < nutzers.size(); i++) {
            Nutzer nutzer = nutzers.elementAt(i);
            if (
                    nutzer.getSurname().toLowerCase().contains(val.toLowerCase())
                    || nutzer.getName().toLowerCase().contains(val.toLowerCase())
                    || nutzer.getUsername().toLowerCase().contains(val.toLowerCase()))
                filteredNutzers.addElement(nutzer);
        }
        return filteredNutzers;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3AF91737-2A47-B29A-5E79-2E90649BA926]
    // </editor-fold> 
    /**
     * 
     * @param username
     * @param name
     * @param surname
     * @param password
     * @param n
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public Nutzer editNutzer (String username, String name, String surname, String password, Nutzer val) throws RemoteException{
        Boolean isEditable = true;
        Boolean isSame = false;
        Vector<Nutzer> alleNutzer = this.getAllNutzer();
        for (int i = 0; i < alleNutzer.size(); i++) {
            Nutzer nutzer = alleNutzer.elementAt(i);
            if(nutzer.getUsername().equals(username) ){
                isEditable = false;
                if (nutzer.getID() == val.getID())
                    isSame = true;
            }       
        }
        if (isEditable) {
            val.setUsername(username);
            val.setName(name);
            val.setSurname(surname);
            val.setPassword(password);
            return saveNutzer(val);
        } else {
            if (isSame){
                val.setUsername(username);
                val.setName(name);
                val.setSurname(surname);
                val.setPassword(password);
                return saveNutzer(val);
            } else {
                return null;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.73F924D2-DAB9-D6BA-1382-98A56D7A2F08]
    // </editor-fold> 
    /**
     * 
     * @param text
     * @param b
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public Beitrag editBeitrag (String text, Beitrag b) throws RemoteException{
        b.setText(text);
        return saveBeitrag(b);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5D166AAA-C58E-F614-CBC5-BDC40AD2AF64]
    // </editor-fold> 
    /**
     * 
     * @param text
     * @param k
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public Kommentar editKommentar (String text, Kommentar k) throws RemoteException{
        k.setText(text);
        return saveKommentar(k);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.7E869C88-9B52-64C0-3A27-F54B650336BB]
    // </editor-fold> 
    /**
     * 
     * @param val 
     * @return  
     * @throws java.rmi.RemoteException 
     */
    public Nutzer saveNutzer (Nutzer val) throws RemoteException{
        return nutzerMapper.update(val);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.96DF2B87-8D8D-F34E-C01E-85EDD102CA5A]
    // </editor-fold> 
    /**
     * 
     * @param val 
     * @return  
     * @throws java.rmi.RemoteException 
     */
    public Beitrag saveBeitrag (Beitrag val) throws RemoteException{
        return beitragMapper.update(val);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4C2FEF26-D39B-EA32-2139-40C512071758]
    // </editor-fold> 
    /**
     * 
     * @param val 
     * @return  
     * @throws java.rmi.RemoteException 
     */
    public Kommentar saveKommentar (Kommentar val) throws RemoteException{
        return kommentarMapper.update(val);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.291FFDFE-4910-E21F-D077-7345E9D295EA]
    // </editor-fold> 
    /**
     * 
     * @param p
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public Nutzer getOwnerOfPinnwand (Pinnwand p) throws RemoteException{
        return p.getOwner(this);
    }

}

