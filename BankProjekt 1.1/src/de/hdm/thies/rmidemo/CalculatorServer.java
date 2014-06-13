package de.hdm.thies.rmidemo;

import java.rmi.Naming;

/**
 * Der <code>CalculatorServer</code> wartet auf Anfragen durch Clients. Hierzu 
 * instantiiert er die Klasse <code>CalculatorImpl</code>.
 * Diese Instanz registriert er unter der Adresse 
 * <code>rmi://thiesnb:1099/CalculatorService</code>
 * auf dem Rechner <code>thiesnb</code> unter dem Namen <code>CalculatorService</code>.
 * 
 * @see CalculatorImpl
 * 
 * @author Thies
 */
public class CalculatorServer {
	
	public CalculatorServer() {
		try {
			// Zunächst eine CalculatorImpl-Instanz erzeugen
			Calculator c = new CalculatorImpl();
			
			/*
			 * Das CalculatorImpl-Objekt muß nun bei der RMI-Registry bekannt 
			 * gemacht werden.
			 * 
			 * Struktur der URL:
			 * rmi://thiesnb:1099/CalculatorService
			 * Protokoll: rmi
			 * Rechner: thiesnb
			 * Port, auf dem die RMI-Registry lauscht: 1099
			 * Name, unter dem Clients das CalculatorImpl-Objekt c erreichen 
			 * können: CalculatorService
			 */
			Naming.rebind("rmi://thiesnb:1099/CalculatorService", c);
			
			System.out.println("CalcluatorServer gestartet...");
		} 
		catch (Exception e) {
			System.out.println("Trouble: " + e);
		}
	}

	public static void main(String args[]) {
		new CalculatorServer();
	}

	/*
	 * Ein kontrolliertes Abmelden eines Server-Objekts bei der RMI-Registry würde
	 * durch Naming.undbind(...) erfolgen. Hierauf wurd in dieser Beispielanwendung
	 * jedoch aus Gründen der Vereinfachung verzichtet.
	 */
}