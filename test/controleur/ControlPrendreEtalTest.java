package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private Chef chef;
	private ControlVerifierIdentite controlVerifierIdentite;
	
	
	@BeforeEach
	public void initialisation() {
		village = new Village("Village test", 20, 1);
		chef = new Chef("Chef test", 7, village);
		village.setChef(chef);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
	}

	@Test
	void testControlPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertNotNull(controlPrendreEtal);
	}

	@Test
	void testResteEtals() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertTrue(controlPrendreEtal.resteEtals());
		
		Village village0Etal = new Village("village sans etal", 5, 0);
		ControlPrendreEtal controlPrendreEtal_complet = new ControlPrendreEtal(controlVerifierIdentite, village0Etal);
		assertFalse(controlPrendreEtal_complet.resteEtals());
		
	}

	@Test
	void testPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		String nomVendeur = "Vendeur test";
		String produit = "fleurs";
		int nbProduit = 5;
		assertTrue(controlPrendreEtal.resteEtals());
		
		
		controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		assertFalse(controlPrendreEtal.resteEtals());
	}

	@Test
	void testVerifierIdentite() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		
		String nomFauxHab = "Faux habitant";
		assertFalse(controlPrendreEtal.verifierIdentite(nomFauxHab));
		
		String nomGaulois = "Vrai habitant";
		Gaulois gaulois = new Gaulois(nomGaulois, 5);
		village.ajouterHabitant(gaulois);
		assertTrue(controlPrendreEtal.verifierIdentite(nomGaulois));
	}

}
