public class Abstand1 extends Datenverarbietung{
    @Override
    /**
     * hier wird der Abstand der Cluster berechnet und gibt eine Summe zurück.
     */
    public double berechneAbstand(double[] x1, double[] x2) {
        double summe = 0;

        // Vergleicht die Array Laengen mit einanden
        if (x1.length != x2.length) {
            System.out.println("Array laengen passen nicht zueinander");
            System.exit(0);
            return 0;
        } else {
            for (int i = 0; i < x1.length; i++) {
                summe = summe + Math.pow((x1[i] - x2[i]),2);
            }
            return Math.sqrt(summe);
        }
    }
}
