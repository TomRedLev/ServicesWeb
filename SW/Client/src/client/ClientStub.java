package client;

import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import common.Client;
import common.Observator;
import common.Product;
import compte.Compte;
import compte.CompteServiceLocator;
import server.Shop;
import server.ShopServiceLocator;
import compte.CompteSoapBindingStub;
import eurToMoney.EurToMoney;
import eurToMoney.EurToMoneyServiceLocator;


public class ClientStub {
    
	private static final Logger LOGGER = Logger.getLogger(ClientStub.class.getPackage().getName());
	private static ArrayList<Product> list = new ArrayList<Product>();
    
	private static void buyProduct(Shop shop, Product product, Client client) throws RemoteException, ServiceException {
		if(client.getCompte().currencyType().equals("EUR")) {
			client.getCompte().retraitDe(product.getPrice());
			shop.sellToClient(client.getToken(), product.getName());
		}
		else {
			EurToMoney eurToMoney = new EurToMoneyServiceLocator().getEurToMoney();
			switch(client.getCompte().currencyType()) {
				case "JPY":
					client.getCompte().retraitDe(eurToMoney.convertToEur(product.getPrice(), "JPY"));
					break;
				case "GBP":
					client.getCompte().retraitDe(eurToMoney.convertToEur(product.getPrice(), "GBP"));
					break;
				case "USD":
					client.getCompte().retraitDe(eurToMoney.convertToEur(product.getPrice(), "USD"));
					break;
				default:
			        LOGGER.log(Level.INFO, "Unknow currency");
			}
			shop.sellToClient(client.getToken(), product.getName());
		}
	}
	
    public static void main(String[] args) throws ServiceException, RemoteException {
        Shop shop = new ShopServiceLocator().getShop();
        Compte compte = new CompteServiceLocator().getCompte();
        ((CompteSoapBindingStub) compte).setMaintainSession(true);
        
        compte.setCurrency("JPY");
        compte.depotDe(10000);
        
        Client client1 = new Client("Alder", compte);
        Observator client1_observator = new Observator();
        // A CONSERVER SI DECONNEXION
        client1.setToken(shop.registerClient(client1.getName(), client1_observator));
        
        list.add( new Product("Harry Potter", "Book", "Alder", 9.99, "EUR", "très bon livre"));
        list.add(new Product("Alice aux pays des merveilles", "Book", "Alder", 8.99, "EUR", "très bon livre, encore"));
        list.add(new Product("Jack in the box", "Toy", "Alder", 24.99, "EUR", "très bon jeu"));
                
        
        shop.buyFromClient(client1.getToken(), list.get(0));        
        LOGGER.log(Level.INFO, shop.storeProducts());
        buyProduct(shop, list.get(0), client1);
        System.out.println(compte.valeurDuSolde());

        shop.buyFromClient(client1.getToken(), list.get(2));
        LOGGER.log(Level.INFO, shop.storeProducts());
        buyProduct(shop, list.get(2), client1);
        System.out.println(compte.valeurDuSolde());

        shop.buyFromClient(client1.getToken(), list.get(1));
        LOGGER.log(Level.INFO, shop.storeProducts());
        buyProduct(shop, list.get(1), client1);
        System.out.println(compte.valeurDuSolde());
        
        shop.buyFromClient(client1.getToken(), list.get(2));
        LOGGER.log(Level.INFO, shop.storeProducts());
        buyProduct(shop, list.get(2), client1);
        System.out.println(compte.valeurDuSolde());
        
        shop.buyFromClient(client1.getToken(), list.get(1));
        LOGGER.log(Level.INFO, shop.storeProducts());
        buyProduct(shop, list.get(2), client1);
        System.out.println(compte.valeurDuSolde());
    }


}