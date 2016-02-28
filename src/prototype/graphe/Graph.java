package prototype.graphe;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import prototype.Grille;

public class Graph implements Graphe {

    List<Sommet> sommet;

    public Graph(int n, boolean entoure) {
	sommet = new LinkedList<Sommet>();
	int[] tab = new int[Grille.nombreTraitGrille(n)];
	Arrays.fill(tab, Grille.VIDE);
	if (entoure) {
	    int j = 0;
	    boolean cn = true;
	    for (int i = 0; i < tab.length; i++) {
		if (i < n || i > tab.length - 1 - n || j == n) {
		    if (j == n) {
			if (cn)
			    j = 0;
			else
			    j = -1;
			cn = !cn;
		    }
		    tab[i] = Grille.JOUE;
		}
		j++;
	    }
	}
	Config racine = new Config(tab);
	sommet.add(racine);
	LinkedList<Integer> l = new LinkedList<Integer>();
	for (int i = 0; i < tab.length; i++) {
	    if (tab[i] == Grille.VIDE)
		l.add(i);
	}
	generer(racine, l);
    }

    @Override
    public boolean addSommet(Sommet s, Sommet pere) {
	System.out.println(s.nom());
	Iterator<Sommet> it = sommet.iterator();
	while (it.hasNext()) {
	    Sommet s1 = it.next();
	    if (s.equals(s1)) {
		pere.addFil(s1);
		return false;
	    }
	}
	return sommet.add(s);
    }

    @Override
    public Iterator<Sommet> iterator() {
	return sommet.iterator();
    }

    @Override
    public String toDot() {
	StringBuffer sb = new StringBuffer("digraph default{");
	for (Iterator iterator = sommet.iterator(); iterator.hasNext();) {
	    Sommet sommet2 = (Sommet) iterator.next();
	    sb.append(sommet2.toDot() + "\n");
	}
	sb.append("}");
	return sb.toString();
    }

    private void generer(Config s, LinkedList<Integer> l) {
	ListIterator<Integer> it = l.listIterator();
	while (it.hasNext()) {
	    Integer type = it.next();
	    int[] t = Arrays.copyOf(s.getTableau(), s.getTableau().length);
	    t[type] = Grille.JOUE;

	    it.remove();
	    LinkedList<Integer> l1 = new LinkedList<Integer>(l);
	    it.add(type);
	    Config s1 = new Config(t);
	    if (addSommet(s1, s)) {
		s.addFil(s1);
		generer(s1, l1);
	    }
	}

    }

}
