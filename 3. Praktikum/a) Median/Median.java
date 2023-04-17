import java.util.Arrays;

public class Median {
    // Ist zum Speichern von "0" under "1".
    private int geradeUngerade;

    // Hier wird der Medianwert abgespeichert.
    private int x;

    /**
     * Die Methode sorgt dafür das durch eine Formel der Medianwert eines Arrays berechnet
     */
    public int median(int[] array) {

        if (array.length == 0 || array == null) {
            System.out.println("Array ist leer.");
            System.exit(0);
        }

        //Sortiert den Inhalt meines Arrays und setzt vorne die kleinste Zahl und dann immer die nächst größere.
        Arrays.sort(array);

        // Hier wird 0 oder 1 abgespeichert durch die Formel
        geradeUngerade = array.length % 2;

        /*
         Hier wird unterschieden ob geradeUngerade "1" oder "0" ist.
         Je nachdem ob "1" oder "0" wird eine ander Formel angewendet.
         */
        if (geradeUngerade == 0) {
            x = (array[array.length / 2] + array[array.length / 2 - 1]) / 2;
        } else if (geradeUngerade == 1) {
            x = (array[(array.length - 1) / 2]);
        }
        return x;
    }
}
