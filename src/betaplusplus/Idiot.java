package betaplusplus;

import java.util.Iterator;
import java.util.LinkedList;

public class Idiot extends AbstractSuccesseurs<Grille> {

	/**
	 * 
	 */
	public Idiot() {
		super(new Fonction<Grille, Iterable<Grille>>() {

			private Simplet simplet = new Simplet();
			private NombreCarre nbC = new NombreCarre();

			/**
			 * @param x grille orgine
			 * @return La liste chainee de coups successifs joues par un joueur idiot
			 * (non-Javadoc)
			 * 
			 * @see betaplusplus.Fonction#get(java.lang.Object)
			 */
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
		
	}

}
