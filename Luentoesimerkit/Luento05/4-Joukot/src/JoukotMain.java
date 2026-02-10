import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

void main() {
    Set<String> paikkoja = new LinkedHashSet<>();
    paikkoja.add("La Palma");
    paikkoja.add("Gran Canaria");
    paikkoja.add("El Hierro");

    IO.println(paikkoja.contains("La Palma"));
    IO.println(paikkoja.contains("Fuerteventura"));

    IO.println(paikkoja);
}