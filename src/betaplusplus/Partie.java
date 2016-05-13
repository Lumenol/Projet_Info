package betaplusplus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.IllegalFormatFlagsException;
import java.util.Iterator;
import java.util.Random;
import java.util.StringTokenizer;

/**
 *
 */
public class Partie {

	/**Lit le fichier .pip et cree la partie de jeu selon les parameres du joueur 
	 * @param j1 Type de joueur (idiot, humain , simplet , pondere , prevoyant )
	 * @param pip nom du fichier 
	 * @return nouvelle partie selon le type de joueur
	 * @throws FileNotFoundException Si le fichier pip n'est pas present
	 * @throws IllegalFormatException Si le fichier n'est pas en .pip
	 * @throws NumberFormatException Si les donnees ne corespondent pas (?)
	 */
	public static Partie fromPip(Fonction<Grille, Iterable<Grille>> j1, String pip)
			throws FileNotFoundException, IllegalFormatException, NumberFormatException {
		BufferedReader br = new BufferedReader(new FileReader(pip));
		String line;
		boolean type = false;
		int hauteur = 0, largeur = 0;
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			if (st.countTokens() != 3)
				throw new IllegalFormatFlagsException("Il manque des informations");
			switch (st.nextToken()) {
			case "S":
				type = false;
				break;
			case "C":
				type = true;
				break;
			default:
				throw new IllegalFormatFlagsException("Le type est incorrect");
			}
			hauteur = Integer.parseInt(st.nextToken());
			largeur = Integer.parseInt(st.nextToken());
		} catch (IOException e) {
		}

		return new Partie(hauteur, largeur, type, j1, new Pondere(new Poids(pip)));

	}

	private ArrayList<Fonction<Grille, Iterable<Grille>>> joueurs;
	private ArrayList<Integer> points;
	private NombreCarre nbC;

	private Grille racine;

	/**
	 * Constructeur de l'objet Partie
	 *
	 * @param hauteur
	 *            hauteur de la grille
	 * @param largeur
	 *            largeur de la grille
	 * @param contours
	 *            affichage des contours (ou pas)
	 * @param j1
	 *            Joueur 1
	 * @param j2
	 *            Joueur 2
	 */
	public Partie(int hauteur, int largeur, boolean contours, Fonction<Grille, Iterable<Grille>> j1,
			Fonction<Grille, Iterable<Grille>> j2) {
		this.racine = new Grille(hauteur, largeur, contours);
		this.nbC = new NombreCarre();
		this.joueurs = new ArrayList<>(2);
		joueurs.add(j1);
		joueurs.add(j2);
		points = new ArrayList<>(2);
		points.add(0);
		points.add(0);
	}

	/**Getter des points du joueur j
	 * @param j
	 *            Joueur
	 * @return Le nombre de points attribues au joueur j 
	 */
	public Integer getPoints(int j) {
		try {
			return points.get(j);
		} catch (Exception e) {
			return null;
		}
	}

	/**Getter de la premiere grille initialisee
	 * @return la grille la grille originelle (vide)
	 */
	public Grille getRacine() {
		return racine;
	}

	/**
	 * Lanceur de la partie de jeu
	 *
	 * @param bavard
	 *            Parametre qui enclenche l'impression des etapes successives de
	 *            la partie, et declenche l'interaction joueur-jeu
	 */
	public void nouvellePartie(boolean bavard) {
		points.set(0, 0);
		points.set(1, 0);
		Grille etape = racine;
		int j = 0;
		int nbc;
		Random random = new Random();
		while (!etape.isPlein()) {
			if (bavard==true){
				if((joueurs.get(j).getClass()).equals(Humain.class)) {
					// imodifier selon pour avoir un beau truc
					System.out.println("A vous de jouer");
					System.out.println(etape);
				} else {
					System.out.println("L'IA joue");
				}
			}
			Iterable<Grille> it = joueurs.get(j).get(etape);
			ArrayList<Grille> suivants = new ArrayList<>();
			for (Iterator<Grille> iterator = it.iterator(); iterator.hasNext();) {
				Grille e = iterator.next();
				suivants.add(e);
			}
			nbc = nbC.get(etape);
			etape = suivants.get(random.nextInt(suivants.size()));
			j = (j + 1) % joueurs.size();
			points.set(j, points.get(j) + nbC.get(etape) - nbc);
			if (bavard==true){
				System.out.println(etape);
			
			if ((joueurs.get(j).getClass()).equals(Humain.class)) {
				System.out.println("Vous avez " + points.get(0) + " points\nL'IA a " + points.get(1) + " points\n");
			} else {
				System.out.println("Vous avez " + points.get(1) + " points\nL'IA a " + points.get(0) + " points\n");
			}
			}
		}
		if (bavard==true){
			if ((joueurs.get(0).getClass()).equals(Humain.class)) {
				if (points.get(1) > points.get(0)) {
					System.out.println("L'IA gagne!");
				} else {
					System.out.println("Vous avez gagné!");
				}
			} else {
				if (points.get(0) > points.get(1)) {
					System.out.println("L'IA gagne!");
				} else {
					System.out.println("Vous avez gagné!");
				}
			}
		}
	}

}
