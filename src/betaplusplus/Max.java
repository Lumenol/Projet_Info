package betaplusplus;

import java.util.Iterator;

public class Max extends FonctionDynamique<Etat, Float> {

	public Max(Fonction<Etat, Iterator<Etat>> successeurs, Fonction<Etat, Integer> nombreCarre,
			Fonction<Etat, Float> V2) {
		super(new Fonction<Etat, Float>() {

			private Fonction<Etat, Iterator<Etat>> succ = successeurs;
			private Fonction<Etat, Integer> nbCarre = nombreCarre;
			private Fonction<Etat, Float> v2 = V2;

			@Override
			public Float get(Etat x) {
				Iterator<Etat> s = succ.get(x);
				if (s.hasNext()) {
					float max = Float.NEGATIVE_INFINITY;
					float m;
					for (Iterator<Etat> iterator = s; iterator.hasNext();) {
						Etat y = iterator.next();
						m = nbCarre.get(x) - nbCarre.get(y) - v2.get(y);
						max = m > max ? m : max;
					}
					return max;
				} else {
					return (float) 0;
				}

			}
		});
		// TODO Auto-generated constructor stub
	}

}
