import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Høyreklikk test mappen og trykk "Run all test" for å kjøre testene
 * tester for funksjonene i Stigespill.java
 * @Author Gruppe 68 (Teodor, Mats, Bashar, Alex, Andreas)
 */

public class StigespillTest {

    private Stigespill spill;
    private Spiller spiller1;

    @BeforeEach
    void setUp() {
        String[] navn = {"Teo", "Mats", "Bashar", "Alex"};
        spill = new Stigespill(navn);
        spiller1 = spill.getSpillere().get(0);
    }

    @Test
    void testNoyaktig100() {
        Rute rute99 = spill.getBrett().getRute(99);
        spiller1.getBrikke().setRute(rute99);

        spill.flyttBrikke(spiller1, 3);

        assertEquals(99, spiller1.getBrikke().getRute().getNummer(),
                "Spilleren skal stå stille hvis terningkastet fører dem forbi rute 100.");

    }

    @Test
    void testStigeOgSlange() {
        Brett brett = new Brett();
        Rute rute8 = brett.getRute(8);
        assertEquals(27, rute8.landPa().getNummer(), "Rute 8 skal være stige til 27");

        Rute rute24 = brett.getRute(24);
        assertEquals(3, rute24.landPa().getNummer(), "Rute 24 skal være slange til 3");
    }

    @Test
    void testTreSeksereTilStart() {
        spiller1.getBrikke().setRute(spill.getBrett().getRute(50));
        spill.håndterTreSeksere(spiller1);

        assertEquals(1, spiller1.getBrikke().getRute().getNummer(),
                "Spilleren skal bli sendt til startruten");
    }

    @Test
    void testNullstillSeksere() {
        spiller1.leggTilSekser();
        assertEquals(1, spiller1.getAntallSekserePaRad());

        spiller1.nullstillSeksere();
        assertEquals(0, spiller1.getAntallSekserePaRad(),
                "Sekser-telleren skal nullstilles");
    }
}