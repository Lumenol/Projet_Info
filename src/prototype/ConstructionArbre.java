package prototype;

public class ConstructionArbre {
	public Noeud initial;
	public ConstructionArbre(Grille a){
		initial = new Noeud (null,a,null);
	}
	public void ajouterNoeud(Noeud pere, Grille p){
		Noeud noeud = new Noeud(pere,p,null);
		pere.listfils.add(noeud);
	}
}
