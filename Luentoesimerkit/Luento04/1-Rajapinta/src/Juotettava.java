/**
 * Rajapinta eläimille, joita voidaan juottaa.
 */
public interface Juotettava {
    /**
     * Juottaa eläintä annetulla määrällä.
     *
     * @param juomanMaara juoman määrä
     * @return tähän mennessä juotu määrä
     */
    int juota(int juomanMaara);
}
