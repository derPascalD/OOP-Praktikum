import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

abstract class Datenverarbietung {
    //cluster
    protected double[][] cluster1 = new double[50][4];
    protected double[][] cluster2 = new double[50][4];
    protected double[][] cluster3 = new double[50][4];

    /**
     * Hier werden die einzelnen Prozesse durchgeführt, wie Datei einlesen berechnen und abspeichern, sowie
     * das Ausgeben der Werte.
     */
    public final void ladenVerarbeitenSpeichern(String dateiName) {
        ladeDaten(dateiName);

        berechneMittelwert(cluster1);
        berechneMittelwert(cluster2);
        berechneMittelwert(cluster3);

        double w1 = berechneAbstand(berechneMittelwert(cluster1), berechneMittelwert(cluster2));
        double w2 = berechneAbstand(berechneMittelwert(cluster1), berechneMittelwert(cluster3));
        double w3 = berechneAbstand(berechneMittelwert(cluster2), berechneMittelwert(cluster3));

        ausgabeWert(w1, w2, w3);
    }

    /**
     * Methode die andere Klassen implementieren können und mit Inhalt füllen.
     */
    public abstract double berechneAbstand(double[] x1, double[] x2);


    /**
     * Werden die 4 Mittelwerte vom Inhalt des Clusters errechnet.
     * Jeweils 100 Werte die zusammengerechnet werden, um dann einen Mittelwert zu berechnen.
     */
    public double[] berechneMittelwert(double[][] cluster) {
        double[] mittelwert = new double[4];
        int zaehler = 0;
        for (int i = 0; i < cluster[i].length; i++) {
            for (double[] doubles : cluster) {
                mittelwert[zaehler] = mittelwert[zaehler] + doubles[i];
            }
            mittelwert[zaehler] = (mittelwert[zaehler] / cluster.length);
            zaehler++;
        }
        return mittelwert;
    }

    /**
     * Hier lade ich Daten aus einer Datei in lade es in 3 verschiedene Cluster.
     */
    public void ladeDaten(String dateiName) {
        List<String> temp = new ArrayList<>();

        Path path = Paths.get(dateiName);

        // Überprüfung, ob die Datei existiert.
        if (Files.exists(path)) {

        } else {

            System.out.println("Datei existiert nicht.");
            System.exit(0);
        }

        try {
            temp =  Files.readAllLines(path);

            if (cluster1.length == 1 ){
                System.out.println("Datei ungueltig!");
                System.exit(0);
            }

        } catch (IOException e) {
            System.out.println("Datei konnte nicht bearbeitet und hinzugefuegt werden.");
        }
        for (int i = 0; i < temp.size(); i++) {
            double[] arrayd = new double[4];
            String[] array = temp.get(i).split(",");
            for (int j = 0; j < 4; j++) {
                try{
                    arrayd[j] = Double.parseDouble(((array[j])));
                } catch(Exception ignored){
                }

            }
            if(i < 50){
                cluster1[i] = arrayd;
            }else if(i < 100){
                cluster2[i-50] = arrayd;
            }else if(i < 150){
                cluster3[i-100] = arrayd;
            }
        }

    }

    /**
     * Hier gebe ich die Abstände in der Konsole aus.
     */
    public void ausgabeWert(double ergebnis1, double ergebnis2, double ergebnis3){
        System.out.println("Ergebnis fuer " + this.getClass().getName() + ":");
        System.out.printf("d(cluster1, cluster2) = %.2f", ergebnis1);
        System.out.println();
        System.out.printf("d(cluster1, cluster3) = %.2f", ergebnis2);
        System.out.println();
        System.out.printf("d(cluster2, cluster3) = %.2f", ergebnis3);
        System.out.println("\n");
    }
}
