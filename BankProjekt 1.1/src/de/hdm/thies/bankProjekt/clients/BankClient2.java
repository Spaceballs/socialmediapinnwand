package de.hdm.thies.bankProjekt.clients;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;

import de.hdm.thies.bankProjekt.BankVerwaltung;
import de.hdm.thies.bankProjekt.data.Account;
import de.hdm.thies.bankProjekt.data.Bank;
import de.hdm.thies.bankProjekt.data.Customer;

/**
 * Demonstrator für die Interaktion mit dem <code>BankServer</code>.
 * <p>
 * <b>Anwendungsfall:</b> Anlegen eines neuen Kontos für den Kunden mit Kd.-Nr.
 * 1. Überweisung von 100.001 Geldeinheiten auf das neue Konto. 
 * 
 * @see de.hdm.thies.bankProjekt.BankServer
 * 
 * @author Thies
 */
public class BankClient2 {
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
			 * Wenn es eine solche Kundin gibt (daran zu erkennen, dass c nicht leer 
			 * ist), dann lesen wir nun einige Informationen über die Kundin aus.
			 */
			if (c != null ) {
				// Kundennummer und Name ausgeben
				System.out.println(c.getId() + ": " + 
													 c.getLastName() + ", " + c.getFirstName());
													 
				// Anlegen eines neuen Kontos für Frau Müller
				Account a = verwaltung.createAccountFor(c);
				
				/* 
				 * Dem Konto schreiben wir 100.001 Geldeinheiten gut (Währung wird hier
				 * vernachlässigt).
				 */
				a.makeDeposit(100001);

				// Damit die Gutschrift auch persistent wird, speichern wir das Objekt.				
				verwaltung.save(a);
				
				/* 
				 * Zur Kontrolle geben wir Nummer und den nun aktuellen Stand des 
				 * Kontos aus
				 */
				System.out.println("Kontoinfos: Nummer: " + 
													 a.getId() + 
													 ", Kontostand: " + a.getBalance());
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