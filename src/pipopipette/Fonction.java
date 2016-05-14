package pipopipette;

/**
 *
 * @param <E>
 * @param <F>
 */
public interface Fonction<E, F> {
	/**
	 * @param x
	 * @return
	 */
	public F get(E x);
}
