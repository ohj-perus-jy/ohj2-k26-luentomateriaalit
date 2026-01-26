import java.util.ArrayList;
import java.util.List;

/**
 * Puudeli, joka periin Koiran
 */
public class Puudeli extends Koira {

    private List<String> voitetutKilpailut;

    /**
     * Puudeli
     * @param nimi Nimi
     * @param rotu Rotu
     * @param voitetutKilpailut Voitetut kilpailut
     */
    public Puudeli(String nimi, String rotu, ArrayList<String> voitetutKilpailut) {
        this.voitetutKilpailut = voitetutKilpailut;
        super(nimi, rotu);
    }

    /**
     * Puudeli ääntelee ja kehuu itseään
     */
    @Override
    public void aantele()
    {
        super.aantele();
        IO.println("Ai niin, olen voittanut " + voitetutKilpailut.size() + " kilpailua ;-).");
    }
}
