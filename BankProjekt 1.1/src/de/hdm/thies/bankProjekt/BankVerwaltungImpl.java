package de.hdm.thies.bankProjekt;

import java.rmi.RemoteException;
import java.util.Vector;

import de.hdm.thies.bankProjekt.data.*;
import de.hdm.thies.bankProjekt.db.*;
import de.hdm.thies.bankProjekt.report.*;

/**
 * Implementierungsklasse des Interface <code>BankVerwaltung</code>.
 * @see BankVerwaltung
 * @author Thies
 */
public class BankVerwaltungImpl	
	extends java.rmi.server.UnicastRemoteObject 
	implements BankVerwaltung {

	/**
	 * Referenz auf das zugehörige Bank-Objekt.
	 */
	private Bank bank = null;
	
	/**
	 * Referenz auf den DatenbankMapper, der Kundenobjekte mit der Datenbank
	 * abgleicht.
	 */
	private CustomerMapper cMapper = null;

	/**
	 * Referenz auf den DatenbankMapper, der Kontoobjekte mit der Datenbank
	 * abgleicht.
	 */
	private AccountMapper aMapper = null;
	
	/**
	 * Referenz auf den ReportGenerator.
	 */
	private ReportGenerator reportGenerator = null;
	
	/**
	 * Konstruktor. Empfängt als Parameter die Bank, die zu verwalten ist sowie
	 * ein <code>CustomerMapper</code>-Objekt und ein 
	 * <code>AccountMapper</code>-Objekt zwecks Datenbankanbindung.
	 * 
	 * @param b die zu verwaltende Bank
	 * @param c der CustomerMapper
	 * @param a der AccountMapper
	 * @throws RemoteException
	 */
	public BankVerwaltungImpl(Bank b, CustomerMapper c, AccountMapper a)
		throws RemoteException {
		super();
		this.bank = b;
		this.cMapper = c;
		this.aMapper = a;
		this.reportGenerator = new ReportGeneratorImpl(this);
	}

	/**
	 * Anlegen eines neuen Kontos für den übergebenen Kunden. Dies führt implizit
	 * zu einem Speichern des neuen, leeren Kontos in der Datenbank.<p>
	 * 
	 * <b>HINWEIS:</b> Änderungen an Account-Objekten müssen stets durch Aufruf von
	 * <code>save(Account a)</code> in die Datenbank transferiert werden.
	 * 
	 * @see	save(Account a)
	 * @see save(Customer c)
	 */	
	public Account createAccountFor(Customer c) 
		throws RemoteException {
		Account a = new AccountImpl();
		a.setOwner(c.getId());
		/* 
		 * Setzen einer vorläufigen Kontonr. Der insert-Aufruf liefert dann ein 
		 * Objekt, dessen Nummer mit der Datenbank konsistent ist.
		 */
		a.setId(1);

		// Objekt in der DB speichern.
		return this.aMapper.insert(a);
	}

	/**
	 * Anlegen eines neuen Kunden. Dies führt implizit
	 * zu einem Speichern des neuen Kunden in der Datenbank.<p>
	 * 
	 * <b>HINWEIS:</b> Änderungen an Customer-Objekten müssen stets durch Aufruf von
	 * <code>save(Customer c)</code> in die Datenbank transferiert werden.
	 * 
	 * @see save(Customer c)
	 * @see	save(Account a)
	 */
	public Customer createCustomer(String first, String last) 
		throws RemoteException {
		Customer c = new CustomerImpl();
		c.setFirstName(first);
		c.setLastName(last);		
		/* 
		 * Setzen einer vorläufigen Kundennr. Der insert-Aufruf liefert dann ein 
		 * Objekt, dessen Nummer mit der Datenbank konsistent ist.
		 */
		c.setId(1);
		
		// Objekt in der DB speichern.
		return this.cMapper.insert(c);
	}

	public void deleteAccount(Account a) 
		throws RemoteException {
		// Account aus der DB entfernen
		this.aMapper.delete(a);
	}

	public void deleteCustomer(Customer c) 
		throws RemoteException {

		// Zunächst sämtl. Konten des Kunden aus der Db entfernen.
		this.aMapper.deleteAccountsOf(c);
		// Anschließend den Kunden entfernen
		this.cMapper.delete(c);
	}

	public Bank getBank() 
		throws java.rmi.RemoteException {
		return this.bank;		
	}

	public Vector<Account> getAccountsOf(Customer c) 
		throws java.rmi.RemoteException {
		
		return this.aMapper.findByOwner(c);
	}

	public Vector<Customer> getCustomerByName(String lastName)
		throws java.rmi.RemoteException {
		
		return this.cMapper.findByLastName(lastName);				
	}

	public Customer getCustomerById(int id)
		throws java.rmi.RemoteException {
		
		return this.cMapper.findByKey(id);				
	}

	public Vector<Customer> getAllCustomers() 
		throws java.rmi.RemoteException {
		return this.cMapper.findAll();
	}

	public Vector<Account> getAllAccounts() 
		throws java.rmi.RemoteException {
		return this.aMapper.findAll();
	}

	public void save(Account a) 
		throws RemoteException {
		aMapper.update(a);
	}

	public void save(Customer c) 
		throws RemoteException {
		cMapper.update(c);
	}

	public ReportGenerator getReportGenerator() 
		throws RemoteException {
		return this.reportGenerator;
	}

}
