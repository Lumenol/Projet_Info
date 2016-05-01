package beta;

public interface Sommet<I> {
	public boolean addEntrant(Sommet<I> s, double p);

	public boolean addSortant(Sommet<I> s, double p);

	public Iterable<Sommet<I>> getEntrant();

	public I getInfo();

	public Iterable<Sommet<I>> getSortant();

	public String toDot();
}
