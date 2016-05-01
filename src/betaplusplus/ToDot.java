package betaplusplus;

import java.util.HashSet;
import java.util.Iterator;

public class ToDot<T extends Etat> implements Fonction<T, String> {

    private Fonction<T, Iterator<T>> succ;
    private Fonction<Etat, Integer> id;
    private HashSet<Etat> visite;

    public ToDot(Fonction<T, Iterator<T>> succ) {
	super();
	this.succ = succ;
	id = new FonctionDynamique<>(new Fonction<Etat, Integer>() {
	    private int id = 0;

	    @Override
	    public Integer get(Etat x) {
		// TODO Auto-generated method stub
		return id++;
	    }
	});

    }

    @Override
    public String get(T x) {
	visite = new HashSet<>();
	StringBuffer sb = new StringBuffer("digraph default{");
	sb.append("graph[labelloc=\"t\" fontsize=16 fontcolor=\"blue\"\n");
	sb.append("label=\"Graphe\"]\n");
	sb.append("node [shape=box fontname = \"Courier New\" color=\"sienna\"]\n");
	sb.append("edge [fontname = \"Times\" fontcolor=\"sienna\"]\n\n");
	sb.append(dot(x));
	sb.append("}");
	return sb.toString();
    }

    private String dot(T x) {
	if (!visite.contains(x)) {
	    StringBuffer sb = new StringBuffer(id.get(x).toString());
	    // inserer representation
	    sb.append(" [ label= \"" + x.label() + "\"]\n");
	    for (Iterator<T> iterator = succ.get(x); iterator.hasNext();) {
		T fil = iterator.next();
		sb.append(dot(fil));
		// inserer ornement arc ici
		sb.append(id.get(x) + " -> " + id.get(fil) + "\n");
	    }
	    visite.add(x);
	    return sb.toString();
	} else
	    return "";
    }

}
