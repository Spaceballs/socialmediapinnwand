
package SocialMedia_Report;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.Vector;

/**
 * Interface class of a Report
 * @author Sebastian
 */
public interface Report extends java.rmi.Remote{

    /**
     * Getter for the BodyParagraph
     * @return a bodyParagraph
     * @throws java.rmi.RemoteException
     */
    Paragraph getBodyParagraph() 
            throws RemoteException;

    /**
     * Getter for the creationDate
     * @return the creationDate of the Report
     * @throws java.rmi.RemoteException
     */
    Date getCreationDate() 
            throws RemoteException;

    /**
     * Getter for the endDate
     * @return endDate of the Report
     * @throws java.rmi.RemoteException
     */
    Date getEndDate() 
            throws RemoteException;

    /**
     * Getter for the Header and TitleParagraph
     * @return the headerAndTitleParagraph
     * @throws java.rmi.RemoteException
     */
    Paragraph getHeaderAndTitleParagraph() 
            throws RemoteException;

    /**
     * Getter for the ImprintParagraph
     * @return imprintParagraph
     * @throws java.rmi.RemoteException
     */
    Paragraph getImprintParagraph() 
            throws RemoteException;

    /**
     * Getter for Rows
     * @return Vector of Rows
     * @throws java.rmi.RemoteException
     */
    Vector<Row> getRows() 
            throws RemoteException;

    /**
     * getter for the startDate
     * @return the startDate of the Report
     * @throws java.rmi.RemoteException
     */
    Date getStartDate() 
            throws RemoteException;

    /**
     * Setter for the BodyParagraph
     * @param bodyParagraph - a Paragraph
     * @throws java.rmi.RemoteException
     */
    void setBodyParagraph(Paragraph bodyParagraph) 
            throws RemoteException;

    /**
     * Setter for the creationDate
     * @param creationDate of the Report
     * @throws java.rmi.RemoteException
     */
    void setCreationDate(Date creationDate) 
            throws RemoteException;

    /**
     * Setter for the endDate
     * @param endDate of the Report
     * @throws java.rmi.RemoteException
     */
    void setEndDate(Date endDate) 
            throws RemoteException;

    /**
     * Setter for the Header and TitleParagraph
     * @param headerAndTitleParagraph - a Paragraph
     * @throws java.rmi.RemoteException
     */
    void setHeaderAndTitleParagraph(Paragraph headerAndTitleParagraph) 
            throws RemoteException;

    /**
     * Setter for the ImprintParagraph
     * @param imprintParagraph - a Paragraph
     * @throws java.rmi.RemoteException
     */
    void setImprintParagraph(Paragraph imprintParagraph) 
            throws RemoteException;

    /**
     * Setter for Rows
     * @param rows - a Vector of Rows
     * @throws java.rmi.RemoteException
     */
    void setRows(Vector<Row> rows) 
            throws RemoteException;

    /**
     * Setter of the startDate
     * @param startDate of the Report
     * @throws java.rmi.RemoteException
     */
    void setStartDate(Date startDate) 
            throws RemoteException;
    
}
