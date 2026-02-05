import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Velkommen til Stigespillet!");
        String antallInput = JOptionPane.showInputDialog(null, "Hvor mange skal spille? (2-4):");
        int antallSpillere = Integer.parseInt(antallInput);


        if (antallSpillere < 2 || antallSpillere > 4) {
            JOptionPane.showMessageDialog(null, "Feil: Antall spillere må være 2-4. Avsultter.");
            return;
        }

        String[] navn = new String[antallSpillere];
        for (int i = 0; i < antallSpillere; i++) {
            navn[i] = JOptionPane.showInputDialog(null, "Navn på spiller " + (i + 1) + ":");
        }

        Stigespill spill = new  Stigespill(navn);
        spill.spill();
    }

}
