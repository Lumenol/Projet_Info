package betaplusplus;

import java.util.HashSet;

public class Simplet extends AbstractSuccesseurs<Grille> {

    public Simplet() {
	super(new Fonction<Grille, Iterable<Grille>>() {

	    @Override
	    public Iterable<Grille> get(Grille x) {
		HashSet<Grille> successeur = new HashSet<>();
		for (int i = 0; i < x.largeur(); i++) {
		    for (int j = 0; j < x.hauteur(); j++) {
			if (x.get(i, j) == Grille.VIDE) {
			    Grille g = new Grille(x);
			    g.placer(i, j);
			    g.RempliCarres();
			    successeur.add(g);
			}
		    }
		}

		// TODO Auto-generated method stub
		return successeur;
	    }

	});
	// TODO Auto-generated constructor stub
    }

}
