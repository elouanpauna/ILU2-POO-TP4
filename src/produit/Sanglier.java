package produit;

import personnages.Gaulois;

public class Sanglier extends Produit{
	private Gaulois chasseur;
	private int poids;
	
	public Sanglier(int poids,Gaulois chasseur) {
		super("sanglier",unite.KG);
		this.chasseur=chasseur;
		this.poids=poids;
	}
	
	@Override
	public int calculDifference(int prix,int difference) {
		int result=prix;
		int poidsKg=poids/difference;
		result=result*poidsKg;
		return result;
	}
	
	@Override
	public String descriptionProduit() {
		String description= "sanglier de " + Integer.toString(poids)+ " kg chassé par "+ chasseur.getNom();
		return description;
	}
	
	
}
