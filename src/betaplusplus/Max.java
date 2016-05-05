package betaplusplus;

import java.util.Iterator;

public class Max<T extends Etat> extends FonctionDynamique<T, Float> {

    public Max(Fonction<T, Iterable<T>> successeurs, Fonction<T, Integer> nombreCarre) {
	this(successeurs, nombreCarre, null);
	fonction = new Moyenne(successeurs, nombreCarre, this);
    }

    public Max(Fonction<T, Iterable<T>> successeurs, Fonction<T, Integer> nombreCarre, Fonction<T, Float> V2) {
	super(new Fonction<T, Float>() {

	    private Fonction<T, Iterable<T>> succ = successeurs;
	    private Fonction<T, Integer> nbCarre = nombreCarre;
	    private Fonction<T, Float> v2 = V2;

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
	});
	// TODO Auto-generated constructor stub
    }

}
