package SocialMedia_DatabaseManager;

import SocialMedia_Data.Abonnement; 
import SocialMedia_Data.AbonnementImpl;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.86058FE3-4703-84A6-19E0-7413B2A65EE8]
// </editor-fold> 
/**
 * Class for mapping AbonnementImpl objects onto a sql database.
 * 
 * 
 * @author Sebastian
 */
public class AbonnementMapper extends DBStatementFactory {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4F343793-5692-58DE-EA80-D99B835998E9]
    // </editor-fold> 
    private static AbonnementMapper abonnementMapper = null;
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5767551A-2A74-DDFE-D2F0-8B38B96D1742]
    // </editor-fold> 
    /**
     * Constructor of the AbonnementMapper class.
     */
    protected AbonnementMapper () {
    }

    /**
     * Singleton class of the mapper class. Either generates a new 
     * AbonnementMapper or returns the already generated Mapper Object
     * @return AbonnementMapper - Returns the AbonnementMapper Object.
     */
    public static AbonnementMapper abonnementMapper(){
        if(abonnementMapper == null){
            abonnementMapper = new AbonnementMapper();
        }
        return abonnementMapper;
    }


    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.07672B8C-2DA5-0B58-2173-FAF4118927BD]
    // </editor-fold> 
    /**
     * Insert method of the Abonnement mapper for the AbonnementImpl objects.
     * 
     * 
     * @param val - Needs a Abonnement object without an id.
     * @return Abonnement - Returns the inserted object with the generated id.
     */
    public Abonnement insert (Abonnement val) {
        Connection con = DBConnection.connection();
        try {
            Timestamp t = new Timestamp(val.getCreationDate().getTime());
            con.createStatement().executeUpdate(
                    INSERT_INTO + " " +
                    TABLE_NAME_ABONNEMENT + " ( " +
                            COLUMN_CREATION_DATE + ", " + 
                            COLUMN_PINNWAND_ID + ", " + 
                            COLUMN_NUTZER_ID + " ) " +
                    VALUES + " ( " + 
                            "\"" + t + "\"" + " , " + 
                            "\"" + val.getPinnwandID() + "\"" + " , " + 
                            "\"" + val.getNutzerID() + "\"" + " )");
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    SELECT + " " + 
                            COLUMN_ID + " " + 
                    FROM  + " " + 
                            TABLE_NAME_ABONNEMENT  + " " + 
                    ORDER_BY_ID_DESC_STATEMENT_OPTION + " " + 
                    LIMIT_STATEMENT_OPTION + " " + "1");
            if (resultSet.next())
                val.setID((resultSet.getInt(COLUMN_ID)));
        } catch (SQLException ex) {
            Logger.getLogger(AbonnementMapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(AbonnementMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.720694C4-3F40-2FAE-694D-624DF8707ACE]
    // </editor-fold> 
    /**
     * Update method of the Abonnement mapper updates object by id.
     * 
     * 
     * @param val - Needs an Abonnement object with a id.
     * @return Abonnement - Returns the updated objects.
     */
    public Abonnement update (Abonnement val) {
        Connection con = DBConnection.connection();
        try {
            Timestamp t = new Timestamp(val.getCreationDate().getTime());
            con.createStatement().executeUpdate(
                    UPDATE + " " +
                            TABLE_NAME_ABONNEMENT + " " +
                    SET + " " +
                            COLUMN_CREATION_DATE + " =\"" + t + "\"" + ", " +
                            COLUMN_NUTZER_ID + " =\"" + val.getNutzerID() + "\""  + ", " +
                            COLUMN_PINNWAND_ID + " =\"" + val.getPinnwandID() + "\""  + " " +
                    WHERE + " " +
                    COLUMN_ID + " = " + val.getID());
        } catch (SQLException ex) {
            Logger.getLogger(AbonnementMapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(AbonnementMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3BF353D9-FF07-B451-4B89-20F8318BE4F0]
    // </editor-fold> 
    /**
     * Deletes the given Abonnement from the sql table by id.
     * 
     * 
     * @param val Abonnement to be deleted.
     */
    public void delete (Abonnement val) {
        Connection con = DBConnection.connection();
        try {
            con.createStatement().executeUpdate(
                    DELETE + " " +
                    FROM + " " +
                            TABLE_NAME_ABONNEMENT + " " +
                    WHERE + " " +
                            COLUMN_ID + " =\"" + val.getID() + "\"");
        } catch (SQLException ex) {
            Logger.getLogger(AbonnementMapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(AbonnementMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.FF6B8927-E3C3-0DF3-8FD2-6F803361FCCF]
    // </editor-fold> 
    /**
     * Method to read every entry in the Abonnement table.
     * 
     * 
     * @return Vector<Abonnement> - Returns all the entrys in the sql table
     */
    public Vector<Abonnement> getAll () {
        Connection con = DBConnection.connection();
        Vector<Abonnement> abonnements = new Vector<Abonnement>();
        try {
            ResultSet resultSet = con.createStatement().executeQuery(
                SELECT + " " +
                        COLUMN_ID + ", " + 
                        COLUMN_CREATION_DATE + ", " + 
                        COLUMN_NUTZER_ID + ", " + 
                        COLUMN_PINNWAND_ID + " " +
                FROM + " " +
                        TABLE_NAME_ABONNEMENT + " " +
                ORDER_BY_ID_STATEMENT_OPTION);
            while (resultSet.next()) {
                try {
                    Abonnement abonnement = new AbonnementImpl();
                    abonnement.setID(resultSet.getInt(COLUMN_ID));
                    abonnement.setCreationDate(resultSet.getTimestamp(COLUMN_CREATION_DATE));
                    abonnement.setNutzerID(resultSet.getInt(COLUMN_NUTZER_ID) );
                    abonnement.setPinnwandID(resultSet.getInt(COLUMN_PINNWAND_ID));
                    abonnements.addElement(abonnement);
                }
                catch(SQLException e) {
                    Logger.getLogger(AbonnementMapper.class.getName()).log(Level.SEVERE, null, e);
                    break;
                } catch (RemoteException ex) {
                    Logger.getLogger(AbonnementMapper.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(AbonnementMapper.class.getName()).log(Level.SEVERE, null, e);
        }
        return abonnements;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8FEA238D-153E-6EFA-188A-255C783AA53D]
    // </editor-fold> 
    /**
    public Abonnement findByID (int val) {
        Connection con = DBConnection.connection();
        return null;
    }
    */
}

