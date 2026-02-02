/**
 * Kissa, jota voidaan juottaa ja jonka hoito sisältää juottamisen.
 */
public class Kissa extends Elain implements Juotettava {

    /**
     * Yhteensä juotu määrä.
     */
    private int juonutYhteensa;

    /**
     * Luo kissan annetulla nimellä.
     *
     * @param nimi kissan nimi
     */
    public Kissa(String nimi) {
        super(nimi);
        juonutYhteensa = 0;
    }

    /**
     * Juottaa kissaa ja palauttaa uuden kokonaismäärän.
     *
     * @param juomanMaara juoman määrä
     * @return tähän mennessä juotu määrä
     */
    @Override
    public int juota(int juomanMaara){
        juonutYhteensa += juomanMaara;
        return juonutYhteensa;
    }

    /**
     * Hoitaa kissan juottamalla sille maitoa.
     */
    @Override
    public void hoida() {
        IO.print("Hoidetaan kissaa " + getNimi() + " juottamalla sille maitoa.");
        juota(1);
        IO.println(getNimi() + " on juonut tänään " + juonutYhteensa + " maitoa.");
    }
}
