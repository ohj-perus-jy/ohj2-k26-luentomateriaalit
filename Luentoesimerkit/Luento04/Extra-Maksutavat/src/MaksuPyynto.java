/**
 * MaksuPyynto kuvaa yhden maksutapahtuman tiedot.
 * <p>
 * * Ajatus: "maksaminen" ei ole pelkkä summa, vaan tapahtuma, joka liittyy
 * * johonkin sovelluksen kannalta merkitykselliseen asiaan (esim. tilaukseen).
 * <p>
 * <p>
 * MaksuPyyntö tarvitaan, jotta maksaminen ei ole vain metodikutsu, vaan selkeästi mallinnettu tapahtuma.
 * Se kokoaa yhteen maksun kannalta olennaiset tiedot yhdeksi olioksi, joka voidaan:
 * - välittää maksutavalle
 * - tarkistaa
 * - käyttää eri maksutavoissa samalla tavalla
 * - laajentaa myöhemmin rikkomatta olemassa olevaa koodia
 * Mitä tapahtuisi ilman MaksuPyyntö-oliota?
 * Ilman erillistä maksupyyntöä rajapinta olisi helposti tämä:
 * maksutapa.maksa(1500, "TILAUS-123");
 * Tämä toimii nyt, mutta ongelmat alkavat heti, kun järjestelmä kasvaa.
 * <p>
 * Mitä jos maksamiseen tarvitaan myöhemmin:
 * - valuutta?
 * - asiakas-ID?
 * - maksun kuvaus?
 * - maksun tyyppi (ennakko / lopullinen)?
 * - maksun aikaleima?
 * <p>
 * Ilman MaksuPyyntöä joudut tekemään tämän:
 * - maksutapa.maksa(1500, "TILAUS-123", "EUR", asiakasId, kuvaus, ...);
 * 👉 Metodin allekirjoitus paisuu ja rikkoo kaikki kutsut.
 * <p>
 * * HUOM: viite ei ole maksutavan (kortti/lahjakortti) sisäinen tunniste eikä
 * * maksun lopullinen tapahtuma-ID. Se on sovelluksen oma tunniste, jolla
 * * maksu voidaan yhdistää takaisin esimerkiksi tilaukseen tai varaukseen.
 */
public class MaksuPyynto {

    /**
     * Maksettava summa sentteinä.
     * <p>
     * Käytämme senttejä (kokonaislukua) liukulukujen sijaan, jotta vältetään
     * rahasummiin liittyvät pyöristysongelmat (esim. 0.1 + 0.2 != 0.3).
     */
    private final int summaSentteina;

    /**
     * Viite kertoo, mihin tämä maksu liittyy.
     * <p>
     * Esimerkkejä viitteestä:
     * - "TILAUS-123" (verkkokaupan tilausnumero)
     * - "VARAUS-987" (ajanvarauksen tunniste)
     * - "LASKU-2026-15" (laskun numero)
     * <p>
     * Miksi viite on tärkeä?
     * 1) Se mahdollistaa maksutapahtuman yhdistämisen takaisin oikeaan kohteeseen.
     * Ilman viitettä maksutulos olisi irrallinen: tiedettäisiin summa, mutta ei kohdetta.
     * 2) Se tekee lokituksesta ja virhetilanteiden selvittämisestä ymmärrettävää:
     * voidaan raportoida "Maksu epäonnistui tilaukselle TILAUS-123".
     * 3) Se pysyy samana maksutavasta riippumatta: kortti, lahjakortti ja lasku
     * voivat kaikki käyttää samaa viitettä.
     */
    private final String viite;

    public MaksuPyynto(int summaSentteina, String viite) {
        this.summaSentteina = summaSentteina;
        this.viite = viite;
    }

    /**
     * @return maksettava summa sentteinä
     */
    public int summaSentteina() {
        return summaSentteina;
    }

    /**
     * Palauttaa maksun viitteen (eli "mihin tämä maksu liittyy").
     * <p>
     * Tyypillinen käyttötapa:
     * - maksutapa voi sisällyttää viitteen maksupalvelun pyynnölle
     * - sovellus voi lokittaa ja raportoida viitteen avulla
     * - maksutulos voidaan kytkeä takaisin tilaukseen viitteen perusteella
     *
     * @return viite, esim. "TILAUS-123"
     */
    public String viite() {
        return viite;
    }
}
