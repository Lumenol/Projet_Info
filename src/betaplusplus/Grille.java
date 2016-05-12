package betaplusplus;

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
	 * @param hauteur
	 * @param largeur
	 * @param contours
	 */
	public Grille(int hauteur, int largeur, boolean contours) {
		this(hauteur, largeur, contours, null);
	}

	/**
	 * Contruit la Grille suivant les parametres passés
	 * 
	 * @param hauteur
	 * @param largeur
	 * @param contours
	 * @param t La grille
	 * 
	 */
	public Grille(int hauteur, int largeur, boolean contours, int[] t) {
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
	 * @param x coord h
	 * @param y coord v
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

	/*
	 * (non-Javadoc) Fonction de hachage pour la grille incluant les rotations
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

	/**
	 * @return La hauteur de la grille
	 */
	public int hauteur() {
		return grille.length;

	}

	/**
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
		// TODO Auto-generated method stub
		return toString(true);
	}

	/**
	 * @return La valeur de Largeur
	 */
	public int largeur() {
		return grille[hauteur() - 1].length;

	}

	/**
	 * @param x Coordonnee h
	 * @param y Coordonnee v
	 * 
	 */
	public void placer(int x, int y) {
		if (get(x, y) == VIDE) {
			grille[y][x] = JOUER;
		}
	}

	/**
	 * Renplissage de la grille de jeu
	 * valeur jouer a toute case de this.grille
	 */
	public void RempliCarres() {
		for (int i = 0; i < largeur(); i++) {
			for (int j = 0; j < hauteur(); j++) {
				if (carreComplet(i, j)) {
					placer(i, j);
					RempliCarres();
					//return;
				}
			}
		}
	}

	public String toString() {
		return toString(false);
	}

	/**
	 * Determine si un carre est present aux coordonnees passees
	 * 
	 * @param x Coord H
	 * @param y Coord V
	 * @return True si un carre est detecte sur les coordonnees x y /False
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
	 * @return La grille t pivotee
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
	 * @return La grille t symetrique
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

	/**
	 * @param toDot
	 * @return
	 */
	private String toString(boolean toDot) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[i].length; j++) {
				switch (grille[i][j]) {
				case VIDE:
					sb.append(" ");
					break;
				case BLOQUE:
					if (i % 2 == 0)
						sb.append(".");
					else
						sb.append(" ");
					break;

				case JOUER:
					if (i % 2 == 0)
						sb.append("-");
					else
						sb.append("|");
					break;
				}
			}
			sb.append(toDot ? "\\n" : "\n");
		}
		return sb.toString();
	}

}
