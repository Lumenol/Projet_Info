package betaplusplus;

import java.util.Iterator;
import java.util.LinkedList;

public class Prevoyant extends AbstractSuccesseurs<Grille> {

    public Prevoyant() {
	super(new Fonction<Grille, Iterable<Grille>>() {

	    private Simplet simplet = new Simplet();
	    private NombreCarre nbC = new NombreCarre();

	    @Override
	    public Iterable<Grille> get(Grille x) {
		LinkedList<Grille> retour = new LinkedList<>();
		int min = Integer.MAX_VALUE;
		for (Iterator<Grille> iterator = simplet.get(x).iterator(); iterator.hasNext();) {
		    Grille y = iterator.next();
		    int m = nbC.get(x) - nbC.get(y);
		    if (m <= min) {

			if (m < min) {
			    min = m;
			    retour.clear();
			}
			retour.add(y);
		    }
		}
		return retour;
	    }
	});
	// TODO Auto-generated constructor stub
    }

}
