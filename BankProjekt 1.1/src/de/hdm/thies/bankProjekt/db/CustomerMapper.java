package de.hdm.thies.bankProjekt.db;

import java.rmi.RemoteException;
import java.sql.*;
import java.util.Vector;

import de.hdm.thies.bankProjekt.data.*;

/**
 * Mapper-Klasse, die <code>Customer</code>-Objekte auf eine relationale 
 * Datenbank abbildet.
 * Hierzu wird eine Reihe von Methoden zur Verfügung gestellt, mit deren Hilfe
 * z.B. Objekte gesucht, erzeugt, modifiziert und gelöscht werden können. 
 * Das Mapping ist bidirektional. D.h., Objekte können in DB-Strukturen
 * und DB-Strukturen in Objekte umgewandelt werden.<p>
 * 
 * <b>Hinweis:</b> Diese Klasse ist analog zur Klasse <code>AccountMapper</code>
 * implementiert.
 * 
 * @see AccountMapper
 * @author Thies
 */

public class CustomerMapper {

	/**
	 * Die Klasse CustomerMapper wird nur einmal instantiiert. Man spricht hierbei
	 * von einem sogenannten <b>Singleton</b>.<p>
	 * Diese Variable ist durch den Bezeichner <code>static</code> nur einmal für
	 * sämtliche eventuellen Instanzen dieser Klasse vorhanden. Sie speichert die
	 * einzige Instanz dieser Klasse.
	 * 
	 * @see accountMapper()
	 */
	private static CustomerMapper customerMapper = null;
	
	/**
	 * Geschützter Konstruktor - verhindert die Möglichkeit, mit new neue 
	 * Instanzen dieser Klasse zu erzeugen.
	 *
	 */
	protected CustomerMapper() {
	}
	
	/**
	 * Diese statische Methode kann aufgrufen werden durch 
	 * <code>CustomerMapper.customerMapper()</code>. Sie stellt die 
	 * Singleton-Eigenschaft sicher, indem Sie dafür sorgt, daß nur eine einzige
	 * Instanz von <code>CustomerMapper</code> existiert.<p>
	 * 
	 * <b>Fazit:</b> CustomerMapper sollte nicht mittels <code>new</code> 
	 * instantiiert werden, sondern stets durch Aufruf dieser statischen Methode.
	 * 
	 * @return DAS <code>CustomerMapper</code>-Objekt.
	 * @see customerMapper
	 */
	public static CustomerMapper customerMapper() {
		if ( customerMapper == null ) {
			customerMapper = new CustomerMapper();
		}
		
		return customerMapper;
	}
		
