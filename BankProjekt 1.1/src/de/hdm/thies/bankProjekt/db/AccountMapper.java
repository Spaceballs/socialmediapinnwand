package de.hdm.thies.bankProjekt.db;

import java.rmi.RemoteException;
import java.sql.*;
import java.util.Vector;

import de.hdm.thies.bankProjekt.data.*;

/**
 * Mapper-Klasse, die <code>Account</code>-Objekte auf eine relationale 
 * Datenbank abbildet.
 * Hierzu wird eine Reihe von Methoden zur Verf�gung gestellt, mit deren Hilfe
 * z.B. Objekte gesucht, erzeugt, modifiziert und gel�scht werden k�nnen. 
 * Das Mapping ist bidirektional. D.h., Objekte k�nnen in DB-Strukturen
 * und DB-Strukturen in Objekte umgewandelt werden.
 * 
 * @see CustomerMapper
 * @author Thies
 */
public class AccountMapper {

	/**
	 * Die Klasse AccountMapper wird nur einmal instantiiert. Man spricht hierbei
	 * von einem sogenannten <b>Singleton</b>.<p>
	 * Diese Variable ist durch den Bezeichner <code>static</code> nur einmal f�r
	 * s�mtliche eventuellen Instanzen dieser Klasse vorhanden. Sie speichert die
	 * einzige Instanz dieser Klasse.
	 * 
	 * @see accountMapper()
	 */
	private static AccountMapper accountMapper = null;
	
	/**
	 * Gesch�tzter Konstruktor - verhindert die M�glichkeit, mit new neue 
	 * Instanzen dieser Klasse zu erzeugen.
	 *
	 */
	protected AccountMapper() {
	}
	
	/**
	 * Diese statische Methode kann aufgrufen werden durch 
	 * <code>AccountMapper.accountMapper()</code>. Sie stellt die 
	 * Singleton-Eigenschaft sicher, indem Sie daf�r sorgt, da� nur eine einzige
	 * Instanz von <code>AccountMapper</code> existiert.<p>
	 * 
	 * <b>Fazit:</b> AccountMapper sollte nicht mittels <code>new</code> 
	 * instantiiert werden, sondern stets durch Aufruf dieser statischen Methode.
	 * 
	 * @return DAS <code>AccountMapper</code>-Objekt.
	 * @see accountMapper
	 */
	public static AccountMapper accountMapper() {
		if ( accountMapper == null ) {
			accountMapper = new AccountMapper();
		}
		
		return accountMapper;
	}
	
