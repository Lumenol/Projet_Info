package prototype;

import java.util.Random;

public class JoueurSimplet extends AbstractJoueur {
    public JoueurSimplet(int numero) {
	super(numero);
	// TODO Auto-generated constructor stub
    }

    @Override
    public void jouer(Grille g) {
	Random rand = new Random();
	boolean jouer = false;
	while (!jouer) {
	    int x = rand.nextInt(g.grille.length);
	    int y = rand.nextInt(g.grille.length);
	    if (g.grille[x][y] == 0) {
		jouer = true;
		g.grille[x][y] = numero;
	    }
	}
    }

}
