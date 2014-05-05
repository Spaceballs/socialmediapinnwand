package SocialMedia_DatabaseManager;

import SocialMedia_Data.Kommentar; 
import SocialMedia_Data.KommentarImpl;
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
// #[regen=yes,id=DCE.86508071-818C-8C40-6662-8E8A4D4DE5AB]
// </editor-fold> 
/**
 * Class for mapping KommentarImpl objects onto a sql database.
 * 
 * 
 * @author Sebastian
 */
public class KommentarMapper extends DBStatementFactory{

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9E5DE831-C9E8-68A8-D649-9ECFB3E846AC]
    // </editor-fold> 
    private static KommentarMapper kommentarMapper = null;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D3B5CF97-9DF3-0750-3151-0AD4546D3D35]
    // </editor-fold> 
    protected KommentarMapper () {
    }

    /**
     * Singleton class of the mapper class. Either generates a new 
     * KommentarMapper or returns the already generated Mapper Object
     * @return KommentarMapper - Returns the AbonnementMapper Object.
     */
    public static KommentarMapper kommentarMapper(){
        if (kommentarMapper == null) {
            kommentarMapper = new KommentarMapper();
        }
        return kommentarMapper;
    }


    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.7866B8A7-10AA-8192-AC55-B9F8AF1AE130]
    // </editor-fold> 
    /**
     * Update method of the Kommentar mapper updates object by id.
     * 
     * 
     * @param val - Needs a Kommentar object without an id.
     * @return Kommentar - Returns the inserted object with the generated id.
     */    
    public Kommentar insert (Kommentar val) {
        Connection con = DBConnection.connection();
        try {
            Timestamp t = new Timestamp(val.getCreationDate().getTime());
            con.createStatement().executeUpdate(
                    INSERT_INTO + " " +
                    TABLE_NAME_KOMMENTAR + " ( " +
                            COLUMN_CREATION_DATE + ", " + 
                            COLUMN_BEITRAG_ID + ", " + 
                            COLUMN_NUTZER_ID +  ", " + 
                            COLUMN_TEXT + " ) " +
                    VALUES + " ( " + 
                            "\"" + t + "\"" + " , " + 
                            "\"" + val.getBeitragID() + "\"" + " , " + 
                            "\"" + val.getNutzerID() + "\"" +  " , " + 
                            "\"" + val.getText() + "\"" + " )");
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    SELECT + " " + 
                            COLUMN_ID + " " + 
                    FROM  + " " + 
                            TABLE_NAME_KOMMENTAR  + " " + 
                    ORDER_BY_ID_DESC_STATEMENT_OPTION + " " + 
                    LIMIT_STATEMENT_OPTION + " " + "1");
            if (resultSet.next())
                val.setID((resultSet.getInt(COLUMN_ID)));
        } catch (SQLException ex) {
            Logger.getLogger(KommentarMapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(KommentarMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D59859BD-8C69-DEF0-2252-03A01A7EB350]
    // </editor-fold> 
    /**
     * Updates the Kommentar object by the objects id.
     * 
     * 
     * @param val - Needs an Kommentar object with a id.
     * @return Kommentar - Returns the updated objects.
     */
    public Kommentar update (Kommentar val) {
        Connection con = DBConnection.connection();
        try {
            Timestamp t = new Timestamp(val.getCreationDate().getTime());
            con.createStatement().executeUpdate(
                    UPDATE + " " +
                            TABLE_NAME_KOMMENTAR + " " +
                            SET + " " +
                                    COLUMN_CREATION_DATE + " =\"" + t + "\"" + ", " +
                                    COLUMN_NUTZER_ID + " =\"" + val.getNutzerID() + "\""  + ", " +
                                    COLUMN_BEITRAG_ID + " =\"" + val.getBeitragID() + "\""  + " " +
                                    COLUMN_TEXT + " =\"" + val.getText() + "\""  + " " +
                            WHERE + " " +
                                    COLUMN_ID + " = " + val.getID());
        } catch (SQLException ex) {
            Logger.getLogger(KommentarMapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(KommentarMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.EE3BF1F0-F3A0-F559-4A32-A1057B153199]
    // </editor-fold> 
    /**
     * Deletes the given Kommentar from the sql table by id.
     * 
     * 
     * @param val - Kommentar to be deleted.
     */
    public void delete (Kommentar val) {
        Connection con = DBConnection.connection();
        try {
            con.createStatement().executeQuery(
                    DELETE + " " +
                    FROM + " " +
                            TABLE_NAME_KOMMENTAR + " " +
                    WHERE + " " +
                            COLUMN_ID + " =\"" + val.getID() + "\"");
        } catch (SQLException ex) {
            Logger.getLogger(KommentarMapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(KommentarMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.42931436-6E5A-7157-C029-F81BDF5F8CF7]
    // </editor-fold> 
    /**
     * Method to read every entry in the Kommentar table.
     * 
     * 
     * @return Vector<Kommentar> - Returns all the entrys in the sql table
     */
    public Vector<Kommentar> getAll () {
        Connection con = DBConnection.connection();
        Vector<Kommentar> kommentare = new Vector<Kommentar>();
        try {
            ResultSet resultSet = con.createStatement().executeQuery(
                SELECT + " " +
                        COLUMN_ID + ", " + 
                        COLUMN_CREATION_DATE + ", " + 
                        COLUMN_NUTZER_ID + ", " + 
                        COLUMN_BEITRAG_ID + ", " + 
                        COLUMN_TEXT + " " +
                FROM + " " +
                        TABLE_NAME_KOMMENTAR + " " +
                ORDER_BY_ID_STATEMENT_OPTION);
            while (resultSet.next()) {
                try {
                    Kommentar kommentar = new KommentarImpl();
                    kommentar.setID(resultSet.getInt(COLUMN_ID));
                    kommentar.setCreationDate(resultSet.getTimestamp(COLUMN_CREATION_DATE));
                    kommentar.setNutzerID( resultSet.getInt(COLUMN_NUTZER_ID) );
                    kommentar.setBeitragID(resultSet.getInt(COLUMN_BEITRAG_ID));
                    kommentar.setText(resultSet.getString(COLUMN_TEXT));
                    kommentare.addElement(kommentar);
                }
                catch(SQLException e) {
                    Logger.getLogger(KommentarMapper.class.getName()).log(Level.SEVERE, null, e);
                    break;
                } catch (RemoteException ex) {
                    Logger.getLogger(KommentarMapper.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(KommentarMapper.class.getName()).log(Level.SEVERE, null, e);
        }
        return kommentare;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5A7836AD-406C-422D-ADA6-76B6D52AF31F]
    // </editor-fold> 
    /**
    public Kommentar findByID (int val) {
        Connection con = DBConnection.connection();
        return null;
    }
    */
}

