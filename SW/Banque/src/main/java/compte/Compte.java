package compte;

public class Compte {
	private int solde;

	public Compte() {
	}
	
	public Compte(int solde) {
		this.solde = solde;
	}
	
	public void depotDe(int montant) {
		if (montant < 0) {
			//faire quelque chose
		}
		solde += montant;
	}
	
	public boolean retraitDe(int montant) {
		if (solde >= montant) {
			solde -= montant;
			return true;
		}
		return false;
	}
	
	public int valeurDuSolde() {
		return solde;
	}
	
}
