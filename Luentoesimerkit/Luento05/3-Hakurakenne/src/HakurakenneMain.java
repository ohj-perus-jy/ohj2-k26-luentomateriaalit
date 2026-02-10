import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

void main() {
    Map<String, Integer> arvosanat = new TreeMap<>();
    arvosanat.put("Matti", 3);
    arvosanat.put("Teppo", 5);
    arvosanat.put("Kalle", 2);
    arvosanat.put("Seppo", 5);

    IO.println(arvosanat);

//    arvosanat.put("Matti", 1);
    arvosanat.replace("Matti", 3);

    IO.println(arvosanat.get("Teppo"));

    arvosanat.remove("Matti");

    IO.println(arvosanat);

    for (Map.Entry<String, Integer> arvo : arvosanat.entrySet()) {
        IO.println(arvo.getKey() + " => " + arvo.getValue());
    }

}