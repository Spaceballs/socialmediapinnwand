package SocialMedia_DatabaseManager;

import SocialMedia_Data.Kommentar; 
import SocialMedia_Data.KommentarImpl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.86508071-818C-8C40-6662-8E8A4D4DE5AB]
// </editor-fold> 
public class KommentarMapper extends DBStatementFactory{

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9E5DE831-C9E8-68A8-D649-9ECFB3E846AC]
    // </editor-fold> 
    private static KommentarMapper kommentarMapper = null;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D3B5CF97-9DF3-0750-3151-0AD4546D3D35]
    // </editor-fold> 
    public KommentarMapper () {
    }


    public static KommentarMapper kommentarMapper(){
        if (kommentarMapper == null) {
            kommentarMapper = new KommentarMapper();
        }
        return kommentarMapper;
    }


    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.7866B8A7-10AA-8192-AC55-B9F8AF1AE130]
    // </editor-fold> 
    public Kommentar insert (Kommentar val) {
        Connection con = DBConnection.connection();
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D59859BD-8C69-DEF0-2252-03A01A7EB350]
    // </editor-fold> 
    public Kommentar update (Kommentar val) {
        Connection con = DBConnection.connection();
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.EE3BF1F0-F3A0-F559-4A32-A1057B153199]
    // </editor-fold> 
    public void delete (Kommentar val) {
        Connection con = DBConnection.connection();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.42931436-6E5A-7157-C029-F81BDF5F8CF7]
    // </editor-fold> 
    public Vector<Kommentar> getAll () {
        Connection con = DBConnection.connection();
        Vector<Kommentar> kommentare = new Vector<Kommentar>();
        try {
            ResultSet resultSet = con.createStatement().executeQuery(
                SELECT + " " +
                COLUMN_ID + ", " + COLUMN_CREATION_DATE + ", " + COLUMN_NUTZER_ID + ", " + COLUMN_BEITRAG_ID + ", " + COLUMN_TEXT + " " +
                FROM + " " +
                TABLE_NAME_KOMMENTAR + " " +
                ORDER_BY_ID_STATEMENT_OPTION);

            while (resultSet.next()) {
                try {
                    Kommentar kommentar = new KommentarImpl();
                    kommentar.setID(resultSet.getInt(COLUMN_ID));
                    kommentar.setCreationDate(resultSet.getDate(COLUMN_CREATION_DATE));
                    kommentar.setNutzerID( resultSet.getInt(COLUMN_NUTZER_ID) );
                    kommentar.setBeitragID(resultSet.getInt(COLUMN_BEITRAG_ID));
                    kommentar.setText(resultSet.getString(COLUMN_TEXT));
                    kommentare.addElement(kommentar);
                }
                catch(SQLException e) {
                    e.printStackTrace();
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kommentare;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5A7836AD-406C-422D-ADA6-76B6D52AF31F]
    // </editor-fold> 
    public Kommentar findByID (int val) {
        Connection con = DBConnection.connection();
        return null;
    }

}

