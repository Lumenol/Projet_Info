package test;

import betaplusplus.Grille;
import betaplusplus.Simplet;
import betaplusplus.ToDot;

/**
 * Created by crede on 30/04/2016.
 */
public class testDot {

	public static void main(String[] args) {
		Simplet simplet = new Simplet();
		ToDot dot = new ToDot(simplet);
		System.out.println(dot.get(new Grille(3, 3, true)));
	}

}
