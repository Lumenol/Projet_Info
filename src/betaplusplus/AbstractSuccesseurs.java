package betaplusplus;

public abstract class AbstractSuccesseurs<T> extends FonctionDynamique<T, Iterable<T>> {

    /**
     * @param fonction 
     */
    public AbstractSuccesseurs(Fonction<T, Iterable<T>> fonction) {
	super(fonction);
    }

}
