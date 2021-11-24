package fr.eiffelcorp.ifshare.rmi.client;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;

import fr.eiffelcorp.ifshare.rmi.common.IShop;

public class ShopClient {
	@SuppressWarnings("deprecation")
	public static void main(String[] args)  {
		try {
			System.setSecurityManager(new RMISecurityManager());
			IShop s = (IShop) Naming.lookup("rmi://localhost:8081/CalculatorService");
			s.buy();
			s.sell();
		} catch (Exception e) {
			System.out.println("Trouble :" + e);
		}
	}

}
