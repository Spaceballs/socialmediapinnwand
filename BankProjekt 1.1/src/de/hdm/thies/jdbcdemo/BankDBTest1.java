package de.hdm.thies.jdbcdemo;
import java.sql.*;

/**
 * Überprüfung des Zugangs zur BankProject-Datenbank
 * auf dem lokalen Rechner.<p>
 * 
 * <b>Anwendungsfall:</b> Auslesen aller Konten der DB.<p>
 * 
 * Hinweise zum Aufbau der Klasse entnehmen Sie bitte der Klasse <code>
 * TestConnection</code>. Beide Klassen besitzen einen analogen Aufbau.
 * 
 * @see TestConnection
 * @author Thies
 */
public class BankDBTest1 {

	public static void main(String[] args) {
		try {
			System.out.println("Demo: Auslesen aller Konten");
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Treiber ok!");

			Connection con = null;
	
			try {
				con = DriverManager.getConnection(
					"jdbc:mysql://localhost/BankProject?user=demo&password=demo");
				System.out.println("Connection ok!");

				Statement stmt = con.createStatement();
				
				ResultSet rs = stmt.executeQuery("SELECT accounts.id, balance, " +
					"firstName, lastName " + 
					"FROM customers, accounts " + 
					"WHERE customers.id = accounts.owner " +
					"ORDER BY lastName");
				
				System.out.println("Ergebnis:");

				while (rs.next()) {

					int id = rs.getInt("id");
					float balance = rs.getFloat("balance");
					String first = rs.getString("firstName");
					String last = rs.getString("lastName");

					System.out.println(id + ": \t" + balance + ", \t" + last + ", " + first);

				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			con.close();
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
