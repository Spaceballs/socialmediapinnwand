
package SocialMedia_Report;

import java.rmi.RemoteException;
import java.util.Vector;

/**
 * Interface class for the Row and Column structure
 * @author Sebastian
 */
public interface Row extends java.rmi.Remote{

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.DE4ECE83-B96C-13F7-DB39-D5DAEFB369D6]
    // </editor-fold>

    /**
     * Adds a Column to the Vector
     * @param val - a Column
     * @throws RemoteException 
     */
    void addColumn(Column val) throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.9068B6F7-E740-E58A-95F9-3A4D6AE48FE8]
    // </editor-fold>

    /**
     * Gets the Column at a certain index
     * @param val - the index
     * @return - the Column at the index
     * @throws RemoteException 
     */
    Column getColumnAt(int val) throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.870405DC-42B3-FD8B-4CFB-001C2E10EA37]
    // </editor-fold>

    /**
     * Getter for the Columns
     * @return Vector of Columns
     * @throws RemoteException 
     */
    Vector<Column> getColumns() throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.68E6EBFF-642C-1041-2BEF-7F8120FEBC96]
    // </editor-fold>

    /**
     * Gets the Number of Columns in the Vector
     * @return the number of Columns in Integer
     * @throws RemoteException 
     */
    int getNumOfColumn() throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.6B02D72D-45F3-48C0-D580-3E7BBA4FEAD8]
    // </editor-fold>

    /**
     * Removes a Column from the Vector
     * @param val - a Column
     * @throws RemoteException 
     */
    void removeColumn(Column val) throws RemoteException;  
}
