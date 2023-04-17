public class Fahrradgruppe {

    private Fahrrad startFahrrad = null;
    private int ladungGesamt;

    /**
     * Jedes neu hinzugefügte Fahrrad wird erstmal das Startfahrrad gesetzt
     * und das nächste Fahrrad rückt davor.
     */
    void addFahrrad(Fahrrad f) {
        f.setNext(startFahrrad);
        startFahrrad = f;
    }

    /**
     * Hier durchsuche ich alle Fahrräder, um das langsamste Fahrrad zu ermitteln.
     * Das langsamste Fahrrad gibt an wie viel km/h die Fahrradgruppe fährt.
     */
    int reisegeschwindigkeit() {
        if (startFahrrad == null) {
            System.out.println("Es kann keine Reisegeschwindigkeit ermittelt werden.\nBitte fuegen sie dafuer ein oder mehrere Fahrraeder hinzu.\n");
            return 0;
        } else {

            Fahrrad vergleich = startFahrrad;
            Fahrrad minGeschwindigkeit = startFahrrad;

            while (vergleich.getNext() != null) {
                vergleich = vergleich.getNext();
                if (minGeschwindigkeit.speed() > vergleich.speed()) {
                    minGeschwindigkeit = vergleich;
                }
            }
            int minSpeed = minGeschwindigkeit.speed();
            return minSpeed;
        }
    }

    /**
     * In der Methode ordne ich die Ladungen den Fahrrädern hinzu,
     * um eine maximale Reisegeschwindigkeit zu erreichen.
     */
    void addLadung(int anzahl) {

        if (startFahrrad == null) {
            System.out.println("Es koe/nnen keine Ladungen verteilt werden.\nBitte fuegen sie ein oder mehrere Fahrraeder hinzu.\n");
        } else {
            this.ladungGesamt = this.ladungGesamt + anzahl;

            System.out.println("Ladung: " + ladungGesamt);
            Fahrrad maxSpeedF;

            for (int i = 0; i < ladungGesamt; i++) {

                maxSpeedF = startFahrrad;

                Fahrrad naechstes = startFahrrad;
                while (naechstes.getNext() != null) {
                    naechstes = naechstes.getNext();
                    if (maxSpeedF.speed() < naechstes.speed()) {
                        maxSpeedF = naechstes;
                    }
                }
                maxSpeedF.setLadung(maxSpeedF.getLadung() + 1);
            }
        }
    }
}
