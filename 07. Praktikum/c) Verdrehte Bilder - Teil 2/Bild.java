import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class Bild {

    private String bildFormat = "";
    private int breiteDesBildes;
    private int hoeheDesBildes;
    private int maximaleHelligkeit;
    private int[][] daten;

    // Die Variable "aufrufe" sorgt dafür, das gezählt wird wie oft die Methode aufgerufen wird.
    private int aufrufe;

    /**
     * In der Methode lese ich eine pgm Datei ein und entnehme die Informationen des Bildes. Zusätzlich
     * speichere ich die Bilddaten in ein zweidimensionales Array.
     */
    void leseBild(String dateiName) {
        String[] bildformatArray;
        int laenge = 0;
        String[] array;

        // Aufruf einer Datei.
        Path path = Paths.get(dateiName);

        // Überprüfung, ob die Datei existiert.
        if (Files.exists(path)) {

            System.out.println("Datei vorhanden.");
        } else {

            System.out.println("Datei existiert nicht.");
            System.exit(0);
        }
        try {

            // Speichere ich jede Zeile in ein eindimensionales Array ab.
            array = ((Files.readString(path)).split("\n"));

            if (array.length == 1 ){
                System.out.println("Datei ungültig!");
                System.exit(0);
            }

            String temp = array[1].trim();

            String[] breiteHoehe = temp.split(" ");

            bildformatArray = array[0].split(" ");

            // Speichern der Bildinformationen.
            bildFormat = bildformatArray[0];
            breiteDesBildes = Integer.parseInt(breiteHoehe[0]);
            hoeheDesBildes = Integer.parseInt(breiteHoehe[1]);

            String temp1 = array[2].trim();

            String[] helligkeit = temp1.split(" ");

            // Speichern der Helligkeit des Bildes.
            maximaleHelligkeit = Integer.parseInt(helligkeit[0]);

            for (int i = 0; i < array.length; i++) {

                if ( array[i].length() >= breiteDesBildes ) {
                        laenge = i;
                        break;
                }
            }

            daten = new int[hoeheDesBildes][breiteDesBildes];

            String[] temp2;
            int counter;

            // Bilddaten in das zweidimensionale Array hinzufügen.
            for (int i = laenge; i < array.length; i++) {
                counter = 0;
                temp2 = array[i].split(" ");
                for (int j = 0; j < temp2.length; j++) {
                    temp2[j] = temp2[j].replace("\r", "");
                }
                for (int j = 0; j < breiteDesBildes + counter; j++) {
                    if ((temp2[j] == "")) {
                        counter++;

                    } else {

                        daten[i - laenge][j - counter] = Integer.parseInt(temp2[j]);
                    }
                }
            }
            System.out.println("Datei wurde hinzugefuegt!");
            System.out.println();


        } catch (IOException e) {
            System.out.println("Datei konnte nicht bearbeitet und hinzugefuegt werden.");
        }
    }

    /**
     * In der Methode drehe ich gegen den Uhrzeigersinn das eingelesene Bild und
     * trage die Werte wieder in das zweidimensionale Array ein.
     */
    void rotiereBild() {
        // Zählt hoch, beim Aufruf der Methode.
        aufrufe++;

        // Drehe ich das Bild und trage die Werte erneut ein
        int datenTemp[][] = new int[breiteDesBildes][hoeheDesBildes];
        for (int i = 0; i < datenTemp.length; i++) {
            for (int j = 0; j < datenTemp[0].length; j++) {
                datenTemp[i][j] = daten[j][daten[j].length - i - 1];
            }
        }
        daten = datenTemp;

        int temp = breiteDesBildes;
        breiteDesBildes = hoeheDesBildes;
        hoeheDesBildes = temp;
    }

    /**
     * In der Methode erstelle ich eine neue Datei, mit dem aktuellen Datum als Name und füge den Inhalt eines
     * zweidimensionalen Arrays hinzu und sorge durch einen Algorithmus dafür das, das Bildwerte korrekt in die Datei
     * geschrieben werden.
     */
    void schreibeBild(String verzeichnis) {

        // Aktuelles Datum auslesen
        LocalDate datum = LocalDate.now();

        // Datei zusammenfügen
        String datei = verzeichnis + datum + ".pgm";

        try {

            // Überprüfe, ob die Datei die man erstellen will, schon existiert.
            Path datei1 = Paths.get(datei);

            if (Files.exists(datei1)) {

                System.out.println("Datei " + "'" + datei + "'" + " schon vorhanden.");
                System.out.println("Bitte Datei aus dem Verzeichnis entfernen, um es erneut zu erstellen.");
                System.exit(0);
            } else {

                Files.createFile(datei1);
                System.out.println("Datei erfolgreich erstellt!");
            }
            String text;

            // An dieser Stelle füge ich Leerzeichen, inklusive den Bilddaten in eine String Variable ein.
            text = bildFormat + "\n";
            text = text + breiteDesBildes + " " + hoeheDesBildes + "\n";
            text = text + maximaleHelligkeit + "\n";

            /*
             Die if Verzweiung wird aufgerufen, wenn die Methode "(aufrufe-3) % 4 = 0 erfüllt"
             Die Formel sorgt dafür, das nur bei 270 Grad Drehung die Formel erfüllt ist.
             Bsp. bei den Aufrufzahlen 3, 7, 11 und so weiter...
             */
            if ( (aufrufe-3) % 4 == 0) {
                for (int i = 0; i < daten.length; i++) {
                    for (int j = 0; j < daten[0].length; j++) {
                        if (daten[i][j] > 9 && daten[i][j + 1] > 9 || daten[i][j] >9  && daten[i][j + 1] < 10 ) {
                            text = text + daten[i][j] + " ";
                        } else {
                            text = text + daten[i][j] + "  ";
                        }
                    }
                    text = text + "\n";
                }
            } else {
                for (int i = 0; i < daten.length; i++) {
                    for (int j = 0; j < daten[0].length-1; j++) {
                        if (daten[i][j] < 10 && daten[i][j + 1] > 9 || daten[i][j] > 9 && daten[i][j + 1] > 9 ) {
                            text = text + daten[i][j] + " ";
                        } else {
                            text = text + daten[i][j] + "  ";
                        }
                    }
                    if (daten[i][breiteDesBildes-2] < 10 && daten[i][breiteDesBildes-1] > 9 && daten[i][breiteDesBildes-2] > 9) {
                        text = text + " "+daten[i][breiteDesBildes-1];
                    } else {
                        text = text + ""+daten[i][breiteDesBildes-1];

                    }
                    text = text + "\n";
                }
            }

            // Schreibe ich den Inhalt der Variable, in die erstelle Bilddatei hinein.
            Files.writeString(datei1, text);

        } catch (IOException e) {
            System.out.println("Fehler beim erstellen.");
        }
    }
}
