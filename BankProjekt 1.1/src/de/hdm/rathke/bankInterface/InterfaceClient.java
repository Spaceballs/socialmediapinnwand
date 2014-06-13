/*
 * Created on 11.12.2004
 *
 */
package de.hdm.rathke.bankInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Vector;

import de.hdm.thies.bankProjekt.BankVerwaltung;
import de.hdm.thies.bankProjekt.data.Account;
import de.hdm.thies.bankProjekt.data.Customer;

/**
 * In dieser Klasse werden alle Client-Requests als Methoden umgesetzt.
 * @author Christian Rathke
 * 
 */

public class InterfaceClient {

	/**
	 * 
	 * @uml.property name="verwaltung"
	 * @uml.associationEnd multiplicity="(0 1)"
	 */
	BankVerwaltung verwaltung = null;
    
    /**
     * Initiieren der Verbindung zum Remote-Object "BankVerwaltung1" durch Nachschauen
     * in der RMI-Registry des RMI-Registry-Hosts.
     */

	private void initServerConnection() {
		String rmiRegistryServer = System.getProperty("java.rmi.registry.hostname","localhost"); 
		try {
		// Zunächst benötigen wir eine Verbindung mit einer Bankverwaltung.
			verwaltung = 
				(BankVerwaltung)Naming.lookup("rmi://" + rmiRegistryServer + ":1099/BankVerwaltung1");
		
			/*
			 * Wenn wir hier ankommen, dann besteht eine Verbinung zum Server.
			 * Wäre die Verbindung nicht zustande gekommen, so wäre eine
			 * Exception ausgeworfen worden und das Programm wäre in den
			 * entsprechenden Catch-Block (s.u.) gesprungen.
			 */
			System.out.println("Verbindung hergestellt...");
			
		
		}
		catch (MalformedURLException murle) {
			System.out.println("MalformedURLException");
			System.out.println(murle);
		}
		catch (RemoteException re) {
			System.out.println("RemoteException");
			System.out.println(re);
		} 
		catch (NotBoundException e) {
			System.out.println("NotBoundException");
			System.out.println(e);
		}
	}
	
	/**
	 * 
	 * Es wird ein neuer Kunde angelegt.
	 * 
	 * @param vorname
	 * @param nachname
	 * @return ein neues Objekt vom Typ Customer.
	 */
    
	public Customer createCustomer(String vorname, String nachname) {
		Customer c = null;
		
		if (verwaltung == null) {
			initServerConnection();
		}
		// Die Bankverwaltung bitten wir, einen neuen Kunden anzulegen.
		try {
			c = verwaltung.createCustomer(vorname, nachname);

			/*
			 * Wenn es darauf hin eine solchen Kunden gibt (daran zu erkenn,
			 * dass c nicht leer ist), dann lesen wir nun einige Informationen
			 * über den Kunden aus und setzen das ID-Feld.
			 */
			if (c != null ) {
				// Einfache Ausgabe der Daten des neuen Kundenobjekts
				System.out.println("Neuer Kunde: " + 
											 c.getLastName() + ", " + 
											 c.getFirstName() +
											 " Kd.-Nr.: " + c.getId() );
			}
			else {
				System.out.println("Kein Kunde angelegt bzw. verfügbar.");
			}
		}
		catch (RemoteException re) {
			System.out.println("RemoteException");
			System.out.println(re);
			
		}
		return c;
	}

	/**
	 *  
     * Vor- und Nachname eines Kunden werden aktualisiert.
	 * 
     * @param c
	 * @param vorname
	 * @param nachname
	 * @return das modifizierte Kundenobjekt.
	 */	
    
    public Customer modifyCustomer(Customer c, String vorname, String nachname) {
		if (verwaltung == null) {
			initServerConnection();
		}
		try {
			c.setFirstName(vorname);
			c.setLastName(nachname);
            // Die Bankverwaltung bitten wir, die modifizierten Kundendaten zu speichern.
			verwaltung.save(c);
		}
		catch (RemoteException re) {
			System.out.println("RemoteException");
			System.out.println(re);
			
		}
		return c;
	}

    
    /**
     * Löschen eines Kunden.
     * @param c
     */
    
	public void deleteCustomer(Customer c) {
		if (verwaltung == null) {
			initServerConnection();
		}
		// Die Bankverwaltung bitten wir, einen neuen Kunden zu löschen.
		try {
			verwaltung.deleteCustomer(c);
		}
		catch (RemoteException re) {
			System.out.println("RemoteException");
			System.out.println(re);
			
		}
	}

    /**
     * Auffinden eines Kunden anhand seines Namens. Es wird nur der erste Kunde mit
     * diesem Namen oder null zurückgegeben.
     * @param name
     * @return
     */
    
	public Customer findCustomer(String name) {
		Customer c = null;
		
		if (verwaltung == null) {
			initServerConnection();
		}
		// Die Bankverwaltung bitten wir, einen Kunden zu finden.
		try {
			Vector v = verwaltung.getCustomerByName(name);
			
			/*
			 * Wenn es darauf hin eine solchen Kunden gibt (daran zu erkennen,
			 * dass die Größe des Ergebnisvektors nicht 0 ist), dann lesen wir
			 * nun einige Informationen über den Kunden aus und setzen das
			 * ID-Feld.
			 */
			if (v.size() != 0 ) {
				c = (Customer)v.firstElement();

				// Einfache Ausgabe der Daten des neuen Kundenobjekts
				System.out.println("Gefundener Kunde: " + 
											 c.getLastName() + ", " + 
											 c.getFirstName() +
											 " Kd.-Nr.: " + c.getId() );
			}
			else {
				System.out.println("Kein Kunde gefunden.");
			}
		}
		catch (RemoteException re) {
			System.out.println("RemoteException");
			System.out.println(re);
			
		}
		return c;
	}
	
