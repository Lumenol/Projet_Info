package prototype;

import java.util.ArrayList;

public class Noeud {
	public Noeud parent;
	public Grille a;
	public ArrayList<Noeud> listfils;
	
	public Noeud(){
		parent = null;
		a = null;
		listfils = null;
	}
	public Noeud(Noeud p, Grille a, ArrayList<Noeud> listfils){
		parent = p;
		this.a = a;
		this.listfils = listfils;
	}
}
