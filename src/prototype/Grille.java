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
