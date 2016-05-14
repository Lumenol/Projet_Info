package pipopipette;

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

	/**
	 * Constructeur de l'objet
	 * 
	 * @param fonction
	 *            Implement la fonction passée en parametre dans l'objet
	 */
	public FonctionDynamique(Fonction<E, F> fonction) {
		this.fonction = fonction;
		memoire = new HashMap<>();
	}

	/**
	 * @param x Cle a chercher dans la map
	 * @return Valeur associee
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
	 * Ajout de (cle,valeur) a la map
	 * 
	 * @param key cle associee
	 * @param value valeur associee
	 * @return structure (Hashmap) aggrementee de k,v
	 */
	public F put(E key, F value) {
		return memoire.put(key, value);
	}

}
