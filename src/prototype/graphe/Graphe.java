package prototype.graphe;

import java.util.Iterator;

public interface Graphe {
    boolean addSommet(Sommet s, Sommet pere);

    Iterator<Sommet> iterator();

    String toDot();
}
