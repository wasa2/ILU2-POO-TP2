package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private Chef chef;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;
	@BeforeEach
	public void initialisation() {
		village = new Village("Village test", 10, 5);
		chef = new Chef("Chef test", 7, village);
		village.setChef(chef);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		
	}

	@Test
	void testControlAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		assertNotNull(controlAcheterProduit);
	}

	@Test
	void testIsHabitant() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		Gaulois inconnu = new Gaulois("Inconnu", 4);
		assertFalse(controlAcheterProduit.isHabitant("Inconnu"));
		village.ajouterHabitant(inconnu);
		assertTrue(controlAcheterProduit.isHabitant("Inconnu"));
	}

	@Test
	void testGetvillage() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		Village village_recu = controlAcheterProduit.getvillage();
		assertEquals(village_recu, village);
	}

}
