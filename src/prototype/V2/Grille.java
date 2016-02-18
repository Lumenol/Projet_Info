package prototype.V2;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

public class Grille {
    private class SortedMapOfList<K, V> {
	private SortedMap<K, ArrayList<V>> map = new TreeMap<K, ArrayList<V>>();

	public void add(K key, V value) {
	    ArrayList<V> val = map.get(key);
	    if (val == null) {
		val = new ArrayList<V>();
		map.put(key, val);
	    }
	    val.add(value);
	}

    }

    public static final int VIDE = 0;
    public static final int BLOQUE = 1;

    public static final int JOUE = 2;

    protected int[][] grille;

    public Grille(int dimension) {
	this(dimension, true);
    }

    public Grille(int dimension, boolean contoure) {
	this(dimension, dimension, contoure);
    }

    public Grille(int hauteur, int largeur) {
	this(hauteur, largeur, true);
    }

    public Grille(int hauteur, int largeur, boolean contoure) {
	hauteur = hauteur <= 0 ? 1 : hauteur;
	largeur = largeur <= 0 ? 1 : largeur;
	grille = new int[2 * hauteur + 1][2 * largeur + 1];
	for (int i = 0; i < grille.length; i++) {
	    for (int j = 0; j < grille[0].length; j++) {
		if ((j % 2 == 0) == (i % 2 == 0)) {
		    grille[i][j] = BLOQUE;
		} else {
		    if (contoure && (i == 0 || i == grille.length - 1 || j == 0 || j == grille[0].length - 1))
			grille[i][j] = JOUE;
		    else
			grille[i][j] = VIDE;
		}
	    }
	}
    }

    protected Grille() {
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Grille other = (Grille) obj;
	if (!Arrays.deepEquals(grille, other.grille))
	    return false;
	return true;
    }

    public int[][] getGrille() {
	int[][] r = new int[grille.length][];
	for (int i = 0; i < r.length; i++) {
	    r[i] = Arrays.copyOf(grille[i], grille[i].length);
	}
	return r;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + Arrays.deepHashCode(grille);
	return result;
    }

    public boolean isComplet() {
	return jouable().size() == 0;
    }

    public boolean isJouable(Point p) {
	if (p.getX() < 0 || p.getX() >= grille[0].length || p.getY() < 0 || p.getY() >= grille.length)
	    return false;
	return grille[(int) p.getY()][(int) p.getX()] == VIDE;
    }

    public SortedMap<Integer, ArrayList<Point>> jouable() {
	SortedMapOfList<Integer, Point> points = new SortedMapOfList<Integer, Point>();
	for (int i = 0; i < grille.length; i++) {
	    for (int j = 0; j < grille[0].length; j++) {
		Point coordonne = new Point(j, i);
		int p = nombreCarreComplets(coordonne);
		if (p != -1)
		    points.add(p, coordonne);
	    }
	}
	return points.map;
    }

    public int jouer(Point p) {
	if (!isJouable(p))
	    return -1;
	int points = nombreCarreComplets(p);
	grille[(int) p.getY()][(int) p.getX()] = JOUE;
	return points;
    }

    public int nombreCarreComplets(Point p) {
	if (!isJouable(p))
	    return -1;
	int[][] t;
	if (p.getY() % 2 == 0)
	    t = new int[][] { { -1, -1 }, { -2, 0 }, { -1, 1 } };
	else
	    t = new int[][] { { -1, -1 }, { 0, -2 }, { 1, -1 } };
	int carre = 0;
	for (int s = -1; s <= 1; s += 2) {
	    boolean complet = true;
	    int i = 0;
	    while (complet && i < t.length) {
		int y = (int) (p.getY() + s * t[i][0]);
		int x = (int) (p.getX() + s * t[i][1]);

		if (y >= 0 && y < grille.length && x >= 0 && x < grille.length)
		    complet = grille[y][x] == JOUE;
		else
		    complet = false;
		i++;
	    }
	    if (complet)
		carre++;
	}
	return carre;
    }

    public String toDot() {
	return toString(true);
    }

    public String toString() {
	return toString(false);
    }

    private String toString(boolean toDot) {
	StringBuffer sb = new StringBuffer();
	for (int i = 0; i < grille.length; i++) {
	    for (int j = 0; j < grille[0].length; j++) {
		switch (grille[i][j]) {
		case VIDE:
		    sb.append(" ");
		    break;
		case BLOQUE:
		    if (i % 2 == 0)
			sb.append(".");
		    else
			sb.append(" ");
		    break;

		case JOUE:
		    if (i % 2 == 0)
			sb.append("-");
		    else
			sb.append("|");
		    break;
		}
	    }
	    sb.append(toDot ? "\\n" : "\n");
	}
	return sb.toString();
    }

}
