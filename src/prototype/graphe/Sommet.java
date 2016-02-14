package prototype.graphe;

import java.util.Iterator;

public interface Sommet {
    boolean addFil(Sommet s);

    Iterator<Sommet> iterator();

    String nom();

    String toDot();
}
