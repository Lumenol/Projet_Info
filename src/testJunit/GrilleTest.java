package testJunit;

import static org.junit.Assert.*;

import org.junit.Test;

import pipopipette.Grille;

public class GrilleTest {

	@Test
	public void testEquals () {
		//deux grilles avec contours, vides
		Integer [] t1 = {0};
		Grille g1 = new Grille(3,3,true,t1);
		Integer [] t2 = {0};
		Grille g2 = new Grille(3,3,true,t2);
		if (! g1.equals(g2)){
			fail("Grilles différentes\n"+g1.toString()+"\n \n"+g2.toString());
		}
		//deux grilles avec 1 carré, symétrie
		Integer [] t3 = {1,0,1};
		Grille g3 = new Grille(3,3,true,t3);
		Integer [] t4 = {0,1,0,0,1};
		Grille g4 = new Grille(3,3,true,t4);
		if (! g3.equals(g4)){
			fail("Grilles différentes\n"+g3.toString()+"\n \n"+g4.toString());
		}
		//deux grilles sans contours, pleines
		Integer [] t5 = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		Grille g5 = new Grille(3,3,false,t5);
		Integer [] t6 = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		Grille g6 = new Grille(3,3,false,t6);
		if (! g5.equals(g6)){
			fail("Grilles différentes\n"+g5.toString()+"\n \n"+g6.toString());
		}
		//deux grilles sans contours, 2 carrés, rotation
		Integer [] t7 = {1,1,0,1,1,1,0,1,1,0};
		Grille g7 = new Grille(3,3,false,t7);
		Integer [] t8 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,1,1,1,0,1,1};
		Grille g8 = new Grille(3,3,false,t8);
		if (! g7.equals(g8)){
			fail("Grilles différentes\n"+g7.toString()+"\n \n"+g8.toString());
		}
	}
	
	@Test
	public void testIsPlein () {
		//avec contours
		Integer [] t = {1,1,1,1,1,1,1,1,1,1,1,1};
		Grille g = new Grille (3,3,true,t);
		if (!g.isPlein()){
			fail("La grille avec contours n'est pas pleine");
		}
		//sans contours
		Integer [] u = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		Grille g2 = new Grille (3,3,false,u);
		if (!g2.isPlein()){
			fail("La grille sans contours n'est pas pleine");
		}
	}
	
	@Test
	public void testPlacer () {
		Integer [] t = {1,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0};
		Grille g1 = new Grille(3,3,false,t);
		Grille g2 = new Grille(3,3,false);
		g2.placer(1,0);
		g2.placer(4, 1);
		g2.placer(2, 3);
		g2.placer(3, 6);
		if (!g1.equals(g2)){
			fail("batons mal placés \n"+g1.toString()+"\n \n"+g2.toString());
		}
	}
	
	@Test
	//dans testREmpliCarres, on teste à la fois rempliCarres et carreComplet qu'on ne peut pas tester directement (private)
	public void testRempliCarres () {
		Integer [] t = {0,0,1,0,0,0,0,1,0,0,0,0};
		Integer [] t2 = {1,0,1,0,0,1,0,1,0,0,1,0};
		Grille g1 = new Grille(3,3,true,t);
		Grille g2 = new Grille(3,3,true,t2);
		g1.RempliCarres();
		if (!g1.equals(g2)){
			fail("carrés du côté non remplis \n"+g1.toString());
		}
		Integer [] t3 = {0,0,0,0,0,0,0,0,1,0,0,1,1,0};
		Integer [] t4 = {0,0,0,0,0,0,0,0,1,0,0,1,1,0,0,1};
		Grille g3 = new Grille(3,3,false,t3);
		Grille g4 = new Grille(3,3,false,t4);
		g3.RempliCarres();
		if (!g3.equals(g4)){
			fail("carré du milieu non rempli \n"+g3.toString());
		}
		
	}

}

