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
public interface Report extends java.rmi.Remote{

    Paragraph getBodyParagraph() 
            throws RemoteException;

    Date getCreationDate() 
            throws RemoteException;

    Date getEndDate() 
            throws RemoteException;

    Paragraph getHeaderAndTitleParagraph() 
            throws RemoteException;

    Paragraph getImprintParagraph() 
            throws RemoteException;

    Vector<Row> getRows() 
            throws RemoteException;

    Date getStartDate() 
            throws RemoteException;

    void setBodyParagraph(Paragraph bodyParagraph) 
            throws RemoteException;

    void setCreationDate(Date creationDate) 
            throws RemoteException;

    void setEndDate(Date endDate) 
            throws RemoteException;

    void setHeaderAndTitleParagraph(Paragraph headerAndTitleParagraph) 
            throws RemoteException;

    void setImprintParagraph(Paragraph imprintParagraph) 
            throws RemoteException;

    void setRows(Vector<Row> rows) 
            throws RemoteException;

    void setStartDate(Date startDate) 
            throws RemoteException;
    
}
