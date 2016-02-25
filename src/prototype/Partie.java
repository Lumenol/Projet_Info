package prototype;

public class Partie {
    public Partie() {
	prototype.V2.Grille grille = new prototype.V2.Grille(3, true);
	Joueur js[] = new Joueur[2];
	// js[0] = new Humain();
	js[1] = new JoueurCarre();
	js[0] = new JoueurPoids("autre/C3x3.pip");
	// js[1] = new Simplet();
	int j = 0;
	while (!grille.isComplet()) {
	    // System.out.println((char) Event.ESCAPE + "c" + grille);
	    System.out.println(j);
	    System.out.println(grille);
	    if (!js[j].jouer(grille))
		j = (j + 1) % 2;
	}
	System.out.println(grille);
	System.out.println("J1=" + js[0].points + "\tJ2=" + js[1].points);
    }
}
