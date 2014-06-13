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
 * <b>Anwendungsfall:</b> Anlegen eines neuen Kundenobjekts.
 * 
 * @see de.hdm.thies.bankProjekt.BankServer
 * 
 * @author Thies
 */
public class BankClient8 {
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

			// Die Bank bitten wir, einen neuen Kunden anzulegen.			
			Customer c = verwaltung.createCustomer("G�nther", "Maier");
			
			/*
			 * Wenn es darauf hin eine solchen Kunden gibt (daran zu erkenn, dass c nicht leer 
			 * ist), dann lesen wir nun einige Informationen �ber den Kunden aus.
			 */
			if (c != null ) {
				// Einfache Ausgabe der Daten des neuen Kundenobjekts 
				System.out.println("Neuer Kunde: " + 
													 c.getLastName() + ", " + 
													 c.getFirstName() +
													 " Kd.-Nr.: " + c.getId() );				
			}
			else {
				System.out.println("Kein Kunde angelegt bzw. verf�gbar.");
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