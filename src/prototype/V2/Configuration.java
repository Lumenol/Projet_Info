package prototype.V2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import prototype.graphe.Sommet;

public class Configuration extends Grille implements Sommet {

    private static int num = 0;
    HashMap<Sommet, Integer> fils = new HashMap<Sommet, Integer>();
    int nom;

    public int V;

    public Configuration(Grille g) {
	nom = num++;
	grille = g.getGrille();
    }

    public Configuration(int dimension) {
	this(dimension, true);
	// TODO Auto-generated constructor stub
    }

    public Configuration(int dimension, boolean contoure) {
	this(dimension, dimension, contoure);
	// TODO Auto-generated constructor stub
    }

    public Configuration(int hauteur, int largeur) {
	this(hauteur, largeur, true);
	// TODO Auto-generated constructor stub
    }

    public Configuration(int hauteur, int largeur, boolean contoure) {
	super(hauteur, largeur, contoure);
	nom = num++;
	V = 0;
	// TODO Auto-generated constructor stub
    }

    public Configuration(int hauteur, int largeur, boolean contoure, Integer[] t, int p) {
	super(hauteur, largeur, contoure, t);
	V = p;
    }

    @Override
    public void addFil(Sommet s) {
	Integer r = fils.get(s);
	if (r == null)
	    fils.put(s, 1);
	else
	    fils.put(s, r + 1);

    }

    @Override
    public boolean equals(Object obj) {
	// TODO Auto-generated method stub
	if (super.equals(obj))
	    return true;
	return isSimilaire((Configuration) obj);
    }

    public ArrayList<Configuration> filsPoidsMin() {

	int min = ((Configuration) Collections.min(fils.keySet(), new Comparator<Sommet>() {

	    @Override
	    public int compare(Sommet o1, Sommet o2) {

		return Integer.compare(((Configuration) o1).V, ((Configuration) o2).V);
	    }

	})).V;
	ArrayList<Configuration> r = new ArrayList<>();
	for (Iterator iterator = fils.keySet().iterator(); iterator.hasNext();) {
	    Configuration configuration = (Configuration) iterator.next();
	    if (configuration.V == min) {
		r.add(configuration);
	    }
	}

	return r;

    }

    @Override
    public Iterator<Sommet> iterator() {
	return fils.keySet().iterator();
    }

    @Override
    public String nom() {
	return Integer.toString(nom);
    }

    public String toDot() {
	StringBuffer sb = new StringBuffer(nom() + " [label=\"V=" + V + "\\n" + super.toDot() + "\"]\n");
	for (Iterator iterator = fils.entrySet().iterator(); iterator.hasNext();) {
	    Entry sommet = (Entry) iterator.next();
	    sb.append(nom() + " -> " + ((Sommet) sommet.getKey()).nom() + " [taillabel=\"" + sommet.getValue() + "\"]"
		    + "\n");
	}
	return sb.toString();
    }

    private boolean isSimilaire(Configuration c) {
	int[][] r = getGrille();
	for (int i = 0; i < 4; i++) {
	    if (Arrays.deepEquals(r, c.grille))
		return true;
	    if (isSymetrique(r, c.grille))
		return true;
	    r = rotation(r);
	}
	return false;
    }

    private boolean isSymetrique(int[][] t1, int[][] c) {
	// droite gauche
	int[][] t2 = new int[t1.length][t1[0].length];
	for (int i = 0; i < t1.length; i++) {
	    for (int j = 0; j < t1[0].length; j++) {
		t2[i][j] = t1[i][t1[0].length - 1 - j];
	    }
	}
	if (Arrays.deepEquals(t2, c))
	    return true;
	// haut bas
	for (int i = 0; i < t1.length; i++) {
	    for (int j = 0; j < t1[0].length; j++) {
		t2[i][j] = t1[t1.length - 1 - i][j];
	    }
	}
	if (Arrays.deepEquals(t2, c))
	    return true;

	return false;

    }

    private int[][] rotation(int[][] t) {
	int[][] r = new int[t[0].length][t.length];
	for (int i = 0; i < r.length; i++) {
	    for (int j = 0; j < r[i].length; j++) {
		r[i][j] = t[j][r.length - 1 - i];
	    }
	}
	return r;
    }

}
