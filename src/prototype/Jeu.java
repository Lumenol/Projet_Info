package prototype;

import java.util.Random;
import java.util.Scanner;

public class Jeu {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();
	// TODO Auto-generated method stub
	System.out.println("Si A alors partie, si B alors calcul de l'arbre");
	String a = sc.next();
	if (a.equals("a")) {
	    new Partie();
	} else {
	    System.out.println("Taille de grille :");
	    int taille_de_grille = sc.nextInt();
	    Grille grille = new Grille(taille_de_grille, true);
	    Grille copieGrille = new Grille(taille_de_grille, true);
	    ConstructionArbre tree = new ConstructionArbre(grille);

	    int cpttab = 0;
	    Joueur js[] = new Joueur[1];
	    js[0] = new Simplet();
	    System.out.println(grille);

	    int nbrPossibilite = Grille.nombreTraitGrille(taille_de_grille) - taille_de_grille * 4;
	    System.out.println("nbr de possiblilites = " + nbrPossibilite);

	    do {
		cpttab++;
		System.out.println("Etape tab n�" + cpttab);

		for (int i = 0; i < nbrPossibilite; i++) {
		    try {
			Thread.sleep(300);
		    } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
		    System.out.println("i = " + i);
		    js[0].jouer(grille);
		    System.out.println(grille);
		    tree.ajouterNoeud(tree.initial, grille);
		    grille = copieGrille.copyGrille();
		}

		System.out.println(grille);
	    } while (!grille.isPlein());

	    System.out.println("FIN");

	}
	sc.close();
    }
}
// arbre, graphe, completion, symetrie, etiquettes sur arbres