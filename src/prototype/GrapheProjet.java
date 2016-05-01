package prototype;

import java.io.FileWriter;
import java.io.IOException;

public class GrapheProjet {

	public static void main(String[] args) {

		Arbre a = new Arbre(1);

		try {
			FileWriter fw = new FileWriter("autre/out.dot");
			fw.write(a.toString());
			System.out.println("OK");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
