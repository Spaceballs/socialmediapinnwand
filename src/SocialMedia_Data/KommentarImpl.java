package SocialMedia_Data;
// #[regen=yes,id=DCE.67A3AF12-C93F-4EF2-3E3E-0535912403EA]
// </editor-fold> 

import java.rmi.RemoteException;

/**
 * Implementation class for Kommentar
 * @author Sebastian
 */
public class KommentarImpl extends UserCreatedContentImpl implements Kommentar {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1B5C65AC-4661-2119-4797-0DE063CFD256]
    // </editor-fold> 
    private int beitragID;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F298D0BE-9649-8BB0-3B54-FBD7D203EFBB]
    // </editor-fold> 
    /**
     * Constructor of the class
     * @throws java.rmi.RemoteException
     */
    public KommentarImpl () 
            throws RemoteException{
        super();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B74E178E-1D04-F219-F66B-C4E5E6A9994E]
    // </editor-fold> 
    /**
     * Getter for the BeitragID attribute.
     * @return Integer - Returns the int ID of the object.
     * @throws java.rmi.RemoteException 
     */
    public int getBeitragID () 
            throws RemoteException{
        return beitragID;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.DC731636-254D-A471-997E-0123D0DC0144]
    // </editor-fold> 
    /**
     * Setter for the BeitragID attribute.
     * @param val - Needs an int ID to be set.
     * @throws java.rmi.RemoteException 
     */
    public void setBeitragID (int val) 
            throws RemoteException{
        this.beitragID = val;
    }
}

