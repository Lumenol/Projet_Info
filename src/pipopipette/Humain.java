package pipopipette;

import java.util.HashSet;
import java.util.Scanner;

public class Humain implements Fonction<Grille, Iterable<Grille>> {

   
    public Humain() {

    }

    /**Forme un jeu avec un joueur de type Humain
     * @param z grille d'origine
     * @return hashset contenant la grille jouee par un joueur Humain
     *
     */
    @Override
    public Iterable<Grille> get(Grille z) {
	Grille grille = new Grille(z);
	HashSet<Grille> g = new HashSet<>();
	Scanner sc = new Scanner(System.in);
	int x = 0, y = 0;
	do {
	    System.out.println("position largeur x: ");
	    x = sc.nextInt();
	    System.out.println("position hauteur y: ");
	    y = sc.nextInt();

	} while (grille.get(x, y) != Grille.VIDE);
	grille.placer(x, y);
	grille.RempliCarres();
	g.add(grille);
	return g;
    }
}