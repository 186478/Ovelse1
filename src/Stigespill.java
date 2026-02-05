import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Stigespill {

    private final Brett brett;
    private final Terning terning;
    private final List<Spiller> spillere;
    private Spiller vinner;

    public Stigespill(String[] spillerNavn) {
        brett = new Brett();
        terning = new Terning();
        this.spillere = new ArrayList<>();

        for(String navn : spillerNavn) {
            spillere.add(new Spiller(navn, brett.getStartRute()));
        }
    }

    public void spill(){
        System.out.println("Spillet starter!");

        while (vinner == null) {
            for (Spiller spiller : spillere) {
                if (vinner == null) {
                    utforTrekk(spiller);
                }
            }
        }

        JOptionPane.showMessageDialog(null,"Gratulerer " + vinner.getNavn() + ", du vant!");
    }

    private void utforTrekk(Spiller spiller) {
        int kast = terning.trill();
        System.out.println(spiller.getNavn() + " triller: " + kast);

        if (kast == 6) {
            spiller.leggTilSekser();
            if (spiller.getAntallSekserePaRad() == 3) {
                håndterTreSeksere(spiller);
                return;
            }
        } else {
            spiller.nullstillSeksere();
        }

        flyttBrikke(spiller, kast);

        if (kast == 6 && vinner == null) {
            System.out.println(spiller.getNavn() + " fikk 6 og kaster igjen!");
            utforTrekk(spiller);
        }
    }

    private void flyttBrikke(Spiller spiller, int kast) {
        int currentNummer = spiller.getBrikke().getRute().getNummer();
        int nyttNummer = currentNummer + kast;

        if (nyttNummer > 100) {
            //javax.swing.JOptionPane.showMessageDialog(null, "For høyt kast! " + spiller.getNavn() + " blir stående på " + currentNummer);
            System.out.println("For høyt kast! " + spiller.getNavn() + " blir stående på " + currentNummer);
            return;
        }

        Rute landingsRute = brett.getRute(nyttNummer);
        Rute endeligRute = landingsRute.landPa();

        String bildeSti = "terningGif/" + kast + ".gif";
        javax.swing.ImageIcon terningIkon = new javax.swing.ImageIcon(bildeSti);

        Object[] options = {"Rull terningen!"};

        /*
        De kommenterte ut linjene er for å gjøre spillet mer interaktivt.
         */

        if (endeligRute.getNummer() < landingsRute.getNummer()) {
            System.out.println("Ops! " + spiller.getNavn() + " kastet en " + kast + " og sklir fra " + landingsRute.getNummer() + " til " + endeligRute.getNummer());
//            JOptionPane.showOptionDialog(null, "Ops! " + spiller.getNavn() + " kastet en " + kast + " og sklir fra " + landingsRute.getNummer() + " til " + endeligRute.getNummer(),
//                "Terningkast",
//                    JOptionPane.DEFAULT_OPTION,
//                    JOptionPane.INFORMATION_MESSAGE,
//                    terningIkon,
//                    options,
//                    options[0]);


        } else if (endeligRute.getNummer() > landingsRute.getNummer()) {
            System.out.println("Jippi! " + spiller.getNavn() + " kastet en " + kast + " og klatrer fra " + landingsRute.getNummer() + " til " + endeligRute.getNummer());

//            JOptionPane.showOptionDialog(null,"Jippi! " + spiller.getNavn() + " kastet en " + kast + " og klatrer fra " + landingsRute.getNummer() +  " til " + endeligRute.getNummer(),
//                    "Terningkast",
//                    JOptionPane.DEFAULT_OPTION,
//                    JOptionPane.INFORMATION_MESSAGE,
//                    terningIkon,
//                    options,
//                    options[0]);
        } else {
            System.out.println(spiller.getNavn() + " kastet en " + kast + " og lander på rute " + endeligRute.getNummer());
//            JOptionPane.showOptionDialog(null,
//                    spiller.getNavn() + " kastet en " + kast + " og lander på rute " + endeligRute.getNummer(), // Melding
//                    "Terningkast",
//                    JOptionPane.DEFAULT_OPTION,
//                    JOptionPane.INFORMATION_MESSAGE,
//                    terningIkon,
//                    options,
//                    options[0]);
        }

        spiller.getBrikke().setRute(endeligRute);

        if (endeligRute.getNummer() == 100) {
            vinner = spiller;
        }
    }

    private void håndterTreSeksere(Spiller spiller) {
        System.out.println("Oisann! Tre seksere på rad:( " + spiller.getNavn() + " må til rute 1 og starte på nytt!");
        spiller.getBrikke().setRute(brett.getStartRute());
        spiller.nullstillSeksere();
    }
}
