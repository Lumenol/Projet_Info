package pipopipette;

/**
 * 
 *
 */
public class Simulation {
	/**
	 * Lanceur de la simulation en non bavard
	 * 
	 * @param hauteur hauteur de la grille
	 * @param largeur largeur de la grille
	 * @param contours  affichage des contours ou non
	 * @param n nombre de parties lancees
	 * @param j1 Joueur 1
	 * @param j2 Joueur 2
	 * @return la moyenne des points remportes lors de la simulation par le joueur 1
	 */
	public static float simulation(int hauteur, int largeur, boolean contours, int n,
			Fonction<Grille, Iterable<Grille>> j1, Fonction<Grille, Iterable<Grille>> j2) {
		Partie p = new Partie(hauteur, largeur, contours, j1, j2);
		float somme = 0;
		for (int i = 0; i < n; i++) {
			p.nouvellePartie(false,1);
			somme += p.getPoints(0);
		}
		return somme / n;

	}
}
