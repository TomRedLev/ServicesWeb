package fr.eiffelcorp.ifshare.rmi.client;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;

import fr.eiffelcorp.ifshare.rmi.common.IProduct;
import fr.eiffelcorp.ifshare.rmi.common.IShop;

@SuppressWarnings("deprecation")
public class IfShareClient {
	public static void main(String[] args)  {
		try {
			System.setSecurityManager(new RMISecurityManager());
			IShop s = (IShop) Naming.lookup("rmi://localhost:8081/ShopService");
			IProduct product = new Product();
			product.setName("Harry Potter");
			product.setType("Book");
			product.setSeller("Alder");
			product.setPrice(9.99);
			product.setComment("très bon livre");
			System.out.println(s.buyFromClient(product));
			System.out.println(s.sellToClient("Harry Potter", 9.99));
		} catch (Exception e) {
			System.out.println("Trouble: " + e);
		}
	}

}
