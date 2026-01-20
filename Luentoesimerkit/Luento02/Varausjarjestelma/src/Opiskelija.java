import java.util.Random;

public class Opiskelija {
    public final static String YLIOPISTO = "Jyväskylän yliopisto";
    private String nimi;
    private int opiskelijanumero;

    public Opiskelija(String nimi, int opiskelijanumero) {
        this.nimi = nimi;
        this.opiskelijanumero = opiskelijanumero;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String uusiNimi) {
        nimi = uusiNimi;
    }

    public void ilmoittaudu(Kurssi kurssi) {
        kurssi.lisaaOpiskelija(this);
    }

    public void tulostaTiedot() {
        String nimi = this.nimi.toLowerCase();
        IO.println(nimi + ", " + opiskelijanumero);
    }

    private String nimiIsolla() {
        return nimi.toUpperCase();
    }

    public static int satunnainenOpiskelijanumero() {
        return new Random().nextInt(10000);
    }
}