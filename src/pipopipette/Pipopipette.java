package pipopipette;

import java.io.FileNotFoundException;
import java.util.IllegalFormatException;
import java.util.Scanner;



public class Pipopipette {


	public static void main(String[] args) {
		switch (args[0]) {
		case "-name": System.out.println("Roche Julie\nCrédevlle Louis-Maxime\nVincent Renard\nBovie Pierre-Edouard\n"); break;
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
			ToDot<Grille> dot = new ToDot<Grille>(new Simplet());
			switch(args[1]){
			case "C" : System.out.println(dot.get(new Grille(Integer.parseInt(args[2]), Integer.parseInt(args[3]), true))); break;
			case "S" : System.out.println(dot.get(new Grille(Integer.parseInt(args[2]), Integer.parseInt(args[3]), false))); break;
			}
			break;
		case "-joue":
			switch (args[2]) {
			case "-simplet": jeu(new Simplet(),args[1],null); break;
			case "-prevoyant": jeu(new Prevoyant(),args[1],null); break;
			case "-idiot": jeu(new Idiot(),args[1],null); break;
			case "-pondere": 
				try {
					jeu(new Pondere(new Poids(args[3])), args[1], args[3]);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				;break;
			}; break;
			
			
			
			
			
		case "-cal":
			if (args[1].equals("-graphe")){
				switch (args[2]){
				case "-simplet": ; break;
				case "-prevoyant": ; break;
				case "-idiot": ; break;
				}
			}else{
				System.out.println("");
			}; break;
		case "-apprend": System.out.println("Non finis1"); break;
		case "-eval": System.out.println("Non finis2"); break;
		
		
		
		
		
		
		case "-simul":
			boolean contours = false;
			switch(args[3]){
			case "C" : contours = true; break;
			case "S" : contours = false; break;
			}
			switch (args[2]) {
			case "-simplet":
				switch (args[6]) {
				case "-simplet": System.out.println("Le joueur simplet a "+Simulation.simulation(Integer.parseInt(args[4]),Integer.parseInt(args[5]),contours,Integer.parseInt(args[1]),new Simplet(),new Simplet())+" carré(s) complété(s)."); break;
				case "-prevoyant": System.out.println("Le joueur simplet a "+Simulation.simulation(Integer.parseInt(args[4]),Integer.parseInt(args[5]),contours,Integer.parseInt(args[1]),new Simplet(),new Prevoyant())+" carré(s) complété(s)."); break;
				case "-idiot": System.out.println("Le joueur simplet a "+Simulation.simulation(Integer.parseInt(args[4]),Integer.parseInt(args[5]),contours,Integer.parseInt(args[1]),new Simplet(),new Idiot())+" carré(s) complété(s)."); break;
				case "-pondere": 
					try {
						System.out.println("Le joueur simplet a "+Simulation.simulation(Integer.parseInt(args[4]),Integer.parseInt(args[5]),contours,Integer.parseInt(args[1]),new Simplet(),new Pondere(new Poids(args[7])))+" carré(s) complété(s)."); break;
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}; break;
			case "-prevoyant":
				switch (args[6]) {
				case "-simplet": System.out.println("Le joueur prevoyant a "+Simulation.simulation(Integer.parseInt(args[4]),Integer.parseInt(args[5]),contours,Integer.parseInt(args[1]),new Prevoyant(),new Simplet())+" carré(s) complété(s)."); break;
				case "-prevoyant": System.out.println("Le joueur prevoyant a "+Simulation.simulation(Integer.parseInt(args[4]),Integer.parseInt(args[5]),contours,Integer.parseInt(args[1]),new Prevoyant(),new Prevoyant())+" carré(s) complété(s)."); break;
				case "-idiot": System.out.println("Le joueur prevoyant a "+Simulation.simulation(Integer.parseInt(args[4]),Integer.parseInt(args[5]),contours,Integer.parseInt(args[1]),new Prevoyant(),new Idiot())+" carré(s) complété(s)."); break;
				case "-pondere": 
					try {
						System.out.println("Le joueur prevoyant a "+Simulation.simulation(Integer.parseInt(args[4]),Integer.parseInt(args[5]),contours,Integer.parseInt(args[1]),new Prevoyant(),new Pondere(new Poids(args[7])))+" carré(s) complété(s)."); break;
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}; break;
			case "-idiot":
				switch (args[6]) {
				case "-simplet": System.out.println("Le joueur idiot a "+Simulation.simulation(Integer.parseInt(args[4]),Integer.parseInt(args[5]),contours,Integer.parseInt(args[1]),new Idiot(),new Simplet())+" carré(s) complété(s)."); break;
				case "-prevoyant": System.out.println("Le joueur idiot a "+Simulation.simulation(Integer.parseInt(args[4]),Integer.parseInt(args[5]),contours,Integer.parseInt(args[1]),new Idiot(),new Prevoyant())+" carré(s) complété(s)."); break;
				case "-idiot": System.out.println("Le joueur idiot a "+Simulation.simulation(Integer.parseInt(args[4]),Integer.parseInt(args[5]),contours,Integer.parseInt(args[1]),new Idiot(),new Idiot())+" carré(s) complété(s)."); break;
				case "-pondere": 
					try {
						System.out.println("Le joueur idiot a "+Simulation.simulation(Integer.parseInt(args[4]),Integer.parseInt(args[5]),contours,Integer.parseInt(args[1]),new Idiot(),new Pondere(new Poids(args[7])))+" carré(s) complété(s)."); break;
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}; break;
			case "-pondere":
				try {
					switch (args[6]) {
					case "-simplet": System.out.println("Le joueur pondere a "+Simulation.simulation(Integer.parseInt(args[4]),Integer.parseInt(args[5]),contours,Integer.parseInt(args[1]),new Pondere(new Poids(args[7])),new Simplet())+" carré(s) complété(s)."); break;
					case "-prevoyant": System.out.println("Le joueur pondere a "+Simulation.simulation(Integer.parseInt(args[4]),Integer.parseInt(args[5]),contours,Integer.parseInt(args[1]),new Pondere(new Poids(args[7])),new Prevoyant())+" carré(s) complété(s)."); break;
					case "-idiot": System.out.println("Le joueur pondere a "+Simulation.simulation(Integer.parseInt(args[4]),Integer.parseInt(args[5]),contours,Integer.parseInt(args[1]),new Pondere(new Poids(args[7])),new Idiot())+" carré(s) complété(s)."); break;
					case "-pondere": System.out.println("Le joueur pondere a "+Simulation.simulation(Integer.parseInt(args[4]),Integer.parseInt(args[5]),contours,Integer.parseInt(args[1]),new Pondere(new Poids(args[7])),new Pondere(new Poids(args[7])))+" carré(s) complété(s).");break;
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				; break;
			}
		}
	}
	/**Lance la partie
	 * @param ia le type de joueur adversaire (idiot, humain , simplet , pondere , prevoyant )
	 * @param joueur Determine je premier joueur ( celui qui commence)
	 */
	public static void jeu(Fonction<Grille, Iterable<Grille>> ia, String joueur, String pip) {
		Scanner sc = new Scanner(System.in);
		Humain a = new Humain();
		Partie c = null;
		if ((ia.getClass()).equals(Pondere.class)){
			try {
				c = c.fromPip(a,ia,joueur,pip);
				c.nouvellePartie(true);
			} catch (IllegalFormatException | NumberFormatException | FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println("Hauteur de grille :");
			int hauteur_de_grille = sc.nextInt();
			System.out.println("Largeur de grille :");
			int Largeur_de_grille = sc.nextInt();
			System.out.println("Voulez vous des contours sur votre grille? : (C/S)");
			String contoursString = sc.next();
			boolean contoursBool = false;
			switch(contoursString){
			case "C" : contoursBool = true; break;
			case "S" : contoursBool = false; break;
			}
			if (Integer.parseInt(joueur) == 1){
				c = new Partie(hauteur_de_grille, Largeur_de_grille, contoursBool, a, ia);
			}else{
				c = new Partie(hauteur_de_grille, Largeur_de_grille, contoursBool, ia, a);
			}
			c.nouvellePartie(true);
			sc.close();	
		}
	}

	/**Configuration de la grille de jeu ( fonction interactive) 
	 * @return une grille avec la configuration desiree
	 */
	public static Grille cal() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hauteur de grille :");
		int hauteur_de_grille = sc.nextInt();
		System.out.println("Largeur de grille :");
		int Largeur_de_grille = sc.nextInt();
		System.out.println("Voulez vous des contours sur votre grille? : (C/S)");
		String contours = sc.next();
		sc.close();
		return new Grille(hauteur_de_grille, Largeur_de_grille, Boolean.parseBoolean(contours));
	}

}