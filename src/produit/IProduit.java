package produit;

public interface IProduit {

	String getNom();

	String descriptionProduit();
	 
	int calculerPrix(int prix);

	int calculDifference(int prix, int difference);
	
}