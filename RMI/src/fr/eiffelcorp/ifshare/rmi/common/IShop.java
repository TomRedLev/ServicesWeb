package fr.eiffelcorp.ifshare.rmi.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IShop extends Remote {
	public int sellToClient(String product_name, Double product_price) throws RemoteException;
	public int buyFromClient(IProduct product) throws RemoteException;
}
