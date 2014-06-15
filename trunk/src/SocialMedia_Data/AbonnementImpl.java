package SocialMedia_Data;

import SocialMedia_Logic.SocialMediaLogicImpl;
import java.rmi.RemoteException;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.D34739A1-3E6D-6B19-CAA4-1E4A754FEA92]
// </editor-fold> 
/**
 * Implementation class for Abonnement
 * @author Sebastian
 */
public class AbonnementImpl extends DataReferenceImpl implements Abonnement {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.332F54F4-F850-3FBE-B548-28DCCA1F4A8E]
    // </editor-fold> 
    private int pinnwandID;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3C60E566-06C4-999C-088C-A31EE76C9AC2]
    // </editor-fold> 
    private int nutzerID;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9A023376-AEF4-0492-69FC-D772039EAC98]
    // </editor-fold> 
    /**
     * Constructor
     * @throws java.rmi.RemoteException
     */
    public AbonnementImpl () 
            throws RemoteException{
        super();
    }
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.34CD4721-4808-AC12-AB06-15C640C1C70A]
    // </editor-fold> 
    /**
     * Getter for the NutzerID attribute.
     * @throws java.rmi.RemoteException
     * @return Integer - Returns the int ID of the object.
     */
    public int getNutzerID () 
            throws RemoteException{
        return nutzerID;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.8D1AACC7-2B0D-F458-8544-FC736F4D62B6]
    // </editor-fold> 
    /**
     * Setter for the NutzerID attribute.
     * @throws java.rmi.RemoteException
     * @param val - Needs an int ID to be set.
     */
    public void setNutzerID (int val) 
            throws RemoteException{
        this.nutzerID = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.DF61E533-860E-7335-9C70-C524D9188253]
    // </editor-fold> 
    /**
     * Getter for the PinnwandID attribute.
     * @throws java.rmi.RemoteException
     * @return - Returns the int ID of the object.
     */
    public int getPinnwandID () 
            throws RemoteException{
        return pinnwandID;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.7999840B-C95C-CF02-2B24-1C5DC8ACE910]
    // </editor-fold> 
    /**
     * Setter for the PinnwandID attribute.
     * @throws java.rmi.RemoteException
     * @param val - Needs an int ID to be set.
     */
    public void setPinnwandID (int val) 
            throws RemoteException{
        this.pinnwandID = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3F4ABB83-B7D5-73F1-C799-438A3E6484D4]
    // </editor-fold> 
    /**
     * Gets Pinnwand by the pinnwandID
     * @param verwaltung - This object is needed for getting data from the DB.
     * @throws java.rmi.RemoteException
     * @return - Returns the Pinnwand object.
     */
    public Pinnwand getAbonnementPinnwand (SocialMediaLogicImpl verwaltung) 
            throws RemoteException{
        return verwaltung.getPinnwandByID(pinnwandID);
    }

}

