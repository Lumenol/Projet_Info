package beta;

public interface Graphe<I> {
	public boolean addSommet(Sommet<I> s);

	public Sommet<I> chercher(I s);

	public Iterable<Sommet<I>> getSommet();

	public String toDot();
}

// Archi graphe, to Dot, strategie
