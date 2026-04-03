package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private Village village;
	private Chef chef;
	
	@BeforeEach
	public void initialisation() {
		village = new Village("Village test", 20, 10);
		chef = new Chef("Chef test", 7, village);
		village.setChef(chef);
	}

	@Test
	void testControlEmmenager() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		assertNotNull(controlEmmenager);
	}

	@Test
	void testIsHabitant() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		String nom_goulois = "Gaulois test";
		assertNull(village.trouverHabitant(nom_goulois));
		
		controlEmmenager.ajouterGaulois(nom_goulois, 5);
		assertNotNull(village.trouverHabitant(nom_goulois));
		assertNotNull(village.trouverHabitant(chef.getNom()));
	}

	@Test
	void testAjouterDruide() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		String nom_druide = "Druide test";
		assertFalse(controlEmmenager.isHabitant(nom_druide));
		
		controlEmmenager.ajouterDruide(nom_druide, 5, 2, 4);
		assertTrue(controlEmmenager.isHabitant(nom_druide));
	}

	@Test
	void testAjouterGaulois() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		String nom_goulois = "Gaulois test";
		assertFalse(controlEmmenager.isHabitant(nom_goulois));
		
		controlEmmenager.ajouterGaulois(nom_goulois, 5);
		assertTrue(controlEmmenager.isHabitant(nom_goulois));
	}

}
