/**
 * Maksutapa on abstrakti yliluokka kaikille maksutavoille.
 * <p>
 * Se määrittelee:
 * - mitä tarkoittaa "maksaminen" sovelluksen näkökulmasta
 * - yhteisen rungon maksun suorittamiselle
 * <p>
 * Aliluokat (esim. kortti, lahjakortti, lasku) toteuttavat
 * varsinaisen maksun omalla tavallaan.
 */
public abstract class Maksutapa {

    /**
     * Maksutavan nimi (esim. "Kortti", "Lahjakortti")
     */
    private final String nimi;

    /**
     * Luo maksutavan annetulla nimellä.
     *
     * @param nimi maksutavan nimi
     */
    protected Maksutapa(String nimi) {
        this.nimi = nimi;
    }

    /**
     * @return maksutavan nimi
     */
    public String getNimi() {
        return nimi;
    }

    /**
     * Suorittaa maksun annetun maksupyynnön perusteella.
     * <p>
     * Tämä on niin sanottu "template method":
     * - yhteinen esivalidointi tehdään tässä
     * - varsinainen maksun toteutus delegoidaan aliluokalle
     *
     * @param pyynto maksupyyntö
     * @return maksun tulos
     */
    public final MaksuTulos maksa(MaksuPyynto pyynto) {
        if (pyynto.summaSentteina() <= 0) {
            return new MaksuTulos(false, "Summa ei kelpaa", null);
        }
        return suoritaMaksu(pyynto);
    }

    /**
     * Aliluokan vastuulla oleva varsinainen maksun toteutus.
     *
     * @param pyynto maksupyyntö
     * @return maksun tulos
     */
    protected abstract MaksuTulos suoritaMaksu(MaksuPyynto pyynto);
}
