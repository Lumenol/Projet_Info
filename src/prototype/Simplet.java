package prototype;

import java.util.Random;

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

}
