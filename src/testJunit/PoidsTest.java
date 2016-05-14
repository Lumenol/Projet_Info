package testJunit;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import pipopipette.FonctionDynamique;
import pipopipette.Grille;
import pipopipette.Poids;

public class PoidsTest {

	@Test
	public void testPoids() throws NumberFormatException, FileNotFoundException {
		Poids p = new Poids("./autre/C3x3.pip");
		Grille g = new Grille(3,3,true);	
		Integer i = p.get(g);
		if (i != 7){
			fail("Le poids ne vaut pas 7 mais "+i);
		}
		Integer [] t2 = {1,0,1};
		Grille g2 = new Grille(3,3,true,t2);
		i = p.get(g2);
		if (i != -1){
			fail("Le poids ne vaut pas -1 mais "+i);
		}
		Integer [] t3 = {1,1,1,1,1};
		Grille g3 = new Grille(3,3,true,t3);
		i = p.get(g3);
		if (i != 6){
			fail("Le poids ne vaut pas 6 mais "+i);
		}
		Integer [] t4 = {0,0,0,1,0,0,0,1,0,0,1,0};
		Grille g4 = new Grille(3,3,true,t4);
		i = p.get(g4);
		if (i != -8){
			fail("Le poids ne vaut pas -8 mais "+i);
		}
		Integer [] t5 = {1,1,1,1,1,1,1,1,1,1,1,1};
		Grille g5 = new Grille(3,3,true,t5);
		i = p.get(g5);
		if (i != 0){
			fail("Le poids ne vaut pas 0 mais "+i);
		}
	}

}
