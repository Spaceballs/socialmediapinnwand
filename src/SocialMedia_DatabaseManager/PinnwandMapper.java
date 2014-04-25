package SocialMedia_DatabaseManager;

import SocialMedia_Data.Pinnwand; 
import java.sql.Connection;
import java.util.Vector;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.809BAA32-7AD0-879C-5114-FA1EA1C519CF]
// </editor-fold> 
/**
 * 
 * @author Sebastian
 */
public class PinnwandMapper {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4E26FF35-0885-BDAD-492B-10424F0BBB35]
    // </editor-fold> 
    private static PinnwandMapper pinnwandMapper = null;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0AB0C381-AC32-1B92-6B6A-A2C563F7DC21]
    // </editor-fold> 
    /**
     * 
     */
    public PinnwandMapper () {
    }

    /**
     * 
     * @return 
     */
    public static PinnwandMapper pinnwandMapper(){
        if (pinnwandMapper == null) {
            pinnwandMapper = new PinnwandMapper();
        }
        return pinnwandMapper;
    }


    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.91B9B9C7-88E3-E831-1662-6E60F7095367]
    // </editor-fold> 
    /**
     * 
     * @param val
     * @return 
     */
    public Pinnwand insert (Pinnwand val) {
        Connection con = DBConnection.connection();
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.98581B02-63DA-4E99-816E-9EF2B4A8E4F6]
    // </editor-fold> 
    /**
     * 
     * @param val
     * @return 
     */
    public Pinnwand update (Pinnwand val) {
        Connection con = DBConnection.connection();
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D2D130AD-8E74-FA70-FC5F-60094E0B198C]
    // </editor-fold> 
    /**
     * 
     * @param val 
     */
    public void delete (Pinnwand val) {
        Connection con = DBConnection.connection();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.FB59E1FB-D7D9-B9DA-BC04-2EFEC34E9A73]
    // </editor-fold> 
    /**
     * 
     * @return 
     */
    public Vector<Pinnwand> getAll () {
        Connection con = DBConnection.connection();
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C0658A8A-FA2D-12E1-4BCA-21F0FDF7D437]
    // </editor-fold> 
    /**
     * 
     * @return 
     */
    public Pinnwand findByID () {
        Connection con = DBConnection.connection();
        return null;
    }

}

