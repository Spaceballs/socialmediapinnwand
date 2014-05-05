package SocialMedia_Data;

//import SocialMedia_DatabaseManager.Vector<Abonnement>;
import SocialMedia_Logic.SocialMediaLogicImpl;
import java.rmi.RemoteException;
import java.util.Vector;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.3553D03C-6305-B201-4A1B-DB2554E72E8D]
// </editor-fold> 
/**
 * 
 * @author Sebastian
 */
public class NutzerImpl extends DataReferenceImpl implements Nutzer {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0D00499F-FD8A-E51C-CC84-E75EC702091C]
    // </editor-fold> 
    private String username;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F324CF40-9CE2-1008-7E23-442A7AC7DC0F]
    // </editor-fold> 
    private String name;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A66A1AC2-3399-75A7-8CB1-3B3B2FF2BE4F]
    // </editor-fold> 
    private String surname;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F5A4A879-CE9B-DC68-BABB-0063578D48C7]
    // </editor-fold> 
    private String password;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.98F2AE72-D7D0-D7AC-4E04-53CF14F84A72]
    // </editor-fold> 
    /**
     * 
     * @throws java.rmi.RemoteException
     */
    public NutzerImpl () 
            throws RemoteException{
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.567D7DB3-BF90-870F-C713-BCCF4C636E5A]
    // </editor-fold> 
    /**
     * 
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public String getName () 
            throws RemoteException{
        return name;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E6DC5A45-7CF6-3E7C-3DAF-119DA22511B2]
    // </editor-fold> 
    /**
     * 
     * @param val 
     * @throws java.rmi.RemoteException 
     */
    public void setName (String val) 
            throws RemoteException{
        this.name = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.D1992486-44F1-AA40-E8AD-2FB13793AC9E]
    // </editor-fold> 
    /**
     * 
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public String getPassword () 
            throws RemoteException{
        return password;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.08A7888A-8EAF-5D9A-562D-0D2EA0E99350]
    // </editor-fold> 
    /**
     * 
     * @param val 
     * @throws java.rmi.RemoteException 
     */
    public void setPassword (String val) 
            throws RemoteException{
        this.password = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A9A9B425-7C26-9DB0-4914-F2F4B9DFEC88]
    // </editor-fold> 
    /**
     * 
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public String getSurname () 
            throws RemoteException{
        return surname;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1F77A8CC-9095-B7EC-BA42-1992AF559AC2]
    // </editor-fold> 
    /**
     * 
     * @param val 
     * @throws java.rmi.RemoteException 
     */
    public void setSurname (String val) 
            throws RemoteException{
        this.surname = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.97AE0FAE-FB1C-C535-4F41-C0409F1F0C2F]
    // </editor-fold> 
    /**
     * 
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public String getUsername () 
            throws RemoteException{
        return username;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.9C720026-A954-59B5-8742-41752CAF391E]
    // </editor-fold> 
    /**
     * 
     * @param val 
     * @throws java.rmi.RemoteException 
     */
    public void setUsername (String val) 
            throws RemoteException{
        this.username = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.EA9F8A85-2059-4E68-72FA-B23705639051]
    // </editor-fold> 
    /**
     * 
     * @param verwaltung
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public Pinnwand getNutzerPinnwand (SocialMediaLogicImpl verwaltung) 
            throws RemoteException{
        Vector<Pinnwand> pinnwaende = verwaltung.getAllPinnwand();

        for (int i = 0; i < pinnwaende.size(); i++) {
            Pinnwand pinnwand = pinnwaende.elementAt(i);
            if(pinnwand.getNutzerID() == this.getID())
                return pinnwand;
        }
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E49402FD-5DC6-2D8C-7CB5-633CA9E8C37B]
    // </editor-fold> 
    /**
     * 
     * @param verwaltung
     * @return 
     * @throws java.rmi.RemoteException 
     */
    public Vector<Abonnement> getAllNutzerAbonnement (SocialMediaLogicImpl verwaltung) 
            throws RemoteException{
        Vector<Abonnement> abonnements = verwaltung.getAllAbonnement();
        Vector<Abonnement> nutzerAbonnements = null;

        for (int i = 0; i < abonnements.size(); i++) {
            Abonnement abonnement = abonnements.elementAt(i);
            if(abonnement.getNutzerID() == this.getID())
                nutzerAbonnements.addElement(abonnement);
        }
        return nutzerAbonnements;
    }
}

