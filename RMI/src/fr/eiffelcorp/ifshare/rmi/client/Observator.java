package fr.eiffelcorp.ifshare.rmi.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import fr.eiffelcorp.ifshare.rmi.common.IObservator;
import fr.eiffelcorp.ifshare.rmi.common.IProduct;

@SuppressWarnings("serial")
public class Observator extends UnicastRemoteObject implements IObservator {
    private List<String> products = new ArrayList<>();
    private final Object lock = new Object();

    public Observator() throws RemoteException {
        super();
    }

    @Override
    public void update(IProduct product) throws RemoteException {
    	for (var elem : products) {
    		if (elem.equals(product.getName())) {
        		System.out.println("The following product is available : " + product.getInfo());
        		synchronized (lock) {
        			this.products.remove(elem);
        		}
        	}
    	}
    }
    
    @Override
	public void setProduct(String product) throws RemoteException {
		for (var elem : products) {
			if (elem.equals(product)) {
				return ;
			}
		}
		synchronized(lock) {
			products.add(product);
		}
	}

    @Override
    public String getInfo() throws RemoteException {
        return "Observator{" + "product : " + products + "}";
    }
}
