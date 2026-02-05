import java.util.Random;

/**
 * @Author Gruppe 68 (Teodor, Mats, Bashar, Alex, Andreas)
 * Klassen Terning for å få verdien av terningen
 */

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
