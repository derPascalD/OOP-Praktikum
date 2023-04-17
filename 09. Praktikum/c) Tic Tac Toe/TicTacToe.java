public class TicTacToe {

    private  int[] feld;
    private  int zaehler = 0;
    private  int ende;

     TicTacToe() {
        reset();
        System.out.println("Willkommen beim Spiel Tic Tac Toe\n");
        System.out.println("Spieler 1 faengt an und hat das 'X', Spieler 2 hat die '0'.");
    }

    /**
     * Wird das Array initialisiert und alle Stellen auf 0 gesetzt.
     */
     void reset() {
        feld = new int[9];
        ende = 0;
        zaehler = 0;
        System.out.println("Spielfeld neu erstellt!");
    }

    /**
     * In dieser Methode wird je nachdem welcher Spieler dran ist, unterschiedliche Berechnungen durchgeführt.
     * Die Werte die übergeben, werden durch eine Berechnung an die richtige Stelle im array übertragen.
     */
    void macheZug(int x, int y) {
        if (x > 2 || x < 0 || y > 2 || y < 0) {
            System.out.println("Falsche Eingabe!");
        } else if (ende == 1) {
            System.out.println("Spiel ist zuende!");
            System.out.println("Um neu zu starten, das Spielfeld zurueck setzen.");
        } else {
            if (feld[(3 * y) + x] != 0) {
                System.out.println("Gibt es schon oder es ist Unentschieden.");
            } else {
                int geradeungerade = zaehler % 2;
                zaehler++;
                if (geradeungerade == 0) {
                    for (int i = 0; i < feld.length; i++) {
                        if (i == (3 * y) + x) {
                            feld[i] = 1;
                        }
                    }
                    if (feld[0] == 1 && feld[1] == 1 && feld[2] == 1) {
                        System.out.println("Spieler 1 hat gesetzt und gewonnen!");
                        ende = 1;
                    } else if (feld[3] == 1 && feld[4] == 1 && feld[5] == 1) {
                        System.out.println("Spieler 1 hat gesetzt und gewonnen!");
                        ende = 1;
                    } else if (feld[6] == 1 && feld[7] == 1 && feld[8] == 1) {
                        System.out.println("Spieler 1 hat gesetzt und gewonnen!");
                        ende = 1;
                    } else if (feld[0] == 1 && feld[3] == 1 && feld[6] == 1) {
                        System.out.println("Spieler 1 hat gesetzt und gewonnen!");
                        ende = 1;
                    } else if (feld[1] == 1 && feld[4] == 1 && feld[7] == 1) {
                        System.out.println("Spieler 1 hat gesetzt und gewonnen!");
                        ende = 1;
                    } else if (feld[2] == 1 && feld[5] == 1 && feld[8] == 1) {
                        System.out.println("Spieler 1 hat gesetzt und gewonnen!");
                        ende = 1;
                    } else if (feld[0] == 1 && feld[4] == 1 && feld[8] == 1) {
                        System.out.println("Spieler 1 hat gesetzt und gewonnen!");
                        ende = 1;
                    } else {
                        System.out.println("Spieler 1 hat gesetzt!");
                    }
                } else {
                    for (int i = 0; i < feld.length; i++) {
                        if (i == (3 * y) + x) {
                            feld[i] = 2;
                        }
                    }
                    if (feld[0] == 2 && feld[1] == 2 && feld[2] == 2) {
                        System.out.println("Spieler 2 hat gesetzt und gewonnen!");
                        ende = 1;
                    } else if (feld[3] == 2 && feld[4] == 2 && feld[5] == 2) {
                        System.out.println("Spieler 2 hat gesetzt und gewonnen!");
                        ende = 1;
                    } else if (feld[6] == 2 && feld[7] == 2 && feld[8] == 2) {
                        System.out.println("Spieler 2 hat gesetzt und gewonnen!");
                        ende = 1;
                    } else if (feld[0] == 2 && feld[3] == 2 && feld[6] == 2) {
                        System.out.println("Spieler 2 hat gesetzt und gewonnen!");
                        ende = 1;
                    } else if (feld[1] == 2 && feld[4] == 2 && feld[7] == 2) {
                        System.out.println("Spieler 2 hat gesetzt und gewonnen!");
                        ende = 1;
                    } else if (feld[2] == 2 && feld[5] == 2 && feld[8] == 2) {
                        System.out.println("Spieler 2 hat gesetzt und gewonnen!");
                        ende = 1;
                    } else if (feld[0] == 2 && feld[4] == 2 && feld[8] == 2) {
                        System.out.println("Spieler 2 hat gesetzt und gewonnen!");
                        ende = 1;
                    }
                    else {
                        System.out.println("Spieler 2 hat gesetzt!");
                    }
                }
            }
        }
    }

    /**
     * Durch die Methode wird das Spielfeld mit den eingetragenen Zeichen ausgegeben.
     */
    void zeigeSpielfeld() {
        int counter = 0;
        for (int i = 0; i < 9; i++) {
            counter++;
            if (feld[i] == 1) {
                System.out.print("X");
            } else if (feld[i] == 2) {
                System.out.print("0");
            } else {
                System.out.print(" ");
            }
            if (counter != 3) {
                System.out.print("|");
            }
            if (counter == 3 && i < 6) {
                System.out.println("\n-+-+-");
                counter = 0;
            }
        }
        System.out.println();
    }
}

