package compte;

public class Compte {
	private double solde;
	private String currency;

	public Compte() {
	}
	
	public Compte(double solde, String currency) {
		this.solde = solde;
		this.currency = currency;
	}
	
	 public void depotDe(double montant) {
		 if (montant < 0) {
			 //TODO faire quelque chose de mieux log ?
	         System.err.println("montant < 0");
	     }
	     else
	    	 solde += montant;
	}
	
	public boolean retraitDe(double montant) {
		if (solde >= montant) {
			solde -= montant;
			return true;
		}
		return false;
	}
	
	public double valeurDuSolde() {
		return solde;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public String currencyType() {
		return currency;
	}
}
