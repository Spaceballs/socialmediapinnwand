package de.hdm.thies.bankProjekt;

import java.util.Vector;

import de.hdm.thies.bankProjekt.data.*;
import de.hdm.thies.bankProjekt.report.ReportGenerator;

/**
 * Schnittstelle für eine Klasse zur Verwaltung von Banken.<p>
 * 
 * <b>Frage:</b> Warum werden diese Methoden nicht als Teil der Klassen 
 * <code>Bank</code> oder <code>Customer</code> implementiert?<br>
 * <b>Antwort:</b> Z.B. das Löschen eines Kunden erfordert Kenntnisse über die
 * Verflechtung eines Kunden mit Konto-Objekten. Um die Klasse <code>Bank</code>
 * bzw. <code>Customer</code> nicht zu stark an andere Klassen zu koppeln, wird
 * das Wissen darüber, wie einzelne "Daten"-Objekte koexistieren, in der 
 * vorliegenden Klasse gekapselt. 
 * 
 * @author Thies
 */
public interface BankVerwaltung 
	extends java.rmi.Remote {

	/**
	 * Einen Kunden anlegen.
	 * 
	 * @param first Vorname
	 * @param last Nachname
	 * @return Ein fertiges Kunden-Objekt.
	 * @throws java.rmi.RemoteException
	 */
	public Customer createCustomer(String first, String last) 
		throws java.rmi.RemoteException;
  
  /**
   * Einen Kunden löschen.
   * 
   * @param c zu löschender Kunde
   * @throws java.rmi.RemoteException
   */
	public void deleteCustomer(Customer c) 
		throws java.rmi.RemoteException;
	
	/**
	 * Ein neues Konto für einen gegebenen Kunden eröffnen.
	 * 
	 * @param c der Kunde
	 * @return fertiges Konto-Objekt
	 * @throws java.rmi.RemoteException
	 */
	public Account createAccountFor(Customer c) 
		throws java.rmi.RemoteException;
		
	/**
	 * Ein Konto löschen.
	 * 
	 * @param a zu löschendes Konto
	 * @throws java.rmi.RemoteException
	 */
	public void deleteAccount(Account a) 
		throws java.rmi.RemoteException;
	
	/**
	 * Auslesen der zugeordneten Bank.
	 *  
	 * @return Bank-Objekt
	 * @throws java.rmi.RemoteException
	 */
	public Bank getBank() 
		throws java.rmi.RemoteException;
	
	/**
	 * Konten eines Kunden auslesen.
	 * @param Kundenobjekt
	 * @return Vector-Objekt mit Account-Objekten bzgl. des Kunden.
	 * @throws java.rmi.RemoteException
	 */
	public Vector<Account> getAccountsOf(Customer c) throws java.rmi.RemoteException;

	/**
	 * Suchen von Customer-Objekten, von denen der Zuname bekannt ist. 
	 * @param lastName ist der Nachname.
	 * @return Alle Customer-Objekte, die die Suchkriterien erfüllen.
	 * @throws java.rmi.RemoteException
	 */
	public Vector<Customer> getCustomerByName(String lastName)
		throws java.rmi.RemoteException;

	/**
	 * Suchen eines Customer-Objekts, dessen Kundennummer bekannt ist. 
	 * @param id ist die Kundennummer.
	 * @return Das erste Customer-Objekt, dass den Suchkriterien entspricht.
	 * @throws java.rmi.RemoteException
	 */
	public Customer getCustomerById(int id) throws java.rmi.RemoteException;

	/**
	 * Sämtliche Kunden der Bank auslesen.
	 * 
	 * @return Vector sämtlicher Kunden
	 */
	public Vector<Customer> getAllCustomers() throws java.rmi.RemoteException;

	/**
	 * Sämtliche Konten der Bank auslesen.
	 * 
	 * @return Vector sämtlicher Konten
	 * @author Thies
	 */
	public Vector<Account> getAllAccounts() throws java.rmi.RemoteException;

	/**
	 * Speichern eines Account-Objekts in der Datenbank.
	 * @param a zu sicherndes Objekt.
	 * @throws java.rmi.RemoteException
	 */
	public void save(Account a) throws java.rmi.RemoteException;

	/**
	 * Speichern eines Customer-Objekts in der Datenbank.
	 * @param c zu sicherndes Objekt.
	 * @throws java.rmi.RemoteException
	 */
	public void save(Customer c) throws java.rmi.RemoteException;

	/**
	 * Auslesen des ReportGenerators.
	 * @return ReportGenerator-Objekt.
	 * @throws java.rmi.RemoteException
	 */
	public ReportGenerator getReportGenerator() throws java.rmi.RemoteException;
}
