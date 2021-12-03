package server;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.StringJoiner;

import common.Observator;
import common.Product;

@SuppressWarnings("serial")
public class Shop {
	private Map<Integer, List<Product>> products = new HashMap<>();
	private Map<Integer, Observator> observators = new HashMap<>();
	private List<Observator> order_observators = new ArrayList<>();
	private final Object lock = new Object();

	public Shop() {}

	
	public int registerClient(String name, Observator observator) {
		int token = name.hashCode(); 
		int count = 0;
		while (products.containsKey(token)) {
			token = (token / 2) + count;
			count += 1;
		}
		synchronized (lock) {
			products.put(token, new ArrayList<Product>());
		}
		addObservator(token, observator);
		return token;
	}
	
	private Product searchForProduct(Integer token, String product_name) {
		for (Product product : products.get(token)) {
			if (product.getName().equals(product_name)) {
				return product;
			}
		}
		return null;
	}

	
	public int sellToClient(Integer token, String product_name) {
		Product product = searchForProduct(token, product_name);
		if (product != null) {
			synchronized (lock) {
				observators.get(token).setProduct("");
				products.get(token).remove(product);
				order_observators.remove(observators.get(token));
			}
			return 0;
		}
		synchronized (lock) {
			observators.get(token).setProduct(product_name);
			order_observators.add(observators.get(token));
		}
		return 1;
	}

	
	public int buyFromClient(Integer token, Product product) {
		synchronized (lock) {
			products.get(token).add(product);
		}
		notifyAllObservators(product);
		return 0;
	}
		
	public String storeProducts() {
		StringJoiner sj = new StringJoiner(", ");
		for (List<Product> productsList : products.values()) {
			for (Product prod : productsList) {
				sj.add(prod.getInfo());
			}
		}
		return sj.toString();
	}
		
	public String clientProducts(Integer token) {
		StringJoiner sj = new StringJoiner(", ");
		for (Product prod : products.get(token)) {
			sj.add(prod.getInfo());
		}
		return sj.toString();
	}
	
	public void addObservator(Integer token, Observator observator) {
		synchronized (lock) {
			this.observators.put(token, observator);
		}
	}
	    
    public void notifyAllObservators(Product product) {
        for (Observator observator : order_observators) {
        	synchronized (lock) {
        		 if (observator.update(product) == 0) {
        			 for (Entry<Integer, Observator> entry : observators.entrySet()) {
        			        if (Objects.equals(observator, entry.getValue())) {
        			            sellToClient(entry.getKey(), product.getName());
        			            break;
        			        }
        			 }
        			 break;
        		 }
        	}
        }
    }

    
    public void removeAllObservators() {
    	synchronized (lock) {
    		observators.clear();
    	}
    }

}
