package de.hdm.thies.bankProjekt.clients;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.util.*;

import de.hdm.thies.bankProjekt.BankVerwaltung;
import de.hdm.thies.bankProjekt.data.Account;
import de.hdm.thies.bankProjekt.data.Bank;
import de.hdm.thies.bankProjekt.data.Customer;

/**
 * Demonstrator f�r die Interaktion mit dem <code>BankServer</code>.
 * <p>
 * <b>Anwendungsfall:</b> Auslesen aller Kunden, deren Nachname "M�ller" ist
 * und Anzeige der zugeh�rigen Konten.
 * 
 * @see de.hdm.thies.bankProjekt.BankServer
 * @author Thies
 */
public class BankClient1 {
	
	public static void main(String[] args) {
		try {
			// Zun�chst ben�tigen wir eine Verbindung mit einer Bankverwaltung.
			BankVerwaltung verwaltung = 
				(BankVerwaltung)Naming.lookup("rmi://thiesnb:1099/BankVerwaltung1");
			
			/* 
			 * Wenn wir hier ankommen, dann besteht eine Verbinung zum Server.
			 * W�re die Verbindung nicht zustande gekommen, so w�re eine Exception
			 * ausgeworfen worden und das Programm w�re in den entsprechenden 
			 * Catch-Block (s.u.) gesprungen. 
			 */
			System.out.println("Verbindung hergestellt...");
			
			// Von der Verwaltung bekommen wir das Bank-Objekt.
			Bank bank = verwaltung.getBank();

			// Die Bank fragen wir, ob sie eine Kundin namens Lotte M�ller kennt.			
			Vector<Customer> result = verwaltung.getCustomerByName("M�ller");
			for ( Customer c : result ) {
				if (c != null ) {
					// Kundennummer und Name ausgeben
					System.out.println(c.getId() + ": " + 
														 c.getLastName() + ", " + c.getFirstName());
														 
					// Welche Konten besitzt der Kunde bei unserer Bank?
					Vector<Account> accounts = verwaltung.getAccountsOf(c);
					
					// F�r jedes gefundene Konto...
					for ( Account a : accounts ) {
						// Ausgeben der Kontonummer und des aktuellen Kontostands					
						System.out.println("Konto: " + a.getId() + ": " + a.getBalance());
					}
				}
			}
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

}