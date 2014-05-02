package SocialMedia_DatabaseManager;

import SocialMedia_Data.Like; 
import SocialMedia_Data.LikeImpl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.11E2FD15-AC88-BA60-9549-E52BE333AD91]
// </editor-fold> 
public class LikeMapper extends DBStatementFactory{

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A75B29F6-98A7-14CF-DC50-4096791E2E76]
    // </editor-fold> 
    private static LikeMapper likeMapper = null;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F420CC2E-47C1-AA2F-9057-59785D74E036]
    // </editor-fold> 
    public LikeMapper () {
    }

    public static LikeMapper likeMapper(){
        if (likeMapper == null) {
            likeMapper = new LikeMapper();
        }
        return likeMapper;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D470D38B-A8D0-F180-05C3-212EC2769706]
    // </editor-fold> 
    public Like insert (Like val) {
        Connection con = DBConnection.connection();
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D580C23C-7D18-88FB-DC26-1E1EFD8FE605]
    // </editor-fold> 
    public Like update (Like val) {
        Connection con = DBConnection.connection();
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B9FF72D7-E27B-D364-26AC-34B3C6DB153A]
    // </editor-fold> 
    public void delete (Like val) {
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
                    COLUMN_BEITRAG_ID + "=" + "`" + val.getBeitragID() + "`" +  " " +
                    COLUMN_LIKE + "=" + "`" + val.getLike() + "`" + " " +
                    ORDER_BY_ID_STATEMENT_OPTION);
        } catch (SQLException ex) {
            Logger.getLogger(AbonnementMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0C4B0EE1-B2C6-56F6-18D3-A695BA7EDA76]
    // </editor-fold> 
    public Vector<Like> getAll () {
        System.err.println(SELECT + " " +
                COLUMN_ID + ", " + COLUMN_CREATION_DATE + ", " + COLUMN_NUTZER_ID + ", " + COLUMN_BEITRAG_ID + ", " + COLUMN_LIKE + " " +
                FROM + " " +
                TABLE_NAME_LIKE + " " +
                ORDER_BY_ID_STATEMENT_OPTION);
        Connection con = DBConnection.connection();
        Vector<Like> likes = new Vector<Like>();
        try {
            ResultSet resultSet = con.createStatement().executeQuery(
                SELECT + " " +
                COLUMN_ID + ", " + COLUMN_CREATION_DATE + ", " + COLUMN_NUTZER_ID + ", " + COLUMN_BEITRAG_ID + ", " + COLUMN_LIKE + " " +
                FROM + " " +
                TABLE_NAME_LIKE + " " +
                ORDER_BY_ID_STATEMENT_OPTION);
            while (resultSet.next()) {
                try {
                    Like like = new LikeImpl();
                    like.setID(resultSet.getInt(COLUMN_ID));
                    like.setCreationDate(resultSet.getDate(COLUMN_CREATION_DATE));
                    like.setNutzerID( resultSet.getInt(COLUMN_NUTZER_ID) );
                    like.setBeitragID(resultSet.getInt(COLUMN_BEITRAG_ID));
                    like.setLike(resultSet.getBoolean(COLUMN_LIKE));
                    likes.addElement(like);
                }
                catch(SQLException e) {
                    e.printStackTrace();
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return likes;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2F208909-213E-7E00-A86E-FFABCE2016FE]
    // </editor-fold> 
    public Like findByID (int val) {
        Connection con = DBConnection.connection();
        return null;
    }
}

