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
			
		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}
