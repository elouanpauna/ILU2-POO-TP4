package produit;

public class Poisson extends Produit{
	private String datePeche;
	
	public Poisson(String datePeche) {
		super("poisson",unite.PIECE);
		this.datePeche=datePeche;
	}
	
	@Override
	public int calculDifference(int prix,int difference) {
		return prix;
	}
	
	@Override
	public String descriptionProduit() {
		String description= "poisson pêché "+ datePeche;
		return description;
	}
}
