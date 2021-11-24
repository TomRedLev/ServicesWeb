package fr.eiffelcorp.ifshare.rmi.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IShop extends Remote {
	public void sell() throws RemoteException;
	public void buy() throws RemoteException;
}
