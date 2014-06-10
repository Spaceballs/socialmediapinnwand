package SocialMedia_Report;

import java.rmi.RemoteException;
import java.util.Vector;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.03A706A7-BD75-826A-E738-004CC4DB3C59]
// </editor-fold> 

/**
 *
 * @author Sebastian
 */
public class RowImpl extends java.rmi.server.UnicastRemoteObject implements Row{

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.87B7D440-CC12-4BCB-8CD3-A5E2A8E2F594]
    // </editor-fold>
    /*
     * @throws java.rmi.RemoteException
     */
    private Vector<Column> mColumn = new Vector<Column>();
    
    public RowImpl() 
            throws RemoteException{
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.870405DC-42B3-FD8B-4CFB-001C2E10EA37]
    // </editor-fold>
    /*
     * @throws java.rmi.RemoteException
     */
    public Vector<Column> getColumns () 
            throws RemoteException{
        return mColumn;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.DE4ECE83-B96C-13F7-DB39-D5DAEFB369D6]
    // </editor-fold>
    /*
     * @throws java.rmi.RemoteException
     */
    public void addColumn (Column val) 
            throws RemoteException{
        mColumn.add(val);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6B02D72D-45F3-48C0-D580-3E7BBA4FEAD8]
    // </editor-fold>
    /*
     * @throws java.rmi.RemoteException
     */
    public void removeColumn (Column val) 
            throws RemoteException{
        mColumn.remove(val);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.68E6EBFF-642C-1041-2BEF-7F8120FEBC96]
    // </editor-fold>
    /*
     * @throws java.rmi.RemoteException
     */
    public int getNumOfColumn () 
            throws RemoteException{
        return mColumn.size();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9068B6F7-E740-E58A-95F9-3A4D6AE48FE8]
    // </editor-fold>
    /**
     *
     * @param val - needs an int value to be set
     * @return
     * @throws java.rmi.RemoteException
     */
    public Column getColumnAt (int val) 
            throws RemoteException{
        return mColumn.get(val);
    }
}

