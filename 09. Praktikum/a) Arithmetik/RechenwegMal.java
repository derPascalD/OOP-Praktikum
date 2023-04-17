public class RechenwegMal implements Rechenweg{

    @Override
    public double berechneErgebnis(double a, double b) {

        return Math.round((a*b*100.0)) / 100.0;
    }
}
