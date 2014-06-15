package SocialMedia_Data;
// #[regen=yes,id=DCE.EDC6A4F4-9793-6127-38E0-93F94550207C]
// </editor-fold> 

import SocialMedia_Logic.SocialMediaLogicImpl;
import java.rmi.RemoteException;

/**
 * Interface class for Like
 * @author Sebastian
 */
public interface Like extends DataReference {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A88DC027-D2F0-D6F5-ECB1-4A7220FAA7DC]
    // </editor-fold> 
    /**
     * Getter for the BeitragID attribute.
     * @return Integer - Returns the int ID of the object. 
     * @throws java.rmi.RemoteException 
     */
    public int getBeitragID ()
            throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D760514B-38E6-75B8-5C57-E4BA4FAC3470]
    // </editor-fold> 
    /**
     * Setter for the BeitragID attribute.
     * @param val - Needs an int ID to be set.
     * @throws java.rmi.RemoteException 
     */
    public void setBeitragID (int val)
            throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.66E08099-C5B7-4506-F5DA-E8F82BABB84C]
    // </editor-fold> 
    /**
     * Getter for the NutzerID attribute.
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public int getNutzerID ()
            throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D0B082B6-C9BE-1FCD-A313-D22D5D132062]
    // </editor-fold> 
    /**
     * Setter for the NutzerID attribute.
     * @param val 
     * @throws java.rmi.RemoteException 
     */
    public void setNutzerID (int val)
            throws RemoteException;
    
    /**
     * Gets the Nutzer by the nutzerID
     * @param verwaltung - This object is needed for getting data from the DB.
     * @return - Returns the nutzer object. 
     * @throws RemoteException 
     */
    public Nutzer getOwner (SocialMediaLogicImpl verwaltung) 
            throws RemoteException;

}

