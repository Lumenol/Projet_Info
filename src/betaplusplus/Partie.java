package betaplusplus;

import java.util.Iterator;

public interface Partie<T> {

	public void ajouterJoueur(Fonction<T, Iterator<T>> j);

	public Fonction vainqueur(); // penser � modifier pour "qui perd gagne"

	public void nouvellePartie();

}
