package betaplusplus;

import java.util.Scanner;


public class Pipopipette {

	public static void main(String[] args) {
		switch (args[0]) {
		case "-name":
			System.out.println("Roche Julie\nCrédevlle Louis-Maxime\nVincent Renard\nBovie Pierre-Edouard\n");
			break;
		case "-h":
			System.out.println("Rappelle de la liste des options du programme:\n"
					+ "java -jar pipopipette.jar -name affiche vos noms et prénoms\n"
					+ "java -jar pipopipette.jar -h rappelle la liste des options du programme\n"
					+ "java -jar pipopipette.jar –graphe type nblignes nbcolonnes renvoie le graphe des configurations réduit au format dot.\n"
					+ "java -jar pipopipette.jar –joue joueur strategie offre la possibilité de jouer sur la console de manière interactive. Le paramètre joueur vaut soit 1 ou 2 : 1 indique que l’humain commence, 2 que c’est l’ordinateur. Les valeurs possibles de strategie sont donnés dans la partie « Stratégies élémentaires »\n"
					+ "java -jar pipopipette.jar -cal strategie calcule une stratégie optimum face à un joueur suivant la stratégie passée en paramètre. La commande renvoie le résultat au format pip (voir l’exemple simple C3x3.pip)\n"
					+ "java -jar pipopipette.jar –cal -graphe strategie calcule une stratégie optimum face un joueur suivant la stratégie passée en paramètre. La commande renvoie le résultat le graphe réduit au format dot et la pondération des configurations définissant la stratégie calculée.\n"
					+ "java -jar pipopipette.jar -apprend N alpha gready strategie calcule une stratégie par une méthode d’apprentissage en faisant en sorte que l’apprenti et le stratège commence chacun leur tour. Les paramètres de l’apprentissage sont : N est le nombre de parties, alpha est le taux d’apprentissage (compris en 0 et 1), gready vaut 1 si la technique du ε-gready est utilisé sinon il vaut 1.\n"
					+ "java -jar pipopipette.jar -eval strategie strategie évalue les deux stratégies en paramètre de manière exacte en faisant commencer la première stratégie passée en paramètre et renvoie le nombre moyen de carrés complétés par la premièrestratégie.\n"
					+ "java -jar pipopipette.jar -simul N strategie strategie évalue les deux stratégies en paramètre par simulation en lançant N parties et une table des probabilités de tous les scores possibles. Le résultat est un script gnuplot donnant le résultat sous la forme d’un diagramme en batons..\n");
			break;
		case "-graphe":
			Grille g = new Grille(Integer.parseInt(args[2]), Integer.parseInt(args[3]), Boolean.parseBoolean(args[1]));
			break;// a finir :S
		case "-joue":
			switch (args[2]) {
			case "-simplet": jeu(new Simplet(),args[1]); break;
			case "-prevoyant": jeu(new Prevoyant(),args[1]); break;
			case "-idiot": jeu(new Idiot(),args[1]); break;
			case "-pondere": break;// a finir :S
			}
			;
			break;
		case "-cal": if (args[1].equals("-graphe")){
			System.out.println("");
		}else{
			switch (args[2]){
			case "-simplet": ; System.out.println((new ToDot<Grille>(new Simplet())).get(cal()));; break;
			case "-prevoyant": System.out.println((new ToDot<Grille>(new Prevoyant())).get(cal()));; break;
			case "-idiot": System.out.println((new ToDot<Grille>(new Idiot())).get(cal()));; break;
			}; break;
		}; break;
		case "-apprend": System.out.println("Non finis1"); break;
		case "-eval": System.out.println("Non finis2"); break;
		case "-simul": System.out.println("Non finis3"); break;
		}
	}

	public static void jeu(Fonction<Grille, Iterable<Grille>> ia, String joueur) {
		Scanner sc = new Scanner(System.in);
		Humain a = new Humain();
		Partie c;
		System.out.println("Hauteur de grille :");
		int hauteur_de_grille = sc.nextInt();
		System.out.println("Largeur de grille :");
		int Largeur_de_grille = sc.nextInt();
		System.out.println("Voulez vous des contours sur votre grille? : (true/false)");
		String contours = sc.next();
		if (Integer.parseInt(joueur) == 1){
			c = new Partie(hauteur_de_grille, Largeur_de_grille, Boolean.parseBoolean(contours), a, ia);
		}else{
			c = new Partie(hauteur_de_grille, Largeur_de_grille, Boolean.parseBoolean(contours), ia, a);
		}
		c.nouvellePartie(true);
		sc.close();
	}
	public static Grille cal() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hauteur de grille :");
		int hauteur_de_grille = sc.nextInt();
		System.out.println("Largeur de grille :");
		int Largeur_de_grille = sc.nextInt();
		System.out.println("Voulez vous des contours sur votre grille? : (true/false)");
		String contours = sc.next();
		sc.close();
		return new Grille(hauteur_de_grille, Largeur_de_grille, Boolean.parseBoolean(contours));
	}

}