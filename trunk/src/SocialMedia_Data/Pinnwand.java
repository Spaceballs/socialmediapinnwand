package SocialMedia_Data;

import SocialMedia_Logic.SocialMediaLogicImpl;
import java.rmi.RemoteException;
import java.util.Vector;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.A573FCE8-0C7C-85E2-81F5-BD4F7AE55AF6]
// </editor-fold> 
public interface Pinnwand extends DataReference{

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9A113161-9549-A226-EBD6-6C10C1599BB1]
    // </editor-fold> 
        /**
     * Getter for the NutzerID attribute.
     * @throws RemoteException 
     * @return Integer - Returns the int ID of the object.
     */
    public int getNutzerID ()
            throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B638B2FD-144C-3974-C959-2CE811B56263]
    // </editor-fold> 
    /**
     * Setter for the Nutzer ID attribute.
     * @param val - Needs an int ID to be set.
     * @throws RemoteException 
     */
    public void setNutzerID (int val)
            throws RemoteException;
    /**
     * Gets all PinnwandBeitraege of the PinnwandID.
     * @param verwaltung - This object is needed for getting data from the DB.
     * @return - Returns all Beiträge of the Pinnwand.
     * @throws RemoteException 
     */
    
    public Vector<Beitrag> getAllPinnwandBeitraege (SocialMediaLogicImpl verwaltung)
            throws RemoteException;
    /**
     * Gets all Nutzer and compares with the chosen ID.
     * @param verwaltung - This object is needed for getting data from the DB.
     * @return - Returns the nutzer object.
     * @throws RemoteException 
     */

    public Nutzer getOwner (SocialMediaLogicImpl verwaltung)
            throws RemoteException;
    /**
     * Gets all <code>Abonnements</code> which reference this <code>Pinnwand</code>-instance
     * @param verwaltung - This object is needed for getting data from the DB.
     * @return - returns all referenced <code>Abonnements</code>
     * @throws RemoteException
     */
    
     public Vector<Abonnement> getAllAbonnementsOfPinnwand (SocialMediaLogicImpl verwaltung)
            throws RemoteException;

}

