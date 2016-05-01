package prototype;

import java.awt.Point;
import java.util.Scanner;

public class Humain extends Joueur {

	public Humain() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean jouer(Grille g) {
		Scanner sc = new Scanner(System.in);
		boolean jouer = false;
		int x = 0, y = 0;
		while (!jouer) {
			System.out.println("x");
			x = sc.nextInt();
			System.out.println("y");
			y = sc.nextInt();
			jouer = g.placer(y, x);
		}
		int c = g.nombreCarreComplets(y, x);
		points += c;
		sc.close();
		return c >= 1;

	}

	@Override
	public boolean jouer(prototype.V2.Grille g) {
		Scanner sc = new Scanner(System.in);
		Point p;
		int x = 0, y = 0;
		do {
			System.out.println("x");
			x = sc.nextInt();
			System.out.println("y");
			y = sc.nextInt();
			p = new Point(x, y);
		} while (!g.isJouable(p));
		int c = g.jouer(p);
		points += c;
		// sc.close();
		return c >= 1;
	}

}
