package betaplusplus;

import java.util.Arrays;

/**
 *
 * @author Julie
 *
 */
public class Grille implements Etat {
    final static int BLOQUE = 1;
    final static int JOUER = 2;
    final static int VIDE = 0;
    private int[][] grille;

    public Grille() {
	// TODO Auto-generated constructor stub
    }

    public Grille(Grille g) {
	this();
	grille = Arrays.copyOf(g.grille, g.grille.length);
	for (int i = 0; i < g.largeur(); i++) {
	    grille[i] = Arrays.copyOf(g.grille[i], g.grille[i].length);
	}
    }

    @Override
    public boolean equals(Object obj) {
	// TODO Auto-generated method stub
	return super.equals(obj);
    }

    public int get(int x, int y) {
	try {
	    return grille[x][y];
	} catch (ArrayIndexOutOfBoundsException e) {
	    return BLOQUE;
	}
    }

    public int hauteur() {
	return 0;

    }

    public boolean isPlein() {
	for (int i = 0; i < grille.length; i++) {
	    for (int j = 0; j < grille[i].length; j++) {
		if (get(i, j) == VIDE)
		    return false;
	    }
	}
	return true;
    }

    @Override
    public String label() {
	// TODO Auto-generated method stub
	return null;
    }

    public int largeur() {
	return 0;

    }

    public int placer(int x, int y) {
	return 0;
    }

    public void RempliCarres() {
	for (int i = 0; i < grille.length; i++) {
	    for (int j = 0; j < grille[i].length; j++) {
		if (CarreComplet(i, j)) {
		    placer(i, j);
		    RempliCarres();
		    return;
		}
	    }
	}
    }

    private boolean CarreComplet(int x, int y) {
	if (get(x, y) != VIDE) {
	    return false;
	}
	int[][] t;
	if (y % 2 == 0)
	    t = new int[][] { { -1, -1 }, { -2, 0 }, { -1, 1 } };
	else
	    t = new int[][] { { -1, -1 }, { 0, -2 }, { 1, -1 } };
	for (int s = -1; s <= 1; s += 2) {
	    boolean complet = true;
	    int i = 0;
	    while (complet && i < t.length) {
		complet = get(x + s * t[i][0], y + s * t[i][1]) == JOUER;
	    }
	    if (complet)
		return true;
	}
	return false;

    }

}
