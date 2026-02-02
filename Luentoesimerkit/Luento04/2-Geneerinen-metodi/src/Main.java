/**
 * Esimerkkiohjelma, joka demonstroi geneerisiä metodeja listojen haussa.
 */
void main()
{
    List<Integer> lista1 = new ArrayList<>(List.of(3, 2, 1, 3, -5 , 3));
    List<Double> lista2 = new ArrayList<>(List.of(3.0, 2.5, 1.2, -5.7));
    List<Byte> lista3 = new ArrayList<>(List.of((byte) 5, (byte) 2, (byte) 3, (byte) 4, (byte) 5));


    if(loytyyko(lista1, 3)) IO.println("Luku 3 löytyi!");
    if(loytyyko(lista2, 2.5)) IO.println("Luku 2.5 löytyi!");
    if(loytyyko(lista3, (byte)2)) IO.println("Luku 2 löytyi!");

    List<String> lista4 = new ArrayList<>(List.of("Kissa", "Koira", "Hamsteri", "Gepardi", "Koira"));
    if (!loytyyko(lista4, "Marsu")) IO.println("MArsua ei löydy :(");

    int esiintymat1 = laskeEsiintymat(lista1, 3); IO.println("Lukua 3 löytyi "+ esiintymat1 + " kpl.");
    int esiintymat2 = laskeEsiintymat(lista2, 0.0); IO.println("Lukua 0.0 löytyi " + esiintymat2 + " kpl.");
    int esiintymat3 = laskeEsiintymat(lista3, (byte)5); IO.println("Lukua 5 löytyi " + esiintymat3 + " kpl.");
    int esiintymat4 = laskeEsiintymat(lista4, "Koira"); IO.println("Merkkijonoa Koira löytyi " + esiintymat4 + " kpl.");
}

/**
 * Laskee etsittävän esiintymien määrän listassa.
 *
 * @param lista lista, josta etsitään
 * @param etsittava etsittävä arvo
 * @param <T> listan alkiotyyppi
 * @return esiintymien lukumäärä
 */
<T> int laskeEsiintymat(List<T> lista, T etsittava)
{
    int lkm = 0;
    for (T elem: lista)
    {
        if (elem.equals(etsittava)) lkm++;
    }
    return lkm;
}

/**
 * Kertoo, löytyykö etsittävä arvo listasta.
 *
 * @param lista lista, josta etsitään
 * @param etsittava etsittävä arvo
 * @param <T> listan alkiotyyppi
 * @return true jos löytyi, muuten false
 */
<T> boolean loytyyko(List<T> lista, T etsittava)
{
    for (T i : lista)
    {
        if (i.equals(etsittava)) return true;
    }
    return false;
}
