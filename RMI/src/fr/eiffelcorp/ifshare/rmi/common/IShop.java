package fr.eiffelcorp.ifshare.rmi.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IShop extends Remote {
	public int registerClient(String name, IObservator observator) throws RemoteException;
	public int sellToClient(Integer token, String product_name) throws RemoteException;
	public int buyFromClient(Integer token, IProduct product) throws RemoteException;
	public String storeProducts() throws RemoteException;
	public String clientProducts(Integer token) throws RemoteException;
	// Ajouter la détection de l'objet observé par les observateurs.
	public void addObservator(Integer token, IObservator observator) throws RemoteException;
	public void notifyAllObservators(IProduct product) throws RemoteException;
	public void removeAllObservators() throws RemoteException;
}
