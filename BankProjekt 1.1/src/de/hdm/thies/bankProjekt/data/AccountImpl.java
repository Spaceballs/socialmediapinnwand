package de.hdm.thies.bankProjekt.data;

import java.rmi.RemoteException;

/**
 * Implementierungsklasse des Interface <code>Account</code>.
 * @see Account
 * @author Thies
 */
public class AccountImpl
	extends java.rmi.server.UnicastRemoteObject
	implements Account {

	/**
	 * Kontonummer
	 */
	private int id = 0;

	/**
	 * Kontostand
	 */
	private float balance = 0;

	/**
	 * Kontoinhaber
	 */
	private int owner = 0;

	public AccountImpl() throws RemoteException {
		super();
	}

	public float getBalance() throws java.rmi.RemoteException {
		return this.balance;
	}

	public int getId() throws java.rmi.RemoteException {
		return this.id;
	}

	/**
	 * Auslesen des Kontoinhabers.
	 * @return Kontoinhaber-Instanz
	 * @see Customer
	 * @throws java.rmi.RemoteException
	 */
	public int getOwner() throws java.rmi.RemoteException {
		return owner;
	}

	public void setBalance(float b) throws java.rmi.RemoteException {
		this.balance = b;
	}

	public void setId(int i) throws java.rmi.RemoteException {
		this.id = i;
	}

	public void setOwner(int c) throws java.rmi.RemoteException {
		this.owner = c;
	}

	public void makeDeposit(float amount) throws RemoteException {
		this.balance = this.balance + amount;
	}

	public void makeWithdrawal(float amount) throws RemoteException {
		this.balance = this.balance - amount;
	}

	/**
	 * Feststellen der Gleichheit zweier Account-Objekte. Die Gleichheit wird in
	 * diesem Beispiel auf eine identische Kontonummer beschränkt.
	 */
	public boolean equals(Object o) {
		/*
		 * Abfragen, ob ein Objekt ungl. NULL ist und ob ein Objekt gecastet werden 
		 * kann, sind immer wichtig!
		 */
		if (o != null && o instanceof Account) {
			Account c = (Account)o;
			try {
				if (c.getId() == this.id)
					return true;
			}
			catch (RemoteException e) {
				return false;
			}
		}
		return false;
	}

}
