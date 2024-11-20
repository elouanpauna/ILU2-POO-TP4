package villagegaulois;

import personnages.Gaulois;
import produit.IProduit;

public class Etal <P extends IProduit> implements IEtal{
	private Gaulois vendeur;
	private IProduit[] produit;
	private int nbProduit;
	private int prix;
	private int quantiteDebutMarche;
	private int quantite;
	private boolean etalOccupe = false;

	
	
	@Override
	public int donnerPrix() {
		return prix;
	}
	
	
	@Override
	 public int contientProduit(String produit, int quantiteSouhaitee) {
		int quantiteAVendre = 0;
		if (nbProduit != 0 && this.produit[0].getNom().equals(produit)) {
		 if (nbProduit >= quantiteSouhaitee) {
			 quantiteAVendre = quantiteSouhaitee;
		 } else {
			 quantiteAVendre = nbProduit;
		 }
		}
		return quantiteAVendre;
	}
	 @Override
	 public int acheterProduit(int quantiteSouhaite) {
	 int prixPaye = 0;
	 for (int i = nbProduit- 1; i > nbProduit- quantiteSouhaite- 1 || i > 1; i--) {
	 prixPaye += produit[i].calculerPrix(prix);
	 //question 3.d
	 }
	 if (nbProduit >= quantiteSouhaite) {
	 nbProduit-= quantiteSouhaite;
	 } else {
	 nbProduit = 0;	
}
	 return prixPaye;
}
	@Override
	public String etatEtal() {
		StringBuilder chaine = new StringBuilder(vendeur.getNom());
		if (nbProduit > 0) {
			chaine.append(" vend ");
			chaine.append(nbProduit + " produits :");
		for (int i = 0; i < nbProduit; i++) {
			chaine.append("\n- " + produit[i].descriptionProduit());
		 }
		} else {
			chaine.append(" n'a plus rien à vendre.");
		}
		chaine.append("\n");
		return chaine.toString();
	}
	
	public boolean isEtalOccupe() {
		return etalOccupe;
	}

	public Gaulois getVendeur() {
		return vendeur;
	}

	public int getQuantite() {
		return quantite;
	}

	public IProduit[] getProduit() {
		return produit;
	}
	
	public void installerVendeur(Gaulois vendeur, P[] produit, int prix) {
		this.vendeur=vendeur;
		this.nbProduit=produit.length;
		this.prix=prix;
		this.produit=produit;
	}
	
	public void occuperEtal(Gaulois vendeur, IProduit[] produit, int quantite) {
		this.vendeur = vendeur;
		this.produit = produit;
		this.quantite = quantite;
		quantiteDebutMarche = quantite;
		etalOccupe = true;
	}
	

	public void libererEtal() {
		etalOccupe = false;
	}

	
}
