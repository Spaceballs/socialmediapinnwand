package SocialMedia_Logic;

import SocialMedia_Data.Abonnement; 
import SocialMedia_Data.Beitrag; 
import SocialMedia_Data.Kommentar; 
import SocialMedia_Data.Like; 
import SocialMedia_Data.Nutzer;
import SocialMedia_Data.Pinnwand; 
import SocialMedia_ReportGenerator.ReportGenerator;
import java.rmi.RemoteException;
import java.util.Vector;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.E76387BD-2F3C-081D-1D36-29915AB9AE5C]
// </editor-fold> 
/**
 * Interface class for the SocialMediaLogic which handles all actions
 * @author Max
 */
public interface SocialMediaLogic extends java.rmi.Remote{

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.54A689F8-ED15-B995-2054-87F098C4F905]
    // </editor-fold> 
    /**
     * Creates a Nutzer
     * @param username - Username of the new Nutzer object.
     * @param name - Name of the new Nutzer object.
     * @param surname - Surname of the new Nutzer object.
     * @param password - Password of the new Nutzer object.
     * @return the createdNutzer Object.
     * @throws java.rmi.RemoteException  
     */
    public Nutzer createNutzer (String username, String name, String surname, String password)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2C19CA25-A24A-E3A8-45C5-43A12A47C76A]
    // </editor-fold> 
    /**
     * Read out the <code>Kommentar</code>-objects from Beitrag.
     * @param val - Beitrag to read out the data
     * @return vector with object Beitrag
     * @throws java.rmi.RemoteException 
     */
    public Vector<Kommentar> getAllKommentarOfBeitrag (Beitrag val)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.7A03E76D-45AB-7C7F-8636-E4515BC2A7D3]
    // </editor-fold> 
    /**
     * Read out the <code>Like</code>-objects from Beitrag.
     * @param val - Beitrag to read out the data
     * @return vector with object Beitrag
     * @throws java.rmi.RemoteException 
     */
    public Vector<Like> getAllLikeOfBeitrag (Beitrag val)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8373614D-035D-0AEB-2538-ACF70E28EA1B]
    // </editor-fold> 
    /**
     * Read out the <code>Abonnement</code>-objects from Nutzer.
     * @param val - Nutzer to read out the data
     * @return vector with object Nutzer
     * @throws java.rmi.RemoteException 
     */
    public Vector<Abonnement> getAllAbonnementOfNutzer (Nutzer val)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4DB52CDE-ABE2-3DB7-5EA6-8085AC65F5CE]
    // </editor-fold> 
    /**
     * Getting the Pinnwand of a Abonnement
     * @param val - an Abonnement
     * @return Pinnwand reference
     * @throws java.rmi.RemoteException 
     */
    public Pinnwand getPinnwandOfAbonnement (Abonnement val)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.AA673068-5BB7-3ECA-BCB3-AB1805221D28]
    // </editor-fold> 
    /**
     * Creating a new Beitrag
     * @param p - Parameter for Pinnwand
     * @param n - Parameter for Nutzer
     * @param text - Format String
     * @return the createdBeitrag Object
     * @throws java.rmi.RemoteException 
     */
    public Beitrag createBeitrag (Pinnwand p, Nutzer n, String text)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.FBD8F383-B73F-E525-572D-4C9F1B73B61E]
    // </editor-fold> 
    /**
     * Creating a new Kommentar
     * @param b - Beitrag
     * @param n - Nutzer
     * @param text - String for text
     * @return the createdKommentar Object 
     * @throws java.rmi.RemoteException 
     */
    public Kommentar createKommentar (Beitrag b, Nutzer n, String text)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5C006196-B10F-B493-CF8C-69FF5F383E95]
    // </editor-fold> 
    /**
     * Creating a new Like
     * @param b - Beitrag
     * @param n - Nutzer
     * @return the createdLike Object
     * @throws java.rmi.RemoteException  
     */
    public Like createLike (Beitrag b, Nutzer n)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9026466D-2033-DECA-2448-5CD82A4BAC7B]
    // </editor-fold> 
    /**
     * Deletes the chosen Beitrag with all associated Kommentare and Likes
     * @param val - Beitrag to be deleted.
     * @throws java.rmi.RemoteException 
     */
    public void deleteBeitrag (Beitrag val)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C139C0C7-1C38-CDD6-CF30-E0B7EBCCD9FF]
    // </editor-fold> 
    /**
     * Deletes the chosen Kommentar
     * @param val - Kommentar to be deleted.
     * @throws java.rmi.RemoteException 
     */
    public void deleteKommentar (Kommentar val)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.BE6AC285-B237-F242-05F7-D770F3995D2B]
    // </editor-fold> 
    /**
     * Deletes the chosen Like
     * @param val - Like to be deleted.
     * @throws java.rmi.RemoteException 
     */
    public void deleteLike (Like val)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9ABDFC79-EC25-3B19-17DC-95705907C62F]
    // </editor-fold> 
    /**
     * Deletes the chosen Abonnement
     * @param val - Abonnement to be deleted. 
     * @throws java.rmi.RemoteException 
     */
    public void deleteAbonnement (Abonnement val)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E61ADFC0-D8EE-51E2-5CD4-E1BB37A9C6FC]
    // </editor-fold> 
    /**
     * Deactivates a Nutzer: changes the username and passwort, deletes all Abonnements and
     * deletes the Pinnwand and all associated Beitraege, Kommentare and Likes
     * @param val - Nutzer who wants to delete his account
     * @return changed username and passwort for saving into database
     * @throws java.rmi.RemoteException 
     */
    public Nutzer deactivateNutzer (Nutzer val)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CB626DDB-C83E-1C13-AFFA-5BC2005C56AB]
    // </editor-fold> 
    /**
     * Checks if the inserted username and passwort match for login
     * @param username - inserted String
     * @param password - inserted String
     * @return null
     * @throws java.rmi.RemoteException 
     */
    public Nutzer authenticateNutzer (String username, String password)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4E1A6CCA-C9C8-F219-1E16-83153577663E]
    // </editor-fold> 
    /**
     * Registrates a Nutzer
     * @param username - inserted String
     * @param name - inserted String
     * @param surname - inserted String
     * @param password - inserted String
     * @return the inserted Data and creates a new Nutzer
     * @throws java.rmi.RemoteException 
     */
    public Nutzer registrateNutzer (String username, String name, String surname, String password)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.837B6B2A-714F-9063-9FD9-C4AFDD62D864]
    // </editor-fold> 
    /**
     * Gets the Pinnwand of a Nutzer
     * @param val - the Nutzer
     * @return the Pinnwand reference
     * @throws java.rmi.RemoteException 
     */
    public Pinnwand getPinnwandOfNutzer (Nutzer val)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6FEAE597-A6F0-32DD-9E09-16B62BB74D2B]
    // </editor-fold> 
    /**
     * Read out the <code>Beitrag</code>-objects from Pinnwand.
     * @param val - Pinnwand to read out the data
     * @return vector with object Pinnwand
     * @throws java.rmi.RemoteException  
     */
    public Vector<Beitrag> getAllBeitragOfPinnwand (Pinnwand val)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4AC13601-4DA3-CE5E-633D-B36F91E9A6F6]
    // </editor-fold> 
    /**
     * Gets the owner of a booked Pinnwand
     * @param val - the Abonnement
     * @return the owner of the Pinnwand
     * @throws java.rmi.RemoteException 
     */
    public Nutzer getOwnerOfPinnwandOfAbonnement (Abonnement val)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.DF03CA40-1D95-DFEB-B9D6-CA5045C6EF48]
    // </editor-fold> 
    /**
     * Method to search for a certain entry in the Nutzer table.
     * @param val - a String
     * @return Vector returns all the entrys in the sql table that contain the String in the username
     * @throws java.rmi.RemoteException 
     */
    public Vector<Nutzer> searchNutzer (String val)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D6403017-EE42-52F6-647F-4DE73A803C34]
    // </editor-fold> 
    /**
     * Edits the username, name, surname and/or password of a Nutzer
     * @param username
     * @param name
     * @param surname
     * @param password
     * @param n - the nutzer
     * @return Nutzer for saving into database
     * @throws java.rmi.RemoteException 
     */
    public Nutzer editNutzer (String username, String name, String surname, String password, Nutzer n)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2C5775B1-3043-5BE9-8876-92CAADDFD60B]
    // </editor-fold> 
    /**
     * Edits the text of a Beitrag
     * @param text
     * @param b - Beitrag
     * @return Beitrag for daving into databse
     * @throws java.rmi.RemoteException 
     */
    public Beitrag editBeitrag (String text, Beitrag b)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1EB9141E-7D2A-BBED-4F28-87BB196DB354]
    // </editor-fold> 
    /**
     * Edits the text of a Kommentar
     * @param text
     * @param k - the Kommentar
     * @return Kommentar for saving into database
     * @throws java.rmi.RemoteException 
     */
    public Kommentar editKommentar (String text, Kommentar k)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B61F7894-BE9E-682E-4B85-3082FAC61759]
    // </editor-fold> 
    /**
     * Creating new Abonnement
     * @param p - Pinnwand that is being booked
     * @param n - Nutzer who creates the Abonnement
     * @return the createdAbonnement Object
     * @throws java.rmi.RemoteException 
     */
    public Abonnement createAbonnement (Pinnwand p, Nutzer n)throws java.rmi.RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E37CB35B-8EC6-1D18-9244-0DE4417EABFC]
    // </editor-fold> 
    /**
     * Gets the owner of a Pinnwand
     * @param p - the Pinnwand
     * @return the Nutzer who is owner of the Pinnwand
     * @throws java.rmi.RemoteException 
     */
    public Nutzer getOwnerOfPinnwand (Pinnwand p)throws java.rmi.RemoteException;
    
    /**
     * Getting all Beitraege
     * @return vector with all Beiträge
     * @throws java.rmi.RemoteException 
     */
    public Vector<Beitrag> getAllBeitrag ()throws java.rmi.RemoteException;
    
    /**
     * Gets all Pinnwaende
     * @return Vector returns all the entrys in the sql table
     * @throws java.rmi.RemoteException 
     */
    public Vector<Pinnwand> getAllPinnwand ()throws java.rmi.RemoteException;
    
    /**
     * Getting all Likes
     * @return Vector returns all the entrys in the sql table
     * @throws java.rmi.RemoteException 
     */
    public Vector<Like> getAllLike ()throws java.rmi.RemoteException;
    
    /**
     * Getting all Kommentare
     * @return vector with all comments
     * @throws java.rmi.RemoteException 
     */
    public Vector<Kommentar> getAllKommentar ()throws java.rmi.RemoteException;
    
    /**
     * Getting all Abonnements
     * @return vector with all abonnements 
     * @throws java.rmi.RemoteException 
     */
    public Vector<Abonnement> getAllAbonnement ()throws java.rmi.RemoteException;
    
    /**
     * Method to get each entry in the Nutzer table.
     * @return Vector returns all the entrys in the sql table
     * @throws java.rmi.RemoteException 
     */
    public Vector<Nutzer> getAllNutzer ()throws java.rmi.RemoteException;
    
    /**
     * Creating new Pinnwand
     * @param n - Nutzer
     * @return the createdPinnwand Object
     * @throws java.rmi.RemoteException 
     */
    public Pinnwand createPinnwand (Nutzer n)throws java.rmi.RemoteException;
    
    /**
     * Deletes the chosen Pinnwand and all associated Beitraege
     * @param val - Pinnwand to be deleted.
     * @throws java.rmi.RemoteException 
     */
    public void deletePinnwand (Pinnwand val)throws java.rmi.RemoteException;
    
    /**
     * Save a nutzer object in the database
     * @param val - Nutzer
     * @return Nutzer object will be updated
     * @throws java.rmi.RemoteException 
     */
    public Nutzer saveNutzer (Nutzer val)throws java.rmi.RemoteException;
    
    /**
     * Save a Beitrag object in the database
     * @param val - Beitrag
     * @return Beitrag object will be updated
     * @throws java.rmi.RemoteException 
     */
    public Beitrag saveBeitrag (Beitrag val)throws java.rmi.RemoteException;
    
    /**
     * Kommentar object will be saved in the database.
     * @param val - Kommentar object to be saved
     * @return Kommentar object will be updated  
     * @throws java.rmi.RemoteException 
     */
    public Kommentar saveKommentar (Kommentar val)throws java.rmi.RemoteException;

    /**
     * Read out the ReportGenerator
     * @return ReportGenerator object
     * @throws java.rmi.RemoteException 
     */
    public ReportGenerator getReportGenerator()throws java.rmi.RemoteException;
    
    /**
     * Checks if a Nutzer is owner of a Beitrag, Kommentar, Like or Pinnwand
     * @param n - the Nutzer
     * @param o - the Object
     * @return true or false
     * @throws RemoteException 
     */
    public Boolean ownerCheck (Nutzer n, Object o) throws RemoteException;
    
    /**
     * Method which checks the type of the parameter and returns its creator.
     * 
     * @param o - Beitrag, Kommentar, Like or Pinnwand is needed for determination.
     * @return Returns the Nutzer object which is referenced in the parameters nutzerID.
     * @throws java.rmi.RemoteException
     */
    public Nutzer getNutzerOf (Object o) throws RemoteException;
    
    /**
     * Checks if a Beitrag is already liked by a Nutzer
     * @param n - the Nutzer
     * @param b - the Beitrag
     * @return true or false
     * @throws java.rmi.RemoteException
     */
    public Boolean isAlreadyLiked(Nutzer n, Beitrag b) throws RemoteException;
    
    /**
     * Checks if a Pinnwand is already booked by a Nutzer
     * @param n - the Nutzer
     * @param p - the Pinnwand
     * @return true or false
     * @throws java.rmi.RemoteException 
     */
    public Boolean isAlreadyBooked(Nutzer n, Pinnwand p) throws RemoteException;
    
    /**
     * Gets the Like a Nutzer has given to a Beitrag
     * @param n - the Nutzer
     * @param b - the Beitrag
     * @return the Like-reference
     * @throws RemoteException 
     */
    public Like getUserLike(Nutzer n, Beitrag b) throws RemoteException;
    
    /**
     * Gets the Abonnement of the Pinnwand a Nutzer has booked
     * @param n - the Nutzer
     * @param p - the Pinnwand
     * @return the Abonnement-refernce
     * @throws RemoteException 
     */
    public Abonnement getPinnwandAbonnement(Nutzer n, Pinnwand p) throws RemoteException;
    
}

