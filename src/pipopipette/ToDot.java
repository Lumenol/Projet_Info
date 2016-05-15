package pipopipette;

import java.util.HashSet;
import java.util.Iterator;


public class ToDot<T extends Etat> implements Fonction<T, String> {

    private Fonction<T, Iterable<T>> succ;
    private Fonction<T, ? extends Number> points;
    private Fonction<Etat, Integer> id;
    private HashSet<Etat> visite;

    /**Constructeur ToDot
     * @param succ Successeur
     */
    public ToDot(Fonction<T, Iterable<T>> succ) {
	this(succ, null);
    }

    /**
     * @param succ Successeur
     * @param points 
     *            Associe un nombre a un etat comme le poids par exemple
     */
    public ToDot(Fonction<T, Iterable<T>> succ, Fonction<T, ? extends Number> points) {
	super();
	this.succ = succ;
	this.points = points;
	id = new FonctionDynamique<>(new Fonction<Etat, Integer>() {
	    private int id = 0;

	    @Override
	    public Integer get(Etat x) {
		// TODO Auto-generated method stub
		return id++;
	    }
	});

    }

    /**
     * Retourne tous les successeurs d'un etat au format dot
     * 
     * @param x Etat
     * @return Successeurs de l'etat (en dot)
     */
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

    /**
     * Ecrit l'etat au format dot avec les arcs vers ses successeurs
     *
     * @param x
     *            Etat
     * @return chaine d'Etat au format dot
     */
    private String dot(T x) {
	if (!visite.contains(x)) {
	    StringBuffer sb = new StringBuffer(id.get(x).toString());
	    sb.append(" [ label= \"");
	    if (points != null)
		sb.append("V=" + points.get(x) + "\\n");
	    sb.append(x.label() + "\"]\n");
	    for (Iterator<T> iterator = succ.get(x).iterator(); iterator.hasNext();) {
		T fil = iterator.next();
		sb.append(dot(fil));
		sb.append(id.get(x) + " -> " + id.get(fil) + "\n");
	    }
	    visite.add(x);
	    return sb.toString();
	} else
	    return "";
    }

}
