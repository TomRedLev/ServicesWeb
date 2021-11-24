package fr.eiffelcorp.ifshare.rmi.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import fr.eiffelcorp.ifshare.rmi.common.ICalculator;


// To stop it : sudo kill -9 $(sudo lsof -t -i:8081)

public class CalculatorServer {
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(8081);
			ICalculator c = new Calculator();
			Naming.rebind("rmi://localhost:8081/CalculatorService", c);
		} catch (Exception e) {
			System.out.println("Trouble: " + e);
		}
	}
}
