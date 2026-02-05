import java.util.ArrayList;
import java.util.List;

public class Brett {

    private final List<Rute> ruter;
    private static final int antallRuter = 100;

    public Brett() {
        this.ruter = new ArrayList<>();
        genererRuter();
        opprettSlangerOgStiger();
    }

    private void genererRuter() {
        for (int i = 1; i <= antallRuter; i++) {
            ruter.add(new Rute(i));
        }
    }

    private void opprettSlangerOgStiger() {
        //stiger
        getRute(1).setFlyttTil(getRute(39));
        getRute(8).setFlyttTil(getRute(27));
        getRute(25).setFlyttTil(getRute(47));
        getRute(46).setFlyttTil(getRute(62));
        getRute(49).setFlyttTil(getRute(79));
        getRute(65).setFlyttTil(getRute(91));
        getRute(86).setFlyttTil(getRute(96));

        //slanger
        getRute(24).setFlyttTil(getRute(3));
        getRute(69).setFlyttTil(getRute(34));
        getRute(78).setFlyttTil(getRute(15));
        getRute(98).setFlyttTil(getRute(85));
        getRute(89).setFlyttTil(getRute(70));
        getRute(41).setFlyttTil(getRute(2));

    }

    public Rute getRute(int nummer) {
        if (nummer < 1 || nummer > antallRuter) {
            return null;
        }
        return ruter.get(nummer - 1);
    }

    public Rute getStartRute() {
        return getRute(1);
    }

}
