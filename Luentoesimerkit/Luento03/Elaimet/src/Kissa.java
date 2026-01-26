/**
 * Kissa
 */
public class Kissa extends Elain {
    private double hannanPituus;

    /**
     * Kissa
     * @param nimi Kissan nimi
     * @param rotu Kissan rotu
     * @param hannanPituus Hännän pituus senttimetreinä
     */
    public Kissa(String nimi, String rotu, double hannanPituus) {
        super(nimi, rotu);
        this.hannanPituus = hannanPituus;
    }

    /**
     * Anna hännän pituus
     * @return Hännän pituus
     */
    public double getHannanPituus() {
        return hannanPituus;
    }

    /**
     * Ääntele
     */
    @Override
    public void aantele()
    {
        IO.println(getNimi() + " (" + getRotu() + ") miukuu. Häntäni pituus on " + getHannanPituus() + " cm.");
    }
}