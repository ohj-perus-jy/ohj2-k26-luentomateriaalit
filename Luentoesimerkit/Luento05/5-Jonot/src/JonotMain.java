import java.util.Deque;
import java.util.LinkedList;

public class Tehtava {
    private String tehtava;

    public Tehtava(String tehtava) {
        this.tehtava = tehtava;
    }

    public void tee() {
        IO.println("Tein tehtävän: " + tehtava);
    }

    @Override
    public String toString() {
        return tehtava;
    }
}

void main() {
    Deque<Tehtava> tehtavat = new LinkedList<>();
    tehtavat.add(new Tehtava("Herää"));
    tehtavat.add(new Tehtava("Pese hampaat"));
    tehtavat.add(new Tehtava("Tee aamupala"));
    tehtavat.add(new Tehtava("Syö aamupala"));
    tehtavat.add(new Tehtava("Mene kouluun"));

    while (!tehtavat.isEmpty()) {
        Tehtava tehtavaNyt = tehtavat.remove();
        tehtavaNyt.tee();
    }
    IO.println(tehtavat);


    Deque<String> kortit = new LinkedList<>();
    kortit.push("Sininen 4");
    kortit.push("Keltainen 4");
    kortit.push("Keltainen 5");
    kortit.push("Punainen 5");

    while (!kortit.isEmpty()) {
        String pallimmainenKortti = kortit.pop();
        IO.println(pallimmainenKortti);
    }
}