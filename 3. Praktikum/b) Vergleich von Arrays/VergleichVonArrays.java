public class VergleichVonArrays {

    /**
     * In dieser Methode habe ich eine Formel entwickelt, wo ich berechnen kann,
     * ob die Werte der beiden Arrays gleich zueinander sind.
     */
    boolean isEqual(int[] a, int[] b) {

        // Im ersten Schritt schaue ich ob Werte in den Arrays gegeben sind.
        if (a.length == 0 || a == null || b.length == 0 || b == null) {

            // Wenn keine Werte gegeben sind, gibt es eine Ausgabe und das Programm ist zu Ende.
            System.out.println("Eins von den Arrays ist leer.");
            System.exit(0);
        }

        // Sind dafür einen Wert zu speichern der sich beim Vergleichen der Arrays errechnet.
        int anZahlA = 0;
        int anZahlB = 0;

        //Sind dafür den Inhalt des jeweiligen Arrays durch eine addition zu speichern.
        int summeA = 0;
        int summeB = 0;

        // Die Zwei for Schleifen rechnen durch eine addition den Inhalt des Arrays aus.
        for (int i = 0; i < b.length; i++) {

            summeB = summeB + b[i];
        }
        for (int i = 0; i < a.length; i++) {
            summeA = summeA + a[i];
        }

        // Hier wird geschaut, ob die Arrays gleich lang sind und ob die Summe der beiden Arrays gleich ist.
        if (a.length == b.length && summeA == summeB) {

            // Hier vergleiche ich das erste Array mit dem zweiten Array
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b.length; j++) {

                        /*
                        Wen es eine übereinstimmung gibt. Rechne ich die zwei Zahlen zusammen und addiere sie zu
                        der Variable hinzu.
                        */
                    if (a[i] == b[j]) {
                        anZahlA = anZahlA + (a[i] + b[j]);
                    }
                }
            }

            // Hier vergleiche ich das erste Array mit dem zweiten Array
            for (int i = 0; i < b.length; i++) {
                for (int j = 0; j < a.length; j++) {

                        /*
                        Wen es eine übereinstimmung gibt. Rechne ich die zwei Zahlen zusammen und addiere sie zu
                        der Variable hinzu.
                        */
                    if (a[j] == b[i]) {
                        anZahlB = anZahlB + (a[j] + b[i]);
                    }
                }
            }
            // Sollten die beiden Variablen den gleichen Wert haben, wird ein true ausgegeben, ansonsten false.
            if (anZahlA == anZahlB) {
                return true;
            }
        }
        return false;
    }
}
