/**
 * LahjakorttiMaksu on maksutapa, jossa maksaminen
 * vähentää lahjakortin saldoa.
 */
public class LahjakorttiMaksu extends Maksutapa {

    private int saldoSentteina;

    public LahjakorttiMaksu(int alkuSaldoSentteina) {
        super("Lahjakortti");
        this.saldoSentteina = alkuSaldoSentteina;
    }

    @Override
    protected MaksuTulos suoritaMaksu(MaksuPyynto pyynto) {
        if (saldoSentteina < pyynto.summaSentteina()) {
            // Jos haluttaisiin käyttää tehdasmetodia:
            // return MaksuTulos.epaonnistui("Saldo ei riitä");
            return new MaksuTulos(false, "Saldo ei riitä", null);
        }
        saldoSentteina -= pyynto.summaSentteina();
        //return MaksuTulos.onnistui("GIFT-" + pyynto.viite());
        return new MaksuTulos(true, null, "GIFT-" + pyynto.viite());
    }
}
