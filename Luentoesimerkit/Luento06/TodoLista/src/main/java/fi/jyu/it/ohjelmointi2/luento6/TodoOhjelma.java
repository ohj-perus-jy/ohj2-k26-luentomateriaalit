package fi.jyu.it.ohjelmointi2.luento6;

import fi.jyu.it.ohjelmointi2.luento6.data.Tehtava;
import fi.jyu.it.ohjelmointi2.luento6.util.SyoteException;
import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class TodoOhjelma {
    Map<String, Runnable> komennot = Map.of(
            "uusi", this::uusiTehtava,
            "listaa", this::listaaTehtavat,
            "tehty", this::merkitseTehdyksi,
            "sulje", () -> System.exit(0),
            "apua", this::apua
    );

    List<Tehtava> tehtavat = new ArrayList<>();

    Path todoTiedosto = Path.of("todot.json");

    int kysyPrioriteetti() throws SyoteException {
        String prio = IO.readln("Anna prioriteetti (luku 0-100) > ");
        int prioriteetti = Integer.parseInt(prio);
        if (prioriteetti < 0 || prioriteetti > 100) {
            throw new SyoteException("Syötteen on oltava välillä 0-100");
        }
        return prioriteetti;
    }

    void uusiTehtava() {
        String tehtavanNimi = IO.readln("Anna tehtävän nimi > ");

        int prioriteetti;
        while (true) {
            try {
                prioriteetti = kysyPrioriteetti();
                break;
            } catch (NumberFormatException e) {
                IO.println("Anna prioriteetti kokonaislukuna!");
            } catch (SyoteException e) {
                IO.println(e.getMessage());
            }
        }

        Tehtava uusiTehtava = new Tehtava(tehtavanNimi, prioriteetti);
        tehtavat.add(uusiTehtava);
        IO.println("Tehtävä '" + uusiTehtava + "' lisätty!");
        tallenna();
    }

    void merkitseTehdyksi() {
        String tehtavaNimi = IO.readln("Mikä tehtävä tuli tehdyksi > ").trim().toLowerCase();

        Optional<Tehtava> tulos = tehtavat.stream()
                .filter(t -> !t.onkoTehty())
                .filter(t -> t.getTehtava().toLowerCase().startsWith(tehtavaNimi))
                .findFirst();

        if (tulos.isEmpty()) {
            IO.println("Hakusanalla '" + tehtavaNimi + "' ei löytynyt yhtään tehtävää.");
            return;
        }

        Tehtava tehtava = tulos.get();
        tehtava.merkitseTehdyksi();
        IO.println("Tehtävä tehty: " + tehtava);

        tallenna();
    }

    void listaaTehtavat() {
        IO.println("Tekemättä olevat tehtävät:");
        tehtavat.stream()
                .filter(t -> !t.onkoTehty())
                .sorted(Comparator.comparing(Tehtava::getPrioriteetti).reversed()
                        .thenComparing(Tehtava::getTehtava))
                .forEach(IO::println);

        IO.println("Tehdyt tehtävät:");
        tehtavat.stream()
                .filter(Tehtava::onkoTehty)
                .sorted(Comparator.comparing(Tehtava::getPrioriteetti).reversed()
                        .thenComparing(Tehtava::getTehtava))
                .forEach(IO::println);
    }

    void apua() {
        IO.println("Kaikki saatavilla olevat komennot:");
        komennot.keySet().forEach(IO::println);
    }

    void lueTiedostosta() {
        if (Files.notExists(todoTiedosto)) {
            return;
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            tehtavat = new ArrayList<>(mapper.readValue(todoTiedosto, new TypeReference<List<Tehtava>>() { }));
        } catch (JacksonException e) {
            IO.println("VIRHE: Todo-tiedostoa ei voitu lukea!");
        }
    }

    void tallenna() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(todoTiedosto, tehtavat);
    }

    void main() {
        lueTiedostosta();
        IO.println("Mun hieno TODO-listasovellus!");
        IO.println("Anna komento! Aloita kirjoittamalla 'apua'!");

        //noinspection InfiniteLoopStatement
        while (true) {
            String komento = IO.readln("> ").trim();
            if (komennot.containsKey(komento)) {
                Runnable komentoNyt = komennot.get(komento);
                komentoNyt.run();
            } else {
                IO.println("Tuntematon komento. Saat kaikki komennot näkyville 'apua'-komennolla!");
            }
        }
    }
}
