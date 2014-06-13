package de.hdm.thies.rmidemo;

/**
 * Jede �ber RMI nutzbare Klasse mu� ein Interface besitzen, das von 
 * <code>java.rmi.Remote</code> abgeleitet ist. Mit Hilfe des Interfaces werden
 * s�mtliche Methoden deklariert, die remote aufrufbar sein sollen. Jede einzelne
 * dieser Methoden kann eine <code>RemoteException</code> auswerfen. Dies ist
 * durch <code>throws java.rmi.RemoteException</code> entsprechend zu deklarieren.
 * <p>
 * Die Implementierung dieses Interfaces wird dann durch eine sogenannte Impl-Klasse
 * realisiert. In diesem Fall hei�t sie <code>CalculatorImpl</code>.
 * <p>
 * Namenskonventionen:
 * <ol>
 * <li> Das Interface tr�gt den eigentlichen Namen ohne weitere Zus�tze, also 
 * z.B. Calculator.
 * <li> Die zugeh�rige Impl-Klasse tr�gt den gleichen Namen wie das Interface, 
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