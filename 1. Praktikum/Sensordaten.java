import java.util.Scanner;

public class Sensordaten {

    public static void main(String[] args) {

        //Aufruf der Methode in der Main Methode.
        filterMesswerte();
    }
    /**
     * Mit der Methode werden bestimmte Zahlen gefiltert
     */
    public static void filterMesswerte(){

        Scanner sc = new Scanner(System.in);

        // Die Variable zaehlt die eingabe von der zahl "1".
        int counterFürEins = 0;

        // Variable "ende" ist dafür da, um die while Schleife zu beenden.
        int ende = 0;

        // Die boolean Variable "nullZuruecksetzen" ist dafür da, um die 0 zu setzen und auch wieder zurueckzusetzen.
        boolean nullZuruecksetzen = false;

        /*
        Mit der While Schleife wird ein Algorithmus ausgeführt der solange laeuft bis die eingabe "-1" dreimal
        hintereinander eingetragen wurde.
         */
        while(ende == 0) {
            // Ausgabe was der User machen soll.
            System.out.println("Bitte geben Sie ein Messwert ein.");
            int eingabe = sc.nextInt();

            // Die if Bedingung sorgt dafür, das negative Zahlen in positve Zahlen umgewandelt werden.
            if (eingabe < 0) {
                eingabe = eingabe*(-1);
                System.out.println(eingabe);

                //Setzt die Variable wieder auf 0
                counterFürEins = 0;
                nullZuruecksetzen = false;

            }

            /*
            Die else if Bedingung sorgt dafür,
            das geschaut wird wie viele einsen man hintereinander eingegeben hat.
            Bei einer eingabe von 3 hinternanderfolgenden einsen,
            wird die Schleife und das Programm beendet.
            */
            else if (eingabe == 1) {
                    counterFürEins++;

                    if (counterFürEins == 3) {
                            ende = 1;
                    }
            }

            /*
            Die Bedingung sorgt dafür das der counterFürEins wieder auf 0 gesetzt wird,
            wenn eine zahl eingegeben wird die größer als "1" ist.
            */
            else if(eingabe > 1){
                counterFürEins = 0;
            }

            /*
            Hier wird überpüft ob man eine 0 eingeben hat, wenn ja wird sie ausgegeben.
            Bei erneuter eingabe der 0 wird keine Ausgabe der 0 mehr stattfinden. Erst wen eine negative Zahl wieder
            eingegben wird.
            */
            else if (eingabe == 0 && nullZuruecksetzen == false) {
                System.out.println(eingabe);
                counterFürEins = 0;
                nullZuruecksetzen = true;
            }
        }
    }
}

