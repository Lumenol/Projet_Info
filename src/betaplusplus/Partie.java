package betaplusplus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Partie {

    private ArrayList<Fonction<Grille, Iterable<Grille>>> joueurs;
    private ArrayList<Integer> points;
    private NombreCarre nbC;

    private Grille racine;

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

    public Integer getPoints(int j) {
	try {
	    return points.get(j);
	} catch (Exception e) {
	    return null;
	}
    }

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
