package common;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Observator {
    private static final Logger LOGGER = Logger.getLogger( Observator.class.getPackage().getName() );
    private List<String> products = new ArrayList<>();
    private final Object lock = new Object();
    
    public Observator() {}
    
    public int update(Product product) {
        for (String elem : products) {
            if (elem.equals(product.getName())) {
                LOGGER.log( Level.INFO, "The following product is available : " + product.getInfo());
                synchronized (lock) {
                    this.products.remove(elem);
                }
                LOGGER.log( Level.INFO,"Automatic buy of this product."); //Choice, seems like the closest to the assignment.
                return 0;
            }
        }
        return 1;
    }
    
    
	public void setProduct(String product) {
		for (String elem : products) {
			if (elem.equals(product)) {
				return ;
			}
		}
		synchronized(lock) {
			products.add(product);
		}
	}

    
    public String getInfo() {
        return "Observator{" + "product : " + products + "}";
    }
}
