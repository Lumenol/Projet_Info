package betaplusplus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.IllegalFormatException;
import java.util.IllegalFormatFlagsException;
import java.util.StringTokenizer;

public class Pondere extends AbstractSuccesseurs<Grille> {

    /**
     * @param poids
     * @param fonction
     */
    public Pondere(Fonction<Grille, Integer> poids) {
	super(new Fonction<Grille, Iterable<Grille>>() {
	    Fonction<Grille, Integer> p = poids;

	    @Override
	    public Iterable<Grille> get(Grille x) {
		// TODO Auto-generated method stub
		return null;
	    }
	});

	// TODO Auto-generated constructor stub

    }

    public Partie read(Fonction<Grille, Iterable<Grille>> j1, String pip)
	    throws FileNotFoundException, IllegalFormatException, NumberFormatException {
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

	    }

	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return null;

    }

}
