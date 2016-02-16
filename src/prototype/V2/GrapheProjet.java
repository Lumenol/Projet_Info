package prototype.V2;

import java.io.FileWriter;
import java.io.IOException;

public class GrapheProjet {

    public static void main(String[] args) {

	Graph a = new Graph(3, 3, true);

	try {
	    FileWriter fw = new FileWriter("autre/outV2.dot");
	    fw.write(a.toDot());
	    System.out.println("OK");
	    fw.close();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

}
