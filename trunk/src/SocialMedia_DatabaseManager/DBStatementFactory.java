/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_DatabaseManager;

import java.sql.Statement;

/**
 *
 * @author Sebastian
 */
public abstract class DBStatementFactory {
    
    final String SELECT = "SELECT ";
    final String INSERT = "INSERT ";
    final String UPDATE = "UPDATE ";
    final String FROM = "FROM ";
    
    final String COLUMN_ID = "id";
    final String COLUMN_CREATION_DATE = "creationDate";
    final String COLUMN_NUTZER_ID = "nutzerID";
    final String COLUMN_PINNWAND_ID = "pinnwandID";
    final String COLUMN_KOMMENTAR_ID = "kommentarID";
    final String COLUMN_BEITRAG_ID = "beitragID";
    final String COLUMN_LIKE_ID = "likeID";
    final String COLUMN_NICKNAME = "nickname";
    final String COLUMN_NACHNAME = "nachname";
    final String COLUMN_VORNAME = "vorname";
    final String COLUMN_PASSWORD = "password";
    final String COLUMN_TEXT = "text";
    
    final String TABLE_NAME_ABONNEMENT = "socialMediaApplication_abonnement";
    final String TABLE_NAME_NUTZER = "socialMediaApplication_nutzer";
    final String TABLE_NAME_PINNWAND = "socialMediaApplication_pinnwand";
    final String TABLE_NAME_LIKE = "socialMediaApplication_like";
    final String TABLE_NAME_BEITRAG = "socialMediaApplication_beitrag";
    final String TABLE_NAME_KOMMENTAR = "socialMediaApplication_kommentar";

    final String ORDER_BY_ID_STATEMENT_OPTION = "Order BY id";
    
    public String statementFactory(Object o){
        o.g
        return "";
    }
}
