/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Report;

import java.rmi.RemoteException;
import java.util.Vector;

/**
 * @todo Kommentierung
 * @author Sebastian
 */
public interface Row extends java.rmi.Remote{

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.DE4ECE83-B96C-13F7-DB39-D5DAEFB369D6]
    // </editor-fold>

    /**
     *
     * @param val
     * @throws RemoteException
     */
        void addColumn(Column val) throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.9068B6F7-E740-E58A-95F9-3A4D6AE48FE8]
    // </editor-fold>

    /**
     *
     * @param val
     * @return
     * @throws RemoteException
     */
        Column getColumnAt(int val) throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.870405DC-42B3-FD8B-4CFB-001C2E10EA37]
    // </editor-fold>

    /**
     *
     * @return
     * @throws RemoteException
     */
        Vector<Column> getColumns() throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.68E6EBFF-642C-1041-2BEF-7F8120FEBC96]
    // </editor-fold>

    /**
     *
     * @return
     * @throws RemoteException
     */
        int getNumOfColumn() throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.6B02D72D-45F3-48C0-D580-3E7BBA4FEAD8]
    // </editor-fold>

    /**
     *
     * @param val
     * @throws RemoteException
     */
        void removeColumn(Column val) throws RemoteException;  
}