    /**
     * Alle dem System bekannten Kunden.
     * @return ein Vektor, der alle Kundenobjekte enthält.
     */
    
	public Vector getAllCustomers() {
		if (verwaltung == null) {
			initServerConnection();
		}
		Vector v = new Vector();
		try {
			v = verwaltung.getAllCustomers();
		} catch (RemoteException re) {
			System.out.println("RemoteException");
			System.out.println(re);

		}
		return v;
	}
    
    /**
     * Alle Kunden mit allen Konten.
     * @return ein Vektor, dessen Elemente Vektoren sind. Jeder Teilvektor besteht aus
     * einem Kundenobjekt an Position 0 und den zugehörenden Kontenobjekten ab Position 1.
     * Diese Struktur wird zum Aufbau des Kunden-und-Konten-Baums verwendet.
     */
    
    public Vector getAllCustomersAndAccounts() {
        if (verwaltung == null) {
            initServerConnection();
        }
        Vector customers = null, accounts = null, customersAndAccounts = new Vector();
        Customer c;
        try {
            // alle Kunden
            customers = verwaltung.getAllCustomers();
            for (int i=0; i<customers.size(); i++){
                c = (Customer)customers.elementAt(i);
                // alle Konten eines Kunden
                accounts = getAccountsOf(c);
                // Kundenobjekt wird als erstes Element hinzugefügt
                accounts.add(0, c);
                customersAndAccounts.add(accounts);
            }
        } catch (RemoteException re) {
                System.out.println("RemoteException");
                System.out.println(re);
        }
        return customersAndAccounts;
    }

	
	/**
     * Erzeugen eins neuen Kontos für einen existierenden Kunden.
     * @param c
     * @return das neue Konto-Objekt.
	 */
    
	public Account createAccountFor(Customer c) {
		if (verwaltung == null) {
			initServerConnection();
		}
		
		Account a = null;

		try {
			// Anlegen eines neuen Kontos
			System.out.println("Neues Konto für: " + 
					 c.getLastName() + ", " + 
					 c.getFirstName() +
					 " Kd.-Nr.: " + c.getId() );

			a = verwaltung.createAccountFor(c);		
			verwaltung.save(a);
		}
		catch (RemoteException re) {
			System.out.println("RemoteException");
			System.out.println(re);
			
		}
		return a;
	}

    /**
     * Löschen eines Kontos
     * @param a: das zu löschende Konto.
     */
    
	public void deleteAccount(Account a) {
		if (verwaltung == null) {
			initServerConnection();
		}
		// Die Bankverwaltung bitten wir, einen neuen Kunden anzulegen.
		try {
			verwaltung.deleteAccount(a);
		}
		catch (RemoteException re) {
			System.out.println("RemoteException");
			System.out.println(re);
			
		}
	}

	/**
     * Alle Konten eines existierenden Kunden.
     * @param c
     * @return ein Vektor, der alle Konto-Objekte des Kunden enthält.
	 */
    
	public Vector getAccountsOf(Customer c) {
		if (verwaltung == null) {
			initServerConnection();
		}
		
		Vector v = new Vector();
		if (verwaltung == null) {
			initServerConnection();
		}
		try {
			v = verwaltung.getAccountsOf(c);
			
			/*
			 * Wenn es darauf hin ein Konto gibt (daran zu erkennen, dass die
			 * Größe des Ergebnisvektors nicht 0 ist), dann lesen wir nun einige
			 * Informationen über die Konto aus.
			 */
			if (v.size() != 0 ) {
				System.out.println("Konten für " + c.getFirstName() + " " + c.getLastName() + ":");
				Account a;
				for (int i = 0; i < v.size(); i++) {
				 a = (Account)v.elementAt(i);

				// Einfache Ausgabe der Daten des neuen Kundenobjekts
				System.out.println(" Kto.Nr.: " + a.getId() + "; Kontostand: " + a.getBalance());
				}
			}
			else {
				System.out.println("Kein Konto gefunden.");
			}
		}
		catch (RemoteException re) {
			System.out.println("RemoteException");
			System.out.println(re);
			
		}
		return v;
	}
	
	
	/**
     * Der Kontostand wird um den angegebenen Betrag verändert.
     * @param a
     * @param amount
     * @return der neue Betrag als float
	 */
    
	public float modifyAccount(Account a, float amount) {
		if (verwaltung == null) {
			initServerConnection();
		}
		float newBalance = 0F;
		try {
			if (amount < 0) a.makeWithdrawal(-amount);
			else a.makeDeposit(amount);
			verwaltung.save(a);
			newBalance = a.getBalance();	
		}
		catch (RemoteException re) {
			System.out.println("RemoteException");
			System.out.println(re);
			
		}
		return newBalance;
	}
}
