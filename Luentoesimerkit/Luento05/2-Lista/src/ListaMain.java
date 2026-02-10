import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lista<T> {
    private T[] taulukko;
    private int koko;

    public Lista() {
        //noinspection unchecked
        taulukko = (T[]) new Object[5];
        koko = 0;
    }

    void add(T e) {
        if (koko > taulukko.length) {
            // taulukkoon ei mahdu uusia alkioita
            // 1. luodaan suurempi taulukkio
            // 2. kopioidaan vanhat alkiot uuteen taulukkoon
        }
        taulukko[koko] = e;
        koko++;
    }

    int size() {
        return koko;
    }

    void set(int i, T e) {
        if (i < 0 || i > koko) {
            // VIRHE
        }
        taulukko[i] = e;
    }

    T get(int i) {
        if (i < 0 || i > koko) {
            // VIRHE
        }
        return taulukko[i];
    }
}

void main() {
    Lista<String> jonoja = new Lista<>();
    jonoja.add("Teksti");
    jonoja.add("Teksti 2");
    IO.println(jonoja.get(0));
    IO.println(jonoja.get(1));

    List<String> paikat = new LinkedList<>();
    paikat.add("Madeira");
    paikat.add("La Palma");
    paikat.add("El Hierro");

    IO.println(paikat);

    paikat.remove("La Palma");

    paikat.add(0, "Fuerteventura");

    IO.println(paikat);

    paikat.remove(1);

    IO.println(paikat);

    IO.println(paikat.get(0));

    for (String paikka : paikat) {
        IO.println(paikka);
    }
}