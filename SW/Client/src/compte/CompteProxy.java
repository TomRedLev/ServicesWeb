package compte;

public class CompteProxy implements compte.Compte {
  private String _endpoint = null;
  private compte.Compte compte = null;
  
  public CompteProxy() {
    _initCompteProxy();
  }
  
  public CompteProxy(String endpoint) {
    _endpoint = endpoint;
    _initCompteProxy();
  }
  
  private void _initCompteProxy() {
    try {
      compte = (new compte.CompteServiceLocator()).getCompte();
      if (compte != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)compte)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)compte)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (compte != null)
      ((javax.xml.rpc.Stub)compte)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public compte.Compte getCompte() {
    if (compte == null)
      _initCompteProxy();
    return compte;
  }
  
  public void depotDe(double montant) throws java.rmi.RemoteException{
    if (compte == null)
      _initCompteProxy();
    compte.depotDe(montant);
  }
  
  public boolean retraitDe(double montant) throws java.rmi.RemoteException{
    if (compte == null)
      _initCompteProxy();
    return compte.retraitDe(montant);
  }
  
  public double valeurDuSolde() throws java.rmi.RemoteException{
    if (compte == null)
      _initCompteProxy();
    return compte.valeurDuSolde();
  }
  
  public java.lang.String currencyType() throws java.rmi.RemoteException{
    if (compte == null)
      _initCompteProxy();
    return compte.currencyType();
  }
  
  public void setCurrency(java.lang.String currency) throws java.rmi.RemoteException{
    if (compte == null)
      _initCompteProxy();
    compte.setCurrency(currency);
  }
  
  
}