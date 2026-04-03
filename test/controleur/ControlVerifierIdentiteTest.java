package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	private Chef chef;
	
	
	@BeforeEach
	public void initialisation() {
		village = new Village("Village test", 20, 10);
		chef = new Chef("Chef test", 7, village);
		village.setChef(chef);
	}

	@Test
	void testControlVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertNotNull(controlVerifierIdentite);
	}

	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		String nomFauxHab = "Faux habitant";
		assertFalse(controlVerifierIdentite.verifierIdentite(nomFauxHab));
		
		String nomGaulois = "Vrai habitant";
		Gaulois gaulois = new Gaulois(nomGaulois, 5);
		village.ajouterHabitant(gaulois);
		assertTrue(controlVerifierIdentite.verifierIdentite(nomGaulois));
	}

}
