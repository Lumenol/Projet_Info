package pipopipette;

public abstract class AbstractSuccesseurs<T> extends FonctionDynamique<T, Iterable<T>> {

    /**
     * @param fonction Fonction a passer
     */
    public AbstractSuccesseurs(Fonction<T, Iterable<T>> fonction) {
	super(fonction);
    
    }

}
