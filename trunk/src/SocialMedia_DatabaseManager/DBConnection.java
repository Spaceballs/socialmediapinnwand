package SocialMedia_DatabaseManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.A4ED5D05-F32A-7295-BD5A-592B6585AEDB]
// </editor-fold> 
public class DBConnection {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.65ECE7B0-DE0C-A9D9-75FD-02417B6EE7D0]
    // </editor-fold> 
    private static Connection con = null;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.152435AE-BD70-7A93-09A2-29A72C2F852F]
    // </editor-fold> 
    private static String url = "jdbc:mysql://mars.iuk.hdm-stuttgart.de/u-mk173?user=mk173&password=oof7eiM2ua";

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.82C17374-FFED-AA2D-BAAE-8FC453E9BEF6]
    // </editor-fold> 
	public static Connection connection() {
		if ( con == null ) {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				con = DriverManager.getConnection(url);
			}
			catch (SQLException e) {
				con = null;
				e.printStackTrace();
			}
			catch (InstantiationException e) {
				con = null;
				e.printStackTrace();
			}
			catch (IllegalAccessException e) {
				con = null;
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				con = null;
				e.printStackTrace();
			}
		}
		return con;
	}
}

