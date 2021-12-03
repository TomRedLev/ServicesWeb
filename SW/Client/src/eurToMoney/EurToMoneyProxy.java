package eurToMoney;

public class EurToMoneyProxy implements eurToMoney.EurToMoney {
  private String _endpoint = null;
  private eurToMoney.EurToMoney eurToMoney = null;
  
  public EurToMoneyProxy() {
    _initEurToMoneyProxy();
  }
  
  public EurToMoneyProxy(String endpoint) {
    _endpoint = endpoint;
    _initEurToMoneyProxy();
  }
  
  private void _initEurToMoneyProxy() {
    try {
      eurToMoney = (new eurToMoney.EurToMoneyServiceLocator()).getEurToMoney();
      if (eurToMoney != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)eurToMoney)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)eurToMoney)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (eurToMoney != null)
      ((javax.xml.rpc.Stub)eurToMoney)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public eurToMoney.EurToMoney getEurToMoney() {
    if (eurToMoney == null)
      _initEurToMoneyProxy();
    return eurToMoney;
  }
  
  public double convertToJpy(double montant) throws java.rmi.RemoteException{
    if (eurToMoney == null)
      _initEurToMoneyProxy();
    return eurToMoney.convertToJpy(montant);
  }
  
  public double convertToGpb(double montant) throws java.rmi.RemoteException{
    if (eurToMoney == null)
      _initEurToMoneyProxy();
    return eurToMoney.convertToGpb(montant);
  }
  
  public double convertToUsd(double montant) throws java.rmi.RemoteException{
    if (eurToMoney == null)
      _initEurToMoneyProxy();
    return eurToMoney.convertToUsd(montant);
  }
  
  public double convertToEur(double montant, java.lang.String currency) throws java.rmi.RemoteException{
    if (eurToMoney == null)
      _initEurToMoneyProxy();
    return eurToMoney.convertToEur(montant, currency);
  }
  
  
}