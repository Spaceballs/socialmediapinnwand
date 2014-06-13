package de.hdm.thies.rmidemo;

/**
 * Jede über RMI nutzbare Klasse muß ein Interface besitzen, das von 
 * <code>java.rmi.Remote</code> abgeleitet ist. Mit Hilfe des Interfaces werden
 * sämtliche Methoden deklariert, die remote aufrufbar sein sollen. Jede einzelne
 * dieser Methoden kann eine <code>RemoteException</code> auswerfen. Dies ist
 * durch <code>throws java.rmi.RemoteException</code> entsprechend zu deklarieren.
 * <p>
 * Die Implementierung dieses Interfaces wird dann durch eine sogenannte Impl-Klasse
 * realisiert. In diesem Fall heißt sie <code>CalculatorImpl</code>.
 * <p>
 * Namenskonventionen:
 * <ol>
 * <li> Das Interface trägt den eigentlichen Namen ohne weitere Zusätze, also 
 * z.B. Calculator.
 * <li> Die zugehörige Impl-Klasse trägt den gleichen Namen wie das Interface, 
 * jedoch mit dem Suffix Impl, also z.B. CalculatorImpl.
 * </ol>
 * An diese Vorgaben sollte man sich strikt halten!
 * 
 * @see CalculatorImpl
 * 
 * @author Thies
 */
public interface Calculator extends java.rmi.Remote {

	public float add(float a, float b) throws java.rmi.RemoteException;

	public float sub(float a, float b) throws java.rmi.RemoteException;

	public float mul(float a, float b) throws java.rmi.RemoteException;

	public float div(float a, float b) throws java.rmi.RemoteException;

}