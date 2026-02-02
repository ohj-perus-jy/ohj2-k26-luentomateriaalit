/**
 * Puudeli, joka perii koiran ruokkimisen ja osaa myös juoda.
 */
public class Puudeli extends Koira implements Juotettava {
    /**
     * Yhteensä juotu määrä.
     */
    private int juonutYhteensa;

    /**
     * Luo puudelin annetulla nimellä.
     *
     * @param nimi puudelin nimi
     */
    public Puudeli(String nimi) {
        super(nimi);
        juonutYhteensa = 0;
    }

    /**
     * Juottaa puudelia ja palauttaa uuden kokonaismäärän.
     *
     * @param juomanMaara juoman määrä
     * @return tähän mennessä juotu määrä
     */
    @Override
    public int juota(int juomanMaara)
    {
        juonutYhteensa += juomanMaara;
        return  juonutYhteensa;
    }

    /**
     * Hoitaa puudelin ruokkimalla ja juottamalla.
     */
    @Override
    public void hoida() {
        super.hoida();
        IO.print("Juotetaan vielä " + getNimi() + ". ");
        juota(3);
        IO.print(getNimi() + " on juonut tänään: ");
        IO.println(juonutYhteensa + " desilitraa.");
    }
}
