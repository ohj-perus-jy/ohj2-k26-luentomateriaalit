/**
 * Demonstraatio-ohjelma, joka näyttää miten maksujärjestelmää
 * käytetään
 */
void main() {

    // 1) Luodaan maksutavat
    Korttimaksu korttimaksu = new Korttimaksu();
    Maksutapa lahjakortti = new LahjakorttiMaksu(2000); // 20,00 €

    // 2) Luodaan maksupyyntö
    // MaksuPyynto = “tätä maksua koskevat tiedot”
    // Maksutapa = “näin tämä maksu suoritetaan”
    MaksuPyynto pyynto = new MaksuPyynto(1500, "TILAUS-123");

    // 3) Suoritetaan maksu kortilla
    IO.println("Maksetaan kortilla:");
    suoritaJaTulosta(korttimaksu, pyynto);

    IO.println();

    // 4) Suoritetaan maksu lahjakortilla
    IO.println("Maksetaan lahjakortilla:");
    suoritaJaTulosta(lahjakortti, pyynto);

    IO.println();

    // 5) Kokeillaan epäonnistuvaa maksua lahjakortilla
    MaksuPyynto isoPyynto = new MaksuPyynto(5000, "TILAUS-124");
    IO.println("Maksetaan lahjakortilla (liian suuri summa):");
    suoritaJaTulosta(lahjakortti, isoPyynto);

    MaksuPyynto mp1 = new MaksuPyynto(1500, "TILAUS-456");
    MaksuTulos korttiTulos = korttimaksu.maksa(mp1);
    IO.println("Korttimaksu: " + (korttiTulos.onnistui() ? "OK" : "FAIL"));

    MaksuTulos lahjaTulos = lahjakortti.maksa(mp1);
    IO.println("Lahjakortti: " + (lahjaTulos.onnistui() ? "OK" : "FAIL"));

    // Hyvitys: tässä kohtaa rajapinta on se "portti".
    // Vain Hyvitettava-tyyppiselle oliolle hyvitys on sallittu toiminto.
    MaksuTulos hyvitys = korttimaksu.hyvita(korttiTulos.tapahtumaId(), 500);
    IO.println("Hyvitys: " + (hyvitys.onnistui() ? "OK" : "FAIL: " + hyvitys.virhe()));
}

/**
 * Suorittaa maksun annetulla maksutavalla ja tulostaa tuloksen.
 *
 * Tämä metodi näyttää käytännössä:
 *  - miten Maksutapa-viitteen kautta kutsutaan maksa-metodia
 *  - miten eri aliluokat käyttäytyvät eri tavoin
 */
private static void suoritaJaTulosta(Maksutapa maksutapa, MaksuPyynto pyynto) {
    MaksuTulos tulos = maksutapa.maksa(pyynto);

    if (tulos.onnistui()) {
        IO.println("Maksu onnistui (" + maksutapa.getNimi() + ")");
        IO.println("Tapahtuma-ID: " + tulos.tapahtumaId());
    } else {
        IO.println("Maksu epäonnistui (" + maksutapa.getNimi() + ")");
        IO.println("Syy: " + tulos.virhe());
    }
}
