package de.hdm.thies.bankProjekt.data;

import java.rmi.RemoteException;

/**
 * Implementierungsklasse des Interface <code>Customer</code>.
 * 
 * @see Customer
 * @author Thies
 */
public class CustomerImpl
	extends java.rmi.server.UnicastRemoteObject
	implements Customer {

	/**
	 * Nachname des Kunden
	 */	
	private String lastName = "";
	
	/**
	 * Vorname des Kunden
	 */
	private String firstName = "";
	
	/**
	 * Kundennummer des Kunden
	 */
	private int id = 0;

	public CustomerImpl() throws RemoteException {
		super();
	}

	public String getFirstName() throws java.rmi.RemoteException {
		return firstName;
	}

	public int getId() throws java.rmi.RemoteException {
		return id;
	}

	public String getLastName() throws java.rmi.RemoteException {
		return lastName;
	}

	public void setFirstName(String string) throws java.rmi.RemoteException {
		firstName = string;
	}

	public void setId(int i) throws java.rmi.RemoteException {
		id = i;
	}

	public void setLastName(String string) throws java.rmi.RemoteException {
		lastName = string;
	}

	public boolean equals(Object o) {
		if ( o != null && o instanceof Customer ) {
			Customer c = (Customer)o;
			try {
				if ( c.getId() == this.id )
					return true;
			}
			catch (RemoteException e) {
				return false;
			}
		}
		return false;
	}
}
