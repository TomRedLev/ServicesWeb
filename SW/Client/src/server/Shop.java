/**
 * Shop.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package server;

public interface Shop extends java.rmi.Remote {
    public int sellToClient(int token, java.lang.String product_name) throws java.rmi.RemoteException;
    public java.lang.String storeProducts() throws java.rmi.RemoteException;
    public int buyFromClient(int token, common.Product product) throws java.rmi.RemoteException;
    public void addObservator(int token, common.Observator observator) throws java.rmi.RemoteException;
    public java.lang.String clientProducts(int token) throws java.rmi.RemoteException;
    public void removeAllObservators() throws java.rmi.RemoteException;
    public int registerClient(java.lang.String name, common.Observator observator) throws java.rmi.RemoteException;
    public void notifyAllObservators(common.Product product) throws java.rmi.RemoteException;
}
