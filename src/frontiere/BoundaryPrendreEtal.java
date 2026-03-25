package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		StringBuilder chaine = new StringBuilder();
		if(!nomVendeurConnu) {
			chaine.append("Je suis désolée "+ nomVendeur+ " mais il faut être un habitant de notre village pour commercer ici.");
			
		}
		else {
			chaine.append("Bonjour "+ nomVendeur+ " , je vais regarder si je peux vous trouver un étal.");
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			if(!etalDisponible) {
				chaine.append("Désolée "+nomVendeur+" je n'ai plus d'étal qui ne sont pas déjà occupé.");
			}
			else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder chaine = new StringBuilder();
		chaine.append("C'est parfait, il me reste un étal pour vous !");
		chaine.append("Il me faudrait quelques renseignements.");
		//StringBuilder question = new StringBuilder();
		chaine.append("Quel produit souhaitez-vous vendre ?");
		String choixProduit = Clavier.entrerChaine(chaine.toString());
		chaine.append("Combien souhaitez-vous en vendre ?");
		int choixQuantitéProd = Clavier.entrerEntier(chaine.toString());
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, choixProduit, choixQuantitéProd);
		if(numeroEtal != -1) {
			chaine.append("Le vendeur "+ nomVendeur+ " s'est installé à l'étal n°"+ numeroEtal);
		}
	}
}
