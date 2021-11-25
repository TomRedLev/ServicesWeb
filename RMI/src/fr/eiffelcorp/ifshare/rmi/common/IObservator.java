package fr.eiffelcorp.ifshare.rmi.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IObservator extends Remote {
    public int update(IProduct product) throws RemoteException;
    public String getInfo() throws RemoteException;
    public void setProduct(String product) throws RemoteException;
}
