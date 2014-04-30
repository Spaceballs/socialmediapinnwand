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
    
    final String WHERE = "WHERE";
    final String DELETE = "DELETE";
    final String SELECT = "SELECT";
    final String INSERT = "INSERT";
    final String UPDATE = "UPDATE";
    final String FROM = "FROM";
    
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
    final String COLUMN_LIKE = "likes";
    
    final String TABLE_NAME_ABONNEMENT = "`abonnement`";
    final String TABLE_NAME_NUTZER = "`nutzer`";
    final String TABLE_NAME_PINNWAND = "`pinnwand`";
    final String TABLE_NAME_LIKE = "`like`";
    final String TABLE_NAME_BEITRAG = "`beitrag`";
    final String TABLE_NAME_KOMMENTAR = "`kommentar`";

    final String ORDER_BY_ID_STATEMENT_OPTION = "Order BY id";
}
