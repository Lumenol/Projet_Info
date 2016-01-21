package prototype;

public abstract class AbstractJoueur {
    int numero;

    public AbstractJoueur(int numero) {
	super();
	this.numero = numero;
    }

    public abstract void jouer(Grille g);
}
