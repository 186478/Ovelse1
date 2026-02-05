import java.util.Random;

public class Terning {

    private int verdi;
    private final Random random;

    public Terning() {
        this.random = new Random();
        this.verdi = 1;
    }

    public int trill() {
        this.verdi = random.nextInt(6) + 1;
        return verdi;
    }
    public int getVerdi() {
        return verdi;
    }
}
