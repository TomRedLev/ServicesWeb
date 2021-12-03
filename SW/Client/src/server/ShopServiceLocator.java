/**
 * ShopServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package server;

public class ShopServiceLocator extends org.apache.axis.client.Service implements server.ShopService {

    public ShopServiceLocator() {
    }


    public ShopServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ShopServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Shop
    private java.lang.String Shop_address = "http://localhost:8080/IfService/services/Shop";

    public java.lang.String getShopAddress() {
        return Shop_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ShopWSDDServiceName = "Shop";

    public java.lang.String getShopWSDDServiceName() {
        return ShopWSDDServiceName;
    }

    public void setShopWSDDServiceName(java.lang.String name) {
        ShopWSDDServiceName = name;
    }

    public server.Shop getShop() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Shop_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getShop(endpoint);
    }

    public server.Shop getShop(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            server.ShopSoapBindingStub _stub = new server.ShopSoapBindingStub(portAddress, this);
            _stub.setPortName(getShopWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setShopEndpointAddress(java.lang.String address) {
        Shop_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (server.Shop.class.isAssignableFrom(serviceEndpointInterface)) {
                server.ShopSoapBindingStub _stub = new server.ShopSoapBindingStub(new java.net.URL(Shop_address), this);
                _stub.setPortName(getShopWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Shop".equals(inputPortName)) {
            return getShop();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://server", "ShopService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://server", "Shop"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Shop".equals(portName)) {
            setShopEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
