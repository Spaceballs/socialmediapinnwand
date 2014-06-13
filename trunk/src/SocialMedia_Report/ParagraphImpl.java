/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Report;

import java.rmi.RemoteException;

/**
 * @todo Kommentierung
 * @author Sebastian Fink
 */
public abstract class ParagraphImpl extends java.rmi.server.UnicastRemoteObject implements Paragraph{

    /**
     *
     * @throws RemoteException
     */
    public ParagraphImpl () throws RemoteException{
        super();
    }
}
