package produit;

public enum unite {
	G("g"),KG("kg"),L("l"),CL("cl"),ML("ml"),PIECE("piece");
	
	private String nom;
	
	private unite(String nom) {
		this.nom=nom;
	}
	
	public String getNom(){
		return this.nom;
	}
}
