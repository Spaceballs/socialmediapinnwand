package de.hdm.thies.bankProjekt;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import de.hdm.thies.bankProjekt.data.*;
import de.hdm.thies.bankProjekt.db.*;

/**
 * RMI-Server, der gestartet wird um die eigentlichen RMI-Server-Objekte zu
 * instantiieren.
 * 
 * @author Thies
 */
public class BankServer {

	/**
	 * Das Verwaltungsobjekt, mittels dessen Kunden und Konten verwaltet werden.
	 */
	private BankVerwaltung verwaltung = null;

	/**
	 * Die Bank.
	 */
	private Bank bank = null;

	public BankServer() {
		try {
			/*
			 * Eine Bank anlegen.
			 * 
			 * HINWEIS: Beachten Sie die Verwendung der "...Impl"-Klassen sowie der
			 * Interface-Referenzen auf der Server-Seite.
			 * 
			 * Beispiel: Variable bank ist vom Typ Bank (Interface) und erh�lt ein
			 * BankImpl-Objekt, welches dem Bank-Interface gen�gt. 
			 */
			bank = new BankImpl();
			bank.setName("HdM-Bank");
			bank.setStreet("Wolframstra�e 32");
			bank.setZip(70121);
			bank.setCity("Stuttgart");

			/*
			 * F�r die Bank ben�tigen wir eine Verwaltung. In dieser werden wichtige
			 * Aktivit�ten vorgehalten.
			 * 
			 * Die Verwaltung mu� wissen, f�r welche Bank sie arbeitet und welche
			 * Mapper zur Verf�gung stehen, um Daten in die Datenbank zu transportieren
			 * zu k�nnen.
			 */
			verwaltung =
				new BankVerwaltungImpl(
					bank,
					CustomerMapper.customerMapper(),
					AccountMapper.accountMapper());

			// Wir melden das Verwaltungsobjekt bei einer RMI-Registry an.
			Naming.rebind("rmi://thiesnb:1099/BankVerwaltung1", verwaltung);
			System.out.println("BankVerwaltung in Registry eingetragen...");
		}
		catch (RemoteException e) {
			e.printStackTrace();
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		BankServer server = new BankServer();
		System.out.println("Server gestartet...");
	}
}