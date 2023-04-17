import java.text.DecimalFormat;

public class Kleidung extends Artikel {

    private String typ;
    private String groesse;
    private String farbe;
    private double mehrwersteuer = 12;

    Kleidung(int artikelNummer, double preis, String typ,
             String groesse, String farbe) {
        super(artikelNummer, preis);
        this.typ = typ;
        this.farbe = farbe;
        this.groesse = groesse;
    }

    // Überschreiben der Methode aus der Oberklasse und übergabe der Informationen.
    String getInfo() {
        DecimalFormat nachKomma = new DecimalFormat("#0.00");
        return "Kleidung - " + typ + ", " + farbe + " (" + groesse + ") : " + nachKomma.format(Math.round((getPreis() * 100.0)) / 100.0) + " Euro";
    }

    // Überschreiben der Methode der Oberklasse.
    @Override
    double getPreis() {
        double brutto = ((mehrwersteuer + 100) * super.getPreis() / 100);
        return brutto;
    }
}
