package SocialMedia_DatabaseManager;

import SocialMedia_Data.Nutzer;
import SocialMedia_Data.NutzerImpl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.2A7B9558-B6D3-BDAA-C118-802F3096C4E5]
// </editor-fold> 
/**
 * 
 * @author Sebastian
 */
public class NutzerMapper extends DBStatementFactory{

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.665FBD45-137D-BD65-2498-CA0B84C4F9F3]
    // </editor-fold> 
    /**
     * 
     */
    private static NutzerMapper nutzerMapper = null;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.47C0FA3B-D373-5813-EC7D-DA212FB0136B]
    // </editor-fold> 
    /**
     * 
     */
    public NutzerMapper() {
    }

    /**
     * 
     * @return 
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
     * 
     * @param val
     * @return 
     */
    public Nutzer insert(Nutzer val) {
        Connection con = DBConnection.connection();
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.25652AD8-6667-DE25-7002-EB0BC3239B9E]
    // </editor-fold> 
    /**
     * 
     * @param val
     * @return 
     */
    public Nutzer update(Nutzer val) {
        Connection con = DBConnection.connection();
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4A60AF52-725F-0D4C-B96A-F0160B05A2E8]
    // </editor-fold> 
    /**
     * 
     * @param val 
     */
    public void delete(Nutzer val) {
        Connection con = DBConnection.connection();
        try {
            con.createStatement().executeQuery(
                    DELETE + " " +
                    FROM + " " +
                    TABLE_NAME_KOMMENTAR + " " +
                    WHERE + " " +
                    COLUMN_ID + "=" + "`" + val.getID() + "`" + " " +
                    COLUMN_CREATION_DATE + "=" + "`" + val.getCreationDate() + "`" + " " +
                    COLUMN_NICKNAME + "=" + "`" + val.getUsername() + "`" + " " +
                    COLUMN_NACHNAME + "=" + "`" + val.getName() + "`" +  " " +
                    COLUMN_VORNAME + "=" + "`" + val.getSurname() + "`" + " " +
                    COLUMN_PASSWORD + "=" + "`" + val.getPassword() + "`" + " " +
                    ORDER_BY_ID_STATEMENT_OPTION);
        } catch (SQLException ex) {
            Logger.getLogger(AbonnementMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4C80F348-AA5A-A17A-D055-05AB68D80A5A]
    // </editor-fold> 
    /**
     * 
     * @return 
     */
    public Vector<Nutzer> getAll() {
        Connection con = DBConnection.connection();
        Vector<Nutzer> nutzers = new Vector<Nutzer>();
        try {
            ResultSet resultSet = con.createStatement().executeQuery(
                SELECT + " " +
                COLUMN_ID + ", " + COLUMN_CREATION_DATE + ", " + COLUMN_NICKNAME + ", " + COLUMN_NACHNAME + ", " + COLUMN_VORNAME + ", " + COLUMN_PASSWORD + " " +
                FROM + " " +
                TABLE_NAME_NUTZER + " " +
                ORDER_BY_ID_STATEMENT_OPTION);

            while (resultSet.next()) {
                try {
                    Nutzer nutzer = new NutzerImpl();
                    nutzer.setID(resultSet.getInt(COLUMN_ID));
                    nutzer.setCreationDate(resultSet.getDate(COLUMN_CREATION_DATE));
                    nutzer.setUsername(resultSet.getString(COLUMN_NICKNAME) );
                    nutzer.setName(resultSet.getString(COLUMN_NACHNAME));
                    nutzer.setSurname(resultSet.getString(COLUMN_VORNAME));
                    nutzer.setPassword(resultSet.getString(COLUMN_PASSWORD));
                    nutzers.addElement(nutzer);
                }
                catch(SQLException e) {
                    e.printStackTrace();
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nutzers;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D23558EA-2F26-4617-294C-70420DD1EA3B]
    // </editor-fold> 
    /**
     * 
     * @param val
     * @return 
     */
    public Nutzer findByID(int val) {
        Connection con = DBConnection.connection();
        return null;
    }
}
