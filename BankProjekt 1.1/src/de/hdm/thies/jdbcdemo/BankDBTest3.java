package de.hdm.thies.jdbcdemo;
import java.sql.*;

/**
 * Überprüfung des Zugangs zur BankProject-Datenbank
 * auf dem lokalen Rechner.<p>
 * 
 * <b>Anwendungsfall:</b> Hinzufügen eines neuen Kontos.<p>
 * 
 * Hinweise zum Aufbau der Klasse entnehmen Sie bitte der Klasse <code>
 * TestConnection</code>. Beide Klassen besitzen einen analogen Aufbau.
 * 
 * @see TestConnection
 * @author Thies
 */
public class BankDBTest3 {

	public static void main(String[] args) {
		try {
			System.out.println(
				"Demo: Hinzufügen eines neuen Kontos für " + "Gerhard Schröder");

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Treiber ok!");

			Connection con = null;

			try {
				con =
					DriverManager.getConnection(
						"jdbc:mysql://localhost/BankProject?user=demo&password=demo");
				System.out.println("Connection ok!");

				Statement stmt = con.createStatement();

				/*
				 * Beachten Sie hier, dass SELECTs mit executeQuery und UPDATEs sowie
				 * INSERTs mit executeUpdate an die DB geschickt werden.
				 */
				int result =
					stmt.executeUpdate("INSERT INTO accounts " + "VALUES (9,6,100.00)");

				/*
				 * In result finden Sie dann einen Rückgabewert, der signalisiert, ob
				 * die Aktion erfolgreich war oder micht. Die Bedeutung der einzelnen
				 * Integer-Werte findet man in der Java-Referenz. 
				 */
				System.out.println("Ergebnis: " + result);
			}
			catch (SQLException e2) {
				e2.printStackTrace();
			}

			con.close();
		}
		catch (InstantiationException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
