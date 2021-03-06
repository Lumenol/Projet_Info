package pipopipette;

public class NombreCarre extends FonctionDynamique<Grille, Integer> {

	/**
	 * 
	 */
	public NombreCarre() {
		super(new Fonction<Grille, Integer>() {
			/**Calcule le nombre de carres realises dans la grille x
			 * 
			 * @param x 
			 *            grille
			 * @return le nombre de carres dans la grille (int)
			 */
			@Override
			public Integer get(Grille x) {
				int nbCarre = 0;
				int[][] t = { { 0, 0 }, { 1, 1 }, { 0, 2 }, { -1, 1 } };
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
		
	}

}
