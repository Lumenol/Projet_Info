package prototype;

public abstract class Joueur {
    int points;

    public Joueur() {
	super();
	points = 0;
    }

    public abstract boolean jouer(Grille g);
}
