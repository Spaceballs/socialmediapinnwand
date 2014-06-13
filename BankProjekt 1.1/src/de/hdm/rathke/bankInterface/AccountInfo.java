/*
 * Created on 11.12.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package de.hdm.rathke.bankInterface;

import de.hdm.thies.bankProjekt.data.*;
import java.rmi.RemoteException;

/**
 * Objekte dieser Klasse werden in der Baumdarstellung von Kunden und Konten zur
 * Darstellung von Accounts verwendet. Sie enthalten außerdem das zugehörige Account-
 * Objekt.
 * @author Christian Rathke
 */
public class AccountInfo {
	private int id;

	/**
	 * 
	 * @uml.property name="a"
	 * @uml.associationEnd multiplicity="(0 1)"
	 */
	private Account a;

	/**
	 * 
	 * @uml.property name="c"
	 * @uml.associationEnd multiplicity="(0 1)"
	 */
	
	AccountInfo(Account a){
		try {
			this.a = a;
			id = a.getId();
		} catch (RemoteException re) {
			System.out.println("RemoteException");
			System.out.println(re);
		}
	}
	
    /**
     * String-Darstellung eines Accounts besteht aus dem String "Konto " und
     * der Konto-Id.
     */
	
	public String toString() {
		return "Konto " + id;
	}
	
    /**
     * 
     * @uml.property name="a"
     */
    
	public Account getAccount(){
		return a;
	}

}
