package Archi_lm;

import java.util.HashMap;

public class FonctionDynamique<E, F> implements Fonction<E, F> {
    private HashMap<E, F> memoire;
    private Fonction<E, F> fonction;

    public FonctionDynamique(Fonction<E, F> fonction) {
	this.fonction = fonction;
	memoire = new HashMap<>();
    }

    public F get(E x) {
	F v;
	if ((v = memoire.get(x)) == null) {
	    v = fonction.get(x);
	    memoire.put(x, v);
	}
	return v;
    }

}