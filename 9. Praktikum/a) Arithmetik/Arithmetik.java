public class Arithmetik {
    private Rechenweg rechnung;

    /**
     * In dieser Methode bekommt man ein Objekt als Parameter übergeben, was dann auch an die Klasse abgespeichert wird.
     */
    void bestimmeRechenweg(Rechenweg rechnung) {
        this.rechnung = rechnung;
    }

    /**
     * Hier werden zwei Double Parameter übergeben, die dann je nach Rechenweg berechnet werden können.
     */
    double berechne(double a, double b){

        return rechnung.berechneErgebnis(a,b);
    }
}
