/**
 * MaksuTulos kuvaa yhden rahallisen tapahtuman lopputulosta.
 * Rahallinen tapahtuma voi olla esimerkiksi:
 * - maksaminen (kortti, lahjakortti, lasku)
 * - hyvitys (kokonainen tai osittainen)
 * <p>
 * Olio kertoo:
 * - onnistuiko maksu vai ei
 * - mahdollisen virheviestin
 * - tapahtuman tunnisteen, jolla tapahtuma voidaan yksilöidä (jos maksu onnistui)
 * <p>
 * Tässä versiossa luokka on toteutettu mahdollisimman
 * suoraviivaisesti käyttäen julkista muodostajaa.
 * <p>
 * HUOMAUTUS:
 * Tässä toteutuksessa on mahdollista luoda olio
 * loogisesti ristiriitaiseen tilaan (esim. onnistui=true,
 * mutta tapahtumaId puuttuu).
 * <p>
 * Todellisessa tuotantokoodissa tämä ratkaistaisiin
 * usein käyttämällä private-muodostajaa ja
 * static-tehdasmetodeja. Tämä malli esitellään
 * myöhemmin kurssilla.
 */
public class MaksuTulos {

    /**
     * Kertoo, onnistuiko tapahtuma
     */
    private final boolean onnistui;

    /**
     * Virheviesti, jos tapahtuma epäonnistui (null jos onnistui)
     */
    private final String virhe;

    /**
     * Tapahtuman tunniste.
     * <p>
     * Tunniste:
     * - yksilöi tämän rahallisen tapahtuman
     * - voidaan käyttää lokituksessa ja virheiden selvittämisessä
     * - EI ole sama asia kuin MaksuPyynto.viite()
     * <p>
     * MaksuPyynto.viite():
     * - kertoo mihin tämä tapahtuma liittyy (esim. tilaus)
     * <p>
     * MaksuTulos.tapahtumaId():
     * - kertoo tämän nimenomaisen maksun tai hyvityksen tunnisteen
     */
    private final String tapahtumaId;

    /**
     * Luo uuden MaksuTulos-olion.
     *
     * @param onnistui    true jos maksu onnistui
     * @param virhe       virheviesti, jos maksu epäonnistui (null jos onnistui)
     * @param tapahtumaId maksutapahtuman tunniste (null jos epäonnistui)
     */
    public MaksuTulos(boolean onnistui, String virhe, String tapahtumaId) {
        this.onnistui = onnistui;
        this.virhe = virhe;
        this.tapahtumaId = tapahtumaId;
    }

    /*
     * ==========================================================
     * HUOMAUTUS JATKOA VARTEN (EI KÄYTÖSSÄ TÄSSÄ VAIHEESSA)
     *
     * Turvallisempi tapa toteuttaa tämä luokka olisi
     * estää virheellisten tilojen luominen kokonaan.
     * Se voitaisiin tehdä esimerkiksi näin:
     *
    private MaksuTulos(boolean onnistui, String virhe, String tapahtumaId) {
        this.onnistui = onnistui;
        this.virhe = virhe;
        this.tapahtumaId = tapahtumaId;
    }

    public static MaksuTulos onnistui(String tapahtumaId) {
        return new MaksuTulos(true, null, tapahtumaId);
    }

    public static MaksuTulos epaonnistui(String virhe) {
        return new MaksuTulos(false, virhe, null);
    }
     *
     * Tällöin MaksuTulos-olioita voisi luoda vain
     * loogisesti järkeviin tiloihin.
     *
     * Tähän palataan myöhemmin kurssilla, kun
     * staattiset tehdasmetodit on käsitelty.
     * ==========================================================
     */

    /**
     * @return true jos rahallinen tapahtuma onnistui, false muuten
     */
    public boolean onnistui() {
        return onnistui;
    }

    /**
     * @return virheviesti, jos tapahtuma epäonnistui, muuten null
     */
    public String virhe() {
        return virhe;
    }

    /**
     * @return tapahtuman tunniste, jos tapahtuma onnistui, muuten null
     */
    public String tapahtumaId() {
        return tapahtumaId;
    }
}
