/**
 * Geneerinen pari kahdelle arvolle.
 *
 * @param <T1> ensimmäisen arvon tyyppi
 * @param <T2> toisen arvon tyyppi
 */
public class Pari<T1, T2> {
    private T1 eka;
    private T2 toka;

    /**
     * Luo parin kahdesta arvosta.
     *
     * @param eka ensimmäinen arvo
     * @param toka toinen arvo
     */
    public Pari(T1 eka, T2 toka)
    {
        this.eka = eka;
        this.toka = toka;
    }

    /**
     * Palauttaa ensimmäisen arvon.
     *
     * @return ensimmäinen arvo
     */
    public T1 getEka() {
        return eka;
    }

    /**
     * Palauttaa toisen arvon.
     *
     * @return toinen arvo
     */
    public T2 getToka() {
        return toka;
    }
}
