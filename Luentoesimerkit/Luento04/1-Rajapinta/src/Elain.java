public abstract class Elain {
    private final String nimi;

    public Elain(String nimi){
        this.nimi=nimi;
    }

    public String getNimi(){
        return nimi;
    }

    public abstract void hoida();
}
