package fr.eiffelcorp.ifshare.rmi.client;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;

import fr.eiffelcorp.ifshare.rmi.common.IObservator;
import fr.eiffelcorp.ifshare.rmi.common.IProduct;
import fr.eiffelcorp.ifshare.rmi.common.IShop;

// Reflechir sur le fait de savoir si product est sensé être coté client ou serveur.
// Juste a déplacer le fichier et à créer des IProducts et call les bonnes méthodes si on veut le passer.
// de l'autre côté.

// Principe établi ici : Le client possède les produits et les observateurs et le shop n'est qu'une plateforme de transfert.


@SuppressWarnings("deprecation")
public class IfShareClient {
	public static void main(String[] args)  {
		try {
			// Chemin a changer
			String secpath = "RMI/fr.eiffelcorp.ifshare.rmi.client/.settings/";
			System.setProperty("java.security.policy", secpath + "sec.policy");
			System.setSecurityManager(new RMISecurityManager());
			IShop s = (IShop) Naming.lookup("rmi://localhost:8081/ShopService");
			
			String client1_name = "Alder";
			IObservator client1_observator = new Observator();
			// A CONSERVER SI DECONNEXION
			Integer client1_token = s.registerClient(client1_name, client1_observator);
			
			IProduct product = new Product("Harry Potter", "Book", "Alder", 9.99, "très bon livre");
			IProduct product2 = new Product("Alice aux pays des merveilles", "Book", "Alder", 8.99, "très bon livre, encore");
			IProduct product3 = new Product("Jack in the box", "Toy", "Alder", 24.99, "très bon jeu");
			
			System.out.println(s.buyFromClient(client1_token, product));
			System.out.println(s.storeProducts());
			System.out.println(s.sellToClient(client1_token, "Alice aux pays des merveilles"));
			System.out.println(s.storeProducts());
			System.out.println(s.sellToClient(client1_token, "Jack in the box"));
			System.out.println(s.storeProducts());
			System.out.println(s.buyFromClient(client1_token, product2));
			System.out.println(s.storeProducts());
			System.out.println(s.buyFromClient(client1_token, product3));
			System.out.println(s.storeProducts());
			System.out.println(s.sellToClient(client1_token, "Alice aux pays des merveilles"));
			System.out.println(s.storeProducts());
			
		} catch (Exception e) {
			System.out.println("Trouble: " + e);
		}
	}

}
