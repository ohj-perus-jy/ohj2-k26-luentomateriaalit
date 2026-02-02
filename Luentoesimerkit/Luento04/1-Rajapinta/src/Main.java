void main()
{
    Elain katti = new Kissa("Katti");
    Elain rekku = new Koira("Rekku");
    Elain puudeli = new Puudeli("Nuudeli");
    List<Elain> elaimet = List.of(katti, rekku, puudeli);
    for (Elain e : elaimet) e.hoida();
}