package betaplusplus;

public class Pipopipette {

	public static void main(String[] args) {
		switch (args[0]){
		case "-name": System.out.println("Roche Julie\nCrédevlle Louis-Maxime\nVincent Renard\nBovie Pierre-Edouard\n"); break;
		case "-h": System.out.println("Rappelle de la liste des options du programme:\n"
				+ "java -jar pipopipette.jar -name affiche vos noms et prénoms\n"
				+ "java -jar pipopipette.jar -h rappelle la liste des options du programme\n"
				+ "java -jar pipopipette.jar –graphe type nblignes nbcolonnes renvoie le graphe des configurations réduit au format dot.\n"
				+ "java -jar pipopipette.jar –joue strategie offre la possibilité de jouer sur la console de manière interactive.\n"
				+ "java -jar pipopipette.jar -cal strategie calcule une stratégie optimum face à un joueur suivant la stratégie passée en paramètre. La commande renvoie le résultat au format pip (voir l’exemple simple C3x3.pip)\n"
				+ "java -jar pipopipette.jar –cal -graphe strategie calcule une stratégie optimum face un joueur suivant la stratégie passée en paramètre. La commande renvoie le résultat le graphe réduit au format dot et la pondération des configurations définissant la stratégie calculée.\n"
				+ "java -jar pipopipette.jar -apprend parametres strategie calcule une stratégie par une méthode d’apprentissage (détail à venir).\n"
				+ "java -jar pipopipette.jar -eval strategie strategie évalue les deux stratégies en paramètre de manière exacte et une table des probabilités de tous les scores possibles. Le résultat est un script gnuplot donnant le résultat sous la forme d’un diagramme en batons.\n"
				+ "java -jar pipopipette.jar -simul N strategie strategie évalue les deux stratégies en paramètre par simulation en lançant N parties et une table des probabilités de tous les scores possibles. Le résultat est un script gnuplot donnant le résultat sous la forme d’un diagramme en batons..\n"); break;
		case "-graphe": new Grille(Integer.parseInt(args[2]), Integer.parseInt(args[3]), Boolean.parseBoolean(args[1])); break;
		case "-joue":
			switch (args[1]){
			case "-simplet":  ; break;
			case "-prevoyant": ; break;
			case "-idiot": ; break;
			case "-pondere": ; break;
			}; break;
		case "-cal": ; break;
		case "-apprend": ; break;
		case "-eval": ; break;
		case "-simul": ; break;
		}
	}
}
