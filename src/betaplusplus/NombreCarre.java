package betaplusplus;

public class NombreCarre extends FonctionDynamique<Grille, Integer> {

    public NombreCarre() {
	super(new Fonction<Grille, Integer>() {

	    @Override
	    public Integer get(Grille x) {
		int nbCarre = 0;
		int[][] t = { { 0, 0 }, { 1, 1 }, { 2, 0 }, { 1, -1 } };
		for (int i = 1; i < x.largeur(); i += 2) {
		    for (int j = 0; j < x.hauteur() - 2; j += 2) {
			boolean complet = true;
			int k = 0;
			while (complet && k < t.length) {
			    complet = x.get(i + t[k][0], j + t[k][1]) == Grille.JOUER;
			    k++;
			}
			if (complet)
			    nbCarre++;
		    }
		}

		return nbCarre;
	    }

	});
	// TODO Auto-generated constructor stub
    }

}
