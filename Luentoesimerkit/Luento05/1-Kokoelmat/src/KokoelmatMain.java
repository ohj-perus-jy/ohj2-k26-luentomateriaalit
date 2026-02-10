import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

double summa(Collection<? extends Number> lukuja) {
    double tulos = 0.0;
    for (Number luku : lukuja) {
        tulos += luku.doubleValue();
    }
    return tulos;
}

void main() {
    Collection<Integer> lukuja = new ArrayList<>();
    lukuja.add(5);
    lukuja.add(5);
    lukuja.add(10);
    lukuja.add(42);

    lukuja.remove(5);

    IO.println(lukuja.contains(10));

    for (int luku : lukuja) {
        IO.println(luku);
    }

    IO.println(lukuja);

    IO.println(summa(lukuja));
}