package betaplusplus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IllegalFormatFlagsException;
import java.util.StringTokenizer;

public class Poids extends FonctionDynamique<Grille, Integer> {

    public Poids(String pip) throws FileNotFoundException, NumberFormatException {
	super(new Fonction<Grille, Integer>() {

	    @Override
	    public Integer get(Grille x) {
		// TODO Auto-generated method stub
		return 0;
	    }
	});

	BufferedReader br = new BufferedReader(new FileReader(pip));
	String line;
	boolean type;
	int hauteur, largeur;
	try {
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    if (st.countTokens() != 3)
		throw new IllegalFormatFlagsException("Il manque des information");
	    switch (st.nextToken()) {
	    case "S":
		type = false;
		break;
	    case "C":
		type = true;
		break;
	    default:
		throw new IllegalFormatFlagsException("Le type est incorect");
	    }
	    hauteur = Integer.parseInt(st.nextToken());
	    largeur = Integer.parseInt(st.nextToken());
	    while ((line = br.readLine()) != null) {
		ArrayList<Integer> tab = new ArrayList<>();
		st = new StringTokenizer(line);
		String l = st.nextToken();
		for (int i = 0; i < line.length(); i++) {
		    if (line.charAt(i) == ' ') {
			line = line.substring(i + 1);
			break;
		    }
		    switch (line.charAt(i)) {
		    case '0':
			tab.add(0);
			break;
		    case '1':
			tab.add(1);
			break;
		    default:
			break;
		    }
		}
		Integer[] t = new Integer[1];
		put(new Grille(hauteur, largeur, type, tab.toArray(t)), Integer.parseInt(st.nextToken()));
	    }

	} catch (IOException e) {
	}

	// TODO Auto-generated constructor stub
    }

}
