package fr.eiffelcorp.ifshare.rmi.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import fr.eiffelcorp.ifshare.rmi.common.IShop;


// To stop it : sudo kill -9 $(sudo lsof -t -i:8081)

// Ameliorations : 
	// Ajouter une fonction qui envoie un Token unique (permettra d'authentifier les transactions d'ajout et de delete).
	// Modifier la fonction de delete pour demander le token et le nom de l'utilisateur (double vérification).
	//Ajouter le champ Token dans les products.
	// On peut créer une hashmap qui contiendra token : nom, pour ne pas régénérer un token pour une personne qui s'est
	// déjà connectée.
	// Permettra de ne demander que le token de la personne et de vérifier si le nom est bien commun.
	// Si on fait ça, plus besoin du token dans les products.
	//
	// On pourrait aussi faire un token comme clé d'une HashMap<Token, List<IProduct>>,
	// Pour delete token + nom de l'objet
	// Pour ajouter token + objet

// Ajouts nécessaires : 
	// Ajouter l'observator/observer.
	
// java fr.eiffelcorp.ifshare.rmi.server.IfShareServer

public class IfShareServer {
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(8081);
			IShop s = new Shop();
			Naming.rebind("rmi://localhost:8081/ShopService", s);
		} catch (Exception e) {
			System.out.println("Trouble: " + e);
		}
	}
}
