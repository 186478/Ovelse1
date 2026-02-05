/**
 * @Author Gruppe 68 (Teodor, Mats, Bashar, Alex, Andreas)
 * Klassen Rute for alle rutene på brettet
 * med funksjonene flyttTil og landPa
 */

public class Rute {

    private final int nummer;
    private Rute flyttTil;

    public Rute(int nummer) {
        this.nummer = nummer;
        this.flyttTil = null;
    }
    public int getNummer() {
        return nummer;
    }

    public void setFlyttTil(Rute flyttTil) {
        this.flyttTil = flyttTil;
    }

    public Rute landPa() {
        if (flyttTil != null) {
            return flyttTil;
        }
        return this;
    }
}