package betaplusplus;

import java.util.Iterator;

public class Moyenne extends FonctionDynamique<Etat, Float> {

    public Moyenne(Fonction<Etat, Iterator<Etat>> successeurs, Fonction<Etat, Integer> nombreCarre,
	    Fonction<Etat, Float> V1) {
	super(new Fonction<Etat, Float>() {

	    private Fonction<Etat, Iterator<Etat>> succ = successeurs;
	    private Fonction<Etat, Integer> nbCarre = nombreCarre;
	    private Fonction<Etat, Float> v1 = V1;

	    @Override
	    public Float get(Etat x) {
		Iterator<Etat> s = succ.get(x);
		if (s.hasNext()) {
		    float somme = 0;
		    int nbSucc = 0;
		    for (Iterator<Etat> iterator = s; iterator.hasNext();) {
			Etat y = iterator.next();
			somme += nbCarre.get(x) - nbCarre.get(y) - v1.get(y);
			nbSucc++;
		    }
		    return somme / nbSucc;
		} else {
		    return (float) 0;
		}
	    }
	});
	// TODO Auto-generated constructor stub
    }

}
