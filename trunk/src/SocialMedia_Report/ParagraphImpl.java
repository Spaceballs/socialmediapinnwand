
package SocialMedia_Report;

import java.rmi.RemoteException;

/**
 * Implementation of the abstract class for Paragraph
 * @author Sebastian Fink
 */
public abstract class ParagraphImpl extends java.rmi.server.UnicastRemoteObject implements Paragraph{

    /**
     * Contructor for the class
     * @throws RemoteException
     */
    public ParagraphImpl () throws RemoteException{
        super();
    }
}
