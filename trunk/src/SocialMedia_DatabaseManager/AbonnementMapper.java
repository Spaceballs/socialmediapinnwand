package SocialMedia_DatabaseManager;

import SocialMedia_Data.Abonnement; 
import SocialMedia_Data.AbonnementImpl;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.86058FE3-4703-84A6-19E0-7413B2A65EE8]
// </editor-fold> 
public class AbonnementMapper extends DBStatementFactory {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4F343793-5692-58DE-EA80-D99B835998E9]
    // </editor-fold> 
    private static AbonnementMapper abonnementMapper = null;
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5767551A-2A74-DDFE-D2F0-8B38B96D1742]
    // </editor-fold> 
    protected AbonnementMapper () {
    }

    public static AbonnementMapper abonnementMapper(){
        if(abonnementMapper == null){
            abonnementMapper = new AbonnementMapper();
        }
        return abonnementMapper;
    }


    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.07672B8C-2DA5-0B58-2173-FAF4118927BD]
    // </editor-fold> 
    public Abonnement insert (Abonnement val) {
        Connection con = DBConnection.connection();
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.720694C4-3F40-2FAE-694D-624DF8707ACE]
    // </editor-fold> 
    public Abonnement update (Abonnement val) {
        Connection con = DBConnection.connection();
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3BF353D9-FF07-B451-4B89-20F8318BE4F0]
    // </editor-fold> 
    public void delete (Abonnement val) {
        Connection con = DBConnection.connection();
        try {
            con.createStatement().executeQuery(
                    DELETE + " " +
                    FROM + " " +
                    TABLE_NAME_ABONNEMENT + " " +
                    WHERE + " " +
                    COLUMN_ID + "=" + "`" + val.getID() + "`" +
                    COLUMN_CREATION_DATE + "=" + "`" + val.getCreationDate() + "`" +
                    COLUMN_NUTZER_ID + "=" + "`" + val.getNutzerID() + "`" +
                    COLUMN_PINNWAND_ID + "=" + "`" + val.getPinnwandID() + "`"
            );
        } catch (SQLException ex) {
            Logger.getLogger(AbonnementMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.FF6B8927-E3C3-0DF3-8FD2-6F803361FCCF]
    // </editor-fold> 
    public Vector<Abonnement> getAll () {
        Connection con = DBConnection.connection();
        Vector<Abonnement> abonnements = new Vector<Abonnement>();
        try {
            ResultSet resultSet = con.createStatement().executeQuery(
                SELECT + " " +
                COLUMN_ID + ", " + COLUMN_CREATION_DATE + ", " + COLUMN_NUTZER_ID + ", " + COLUMN_PINNWAND_ID + " " +
                FROM + " " +
                TABLE_NAME_ABONNEMENT + " " +
                ORDER_BY_ID_STATEMENT_OPTION);

            while (resultSet.next()) {
                try {
                    Abonnement abonnement = new AbonnementImpl();
                    abonnement.setID(resultSet.getInt(COLUMN_ID));
                    abonnement.setCreationDate(resultSet.getDate(COLUMN_CREATION_DATE));
                    abonnement.setNutzerID( resultSet.getInt(COLUMN_NUTZER_ID) );
                    abonnement.setPinnwandID(resultSet.getInt(COLUMN_PINNWAND_ID));
                    abonnements.addElement(abonnement);
                }
                catch(SQLException e) {
                    e.printStackTrace();
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return abonnements;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8FEA238D-153E-6EFA-188A-255C783AA53D]
    // </editor-fold> 
    public Abonnement findByID (int val) {
        Connection con = DBConnection.connection();
        return null;
    }

}

