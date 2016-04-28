package betaplusplus;

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
	return false;
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

    }

    private boolean CarreComplet(int x, int y) {
	return true;
    }

}
