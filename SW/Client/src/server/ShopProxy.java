package server;

public class ShopProxy implements server.Shop {
  private String _endpoint = null;
  private server.Shop shop = null;
  
  public ShopProxy() {
    _initShopProxy();
  }
  
  public ShopProxy(String endpoint) {
    _endpoint = endpoint;
    _initShopProxy();
  }
  
  private void _initShopProxy() {
    try {
      shop = (new server.ShopServiceLocator()).getShop();
      if (shop != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)shop)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)shop)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (shop != null)
      ((javax.xml.rpc.Stub)shop)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public server.Shop getShop() {
    if (shop == null)
      _initShopProxy();
    return shop;
  }
  
  public int sellToClient(int token, java.lang.String product_name) throws java.rmi.RemoteException{
    if (shop == null)
      _initShopProxy();
    return shop.sellToClient(token, product_name);
  }
  
  public int buyFromClient(int token, common.Product product) throws java.rmi.RemoteException{
    if (shop == null)
      _initShopProxy();
    return shop.buyFromClient(token, product);
  }
  
  public void notifyAllObservators(common.Product product) throws java.rmi.RemoteException{
    if (shop == null)
      _initShopProxy();
    shop.notifyAllObservators(product);
  }
  
  public java.lang.String storeProducts() throws java.rmi.RemoteException{
    if (shop == null)
      _initShopProxy();
    return shop.storeProducts();
  }
  
  public void addObservator(int token, common.Observator observator) throws java.rmi.RemoteException{
    if (shop == null)
      _initShopProxy();
    shop.addObservator(token, observator);
  }
  
  public java.lang.String clientProducts(int token) throws java.rmi.RemoteException{
    if (shop == null)
      _initShopProxy();
    return shop.clientProducts(token);
  }
  
  public void removeAllObservators() throws java.rmi.RemoteException{
    if (shop == null)
      _initShopProxy();
    shop.removeAllObservators();
  }
  
  public int registerClient(java.lang.String name, common.Observator observator) throws java.rmi.RemoteException{
    if (shop == null)
      _initShopProxy();
    return shop.registerClient(name, observator);
  }
  
  
}