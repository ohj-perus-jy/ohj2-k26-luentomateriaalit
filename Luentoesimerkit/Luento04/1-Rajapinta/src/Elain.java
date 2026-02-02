/**
 * Abstrakti perusluokka eläimille.
 * Tarjoaa nimen ja edellyttää hoito-operaation toteutuksen.
 */
public abstract class Elain {
    private final String nimi;

    /**
     * Luo eläimen annetulla nimellä.
     *
     * @param nimi eläimen nimi
     */
    public Elain(String nimi){
        this.nimi=nimi;
    }

    /**
     * Palauttaa eläimen nimen.
     *
     * @return eläimen nimi
     */
    public String getNimi(){
        return nimi;
    }

    /**
     * Toteuttaa eläimen hoidon.
     */
    public abstract void hoida();
}
