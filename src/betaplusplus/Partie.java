package betaplusplus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 *
 */
public class Partie {

    private ArrayList<Fonction<Grille, Iterable<Grille>>> joueurs;
    private ArrayList<Integer> points;
    private NombreCarre nbC;

    private Grille racine;

    /**
     * Constructeur de l'objet Partie
     *
     * @param hauteur
     *            hauteur de la grille
     * @param largeur
     *            largeur de la grille
     * @param contours
     * @param j1
     *            Joueur 1
     * @param j2
     *            Joueur 2
     */
    public Partie(int hauteur, int largeur, boolean contours, Fonction<Grille, Iterable<Grille>> j1,
	    Fonction<Grille, Iterable<Grille>> j2) {
	this.racine = new Grille(hauteur, largeur, contours);
	this.nbC = new NombreCarre();
	this.joueurs = new ArrayList<>(2);
	joueurs.add(j1);
	joueurs.add(j2);
	points = new ArrayList<>(2);
	points.add(0);
	points.add(0);
    }

    /**
     * @param j
     *            Joueur
     * @return Le nombre de points attribues au joueur j
     */
    public Integer getPoints(int j) {
	try {
	    return points.get(j);
	} catch (Exception e) {
	    return null;
	}
    }

    /**
     * Lanceur de la partie de jeu
     *
     * @param bavard
     *            Parametre qui enclenche l'impression des etapes successives de
     *            la partie
     */
    public void nouvellePartie(boolean bavard) {
	points.set(0, 0);
	points.set(1, 0);
	Grille etape = racine;
	int j = 0;
	int nbc;
	Random random = new Random();
	while (!etape.isPlein()) {
	    if (bavard) {
		// imodifier selon pour avoir un beau truc
		System.out.println("A vous de jouer");
		System.out.println(etape);
	    }
	    Iterable<Grille> it = joueurs.get(j).get(etape);
	    ArrayList<Grille> suivants = new ArrayList<>();
	    for (Iterator<Grille> iterator = it.iterator(); iterator.hasNext();) {
		Grille e = iterator.next();
		suivants.add(e);
	    }
	    nbc = nbC.get(etape);
	    etape = suivants.get(random.nextInt(suivants.size()));
	    j = (j + 1) % joueurs.size();
	    points.set(j, points.get(j) + nbC.get(etape) - nbc);
	}
    }

}
