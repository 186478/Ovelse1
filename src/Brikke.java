/**
 * @Author Gruppe 68 (Teodor, Mats, Bashar, Alex, Andreas)
 * Klassen brikke for brikkene i stigespillet
 */

public class Brikke {

    private Rute rute;

    public Brikke(Rute startRute) {
        this.rute = startRute;
    }

    public Rute getRute() {
        return rute;
    }

    public void setRute(Rute rute) {
        this.rute = rute;
    }

}
