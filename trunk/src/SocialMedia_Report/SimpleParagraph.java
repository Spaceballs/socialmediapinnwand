/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Report;

import java.rmi.RemoteException;

/**
 * @todo Kommentierung
 * @author Sebastian
 */
public interface SimpleParagraph extends Paragraph{

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.ABD5A780-991F-8EB7-9901-2929A1CBA75D]
    // </editor-fold>
    String getText() throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.D0033BDC-E2EA-54A4-4419-6C910255DDE4]
    // </editor-fold>
    void setText(String val) throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.193B4D3C-F228-B112-FBD8-4CE55F239E30]
    // </editor-fold>
    
    /**
     *
     * @return
     * @throws RemoteException
     */
    String toStrings() throws RemoteException;
}
