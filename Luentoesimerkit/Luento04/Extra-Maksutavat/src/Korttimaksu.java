/**
 * Korttimaksu on maksutapa, jossa maksu tehdään kortilla.
 *
 * Korttimaksulla pidetään kirjaa katevarauksesta,
 * jota voidaan myöhemmin mahdollisesti hyvittää.
 */
public class Korttimaksu extends Maksutapa implements Hyvitettava {

    /** Yksinkertainen esimerkkitila: paljonko on vielä "hyvitettävää" */
    private int katevarausSentteina = 0;

    public Korttimaksu() {
        super("Kortti");
    }

    @Override
    protected MaksuTulos suoritaMaksu(MaksuPyynto pyynto) {
        katevarausSentteina = pyynto.summaSentteina();
        //return MaksuTulos.onnistui("CARD-" + pyynto.viite());
        return new MaksuTulos(true, null, "CARD-"+ pyynto.viite());
    }

    @Override
    public MaksuTulos hyvita(String tapahtumaId, int summaSentteina) {
        if (summaSentteina <= 0) {
            return new MaksuTulos(false, "Hyvityssumma ei kelpaa", null);
        }
        if (summaSentteina > katevarausSentteina) {
            return new MaksuTulos(false, "Hyvityssumma ylittää katevarauksen", null);
        }

        katevarausSentteina -= summaSentteina;
        return new MaksuTulos(true, null, "REF-" + tapahtumaId);
    }
}
