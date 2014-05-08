/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Report;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author Sebastian
 */
public interface Report extends java.rmi.Remote {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.88FBC6E4-CD3B-4E19-1904-6B13A7DF387D]
    // </editor-fold>
    /**
     *
     * @param val
     * @throws java.rmi.RemoteException
     */
    public void addRow(Row val) throws RemoteException;

    /**
     *
     * @return
     * @throws java.rmi.RemoteException
     */
    public Vector<Paragraph> getAllParagraphs() throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.C4845CAD-6489-79E9-8793-09FBE313D345]
    // </editor-fold>
    /**
     *
     * @return
     * @throws java.rmi.RemoteException
     */
    public Vector<Row> getAllRows() throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.736AE163-DD52-AE45-73DA-F720D296BEBF]
    // </editor-fold>
    /**
     *
     * @return
     * @throws java.rmi.RemoteException
     */
    public Date getCreationDate() throws RemoteException;

    /**
     *
     * @return
     * @throws java.rmi.RemoteException
     */
    public Date getEndDate() throws RemoteException;

    /**
     *
     * @return
     * @throws java.rmi.RemoteException
     */
    public String getImprint() throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.71D76669-894D-09DE-8726-1490EAAF6F4C]
    // </editor-fold>
    /**
     *
     * @return
     * @throws java.rmi.RemoteException
     */
    public String getReportTitle() throws RemoteException;

    /**
     *
     * @return
     * @throws java.rmi.RemoteException
     */
    public Date getStartDate() throws RemoteException;

    /**
     *
     * @param Paragraph
     * @throws java.rmi.RemoteException
     */
    public void removeParagraph(Paragraph Paragraph) throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.6B817044-83CA-F739-4038-CAB9BC5D19F9]
    // </editor-fold>
    /**
     *
     * @param val
     * @throws java.rmi.RemoteException
     */
    public void removeRow(Row val) throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.DF9B67FA-09D6-BC6D-AFAD-6C11C9D79470]
    // </editor-fold>
    /**
     *
     * @param val
     * @throws java.rmi.RemoteException
     */
    public void setCreationDate(Date val) throws RemoteException;

    /**
     *
     * @param endDate
     * @throws java.rmi.RemoteException
     */
    public void setEndDate(Date endDate) throws RemoteException;

    /**
     *
     * @param imprint
     * @throws java.rmi.RemoteException
     */
    public void setImprint(String imprint) throws RemoteException;

    /**
     *
     * @param Paragraph
     * @throws java.rmi.RemoteException
     */
    public void setParagraph(Paragraph Paragraph) throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.2825BBE1-A6B3-F481-3693-EE16A3B47B0C]
    // </editor-fold>
    /**
     *
     * @param val
     * @throws java.rmi.RemoteException
     */
    public void setReportTitle(String val) throws RemoteException;

    /**
     *
     * @param startDate
     * @throws java.rmi.RemoteException
     */
    public void setStartDate(Date startDate) throws RemoteException;
    
}
