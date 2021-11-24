package fr.eiffelcorp.ifshare.rmi.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import fr.eiffelcorp.ifshare.rmi.common.IShop;


// To stop it : sudo kill -9 $(sudo lsof -t -i:8081)

public class ShopServer {
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(8081);
			IShop c = new Shop();
			Naming.rebind("rmi://localhost:8081/CalculatorService", c);
		} catch (Exception e) {
			System.out.println("Trouble: " + e);
		}
	}
}
