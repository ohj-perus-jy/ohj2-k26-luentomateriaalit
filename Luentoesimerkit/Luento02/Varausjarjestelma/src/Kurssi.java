import java.util.ArrayList;
import java.util.List;

public class Kurssi {
    private String koodi;
    private String nimi;
    private List<Opiskelija> osallistujat;

    public Kurssi(String koodi, String nimi) {
        this.koodi = koodi;
        this.nimi = nimi;
        osallistujat = new ArrayList<>();
    }

    public void lisaaOpiskelija(Opiskelija op) {
        // Nyt voidaan tarkistaa
        //  - Onko kurssilla tilaa
        //  - Onko opiskelija jo ilmoittautunut
        osallistujat.add(op);
    }

    public void tulostaTiedot() {
        IO.println(koodi + " " + nimi);
        for (Opiskelija op : osallistujat) {
            op.tulostaTiedot();
        }
    }


}
