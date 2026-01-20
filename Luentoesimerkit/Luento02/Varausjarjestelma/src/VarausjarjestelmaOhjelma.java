void main() {
    Opiskelija denis = new Opiskelija("Denis", Opiskelija.satunnainenOpiskelijanumero());
    Opiskelija aj = new Opiskelija("Antti-Jussi", Opiskelija.satunnainenOpiskelijanumero());
    Opiskelija sami = new Opiskelija("Sami", Opiskelija.satunnainenOpiskelijanumero());

    denis.tulostaTiedot();
    aj.tulostaTiedot();
    sami.tulostaTiedot();

    Kurssi kurssi = new Kurssi("TIEP111", "Ohjelmointi 2");
    sami.ilmoittaudu(kurssi);
    kurssi.tulostaTiedot();
}
