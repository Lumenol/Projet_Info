package prototype;

public class Partie {
    public Partie() {
	Grille grille = new Grille(5);
	Joueur js[] = new Joueur[2];
	js[0] = new Humain();
	// js[0] = new Simplet();
	js[1] = new Simplet();
	int j = 0;
	while (!grille.isPlein()) {
	    System.out.println(grille);
	    if (!js[j].jouer(grille))
		j = (j + 1) % 2;
	    System.out.println("-----------------------------------");
	}
	System.out.println(grille);
	System.out.println("J1=" + js[0].points + "\tJ2=" + js[1].points);
    }
}
