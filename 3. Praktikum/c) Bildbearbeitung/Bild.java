public class Bild {

    private int[][] arrayD;

    public int[][] getArrayD() {
        return arrayD;
    }

    public void setArrayD(int[][] array) {
        this.arrayD = array;
    }

    /**
     * In dieser Methode habe ich einen Algorithmus geschrieben, wo ich die Bildeingabe spiegel und danach die
     * Binärzahlen invertiere.
     */
    public Bild flipAndInvert() {

        if (arrayD.length == 0 || arrayD == null) {
            System.out.println("Array ist leer.");
            System.out.println("");
            return null;
        }

        // Hier gebe ich das Originalbild aus.
        System.out.println("Originalbild:");
        ausgabe();

        /*
         An dieser Stelle des Programmes spiegel ich das Bild. ich vertausche immer die Erste Zeile mit der
         letzten Zeile und danach gehe ich eine Zeile runter und vertausche sie mit der vorletzten Zeile.
         */
        for (int i = 0; i < arrayD.length / 2; i++) {
            for (int j = 0; j < arrayD[i].length; j++) {


                // Hier speichere ich den einzelnen Zeileninhalt ab und überschreibe ihn dann wieder
                int zwischenspeicher = arrayD[arrayD.length - i - 1][j];
                arrayD[arrayD.length - i - 1][j] = arrayD[i][j];
                arrayD[i][j] = zwischenspeicher;
            }
        }

        /*
         Als letzten Schritt invertiere ich die Binärzahlen.
         */
        for (int i = 0; i < arrayD.length; i++) {
            for (int j = 0; j < arrayD[i].length; j++) {

                //Hier wird geschaut, ob die Stelle im Array "0" oder "1" ist.
                if (arrayD[i][j] == 0) {

                    // Ist die Stelle des Arrays "0" wird die 0 zu einer "1".
                    arrayD[i][j] = 1;

                    // Ist die Stelle des Arrays "1" wird die "1" zu einer "0".
                } else if (arrayD[i][j] == 1){
                    arrayD[i][j] = 0;
                } else {

                    /*
                     Sollte das Bild keine Binärzahlen enthalten gibt es eine Ausgabe und
                     wird nicht weiter verarbeitet
                     */
                    System.out.println("Das eingegebene Bild ist nicht Binär!");
                    System.out.println("");
                    return null;
                }
            }
        }
        // Hier wird das fertige Bild ausgegeben
        System.out.println("Bild nach flipAndInvert():");
        ausgabe();
        return this;
    }

    /**
     * In der Methode ausgabe() wird das Bild visuell erzeugt.
     * Je nachdem wann man die Methode aufruft, kann man das fertige Bild ausgeben oder das Originalbild.
     */
    public void ausgabe() {

        for (int i = 0; i < arrayD.length; i++) {
            for (int j = 0; j < arrayD[i].length; j++) {

                System.out.print(arrayD[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }
}



