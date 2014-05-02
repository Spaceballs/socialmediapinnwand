package SocialMedia_DatabaseManager;

import SocialMedia_Data.Pinnwand; 
import SocialMedia_Data.PinnwandImpl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.809BAA32-7AD0-879C-5114-FA1EA1C519CF]
// </editor-fold> 
/**
 * 
 * @author Sebastian
 */
public class PinnwandMapper extends DBStatementFactory{

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
        try {
            con.createStatement().executeQuery(
                    DELETE + " " +
                    FROM + " " +
                    TABLE_NAME_KOMMENTAR + " " +
                    WHERE + " " +
                    COLUMN_ID + "=" + "`" + val.getID() + "`" + " " +
                    COLUMN_CREATION_DATE + "=" + "`" + val.getCreationDate() + "`" + " " +
                    COLUMN_NUTZER_ID + "=" + "`" + val.getNutzerID() + "`" + " " +
                    ORDER_BY_ID_STATEMENT_OPTION);
        } catch (SQLException ex) {
            Logger.getLogger(AbonnementMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        Vector<Pinnwand> pinnwaende = new Vector<Pinnwand>();
        try {
            ResultSet resultSet = con.createStatement().executeQuery(
                    SELECT + " " +
                    COLUMN_ID + ", " + COLUMN_CREATION_DATE + ", " + COLUMN_NUTZER_ID + " " +
                    FROM + " " +
                    TABLE_NAME_PINNWAND + " " +
                    ORDER_BY_ID_STATEMENT_OPTION);
            while (resultSet.next()) {
                try {
                    Pinnwand pinnwand = new PinnwandImpl();
                    pinnwand.setID(resultSet.getInt(COLUMN_ID));
                    pinnwand.setCreationDate(resultSet.getDate(COLUMN_CREATION_DATE));
                    pinnwand.setNutzerID(resultSet.getInt(COLUMN_NUTZER_ID));
                    pinnwaende.addElement(pinnwand);
                } catch (SQLException e) {
                    e.printStackTrace();
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pinnwaende;
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

