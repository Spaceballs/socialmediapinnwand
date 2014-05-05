package SocialMedia_DatabaseManager;

import SocialMedia_Data.Pinnwand; 
import SocialMedia_Data.PinnwandImpl;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.809BAA32-7AD0-879C-5114-FA1EA1C519CF]
// </editor-fold> 
/**
 * Class for mapping PinnwandImpl objects onto a sql database.
 * 
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
     * Constructor of the PinnwanndMapper class.
     */
    public PinnwandMapper () {
    }

    /**
     * Singleton class of the mapper class. Either generates a new 
     * PinnwandMapper or returns the already generated Mapper Object
     * @return PinnwandMapper - Returns the PinnwandMapper Object.
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
     * Insert method of the Pinnwand mapper for the PinnwandImpl objects.
     * 
     * 
     * @param val - Needs a Pinnwand object without an id.
     * @return Pinnwand - Returns the inserted object with the generated id.
     */
    public Pinnwand insert (Pinnwand val) {
        Connection con = DBConnection.connection();
        try {
            Timestamp t = new Timestamp(val.getCreationDate().getTime());
            con.createStatement().executeUpdate(
                    INSERT_INTO + " " +
                    TABLE_NAME_PINNWAND + " ( " +
                            COLUMN_CREATION_DATE + ", " + 
                            COLUMN_NUTZER_ID + " ) " +
                    VALUES + " ( " + 
                            "\"" + t + "\"" + " , " + 
                            "\"" + val.getNutzerID() + "\"" + " )");
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    SELECT + " " + 
                            COLUMN_ID + " " + 
                    FROM  + " " + 
                            TABLE_NAME_PINNWAND  + " " + 
                    ORDER_BY_ID_DESC_STATEMENT_OPTION + " " + 
                    LIMIT_STATEMENT_OPTION + " " + "1");
            if (resultSet.next())
                val.setID((resultSet.getInt(COLUMN_ID)));
        } catch (SQLException ex) {
            Logger.getLogger(PinnwandMapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(PinnwandMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.98581B02-63DA-4E99-816E-9EF2B4A8E4F6]
    // </editor-fold> 
    /**
     * Update method of the Pinnwand mapper updates object by id.
     * 
     * 
     * @param val - Needs an Pinnwand object with a id.
     * @return Pinnwand - Returns the updated objects.
     */
    public Pinnwand update (Pinnwand val) {
        Connection con = DBConnection.connection();
        try {
            Timestamp t = new Timestamp(val.getCreationDate().getTime());
            con.createStatement().executeUpdate(
                    UPDATE + " " +
                            TABLE_NAME_PINNWAND + " " +
                    SET + " " +
                            COLUMN_CREATION_DATE + " =\"" + t + "\"" + ", " +
                            COLUMN_NUTZER_ID + " =\"" + val.getNutzerID() + "\""  + ", " +
                    WHERE + " " +
                    COLUMN_ID + " = " + val.getID());
        } catch (SQLException ex) {
            Logger.getLogger(PinnwandMapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(PinnwandMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D2D130AD-8E74-FA70-FC5F-60094E0B198C]
    // </editor-fold> 
    /**
     * Deletes the given Pinnwand from the sql table by id.
     * 
     * 
     * @param val Pinnwand to be deleted.
     */
    public void delete (Pinnwand val) {
        Connection con = DBConnection.connection();
        try {
            con.createStatement().executeUpdate(
                    DELETE + " " +
                    FROM + " " +
                            TABLE_NAME_ABONNEMENT + " " +
                    WHERE + " " +
                            COLUMN_ID + " =\"" + val.getID() + "\"");
        } catch (SQLException ex) {
            Logger.getLogger(PinnwandMapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(PinnwandMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.FB59E1FB-D7D9-B9DA-BC04-2EFEC34E9A73]
    // </editor-fold> 
    /**
     * Method to read every entry in the Pinnwand table.
     * 
     * 
     * @return Vector<Pinnwand> - Returns all the entrys in the sql table
     */
    public Vector<Pinnwand> getAll () {
        Connection con = DBConnection.connection();
        Vector<Pinnwand> pinnwaende = new Vector<Pinnwand>();
        try {
            ResultSet resultSet = con.createStatement().executeQuery(
                SELECT + " " +
                        COLUMN_ID + ", " + 
                        COLUMN_CREATION_DATE + ", " + 
                        COLUMN_NUTZER_ID + " " + 
                FROM + " " +
                        TABLE_NAME_PINNWAND + " " +
                ORDER_BY_ID_STATEMENT_OPTION);
            while (resultSet.next()) {
                try {
                    Pinnwand pinnwand = new PinnwandImpl();
                    pinnwand.setID(resultSet.getInt(COLUMN_ID));
                    pinnwand.setCreationDate(resultSet.getTimestamp(COLUMN_CREATION_DATE));
                    pinnwand.setNutzerID(resultSet.getInt(COLUMN_NUTZER_ID) );
                    pinnwaende.addElement(pinnwand);
                }
                catch(SQLException e) {
                    Logger.getLogger(PinnwandMapper.class.getName()).log(Level.SEVERE, null, e);
                    break;
                } catch (RemoteException ex) {
                    Logger.getLogger(PinnwandMapper.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(PinnwandMapper.class.getName()).log(Level.SEVERE, null, e);
        }
        return pinnwaende;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C0658A8A-FA2D-12E1-4BCA-21F0FDF7D437]
    // </editor-fold> 
    /**
    public Pinnwand findByID () {
        Connection con = DBConnection.connection();
        return null;
    }
    */
}

