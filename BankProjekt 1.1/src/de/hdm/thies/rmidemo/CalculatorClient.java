package de.hdm.thies.rmidemo;

import java.rmi.*;
import java.net.MalformedURLException;

/**
 * Beispiel-Server zur Demonstration des Zugriffs auf den <code>CalculatorServer</code>
 * bzw. genauer auf <code>CalculatorImpl</code>-Objekte.
 * <p>
 * <b>Beachten Sie:</b> Auf Client-Seite wird nicht mit Referenzen auf 
 * <code>CalculatorImpl</code>-Objekten gearbeitet! Man verwendet
 * <em>ausschließlich</em> das zugehörige Interface! In diesem Fall ist dies
 * das Interface <code>Calculator</code>.
 * 
 * @author Thies
 */
public class CalculatorClient {

	public static void main(String[] args) {
		try {
			/*
			 * Erster Schritt: der Client muß mit dem Server Verbindung aufnehmen. 
			 * Dies geschieht sehr einfach durch einen Lookup in der RMI-Registry, in
			 * der sich der entsprechende Server zuvor eingetragen hat.
			 * 
			 * Struktur der URL:
			 * rmi://thiesnb/CalculatorService
			 * Protokoll: rmi
			 * Name des Rechners auf dem sich die RMI-Registry befindet: thiesnb 
			 * Hinweis: Dies muß nicht der Rechner sein, auf dem sich das gesuchte 
			 * Objekt bzw. der umschließende Server befindet. Client, Server und 
			 * Registry können prinzipiell auf separaten Rechnern laufen.  
			 * 
			 * Rückgabewert des Lookups ist ein Objekt, das dem Calculator-Interface
			 * genügt. Der Anwendungsprogrammierer bemerkt nicht, dass ihm hier ein
			 * Stub-Objekt untergeschoben wird. Das Stub-Objekt wurd zuvor durch den
			 * Aufruf des RMI-Compilers (rmic) erstellt. Auch der Stub gehorcht wie die
			 * Impl-Klasse dem Calculator-Interface.
			 * 
			 * Fortan kann der Client so programmiert werden, als wäre das Objekt c
			 * ein lokales Objekt. Der sich dahinter verbergende Stub übersetzt sämtliche
			 * Anfragen an dieses und daraus hervorgehende Objekte in Netzwerkaufrufe
			 * an das Server-Objekt.
			 * 
			 * Randbemerkung: Als Server-Objekt bezeichnet man nicht den eigentlichen
			 * Server-Prozess, sondern jedes Objekt, das dieser Server-Prozess den 
			 * Clients anbietet.
			 */
			Calculator c =
				(Calculator)Naming.lookup("rmi://thiesnb/CalculatorService");

			// Nun kann man sehr einfach auf c - also den Taschenrechner - zugreifen.
			System.out.println(c.sub(40, 3));
			System.out.println(c.add(4, 5));
			System.out.println(c.mul(30, 60));
			System.out.println(c.div(9, 0));

		}
		catch (MalformedURLException murle) {
			// Lookup ist wegen falscher URL gescheitert
			System.out.println(murle);
		}
		catch (RemoteException re) {
			/*
			 * Jeder Methodenaufruf des Objekts c kann scheitern. Dies kann z.B. durch
			 * eine zusammengebrochene Netzwerkverbindung bedingt sein. Dies wird durch
			 * RemoteExceptions signalisiert.
			 * 
			 * RemoteExceptions können auch verwendet werden, um Ausnahmen in der 
			 * Programmlogik des Servers an den Client zu übermitteln. Im Falle des
			 * Calculators könnte man so das Teilen durch Null (vgl. Methode div)
			 * beanstanden.
			 */
			System.out.println(re);
		}
		catch (NotBoundException nbe) {
			/*
			 * Mißlingt der Lookup oder bricht später die Netzwerkverbindung zusammen,
			 * so könnte man dennoch weiterhin versuchen, Methodenaufrufe an das
			 * Objekt c abzusetzen. Dies würde dann mit einer NotBoudnException 
			 * quittiert. 
			 */
			System.out.println(nbe);
		}
	}

}