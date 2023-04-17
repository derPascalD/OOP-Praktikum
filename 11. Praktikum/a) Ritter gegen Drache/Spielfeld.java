import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Spielfeld extends JPanel implements ActionListener {

    private final JButton[][] buttons = new JButton[7][7];

    private final Font font1 = new Font("Cookie", Font.PLAIN,55);
    private String amZug;
    private int zahl;
    private boolean passt = true;
    private int zeileD = 6;
    private int spalteD = 6;
    private int zeileR = 0;
    private int spalteR = 0;
    private int spielEnde = 0;
    private final int[][] kachelnE = new int[7][7];
    private int element;
    private int wuerfelZahl;
    private int start;

    // Um auf meine anderen Klassen zuzugreifen
    SpielstaerkeRD spielstaerkeRD;
    Gui gui;

    /**
     * Hier erstelle ich das Spielfeld mit Buttons,
     * die ich einem Gridlayout hinzufüge und setze dabei die Spielfiguren.
     */
    Spielfeld(Gui gui, SpielstaerkeRD spielstaerkeRD) {

        // Damit holle ich mir meine Klassen rein
        this.gui = gui;
        this.spielstaerkeRD = spielstaerkeRD;

        zahl = (int) (Math.random() * 2);
        if (0 == zahl) {
            amZug = "R";
            gui.getInformation().setText("Der Ritter ist dran!");

        } else {
            amZug = "D";
            gui.getInformation().setText("Der Drache ist dran!");
        }

        for (int i = 0; i < 49; i++) {

        }
        setLayout(new GridLayout(7, 7));

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(font1);
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].setForeground(Color.WHITE);
                element = (int) (Math.random() * 3) + 1;
                if (element == 1) {
                    buttons[i][j].setBackground(new Color(36, 206, 19));
                } else if (element == 2) {
                    buttons[i][j].setBackground(new Color(12, 13, 236));
                } else if (element == 3) {
                    buttons[i][j].setBackground(new Color(248, 13, 13));
                }

                if (i == 0 && j == 0) {
                    kachelnE[i][j] = 0;
                } else if (i == 6 && j == 6) {
                    kachelnE[i][j] = 4;
                } else {
                    kachelnE[i][j] = element;
                }
                this.add(buttons[i][j]);
                buttons[i][j].addActionListener(this);
            }
        }
        buttons[zeileD][spalteD].setText("D");
        buttons[zeileD][spalteD].setBackground(Color.BLACK);
        buttons[zeileR][spalteR].setText("R");
        buttons[zeileR][spalteR].setBackground(Color.BLACK);
    }

    /**
     * In der Methode werden x und y Koordinaten übertragen.
     * Die Werte werden je nach Würfelzahl überprüft und weitergeben zur berechnung des Spielzuges.
     * Hier finden die Auswertungen der Spielstärken statt, um den Gewinner zu ermitteln.
     */
    void spielZug(int x, int y) {

        if (Objects.equals(amZug, "R") && spielEnde != 1 && start == 1) {
            if (spalteR + wuerfelZahl >= y && spalteR - wuerfelZahl <= y) {
                if (zeileR + wuerfelZahl >= x && zeileR - wuerfelZahl <= x) {
                    buttons[zeileR][spalteR].setText("");
                    zeileR = x;
                    spalteR = y;
                    buttons[x][y].setText("R");
                    punkteverteilen();
                    gui.getInformation().setText("Der Drache ist dran!");
                    amZug = "D";
                    gui.getWuerfel().setEnabled(true);
                    start = 0;
                }
            }

            if (zeileR == zeileD && spalteR == spalteD) {
                buttons[zeileD][spalteD].setText("");
                buttons[zeileR][spalteR].setText("");
                buttons[x][y].setText("X");
                spielEnde = 1;

                if (spielstaerkeRD.getSpielstaerkeD() > spielstaerkeRD.getSpielstaerkeR()) {
                    gui.getInformation().setText("Der Drache hat gewonnen!");
                } else if (spielstaerkeRD.getSpielstaerkeD() < spielstaerkeRD.getSpielstaerkeR()) {
                    gui.getInformation().setText("Der Ritter hat gewonnen!");
                } else {
                    gui.getInformation().setText("Unentschieden!");
                }
                gui.getErgebnis().setText("Ergebnis: -");
                passt = false;
            }

        } else if (Objects.equals(amZug, "D") && spielEnde != 1 && start == 1) {
            if (spalteD + wuerfelZahl >= y && spalteD - wuerfelZahl <= y) {
                if (zeileD + wuerfelZahl >= x && zeileD - wuerfelZahl <= x) {
                    buttons[zeileD][spalteD].setText("");
                    zeileD = x;
                    spalteD = y;
                    buttons[x][y].setText("D");
                    punkteverteilen();
                    gui.getInformation().setText("Der Ritter ist dran!");
                    amZug = "R";
                    gui.getWuerfel().setEnabled(true);
                    start = 0;
                }
            }

            if (zeileR == zeileD && spalteR == spalteD) {
                buttons[zeileD][spalteD].setText("");
                buttons[zeileR][spalteR].setText("");
                buttons[x][y].setText("X");
                spielEnde = 1;
                if (spielstaerkeRD.getSpielstaerkeD() > spielstaerkeRD.getSpielstaerkeR()) {
                    gui.getInformation().setText("Der Drache hat gewonnen!");
                } else if (spielstaerkeRD.getSpielstaerkeD() < spielstaerkeRD.getSpielstaerkeR()) {
                    gui.getInformation().setText("Der Ritter hat gewonnen!");
                } else {
                    gui.getInformation().setText("Unentschieden!");
                }
                gui.getErgebnis().setText("Ergebnis: -");
                passt = false;
            }
        }
    }

    /**
     * Hier wird eine Würfelzahl zwischen von 1 bis 3 zufällig erstellt.
     */
    public void wuerfeln() {
        if (spielEnde != 1 ) {
            start = 1;
            gui.getWuerfel().setEnabled(false);
            wuerfelZahl = (int) (Math.random() * 3) + 1;
            gui.getErgebnis().setText("Ergebnis: " + wuerfelZahl);
        }
    }

    /**
     * Überprüft zur Laufzeit des Programmes die Eingabe des Benutzers.
     */
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (e.getSource() == buttons[i][j] && passt) {
                    spielZug(i, j);
                    return;
                }
            }
        }
    }

    /**
     * Hier werden die Punkte der beiden Spieler berechnet.
     */
    void punkteverteilen() {

        int temp;
        for (int i = 0; i < kachelnE.length; i++) {
            for (int j = 0; j < kachelnE[0].length; j++) {
                if (amZug == "D" && i == zeileD && j == spalteD) {
                    if (kachelnE[i][j] == 1) {
                        temp = spielstaerkeRD.getSpielstaerkeD();
                        temp = (temp * 90) / 100;
                        spielstaerkeRD.setSpielstaerkeD(temp);

                    } else if (kachelnE[i][j] == 3) {
                        temp = spielstaerkeRD.getSpielstaerkeD();
                        temp = (temp * 110) / 100;
                        spielstaerkeRD.setSpielstaerkeD(temp);
                    }
                    gui.getInformationD().setText("Spielstärke: " + spielstaerkeRD.getSpielstaerkeD());
                    break;

                } else if (amZug == "R" && i == zeileR && j == spalteR) {

                    if (kachelnE[i][j] == 1) {
                        temp = spielstaerkeRD.getSpielstaerkeR();
                        temp = (temp * 110) / 100;
                        spielstaerkeRD.setSpielstaerkeR(temp);

                    } else if (kachelnE[i][j] == 3) {
                        temp = spielstaerkeRD.getSpielstaerkeR();
                        temp = (temp * 90) / 100;
                        spielstaerkeRD.setSpielstaerkeR(temp);
                    }
                    gui.getInformationR().setText("Spielstärke: " + spielstaerkeRD.getSpielstaerkeR());
                    break;
                }
            }
        }
    }
}