	/**
	 * Suchen eines Kontos mit vorgegebener Kontonummer. Da diese eindeutig ist, 
	 * wird genau ein Objekt zur�ckgegeben.
	 * 
	 * @param id Prim�rschl�sselattribut (->DB)
	 * @return Konto-Objekt, das dem �bergebenen Schl�ssel entspricht, null bei 
	 * nicht vorhandenem DB-Tupel.
	 */	
	public Account findByKey(int id) {
		// DB-Verbindung holen
		Connection con = DBConnection.connection();
		
		try {
			// Leeres SQL-Statement (JDBC) anlegen
			Statement stmt = con.createStatement();
			
			// Statement ausf�llen und als Query an die DB schicken	
			ResultSet rs = stmt.executeQuery(
				"SELECT id, owner, balance FROM accounts " +
				"WHERE id=" + id +
				" ORDER BY owner");
			
			/*
			 * Da id Prim�rschl�ssel ist, kann max. nur ein Tupel zur�ckgegeben werden.
			 * Pr�fe, ob ein Ergebnis vorliegt.
			 */	
			if (rs.next()) {
				try {
					// Ergebnis-Tupel in Objekt umwandeln
					Account a = new AccountImpl();
					a.setId(rs.getInt("id"));
					a.setOwner(rs.getInt("owner"));
					a.setBalance( rs.getFloat("balance") );
					return a;
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
	 * Auslesen aller Konten.
	 * 
	 * @return Ein Vektor mit Account-Objekten, die s�mtliche Konten 
	 * repr�sentieren. Bei evtl. Exceptions wird ein partiell gef�llter oder ggf.
	 * auch leerer Vetor zur�ckgeliefert. 
	 */
	public Vector<Account> findAll() {
		Connection con = DBConnection.connection();
		
		// Ergebnisvektor vorbereiten
		Vector<Account> result = new Vector<Account>();
		
		try {
			Statement stmt = con.createStatement();
				
			ResultSet rs = stmt.executeQuery(
				"SELECT id, owner, balance FROM accounts " +
				" ORDER BY id");

			// F�r jeden Eintrag im Suchergebnis wird nun ein Account-Objekt erstellt.				
			while (rs.next()) {
				try {
					Account a = new AccountImpl();
					a.setId(rs.getInt("id"));
					a.setOwner(rs.getInt("owner"));
					a.setBalance( rs.getFloat("balance") );

					// Hinzuf�gen des neuen Objekts zum Ergebnisvektor
					result.addElement(a);
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

		// Ergebnisvektor zur�ckgeben
		return result;
	}
	
	/**
	 * Auslesen aller Konten eines durch Fremdschl�ssel (Kundennr.) gegebenen 
	 * Kunden.
	 * 
	 * @see findByOwner(Customer owner)
	 * @param ownerID Schl�ssel des zugeh�rigen Kunden.
	 * @return Ein Vektor mit Account-Objekten, die s�mtliche Konten des 
	 * betreffenden Kunden repr�sentieren. Bei evtl. Exceptions wird ein partiell 
	 * gef�llter oder ggf. auch leerer Vetor zur�ckgeliefert. 
	 */
	public Vector<Account> findByOwner(int ownerID) {
		Connection con = DBConnection.connection();
		Vector<Account> result = new Vector<Account>();
		
		try {
			Statement stmt = con.createStatement();
				
			ResultSet rs = stmt.executeQuery(
				"SELECT id, owner, balance FROM accounts " +
				"WHERE owner=" + ownerID +
				" ORDER BY id");
				
			// F�r jeden Eintrag im Suchergebnis wird nun ein Account-Objekt erstellt.				
			while (rs.next()) {
				try {
					Account a = new AccountImpl();
					a.setId(rs.getInt("id"));
					a.setOwner( rs.getInt("owner") );
					a.setBalance( rs.getFloat("balance") );

					// Hinzuf�gen des neuen Objekts zum Ergebnisvektor
					result.addElement(a);
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

		// Ergebnisvektor zur�ckgeben
		return result;
	}

	/**
	 * Auslesen aller Konten eines Kunden (durch <code>Customer</code>-Objekt
	 * gegeben).
	 * 
	 * @see findByOwner(int ownerID)
	 * @param owner
	 * @return
	 */	
	public Vector<Account> findByOwner(Customer owner) {
		
		try {
			/*
			 * Wir lesen einfach die Kundennummer (Prim�rschl�ssel) des 
			 * Customer-Objekts aus und delegieren die weitere 
			 * Bearbeitung an findByOwner(int ownerID).
			 */
			return findByOwner(owner.getId());
		}
		catch (RemoteException e) {
			e.printStackTrace();
			/*
			 * Wenn etwas schief geht, geben wir einen leeren Vektor zur�ck. Dies ist
			 * konsistent mit dem Verhalten von findByOwner(int ownerID).
			 */
			return new Vector();
		}
	}
	
	/**
	 * Einf�gen eines <code>Account</code>-Objekts in die Datenbank. Dabei wird 
	 * auch der Prim�rschl�ssel des �bergebenen Objekts gepr�ft und ggf. 
	 * berichtigt.
	 * 
	 * @param a das zu speichernde Objekt 
	 * @return das bereits �bergebene Objekt, jedoch mit ggf. korrigierter 
	 * <code>id</code>.
	 */
	public Account insert(Account a) {
		Connection con = DBConnection.connection();
		
		try {
			Statement stmt = con.createStatement();
				
			/*
			 * Zun�chst schauen wir nach, welches der momentan h�chste 
			 * Prim�rschl�sselwert ist.
			 */
			ResultSet rs = stmt.executeQuery(
				"SELECT MAX(id) AS maxid " +
				"FROM accounts ");
			
			// Wenn wir etwas zur�ckerhalten, kann dies nur einzeilig sein	
			if (rs.next()) {
				try {
					/*
					 * a erh�lt den bisher maximalen, nun um 1 inkrementierten 
					 * Prim�rschl�ssel.
					 */ 
					a.setId(rs.getInt("maxid") + 1);
					
					stmt = con.createStatement();
				
					// Jetzt erst erfolgt die tats�chliche Einf�geoperation
					stmt.executeUpdate("INSERT INTO accounts (id, owner, balance) " +
						"VALUES (" + 
						a.getId() + "," +
						a.getOwner() + "," +
						a.getBalance() + ")");

				}
				catch(RemoteException ex) {
					ex.printStackTrace();
				}
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		/*
		 * R�ckgabe, des evtl. korrigierten Accounts.
		 * 
		 * HINWEIS: Da in Java nur Referenzen auf Objekte und keine physischen
		 * Objekte �bergeben werden, w�re die Anpassung des Account-Objekts auch
		 * ohne diese explizite R�ckgabe au�erhalb dieser Methode sichtbar.
		 * Die explizite R�ckgabe von a ist eher ein Stilmittel, um zu signalisieren,
		 * dass sich das Objekt evtl. im Laufe der Methode ver�ndert hat. 
		 */ 
		return a;
	}
	
	/**
	 * Wiederholtes Schreiben eines Objekts in die Datenbank.
	 * 
	 * @param a das Objekt, das in die DB geschrieben werden soll
	 * @return das als Parameter �bergebene Objekt
	 */
	public Account update(Account a) {
		Connection con = DBConnection.connection();
		
		try {
			Statement stmt = con.createStatement();
				
			stmt.executeUpdate("UPDATE accounts " +
			"SET owner=\"" + a.getOwner() + "\", " +
			"balance=\"" + a.getBalance() + "\" " +
			"WHERE id=" + a.getId());
				
		} catch (SQLException e2) {
			e2.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		// Um Analogie zu insert(Account a) zu wahren, geben wir a zur�ck
		return a;
	}
	
	/**
	 * L�schen der Daten eines <code>Account</code>-Objekts aus der Datenbank.
	 * 
	 * @param a das aus der DB zu l�schende "Objekt"
	 */
	public void delete(Account a) {
		Connection con = DBConnection.connection();
		
		try {
			Statement stmt = con.createStatement();
				
			stmt.executeUpdate("DELETE FROM accounts " +
			"WHERE id=" + a.getId());
				
		} catch (SQLException e2) {
			e2.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * L�schen s�mtlicher Konten (<code>Account</code>-Objekte) eines Kunden.
	 * Diese Methode sollte aufgerufen werden, bevor ein 
	 * <code>Customer</code>-Objekt gel�scht wird.
	 *  
	 * @param c das <code>Customer</code>-Objekt, zu dem die Konten geh�ren
	 */
	public void deleteAccountsOf(Customer c) {
		Connection con = DBConnection.connection();
		
		try {
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate("DELETE FROM accounts " +
			"WHERE owner=" + c.getId());
				
		} catch (SQLException e2) {
			e2.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Auslesen des zugeh�rigen <code>Customer</code>-Objekts zu einem gegebenen
	 * Konto.
	 * 
	 * @param a das Konto, dessen Inhaber wir auslesen m�chten
	 * @return ein Objekt, das den Eigent�mer des Kontos darstellt 
	 */	
	public Customer getOwner(Account a) {
		try {
			/*
			 * Wir bedienen uns hier einfach des CustomerMapper. Diesem geben wir 
			 * einfach den in dem Account-Objekt enthaltenen Fremdschl�ssel f�r den
			 * Kontoinhaber. Der CustomerMapper l�st uns dann diese ID in ein Objekt
			 * auf.
			 */
			return CustomerMapper.customerMapper().findByKey(a.getOwner());
		}
		catch (RemoteException e) {
			e.printStackTrace();
			// Wenn eine Exception auftritt, dann geben wir null zur�ck.
			return null;
		}
	}

}
