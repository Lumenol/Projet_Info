package prototype;

public class Partie {
    public Partie() {
	Grille grille = new Grille(5);
	AbstractJoueur js[] = new AbstractJoueur[2];
	js[0] = new Joueur(1);
	 js[0] = new JoueurSimplet(1);
	//js[1] = new JoueurSimplet(2);
	int j = 0;
	while (!grille.isPlein()) {
	    System.out.println(grille);
	    js[j].jouer(grille);
	    j = (j + 1) % 2;
	}
	System.out.println(grille);
    }
}
