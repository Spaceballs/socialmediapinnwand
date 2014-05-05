package SocialMedia_DatabaseManager;

import SocialMedia_Data.Like; 
import SocialMedia_Data.LikeImpl;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.11E2FD15-AC88-BA60-9549-E52BE333AD91]
// </editor-fold> 
/**
 * Class for mapping AbonnementImpl objects onto a sql database.
 * 
 * 
 * @author Sebastian
 */
public class LikeMapper extends DBStatementFactory{

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A75B29F6-98A7-14CF-DC50-4096791E2E76]
    // </editor-fold> 
    private static LikeMapper likeMapper = null;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F420CC2E-47C1-AA2F-9057-59785D74E036]
    // </editor-fold> 
    /**
     * Constructor of the LikeMapper class.
     */
    protected LikeMapper () {
    }

    /**
     * Singleton class of the mapper class. Either generates a new 
     * LikeMapper or returns the already generated Mapper Object
     * @return LikeMapper - Returns the LikeMapper Object.
     */
    public static LikeMapper likeMapper(){
        if (likeMapper == null) {
            likeMapper = new LikeMapper();
        }
        return likeMapper;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D470D38B-A8D0-F180-05C3-212EC2769706]
    // </editor-fold> 
    /**
     * Insert method of the Like mapper for the AbonnementImpl objects.
     * 
     * 
     * @param val - Needs a Like object without an id.
     * @return Like - Returns the inserted object with the generated id.
     */
    public Like insert (Like val) {
        Connection con = DBConnection.connection();
        try {
            Timestamp t = new Timestamp(val.getCreationDate().getTime());
            con.createStatement().executeUpdate(
                    INSERT_INTO + " " +
                    TABLE_NAME_LIKE + " ( " +
                            COLUMN_CREATION_DATE + ", " + 
                            COLUMN_BEITRAG_ID + ", " + 
                            COLUMN_NUTZER_ID +" ) " +
                    VALUES + " ( " + 
                            "\"" + t + "\"" + " , " + 
                            "\"" + val.getBeitragID() + "\"" + ", " + 
                            "\"" + val.getNutzerID() + "\"" +" )");
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    SELECT + " " + 
                            COLUMN_ID + " " + 
                    FROM  + " " + 
                            TABLE_NAME_LIKE  + " " + 
                    ORDER_BY_ID_DESC_STATEMENT_OPTION + " " + 
                    LIMIT_STATEMENT_OPTION + " " + "1");
            if (resultSet.next())
                val.setID((resultSet.getInt(COLUMN_ID)));
        } catch (SQLException ex) {
            Logger.getLogger(LikeMapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(LikeMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D580C23C-7D18-88FB-DC26-1E1EFD8FE605]
    // </editor-fold> 
    /**
     * Update method of the Like mapper updates object by id.
     * 
     * 
     * @param val - Needs an Like object with a id.
     * @return Like - Returns the updated objects.
     */
    public Like update (Like val) {
        Connection con = DBConnection.connection();
        try {
            Timestamp t = new Timestamp(val.getCreationDate().getTime());
            con.createStatement().executeUpdate(
                    UPDATE + " " +
                    TABLE_NAME_ABONNEMENT + " " +
                    SET + " " +
                            COLUMN_CREATION_DATE + " =\"" + t + "\"" + ", " +
                            COLUMN_NUTZER_ID + " =\"" + val.getNutzerID() + "\""  + ", " +
                            COLUMN_BEITRAG_ID + " =\"" + val.getBeitragID() + "\""  + " " +
                    WHERE + " " +
                            COLUMN_ID + " = " + val.getID());
        } catch (SQLException ex) {
            Logger.getLogger(LikeMapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(LikeMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B9FF72D7-E27B-D364-26AC-34B3C6DB153A]
    // </editor-fold>
    /**
     * Deletes the given Like from the sql table by id.
     * 
     * 
     * @param val Like to be deleted.
     */
    public void delete (Like val) {
        Connection con = DBConnection.connection();
        try {
            con.createStatement().executeQuery(
                    DELETE + " " +
                    FROM + " " +
                            TABLE_NAME_LIKE + " " +
                    WHERE + " " +
                            COLUMN_ID + " =\"" + val.getID() + "\"");
        } catch (SQLException ex) {
            Logger.getLogger(LikeMapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(LikeMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0C4B0EE1-B2C6-56F6-18D3-A695BA7EDA76]
    // </editor-fold> 
    /**
     * Method to read every entry in the Like table.
     * 
     * 
     * @return Vector<Like> - Returns all the entrys in the sql table
     */
    public Vector<Like> getAll () {
        Connection con = DBConnection.connection();
        Vector<Like> likes = new Vector<Like>();
        try {
            ResultSet resultSet = con.createStatement().executeQuery(
                SELECT + " " +
                        COLUMN_ID + ", " + 
                        COLUMN_CREATION_DATE + ", " + 
                        COLUMN_NUTZER_ID + ", " + 
                        COLUMN_BEITRAG_ID + " " +
                FROM + " " +
                        TABLE_NAME_LIKE + " " +
                ORDER_BY_ID_STATEMENT_OPTION);
            while (resultSet.next()) {
                try {
                    Like like = new LikeImpl();
                    like.setID(resultSet.getInt(COLUMN_ID));
                    like.setCreationDate(resultSet.getTimestamp(COLUMN_CREATION_DATE));
                    like.setNutzerID( resultSet.getInt(COLUMN_NUTZER_ID) );
                    like.setBeitragID(resultSet.getInt(COLUMN_BEITRAG_ID));
                    likes.addElement(like);
                }
                catch(SQLException e) {
                    Logger.getLogger(LikeMapper.class.getName()).log(Level.SEVERE, null, e);
                    break;
                } catch (RemoteException ex) {
                    Logger.getLogger(LikeMapper.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(LikeMapper.class.getName()).log(Level.SEVERE, null, e);
        }
        return likes;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2F208909-213E-7E00-A86E-FFABCE2016FE]
    // </editor-fold> 
    /**
    public Like findByID (int val) {
        Connection con = DBConnection.connection();
        return null;
    }
    */
}

