
package SocialMedia_Data;

import SocialMedia_Logic.SocialMediaLogicImpl;
import java.rmi.RemoteException;
import java.util.Vector;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.47B4081F-641D-CF5F-7507-4246F9B5F87B]
// </editor-fold> 
/**
 * Implementation class of Pinnwand
 * @author Sebastian
 */
public class PinnwandImpl extends DataReferenceImpl implements Pinnwand {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F8ED24B1-434A-1BB8-CA16-4BFE06D95567]
    // </editor-fold> 
    private int nutzerID;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.72DCC317-149D-B9E4-6A3B-717A3374A9CA]
    // </editor-fold> 
    /**
     * Constructor of the class
     * @throws RemoteException 
     */
    public PinnwandImpl () 
            throws RemoteException{
        super();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.9C4291DD-740E-D30A-3764-2DC928A81FA5]
    // </editor-fold> 
    /**
     * Getter for the NutzerID attribute.
     * @throws RemoteException 
     * @return Integer - Returns the int ID of the object.
     */
    public int getNutzerID () 
            throws RemoteException{
        return nutzerID;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.44707E22-5B0D-70BB-F963-9CA705705444]
    // </editor-fold> 
    /**
     * Setter for the Nutzer ID attribute.
     * @param val - Needs an int ID to be set.
     * @throws RemoteException 
     */
    public void setNutzerID (int val) 
            throws RemoteException{
        this.nutzerID = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1C5670FC-1942-4082-13A2-408A385BBDAB]
    // </editor-fold> 
    /**
     * Gets all Beitraege of a Pinnwand
     * @param verwaltung - This object is needed for getting data from the DB.
     * @return - Returns all Beiträge of the Pinnwand.
     * @throws RemoteException 
     */
    public Vector<Beitrag> getAllPinnwandBeitraege (SocialMediaLogicImpl verwaltung) 
            throws RemoteException{
        Vector<Beitrag> beitraege = verwaltung.getAllBeitrag();
        Vector<Beitrag> pinnwandBeitraege = new Vector<Beitrag>();
        for (int i = 0; i < beitraege.size(); i++) {
            Beitrag beitrag = beitraege.elementAt(i);
            if(beitrag.getPinnwandID() == this.getID())
                pinnwandBeitraege.addElement(beitrag);
        }
        return pinnwandBeitraege;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A095AC40-10D1-77A9-0A67-2D41CC05B201]
    // </editor-fold> 
    /**
     * Gets Nutzer by nutzerID.
     * @param verwaltung - This object is needed for getting data from the DB.
     * @return - Returns the nutzer object.
     * @throws RemoteException 
     */
    public Nutzer getOwner (SocialMediaLogicImpl verwaltung) 
            throws RemoteException{
        return verwaltung.getNutzerByID(nutzerID);
    }
    
    /**
     * Gets all <code>Abonnements</code> which reference this <code>Pinnwand</code>-instance
     * @param verwaltung - This object is needed for getting data from the DB.
     * @return - returns all referenced <code>Abonnements</code>
     * @throws RemoteException
     */
    public Vector<Abonnement> getAllAbonnementsOfPinnwand (SocialMediaLogicImpl verwaltung)
            throws RemoteException {
        Vector<Abonnement> abonnements = verwaltung.getAllAbonnement();
        Vector<Abonnement> abonnementsResult = new Vector<Abonnement>();
        for (int i = 0; i < abonnements.size(); i++) {
            Abonnement abonnement = abonnements.elementAt(i);
            if(abonnement.getPinnwandID() == this.getID())
                abonnementsResult.add(abonnement);
        }
        return abonnementsResult;
    }
}

