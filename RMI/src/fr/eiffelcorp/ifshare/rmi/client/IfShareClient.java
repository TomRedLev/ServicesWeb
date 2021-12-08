package fr.eiffelcorp.ifshare.rmi.client;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.util.Scanner;

import fr.eiffelcorp.ifshare.rmi.common.IObservator;
import fr.eiffelcorp.ifshare.rmi.common.IProduct;
import fr.eiffelcorp.ifshare.rmi.common.IShop;

// Reflechir sur le fait de savoir si product est sensé être coté client ou serveur.
// Juste a déplacer le fichier et à créer des IProducts et call les bonnes méthodes si on veut le passer.
// de l'autre côté.

// Principe établi ici : Le client possède les produits et les observateurs et le shop n'est qu'une plateforme de transfert.


// java fr.eiffelcorp.ifshare.rmi.client.IfShareClient

@SuppressWarnings("deprecation")
public class IfShareClient {
	public static void main(String[] args)  {
		try {
			// Chemin à changer si ne fonctionne pas pour Julien ou Gabriel
			// Fonctionne sans pour Tom
            String secpath = "src/fr/eiffelcorp/ifshare/rmi/client/.settings/";
			//String secpath = "'RMI/src/fr/eiffelcorp/ifshare/rmi/client/";
			System.setProperty("java.security.policy", secpath + "sec.policy");
			System.setSecurityManager(new RMISecurityManager());
			IShop s = (IShop) Naming.lookup("rmi://localhost:8081/ShopService");
			
			
			var sc = new Scanner(System.in);
			String client_name = "";
			System.out.print("Enter your name : ");
			if (sc.hasNextLine()) {
				client_name = sc.nextLine();
			}
			
			IObservator client_observator = new Observator();
			// A CONSERVER SI DECONNEXION
			Integer client_token = s.registerClient(client_name, client_observator);
			System.out.println("You are connected, " + client_name + ". Your token is : " + client_token);
			
			boolean quit = false;
			while (true) {
				System.out.print("See the shop, buy a product, sell a product or Quit ? (SH, B, S or Q) : "); 
				String action = sc.nextLine();
				String pr_name = "";
				String pr_type = "";
				double pr_price = 0;
				String pr_comment = "";
				
				switch (action) {
					case "SH" : 
						System.out.println(s.storeProducts());
						break;
						
					case "B" :
						System.out.print("Enter product name : "); 
						if (sc.hasNextLine()) {
							pr_name = sc.nextLine();
						}
						s.sellToClient(client_token, pr_name);
						break;
						
					case "S" :
						System.out.print("Enter product name : ");
						if (sc.hasNextLine()) {
							pr_name = sc.nextLine();
						}
						System.out.print("Enter product type : ");
						if (sc.hasNextLine()) {
							pr_type = sc.nextLine();
						}
						System.out.print("Enter product price : "); 
						if (sc.hasNextDouble()) {
							pr_price = Double.parseDouble(sc.nextLine());
						}
						System.out.print("Enter product comment : ");
						if (sc.hasNextLine()) {
							pr_comment = sc.nextLine();
						}
						IProduct product = new Product(pr_name, pr_type, client_name, pr_price, pr_comment);
						s.buyFromClient(client_token, product);
						break;
						
					case "Q" : 
						quit = true;
						break;
						
					default :
						System.out.println("Error");
						break;
				}
				
				if (quit == true) {
					break;
				}
			}
			sc.close();
			System.out.println("Hope to see you soon !");
			
			
			/*
			IProduct product = new Product("Harry Potter", "Book", "Alder", 9.99, "très bon livre");
			IProduct product2 = new Product("Alice aux pays des merveilles", "Book", "Alder", 8.99, "très bon livre, encore");
			IProduct product3 = new Product("Jack in the box", "Toy", "Alder", 24.99, "très bon jeu");
			
			System.out.println(s.buyFromClient(client_token, product));
			System.out.println(s.storeProducts());
			System.out.println(s.sellToClient(client_token, "Alice aux pays des merveilles"));
			System.out.println(s.storeProducts());
			System.out.println(s.sellToClient(client_token, "Jack in the box"));
			System.out.println(s.storeProducts());
			System.out.println(s.buyFromClient(client_token, product2));
			System.out.println(s.storeProducts());
			System.out.println(s.buyFromClient(client_token, product3));
			System.out.println(s.storeProducts());
			System.out.println(s.sellToClient(client_token, "Alice aux pays des merveilles"));
			System.out.println(s.storeProducts());
			*/
			
		} catch (Exception e) {
			System.out.println("Trouble: " + e);
		}
	}

}
