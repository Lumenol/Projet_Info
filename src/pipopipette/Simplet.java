package pipopipette;

import java.util.HashSet;
/**
 * 
 * Type de joueur (strategie)
 *
 */
public class Simplet extends AbstractSuccesseurs<Grille> {

	/**
	 * Constructeur vide de l'objet
	 */
	public Simplet() {
		super(new Fonction<Grille, Iterable<Grille>>() {

			/**
			 * Forme un jeu avec un joueur type Simplet
			 * 
			 * @param x grille d'origine
			 * @see pipopipette.Fonction#get(java.lang.Object)
			 * @return Hashset de coups successifs joues par un joueur type simplet
			 */
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
				return successeur;
			}
		});
	}

}
