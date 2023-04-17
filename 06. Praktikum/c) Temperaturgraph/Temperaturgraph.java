public class Temperaturgraph {

    private int maxTemperatur;
    private int minTemperatur;
    private int jahresZahl;

    // Array mit 12 mal -1 Werte belegt für die 12 Monate.
    private int[] arrayT = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    public Temperaturgraph(int jahr) {

        if ( jahr <= 0) {
            System.out.println("Bitte ein Jahr eingeben, was groesser als 0 ist.");
            System.exit(0);
        } else {
            this.jahresZahl = jahr;
        }
    }

    /**
     * In dieser Methode trage ich die Temperaturen in einem Array ein.
     */
    void addTemperatur(int monat, int temperatur) {

        if ( monat-1 >= arrayT.length || monat <=0) {

            System.out.println("Bitte nur Zahlen zwischen 1 und 12 eintragen.");

        } else {

            if (temperatur < 0) {

                System.out.println("Bitte tragen sie Temperaturen ein, die mindestens über -1 sind.");
            } else {

                int index = monat - 1;


                for (int i = 0; i < arrayT.length; i++) {
                    if (i == index) {

                        arrayT[i] = temperatur;
                    }
                }
            }
        }
    }

    /**
     * Hier erstelle ich Grafisch in der Konsole ein Balkendiagramm,
     * wo man für jeden Monat die Temperatur sehen kann.
     */
    void plotGraph() {

        int ausgabe = 1;

        for (int i = 0; i < arrayT.length; i++) {
            if (-1 == arrayT[i]) {

                System.out.println("Es fehlen für bestimmte Monate noch die Temperaturen.");
                ausgabe = 0;
                break;

            } else if (i == arrayT.length - 1) {

                for (int j = 0; j < arrayT.length; j++) {

                    if (arrayT[j] > maxTemperatur) {
                        maxTemperatur = arrayT[j];
                    }
                    minTemperatur = maxTemperatur;
                }
                for (int j = 0; j < arrayT.length; j++) {
                    if (arrayT[j] < minTemperatur) {
                        minTemperatur = arrayT[j];
                    }
                }
            }
        }

        if (ausgabe == 1) {

             String zahl = String.valueOf(maxTemperatur);
             String neuesI;

            System.out.println("Jahr: "+jahresZahl);

            // Hiermit erreiche ich das meine Temperaturen richtig eingerückt werden.
            for (int i = maxTemperatur; i > minTemperatur - 1; i--) {
                 neuesI = String.valueOf(i);
                for (int l = 0; l < zahl.length()-neuesI.length() ; l++) {
                    System.out.print(" ");
                }
                    System.out.print(i+" ");

                    // Hiermit erstelle ich für jeden Monat den Temperaturbalken.
                    for (int j = 0; j < 12; j++) {
                        if (arrayT[j] >= i) {
                            System.out.print(" #");
                        }else {
                            System.out.print("  ");
                        }
                    }
                System.out.println("");
            }
        }
    }
}
