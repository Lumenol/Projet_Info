package prototype.V2;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;

import prototype.graphe.Graphe;
import prototype.graphe.Sommet;

public class Graph implements Graphe {

    List<Sommet> sommet;
    int hauteur, largeur;
    boolean bord;

    public Graph(int h, int l, boolean contoure) {
	hauteur = h;
	largeur = l;
	bord = contoure;
	sommet = new LinkedList<Sommet>();
	Configuration racine = new Configuration(h, l, contoure);
	// System.out.println(racine.nom());
	sommet.add(racine);
	generer(racine);
    }

    @Override
    public boolean addSommet(Sommet s, Sommet pere) {
	// System.out.println(s);
	// System.out.println(pere.nom());
	// System.out.println(pere);
	Iterator<Sommet> it = sommet.iterator();
	while (it.hasNext()) {
	    Sommet s1 = it.next();
	    if (s.equals(s1)) {
		pere.addFil(s1);
		return false;
	    }
	}
	// System.out.println(s.nom());
	return sommet.add(s);
    }

    @Override
    public Iterator<Sommet> iterator() {
	return sommet.iterator();
    }

    @Override
    public String toDot() {
	StringBuffer sb = new StringBuffer("digraph default{");
	sb.append("graph[labelloc=\"t\" fontsize=16 fontcolor=\"blue\"\n");
	sb.append("label=\"Graphe " + hauteur + "x" + largeur + " " + (bord ? "avec" : "sans") + " bord\"]\n\n");
	sb.append("node [shape=box fontname = \"Courier New\" color=\"sienna\"]\n");
	sb.append("edge [fontname = \"Times\" fontcolor=\"sienna\"]\n\n");
	for (Iterator iterator = sommet.iterator(); iterator.hasNext();) {
	    Sommet sommet2 = (Sommet) iterator.next();
	    sb.append(sommet2.toDot() + "\n");
	}
	sb.append("}");
	return sb.toString();
    }

    private void generer(Configuration s) {
	Configuration s1 = new Configuration(s);
	// System.out.println(s1);
	if (!s1.isComplet()) {
	    SortedMap<Integer, ArrayList<Point>> jouable = s1.jouable();
	    ArrayList<Point> points = jouable.get(jouable.lastKey());

	    for (Iterator iterator = points.iterator(); iterator.hasNext();) {
		Point point = (Point) iterator.next();
		int[][] h = s1.getGrille();
		s1.jouer(point);
		Configuration s2 = new Configuration(s1);
		jouer(s2);
		if (addSommet(s2, s)) {
		    s.addFil(s2);
		    generer(s2);
		}
		s1.grille = h;
	    }
	}

    }

    private void jouer(Configuration c) {
	int point = 1;
	while (point > 0 && !c.isComplet()) {

	    SortedMap<Integer, ArrayList<Point>> jouable = c.jouable();
	    if (jouable.lastKey() >= 1) {
		ArrayList<Point> points = jouable.get(jouable.lastKey());
		c.jouer(points.get(0));
	    } else {
		point = 0;
	    }
	}
    }

}
