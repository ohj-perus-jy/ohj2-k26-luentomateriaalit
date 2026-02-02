/**
 * Rajapinta eläimille, joita voidaan ruokkia.
 */
public interface Ruokittava {
    /**
     * Ruokkii eläimen annetulla ruoalla.
     *
     * @param ruoanNimi ruoan nimi
     */
    void ruoki(String ruoanNimi);
}
