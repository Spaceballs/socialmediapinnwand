package SocialMedia_Logic;

import SocialMedia_Data.Abonnement; 
import SocialMedia_Data.Beitrag; 
import SocialMedia_Data.Kommentar; 
import SocialMedia_Data.Like; 
import SocialMedia_Data.Nutzer;
import SocialMedia_Data.Pinnwand; 
import java.util.Vector;

//import SocialMedia_DatabaseManager.Vector<Abonnement>;
//import SocialMedia_DatabaseManager.Vector<Beitrag>;
//import SocialMedia_DatabaseManager.Vector<Kommentar>;
//import SocialMedia_DatabaseManager.Vector<Like>;
//import SocialMedia_DatabaseManager.Vector<Nutzer>;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.E76387BD-2F3C-081D-1D36-29915AB9AE5C]
// </editor-fold> 
public interface SocialMediaLogic extends java.rmi.Remote{

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.54A689F8-ED15-B995-2054-87F098C4F905]
    // </editor-fold> 
    public Nutzer createNutzer (String username, String name, String surname, String password)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2C19CA25-A24A-E3A8-45C5-43A12A47C76A]
    // </editor-fold> 
    public Vector<Kommentar> getAllKommentarOfBeitrag (Beitrag val)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.7A03E76D-45AB-7C7F-8636-E4515BC2A7D3]
    // </editor-fold> 
    public Vector<Like> getAllLikeOfBeitrag (Beitrag val)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8373614D-035D-0AEB-2538-ACF70E28EA1B]
    // </editor-fold> 
    public Vector<Abonnement> getAllAbonnementOfNutzer (Nutzer val)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4DB52CDE-ABE2-3DB7-5EA6-8085AC65F5CE]
    // </editor-fold> 
    public Pinnwand getPinnwandOfAbonnement (Abonnement val)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.AA673068-5BB7-3ECA-BCB3-AB1805221D28]
    // </editor-fold> 
    public Beitrag createBeitrag (Pinnwand p, Nutzer n, String text)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.FBD8F383-B73F-E525-572D-4C9F1B73B61E]
    // </editor-fold> 
    public Kommentar createKommentar (Beitrag b, Nutzer n, String text)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5C006196-B10F-B493-CF8C-69FF5F383E95]
    // </editor-fold> 
    public Like createLike (Beitrag b, Nutzer n)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9026466D-2033-DECA-2448-5CD82A4BAC7B]
    // </editor-fold> 
    public void deleteBeitrag (Beitrag val)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C139C0C7-1C38-CDD6-CF30-E0B7EBCCD9FF]
    // </editor-fold> 
    public void deleteKommentar (Kommentar val)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.BE6AC285-B237-F242-05F7-D770F3995D2B]
    // </editor-fold> 
    public void deleteLike (Like val)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9ABDFC79-EC25-3B19-17DC-95705907C62F]
    // </editor-fold> 
    public void deleteAbonnement (Abonnement val)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E61ADFC0-D8EE-51E2-5CD4-E1BB37A9C6FC]
    // </editor-fold> 
    public void deactivateNutzer (Nutzer val)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CB626DDB-C83E-1C13-AFFA-5BC2005C56AB]
    // </editor-fold> 
    public Nutzer authenticateNutzer (String username, String password)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4E1A6CCA-C9C8-F219-1E16-83153577663E]
    // </editor-fold> 
    public Nutzer registrateNutzer (String username, String name, String surname, String password)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.837B6B2A-714F-9063-9FD9-C4AFDD62D864]
    // </editor-fold> 
    public Pinnwand getPinnwandOfNutzer (Nutzer val)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6FEAE597-A6F0-32DD-9E09-16B62BB74D2B]
    // </editor-fold> 
    public Vector<Beitrag> getAllBeitragOfPinnwand (Pinnwand val)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4AC13601-4DA3-CE5E-633D-B36F91E9A6F6]
    // </editor-fold> 
    public Nutzer getOwnerOfPinnwandOfAbonnement (Abonnement val)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.DF03CA40-1D95-DFEB-B9D6-CA5045C6EF48]
    // </editor-fold> 
    public Vector<Nutzer> searchNutzer (String val)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D6403017-EE42-52F6-647F-4DE73A803C34]
    // </editor-fold> 
    public Nutzer editNutzer (String username, String name, String surname, String password, Nutzer n)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2C5775B1-3043-5BE9-8876-92CAADDFD60B]
    // </editor-fold> 
    public Beitrag editBeitrag (String text, Beitrag b)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1EB9141E-7D2A-BBED-4F28-87BB196DB354]
    // </editor-fold> 
    public Kommentar editKommentar (String text, Kommentar k)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B61F7894-BE9E-682E-4B85-3082FAC61759]
    // </editor-fold> 
    public Abonnement createAbonnement (Pinnwand p, Nutzer n)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E37CB35B-8EC6-1D18-9244-0DE4417EABFC]
    // </editor-fold> 
    public Nutzer getOwnerOfPinnwand (Pinnwand p)throws java.rmi.RemoteException;
    
    public Vector<Beitrag> getAllBeitrag ()throws java.rmi.RemoteException;
    
    public Vector<Pinnwand> getAllPinnwand ()throws java.rmi.RemoteException;
    
    public Vector<Like> getAllLike ()throws java.rmi.RemoteException;
    
    public Vector<Kommentar> getAllKommentar ()throws java.rmi.RemoteException;
    
    public Vector<Abonnement> getAllAbonnement ()throws java.rmi.RemoteException;
    
    public Vector<Nutzer> getAllNutzer ()throws java.rmi.RemoteException;
    
    public Pinnwand createPinnwand (Nutzer n)throws java.rmi.RemoteException;
    
    public void deletePinnwand (Pinnwand val)throws java.rmi.RemoteException;
    
    public Nutzer saveNutzer (Nutzer val)throws java.rmi.RemoteException;
    
    public Beitrag saveBeitrag (Beitrag val)throws java.rmi.RemoteException;
    
    public Kommentar saveKommentar (Kommentar val)throws java.rmi.RemoteException;
    
}

