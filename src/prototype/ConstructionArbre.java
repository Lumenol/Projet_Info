package prototype;

public class ConstructionArbre {
	public Noeud initial;
	public ConstructionArbre(Grille a){
		initial = new Noeud (null,a);
	}
	public void ajouterNoeud(Noeud pere, Grille p){
		Noeud noeud = new Noeud(pere,p);
		pere.listfils.add(noeud);
	}
}
