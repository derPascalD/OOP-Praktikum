import java.util.Scanner;

public class Wochentag {

/*
In der Main Methode rufe ich die Methode berechneWochenTag() auf und gebe 3 Parameter mit zur berechnung.
Die parameter gibt man einzeln in der Konsole ein.
 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 3 Methoden die aufgerufen werden wo der User eingaben machen muss
        int tag = eingabeTag();

        int monat = eingabeMonat();

        int jahr = eingabeJahr();

        //Für die Methode werden 3 Parameter übergeben die dann in der Methode mithilfe von Formeln verrechnet werden
        berechneWochenTag(tag, monat, jahr);
    }

    /**
     * Mit der Methode wird errechnet welcher Wochentag das eingegebene Datum hat und gibt es  in der Konsole aus.
     * @param d    Tag zwischen 1 und 31;
     * @param m    Monat zwischen 1 und 12;
     * @param jahr Jahr ab 1 bis unendlich
     */
    public static void berechneWochenTag(int d, int m, int jahr) {


        //Die Berechnung wenn der Monat Januar oder Februar angegeben wird.
        if (m == 1) {
            m = 13;
            jahr = jahr - 1;
        } else if (m == 2) {
            m = 14;
            jahr = jahr - 1;
        }
        // Berechnung der Jahreszahl
        int y =  jahr%100;

        //Berechnung des Jahrhunderts
        int c = jahr/100;

        //Die Berechnung für den Wochentag.
        int a = 26 * (m + 1);
        int b = a / 10;
        int f = 5 * y;
        int g = f / 4;
        int i = c / 4;
        int x = 5 * c;
        int e = d + b + g + i + x - 1;
        int w = (e % 7);

        //Damit setze ich das Jahr und den Monat zurück, um es richtig auszugeben in der Konsole.
        if (m == 13) {
            m = 1;
            jahr = jahr + 1;
        } else if (m == 14) {
            m = 2;
            jahr = jahr + 1;
        }

        // Ein Algorithmus, der ausgibt welcher Wochentag das eingegebene Datum hat.
        if (w == 0) {
            System.out.println("Der Wochentag für den " + d + "." + m + "." + jahr + " ist der Sonntag.");
        } else if (w == 1) {
            System.out.println("Der Wochentag für den " + d + "." + m + "." + jahr + " ist der Montag.");
        } else if (w == 2) {
            System.out.println("Der Wochentag für den " + d + "." + m + "." + jahr + " ist der Dienstag.");
        } else if (w == 3) {
            System.out.println("Der Wochentag für den " + d + "." + m + "." + jahr + " ist der Mittwoch.");
        } else if (w == 4) {
            System.out.println("Der Wochentag für den " + d + "." + m + "." + jahr + " ist der Donnerstag.");
        } else if (w == 5) {
            System.out.println("Der Wochentag für den " + d + "." + m + "." + jahr + " ist der Freitag.");
        } else if (w == 6) {
            System.out.println("Der Wochentag für den " + d + "." + m + "." + jahr + " ist der Samstag.");
        }
    }
   /**
    Die Methode überprüft ob das eingegeben Jahr nicht kleiner als 0 ist.
     * Es fängt alle fehlerhaften eingaben die kleiner als 0 sind ab un gibt dem User die Chance eine erneute eingabe
     * durchzuführen.
     */
    public static int eingabeTag() {

        System.out.println("----Wochentag ermitteln----");

        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("Bitte trage den Tag ein.");
            int tag = sc.nextInt();

            if (tag < 1 || tag > 31){

                // Ausgabe für den User was er eintragen soll
                System.out.println("Bitte trage eine Zahl zwischen 1 und 31 ein.");
            } else {
                return tag;
            }
        }
    }
    /**
     * Die Methode überprüft ob das der eingegebene Monat zwischen 1 und 12 liegt.
     * Die Methode fängt alle fehlerhaften eingaben die kleiner als 1 und größer als 12 sind ab.
     * Man hat dann die Möglichkeit erneut eine eingabe für den Monat zu tätigen.
    **/
    public static int eingabeMonat() {
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("Bitte trage den Monat ein.");
            int monat = sc.nextInt();

            if (monat < 1 || monat > 12){

                System.out.println("Bitte trage eine Zahl zwischen 1 und 12 ein.");
            } else {

                return monat;
            }
        }
    }
    /** Die Methode überprüft ob das eingegeben Jahr nicht kleiner als 0 ist.
     * Es fängt alle fehlerhaften eingaben die kleiner als 0 sind ab un gibt dem User die Chance eine erneute eingabe
     * durchzuführen
     */
    public static int eingabeJahr() {

        // Klasse Scanner hinzugefügt
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("Bitte trage das Jahr ein.");
            int jahr = sc.nextInt();

            if (jahr < 1){
                System.out.println("Bitte trage eine Zahl über 0 ein.");
            } else {

            // Gibt das die Variable jahr zurück. um mit dem Wert oben in der while Schleife zu rechnen
                return jahr;
            }
        }
    }
}