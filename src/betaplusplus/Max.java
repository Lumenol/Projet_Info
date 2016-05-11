package betaplusplus;

import java.util.Iterator;

public class Max<T> implements Fonction<T, Float> {

    private Fonction<T, Iterable<T>> succ;
    private Fonction<T, Integer> nbCarre;
    private Fonction<T, Float> v2;

    public Max(Fonction<T, Iterable<T>> successeurs, Fonction<T, Integer> nombreCarre) {
	this(successeurs, nombreCarre, null);
    }

    public Max(Fonction<T, Iterable<T>> successeurs, Fonction<T, Integer> nombreCarre, Fonction<T, Float> V2) {
	succ = successeurs;
	nbCarre = nombreCarre;
	v2 = V2;
    }

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

    public void setV2(Fonction<T, Float> V2) {
	v2 = V2;
    }

    // TODO Auto-generated constructor stub
}
