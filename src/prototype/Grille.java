package prototype;

public class Grille {
    public int[][] grille;

    public Grille(int n) {
	grille = new int[2 * n + 1][2 * n + 1];
	for (int i = 0; i < grille.length; i++) {
	    for (int j = 0; j < grille.length; j++) {
		if ((j % 2 == 0) == (i % 2 == 0)) {
		    grille[i][j] = -1;
		} else {
		    grille[i][j] = 0;
		}
	    }
	}
    }

    public int carreComplete(int x, int y) {
	int c = 0;
	int[][] p = { { -1, -1 }, { 0, -2 }, { 1, -1 } };
	if (y % 2 == 0) {
	    boolean b = true;
	    for (int i = 0; i < p.length && b; i++) {
		int x_ = x + p[i][0];
		int y_ = y + p[i][1];
		if (x_ >= 0 && x_ < grille.length && y_ >= 0 && y_ < grille.length) {
		    b = grille[y_][x_] != 0;
		}
	    }
	    c += b ? 1 : 0;
	    b = true;
	    for (int i = 0; i < p.length && b; i++) {
		int x_ = x - p[i][0];
		int y_ = y - p[i][1];
		if (x_ >= 0 && x_ < grille.length && y_ >= 0 && y_ < grille.length) {
		    b = grille[y_][x_] != 0;
		}
	    }
	    c += b ? 1 : 0;
	} else {
	    boolean b = true;
	    for (int i = 0; i < p.length && b; i++) {
		int x_ = x + p[i][1];
		int y_ = y + p[i][0];
		if (x_ >= 0 && x_ < grille.length && y_ >= 0 && y_ < grille.length) {
		    b = grille[y_][x_] != 0;
		}
	    }
	    c += b ? 1 : 0;
	    b = true;
	    for (int i = 0; i < p.length && b; i++) {
		int x_ = x - p[i][1];
		int y_ = y - p[i][0];
		if (x_ >= 0 && x_ < grille.length && y_ >= 0 && y_ < grille.length) {
		    b = grille[y_][x_] != 0;
		}
	    }
	    c += b ? 1 : 0;
	}
	return c;
    }

    public boolean isPlein() {
	for (int i = 0; i < grille.length; i++) {
	    for (int j = 0; j < grille.length; j++) {
		if (grille[i][j] == 0) {
		    return false;
		}
	    }
	}
	return true;
    }

    @Override
    public String toString() {
	StringBuffer b = new StringBuffer();
	for (int i = 0; i < grille.length; i++) {
	    for (int j = 0; j < grille.length; j++) {
		switch (grille[i][j]) {
		case -1:
		    b.append("*");
		    break;
		case 0:
		    b.append(" ");
		    break;
		default:
		    b.append(grille[i][j]);
		}
	    }
	    b.append("\n");
	}
	return b.toString();

    }
}
