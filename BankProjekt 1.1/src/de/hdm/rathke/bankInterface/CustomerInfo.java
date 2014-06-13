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
 * Darstellung von Customers verwendet. Sie enthalten außerdem das zugehörige Customer-
 * Objekt.
 * @author Christian Rathke
 */
public class CustomerInfo {
    /**
     * 
     * @uml.property name="firstname"
     */
	private String firstname;
    /**
     * 
     * @uml.property name="lastname"
     */
	private String lastname;

	/**
	 * 
	 * @uml.property name="c"
	 * @uml.associationEnd multiplicity="(0 1)"
	 */
	private Customer c;

	
	CustomerInfo(Customer c){
		try {
			this.c = c;
			firstname = c.getFirstName();
			lastname = c.getLastName();
		} catch (RemoteException re) {
			System.out.println("RemoteException");
			System.out.println(re);
		}
	}
    
    /**
     * Die String-Darstellung eines Kunden besteht aus Nachname und Vorname.
     */
	public String toString() {
		return lastname + ", " + firstname;
	}
	
    /**
     * 
     * @uml.property name="c"
     */
	public Customer getCustomer(){
		return c;
	}

}
