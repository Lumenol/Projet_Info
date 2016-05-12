package betaplusplus;

import java.util.Iterator;

/**
 * @param <T>
 */
public class Max<T> implements Fonction<T, Float> {

	private Fonction<T, Iterable<T>> succ;
	private Fonction<T, Integer> nbCarre;
	private Fonction<T, Float> v2;

	/**Constructeur de Max
	 * @param successeurs Les successeurs 
	 * @param nombreCarre fonction passee 
	 */
	public Max(Fonction<T, Iterable<T>> successeurs, Fonction<T, Integer> nombreCarre) {
		this(successeurs, nombreCarre, null);
		setV2(new Moyenne(new Simplet(), nombreCarre, new FonctionDynamique<>(this)));
	}

	/**
	 * Constructeur de l'objet Max
	 *
	 * @param successeurs les successeurs
	 * @param nombreCarre fonction nbCarre
	 * @param V2
	 */
	public Max(Fonction<T, Iterable<T>> successeurs, Fonction<T, Integer> nombreCarre, Fonction<T, Float> V2) {
		succ = successeurs;
		nbCarre = nombreCarre;
		v2 = V2;
	}

	/**
	 * @param x 
	 * @return successeur pour le joueur qui le plus de carres
	 * (non-Javadoc)
	 *
	 * @see betaplusplus.Fonction#get(java.lang.Object)
	 */
	@Override
	public Float get(T x) {
		Iterator<T> s = succ.get(x).iterator();
		if (s.hasNext()) {
			float max = Float.NEGATIVE_INFINITY;
			float m;
			for (Iterator<T> iterator = s; iterator.hasNext();) {
				T y = iterator.next();
				m = nbCarre.get(x) - nbCarre.get(y) - v2.get(y);
				max = m > max ? m : max;
			}
			return max;
		} else {
			return (float) 0;
		}

	}

	/**
	 * @param V2 (?)
	 */
	public void setV2(Fonction<T, Float> V2) {
		v2 = V2;
	}

}
