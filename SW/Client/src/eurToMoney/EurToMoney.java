/**
 * EurToMoney.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package eurToMoney;

public interface EurToMoney extends java.rmi.Remote {
    public double convertToJpy(double montant) throws java.rmi.RemoteException;
    public double convertToGpb(double montant) throws java.rmi.RemoteException;
    public double convertToEur(double montant, java.lang.String currency) throws java.rmi.RemoteException;
    public double convertToUsd(double montant) throws java.rmi.RemoteException;
}
