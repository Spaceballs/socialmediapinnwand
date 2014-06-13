package de.hdm.thies.jdbcdemo;
import java.sql.*;

/**
 * Ziel dieser Klasse ist die Überprüfung des Zugangs zur Test-Datenbank
 * auf dem lokalen Rechner.
 * 
 * Verbindungen mit mySQL werden stets nach folgender Struktur beschrieben:
 * <code>jdbc:mysql://[hostname][,failoverhost...][:port]/[dbname][?param1=value1][&param2=value2].....</code>
 * 
 * @author Thies
 */
public class TestConnection {

	public static void main(String[] args) {
		try {
			// Zunächst ist der entsprechende Datenbank-Treiber zu laden.
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Treiber ok!");

			Connection con = null;

			try {
				/*
				 * Wir fordern nun eine Verbindung an:
				 * DBMS: mySQL
				 * Ort: localhost
				 * Account: demo
				 * Passwort: demo
				 */
				con =
					DriverManager.getConnection(
						"jdbc:mysql://localhost/test?user=demo&password=demo");
				System.out.println("Connection ok!");

				/*
				 * Schließlich versuchen wir noch, ein SQL-Statement an die Datenbank
				 * zu senden.
				 */

				// Ein leeres Statement anlegen.
				Statement stmt = con.createStatement();

				/*
				 * Dem Statement nennen wir nun die Anfrage, die an die Datenbank zu
				 * senden ist.
				 * Als Rückgabewert erhalten wir dann eine Tabelle, die die Ergebnis-
				 * menge der Anfrage enthält.
				 */
				ResultSet rs =
					stmt.executeQuery(
						"SELECT id, name, vorname FROM people ORDER BY name");

				// Nun werten wir jedes einzelne Tupel der Ergebnismenge aus.				
				while (rs.next()) {
					/*
					 * Die in der Anfrage genannte Tabelle people enthaelt die Attribute
					 * id, name, vorname. Diese wollen wir nun von jedem Tupel auslesen.
					 */
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String vorname = rs.getString("vorname");
					// Wir geben die Ergebnismenge tupelweise (zeilenweise) aus.
					System.out.println(id + ": " + name + ", " + vorname);
				}
			}
			catch (SQLException e2) {
				/* 
				 * Sollte ein Fehler bei der DB-Anfrage auftreten, würde der
				 * Programmablauf hier weitergehen.
				 */
				e2.printStackTrace();
			}

			// Abschließend schließen wir die DB-Verbindung.
			con.close();

		}
		catch (InstantiationException e) {
			/* 
			 * Wenn ein Fehler bei der Instantiierung des DB-Treiber aufträte, würde der
			 * Programmablauf hier fortgesetzt.
			 */
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			/* 
			 * Wenn ein Fehler bzgl. der Zugriffberechtigungen für die DB aufträte, 
			 * würde der Programmablauf hier fortgesetzt.
			 */
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			/* 
			 * ClassNotFoundException ist ebenfalls ein möglicher Fehler bei der 
			 * Instantiierung des DB-Treibers.
			 */
			e.printStackTrace();
		} 
		catch (SQLException e) {
			/* 
			 * Sollte ein allg. Fehler z.B. beim Aufbau der Verbindung auftreten, würde der
			 * Programmablauf hier weitergehen.
			 */
			e.printStackTrace();
		}

	}
}
