package betaplusplus;

import java.util.HashMap;

/**
 * 
 *
 * @param <E>
 * @param <F>
 */
/**
 * 
 *
 * @param <E>
 * @param <F>
 */
public class FonctionDynamique<E, F> implements Fonction<E, F> {
    private HashMap<E, F> memoire;
    private Fonction<E, F> fonction;

    /**Constructeur de l'objet  
     * @param fonction 
     * Implement la fonction passée en parametre dans l'objet 
     */
    public FonctionDynamique(Fonction<E, F> fonction) {
	this.fonction = fonction;
	memoire = new HashMap<>();
    }

    /* (non-Javadoc)
     * @see betaplusplus.Fonction#get(java.lang.Object)
     */
    public F get(E x) {
	F v;
	if ((v = memoire.get(x)) == null) {
	    v = fonction.get(x);
	    memoire.put(x, v);
	}
	return v;
    }

    /**
     * @param key
     * @param value
     * @return
     */
    public F put(E key, F value) {
	return memoire.put(key, value);
    }

}
