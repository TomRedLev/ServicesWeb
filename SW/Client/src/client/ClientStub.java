package client;

import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;


import java.util.logging.Level;
import java.util.logging.Logger;

import common.Observator;
import common.Product;
import server.Shop;
import server.ShopServiceLocator;


public class ClientStub {
    
	private static final Logger LOGGER = Logger.getLogger(ClientStub.class.getPackage().getName());
    
    public static void main(String[] args) throws ServiceException, RemoteException {
        Shop shop = new ShopServiceLocator().getShop();

        String client1_name = "Alder";
        Observator client1_observator = new Observator();
        // A CONSERVER SI DECONNEXION
        Integer client1_token = shop.registerClient(client1_name, client1_observator);

        Product product = new Product("Harry Potter", "Book", "Alder", 9.99, "très bon livre");
        Product product2 = new Product("Alice aux pays des merveilles", "Book", "Alder", 8.99, "très bon livre, encore");
        Product product3 = new Product("Jack in the box", "Toy", "Alder", 24.99, "très bon jeu");

        LOGGER.log(Level.INFO, "Hello World with java.util.logging");

        shop.buyFromClient(client1_token, product);
        LOGGER.log(Level.INFO, shop.storeProducts());
        shop.sellToClient(client1_token, "Alice aux pays des merveilles");
        LOGGER.log(Level.INFO, shop.storeProducts());
        shop.sellToClient(client1_token, "Jack in the box");
        LOGGER.log(Level.INFO, shop.storeProducts());
        shop.buyFromClient(client1_token, product2);
        LOGGER.log(Level.INFO, shop.storeProducts());
        shop.buyFromClient(client1_token, product3);
        LOGGER.log(Level.INFO, shop.storeProducts());
        shop.sellToClient(client1_token, "Alice aux pays des merveilles");
        LOGGER.log(Level.INFO, shop.storeProducts());



    }


}