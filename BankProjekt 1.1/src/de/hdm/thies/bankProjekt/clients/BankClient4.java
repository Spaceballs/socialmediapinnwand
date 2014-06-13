package de.hdm.thies.bankProjekt.clients;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;

import de.hdm.thies.bankProjekt.BankVerwaltung;
import de.hdm.thies.bankProjekt.data.Bank;
import de.hdm.thies.bankProjekt.data.Customer;

/**
 * Demonstrator f�r die Interaktion mit dem <code>BankServer</code>.
 * <p>
 * <b>Anwendungsfall:</b> L�schen eines Kundenobjekts mit der Kundennr. 11.
 * 
 * @see de.hdm.thies.bankProjekt.BankServer
 * 
 * @author Thies
 */
public class BankClient4 {
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

			// Die Bank fragen wir, ob sie eine Kundin mit der Kd.-Nr. 11 kennt.			
			Customer c = verwaltung.getCustomerById(11);
			
			/*
			 * Wenn es eine solche Kundin gibt (daran zu erkenn, dass c nicht leer 
			 * ist), dann lesen wir nun einige Informationen �ber die Kundin aus.
			 */
			if (c != null ) {
				// Ank�ndigung, was nun geschieht
				System.out.println("L�sche: " + 
													 c.getLastName() + ", " + 
													 c.getFirstName() );
				
				/*
				 * Die Verwaltung bitten, die Kundin zu l�schen. Dies bedeutet implizit,
				 * dass auch deren Konten gel�scht werden. Hierf�r sorgt die Verwaltung.
				 */ 
				verwaltung.deleteCustomer(c);

				// Vollzugsmeldung ausgeben
				System.out.println("Kundin gel�scht.");
			}
			else {
				System.out.println("Keine Kundin mit der Kd.-Nr. 11 gefunden.");
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