package de.hdm.thies.rmidemo;

import java.rmi.RemoteException;

/**
 * Die Implementierungsklasse (kurz: Impl-Klasse) des Interfaces <code>Calculator</code>.
 * Jede Impl-Klasse ist von <code>UnicastRemoteObject</code> abgeleitet. Man kann
 * unter RMI auch andere Lösungswege wählen. Für diese Kurzeinführung reicht diese
 * Lösung jedoch aus.
 * <p>
 * Weitere Informationen finden Sie in dem Interface <code>Calculator</code>.
 * 
 * @see Calculator
 * 
 * @author Thies
 */
public class CalculatorImpl
	extends java.rmi.server.UnicastRemoteObject
	implements Calculator {

	/*
	 * Implementationsklassen müssen einen expliziten Konstruktor besitzen, der
	 * RemoteExceptions auswerfen kann.
	 */
	public CalculatorImpl() throws java.rmi.RemoteException {
		// obligatorisches Aufrufen des Konstruktors der Klasse UnicastRemoteObject.
		super();
	}

	/*
	 * Ab hier folgen Implementierungen der im Interface deklarierten Methoden.
	 * @see de.hdm.thies.rmidemo.Calculator#add(float, float)
	 */
	public float add(float a, float b) throws java.rmi.RemoteException {
		return a + b;
	}

	public float sub(float a, float b) throws java.rmi.RemoteException {
		return a - b;
	}

	public float mul(float a, float b) throws java.rmi.RemoteException {
		return a * b;
	}

	public float div(float a, float b) throws java.rmi.RemoteException {
		if (b == 0)
			throw new RemoteException("Division durch 0 ist nicht erlaubt!");
			
		return a / b;
	}

}