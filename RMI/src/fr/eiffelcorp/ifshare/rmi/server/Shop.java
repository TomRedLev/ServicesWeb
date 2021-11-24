package fr.eiffelcorp.ifshare.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import fr.eiffelcorp.ifshare.rmi.common.IShop;

public class Shop extends UnicastRemoteObject implements IShop {

	protected Shop() throws RemoteException {
		super();
	}

	@Override
	public void sell() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buy() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
