package de.hdm.thies.bankProjekt.data;


/**
 * Exemplarische Schnittstellenspezifikation einer Bank.
 * 
 * @author Thies
 */
public interface Bank extends java.rmi.Remote {

	/**
	 * Ort auslesen, an dem sich die Bank befindet.
	 * 
	 * @return Ort als Zeichenkette
	 * @throws java.rmi.RemoteException
	 */
	public String getCity() throws java.rmi.RemoteException;
	
	/**
	 * Namen der Bank auslesen.
	 * 
	 * @return Name als Zeichenkette.
	 * @throws java.rmi.RemoteException
	 */
	public String getName() throws java.rmi.RemoteException;
	
	/**
	 * Straﬂe inkl. Hausnummer auslesen, in der sich die Bank befindet.
	 * 
	 * @return Straﬂe und Hausnumer als Zeichenkette.
	 * @throws java.rmi.RemoteException
	 */
	public String getStreet() throws java.rmi.RemoteException;
	
	/**
	 * Postleitzahl des Bankorts.
	 * 
	 * @return Postleitzahl, ganzzahlig
	 * @throws java.rmi.RemoteException
	 */
	public int getZip() throws java.rmi.RemoteException;
	
	/**
	 * Ort der Bank setzen.
	 * @param Ort als Zeichenkette
	 * @throws java.rmi.RemoteException
	 */
	public void setCity(String string) throws java.rmi.RemoteException;
	
	/**
	 * Namen der Bank setzen.
	 * @param Name als Zeichenkette.
	 * @throws java.rmi.RemoteException
	 */
	public void setName(String string) throws java.rmi.RemoteException;
	
	/**
	 * Straﬂe und Hausnummer setzen, in der sich die Bank befindet.
	 * @param Zeichenkette, die Straﬂe und Hausnummer enth‰lt.
	 * @throws java.rmi.RemoteException
	 */
	public void setStreet(String string) throws java.rmi.RemoteException;
	
	/**
	 * Postleitzahl setzen des Bankorts setzen.
	 * @param Postleitzahl, ganzzahlig
	 * @throws java.rmi.RemoteException
	 */
	public void setZip(int i) throws java.rmi.RemoteException;

}