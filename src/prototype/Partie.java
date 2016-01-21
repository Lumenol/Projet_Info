package prototype;

public class Partie {
    public static void main(String argv[]) {
	Grille grille = new Grille(3);
	AbstractJoueur js[] = new AbstractJoueur[2];
	// js[0] = new Joueur(1);
	js[0] = new JoueurSimplet(1);
	js[1] = new JoueurSimplet(2);
	int j = 0;
	while (!grille.isPlein()) {
	    System.out.println(grille);
	    js[j].jouer(grille);
	    j = (j + 1) % 2;
	}
	System.out.println(grille);
    }
}
