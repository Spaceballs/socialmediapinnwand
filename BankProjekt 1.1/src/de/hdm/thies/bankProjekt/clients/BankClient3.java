package de.hdm.thies.bankProjekt.clients;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.util.Vector;

import de.hdm.thies.bankProjekt.BankVerwaltung;
import de.hdm.thies.bankProjekt.data.Account;
import de.hdm.thies.bankProjekt.data.Bank;
import de.hdm.thies.bankProjekt.data.Customer;

/**
 * Demonstrator für die Interaktion mit dem <code>BankServer</code>.
 * <p>
 * <b>Anwendungsfall:</b> Löschen des Kontos mit der höchsten Kontonummer von
 * Kunde Nr. 1.
 * 
 * @see de.hdm.thies.bankProjekt.BankServer
 * 
 * @author Thies
 */
public class BankClient3 {
	public static void main(String[] args) {
		try {
			// Zunächst benötigen wir eine Verbindung mit einer Bankverwaltung.
			BankVerwaltung verwaltung = 
				(BankVerwaltung)Naming.lookup("rmi://thiesnb:1099/BankVerwaltung1");
			
			/* 
			 * Wenn wir hier ankommen, dann besteht eine Verbinung zum Server.
			 * Wäre die Verbindung nicht zustande gekommen, so wäre eine Exception
			 * ausgeworfen worden und das Programm wäre in den entsprechenden 
			 * Catch-Block (s.u.) gesprungen. 
			 */
			System.out.println("Verbindung hergestellt...");
			
			// Von der Verwaltung bekommen wir das Bank-Objekt.
			Bank bank = verwaltung.getBank();

			// Die Bank fragen wir, ob sie einen Kunden mit der Kd.-Nr. 1 kennt.			
			Customer c = verwaltung.getCustomerById(1);

			/*
			 * Wenn es einen solchen Kunden gibt (daran zu erkennen, dass c nicht leer 
			 * ist), dann lesen wir nun einige Informationen über den Kunden aus.
			 */
			if (c != null ) {
				// Kundennummer und Name ausgeben
				System.out.println(c.getId() + ": " + 
													 c.getLastName() + ", " + c.getFirstName());
				
				// Auslesen aller Konten von Kd. 1
				Vector<Account> result = verwaltung.getAccountsOf(c);
				
				// Wenn Müller mind. ein Konto bei uns führt, dann ...
				if ( result.size() > 0 ) {
					// Nimm das Konto, das in result an hinterster Position steht
					Account a = result.elementAt(result.size() - 1);

					// Zeige Nummer und Stand dieses Kontos noch einmal an
					System.out.println("Lösche Account: " + a.getId() + ": " + a.getBalance());
				
					// Bitte die Verwaltung, das Konto zu löschen
					verwaltung.deleteAccount(a);

					// Gib eine Vollzugsmeldung aus
					System.out.println("Konto gelöscht.");
				}
				else {
					System.out.println("Keine Konten vorhanden, die gelöscht werden können.");
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