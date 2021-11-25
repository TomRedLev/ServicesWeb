package fr.eiffelcorp.ifshare.rmi.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IProduct extends Remote {
	public String getName() throws RemoteException;
	public String getType() throws RemoteException;
	public String getSeller() throws RemoteException;
	public Double getPrice() throws RemoteException;
 	public String getComment() throws RemoteException;
 	public void setName(String name) throws RemoteException;
	public void setType(String type) throws RemoteException;
	public void setSeller(String seller) throws RemoteException;
	public void setPrice(Double price) throws RemoteException;
	public void setComment(String comment) throws RemoteException; 
	public String getInfo() throws RemoteException;
}
