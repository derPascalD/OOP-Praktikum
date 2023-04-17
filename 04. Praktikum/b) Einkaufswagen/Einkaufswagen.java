import java.util.ArrayList;

public class Einkaufswagen {

    private ArrayList<String> liste = new ArrayList<String>();

    /**
     * Sorgt dafür, das Elemente in das Array hinzugefügt werden.
     * Überprüft gleichzeitig wie viele Elemente im Array sind.
     */
    public void addToCart(String item) {
        if (liste.size() == 5) {

            System.out.println("Bitte entfernen sie einen Artikel aus dem Einkaufswagen.");
            System.out.println("Es koennen nur maximal 5 Artikel im Einkaufswagen liegen.");

        } else {
            liste.add(item);
        }
    }

    /**
     * Sorgt dafür, das Elemente aus der Array Liste gelöscht werden.
     */
    public void removeFromCart(String item) {

        // Hier wird überprüft ob der Artikel im Einkaufswagen ist.
        int counter = 0;
        for (int i = 0; i < liste.size(); i++) {

            if (item == liste.get(i)) {
                counter = 1;
            }
        }

        // Hier wird der Artikel gelöscht oder Ausgabe den Artikel gibt es nicht
        if (counter == 0) {
            System.out.println("");
            System.out.println("Der Artikel befindet sich nicht im Einkaufswagen und kann\nnicht geloescht werden.");
            System.out.println("");
        } else {
            liste.remove(item);
        }
    }

    /**
     * Damit kann man die aktuelle Anzahl ausgeben lassen.
     */
    public void size() {

        System.out.println("Anzahl der Artikel im Einkaufswagen: " + liste.size());
        System.out.println("");
    }

    /**
     * Hiermit rufe ich die Elemente im Array auf und gebe sie in der Konsole aus.
     */
    public void showContent() {

        for (int i = 0; i < liste.size(); i++) {
            System.out.println("Artikel: " + liste.get(i));
        }
        System.out.println("");
    }
}
