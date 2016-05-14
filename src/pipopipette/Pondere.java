package pipopipette;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Type de joueur (strategie)
 *
 */
public class Pondere extends AbstractSuccesseurs<Grille> {

	/**
	 * Constructeur de Pondere
	 * 
	 * @param poids
	 *            le poids
	 */
	public Pondere(Fonction<Grille, Integer> poids) {
		super(new Fonction<Grille, Iterable<Grille>>() {
			Fonction<Grille, Integer> p = poids;
			Simplet simplet = new Simplet();
			NombreCarre nbC = new NombreCarre();

			/**
			 * Getter liste de coups type ponderes
			 * 
			 * @param x
			 *            grille d'origine
			 * @return Liste chainee de coups successifs joues par un joueur de
			 *         type pondere
			 */
			@Override
			public Iterable<Grille> get(Grille x) {
				LinkedList<Grille> retour = new LinkedList<>();
				int min = Integer.MAX_VALUE;
				for (Iterator<Grille> iterator = simplet.get(x).iterator(); iterator.hasNext();) {
					Grille y = iterator.next();
					int m = nbC.get(x) - nbC.get(y) + poids.get(y);
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

	}

}
