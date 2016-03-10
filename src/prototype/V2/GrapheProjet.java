package prototype.V2;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GrapheProjet {

    public static void genererGraphe(int hauteur, int largeur, boolean bord, String dossier, String format) {

	Graph a = null;

	a = new Graph(hauteur, largeur, bord);
	// try {
	// a = Graph.graphFromPip(new File("autre/C3x3.pip"));
	// } catch (FileNotFoundException e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// }

	(new File(dossier)).mkdirs();

	String fileName = dossier + "/Graphe_" + hauteur + "x" + largeur + "_" + (bord ? "avec" : "sans") + "_bord";

	try {
	    FileWriter fw = new FileWriter(fileName + ".dot");
	    fw.write(a.toDot());
	    System.out.println(".dot OK");
	    fw.close();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	try {
	    Process p = Runtime.getRuntime()
		    .exec("dot" + " -T" + format + " " + fileName + ".dot -o " + fileName + "." + format);

	    p.waitFor();
	    Desktop.getDesktop().open(new File(fileName + "." + format));
	} catch (IOException e) {
	    System.err.println(e.getMessage());
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    public static void main(String[] args) {
	genererGraphe(3, 3, true, "autre/Graphe", "png");
    }

}
