package prototype;

public abstract class Joueur {
    int points;

    public Joueur() {
	super();
	points = 0;
    }

    public abstract boolean jouer(Grille g);

    public abstract boolean jouer(prototype.V2.Grille g);
}
