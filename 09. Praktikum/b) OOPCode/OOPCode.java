import java.lang.Math;

public class OOPCode {

    private int[][] werteArray;
    private int[][] bild;
    private int zaehler = 0;
    private int maxDrehung = 0;
    private int maxOOPCode = 0;

    /**
     * Im Konstruktor wird erst auf Fehler überprüft und erst dann werden die Daten übertragen.
     */
    OOPCode(int[][] bild) {

        if (bild == null || bild.length == 0) {
            System.out.println("Bitte das Array füllen");
            System.exit(0);
        } else if (bild.length != bild[0].length) {
            System.out.println("Die Anzahl passt nicht zum übergebenen Bild!");
            System.exit(0);
        } else {

            for (int i = 0; i < bild.length; i++) {
                if (bild.length != bild[i].length) {
                    System.out.println("In einer Zeile passt die Spaltenlaenge nicht zur Zeilenlaenge!");
                    System.exit(0);
                }
            }
            for (int i = 0; i < bild.length; i++) {
                for (int j = 0; j < bild.length; j++) {
                    if (0 != bild[i][j]) {
                        if (1 != bild[i][j]) {
                            System.out.println("Bitte nur 1 oder 0 eintragen");
                            System.exit(0);
                        }
                    }
                }
            }
            this.bild = bild;
            zahlenFeldErstellen();
        }
    }

    /**
     * In der Methode wird ein Zahlenfeld erstellt.
     * Oben links in der Ecke steht immer die größte Zahl, die dann durch 2 immer weiter kleiner wird, bis unten Rechts
     * die "1" steht.
     */
    private void zahlenFeldErstellen() {
        int k = (bild[0].length * bild[0].length) - 1;

        int maxWert = (int) Math.pow(2, k);

        werteArray = new int[bild[0].length][bild[0].length];

        for (int i = 0; i < werteArray.length; i++) {
            for (int j = 0; j < werteArray[0].length; j++) {
                werteArray[i][j] = maxWert;
                maxWert = maxWert / 2;
            }
        }
    }

    /**
     * Die Methode gibt den inhalt des Arrays "bild" aus.
     */
    void ausgabeBild() {

        for (int i = 0; i < bild.length; i++) {
            for (int j = 0; j < bild[0].length; j++) {
                System.out.print(bild[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Hier wird der maximale OOP Code für ein Bild berechnet.
     */
    int oopCodeSumme() {
        int OOPCode = 0;
        for (int i = 0; i < bild.length; i++) {
            for (int j = 0; j < bild[0].length; j++) {

                if (0 != bild[i][j]) {
                    OOPCode = OOPCode + werteArray[i][j];
                }
            }
        }
        return OOPCode;
    }

    /**
     * Hier wird das Bild im Uhrzeigern um 90 Grad gedreht.
     */
    private void bilddrehen() {
        int[][] temp = new int[bild.length][bild.length];
        int counter = 0;

        for (int i = 0; i < bild.length; i++) {
            for (int j = bild.length - 1; j >= 0; j--) {
                temp[i][counter] = bild[j][i];
                counter++;
            }
            counter = 0;
        }
        bild = temp;
    }

    /**
     * Hier wird berechnet, welches Bild den maximalen OPPCode hat und wie viele Drehungen dafür benötigt
     * wurden
     */
    int maxOOPCode() {

        if (maxOOPCode < oopCodeSumme()) {
            maxOOPCode = oopCodeSumme();
        }

        if ( zaehler == 4) {

            for (int i = 0; i < 4; i++) {
                if (oopCodeSumme() == maxOOPCode){
                    ausgabeBild();
                    for (int j = i; j < 4; j++) {
                        bilddrehen();
                    }
                    break;
                }
                maxDrehung++;
                bilddrehen();
            }
        } else{
            zaehler++;
            bilddrehen();
            maxOOPCode();
        }
        return  maxOOPCode;
    }

    /**
     * Gibt die Anzahl der Drehungen für den maximale OOPCode zurück.
     */
    public int getMaxDrehung() {
        return maxDrehung;
    }
}