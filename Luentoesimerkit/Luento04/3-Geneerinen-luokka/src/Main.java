/**
 * Esimerkkiohjelma, joka demonstroi geneerisen Pari-luokan käyttöä.
 */
void main()
{
    Pari<String, Integer> pari = new Pari<>("ikä", 25);
    IO.println("Eka: " + pari.getEka() + ", Toka: " + pari.getToka());

    List<String> ajLeffat = List.of("Terminator 2", "Inception", "Casino Royale");
    Pari<String, List<String>> lempileffat = new Pari<>("Antti-Jussi", ajLeffat);
    IO.println("Eka: " + lempileffat.getEka() + ", Toka: " + lempileffat.getToka());

    Pari<Double, Double> koordinaatit = new Pari<>(1.5, -4.5);
    IO.println("Eka: " + koordinaatit.getEka() + ", Toka: " + koordinaatit.getToka());
    Pari<Pari<Double, Double>, Pari<String, List<String>>> outo = new Pari<>(koordinaatit, lempileffat);
    IO.println("Eka: " + outo.getEka().getEka() + ", " + outo.getEka().getToka() + "; Toka: " + outo.getToka().getEka() + ", " + outo.getToka().getToka());


}
