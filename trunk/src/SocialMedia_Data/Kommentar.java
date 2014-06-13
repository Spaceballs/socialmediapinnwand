package SocialMedia_Data;
// #[regen=yes,id=DCE.8BE01692-36F5-5611-7B84-F21BF99A667B]
// </editor-fold> 

import java.rmi.RemoteException;

/**
 * 
 * @author Sebastian
 */
public interface Kommentar extends UserCreatedContent {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.39717E0E-C847-C40A-D332-2D62777C400B]
    // </editor-fold> 
    /**
     * Getter for the BeitragID attribute.
     * @return Integer - Returns the int ID of the object.
     * @throws RemoteException 
     */
    public int getBeitragID ()
            throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4B410CC2-7B33-490B-B7D3-AD8FFD533CC8]
    // </editor-fold> 
    /**
     * Setter for the BeitragID attribute.
     * @param val - Needs an int ID to be set
     * @throws java.rmi.RemoteException 
     */
    public void setBeitragID (int val)
            throws RemoteException;
}

