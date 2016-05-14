package pipopipette;

import java.util.Iterator;

/**
 *
 * @param <T>
 */
public class Moyenne<T> extends FonctionDynamique<T, Float> {

	/**
	 * Constructeur de l'objet Moyenne
	 * 
	 * @param successeurs Les successeurs
	 * @param nombreCarre fonction passee
	 * @param V1  
	 */
	public Moyenne(Fonction<T, Iterable<T>> successeurs, Fonction<T, Integer> nombreCarre, Fonction<T, Float> V1) {
		super(new Fonction<T, Float>() {

			private Fonction<T, Iterable<T>> succ = successeurs;
			private Fonction<T, Integer> nbCarre = nombreCarre;
			private Fonction<T, Float> v1 = V1;

			/**
			 * (non-Javadoc)
			 * 
			 * @param x 
			 * @return 
			 */
			@Override
			public Float get(T x) {
				Iterator<T> s = succ.get(x).iterator();
				if (s.hasNext()) {
					float somme = 0;
					int nbSucc = 0;
					for (Iterator<T> iterator = s; iterator.hasNext();) {
						T y = iterator.next();
						somme += nbCarre.get(x) - nbCarre.get(y) - v1.get(y);
						nbSucc++;
					}
					return somme / nbSucc;
				} else {
					return (float) 0;
				}
			}
		});
		
	}

}
