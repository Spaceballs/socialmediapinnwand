
package SocialMedia_Data;

import SocialMedia_Logic.SocialMediaLogicImpl;
import java.rmi.RemoteException;

/**
 * Interface class of UserGeneratedContent
 * @author Sebastian
 */
public interface UserCreatedContent extends DataReference{

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.09AA971C-CC81-7A33-68D2-9D93A9D48B66]
    // </editor-fold>
    /**
     * Getter for the NutzerID attribute.
     * @return Integer - Returns the int ID of the object.
     * @throws java.rmi.RemoteException 
     */
    int getNutzerID()
            throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.0A75001D-1A8F-9B66-7C7A-A84D8D309A09]
    // </editor-fold>
    /**
     * Getter for the Text attribute.
     * @throws java.rmi.RemoteException
     * @return String - Returns a string of the object.
     */
    String getText()
            throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.4C3FF8B3-5DDD-8FA9-21F4-D9B3320848A8]
    // </editor-fold>
    /**
     * Setter for the NutzerID attribute.
     * @param val - Needs an int ID to be set.
     * @throws java.rmi.RemoteException 
     */
    void setNutzerID(int val)
            throws RemoteException;
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.3084509D-FA6D-C60E-74B5-268CF2D5817F]
    // </editor-fold>
    /**
     * Setter for the Text attribute.
     * @param val - Needs a string to be set.
     * @throws java.rmi.RemoteException 
     */
    void setText(String val)
            throws RemoteException;
    
    /**
     * Gets Nutzer by NutzerID
     * @param verwaltung - This object is needed for getting data from the DB.
     * @throws java.rmi.RemoteException
     * @return - Returns the Nutzer object.
     */
    public Nutzer getOwner (SocialMediaLogicImpl verwaltung) 
            throws RemoteException;
    
}
