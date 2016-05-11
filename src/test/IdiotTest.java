package test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import betaplusplus.Grille;
import betaplusplus.Idiot;
import betaplusplus.Prevoyant;

public class IdiotTest {

	@Test
	public void testGet() {
		//on perd 4 carrés
		Idiot id = new Idiot();
		int [] t = {0,0,0,1,0,0,0,1,0,0,1,0};
		Grille g = new Grille(3,3,true,t);
		int [] t2 = {1,1,1,1,1,1,0,1,0,0,1,0,0};
		Grille g2 = new Grille(3,3,true,t2);
		LinkedList<Grille> l = (LinkedList<Grille>) id.get(g);
		if (!l.contains(g2)){
			fail("L'état successeur n'est pas celui qui offre le plus de points, ce devrait être \n"+g2.toString()+"\n et pas : \n"+l.toString());
		}
		//on perd 3 carrés
		Idiot id2 = new Idiot();
		int [] t3 = {0,0,1,0,0,0,0,0,0,0,0,0};
		Grille g3 = new Grille(3,3,true,t3);
		int [] t4 = {1,0,1,0,0,1,0,1,0,0,1,0};
		Grille g4 = new Grille(3,3,true,t4);
		LinkedList<Grille> l2 = (LinkedList<Grille>) id2.get(g3);
		if (!l2.contains(g4)){
			fail("L'état successeur n'est pas celui qui offre le plus de points, ce devrait être \n"+g4.toString()+"\n et pas : \n"+l2.toString());
		}
		//on gagne 1 carré et on en perd 8
		Idiot id3 = new Idiot();
		int [] t5 = {0,0,0,1,0,1,1,0,0,0,0,0};
		Grille g5 = new Grille(3,3,true,t5);
		int [] t6 = {1,1,1,1,1,1,1,1,1,1,1,1};
		Grille g6 = new Grille(3,3,true,t6);
		LinkedList<Grille> l3 = (LinkedList<Grille>) id3.get(g5);
		if (!l3.contains(g6)){
			fail("L'état successeur n'est pas celui qui offre le plus de points, ce devrait être \n"+g6.toString()+"\n et pas : \n"+l3.toString());
		}
	}

}
