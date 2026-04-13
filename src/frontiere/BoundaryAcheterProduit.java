package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		// TODO à completer
		
		if (!controlAcheterProduit.isHabitant(nomAcheteur)) {
			System.out.println(
					"Je suis désolée "+nomAcheteur+ " mais il faut être un habitant de notre village pour commercer ici.\n");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("1 - je veux acheter un produit.\n");
			question.append("2 - je veux avoir une vue d'ensemble du marché.\n");
			question.append("3 - quitter l'application.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					StringBuilder questionProduit =  new StringBuilder();
					questionProduit.append("Quel produit voulez-vous acheter ?\n");
					String choixProduit = Clavier.entrerChaine(questionProduit.toString());
					Gaulois[] vendeurs = controlAcheterProduit.getvillage().rechercherVendeursProduit(choixProduit);
					if(vendeurs==null) {
						questionProduit.append("Désolé, personne ne vend ce produit au marché.");
						break;
					}
					else {
						StringBuilder choixCommerçant = new StringBuilder();
						choixCommerçant.append("Chez quel commerçant voulez-vous acheter des "+choixProduit+" ?\n");
						for(int i=0; i<vendeurs.length; i++) {
							choixCommerçant.append((i+1)+" - "+vendeurs[i].getNom());
						}
						int choixVendeur = Clavier.entrerEntier(choixCommerçant.toString());
						StringBuilder chaine =  new StringBuilder();
						chaine.append(nomAcheteur+" se déplace jusqu'à l'étal du vendeur "+ choixCommerçant);
						
						StringBuilder questionQuantiteProd = new StringBuilder();
						questionQuantiteProd.append("Combien de "+choixProduit+" voulez-vous acheter ?\n");
						int choixQuantiteProd = Clavier.entrerEntier(questionQuantiteProd.toString());
						
						String nomVendeurChoisit = vendeurs[choixVendeur-1].getNom(); 
						int quantiteDispo = controlAcheterProduit.getvillage().rechercherEtal(vendeurs[choixVendeur-1]).getQuantite();
						if(quantiteDispo == 0) {
							questionQuantiteProd.append(nomAcheteur+" veut acheter "+choixQuantiteProd+" "+choixProduit+", malheureusement il n’y'en a plus !");
							
						}
						
						else if(quantiteDispo < choixQuantiteProd) {
							questionQuantiteProd.append(nomAcheteur+" veut acheter "+choixQuantiteProd+" "+choixProduit+", malheureusement "+nomVendeurChoisit+" n'en a plus que "+quantiteDispo+". "+nomAcheteur+" achète tout le stock de "+nomVendeurChoisit+".");
							
						}
						else {
							questionQuantiteProd.append(nomAcheteur+" achète "+choixQuantiteProd+ " "+ choixProduit+ " à "+ vendeurs[choixVendeur-1]);
							
						}
					}
					break;

				case 2:
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}
}
