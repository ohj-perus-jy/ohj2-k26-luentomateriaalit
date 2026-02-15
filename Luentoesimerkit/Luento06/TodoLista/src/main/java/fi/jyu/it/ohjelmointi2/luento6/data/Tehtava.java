package fi.jyu.it.ohjelmointi2.luento6.data;

import java.time.LocalDateTime;

public class Tehtava {
    private String tehtava;
    private LocalDateTime tehtyPvm;
    private int prioriteetti;

    public Tehtava() {
        tehtava = null;
        tehtyPvm = null;
        prioriteetti = 0;
    }

    public Tehtava(String tehtava, int prioriteetti) {
        this.tehtava = tehtava;
        this.prioriteetti = prioriteetti;
    }

    public String getTehtava() {
        return tehtava;
    }

    public LocalDateTime getTehtyPvm() {
        return tehtyPvm;
    }

    public int getPrioriteetti() {
        return prioriteetti;
    }

    public boolean onkoTehty() {
        return tehtyPvm != null;
    }

    public void merkitseTehdyksi() {
        this.tehtyPvm = LocalDateTime.now();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('P');
        sb.append(prioriteetti);
        sb.append(": ");
        sb.append(tehtava);
        if (onkoTehty()) {
            sb.append(" (TEHTY: ");
            sb.append(tehtyPvm);
            sb.append(")");
        }
        return sb.toString();
    }
}
