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
    final String INSERT_INTO = "INSERT INTO";
    final String VALUES = "VALUES";
    final String SET = "SET";
    
    final String COLUMN_ID = "id";
    final String COLUMN_CREATION_DATE = "creationDate";
    final String COLUMN_NUTZER_ID = "nutzerID";
    final String COLUMN_PINNWAND_ID = "pinnwandID";
    final String COLUMN_KOMMENTAR_ID = "kommentarID";
    final String COLUMN_BEITRAG_ID = "beitragID";
    final String COLUMN_LIKE_ID = "likeID";
    final String COLUMN_NICKNAME = "username";
    final String COLUMN_NACHNAME = "name";
    final String COLUMN_VORNAME = "surname";
    final String COLUMN_PASSWORD = "password";
    final String COLUMN_TEXT = "text";
    
    final String TABLE_NAME_ABONNEMENT = "`abonnement`";
    final String TABLE_NAME_NUTZER = "`nutzer`";
    final String TABLE_NAME_PINNWAND = "`pinnwand`";
    final String TABLE_NAME_LIKE = "`like`";
    final String TABLE_NAME_BEITRAG = "`beitrag`";
    final String TABLE_NAME_KOMMENTAR = "`kommentar`";

    final String ORDER_BY_ID_STATEMENT_OPTION = "Order BY id";
    final String ORDER_BY_ID_DESC_STATEMENT_OPTION = "Order BY id DESC";
    final String MAX_ID_STATEMENT_OPTION = "MAX(id)";
    final String LIMIT_STATEMENT_OPTION = "LIMIT";
    
}
