package de.hdm.thies.bankProjekt.report;

import de.hdm.thies.bankProjekt.data.Customer;

/**
 * Ein ReportGenerator bietet die M�glichkeit, eine Menge von Berichten (Reports)
 * zu erstellen, die Menge von Daten bzgl. bestimmter Sachverhalte des Systems
 * zweckspezifisch darstellen.<p>
 * 
 * Die Klasse bietet eine Reihe von <code>create...</code>-Methoden, mit deren
 * Hilfe die Reports erstellt werden k�nnen. Jede dieser Methoden besitzt eine
 * dem Anwendungsfall entsprechende Parameterliste. Diese Parameter ben�tigt der
 * der Generator, um den Report erstellen zu k�nnen.<p>
 * 
 * Bei neu hinzukommenden Bedarfen an Berichten, kann diese Klasse auf einfache
 * Weise erweitert werden. Hierzu k�nnen zus�tzliche <code>create...</code>-Methoden
 * implementiert werden. Die bestehenden Methoden bleiben davon unbeeinflu�t, so
 * dass bestehende Programmlogik nicht ver�ndert werden mu�.
 * 
 * @author thies
 */
public interface ReportGenerator extends java.rmi.Remote {

	/**
	 * Erstellen eines <code>AllAccountsOfCustomerReport</code>-Reports. Dieser
	 * Report-Typ stellt s�mtliche Konten eines Kunden dar.
	 * 
	 * @param c eine Referenz auf das Kundenobjekt bzgl. dessen der Report erstellt
	 * werden soll.
	 * @return das fertige Reportobjekt
	 * @throws java.rmi.RemoteException
	 * @see AllAccountsOfCustomerReport
	 */
	public abstract AllAccountsOfCustomerReport 
		createAllAccountsOfCustomerReport(Customer c) 
		throws java.rmi.RemoteException;

	/**
	 * Erstellen eines <code>AllAccountsOfAllCustomersReport</code>-Reports. Dieser
	 * Report-Typ stellt s�mtliche Konten aller Kunden dar.
	 * 
	 * @return das fertige Reportobjekt
	 * @throws java.rmi.RemoteException
	 * @see AllAccountsOfAllCustomersReport
	 */
	public abstract AllAccountsOfAllCustomersReport 
		createAllAccountsOfAllCustomersReport()
		throws java.rmi.RemoteException;

}