	/**
	 * Suchen eines Kunden mit vorgegebener Kundennummer. Da diese eindeutig ist, 
	 * wird genau ein Objekt zurückgegeben.
	 * 
	 * @param id Primärschlüsselattribut (->DB)
	 * @return Kunden-Objekt, das dem übergebenen Schlüssel entspricht, null bei 
	 * nicht vorhandenem DB-Tupel.
	 */	
	public Customer findByKey(int id) {
		// DB-Verbindung holen
		Connection con = DBConnection.connection();
		
		try {
			// Leeres SQL-Statement (JDBC) anlegen
			Statement stmt = con.createStatement();
				
			// Statement ausfüllen und als Query an die DB schicken	
			ResultSet rs = stmt.executeQuery(
				"SELECT id, firstName, lastName FROM customers " +
				"WHERE id=" + id +
				" ORDER BY lastName");
				
			/*
			 * Da id Primärschlüssel ist, kann max. nur ein Tupel zurückgegeben werden.
			 * Prüfe, ob ein Ergebnis vorliegt.
			 */	
			if (rs.next()) {
				try {
					// Ergebnis-Tupel in Objekt umwandeln
					Customer c = new CustomerImpl();
					c.setId(rs.getInt("id"));
					c.setFirstName(rs.getString("firstName"));
					c.setLastName(rs.getString("lastName"));
					
					return c;
				}
				catch(RemoteException ex) {
					ex.printStackTrace();
					return null;
				}
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}

		return null;
	}
	
	/**
	 * Auslesen aller Kunden.
	 * 
	 * @return Ein Vektor mit Customer-Objekten, die sämtliche Kunden
	 * repräsentieren. Bei evtl. Exceptions wird ein partiell gefüllter oder ggf.
	 * auch leerer Vetor zurückgeliefert. 
	 */
	public Vector<Customer> findAll() {
		Connection con = DBConnection.connection();
		// Ergebnisvektor vorbereiten
		Vector<Customer> result = new Vector<Customer>();
		
		try {
			Statement stmt = con.createStatement();
				
			ResultSet rs = stmt.executeQuery(
				"SELECT id, firstName, lastName " +
				"FROM customers " +
				"ORDER BY lastName");
				
			// Für jeden Eintrag im Suchergebnis wird nun ein Customer-Objekt erstellt.				
			while (rs.next()) {
				try {
					Customer c = new CustomerImpl();
					c.setId(rs.getInt("id"));
					c.setFirstName(rs.getString("firstName"));
					c.setLastName(rs.getString("lastName"));

					// Hinzufügen des neuen Objekts zum Ergebnisvektor
					result.addElement(c);
				}
				catch(RemoteException ex) {
					ex.printStackTrace();
					// Bei einer evtl. Exception brechen wir die while-Schleife ab. 
					break;
				}
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}

		// Ergebnisvektor zurückgeben
		return result;
	}
	
	/**
	 * Auslesen aller Kunden-Objekte mit gegebenem Nachnamen
	 * 
	 * @param name Nachname der Kunden, die ausgegeben werden sollen
	 * @return Ein Vektor mit Customer-Objekten, die sämtliche Kunden mit dem
	 * gesuchten Nachnamen repräsentieren. Bei evtl. Exceptions wird ein partiell 
	 * gefüllter oder ggf. auch leerer Vetor zurückgeliefert. 
	 */
	public Vector<Customer> findByLastName(String name) {
		Connection con = DBConnection.connection();
		Vector<Customer> result = new Vector<Customer>();
		
		try {
			Statement stmt = con.createStatement();
				
			ResultSet rs = stmt.executeQuery(
				"SELECT id, firstName, lastName " +
				"FROM customers " +
				"WHERE lastName LIKE '" + name +
				"' ORDER BY lastName");
				
			// Für jeden Eintrag im Suchergebnis wird nun ein Customer-Objekt erstellt.				
			while (rs.next()) {
				try {
					Customer c = new CustomerImpl();
					c.setId(rs.getInt("id"));
					c.setFirstName(rs.getString("firstName"));
					c.setLastName(rs.getString("lastName"));

					// Hinzufügen des neuen Objekts zum Ergebnisvektor
					result.addElement(c);
				}
				catch(RemoteException ex) {
					ex.printStackTrace();
					// Bei einer evtl. Exception brechen wir die while-Schleife ab. 
					break;
				}
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}

		// Ergebnisvektor zurückgeben
		return result;
	}
	
	/**
	 * Einfügen eines <code>Customer</code>-Objekts in die Datenbank. Dabei wird 
	 * auch der Primärschlüssel des übergebenen Objekts geprüft und ggf. 
	 * berichtigt.
	 * 
	 * @param c das zu speichernde Objekt 
	 * @return das bereits übergebene Objekt, jedoch mit ggf. korrigierter 
	 * <code>id</code>.
	 */
	public Customer insert(Customer c) {
		Connection con = DBConnection.connection();
		
		try {
			Statement stmt = con.createStatement();
				
			/*
			 * Zunächst schauen wir nach, welches der momentan höchste 
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery(
				"SELECT MAX(id) AS maxid " +
				"FROM customers ");
				
			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein	
			if (rs.next()) {
				try {
					/*
					 * c erhält den bisher maximalen, nun um 1 inkrementierten 
					 * Primärschlüssel.
					 */ 
					c.setId(rs.getInt("maxid") + 1);
					
					stmt = con.createStatement();
				
					// Jetzt erst erfolgt die tatsächliche Einfügeoperation
					stmt.executeUpdate("INSERT INTO customers (id, firstName, lastName) " +
						"VALUES (" + 
						c.getId() + ",'" +
						c.getFirstName() + "','" +
						c.getLastName() + "')");

				}
				catch(RemoteException ex) {
					ex.printStackTrace();
				}
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		/*
		 * Rückgabe, des evtl. korrigierten Customers.
		 * 
		 * HINWEIS: Da in Java nur Referenzen auf Objekte und keine physischen
		 * Objekte übergeben werden, wäre die Anpassung des Customer-Objekts auch
		 * ohne diese explizite Rückgabe außerhalb dieser Methode sichtbar.
		 * Die explizite Rückgabe von c ist eher ein Stilmittel, um zu signalisieren,
		 * dass sich das Objekt evtl. im Laufe der Methode verändert hat. 
		 */ 
		return c;
	}
	
	/**
	 * Wiederholtes Schreiben eines Objekts in die Datenbank.
	 * 
	 * @param c das Objekt, das in die DB geschrieben werden soll
	 * @return das als Parameter übergebene Objekt
	 */
	public Customer update(Customer c) {
		Connection con = DBConnection.connection();
		
		try {
			Statement stmt = con.createStatement();
				
			stmt.executeUpdate("UPDATE customers " +
			"SET firstName=\"" + c.getFirstName() + "\", " +
			"lastName=\"" + c.getLastName() + "\" " +
			"WHERE id=" + c.getId());
				
		} catch (SQLException e2) {
			e2.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		// Um Analogie zu insert(Customer c) zu wahren, geben wir c zurück
		return c;
	}
	
	/**
	 * Löschen der Daten eines <code>Customer</code>-Objekts aus der Datenbank.
	 * 
	 * @param c das aus der DB zu löschende "Objekt"
	 */
	public void delete(Customer c) {
		Connection con = DBConnection.connection();
		
		try {
			Statement stmt = con.createStatement();
				
			stmt.executeUpdate("DELETE FROM customers " +
			"WHERE id=" + c.getId());
				
		} catch (SQLException e2) {
			e2.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Auslesen der zugehörigen <code>Account</code>-Objekte zu einem gegebenen
	 * Kunden.
	 * 
	 * @param c der Kunde, dessen Konten wir auslesen möchten
	 * @return ein Vektor mit sämtlichen Konto-Objekten des Kunden
	 */	
	public Vector<Account> getAccountsOf(Customer c) {
		/*
		 * Wir bedienen uns hier einfach des AccountMapper. Diesem geben wir 
		 * einfach den in dem Customer-Objekt enthaltenen Primärschlüssel.Der 
		 * CustomerMapper löst uns dann diese ID in eine Reihe von Konto-Objekten
		 * auf.
		 */
		return AccountMapper.accountMapper().findByOwner(c);
	}
}
