package test;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import betaplusplus.Grille;
import betaplusplus.Simplet;
import sun.launcher.resources.launcher;

public class SimpletTest {

	@Test
	public void test() {
		//successeurs d'une grille vide avec contours
		Simplet simplet = new Simplet();
		Grille g = new Grille(3,3,true);
		int [] t2 = {1};
		int [] t3 = {0,0,0,1,0};
		Grille g2 = new Grille(3,3,true,t2);
		Grille g3 = new Grille(3,3,true,t3);
		HashSet<Grille> l = (HashSet<Grille>) simplet.get(g);
		if ((! l.contains(g2)) && (! l.contains(g3))){
			fail("les successeurs sont faux \n"+l.toString());
		}
		//successeurs d'une grille vide sans contours
		Simplet simpletv = new Simplet();
		Grille gv = new Grille(3,3,false);
		int [] tv2 = {1};
		int [] tv3 = {0,1};
		int [] tv4 = {0,0,0,0,1};
		int [] tv5 = {0,0,0,0,0,0,0,0,1};
		Grille gv2 = new Grille(3,3,false,tv2);
		Grille gv3 = new Grille(3,3,false,tv3);
		Grille gv4 = new Grille(3,3,false,tv4);
		Grille gv5 = new Grille(3,3,false,tv5);
		HashSet<Grille> lv = (HashSet<Grille>) simpletv.get(gv);
		if ((! lv.contains(gv2)) && (! lv.contains(gv3)) && (! lv.contains(gv4)) && (!lv.contains(gv5))){
			fail("les successeurs sont faux \n"+lv.toString());
		}
		//successeurs d'une grille avec 2 batons
		Simplet simplet2 = new Simplet();
		int [] t4 = {0,0,0,0,0,1,1};
		Grille g4 = new Grille(3,3,true,t4);
		int [] t5 = {0,0,0,1,0,1,1,0,1,0};
		int [] t6 = {1,0,1,0,0,1,1,1,0,0,1,0};
		Grille g5 = new Grille(3,3,true,t5);
		Grille g6 = new Grille(3,3,true,t6);
		HashSet<Grille> l2 = (HashSet<Grille>) simplet2.get(g4);
		if ((! l2.contains(g5)) && (! l.contains(g6))){
			fail("les successeurs sont faux \n"+l2.toString());
		}
		//le successeur est la grille pleine
		Simplet simplet3 = new Simplet();
		int [] t7 = {0,0,0,1,0,1,1,0,0,0,0,0};
		int [] t8 = {1,1,1,1,1,1,1,1,1,1,1,1};
		Grille g7 = new Grille(3,3,true,t7);
		Grille g8 = new Grille(3,3,true,t8);
		HashSet<Grille> l3 = (HashSet<Grille>) simplet3.get(g7);
		if (! l3.contains(g8)){
			fail("les successeurs sont faux, la grille doit être pleine \n"+l3.toString());
		}
	}

}
