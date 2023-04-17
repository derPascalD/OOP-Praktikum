public class MyList {

    // Speichert die Länge eines Arrays.
    private int laengeA;
    private int[] array = new int[0];

    /**
     * Die Methode sorgt dafür, dass neue Elemente zum Array hinzugefügt werden.
     */
    public void addToList(int index, int item) {

        if (index >= array.length+1 || index < 0) {
            System.out.println("Der eingegebene Index liegt ausserhalb des Bereiches.");
            return;
        }
            laengeA++;

        // Erstellung eines temporären Arrays.
        int[] arrayE = new int[laengeA];

        if (laengeA > 1) {
            for (int i = 0; i < arrayE.length - 1; i++) {

                if (index == i) {
                    for (int j = i; j < arrayE.length - 1; j++) {
                        arrayE[j + 1] = array[j];
                        i++;
                    }
                } else {
                    arrayE[i] = array[i];
                }
            }
        }

        // Wird die Länge vom Array erhört und neu erstellt.
        array = new int[laengeA];
        arrayE[index] = item;

        // Werden die Elemente vom temporären Array in das richtige Array hinzugefügt.
        for (int i = 0; i < laengeA; i++) {
            array[i] = arrayE[i];
        }
        // Ausgabe des hinzugefügten Elements und an welche Indexstelle es gesetzt wurde.
        System.out.println("Element " + item + " hinzugefuegt an Index " + index + ".");

    }

    /**
     * In der Methode werden Elemente aus dem Array gelöscht und das Array wird kleiner gesetzt.
     */
    public void removeFromList(int index) {

        if (array.length == 0 || array == null) {
            System.out.println("Array ist noch leer.");
            System.out.println("");
            return;
        }

        // Erstellung eines temporären Arrays mit der Länge -1.
        int[] arrayE = new int[array.length - 1];

        if (index >= array.length || index < 0) {
            System.out.println("Der eingegebene Index liegt ausserhalb des Bereiches.");
            System.exit(0);
        }

        for (int i = 0; i < array.length; i++) {

            if (index == i) {
                System.out.println("Element "+ array[index] +" geloescht.");
                for (int j = i; j < arrayE.length; j++) {
                    arrayE[j] = array[j + 1];
                    i++;
                }
            } else {
                arrayE[i] = array[i];
            }
        }
        // Wird die Länge vom Array, um 1 verringert und neu erstellt.
        array = new int[array.length - 1];

        // Werden die Elemente vom temporären Array in das richtige Array hinzugefügt.
        for (int i = 0; i < array.length; i++) {
            array[i] = arrayE[i];
        }

    }

    /**
     * Beim Aufruf der Methode wird der Inhalt des Arrays ausgegeben.
     */
    public void ausgabe() {

        if (array.length == 0 || array == null) {
            System.out.println("Array ist noch leer.");
            System.out.println("");
            return;
        }

        System.out.println("Array Inhalt:");
        for (int j : array) {
            System.out.print(j + " ");

        }
        System.out.println("\n");
    }

    /**
     * Die Methode sorgt dafür, das doppelte Elemente aus dem Array entfernt werden.
     */
    public int removeDuplicates() {


        if (array.length == 0 || array == null) {
            System.out.println("Array ist noch leer. Bitte befuelle erst das Array");
            System.out.println("");
            return 0;

        }

        else {
            int zaehler = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 1; j < array.length; j++) {
                    if (array[i] == array[j] && i != j) {
                        zaehler++;
                        removeFromList(j);
                        i = -1;
                        break;
                    }
                }
            }return zaehler;
        }
    }

    /**
     * Die Methode sorgt dafür, dass das Array sortiert wird.
     */
    public void sortList() {

        if (array.length == 0 || array == null) {
            System.out.println("Array ist noch leer.\nBitte Elemente hinzufuegen um das Array zu sortieren.");
            System.out.println("");
            System.exit(0);
        }

        int kleinsterWert;

        /*
        Hier wird immer vom aktuellen Element der Index abgespeichert.
        */
        for (int i = 0; i < array.length; i++) {
            kleinsterWert = i;

            /*
            Durch die Schleife wird jetzt immer die kleinste Zahl im Array gesucht und
            der Index in einer Variable abgespeichert.
            */
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[kleinsterWert]) {
                    kleinsterWert = j;
                }
            }

            //Wenn die kleinste Zahl gefunden wurde, wird die Zahl nach vorne gepackt und die nächst kleine gesucht.
            int zwischenwert = array[i];
            array[i] = array[kleinsterWert];
            array[kleinsterWert] = zwischenwert;
        }
    }

    /**
     * Hier wird geschaut, ob es Elemente gibt die, die Summe ergeben die gesucht wird.
     */
    public void kombiZahl(int zahl) {

        if (array.length == 0 || array == null) {
            System.out.println("Array ist noch leer.\nBitte Elemente hinzufuegen, um die Kombi zahlen zu bestimmen.");
            System.out.println("");
            System.exit(0);
        }

        System.out.println("Kombi Zahlen sind:");
        int ergebnis = 0;

        // Gehe durch das Array und suchen nach Kombinationen.
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    if (zahl == (array[i] + array[j] + array[k])) {

                        // Ausgabe der Kombinationen + die Summe.
                        System.out.println(array[i] + " + " + array[j] + " + " + array[k] + " = " + zahl);
                        ergebnis = 1;
                    }
                }
            }
        }
        // Wenn es keine Kombination gibt zur Berechnung der Summe, gibt es eine Ausgabe.
        if (ergebnis == 0) {
            System.out.println("");
            System.out.println("Es gibt hier keine drei Kombizahlen die, die Summe " + zahl + " ergeben.");
        }
    }
}