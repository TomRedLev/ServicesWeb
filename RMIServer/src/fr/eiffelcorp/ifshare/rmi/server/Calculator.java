package fr.eiffelcorp.ifshare.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import fr.eiffelcorp.ifshare.rmi.common.ICalculator;

public class Calculator extends UnicastRemoteObject implements ICalculator {

	protected Calculator() throws RemoteException {
		super();
	}

	@Override
	public long add(long a, long b) throws RemoteException {
		return a + b;
	}

	@Override
	public long sub(long a, long b) throws RemoteException {
		return a - b;
	}

	@Override
	public long mul(long a, long b) throws RemoteException {
		return a * b;
	}

	@Override
	public long div(long a, long b) throws RemoteException {
		return a / b;
	}

}
