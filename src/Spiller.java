public class Spiller {

    private final String navn;
    private final Brikke brikke;
    private int antallSekserePaRad;

    public Spiller(String navn, Rute startRute) {
        this.navn = navn;
        this.brikke = new Brikke(startRute);
        this.antallSekserePaRad = 0;
    }

    public String getNavn() {
        return navn;
    }

    public Brikke getBrikke() {
        return brikke;
    }

    public int getAntallSekserePaRad() {
        return antallSekserePaRad;
    }

    public void leggTilSekser() {
        this.antallSekserePaRad++;
    }

    public void nullstillSeksere() {
        this.antallSekserePaRad = 0;
    }
}
