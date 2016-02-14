package prototype;

public class Grille {
    public static final int VIDE = 0;
    public static final int BLOQUE = 1;
    public static final int JOUE = 2;

    public static int dimmentionGrille(int nbTraits) {
	int r = 0, n = 0;
	while ((r = r + 4 * n) < nbTraits) {
	    n++;
	}
	return n;
    }

    public static int nombreTraitGrille(int n) {
	return nombreTraitGrille(n, 0);
    }

    private static int nombreTraitGrille(int n, int r) {
	if (n == 0)
	    return r;
	else
	    return nombreTraitGrille(n - 1, r + 4 * n);
    }

    public int[][] grille;

    public Grille(int n) {
	this(n, false);
    }

    public Grille(int n, boolean contours) {
	grille = new int[2 * n + 1][2 * n + 1];
	for (int i = 0; i < grille.length; i++) {
	    for (int j = 0; j < grille.length; j++) {
		if ((j % 2 == 0) == (i % 2 == 0)) {
		    grille[i][j] = BLOQUE;
		} else {
		    if (contours && (i == 0 || i == grille.length - 1 || j == 0 || j == grille.length - 1))
			grille[i][j] = JOUE;
		    else
			grille[i][j] = VIDE;
		}
	    }
	}
    }

    public Grille(int[] tab) throws IllegalArgumentException {
	int n = dimmentionGrille(tab.length);
	grille = new int[2 * n + 1][2 * n + 1];
	int k = 0;
	for (int i = 0; i < grille.length; i++) {
	    for (int j = 0; j < grille.length; j++) {
		if ((j % 2 == 0) == (i % 2 == 0))
		    grille[i][j] = BLOQUE;
		else {
		    grille[i][j] = tab[k];
		    k++;
		}
	    }
	}
    }

    public boolean isPlein() {
	for (int i = 0; i < grille.length; i++) {
	    for (int j = 0; j < grille.length; j++) {
		if (grille[i][j] == VIDE) {
		    return false;
		}
	    }
	}
	return true;
    }

    public int nombreCarreComplets(int y, int x) {
	int[][] p;
	if (y % 2 == 0)
	    p = new int[][] { { -1, -1 }, { -2, 0 }, { -1, 1 } };
	else
	    p = new int[][] { { -1, -1 }, { 0, -2 }, { 1, -1 } };
	int carre = 0;
	int i;
	boolean complet;
	for (int s = -1; s <= 1; s += 2) {
	    complet = true;
	    i = 0;
	    while (complet && i < p.length) {
		int y_ = y + s * p[i][0];
		int x_ = x + s * p[i][1];
		complet = y_ >= 0 && y_ < grille.length && x_ >= 0 && x_ < grille.length;
		if (complet)
		    complet = grille[y_][x_] == JOUE;
		i++;
	    }
	    if (complet)
		carre++;
	}
	return carre;
    }

    public boolean placer(int y, int x) {
	if (y >= 0 && y < grille.length && x >= 0 && x < grille.length)
	    if (grille[y][x] == VIDE) {
		grille[y][x] = JOUE;
		return true;
	    }
	return false;
    }

    @Override

    public String toString() {
	return toString(false);
    }

    public String toString(boolean dot) {
	StringBuffer sb = new StringBuffer();
	for (int i = 0; i < grille.length; i++) {
	    for (int j = 0; j < grille.length; j++) {
		switch (grille[i][j]) {
		case VIDE:
		    sb.append(" ");
		    break;
		case BLOQUE:
		    if (i % 2 == 0)
			sb.append("*");
		    else
			sb.append(" ");
		    break;

		case JOUE:
		    if (i % 2 == 0)
			sb.append("-");
		    else
			sb.append("|");
		    break;
		}
	    }
	    sb.append(dot ? "\\n" : "\n");
	}
	return sb.toString();
    }

}
