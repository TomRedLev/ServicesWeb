/**
 * ShopService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package server;

public interface ShopService extends javax.xml.rpc.Service {
    public java.lang.String getShopAddress();

    public server.Shop getShop() throws javax.xml.rpc.ServiceException;

    public server.Shop getShop(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
