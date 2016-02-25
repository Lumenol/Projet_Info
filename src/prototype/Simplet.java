package prototype;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.SortedMap;

public class Simplet extends Joueur {
    public Simplet() {
	super();
	// TODO Auto-generated constructor stub
    }

    @Override
    public boolean jouer(Grille g) {
	Random rand = new Random();
	boolean jouer = false;
	int x = 0, y = 0;
	while (!jouer) {
	    x = rand.nextInt(g.grille.length);
	    y = rand.nextInt(g.grille.length);
	    jouer = g.placer(y, x);
	}
	int c = g.nombreCarreComplets(y, x);
	points += c;
	return c >= 1;
    }

    @Override
    public boolean jouer(prototype.V2.Grille g) {
	Random rand = new Random();
	boolean jouer = false;
	int x = 0, y = 0;
	Point p;
	SortedMap<Integer, ArrayList<Point>> jouable = g.jouable();
	do {
	    x = rand.nextInt(jouable.size());
	    Iterator<Entry<Integer, ArrayList<Point>>> iterator = jouable.entrySet().iterator();
	    Entry<Integer, ArrayList<Point>> next = null;
	    for (int i = 0; i <= x; i++) {
		next = iterator.next();
	    }
	    y = rand.nextInt(next.getValue().size());
	    p = next.getValue().get(y);
	} while (!g.isJouable(p));
	int c = g.jouer(p);
	points += c;
	return c >= 1;
    }

}
