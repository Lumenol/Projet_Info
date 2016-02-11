package prototype;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class Arbre {

    private Sommet racine;

    public Arbre(int n) {
	int[] tab = new int[Grille.nombreTraitGrille(n)];
	Arrays.fill(tab, Grille.VIDE);
	racine = new Sommet(tab);
	LinkedList<Integer> l = new LinkedList<Integer>();
	for (int i = 0; i < tab.length; i++) {
	    l.add(i);
	}
	generer(racine, l);
    }

    public String toString() {
	StringBuffer sb = new StringBuffer("digraph default{");
	sb.append(racine.toString());
	sb.append("}");
	return sb.toString();
    }

    private void generer(Sommet s, LinkedList<Integer> l) {
	ListIterator<Integer> it = l.listIterator();
	while (it.hasNext()) {
	    Integer type = it.next();
	    int[] t = Arrays.copyOf(s.getTableaeu(), s.getTableaeu().length);
	    t[type] = Grille.JOUE;

	    it.remove();
	    LinkedList<Integer> l1 = new LinkedList<Integer>(l);
	    it.add(type);
	    Sommet s1 = new Sommet(t);
	    s.add(s1);
	    generer(s1, l1);
	}

    }

}
