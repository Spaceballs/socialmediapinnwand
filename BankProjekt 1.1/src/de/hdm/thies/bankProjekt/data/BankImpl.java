package de.hdm.thies.bankProjekt.data;

import java.rmi.RemoteException;

/**
 * Implementierungsklasse des Interface <code>Bank</code>.
 * @see Bank
 * @author Thies
 */
public class BankImpl
	extends java.rmi.server.UnicastRemoteObject
	implements Bank {

	/**
	 * Name der Bank
	 */
	private String name = "";
	
	/**
	 * Straﬂe und Hausnummer der Bank.
	 */
	private String street = "";
	
	/**
	 * Postleitzahl der Bank.
	 */
	private int zip = 0;
	
	/**
	 * Ortsbezeichnung der Bank.
	 */
	private String city = "";

	public BankImpl() 
		throws RemoteException {
		super();
	}

	public String getCity() 
		throws java.rmi.RemoteException {
		return city;
	}

	public String getName() 
		throws java.rmi.RemoteException {
		return name;
	}

	public String getStreet() 
		throws java.rmi.RemoteException {
		return street;
	}

	public int getZip() 
		throws java.rmi.RemoteException {
		return zip;
	}

	public void setCity(String string) 
		throws java.rmi.RemoteException {
		city = string;
	}

	public void setName(String string) 
		throws java.rmi.RemoteException {
		name = string;
	}

	public void setStreet(String string) 
		throws java.rmi.RemoteException {
		street = string;
	}

	public void setZip(int i) 
		throws java.rmi.RemoteException {
		zip = i;
	}

}
