import java.text.DecimalFormat;

public class DVD extends Artikel{

    private String filmtitel;
    private String dauer;

    private double mehrwersteuer = 19;

    DVD(int artikelNummer, double preis, String filmtitel, String dauer) {
        super(artikelNummer, preis);
        this.filmtitel = filmtitel;
        this.dauer = dauer;
    }
    // Überschreiben der Methode aus der Oberklasse und übergabe der Informationen.
    String getInfo() {
        DecimalFormat nachKomma = new DecimalFormat("#0.00");
        return "DVD - " + filmtitel +  " (" +dauer+") : "+ nachKomma.format(Math.round((getPreis()*100.0)) / 100.0) + " Euro" ;
    }
    // Überschreiben der Methode der Oberklasse.
    @Override
    double getPreis() {
        double brutto = ((mehrwersteuer+100)*super.getPreis()/100);
        return brutto;
    }
}
