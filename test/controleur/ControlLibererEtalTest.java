package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private Village village;
	private Chef chef;
	@BeforeEach
	public void initialisation(){
		village = new Village("Village test", 10, 5);
		chef = new Chef("Chef test", 7, village);
		village.setChef(chef);
	}

	@Test
	void testControlLibererEtal() {
		fail("Not yet implemented");
	}

	@Test
	void testLibererEtal() {
		fail("Not yet implemented");
	}

	@Test
	void testIsVendeur() {
		fail("Not yet implemented");
	}

}
