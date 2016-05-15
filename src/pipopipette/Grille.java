package pipopipette;

import java.util.Arrays;

/**
 *
 * @author Julie
 *
 */
public class Grille implements Etat {
	final static int BLOQUE = 1;
	final static int JOUER = 2;
	final static int VIDE = 0;
	private int[][] grille;

	public Grille(Grille g) {
		grille = Arrays.copyOf(g.grille, g.grille.length);
		for (int i = 0; i < g.grille.length; i++) {
			grille[i] = Arrays.copyOf(g.grille[i], g.grille[i].length);
		}
	}

	/**
	 * Constructeur de l'objet Grille
	 * 
	 * @param hauteur la hauteur de la grille
	 * @param largeur la largeur de la grille
	 * @param contours
	 *            choix de l'affichage des contours
	 */
	public Grille(int hauteur, int largeur, boolean contours) {
		this(hauteur, largeur, contours, null);
	}

	/**
	 * Construit la Grille suivant les parametres passes
	 * 
	 * @param hauteur
	 *            determine la hauteur de la grille
	 * @param largeur
	 *            determine la largeur de la grille
	 * @param contours
	 *            determine l'affichage ou non des contours
	 * @param t
	 *            La grille
	 * 
	 */
	public Grille(int hauteur, int largeur, boolean contours, Integer[] t) {
		hauteur = hauteur <= 0 ? 1 : hauteur;
		largeur = largeur <= 0 ? 1 : largeur;
		grille = new int[2 * hauteur + 1][2 * largeur + 1];
		int k = 0;
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[i].length; j++) {
				if ((j % 2 == 0) == (i % 2 == 0)) {
					grille[i][j] = BLOQUE;
				} else {
					if (contours && (i == 0 || i == grille.length - 1 || j == 0 || j == grille[i].length - 1))
						grille[i][j] = JOUER;
					else {
						if (t == null || k >= t.length) {
							grille[i][j] = VIDE;
						} else {
							if (t[k] == 1) {
								grille[i][j] = JOUER;
							} else {
								grille[i][j] = t[k];
							}
							k++;
						}
					}
				}
			}
		}
	}

	
	/**Fonction de comparaison
	 * @param obj l'objet a comparer
	 * @return true si l'objet appelant est le meme que celui passe en parametre
	 * */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grille other = (Grille) obj;
		int[][] g = other.grille;
		for (int i = 0; i < 4; i++) {
			g = rotation(g);
			if (Arrays.deepEquals(grille, g) || Arrays.deepEquals(grille, symetrique(g)))
				return true;
		}
		return false;
	}

	/**
	 * @param x
	 *            coordonnee horizontale
	 * @param y
	 *            coordonnee verticale
	 * @return valeur de la grille aux coordonnees x y (vide / jouer )/ bloque
	 *         si innaccessible
	 */
	public int get(int x, int y) {
		try {
			return grille[y][x];
		} catch (ArrayIndexOutOfBoundsException e) {
			return BLOQUE;
		}
	}

	/**
	 * Fonction de hachage pour la grille en incluant les rotations et les symetries
	 * @return entier hash 
	 */
	@Override
	public int hashCode() {
		int[][] g = grille;
		int hash = Integer.MIN_VALUE;
		for (int i = 0; i < 4; i++) {
			g = rotation(g);
			hash = Math.max(hash, Arrays.deepHashCode(g));
			hash = Math.max(hash, Arrays.deepHashCode(symetrique(g)));

		}
		return hash;
	}

	/**Getter de hauteur
	 * @return La hauteur de la grille
	 */
	public int hauteur() {
		return grille.length;

	}

	/**Determine si la grille pleine
	 * @return Faux si au moins une case de la grille est vide
	 */
	public boolean isPlein() {
		for (int i = 0; i < largeur(); i++) {
			for (int j = 0; j < hauteur(); j++) {
				if (get(i, j) == VIDE)
					return false;
			}
		}
		return true;
	}

	
	@Override
	public String label() {
		
		return toString(true);
	}

	/**Getter de largeur
	 * @return la largeur de la grille
	 */
	public int largeur() {
		return grille[hauteur() - 1].length;

	}

	/**Place JOUER  aux coordonnees x,y
	 * @param x
	 *            Coordonnee horizontale
	 * @param y
	 *            Coordonnee verticale
	 * 
	 */
	public void placer(int x, int y) {
		if (get(x, y) == VIDE) {
			grille[y][x] = JOUER;
		}
	}

	/**
	 * Completion automatique des carres
	 */
	public void RempliCarres() {
		for (int i = 0; i < largeur(); i++) {
			for (int j = 0; j < hauteur(); j++) {
				if (carreComplet(i, j)) {
					placer(i, j);
					RempliCarres();
				}
			}
		}
	}

	/**
	 * 
	 * 
	 * @see java.lang.Object#toString()
	 * @return 
	 */
	public String toString() {
		return toString(false);
	}

	/**
	 * Determine si un carre est ferme aux coordonnees passees
	 * 
	 * @param x
	 *            Coordonnee horizontale
	 * @param y
	 *            Coordonnee verticale
	 * @return True si un carre est ferme sur les coordonnees x y / False
	 */
	private boolean carreComplet(int x, int y) {
		if (get(x, y) != VIDE) {
			return false;
		}
		int[][] t;
		if (y % 2 == 0)
			t = new int[][] { { -1, -1 }, { 0, -2 }, { 1, -1 } };
		else
			t = new int[][] { { -1, -1 }, { -2, 0 }, { -1, 1 } };
		for (int s = -1; s <= 1; s += 2) {
			boolean complet = true;
			int i = 0;
			while (complet && i < t.length) {
				complet = get(x + s * t[i][0], y + s * t[i][1]) == JOUER;
				i++;
			}
			if (complet)
				return true;
		}
		return false;

	}

	/**
	 * @param t
	 *            grille
	 * @return La grille t pivotee d'un 1/4 de tour a droite
	 */
	private int[][] rotation(int[][] t) {
		int[][] r = new int[t[t.length - 1].length][t.length];
		for (int i = 0; i < r.length; i++) {
			for (int j = 0; j < r[i].length; j++) {
				r[i][j] = t[j][r.length - 1 - i];
			}
		}
		return r;
	}

	/**
	 * @param t
	 *            grille
	 * @return La grille t en symetrique axiale
	 */
	private int[][] symetrique(int[][] t) {
		int[][] t2 = new int[t.length][t[t.length - 1].length];
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				t2[i][j] = t[i][t[i].length - 1 - j];
			}
		}
		return t2;

	}

	/** Imprime la grille
	 * @param toDot format
	 * @return affichage de la grille
	 */
	private String toString(boolean toDot) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[i].length; j++) {
				switch (grille[i][j]) {
				case VIDE:
					sb.append("  ");
					break;
				case BLOQUE:
					if (i % 2 == 0)
						sb.append(". ");
					else
						sb.append("  ");
					break;

				case JOUER:
					if (i % 2 == 0)
						sb.append("- ");
					else
						sb.append("| ");
					break;
				}
			}
			sb.append(toDot ? "\\n" : "\n");
		}
		return sb.toString();
	}

}
