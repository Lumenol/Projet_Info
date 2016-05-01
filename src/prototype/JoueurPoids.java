package prototype;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;

import prototype.V2.Configuration;
import prototype.V2.Graph;
import prototype.V2.Grille;

public class JoueurPoids extends Joueur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Graph g = Graph.graphFromPip(new File("autre/C3x3.pip"));

			// System.out.println(g.toDot());
			System.out.println(g.toPip());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	Graph graph = null;

	public JoueurPoids(String pip) {
		super();
		try {
			graph = Graph.graphFromPip(new File(pip));

			// System.out.println(g.toDot());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean jouer(Grille g) {
		Configuration c = new Configuration(g);
		Configuration config = graph.get(c);
		Random rand = new Random();
		if (config != null) {
			ArrayList<Configuration> filsPoidsMin = config.filsPoidsMin();

			c = filsPoidsMin.get(rand.nextInt(filsPoidsMin.size()));
			System.out.println(c);
			Set<Entry<Integer, ArrayList<Point>>> entrySet = g.jouable().entrySet();
			for (Iterator iterator = entrySet.iterator(); iterator.hasNext();) {
				Entry<Integer, ArrayList<Point>> entry = (Entry<Integer, ArrayList<Point>>) iterator.next();
				ArrayList<Point> value = entry.getValue();
				for (Iterator iterator2 = value.iterator(); iterator2.hasNext();) {
					Point point = (Point) iterator2.next();
					Configuration tmp = new Configuration(g);
					tmp.jouer(point);
					System.out.println(tmp);
					Graph.jouer(tmp);
					if (tmp.equals(c)) {
						int p = g.jouer(point);
						points += p;
						return p > 0;
					}
				}
			}
		} else {
			SortedMap<Integer, ArrayList<Point>> jouable = g.jouable();
			ArrayList<Point> arrayList = jouable.get(jouable.lastKey());
			int p = g.jouer(arrayList.get(rand.nextInt(arrayList.size())));
			points += p;
			return p > 0;
		}
		return false;
	}

	@Override
	public boolean jouer(prototype.Grille g) {
		// TODO Auto-generated method stub
		return false;
	}

}
