public class PasswortGenerator {

    private String passwort = "";

    /**
     * In der Methode wird ein Satz der als Parameter übergeben wird,
     * so umgewandelt, dass der erste Buchstabe einer Zeichenkette gesetzt wird.
     * Die Anfangsbuchstaben werden im wechsel als Groß und Kleinbuchstaben abgespeichert.
     */
    void erstellePasswort(String satz) {

        // Ist dafür da um nach jedem Leerzeichen wieder einen Buchstaben zu setzen.
        int leerzeichen = 0;

        // Sorgt dafür des Buchstaben groß oder kleingeschrieben werden.
        int umschalt = 0;

        // Hier wird immer der Erste Buchstabe einer Zeichenkette in einer Liste gesetzt.
        for (int i = 0; i < satz.length(); i++) {
            if (String.valueOf(satz.charAt(i)).matches("\\S")) {

                if (leerzeichen == 0 && (String.valueOf(satz.charAt(i)).matches("[a-zA-Z]"))) {

                    if (umschalt == 0) {

                        passwort = passwort + String.valueOf(satz.charAt(i)).toLowerCase();
                        leerzeichen = 1;
                        umschalt = 1;

                    } else {

                        passwort = passwort + String.valueOf(satz.charAt(i)).toUpperCase();
                        leerzeichen = 1;
                        umschalt = 0;
                    }
                }
            } else if (String.valueOf(satz.charAt(i)).matches("\\s")) {

                leerzeichen = 0;
            }
        }
    }

    /**
     * Zum Ausgeben des Passwortes.
     */
    void ausgabePasswort() {

        System.out.println("Passwort: " + passwort);
    }
}
