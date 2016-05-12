package test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.LinkedList;

import org.junit.Test;

import betaplusplus.Grille;
import betaplusplus.Poids;
import betaplusplus.Pondere;

public class PondereTest {

	@Test
	public void testGet() throws NumberFormatException, FileNotFoundException {
		Pondere p = new Pondere(new Poids("./autre/C3x3.pip"));
		Grille g = new Grille(3,3,true);
		Integer [] t2= {0,0,0,1};
		Grille g2 = new Grille(3,3,true,t2);
		LinkedList<Grille> l = (LinkedList<Grille>) p.get(g);
		if(! l.contains(g2)){
			fail("Le 1er successeur de pondere est erroné");
		}
		Integer [] t3 = {0,0,0,1,0,0,0,1,0,0,1};
		Grille g3 = new Grille(3,3,true,t3);
		LinkedList<Grille> l2 = (LinkedList<Grille>) p.get(g2);
		if(! l2.contains(g3)){
			fail("Le second successeur de pondere est erroné"+g3.toString());
		}
		Integer [] t4 = {1,1,1,1,1,1,0,1,0,0,1};
		Grille g4 = new Grille(3,3,true,t4);
		LinkedList<Grille> l3 = (LinkedList<Grille>) p.get(g3);
		if(! l3.contains(g4)){
			fail("Le troisieme successeur de pondere est erroné"+g4.toString());
		}
		Integer [] t5 = {1,1,1,1,1,1,1,1,1,1,1,1};
		Grille g5 = new Grille(3,3,true,t5);
		LinkedList<Grille> l4 = (LinkedList<Grille>) p.get(g4);
		if(! l4.contains(g5)){
			fail("Le dernier successeur de pondere est erroné"+g5.toString());
		}
	}

}
