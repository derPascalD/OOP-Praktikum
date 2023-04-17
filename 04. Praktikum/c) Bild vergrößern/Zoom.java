public class Zoom {

    // Mehrdimensionale Array
    private int[][] arrayD;

    // Konstruktor wodurch eine Variable initialisiert werden kann.
    public Zoom(int[][] arrayD) {

        this.arrayD = arrayD;
    }

    /**
     * In dieser Methode werden Berechnungen durchgeführt, um ein Bild zu vergrößern.
     */
    int[][] zoom(int f) {

        // Überprüft, das Zahlen die 1 oder kleiner sind abgefangen werden.
        if ( f <= 1) {
            System.out.println("Bitte nur Zahlen die Groesser sind als 1 eintragen.");
            System.exit(0);
        }

        // Hier wird berechnet wie viele Zeilen und Spalten das neue Array haben soll.
        int neuesF = arrayD.length * f;


        // Neues Array erzeugt, wo das vergrößerte Bild eingespeichert wird.
        int[][] neuesArray = new int[neuesF][neuesF];

        // Überprüft, ob Array leer oder 0 ist.
        if (arrayD.length == 0 || arrayD == null) {
            System.out.println("Array ist leer oder es steht eine 0 drin.");
            System.out.println("");
            System.exit(0);
        }

        // Überprüft das die Zeilen und Spalten gleich sind.
        if (arrayD.length != arrayD[0].length) {
            System.out.println("Die Zeilen udn Spalten nicht nicht gleich Gross.");
            System.exit(0);
        }



        // Hier wird überprüft, dass die Werte im Array 0 bis einschließlich 7 sind.
        for (int i = 0; i < arrayD.length; i++) {
            for (int j = 0; j < arrayD[i].length; j++) {

                if (arrayD[i][j] < 0 || 7 < arrayD[i][j]) {

                    System.out.println("Bitte nur Zahlen von 0 bis einschließlich 7 im Array eintragen!");
                    System.out.println("");
                    System.exit(0);
                }
            }
        }
        // Sind für die Stellen im neuen Array.
        int a = 0;
        int b = 0;

        // Die drei for Schleifen sorgen dafür, dass das Bild vergrößert wird.
        for (int i = 0; i < arrayD.length; i++) {
            for (int k = 0; k < f; k++) {
                for (int j = 0; j < arrayD[i].length; j++) {

                    int l = 0;
                    while (l != f) {
                        neuesArray[a][b] = arrayD[i][j];

                        // Sorgt dafür das die Länge vom Array nicht überzogen wird.
                        if (b != neuesF-1) {

                            // Setzt die Spalten.
                            b++;
                        }
                        l++;
                    }
                }

                //Setzt die Zeilen.
                a++;

                //Setzt die Spalten zurück.
                b = 0;
            }
        }
        return neuesArray;
    }
}



