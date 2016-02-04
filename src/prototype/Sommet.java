package prototype;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Sommet {
    private static int numero = 0;
    private List<Sommet> voisin;
    private Grille grille;
    private int[] tableaeu;
    private int num;

    public Sommet(int[] grille) {
	voisin = new LinkedList<Sommet>();
	tableaeu = grille;
	this.grille = new Grille(Grille.dimmentionGrille(grille.length), grille);
	num = numero;
	numero++;
    }

    public boolean add(Sommet arg0) {
	return voisin.add(arg0);
    }

    public Grille getGrille() {
	return grille;
    }

    public int[] getTableaeu() {
	return tableaeu;
    }

    public Iterator<Sommet> iterator() {
	return voisin.iterator();
    }

    public String toString() {
	StringBuffer sb = new StringBuffer(num + " [label=\"" + grille.toString(true) + "\"]\n");

	for (Iterator iterator = voisin.iterator(); iterator.hasNext();) {
	    Sommet sommet = (Sommet) iterator.next();
	    sb.append(num + " -> " + sommet.num + "\n");
	    sb.append(sommet);
	}
	return sb.toString();
    }

}
