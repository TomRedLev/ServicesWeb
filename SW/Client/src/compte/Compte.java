/**
 * Compte.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package compte;

public interface Compte extends java.rmi.Remote {
    public void setCurrency(java.lang.String currency) throws java.rmi.RemoteException;
    public void depotDe(double montant) throws java.rmi.RemoteException;
    public boolean retraitDe(double montant) throws java.rmi.RemoteException;
    public double valeurDuSolde() throws java.rmi.RemoteException;
    public java.lang.String currencyType() throws java.rmi.RemoteException;
}
