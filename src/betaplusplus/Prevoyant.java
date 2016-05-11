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
		int max = Integer.MIN_VALUE;
		for (Iterator<Grille> iterator = simplet.get(x).iterator(); iterator.hasNext();) {
		    Grille y = iterator.next();
		    int m = nbC.get(x) - nbC.get(y);
		    if (m >= max) {
		    	if (m > max) {
		    		max = m;
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
