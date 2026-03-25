package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		StringBuilder chaine = new StringBuilder();
		if(!vendeurReconnu) {
			chaine.append("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
		}
		else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			boolean etalOccupe = donneesEtal[0].equals("true");
			if(etalOccupe) {
				String produit = donneesEtal[2];
				String quantiteInitial = donneesEtal[3];
				String quantiteVendu = donneesEtal[4];
				chaine.append("Vous avez vendu "+quantiteVendu+" sur "+ quantiteInitial+ " "+ produit+".");
				chaine.append("Au revoir "+nomVendeur+", passez une bonne journée");
			}
		
		}
	}

}
