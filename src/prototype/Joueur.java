package prototype;

import java.util.Scanner;

public class Joueur extends AbstractJoueur {

    public Joueur(int numero) {
	super(numero);
	// TODO Auto-generated constructor stub
    }

    @Override
    public void jouer(Grille g) {
	Scanner sc = new Scanner(System.in);
	boolean jouer = false;
	while (!jouer) {
	    System.out.println("x");
	    int x = sc.nextInt();
	    System.out.println("y");
	    int y = sc.nextInt();
	    if (g.grille[y][x] == 0) {
		jouer = true;
		g.grille[y][x] = numero;
	    }
	}
    }

}
