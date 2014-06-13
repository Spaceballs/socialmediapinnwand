package de.hdm.thies.bankProjekt.clients;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;

import de.hdm.thies.bankProjekt.*;
import de.hdm.thies.bankProjekt.report.*;

/**
 * Demonstrator f�r die Interaktion mit dem <code>BankServer</code>.
 * <p>
 * <b>Anwendungsfall:</b> Erstellen eines Reports.
 * 
 * @see de.hdm.thies.bankProjekt.BankServer
 * 
 * @author Thies
 */
public class BankClient7 {
	
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
			
			// Zun�chst m�ssen wir uns Zugang zum ReportGenerator verschaffen.
			ReportGenerator gen = verwaltung.getReportGenerator();

			AllAccountsOfAllCustomersReport report = gen.createAllAccountsOfAllCustomersReport();

			PlainTextReportWriter textWriter = new PlainTextReportWriter();
			textWriter.process(report);
			System.out.println(textWriter.getReportText());

			HTMLReportWriter htmlWriter = new HTMLReportWriter();
			htmlWriter.process(report);
			System.out.println(htmlWriter.getReportText());
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