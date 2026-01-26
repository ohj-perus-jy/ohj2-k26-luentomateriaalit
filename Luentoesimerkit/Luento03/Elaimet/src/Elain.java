/**
 * Abstrakti eläin.
 */
public abstract class Elain {
    private final String nimi;
    private final String rotu;

    /**
     * Eläin
     * @param nimi Nimi
     * @param rotu Rotu
     */
    public Elain(String nimi, String rotu) {
        this.nimi = nimi;
        this.rotu = rotu;
    }

    /**
     * Anna nimi
     * @return Nimi
     */
    public String getNimi() {
        return nimi;
    }

    /**
     * Anna rotu
     * @return Rotu
     */
    public String getRotu() {
        return rotu;
    }

    /**
     * Ääntele. Toteutettava perivissä luokissa.
     */
    public abstract void aantele();


    // Kaikilla luokilla on toString, joka voidaan ylikirjoittaa.
    //
    // @Override
    // public String toString()
    // {
    //     return "";
    // }
}
