package prototype.graphe;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import prototype.Grille;

public class Config implements Sommet {

    private static int num = 0;

    Set<Sommet> fils = new HashSet<Sommet>();

    Grille grille;
    int[] tableau;
    int nom;

    public Config(int[] tab) {
	nom = num++;
	tableau = Arrays.copyOf(tab, tab.length);
	grille = new Grille(tab);
    }

    @Override
    public void addFil(Sommet s) {
	fils.add(s);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Config other = (Config) obj;
	return rotation(other);
    }

    public int[] getTableau() {
	return tableau;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + Arrays.hashCode(tableau);
	return result;
    }

    @Override
    public Iterator<Sommet> iterator() {
	return fils.iterator();
    }

    @Override
    public String nom() {
	return Integer.toString(nom);
    }

    @Override
    public String toDot() {
	StringBuffer sb = new StringBuffer(nom() + " [label=\"" + grille.toString(true) + "\"]\n");
	for (Iterator iterator = fils.iterator(); iterator.hasNext();) {
	    Sommet sommet = (Sommet) iterator.next();
	    sb.append(nom() + " -> " + sommet.nom() + "\n");
	}
	return sb.toString();
    }

    private boolean rotation(Config c) {
	int[][] t1 = grille.grille;
	int[][] t2 = new int[t1.length][t1.length];

	for (int x = 0; x < 4; x++) {
	    for (int i = 0; i < t1.length; i++) {
		for (int j = 0; j < t1.length; j++) {
		    t2[j][t1.length - 1 - i] = t1[i][j];
		}
	    }
	    if (Arrays.deepEquals(t2, c.grille.grille)) {
		return true;
	    }
	    if (symetrique(t2, c.grille.grille))
		return true;
	    t1 = t2;
	    t2 = new int[t1.length][t1.length];
	}
	return false;
    }

    private boolean symetrique(Config c) {
	return symetrique(grille.grille, c.grille.grille);
    }

    private boolean symetrique(int[][] t1, int[][] c) {
	// droite gauche
	int[][] t2 = new int[t1.length][t1.length];
	for (int i = 0; i < t1.length; i++) {
	    for (int j = 0; j < t1.length; j++) {
		t2[i][j] = t1[i][t1.length - 1 - j];
	    }
	}
	if (Arrays.deepEquals(t2, c))
	    return true;
	// haut bas
	for (int i = 0; i < t1.length; i++) {
	    for (int j = 0; j < t1.length; j++) {
		t2[i][j] = t1[t1.length - 1 - i][j];
	    }
	}
	if (Arrays.deepEquals(t2, c))
	    return true;

	return false;

    }

}
