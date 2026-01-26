public class Hamsteri extends Elain {

    /**
     * Hamsterin paras kaveri
     */
    private Hamsteri parasKaveri;

    /* Nämä lisättiin luennon jälkeen */
    private int kierroksiaJuostu;
    private final int MAX_KIERROKSIA;

    /**
     * Hamsteri. Maksimikierrosmäärä asetetaan 100:aan.
     *
     * @param nimi Nimi
     * @param rotu Rotu
     */
    public Hamsteri(String nimi, String rotu) {
        this(nimi, rotu, 100);
    }

    /**
     * Hamsteri
     *
     * @param nimi          Nimi
     * @param rotu
     * @param maxKierroksia
     */
    public Hamsteri(String nimi, String rotu, int maxKierroksia) {
        super(nimi, rotu);
        parasKaveri = this;
        kierroksiaJuostu = 0;
        MAX_KIERROKSIA = maxKierroksia;
    }

    /**
     * Lisää hamsterille paras kaveri
     *
     * @param parasKaveri Paras kaveri
     */
    public void lisaaParasKaveri(Hamsteri parasKaveri) {
        this.parasKaveri = parasKaveri;

        /* TODO: Tässä voisi tarkistaa, että onko
         * parametrina tulevalla hamsterilla jo paras kaveri
         * (muu kuin this) ja jos on, niin sitten ei lisätä.
         * Tällöin olisi luontevaa muuttaa metodin paluuarvoksi
         * boolean ja palauttaa true vain, jos lisäys onnistui.
         */

        /* Tämä onnistuu, koska myös parametrina tuleva Hamsteri
         * tämän samaisen tyypin edustaja. Luokka luottaa itseensä
         * ja omiin ilmentymiinsä, ja siksi pääsemme käpistelemään
         * myös toisen Hamsterin yksityistä attribuuttia
         */
        parasKaveri.parasKaveri = this;
    }

    /**
     * Anna paras kaveri
     *
     * @return Paras kaveri
     */
    public Hamsteri getParasKaveri() {
        return this.parasKaveri;
    }

    /* Alla olevat metodit tehtiin luennon jälkeen */

    /**
     * Juokseppas hamsteri juoksupyörässä!
     *
     * @param kierroksia montako kierrosta juostaan
     * @return Jaksaako marsu juosta enää
     */
    public boolean juokseJuoksupyorassa(int kierroksia) {
        if (kierroksiaJuostu > MAX_KIERROKSIA) return false;
        kierroksiaJuostu += kierroksia;
        if (kierroksiaJuostu > MAX_KIERROKSIA) {
            // Kuollut hamsteri ei voi olla kenekään paras kaveri, joten
            // poistetaan tieto parhaasta kaverista.
            poistaParasKaveri();
            return false;
        }
        return true;
    }

    /**
     * Resetoidaan sekä oma että parhaan kaverin tiedot parhaista kavereista,
     * ts. asetetaan ne this-arvoihin.
     */
    public void poistaParasKaveri() {
        parasKaveri.parasKaveri = parasKaveri;
        this.parasKaveri = this;
    }

    /**
     * Ääntele hamsterille ominaisella tavalla.
     */
    @Override
    public void aantele() {
        IO.print("Olen " + getRotu() + " " + getNimi() + ". ");
        if (kierroksiaJuostu < MAX_KIERROKSIA) {
            IO.print("Jaksan juosta vielä " + (MAX_KIERROKSIA - kierroksiaJuostu) + " kierrosta juoksupyörässä. ");
            IO.println("Paras kaverini on " + parasKaveri.getNimi());
        } else {
            IO.println("Valitettavasti olen kyykähtänyt raskaan juoksemisen seurauksena. ");
        }
    }
}