package test;

import static org.junit.Assert.*;

import org.junit.Test;

import betaplusplus.Grille;
import betaplusplus.NombreCarre;

public class NombreCarreTest {

	@Test
	public void testNombreCarre() {
		//grille avec contours, vide
		Grille g = new Grille(3,3,true);
		NombreCarre n = new NombreCarre();
		if (n.get(g) != 0){
			fail("Nombre de carrés non nul");
		}
		//grille avec contours, 1 carré dans l'angle
		int [] t1 = {1,0,1};
		Grille g1 = new Grille(3,3,true,t1);
		NombreCarre n1 = new NombreCarre();
		if (n1.get(g1) != 1){
			fail("Nombre de carrés devrait valoir 1 mais vaut " + n1.get(g1)+"\n"+g1.toString());
		}
		//grille avec contours, tous les carrés pleins (9)
		int [] t2 = {1,1,1,1,1,1,1,1,1,1,1,1};
		Grille g2 = new Grille(3,3,true,t2);
		NombreCarre n2 = new NombreCarre();
		if (n2.get(g2) != 9){
			fail("Nombre de carrés devrait valoir 9 mais vaut " + n2.get(g2)+"\n"+g2.toString());
		}
		//grille avec contours, 1 carré au milieu
		int [] t3 = {0,0,0,1,0,1,1,0,1,0,0,0};
		Grille g3 = new Grille(3,3,true,t3);
		NombreCarre n3 = new NombreCarre();
		if (n3.get(g3) != 1){
			fail("Nombre de carrés devrait valoir 1 mais vaut " + n3.get(g3)+"\n"+g3.toString());
		}
		//grille sans contours, 1 carré dans l'angle
		int [] t4 = {1,0,0,1,1,0,0,1,0};
		Grille g4 = new Grille(3,3,false,t4);
		NombreCarre n4 = new NombreCarre();
		if (n4.get(g4) != 1){
			fail("Nombre de carrés devrait valoir 1 mais vaut " + n4.get(g4)+"\n"+g4.toString());
		}
		//grille sans coutours, 2 carrés, bord + milieu
		int [] t5 = {0,0,0,0,0,0,0,1,1,0,1,1,1,0,1,1,0};
		Grille g5 = new Grille(3,3,false,t5);
		NombreCarre n5 = new NombreCarre();
		if (n5.get(g5) != 2){
			fail("Nombre de carrés devrait valoir 2 mais vaut " + n5.get(g5)+"\n"+g5.toString());
		}
	}

}
