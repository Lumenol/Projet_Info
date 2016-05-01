package prototype;

import java.util.ArrayList;

public class Noeud {
	public Noeud parent;
	public Grille a;
	public ArrayList<Noeud> listfils;

	public Noeud() {
		parent = null;
		a = null;
		listfils = new ArrayList<Noeud>();
	}

	public Noeud(Noeud p, Grille a) {
		parent = p;
		this.a = a;
		this.listfils = new ArrayList<Noeud>();
	}
}
