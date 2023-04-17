import java.util.ArrayList;
import java.text.*;

public class Warenkorb {

    private ArrayList<Artikel> warenkorb = new ArrayList<>();

    /**
     * FÜgt einen Artikel, in die Array Liste hinzu.
     */
    void addArtikel(Artikel artikel) {
        warenkorb.add(artikel);
    }

    /**
     * Löscht den Artikel aus der Array Liste.
     */
    void removeArtikel(Artikel artikel) {
        int counter = 0;

        for (Artikel eArtikel : warenkorb) {
            if (eArtikel == artikel) {
                warenkorb.remove(artikel);
                break;
            } else {
                counter++;

            }
        }
        if ( counter == warenkorb.size()) {
            System.out.println("Artikel befindet sich nicht im Warenkorb!\n");
        }
    }

    /**
     * In der Methode werden die einzelnen Artikel ausgegeben, mit dem dazugehörigen Bruttopreis.
     */
    void zeigeWarenkorb() {
        DecimalFormat nachKomma = new DecimalFormat("#0.00");
        double gesamtpreis = 0;
        for (Artikel eArtikel : warenkorb) {
            System.out.println(eArtikel.getInfo());
            gesamtpreis = gesamtpreis + Math.round((eArtikel.getPreis() * 100.0)) / 100.0;

        }
        if (warenkorb.size() == 0) {
            System.out.println("Warenkorb ist leer! Bitte fügen sie Artikel hinzu.\n");
        } else {

            // Ausgabe der Gesamtsumme ind Brutto
            System.out.println("Gesamtpreis: " + nachKomma.format(gesamtpreis) + " Euro\n");
        }
    }
}