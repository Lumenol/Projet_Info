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
		if (a.equals("a")){
			new Partie();
		}else{
			Grille grille = new Grille(2,true);

			ConstructionArbre tree = new ConstructionArbre(grille);

			int cpttab = 0;
			Joueur js[] = new Joueur[1];
			js[0] = new Simplet();
			System.out.println(grille);
		//	for (int i = 0; i <= 4; i++){


				do{
					cpttab++;
					System.out.println("Etape tab n°"+cpttab);
					js[0].jouer(grille);
					tree.ajouterNoeud(tree.initial, grille);
					System.out.println(grille);
				}while (!grille.isPlein());

				System.out.println("FIN");
		//	}
		}
		sc.close();
	}
}
//arbre, graphe, complession, symetrie, etiquettes sur arbres