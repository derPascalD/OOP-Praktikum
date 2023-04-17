public class Memory {
    private int geradeUngerade;

    /**
     * Die Methode sorgt dafür, das ein Memory Spielfeld erzeugt wird,
     * mit einer geraden Anzahl an Spalten und Zeilen.
     * Ein Algorithmus sorgt dafür, das nur einmalige Pärchen erzeugt werden.
     */
    int[][] generateField(int n) {

        // Wird abgefangen, dass die Zahlen Positiv sein müssen.
        if ( n < 0) {
            System.out.println("Bitte nur Positive Zahlen eingeben.");
            System.exit(0);
        }

        int array[][] = new int[n][n];

        geradeUngerade = n % 2;

        // Im ersten Schritt schaue ich ob Werte in den Arrays gegeben sind.
        if (array.length == 0 || array == null) {
            System.out.println("Array ist leer oder es steht eine 0 drin.");
            System.out.println("");
            System.exit(0);
        }

        if (geradeUngerade == 1) {
            System.out.println("Bitte nur gerade Zahlen eingeben.");
            System.exit(0);
        }

        // Hier wird ein Spielfeld erzeugt, wo es jedes Pärchen nur einmal gibt
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {

                array[i][j] = (int) (Math.random() * ((n * n) / 2) + 5);

                int counter = 0;
                for (int k = 0; k < array.length; k++) {
                    for (int l = 0; l < array[k].length; l++) {

                        if (array[i][j] == array[k][l]) {
                            counter++;
                            if (array[i][j] == array[k][l] && counter == 3) {

                                array[i][j] = (int) (Math.random() * ((n * n) / 2) + 5);
                                k = 0;
                                l = -1;
                                counter = 0;
                            }
                        }
                    }
                }
            }
        }
        return array;
    }

    /**
     * Die Methode sorgt beim Aufruf dafür,
     * dass das Array bzw. das Spielfeld in der Konsole ausgegeben wird.
     */
    public void visuelleAusgabe(int[][] array) {

           System.out.println("Spielfeld:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");

        }
        System.out.println("");
    }
}