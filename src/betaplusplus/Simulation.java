package betaplusplus;

public class Simulation {
    public static float simulation(int hauteur, int largeur, boolean contours, int n,
	    Fonction<Grille, Iterable<Grille>> j1, Fonction<Grille, Iterable<Grille>> j2) {
	Partie p = new Partie(hauteur, largeur, contours, j1, j2);
	float somme = 0;
	for (int i = 0; i < n; i++) {
	    p.nouvellePartie(false);
	    somme += p.getPoints(0);
	}
	return somme / n;

    }
}
