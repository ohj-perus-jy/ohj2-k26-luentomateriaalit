public class Koira extends Elain {

    private String lempiruoka;

    /**
     * Koira
     * @param nimi Nimi
     * @param rotu Rotu
     * @param lempiruoka Lempiruoka
     */
    public Koira(String nimi, String rotu, String lempiruoka) {
        super(nimi, rotu);
        this.lempiruoka = lempiruoka;
    }

    /**
     * Koira, jonka lempiruoka on nappulat.
     * @param nimi Nimi
     * @param rotu Rotu
     */
    public Koira(String nimi, String rotu) {
        /* Tämä tehtiin luennon jälkeen */
        /* Saman luokan konstruktoria voidaan kutsua näin. */
        this(nimi, rotu, "Nappulat");
    }

    /**
     * Anna lempiruoka
     * @return Lempiruoka
     */
    public String getLempiruoka() {
        return lempiruoka;
    }

    /**
     * Ääntele
     */
    @Override
    public void aantele()
    {
        IO.println(getNimi() + " haukkuu! Lempiruokaani on " + getLempiruoka());
    }

}