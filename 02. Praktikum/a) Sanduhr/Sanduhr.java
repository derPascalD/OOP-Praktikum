public class Sanduhr {
    public static void main(String[] args) {

        // Hier übergibt man der Methode einen Parameter, der dann in der Methode verarbeitet wird
        printSanduhr(5);
    }

    /**
     * In dieser Methode wird ein Algorithmus ausgeführt, wo immer wieder geschaut wird welche Bedingungen erfüllt sind
     * und dann eben ausgeführt werden.
     *
     * @param width
     */
    public static void printSanduhr(int width) {

        if ( width <= 2) {
            System.out.println("Bitte eine Zahl eintragen die groeßer als 2 ist.");
        } else {

        // Hier werden die Sterne abgespeichert die als erstes ausgegeben werden sollen
        int anzahlSterne = width;

        /*
         Hier wird geschaut, ob die Zahl einen Restwert hat.
         0 oder 1 abgespeichert.
         Zahl Gerade oder ungerade ist.
         */
        int nullOderEins = width % 2;

        // Die Variable ist dafür da, die Zeilen bis zur Mitte der sanduhr zu speichern.
        int runterZaehlenBisMitte = 0;

        // Die Variable ist dafür da, die Zeilen für die ab der Mitte Berechnung zu speichern.
        int hochZaehlenNachMitte;

        // Hier wird mit einer Formel berechnet wie viele Leerzeichen nach der Mitte der Sanduhr ausgegeben werden.
        int leerzeichenNachMitte = (anzahlSterne - 3) / 2;

        /**
         * In diesem Part wird geschaut ob 0 oder 1 ist.
         * Mit der Formel, die hier ausgeführt wird, kann ich genau bestimmen
         * wie viele Zeilen geschrieben werden bis zur Mitte der Sanduhr.
         */
        if (nullOderEins == 0) {
            // Gerade Zahlen
            runterZaehlenBisMitte = width / 2;

        } else if(nullOderEins == 1) {
            // Ungerade Zahlen
            runterZaehlenBisMitte = width / 2 + 1;;
        }

        // Hier wird 1 Minus gerechnet, weil man Ab der Mitte 1 Zeile weniger hat zum runter Rechnen.
        hochZaehlenNachMitte = runterZaehlenBisMitte - 1;

        // Hier wird quasi eine Pyramide rückwärts erstellt.
        for (int i = 0; i < runterZaehlenBisMitte; i++) {

            // Die Schleife sorgt dafür das immer die leerzeichen immer korrekt gesetzt werden
            for (int z = 0; z < i; z++) {

                // Ausgabe der Leerzeichen in der Konsole.
                System.out.print(" ");
            }
            // Hiermit werden immer die korrekte Anzahl der Sterne in der Zeile ausgegeben.
            for (int a = 0; a < anzahlSterne; a++) {

                // Ausgabe der Sterne in der Konsole
                System.out.print("*");
            }
            // Hiermit springen wir in die nächste Zeile
            System.out.println("");

            // Hier werden die Sterne immer um 2 abgerechnet.
            anzahlSterne = anzahlSterne -2;
        }

        /*
        Hier wird die Anzahl um 4 erhöht, um bei der Berechnung bei der nachfolgenden Berechnungen korrekt
        alles auszuführen
         */
        anzahlSterne = anzahlSterne + 4;

        // For Schleife die quasi eine Pyramide baut. Es werden immer 2 Sterne mehr dazu gezählt
        for (int g = 0; g < hochZaehlenNachMitte; g++) {

            // Die Schleife sorgt dafür das immer die leerzeichen immer korrekt gesetzt werden
            for (int e = 0; e < leerzeichenNachMitte; e++) {

                // Ausgabe der Leerzeichen in der Konsole.
                System.out.print(" ");
            }
            // Counter um weniger leerzeichen auszugeben.
            leerzeichenNachMitte--;

            // Hiermit werden immer die korrekte Anzahl der Sterne in der Zeile ausgegeben.
            for (int f = 0; f < anzahlSterne; f++) {

                // Ausgabe der Sterne in der Konsole
                System.out.print("*");
            }

            // Hiermit springen wir in die nächste Zeile
            System.out.println("");

            // Hier werden die Sterne immer um 2 erhöht.
            anzahlSterne = anzahlSterne + 2;
        }
        }
    }
}
