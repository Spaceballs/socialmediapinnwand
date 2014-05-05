package SocialMedia_Data;

import java.rmi.RemoteException;
import java.util.Date;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.6B973D64-CA18-01E4-0E33-4AD5ADD71973]
// </editor-fold> 
/**
 * 
 * @author Sebastian
 */
public class DataReferenceImpl extends java.rmi.server.UnicastRemoteObject implements DataReference {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E45F6BC3-9767-A2D8-6CEB-9DB94A1BEEFD]
    // </editor-fold> 
    private int ID;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.BFE77B04-E0A8-5A77-7329-26D901F9D0EC]
    // </editor-fold> 
    private Date creationDate;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E53B2245-E1F6-6A0E-54A8-36E265C8BD5F]
    // </editor-fold> 
    /**
     * 
     * @throws java.rmi.RemoteException
     */
    public DataReferenceImpl () 
            throws RemoteException{
        super();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.FCABA384-0469-0962-060E-28BE0D0E7C82]
    // </editor-fold> 
    /**
     * 
     * @return 
     */
    public int getID () 
            throws RemoteException{
        return ID;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.FDCE10AB-E236-B3C7-2407-6A09EA4717F4]
    // </editor-fold> 
    /**
     * 
     * @param val 
     */
    public void setID (int val) 
            throws RemoteException{
        this.ID = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.4BCCE1AB-78B5-AA3C-932B-883E5D1775B5]
    // </editor-fold> 
    /**
     * 
     * @return 
     */
    public Date getCreationDate () 
            throws RemoteException{
        return creationDate;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.86FD70C6-270D-42C5-EFB5-AB6602CF95B1]
    // </editor-fold> 
    /**
     * 
     * @param val 
     */
    public void setCreationDate (Date val) 
            throws RemoteException{
        this.creationDate = val;
    }
}

