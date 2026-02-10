import java.util.Deque;
import java.util.LinkedList;

class Kehys {
    int n;
    int valitulos;

    Kehys(int n, int valitulos) {
        this.n = n;
        this.valitulos = valitulos;
    }
}

int kertomaOptimoitu(int n) {
    Kehys nyt = new Kehys(n, 1);

    while (true) {
        if (nyt.n == 1) {
            return nyt.valitulos;
        }
        nyt.valitulos = nyt.n * nyt.valitulos;
        nyt.n--;
    }
}

int kertoma(int n) {
    if (n == 1) return 1;
    return n * kertoma(n - 1);
}



int kertomaPinolla(int n) {
    Deque<Integer> kutsupino = new LinkedList<>();

    while (true) {
        if (n == 1) {
            kutsupino.push(1);
            break;
        }
        kutsupino.push(n);
        n = n - 1;
    }

    int tulos = kutsupino.pop();
    while (!kutsupino.isEmpty()) {
        tulos = tulos * kutsupino.pop();
    }

    return tulos;
}

void main() {
    IO.println(kertoma(5));
    IO.println(kertomaPinolla(5));
    IO.println(kertomaOptimoitu(5));
}