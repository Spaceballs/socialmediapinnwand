/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Data;

import java.rmi.RemoteException;
import java.util.Date;

/**
 * Class for handling all IDs and creationDates
 * @author Sebastian
 */
public interface DataReference extends java.rmi.Remote{

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.4BCCE1AB-78B5-AA3C-932B-883E5D1775B5]
    // </editor-fold>
    /**
     * Getter for the CreationDate attribute.
     * @return Date
     * @throws java.rmi.RemoteException
     */
    Date getCreationDate()
            throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.FCABA384-0469-0962-060E-28BE0D0E7C82]
    // </editor-fold>
    /**
     * Getter for the ID attribute.
     * @return int
     * @throws java.rmi.RemoteException
     */
    int getID()
            throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.86FD70C6-270D-42C5-EFB5-AB6602CF95B1]
    // </editor-fold>
    /**
     * Setter for the CreationDate attribute.
     * @param val
     * @throws java.rmi.RemoteException
     */
    void setCreationDate(Date val)
            throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.FDCE10AB-E236-B3C7-2407-6A09EA4717F4]
    // </editor-fold>
    /**
     * Setter for the ID attribute.
     * @param val
     * @throws java.rmi.RemoteException
     */
    void setID(int val)
            throws RemoteException;
    
}
