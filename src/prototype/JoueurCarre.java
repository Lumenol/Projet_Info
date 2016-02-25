package prototype;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.SortedMap;

import prototype.V2.Grille;

public class JoueurCarre extends Joueur {

    @Override
    public boolean jouer(Grille g) {
	Random rand = new Random();
	SortedMap<Integer, ArrayList<Point>> jouable = g.jouable();
	ArrayList<Point> arrayList = jouable.get(jouable.lastKey());
	int c = g.jouer(arrayList.get(rand.nextInt(arrayList.size())));
	points += c;
	return c >= 1;
    }

    @Override
    public boolean jouer(prototype.Grille g) {
	return false;
    }

}
