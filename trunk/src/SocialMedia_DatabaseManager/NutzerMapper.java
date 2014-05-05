package SocialMedia_DatabaseManager;

import SocialMedia_Data.Nutzer;
import SocialMedia_Data.NutzerImpl;
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
// #[regen=yes,id=DCE.2A7B9558-B6D3-BDAA-C118-802F3096C4E5]
// </editor-fold> 
/**
 * Class for mapping NutzerImpl objects onto a sql database.
 * 
 * 
 * @author Sebastian
 */
public class NutzerMapper extends DBStatementFactory{

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.665FBD45-137D-BD65-2498-CA0B84C4F9F3]
    // </editor-fold> 
    private static NutzerMapper nutzerMapper = null;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.47C0FA3B-D373-5813-EC7D-DA212FB0136B]
    // </editor-fold> 
    /**
     * Constructor of the NutzerMapper class.
     */
    protected NutzerMapper() {
    }

    /**
     * Singleton class of the mapper class. Either generates a new 
     * NutzerMapper or returns the already generated Mapper Object
     * @return NutzerMapper - Returns the NutzerMapper Object.
     */
    public static NutzerMapper nutzerMapper() {
        if (nutzerMapper == null) {
            nutzerMapper = new NutzerMapper();
        }
        return nutzerMapper;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C1ED3A6E-09B8-4760-D3C6-A75103DC7528]
    // </editor-fold> 
    /**
     * Insert method of the Nutzer mapper for the NutzerImpl objects.
     * 
     * 
     * @param val - Needs a Nutzer object without an id.
     * @return Nutzer - Returns the inserted object with the generated id.
     */
    public Nutzer insert(Nutzer val) {
        Connection con = DBConnection.connection();
        try {
            Timestamp t = new Timestamp(val.getCreationDate().getTime());
            con.createStatement().executeUpdate(
                    INSERT_INTO + " " +
                    TABLE_NAME_NUTZER + " ( " +
                            COLUMN_CREATION_DATE + ", " + 
                            COLUMN_NICKNAME + ", " + 
                            COLUMN_VORNAME + ", " + 
                            COLUMN_NACHNAME + ", " + 
                            COLUMN_PASSWORD + " ) " +
                    VALUES + " ( " + 
                            "\"" + t + "\"" + " , " + 
                            "\"" + val.getUsername() + "\"" + " , " + 
                            "\"" + val.getSurname() + "\"" + " , " + 
                            "\"" + val.getName() + "\"" + " , " + 
                            "\"" + val.getPassword() + "\"" + " )");
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    SELECT + " " + 
                            COLUMN_ID + " " + 
                    FROM  + " " + 
                            TABLE_NAME_NUTZER  + " " + 
                    ORDER_BY_ID_DESC_STATEMENT_OPTION + " " + 
                    LIMIT_STATEMENT_OPTION + " " + "1");
            if (resultSet.next())
                val.setID((resultSet.getInt(COLUMN_ID)));
        } catch (SQLException ex) {
            Logger.getLogger(NutzerMapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(NutzerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.25652AD8-6667-DE25-7002-EB0BC3239B9E]
    // </editor-fold> 
    /**
     * Update method of the Nutzer mapper updates object by id.
     * 
     * 
     * @param val - Needs an Nutzer object with a id.
     * @return Nutzer - Returns the updated objects.
     */
    public Nutzer update(Nutzer val) {
        Connection con = DBConnection.connection();
        try {
            Timestamp t = new Timestamp(val.getCreationDate().getTime());
            con.createStatement().executeUpdate(
                    UPDATE + " " +
                            TABLE_NAME_NUTZER + " " +
                    SET + " " +
                            COLUMN_CREATION_DATE + " =\"" + t + "\"" + ", " +
                            COLUMN_NICKNAME + " =\"" + val.getUsername() + "\""  + ", " +
                            COLUMN_VORNAME + " =\"" + val.getSurname() + "\""  + ", " +
                            COLUMN_NACHNAME + " =\"" + val.getName() + "\""  + ", " +
                            COLUMN_PASSWORD + " =\"" + val.getPassword() + "\""  + " " +
                    WHERE + " " +
                            COLUMN_ID + " = " + val.getID());
        } catch (SQLException ex) {
            Logger.getLogger(NutzerMapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(NutzerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4A60AF52-725F-0D4C-B96A-F0160B05A2E8]
    // </editor-fold> 
    /**
     * Deletes the given Nutzer from the sql table by id.
     * 
     * 
     * @param val Nutzer to be deleted.
     */
    public void delete(Nutzer val) {
        Connection con = DBConnection.connection();
        try {
            con.createStatement().executeUpdate(
                    DELETE + " " +
                    FROM + " " +
                            TABLE_NAME_NUTZER + " " +
                    WHERE + " " +
                            COLUMN_ID + " =\"" + val.getID() + "\"");
        } catch (SQLException ex) {
            Logger.getLogger(NutzerMapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(NutzerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4C80F348-AA5A-A17A-D055-05AB68D80A5A]
    // </editor-fold> 
    /**
     * Method to read every entry in the Nutzer table.
     * 
     * 
     * @return Vector<Nutzer> - Returns all the entrys in the sql table
     */
    public Vector<Nutzer> getAll() {
        Connection con = DBConnection.connection();
        Vector<Nutzer> nutzers = new Vector<Nutzer>();
        try {
            ResultSet resultSet = con.createStatement().executeQuery(
                SELECT + " " +
                        COLUMN_ID + ", " + 
                        COLUMN_CREATION_DATE + ", " + 
                        COLUMN_NICKNAME + ", " + 
                        COLUMN_VORNAME + ", " + 
                        COLUMN_NACHNAME + ", " + 
                        COLUMN_PASSWORD + " " +
                FROM + " " +
                        TABLE_NAME_NUTZER + " " +
                ORDER_BY_ID_STATEMENT_OPTION);
            while (resultSet.next()) {
                try {
                    Nutzer nutzer = new NutzerImpl();
                    nutzer.setID(resultSet.getInt(COLUMN_ID));
                    nutzer.setCreationDate(resultSet.getTimestamp(COLUMN_CREATION_DATE));
                    nutzer.setUsername(resultSet.getString(COLUMN_NICKNAME) );
                    nutzer.setSurname(resultSet.getString(COLUMN_VORNAME));
                    nutzer.setName(resultSet.getString(COLUMN_NACHNAME));
                    nutzer.setPassword(resultSet.getString(COLUMN_PASSWORD));
                    nutzers.addElement(nutzer);
                }
                catch(SQLException e) {
                    Logger.getLogger(NutzerMapper.class.getName()).log(Level.SEVERE, null, e);
                    break;
                } catch (RemoteException ex) {
                    Logger.getLogger(NutzerMapper.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(NutzerMapper.class.getName()).log(Level.SEVERE, null, e);
        }
        return nutzers;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D23558EA-2F26-4617-294C-70420DD1EA3B]
    // </editor-fold> 
    /**
    public Nutzer findByID(int val) {
        Connection con = DBConnection.connection();
        return null;
    }
    */
}
