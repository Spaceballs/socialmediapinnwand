package SocialMedia_DatabaseManager;

import SocialMedia_Data.Beitrag; 
import SocialMedia_Data.BeitragImpl;
import java.awt.image.RescaleOp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.C7EFE1A2-DFDC-BDB2-0C05-445EE6027E44]
// </editor-fold> 
public class BeitragMapper extends DBStatementFactory {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4D65ED05-AD0B-FC57-0EC4-0AFACBC0DD01]
    // </editor-fold> 
    private static BeitragMapper beitragMapper = null;
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3F9CA0CE-A15F-4755-D8B8-4637AD032631]
    // </editor-fold> 
    public BeitragMapper () {
    }

    /**
     * 
     * @return 
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
    public Beitrag insert (Beitrag val) {
        Connection con = DBConnection.connection();
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4ACBD08C-1948-DCEB-5211-AC0A39939014]
    // </editor-fold> 
    public Beitrag update (Beitrag val) {
        Connection con = DBConnection.connection();
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5A108A9E-5162-7EDB-7A86-C17CD171A261]
    // </editor-fold> 
    public void delete (Beitrag val) {
        Connection con = DBConnection.connection();
        try {
            con.createStatement().executeQuery(
                    DELETE + " " +
                    FROM + " " +
                    TABLE_NAME_BEITRAG + " " +
                    WHERE + " " +
                    COLUMN_ID + "=" + "`" + val.getID() + "`" + " " +
                    COLUMN_CREATION_DATE + "=" + "`" + val.getCreationDate() + "`" + " " +
                    COLUMN_NUTZER_ID + "=" + "`" + val.getNutzerID() + "`" + " " +
                    COLUMN_PINNWAND_ID + "=" + "`" + val.getPinnwandID() + "`" +  " " +
                    COLUMN_TEXT + "=" + "`" + val.getText() + "`" + " " +
                    ORDER_BY_ID_STATEMENT_OPTION);
        } catch (SQLException ex) {
            Logger.getLogger(AbonnementMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @return 
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0B0DADF1-20A3-4875-9AA5-6F90023A7F32]
    // </editor-fold> 
    public Vector<Beitrag> getAll () {
        Connection con = DBConnection.connection();
        Vector<Beitrag> beitraege = new Vector<Beitrag>();
        try {
            ResultSet resultSet = con.createStatement().executeQuery(
                SELECT + " " +
                COLUMN_ID + ", " + COLUMN_CREATION_DATE + ", " + COLUMN_NUTZER_ID + ", " + COLUMN_PINNWAND_ID + ", " + COLUMN_TEXT + " " +
                FROM + " " +
                TABLE_NAME_BEITRAG + " " +
                ORDER_BY_ID_STATEMENT_OPTION);
            while (resultSet.next()) {
                try {
                    Beitrag beitrag = new BeitragImpl();
                    beitrag.setID(resultSet.getInt(COLUMN_ID));
                    beitrag.setCreationDate(resultSet.getDate(COLUMN_CREATION_DATE));
                    beitrag.setNutzerID( resultSet.getInt(COLUMN_NUTZER_ID) );
                    beitrag.setPinnwandID(resultSet.getInt(COLUMN_PINNWAND_ID));
                    beitrag.setText(resultSet.getString(COLUMN_TEXT));
                    beitraege.addElement(beitrag);
                }
                catch(SQLException e) {
                    Logger.getLogger(BeitragMapper.class.getName()).log(Level.SEVERE, null, e);
                    break;
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
    public Beitrag findByID (int val) {
        Connection con = DBConnection.connection();
        return null;
    }

}

