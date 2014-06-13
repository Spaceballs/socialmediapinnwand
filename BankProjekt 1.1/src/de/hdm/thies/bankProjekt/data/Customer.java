package de.hdm.thies.bankProjekt.data;

import java.lang.String;

/**
 * Exemplarische Schnittstellendefinition für Kunden.
 * 
 * @author Thies
 */
public interface Customer extends java.rmi.Remote {

	/**
	 * Vornamen setzen.
	 * 
	 * @param first Vorname
	 * @throws java.rmi.RemoteException
	 */
	public void setFirstName(String first) throws java.rmi.RemoteException;
	
	/**
	 * Vornamen auslesen
	 * @return Vorname
	 * @throws java.rmi.RemoteException
	 */
	public String getFirstName() throws java.rmi.RemoteException;
	
	/**
	 * Nachnamen setzen.
	 * 
	 * @param first Nachname
	 * @throws java.rmi.RemoteException
	 */
	public void setLastName(String first) throws java.rmi.RemoteException;
	
	/**
	 * Nachnamen auslesen.
	 * 
	 * @return Nachname
	 * @throws java.rmi.RemoteException
	 */
	public String getLastName() throws java.rmi.RemoteException;
	
	/**
	 * Kundennummer setzen.
	 * @param theId Kundennummer
	 * @throws java.rmi.RemoteException
	 */
	public void setId(int theId) throws java.rmi.RemoteException;
	
	/**
	 * Auslesen der Kundennummer.
	 * 
	 * @return Kundennummer
	 * @throws java.rmi.RemoteException
	 */
	public int getId() throws java.rmi.RemoteException;
	
}
