package fr.eiffelcorp.ifshare.rmi.client;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;

import fr.eiffelcorp.ifshare.rmi.common.ICalculator;

public class CalculatorClient {
	@SuppressWarnings("deprecation")
	public static void main(String[] args)  {
		try {
			System.setSecurityManager(new RMISecurityManager());
			ICalculator c = (ICalculator) Naming.lookup("rmi://localhost:8081/CalculatorService");
			System.out.println(c.sub(4, 3));
			System.out.println(c.add(4, 5));
			System.out.println(c.mul(3, 6));
			System.out.println(c.sub(9, 3));
			
		} catch (Exception e) {
			System.out.println("Trouble :" + e);
		}
	}

}
