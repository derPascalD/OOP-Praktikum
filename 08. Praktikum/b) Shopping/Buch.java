import java.text.DecimalFormat;

public class Buch extends Artikel{

    private String autorennamen;
    private String buchtitel;
    private int erscheinungsjahr;

    private double mehrwersteuer = 17;

    Buch(int artikelNummer, double preis, String autorennamen,
         String buchtitel, int erscheinungsjahr) {
        super(artikelNummer, preis);
        this.autorennamen = autorennamen;
        this.buchtitel = buchtitel;
        this.erscheinungsjahr = erscheinungsjahr;

    }
    // Überschreiben der Methode aus der Oberklasse und übergabe der Informationen.
    String getInfo() {
        DecimalFormat nachKomma = new DecimalFormat("#0.00");
        return "Buch - " + autorennamen + ", " + buchtitel + " (" +erscheinungsjahr+") : "+ nachKomma.format((Math.round((getPreis()*100.0)) / 100.0)) + " Euro" ;
    }
    // Überschreiben der Methode der Oberklasse.
    @Override
    double getPreis() {
        double brutto = ((mehrwersteuer+100)*super.getPreis()/100);
        return brutto;
    }
}
