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
			 * Beispiel: Variable bank ist vom Typ Bank (Interface) und erhält ein
			 * BankImpl-Objekt, welches dem Bank-Interface genügt. 
			 */
			bank = new BankImpl();
			bank.setName("HdM-Bank");
			bank.setStreet("Wolframstraße 32");
			bank.setZip(70121);
			bank.setCity("Stuttgart");

			/*
			 * Für die Bank benötigen wir eine Verwaltung. In dieser werden wichtige
			 * Aktivitäten vorgehalten.
			 * 
			 * Die Verwaltung muß wissen, für welche Bank sie arbeitet und welche
			 * Mapper zur Verfügung stehen, um Daten in die Datenbank zu transportieren
			 * zu können.
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