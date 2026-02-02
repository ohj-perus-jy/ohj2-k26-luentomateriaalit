/**
 * Hyvitettava kuvaa maksutapaa, jolle voidaan tehdä hyvitys
 * aiemmin onnistuneen maksun perusteella.
 *
 * Tämä on rajapinta, koska hyvitys ei ole kaikkien maksutapojen
 * perusominaisuus, vaan lisäkyvykkyys.
 *
 * Rajapinta antaa yhteisen "kielen" sille osajoukolle maksutapoja,
 * jotka tukevat hyvitystä.
 */
public interface Hyvitettava {

    /**
     * Hyvittää aiemmin tehdyn maksun (kokonaan tai osittain).
     *
     * @param tapahtumaId sen maksun tunniste, jota hyvitetään
     * @param summaSentteina hyvityksen määrä sentteinä
     * @return hyvityksen tulos (onnistuiko vai ei)
     */
    MaksuTulos hyvita(String tapahtumaId, int summaSentteina);
}
