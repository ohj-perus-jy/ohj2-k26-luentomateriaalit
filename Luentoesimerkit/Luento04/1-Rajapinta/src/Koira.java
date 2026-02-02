import java.util.ArrayList;
import java.util.List;

/**
 * Koira, joka voidaan ruokkia ja jonka hoito sisältää ruokkimisen.
 */
public class Koira extends Elain implements Ruokittava {

    /**
     * Päivän ruoat kiinteänä listana.
     */
    final String[] PAIVAN_RUUAT = {"nakki", "muusi", "pirtelö"};
    /**
     * Kuinka monta ruokaa on jo syöty.
     */
    int syotyjaRuokia;
    /**
     * Syödyt ruoat järjestyksessä.
     */
    List<String> syodyt;

    /**
     * Luo koiran annetulla nimellä.
     *
     * @param nimi koiran nimi
     */
    public Koira(String nimi) {
        super(nimi);
        syotyjaRuokia = 0;
        syodyt = new ArrayList<>();
    }

    /**
     * Lisää ruoan syötyjen listaan ja kasvattaa laskuria.
     *
     * @param ruoanNimi ruoan nimi
     */
    @Override
    public void ruoki(String ruoanNimi)
    {
        syodyt.add(ruoanNimi);
        syotyjaRuokia++;
    }

    /**
     * Hoitaa koiran ruokkimalla sen seuraavalla päivän ruualla.
     */
    @Override
    public void hoida()
    {
        IO.print("Syötetään " + getNimi() + ":lle " + PAIVAN_RUUAT[syotyjaRuokia]+". ");
        ruoki(PAIVAN_RUUAT[syotyjaRuokia]);
        IO.print(getNimi() + " on syönyt tänään: ");
        IO.println(syodyt);
    }
}
