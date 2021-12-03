/**
 * EurToMoneyServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package eurToMoney;

public class EurToMoneyServiceLocator extends org.apache.axis.client.Service implements eurToMoney.EurToMoneyService {

    public EurToMoneyServiceLocator() {
    }


    public EurToMoneyServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EurToMoneyServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for EurToMoney
    private java.lang.String EurToMoney_address = "http://localhost:8080/Convertisseur/services/EurToMoney";

    public java.lang.String getEurToMoneyAddress() {
        return EurToMoney_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EurToMoneyWSDDServiceName = "EurToMoney";

    public java.lang.String getEurToMoneyWSDDServiceName() {
        return EurToMoneyWSDDServiceName;
    }

    public void setEurToMoneyWSDDServiceName(java.lang.String name) {
        EurToMoneyWSDDServiceName = name;
    }

    public eurToMoney.EurToMoney getEurToMoney() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EurToMoney_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEurToMoney(endpoint);
    }

    public eurToMoney.EurToMoney getEurToMoney(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            eurToMoney.EurToMoneySoapBindingStub _stub = new eurToMoney.EurToMoneySoapBindingStub(portAddress, this);
            _stub.setPortName(getEurToMoneyWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEurToMoneyEndpointAddress(java.lang.String address) {
        EurToMoney_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (eurToMoney.EurToMoney.class.isAssignableFrom(serviceEndpointInterface)) {
                eurToMoney.EurToMoneySoapBindingStub _stub = new eurToMoney.EurToMoneySoapBindingStub(new java.net.URL(EurToMoney_address), this);
                _stub.setPortName(getEurToMoneyWSDDServiceName());
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
        if ("EurToMoney".equals(inputPortName)) {
            return getEurToMoney();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://eurToMoney", "EurToMoneyService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://eurToMoney", "EurToMoney"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("EurToMoney".equals(portName)) {
            setEurToMoneyEndpointAddress(address);
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
