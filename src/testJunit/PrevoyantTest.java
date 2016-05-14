package testJunit;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import pipopipette.Grille;
import pipopipette.Prevoyant;

public class PrevoyantTest {

	@Test
	public void testGet() {
		//coup optimal : gagne 1 carré et n'en perd pas 
		Prevoyant pre = new Prevoyant();
		Integer [] t = {1};
		Grille g = new Grille(3,3,true,t);
		Integer [] t2 = {1,0,1};
		Grille g2 = new Grille(3,3,true,t2);
		LinkedList<Grille> l = (LinkedList<Grille>) pre.get(g);
		if (!l.contains(g2)){
			fail("Successeur de g non optimal");
		}
		//coup otimal : gagne 1 carré et en perd 0
		Prevoyant pre2 = new Prevoyant();
		Integer [] t3 = {0,0,0,1,0,0,0,0,0,0,1,0};
		Grille g3 = new Grille(3,3,true,t3);
		Integer [] t4 = {0,0,0,1,0,0,1,1,0,0,1,0};
		Grille g4 = new Grille(3,3,true,t4);
		LinkedList<Grille> l2 = (LinkedList<Grille>) pre2.get(g3);
		if (!l2.contains(g4)){
			fail("Successeur de g3 non optimal");
		}
		//gagne 8 carrés et n'en perd pas
		Prevoyant pre3 = new Prevoyant();
		Integer [] t5 = {0,0,1,1,0,0,1,1,0,0,1,0};
		Grille g5 = new Grille(3,3,true,t5);
		Integer [] t6 = {1,1,1,1,1,1,1,1,1,1,1,1};
		Grille g6 = new Grille(3,3,true,t6);
		LinkedList<Grille> l3 = (LinkedList<Grille>) pre3.get(g5);
		if (!l3.contains(g6)){
			fail("Successeur non optimal, la grille devrait être complête");
		}
		//gagne 3 carrés et n'en perd aucun
		Prevoyant pre4 = new Prevoyant();
		Integer [] t7 = {0,0,1,0,0,0,0,1,0,0,0,0};
		Grille g7 = new Grille(3,3,true,t7);
		Integer [] t8 = {1,0,1,0,0,1,1,1,0,0,1,0};
		Grille g8 = new Grille(3,3,true,t8);
		LinkedList<Grille> l4 = (LinkedList<Grille>) pre4.get(g7);
		if (!l4.contains(g8)){
			fail("Successeur de g7 non optimal");
		}
	}

}
