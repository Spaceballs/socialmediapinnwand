package SocialMedia_DatabaseManager;

import SocialMedia_Data.Beitrag; 
import SocialMedia_Data.BeitragImpl;
import java.awt.image.RescaleOp;
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
// #[regen=yes,id=DCE.C7EFE1A2-DFDC-BDB2-0C05-445EE6027E44]
// </editor-fold> 
/**
 * Class for mapping BeitragImpl objects into a sql database.
 * 
 * 
 * @author Sebastian
 */
public class BeitragMapper extends DBStatementFactory {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4D65ED05-AD0B-FC57-0EC4-0AFACBC0DD01]
    // </editor-fold> 
    private static BeitragMapper beitragMapper = null;
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3F9CA0CE-A15F-4755-D8B8-4637AD032631]
    // </editor-fold> 
    protected BeitragMapper () {
    }

    /**
     * Singleton class of the mapper class. Either generates a new 
     * BeitraMapper or returns the already generated Mapper Object
     * @return BeitraMapper - Returns the AbonnementMapper Object.
     */
    public static BeitragMapper beitragMapper(){
        if(beitragMapper == null){
            beitragMapper = new BeitragMapper();
        }
        return beitragMapper;
    }


    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.83B8D728-1072-5297-E306-A9EA071580E9]
    // </editor-fold> 
    /**
     * Update method of the Beitrag mapper updates object by id.
     * 
     * 
     * @param val - Needs a Beitrag object without an id.
     * @return Beitrag - Returns the inserted object with the generated id.
     */
    public Beitrag insert (Beitrag val) {
        Connection con = DBConnection.connection();
        try {
            Timestamp t = new Timestamp(val.getCreationDate().getTime());
            con.createStatement().executeUpdate(
                    INSERT_INTO + " " +
                    TABLE_NAME_BEITRAG + " ( " +
                            COLUMN_CREATION_DATE + ", " + 
                            COLUMN_PINNWAND_ID + ", " + 
                            COLUMN_NUTZER_ID +  ", " + 
                            COLUMN_TEXT + " ) " +
                    VALUES + " ( " + 
                            "\"" + t + "\"" + " , " + 
                            "\"" + val.getPinnwandID() + "\"" + " , " + 
                            "\"" + val.getNutzerID() + "\"" +  " , " + 
                            "\"" + val.getText() + "\"" + " )");
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    SELECT + " " + 
                            COLUMN_ID + " " + 
                    FROM  + " " + 
                            TABLE_NAME_BEITRAG  + " " + 
                    ORDER_BY_ID_DESC_STATEMENT_OPTION + " " + 
                    LIMIT_STATEMENT_OPTION + " " + "1");
            if (resultSet.next())
                val.setID((resultSet.getInt(COLUMN_ID)));
        } catch (SQLException ex) {
            Logger.getLogger(BeitragMapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(BeitragMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4ACBD08C-1948-DCEB-5211-AC0A39939014]
    // </editor-fold> 
    /**
     * Updates the Beitrag object by the objects id.
     * 
     * 
     * @param val - Needs an Beitrag object with a id.
     * @return Beitrag - Returns the updated objects.
     */
    public Beitrag update (Beitrag val) {
        Connection con = DBConnection.connection();   
        try {
            Timestamp t = new Timestamp(val.getCreationDate().getTime());
            con.createStatement().executeUpdate(
                    UPDATE + " " +
                            TABLE_NAME_BEITRAG + " " +
                            SET + " " +
                                    COLUMN_CREATION_DATE + " =\"" + t + "\"" + ", " +
                                    COLUMN_NUTZER_ID + " =\"" + val.getNutzerID() + "\""  + ", " +
                                    COLUMN_PINNWAND_ID + " =\"" + val.getPinnwandID() + "\""  + " " +
                                    COLUMN_TEXT + " =\"" + val.getText() + "\""  + " " +
                            WHERE + " " +
                                    COLUMN_ID + " = " + val.getID());
        } catch (SQLException ex) {
            Logger.getLogger(BeitragMapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(BeitragMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5A108A9E-5162-7EDB-7A86-C17CD171A261]
    // </editor-fold> 
    /**
     * Deletes the given Beitrag from the sql table by id.
     * 
     * 
     * @param val - Beitrag to be deleted.
     */
    public void delete (Beitrag val) {
        Connection con = DBConnection.connection();
        try {
            con.createStatement().executeQuery(
                    DELETE + " " +
                    FROM + " " +
                            TABLE_NAME_BEITRAG + " " +
                    WHERE + " " +
                            COLUMN_ID + " =\"" + val.getID() + "\"");
        } catch (SQLException ex) {
            Logger.getLogger(BeitragMapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(BeitragMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0B0DADF1-20A3-4875-9AA5-6F90023A7F32]
    // </editor-fold> 
    /**
     * Method to read every entry in the Beitrag table.
     * 
     * 
     * @return Vector<Beitrag> - Returns all the entrys in the sql table
     */
    public Vector<Beitrag> getAll () {
        Connection con = DBConnection.connection();
        Vector<Beitrag> beitraege = new Vector<Beitrag>();
        try {
            ResultSet resultSet = con.createStatement().executeQuery(
                SELECT + " " +
                        COLUMN_ID + ", " + 
                        COLUMN_CREATION_DATE + ", " + 
                        COLUMN_NUTZER_ID + ", " + 
                        COLUMN_PINNWAND_ID + ", " + 
                        COLUMN_TEXT + " " +
                FROM + " " +
                        TABLE_NAME_BEITRAG + " " +
                ORDER_BY_ID_STATEMENT_OPTION);
            while (resultSet.next()) {
                try {
                    Beitrag beitrag = new BeitragImpl();
                    beitrag.setID(resultSet.getInt(COLUMN_ID));
                    beitrag.setCreationDate(resultSet.getTimestamp(COLUMN_CREATION_DATE));
                    beitrag.setNutzerID( resultSet.getInt(COLUMN_NUTZER_ID) );
                    beitrag.setPinnwandID(resultSet.getInt(COLUMN_PINNWAND_ID));
                    beitrag.setText(resultSet.getString(COLUMN_TEXT));
                    beitraege.addElement(beitrag);
                }
                catch(SQLException e) {
                    Logger.getLogger(BeitragMapper.class.getName()).log(Level.SEVERE, null, e);
                    break;
                } catch (RemoteException ex) {
                    Logger.getLogger(BeitragMapper.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(BeitragMapper.class.getName()).log(Level.SEVERE, null, e);
        }
        return beitraege;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D12ED43A-5458-0A9B-A33B-4670D16CC3F1]
    // </editor-fold> 
    /**
    public Beitrag findByID (int val) {
        Connection con = DBConnection.connection();
        return null;
    }
    */
}

