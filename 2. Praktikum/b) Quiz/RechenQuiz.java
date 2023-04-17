public class RechenQuiz {

    /*
     DieVariable speichert das Ergebnis der Rechnung ab die
     in der Methode getExercise() durchgeführt wird
     */
    private int ergebnis = 0;

    private int operant1;
    private int operant2;

    /*
     Hier wird eine Zufallszahl zwischen 0 und 2 generiert.
     DieVariable dient dazu den Operator festzulegen.
     */
    private int grundrechenarten = (int)(Math.random() * 3);

    // Die Variable sorgt dafür das die While Schleife, solange läuft bis sie auf "1" gesetzt wird.
    private int i = 0;

    /**
     * In der Methode getExercise() wird ein Algorithmus ausgeführt, wo eine Rechenaufgabe
     * zufällig erstellt wird und berechnet wird. Durch Aufrufen der Methode,
     * wird eine Rechenaufgabe in der Konsole ausgegeben.
     */
    public  void getExercise() {

        // Die while Schleife laeuft, solange bis eine Rechnung gueltig ist, das heißt es darf kein Ergebnis unter 0 sein.
        while (i == 0) {

            // Zwei variablen wo für jeden operant eine zufaellige Zahl erstellt wird zwischen 1 und 20.
            operant1 = (int) (Math.random() * 20) +1;
            operant2 = (int) (Math.random() * 20) +1;

            /*
            Hier wird ueberprueft, ob die generierte Zufallszahl 2 ist.
            Bei 2 wird die Rechnung mit "+" durchgeführt.
            */
            if (grundrechenarten == 2) {

                ergebnis = operant1 + operant2;
                System.out.println(operant1 + " + " + operant2 + " = ?");
                i = 1;
            /*
            Hier wird überprüft, ob die generierte Zufallszahl 2 ist.
            Bei 1 wird die Rechnung mit "-" durchgeführt.
            */
            } else if (grundrechenarten == 1) {

                ergebnis = operant1 - operant2;
                if (ergebnis >= 0) {
                    System.out.println(operant1 + " - " + operant2 + " = ?");
                    i = 1;
                }
            /*
            Hier wird überprüft, ob die generierte Zufallszahl 2 ist.
            Bei 0 wird die Rechnung mit "*" durchgeführt.
            */
            } else if (grundrechenarten == 0) {

                ergebnis = operant1 * operant2;
                System.out.println(operant1 + " * " + operant2 + " = ?");
                i = 1;
            }
        }
    }

    /**
     * Die Methode gibt das Ergebnis der Rechnung von getExercise() zurück.
     *
     * @return
     */
    public int getResult() {

        return ergebnis;
    }
}