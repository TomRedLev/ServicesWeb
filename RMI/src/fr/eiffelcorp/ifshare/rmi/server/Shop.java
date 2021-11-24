package fr.eiffelcorp.ifshare.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import fr.eiffelcorp.ifshare.rmi.common.IProduct;
import fr.eiffelcorp.ifshare.rmi.common.IShop;

@SuppressWarnings("serial")
public class Shop extends UnicastRemoteObject implements IShop {
	
	private List<IProduct> products = new ArrayList<>();

	protected Shop() throws RemoteException {
		super();
	}
	
	private IProduct searchForProduct(String product_name, Double product_price) throws RemoteException {
		for (var product : products) {
			if (product.getName().equals(product_name) && product.getPrice().equals(product_price) ) {
				return product;
			}
		}
		return null;
	}

	@Override
	public int sellToClient(String product_name, Double product_price) throws RemoteException {
		IProduct product = searchForProduct(product_name, product_price);
		if (product != null) {
			products.remove(product);
			return 0;
		}
		return 1;
	}

	@Override
	public int buyFromClient(IProduct product) throws RemoteException {
		products.add(product);
		return 0;
	}

}
