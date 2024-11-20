package produit;

public abstract class Produit implements IProduit {
	private String nom;
	private unite unite;
	
	public Produit(String nom,unite unite) {
		this.nom=nom;
		this.unite=unite;
	}
	@Override
	public String getNom() {
		return nom;
	}
	
	public abstract int calculDifference(int prix,int difUnite);
	/*
	 * On suppose que les prixs sont donnés dans les unités les plus habituelles (kg,l,piece)
	 */
	@Override
	public int calculerPrix(int prix) {
		int prixFinal=prix;
		if (unite.getNom()== "g") {
			prixFinal=calculDifference(prix,1000);
		}else if (unite.getNom()=="cl") {
			prixFinal=calculDifference(prix,100);
		}else if (unite.getNom()=="ml") {
			prixFinal=calculDifference(prix,1000);
		}
		return prixFinal;
	}
	@Override
	public abstract String descriptionProduit();
}
