void main() {
    Kissa kissa = new Kissa("Miuku", "Siamilainen", 15.0);
    Koira koira = new Koira("Rekku", "Bulldoggi", "Luu");
    Hamsteri hamsteri1 = new Hamsteri("Nappi", "Agouti");
    Hamsteri hamsteri2 = new Hamsteri("Nuppu", "Pallo");
    hamsteri1.lisaaParasKaveri(hamsteri2);

    Koira puudeli = new Puudeli("Sulo", "Coton de Tulear", new ArrayList<>(List.of("Jyväskylän kaunein", "Suomen paras villa")));


    IO.println(hamsteri1.getNimi() + ", " + hamsteri1.getRotu());

    IO.println("Olen " + hamsteri1.getRotu() + "-rotuinen " + hamsteri1.getNimi() + " ja paras kaverini on " + hamsteri1.getParasKaveri().getNimi());

    // kissa.aantele();
    // koira.aantele();
    // hamsteri1.aantele();

    List<Elain> elaimet = new ArrayList<>();
    elaimet.add(kissa);
    elaimet.add(koira);
    elaimet.add(hamsteri1);
    elaimet.add(hamsteri2);
    elaimet.add(puudeli);

    for (Elain elain : elaimet) {
        elain.aantele();
    }

    /* Tämä tehtiin luennon jälkeen */
    hamsteri1.juokseJuoksupyorassa(10);
    hamsteri1.aantele();
    hamsteri1.juokseJuoksupyorassa(100);
    hamsteri1.aantele();
}