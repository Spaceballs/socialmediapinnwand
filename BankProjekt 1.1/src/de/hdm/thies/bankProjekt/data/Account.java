package de.hdm.thies.bankProjekt.data;

/**
 * Exemplarische Schnittstellenspezifikation eines Bankkontos.
 * 
 * @author Thies
 *
 */
public interface Account extends java.rmi.Remote {

	/**
	 * Auslesen des Kontostands.
	 * @return Kontostand
	 * @throws java.rmi.RemoteException
	 */
	public float getBalance() throws java.rmi.RemoteException;

	/**
	 * Setzen des Kontostands.
	 * @throws java.rmi.RemoteException
	 */
	public void setBalance(float b) throws java.rmi.RemoteException;

	/**
	 * Auslesen der Kontonummer.
	 * @return Kontonummer, ganzzahlig
	 * @throws java.rmi.RemoteException
	 */
	public int getId() throws java.rmi.RemoteException;

	/**
	 * Auslesen des Kontoinhabers.
	 * @return Kontoinhaber-Instanz
	 * @see Customer
	 * @throws java.rmi.RemoteException
	 */
	public int getOwner() throws java.rmi.RemoteException;

	/**
	 * Setzen der Kontonummer. <br>
	 * <b>Hinweis:</b> Sollte nur von Verwaltungsklassen genutzt werden!
	 * @param i
	 * @see setOwner(Customer customer)
	 * @throws java.rmi.RemoteException
	 */
	public void setId(int i) throws java.rmi.RemoteException;

	/**
	 * Setzen des Kontoinhabers. <br>
	 * <b>Hinweis:</b> Sollte nur von Verwaltungsklassen genutzt werden!
	 * @param c
	 * @see setId(int i)
	 * @throws java.rmi.RemoteException
	 */
	public void setOwner(int c) throws java.rmi.RemoteException;

	/**
	 * Eine Einzahlung bzw. Gutschrift für das Konto buchen. 
	 * @param amount
	 * @see makeWithdrawal(int amount)
	 * @throws java.rmi.RemoteException
	 */
	public void makeDeposit(float amount) throws java.rmi.RemoteException;

	/**
	 * Eine Auszahlung bzw. Belastung des Kontos buchen. 
	 * @param amount
	 * @see makeDeposit(int amount)
	 * @throws java.rmi.RemoteException
	 */
	public void makeWithdrawal(float amount) throws java.rmi.RemoteException;

}
